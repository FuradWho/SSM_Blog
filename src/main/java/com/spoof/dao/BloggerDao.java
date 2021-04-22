package com.spoof.dao;

import com.spoof.domain.Blogger;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;


/**
 * @author 13375
 */
@Repository
public interface BloggerDao {

    Blogger getLoginInfo();

    String getBloggerEmail();

    Blogger getBloggerByUsername(String username);

    Blogger getBloggerInfo();

    void updateBloggerInfo(Blogger blogger);

}
