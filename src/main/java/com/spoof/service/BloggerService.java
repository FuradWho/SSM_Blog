package com.spoof.service;

import com.spoof.domain.Blogger;

/**
 * 用户相关的一些操作 包含
 *
 *
 * @author 13375
 */
public interface BloggerService {
    boolean loginCheck(String username , String password);

    String getBloggerEmail();

    Blogger getLoginInfo();

    Blogger getBloggerByUsername(String username);

    Blogger getBloggerInfo();



}
