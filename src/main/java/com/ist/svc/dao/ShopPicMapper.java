package com.ist.svc.dao;

import com.ist.svc.domain.ShopPic;
import com.ist.svc.domain.ShopPicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopPicMapper {
    long countByExample(ShopPicExample example);

    int deleteByExample(ShopPicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopPic record);

    int insertSelective(ShopPic record);

    List<ShopPic> selectByExample(ShopPicExample example);

    ShopPic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopPic record, @Param("example") ShopPicExample example);

    int updateByExample(@Param("record") ShopPic record, @Param("example") ShopPicExample example);

    int updateByPrimaryKeySelective(ShopPic record);

    int updateByPrimaryKey(ShopPic record);
}