package com.admin.security;

import com.webmagic.model.User;
import com.webmagic.mymapper.UserMyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * spring security 提供获取用户信息的service，主要给security提供验证用户的信息
 */
@Service("userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UserMyMapper userMapper;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = new User();
        user.setUsername(userName);
        User userInfo = userMapper.selectOne(user);
        if (userInfo == null) {
            throw new UsernameNotFoundException("找不到该账户信息!");
        }
        
        // GrantedAuthority 是 security提供的权限类
        List<GrantedAuthority> list = new ArrayList<>();
        getRoles(user, list); // 获取角色，放到list里面
        org.springframework.security.core.userdetails.User auth_user = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), list);
        return auth_user;
    }
    
    /**
     * 获取所属角色
     * @param user
     */
    public void getRoles(User user, List<GrantedAuthority> list) {
        for (String role : user.getRoles().split(",")) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
    }
    
}
