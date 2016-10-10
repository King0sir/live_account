package org.kin.live.live_account.action;

import org.kin.live.live_account.dao.TransExtMapper;
import org.kin.live.live_account.dao.TransMapper;
import org.kin.live.live_account.domain.Trans;
import org.kin.live.live_account.domain.TransExt;
import org.kin.live.live_account.domain.User;
import org.kin.live.live_account.except.BaseException;
import org.kin.live.live_account.pojo.HisTrans;
import org.kin.live.live_account.pojo.PageTool;
import org.kin.live.live_account.service.DomainService;
import org.kin.live.live_account.service.ValidateService;
import org.kin.live.live_account.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by kingsir on 16-9-26.
 */
@Controller
@RequestMapping("/trans")
public class TransAction {

    @Resource
    private ValidateService validateService;
    @Resource
    private DomainService domainService;

    @Resource
    private TransMapper transMapper;
    @Resource
    private TransExtMapper transExtMapper;

    @RequestMapping("/newTrans")
    public String newTrans(HttpServletRequest request) throws BaseException{
        validateService.transParamsValidate(request);

        this.saveTrans(request);

        return "user/finish";
    }

    @RequestMapping("/history")
    public String history(HttpServletRequest request,String userId) throws BaseException{
        System.out.println(userId);
        User user = domainService.getUserById(userId);

        PageTool pageTool = new PageTool();
        List<HisTrans> hisTransList = domainService.getTransOfOnePage(userId,pageTool);

        request.setAttribute("user",user);
        request.setAttribute("hisTransList",hisTransList);
        request.setAttribute("pageTool",pageTool);
        return "trans/history";
    }

    private void saveTrans(HttpServletRequest request){
        try {
            String payTimeStr = request.getParameter("payTime");
            String transAmtStr = request.getParameter("transAmt");
            String payerId = request.getParameter("payer");
            String shares = request.getParameter("shares");
            String memo = request.getParameter("memo");
            String groupId = request.getParameter("groupId");

            Date payTime = DateUtil.getDate(payTimeStr,DateUtil.DATE_FORMAT_SHORT);
            BigDecimal transAmt = new BigDecimal(transAmtStr).multiply(new BigDecimal(100));
            String[] shareArray = shares.split(",");

            Trans trans = new Trans();
            trans.setDivideTo(shareArray.length);
            trans.setGroupId(groupId);
            trans.setMemo(memo);
            trans.setPayerId(payerId);
            trans.setPayTime(payTime);
            trans.setPerAmt(transAmt.divide(new BigDecimal(shareArray.length),2, RoundingMode.HALF_UP));
            trans.setTransAmt(transAmt);
            transMapper.insertSelective(trans);

            for(String share : shareArray){
                TransExt ext = new TransExt();
                ext.setGroupId(groupId);
                ext.setTransId(trans.getId());
                ext.setUserId(share);
                transExtMapper.insertSelective(ext);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
