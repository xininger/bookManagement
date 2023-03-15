//package com.aaa.service.impl;
//
//import com.aaa.domain.User;
//import com.aaa.mapper.UserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        调用usermapper方法，条件构造器
////        QueryWrapper<User> wrapper = new QueryWrapper<>();
////        wrapper.eq("username",username);
////        User user = userMapper.selectOne(wrapper);
//        User user = userMapper.findUserByName(username);
////        判断
//        if (user == null) {
//            //认证失败
//            throw new UsernameNotFoundException("用户不存在！");
//        }
//        String role = Integer.toString(user.getRole());
//        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
//        return new org.springframework.security.core.userdetails.User(user.getUsername(),new BCryptPasswordEncoder().encode(user.getPassword()),auth);
//    }
//}
