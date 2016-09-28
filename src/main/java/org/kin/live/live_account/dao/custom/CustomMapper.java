package org.kin.live.live_account.dao.custom;

import org.kin.live.live_account.pojo.SimpleUser;

import java.util.List;

/**
 * Created by kingsir on 16-9-27.
 */
public interface CustomMapper {

    public List<SimpleUser> selectSimpleUserByGroups(String groupId);
}
