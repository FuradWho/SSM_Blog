package com.spoof.realme;

import com.spoof.domain.Blogger;
import com.spoof.service.BloggerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class BloggerRealm extends AuthorizingRealm {

    @Autowired
    private BloggerService bloggerService;


    /**
     * 为当前登陆的用户授予角色和权限
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 身份认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();
        Blogger blogger = bloggerService.getBloggerByUsername(username);

        if (null != blogger) {

            SecurityUtils.getSubject().getSession().setAttribute("currentUser", blogger);
            return new SimpleAuthenticationInfo(blogger.getUserName(), blogger.getPassword(), "BloggerRealm");
        } else {
            return null;
        }

    }
}
