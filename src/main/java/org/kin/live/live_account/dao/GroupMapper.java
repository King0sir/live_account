package org.kin.live.live_account.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.kin.live.live_account.domain.Group;
import org.kin.live.live_account.domain.GroupExample;

public interface GroupMapper {
    int countByExample(GroupExample example);

    int deleteByExample(GroupExample example);

    int deleteByPrimaryKey(String id);

    int insert(Group record);

    int insertSelective(Group record);

    List<Group> selectByExample(GroupExample example);

    Group selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByPrimaryKeySelective(Group record);

    int updateByPrimaryKey(Group record);
}