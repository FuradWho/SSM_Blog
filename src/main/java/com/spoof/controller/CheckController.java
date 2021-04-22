package com.spoof.controller;


import com.spoof.domain.Blogger;
import com.spoof.service.BloggerService;
import com.spoof.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/back")
public class CheckController {

    @Autowired
    private BloggerService bloggerService;

    @RequestMapping(value = "/bloggerLogin.do", method = RequestMethod.GET)
    public String login(HttpServletRequest httpServletRequest) {
        return "/back/login";
    }

    @RequestMapping("/checkLogin")
    @ResponseBody
    public boolean login(@RequestBody Blogger blogger) {

        Subject subject = SecurityUtils.getSubject();

        String saltPassword = MD5Util.md5(blogger.getPassword(), "admin");

        UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUserName(), blogger.getPassword());

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

}
