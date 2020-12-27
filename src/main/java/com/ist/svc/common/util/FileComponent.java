package com.ist.svc.common.util;

import com.ist.svc.common.CodeConstant;
import com.ist.svc.common.pojo.FileDTO;
import com.ist.svc.config.IstConfig;
import com.ist.svc.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class FileComponent extends BaseServiceImpl {

    @Autowired
    private IstConfig istConfig;

    /*
    文件上传流程：
        上传时：存在临时文件夹，启用一个临时的文件名，防止文件冲突，返回文件的相对文件路径信息
        实际存储信息时：移动文件到正式文件夹，修改文件名，删除源文件，返回文件的相对文件路径信息
     */

    public FileDTO fileUpload(MultipartFile file) {

        // 获取文件名
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || "".equals(originalFilename)) {
            return null;
        }

        //从配置文件获取临时目录路径
        String tempPath = istConfig.getUploadPathTemp();

        //生成新文件名，防止和其他文件冲突

        File dest = this.getTargetFile(tempPath, originalFilename);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            log.info("[FILE] 不存在该文件夹，创建="+dest.getParent());
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // 封装返回信息
        FileDTO fileDTO =new FileDTO();
        fileDTO.setAbsolutePath(dest.getAbsolutePath());
        fileDTO.setRelativePath(dest.getAbsolutePath().substring(tempPath.length()));
        fileDTO.setFilename(dest.getName());
        fileDTO.setOriginalFilename(originalFilename);
        fileDTO.setUrl(this.getUrl(fileDTO.getAbsolutePath().substring(istConfig.getUploadPathBak().length())));
        return fileDTO;
    }

    // 获取临时文件的文件名信息
    private File getTargetFile(String path, String sourceFilename){
        File targetFile = null;

        // 修改文件名，加上时间戳
        do {
//            String prefix = sourceFilename.substring(0, sourceFilename.lastIndexOf("."));
            String suffix = sourceFilename.substring(sourceFilename.lastIndexOf("."));
            targetFile = new File(this.getPath(Arrays.asList(path, getItemId(3)+"_"+getItemId(6)+suffix)));
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (targetFile.exists());

        return targetFile;
    }

    // 移动文件，并删除旧文件
    private FileDTO fileMove(String relativePath, String destDirPath){
        String tempPath = istConfig.getUploadPathTemp();
        String bakPath = istConfig.getUploadPathBak();

        File source = new File(this.getPath(Arrays.asList(tempPath, relativePath)));
        File dest = new File(this.getPath(Arrays.asList(bakPath, destDirPath, relativePath)));

        // 检测是否存在目录
        if ( ! dest.getParentFile().exists()) {
            log.info("[FILE] 不存在该文件夹，创建="+dest.getParent());
            dest.getParentFile().mkdirs();
        }

        try {
            FileUtils.copyFile(source, dest);
        } catch (IOException e) {
            log.error("[FILE] 文件拷贝失败，relativePath="+relativePath+", e="+e.getMessage());
            e.printStackTrace();
        }

        // 删除旧文件
        if ( ! source.delete()) {
            log.error("[FILE] 原文件删除失败，relativePath="+relativePath);
        }

        FileDTO fileDTO = new FileDTO();
        fileDTO.setUrl(null);
        fileDTO.setAbsolutePath(dest.getAbsolutePath());
        fileDTO.setRelativePath(this.getPath(Arrays.asList(destDirPath, relativePath)));
        fileDTO.setFilename(dest.getName());
        return fileDTO;
    }

    // 新建时，移动文件，返回url路径入库
    public String getMultiUrlStr(String multiUrls, String destDirPath){
        if (StringUtils.isBlank(multiUrls)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] urls = multiUrls.split(",");
        for (String tempUrl : urls) {
            String filename = this.fileMove(tempUrl, destDirPath).getRelativePath();
            stringBuilder.append(filename).append(",");
        }
        String result = stringBuilder.toString();
        if (result.endsWith(",")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    private String getPath(List<String> paths){
        StringBuilder result = new StringBuilder();
        for (String temp : paths) {
            if (temp.length() > 1 && temp.endsWith(File.separator)) {
                temp = temp.substring(0, temp.length() - 1);
            }

            if ( ! temp.startsWith(File.separator)) {
                result.append(File.separator).append(temp);
            } else {
                result.append(temp);
            }
        }
        return result.toString();
    }

    // 根据附件url信息，组装list信息
    public List<FileDTO> getFileDTOList(String urls) {
        if (StringUtils.isBlank(urls)) {
            return new ArrayList<>();
        }

        List<FileDTO> result = new ArrayList<>();
        String[] urlArr = urls.split(",");

        String url = null;
        for (String tempUrl : urlArr) {
            if (StringUtils.isNotBlank(tempUrl)) {

                FileDTO tempFileDTO = new FileDTO();
                tempFileDTO.setUrl(this.getUrl(tempUrl));
                tempFileDTO.setAbsolutePath(this.getPath(Arrays.asList(istConfig.getUploadPathBak(), tempUrl)));
                tempFileDTO.setRelativePath(tempUrl);
                tempFileDTO.setFilename(tempUrl.substring(tempUrl.lastIndexOf(File.separator) + 1));

                result.add(tempFileDTO);
            }
        }
        return result;
    }

    private String getUrl(String tempUrl){
        String url = "";
        if (istConfig.getSpringProfilesActive().startsWith("pro")) {
            url = "http://"+istConfig.getNginxPublicUri()+ CodeConstant.Path.IST_IMAGE+tempUrl;
        } else if (istConfig.getSpringProfilesActive().startsWith("dev")) {
            url = "http://"+istConfig.getNginxPublicUri()+CodeConstant.Path.IST_IMAGE+tempUrl;
        } else {
            url = "http://localhost:"+istConfig.getServerPort()+CodeConstant.Path.IST_IMAGE+tempUrl;
        }
        return url;
    }
}
