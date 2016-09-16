package org.kin.live.live_account.action;

import org.kin.live.live_account.dao.UserMapper;
import org.kin.live.live_account.domain.User;
import org.kin.live.live_account.domain.UserExample;
import org.kin.live.live_account.util.PassUtil;
import org.kin.live.live_account.util.SeriaNumberUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * Created by kingsir on 16-9-16.
 */
@Controller
public class RegisterAction {

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/register")
    public String register(HttpServletRequest request){

        if(!checkPass(request))return "密码验证失败";
        if(!checkPhone(request))return "手机号重复";
        if(!checkEmail(request))return "邮箱重复";

        User user = this.getUser(request);

        userMapper.insertSelective(user);

        return "redirect:index";
    }

    private boolean checkPhone(HttpServletRequest request){
        String phone = request.getParameter("phone");

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);

        List<User> userList = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList)){
            return false;
        }
        return true;
    }

    private boolean checkPass(HttpServletRequest request){
        String pass = request.getParameter("rPassword");
        String checkPass = request.getParameter("rCheckPassword");
        if(StringUtils.isEmpty(pass)){
            return false;
        }
        if(StringUtils.isEmpty(checkPass)){
            return false;
        }
        if(pass.equals(checkPass)){
            return true;
        }
        return false;
    }

    private boolean checkEmail(HttpServletRequest request){
        String email= request.getParameter("email");

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);

        List<User> userList = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList)){
            return false;
        }
        return true;
    }

    private User getUser(HttpServletRequest request){
        try {
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String nickName = request.getParameter("nickName");
            String pass = request.getParameter("rPassword");
            nickName = new String(nickName.getBytes("8859_1"),"utf8");

            String userId = SeriaNumberUtil.getSerialNumberByTimeUUID(18);
            String realPass = PassUtil.getPass(userId,pass);

            User user = new User();
            user.setEmail(email);
            user.setCreateTime(new Date());
            user.setEnable(1);
            user.setId(userId);
            user.setNickName(nickName);
            user.setPasswd(realPass);
            user.setPhone(phone);

            return user;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new User();
    }

}
