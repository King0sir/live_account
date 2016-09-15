package org.kin.live.live_account.action;

import org.kin.live.live_account.dao.UserMapper;
import org.kin.live.live_account.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Created by kingsir on 16-9-8.
 */
@Controller
@RequestMapping("/test")
public class TestAction {

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = {"index",""})
    public String index(){
//        return "redirect:/test/index2";
        return "index";
    }

    @RequestMapping(value = "index2")
    public String index2(){
        User user = new User();
        user.setCreateTime(new Date());
        user.setEmail("kinminghao.king.sir@gmail.com");
        user.setEnable(1);
        user.setId(UUID.randomUUID().toString().substring(0,13));
        user.setNickName("kin");
        user.setPasswd("paass");
        user.setPhone("18941651359");
        user.setWxNo(470147789);
        userMapper.insertSelective(user);

        return "index";
    }
}
