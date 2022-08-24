package com.smf.wqphd.controller;


import com.smf.wqphd.bean.ResMsg;
import com.smf.wqphd.bean.Root_user;
import com.smf.wqphd.constant.Const;
import com.smf.wqphd.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class RootController {
    @Autowired
    public RootService service;

    @Autowired
    public HttpSession session;

    @RequestMapping("/changePass")
    @ResponseBody
    public ResMsg changePass(String oldpassword, String repassword){
        ResMsg msg=new ResMsg();
//        System.out.println(oldpassword+" "+repassword);
        String name= (String) session.getAttribute("SESSION_KEY_USERNAME");
//        System.out.println("name:"+name);
        Root_user user=service.selectByName(name);

        if(user.getU_Password().equals(oldpassword)){
            boolean jud=service.updateByName(name,repassword);
            msg.setErrcode("0");
            msg.setErrmsg("修改密码成功");
            session.removeAttribute(Const.SESSION_KEY_USER);
            session.removeAttribute(Const.SESSION_KEY_USERNAME);
            //System.out.println(jud);
        }else{
            msg.setErrcode("1");
            msg.setErrmsg("原密码错误");
        }
        return msg;
    }
}
