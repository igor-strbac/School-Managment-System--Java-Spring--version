package com.example.dnevnikjartest.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    public SecurityConfiguration(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String korisniciQuery;

    @Value("${spring.queries.roles-query}")
    private String ulogeQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().usersByUsernameQuery(korisniciQuery).authoritiesByUsernameQuery(ulogeQuery)
                .passwordEncoder(bCryptPasswordEncoder).dataSource(dataSource);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/roditelj/**").hasAuthority("roditelj")
                .antMatchers("/admin/**").hasAuthority("admin")
                .antMatchers("/ucitelj/**").hasAuthority("ucitelj")
                .antMatchers("/direktor/**").hasAuthority("direktor")
                .anyRequest()
                .authenticated().and().csrf().disable().formLogin().loginPage("/login").failureUrl("/login?error=true")
                .successHandler(authenticationSuccessHandler)
                .usernameParameter("username")
                .passwordParameter("password").and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }

    // .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**",
    // "/images/**");
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");

    }

}
