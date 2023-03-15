//package com.aaa.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    注入自定义的实现类
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(password());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()  //定义登录页面
//                .loginPage("/index.html") //登录页面设置
//                .loginProcessingUrl("/user/login")  //访问路径
//                .defaultSuccessUrl("/user/dashboard") //登录成功路径
//                .and().authorizeRequests()
//                .antMatchers("/","/user/login","/").permitAll()
//                .anyRequest().authenticated()
//                .and().csrf().disable();
//    }
//
//    /**
//     * 密码加密
//     * @return
//     */
//    @Bean
//    PasswordEncoder password() {
//        return new BCryptPasswordEncoder();
//    }
//}
