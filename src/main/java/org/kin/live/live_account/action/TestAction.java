package org.kin.live.live_account.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kingsir on 16-9-8.
 */
@Controller
public class TestAction {

    @RequestMapping(value = {"index",""})
    public String index(){
        return "redirect:/index2";
    }

    @RequestMapping(value = "index2")
    public String index2(){
        return "index";
    }
}
