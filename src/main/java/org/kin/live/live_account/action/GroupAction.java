package org.kin.live.live_account.action;

import org.kin.live.live_account.dao.GroupMapper;
import org.kin.live.live_account.domain.Group;
import org.kin.live.live_account.domain.User;
import org.kin.live.live_account.except.BaseException;
import org.kin.live.live_account.pojo.PageResult;
import org.kin.live.live_account.service.ValidateService;
import org.kin.live.live_account.util.SeriaNumberUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by kingsir on 16-9-25.
 */
@Controller
@RequestMapping("/group")
public class GroupAction {

    @Resource
    private ValidateService validateService;

    @Resource
    private GroupMapper groupMapper;

    @RequestMapping("/create")
    public PageResult createGroup(HttpServletRequest request, String userId, String groupName){
        try {
            validateService.validateUserId(userId);
            Group group = this.getUser(userId,groupName);
            groupMapper.insertSelective(group);
            return PageResult.getSuccess();
        } catch (BaseException e) {
            e.printStackTrace();
            return PageResult.getFail(e.getMessage());
        }
    }

    private Group getUser(String userId,String groupName){
        String groupId = SeriaNumberUtil.getSerialNumberByTimeUUID(16);

        Group group = new Group();
        group.setId(groupId);
        group.setEnable(1);
        group.setName(groupName);
        group.setCreateTime(new Date());
        group.setUserId(userId);

        return group;
    }
}
