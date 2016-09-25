package org.kin.live.live_account.action;

import org.kin.live.live_account.dao.GroupMapper;
import org.kin.live.live_account.pojo.PageResult;
import org.kin.live.live_account.util.SeriaNumberUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by kingsir on 16-9-25.
 */
@Controller
@RequestMapping("/group")
public class GroupAction {

    @Resource
    private GroupMapper groupMapper;

    @RequestMapping("/create")
    public PageResult createGroup(HttpServletRequest request, String userId, String groupName){
        String groupId = SeriaNumberUtil.getSerialNumberByTimeUUID(16);


        return PageResult.getSuccess();
    }
}
