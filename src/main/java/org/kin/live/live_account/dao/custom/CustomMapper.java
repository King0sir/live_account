package org.kin.live.live_account.dao.custom;

import org.kin.live.live_account.domain.Groups;
import org.kin.live.live_account.pojo.HisTrans;
import org.kin.live.live_account.pojo.SimpleUser;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by kingsir on 16-9-27.
 */
public interface CustomMapper {

    public List<SimpleUser> selectSimpleUserByGroups(String groupId);

    public BigDecimal getTotalAmt(String userId);

    public Integer hisTransCount(Map map);

    public List<HisTrans> hisTrans(Map map);

    public Integer searchGroupsCount(Map map);

    public List<Groups> searchGroups(Map map);
}
