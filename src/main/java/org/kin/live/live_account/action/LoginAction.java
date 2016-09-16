package org.kin.live.live_account.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kingsir on 16-9-16.
 */
@Controller
public class LoginAction {

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        System.out.println("user:"+user+" pass:"+password);
        return "redirect:/index";
    }

}
