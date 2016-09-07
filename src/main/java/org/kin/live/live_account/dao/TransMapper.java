package org.kin.live.live_account.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.kin.live.live_account.domain.Trans;
import org.kin.live.live_account.domain.TransExample;

public interface TransMapper {
    int countByExample(TransExample example);

    int deleteByExample(TransExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Trans record);

    int insertSelective(Trans record);

    List<Trans> selectByExample(TransExample example);

    Trans selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Trans record, @Param("example") TransExample example);

    int updateByExample(@Param("record") Trans record, @Param("example") TransExample example);

    int updateByPrimaryKeySelective(Trans record);

    int updateByPrimaryKey(Trans record);
}