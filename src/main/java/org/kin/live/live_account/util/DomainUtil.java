package org.kin.live.live_account.util;

import org.kin.live.live_account.domain.Groups;

import java.util.Date;

/**
 * Created by kingsir on 16-9-26.
 */
public class DomainUtil {

    public static Groups getGroups(String userId, String groupName){
        String groupId = SeriaNumberUtil.getSerialNumberByTimeUUID(16);

        Groups group = new Groups();
        group.setId(groupId);
        group.setEnable(1);
        group.setName(groupName);
        group.setCreateTime(new Date());
        group.setUserId(userId);

        return group;
    }
}
