package org.kin.live.live_account.action;

import org.kin.live.live_account.domain.Groups;
import org.kin.live.live_account.domain.User;
import org.kin.live.live_account.except.BaseException;
import org.kin.live.live_account.service.DomainService;
import org.kin.live.live_account.util.PassUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

        request.setAttribute("group",groups);
        request.setAttribute("user",user);
        return "user/admin";
    }


}
