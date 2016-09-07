package org.kin.live.live_account.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.kin.live.live_account.domain.TransExt;
import org.kin.live.live_account.domain.TransExtExample;

public interface TransExtMapper {
    int countByExample(TransExtExample example);

    int deleteByExample(TransExtExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TransExt record);

    int insertSelective(TransExt record);

    List<TransExt> selectByExample(TransExtExample example);

    TransExt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TransExt record, @Param("example") TransExtExample example);

    int updateByExample(@Param("record") TransExt record, @Param("example") TransExtExample example);

    int updateByPrimaryKeySelective(TransExt record);

    int updateByPrimaryKey(TransExt record);
}