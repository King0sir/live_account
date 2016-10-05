package org.kin.live.live_account.action;

import org.kin.live.live_account.domain.Groups;
import org.kin.live.live_account.domain.User;
import org.kin.live.live_account.except.BaseException;
import org.kin.live.live_account.pojo.SimpleUser;
import org.kin.live.live_account.service.DomainService;
import org.kin.live.live_account.util.PassUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by kingsir on 16-9-16.
 */
@Controller
public class LoginAction {

    @Resource
    private DomainService domainService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request) throws BaseException {
        String userStr = request.getParameter("user");
        String password = request.getParameter("password");
        User user =domainService.getUser(userStr);
        if(user == null){
            return "没有对应的帐户";
        }
        String realPass = PassUtil.getPass(user.getId(),password);
        if(!user.getPasswd().equals(realPass)){
            return "密码错误";
        }

        Groups groups = domainService.queryGroupsByUserId(user.getId());

        List<SimpleUser> simpleUserList = this.getOptionList(groups.getId());

        request.setAttribute("simpleUserList",simpleUserList);
        request.setAttribute("group",groups);
        request.setAttribute("user",user);
        return "user/admin";
    }

    private List<SimpleUser> getOptionList(String groupId){
        List<SimpleUser> userList = domainService.getUserList(groupId);
        userList.add(new SimpleUser("123","123"));
        userList.add(new SimpleUser("234","234"));
        return userList;
    }
}
