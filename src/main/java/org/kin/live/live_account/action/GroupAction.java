package org.kin.live.live_account.action;

import org.kin.live.live_account.dao.GroupsMapper;
import org.kin.live.live_account.domain.Groups;
import org.kin.live.live_account.domain.User;
import org.kin.live.live_account.except.BaseException;
import org.kin.live.live_account.pojo.PageResult;
import org.kin.live.live_account.service.DomainService;
import org.kin.live.live_account.service.ValidateService;
import org.kin.live.live_account.util.DomainUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by kingsir on 16-9-25.
 */
@Controller
@RequestMapping("/group")
public class GroupAction {

    @Resource
    private ValidateService validateService;
    @Resource
    private DomainService domainService;

    @Resource
    private GroupsMapper groupsMapper;

    @ResponseBody
    @RequestMapping("/create")
    public PageResult createGroup(HttpServletRequest request, String userId, String groupName){
        try {
            validateService.validateUserId(userId);
            validateService.validateGroupName(groupName);
            Groups groups = DomainUtil.getGroups(userId,groupName);
            groupsMapper.insertSelective(groups);
            return PageResult.getSuccess();
        } catch (BaseException e) {
            e.printStackTrace();
            return PageResult.getFail(e);
        }
    }

    @RequestMapping("/search")
    public String searchGroup(HttpServletRequest request){
        return "group/search";
    }

    @RequestMapping("/member")
    public String queryMember(HttpServletRequest request,String groupId) throws BaseException {
        System.out.println(groupId);
        String groupName = domainService.queryGroupNameById(groupId);
        List<User> userList = domainService.getUserFromGroupName(groupName);

        request.setAttribute("userList",userList);
        request.setAttribute("groupName",groupName);
        return "group/member";
    }
}
