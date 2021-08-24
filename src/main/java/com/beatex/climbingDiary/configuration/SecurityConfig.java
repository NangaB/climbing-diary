package com.beatex.climbingDiary.configuration;

import com.beatex.climbingDiary.model.Role;
import com.beatex.climbingDiary.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("buzz")
//                    .password("aa")
//                    .authorities("ROLE_USER")
//                .and()
//                .withUser("wood")
//                    .password("bb")
//                    .authorities("ROLE_USER");
//    }


//    @Autowired
//    DataSource dataSource;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery(
//                        "select username, password, enabled from Users " + "where username=?")
//                .authoritiesByUsernameQuery(
//                        "select username, authority from UserAuthoriteis " + "where username=?")
//                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
//    }

//    @Qualifier("userRepositoryUserDetailService")
//    @Autowired
//    UserDetailsService userDetailsService;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailsService) //info że to customerDetailService dostarcza info o userach
                .passwordEncoder(getEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/addRout", "/delete").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin().defaultSuccessUrl("/hello") // to się wyświetla po zalogowaniu
                .failureForwardUrl("/login");
    }

    @Bean
    public PasswordEncoder getEncoder(){
            return new BCryptPasswordEncoder();
    }


}
