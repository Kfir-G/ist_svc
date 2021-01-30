package com.ist.svc.dao;

import com.ist.svc.domain.InfoPublicKey;
import com.ist.svc.domain.InfoPublicKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface InfoPublicKeyMapper {
    long countByExample(InfoPublicKeyExample example);

    int deleteByExample(InfoPublicKeyExample example);

    int insert(InfoPublicKey record);

    int insertSelective(InfoPublicKey record);

    List<InfoPublicKey> selectByExample(InfoPublicKeyExample example);

    int updateByExampleSelective(@Param("record") InfoPublicKey record, @Param("example") InfoPublicKeyExample example);

    int updateByExample(@Param("record") InfoPublicKey record, @Param("example") InfoPublicKeyExample example);
    @Select("select `value` from card.info_public_key where `key`=#{key, jdbcType=VARCHAR} limit 1;")
    String selectValueByPublicKey(@Param(value = "key") String key);
}