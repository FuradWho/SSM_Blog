package com.spoof.service.Impl;

import com.spoof.dao.BloggerDao;
import com.spoof.domain.Blogger;
import com.spoof.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author 13375
 */
@Service("BloggerService")
public class BloggerServiceImpl implements BloggerService {

    @Autowired
    private BloggerDao bloggerDao;

    @Override
    public boolean loginCheck(String username, String password) {

        Blogger blogger = bloggerDao.getBloggerInfo();
        System.out.println("service" + blogger.getUserName());
        if (username.equals(blogger.getUserName()) && password.equals(blogger.getPassword())) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String getBloggerEmail() {
        return null;
    }

    @Override
    public Blogger getLoginInfo() {

        Blogger blogger = bloggerDao.getBloggerInfo();
        System.out.println("service" + blogger.getUserName());

        return blogger;
    }

    @Override
    public Blogger getBloggerByUsername(String username) {
        return null;
    }

    @Override
    public Blogger getBloggerInfo() {

        System.out.println("进入");
        Blogger blogger = bloggerDao.getBloggerInfo();
        return blogger;
    }
}
