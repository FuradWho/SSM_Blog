package com.spoof.controller;


import com.spoof.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private BloggerService bloggerService;

    @RequestMapping("/index.do")
    public String index(HttpServletRequest httpServletRequest) throws Exception{

        System.out.println("1");

            return null;
    }


}
