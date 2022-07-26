package com.myapp.mywebapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("Aliyan")
                .password("$2a$10$zEA51gGtE4lI4BGVmW2A/.7l2.X4TGqmQaBcGaRzV4UTUSuLJTor6")
                .roles("User").and().withUser("Admin")
                .password("$2a$10$JZaeIL5o0uz6E870D.p5bucFWnjXfs/nGPTEbF6Fxw3K9O5AnrKe2")
                .roles("Admin");
    }


    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/users").permitAll()
                .antMatchers("/users/new").hasRole("User").anyRequest().authenticated().and().httpBasic()
                .and().exceptionHandling().accessDeniedPage("/403");
    }
}
