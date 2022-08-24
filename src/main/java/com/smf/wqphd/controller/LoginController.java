package com.smf.wqphd.controller;

import com.smf.wqphd.bean.ResMsg;
import com.smf.wqphd.bean.Root_user;
import com.smf.wqphd.constant.Const;
import com.smf.wqphd.service.RootService;
import com.smf.wqphd.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    public HttpSession session;

    @Autowired
    public RootService service;

    @RequestMapping("/test")
    public void test(){
        System.out.println(service.selectAll());
    }

    @RequestMapping("/signin")
    @ResponseBody
    public ResMsg login(LoginVo vo, HttpServletRequest request,
                        HttpServletResponse response){
        System.out.println(vo);
        ResMsg msg=new ResMsg();
        String validate=(String)session.getAttribute("rand");
        System.out.println(validate);
        if(vo.getValidate()==null || !validate.equalsIgnoreCase(vo.getValidate())){
            msg.setErrcode("4");
            msg.setErrmsg("验证码错误");
            System.out.println("验证码错误");
        }else if(vo.getUsername()!=null && vo.getUsername()!=null){
            Root_user root=service.selectByName(vo.getUsername());
            System.out.println("root:"+root);
            if(root==null){
                msg.setErrcode("2");
                msg.setErrmsg("用户不存在");
            }
                else if(vo.getUsername().equals(root.getU_Name()) && vo.getPassword().equals(root.getU_Password())){
                    msg.setErrcode("0");
                    msg.setErrmsg("登录成功");
                   // session.setAttribute("username",root.getU_Name());
                Cookie cookie = new Cookie("loginUser",vo.getUsername());
                cookie.setPath("/");
                response.addCookie(cookie);
                session.setAttribute(Const.SESSION_KEY_USER,root);
                session.setAttribute(Const.SESSION_KEY_USERNAME,root.getU_Name());
//                System.out.println(session.getAttribute(Const.SESSION_KEY_USERNAME));
                }else{
                    msg.setErrcode("1");
                    msg.setErrmsg("用户名或密码错误");
                }

        }
//        System.out.println(vo);
//        System.out.println(session.getAttribute("rand"));
        return msg;
    }


    /**
     * 退出/注销功能
     *
     * @return
     */
    @RequestMapping(value = "/logout")
    public String logout() {
        session.removeAttribute(Const.SESSION_KEY_USER);
        session.removeAttribute(Const.SESSION_KEY_USERNAME);
      return "login";
    }

}
