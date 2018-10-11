package cn.smallc.footballLottery.shiro;

import cn.smallc.footballLottery.support.SharedRepositoryFactory;
import cn.smallc.footballLottery.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author smallC
 * @Date 2018/10/9
 * @Description
 */

@Component
public class CustomRealm extends AuthorizingRealm {


    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null || !JWTUtil.verify(token, username)) {
            throw new AuthenticationException("token认证失败！");
        }
        String password = SharedRepositoryFactory.getUserRepository().getPasswordByUsername(username);
        if (password == null) {
            throw new AuthenticationException("该用户不存在！");
        }
//        int ban = userMapper.checkUserBanStatus(username);
//        if (ban == 1) {
//            throw new AuthenticationException("该用户已被封号！");
//        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        String roleName = SharedRepositoryFactory.getRoleRepository().getRoleNameByUsername(username);
        Set<String> RoleSet = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        RoleSet.add(roleName);
        //设置该用户拥有的角色
        info.setRoles(RoleSet);
        return info;
    }

}
