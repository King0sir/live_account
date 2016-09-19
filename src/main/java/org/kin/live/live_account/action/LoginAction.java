package org.kin.live.live_account.action;

import org.kin.live.live_account.dao.UserMapper;
import org.kin.live.live_account.domain.User;
import org.kin.live.live_account.domain.UserExample;
import org.kin.live.live_account.util.PassUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
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
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String userStr = request.getParameter("user");
        String password = request.getParameter("password");
        User user = this.getUser(userStr);
        if(user == null){
            return "没有对应的帐户";
        }
        String realPass = PassUtil.getPass(user.getId(),password);
        if(!user.getPasswd().equals(realPass)){
            return "密码错误";
        }

        request.setAttribute("user",user);
        return "user/admin";
    }

    private User getUser(String user){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(user.contains("@")){
            criteria.andEmailEqualTo(user);
        }else {
            try {
                Integer.parseInt(user);
                criteria.andPhoneEqualTo(user);
            }catch (Exception e){}
        }
        List<User> userList = userMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userList)){
            if(userList.size() == 1){
                return userList.get(0);
            }else {
                return null;
            }
        }
        return null;
    }
}
