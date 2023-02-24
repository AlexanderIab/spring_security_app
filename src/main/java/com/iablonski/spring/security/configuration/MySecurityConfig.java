package com.iablonski.spring.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public UserDetailsManager users(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/").hasAnyRole("EMPLOYEE","HR", "MANAGER")
                .requestMatchers("/update-info", "/add-new-employee","/delete-employee").hasRole("HR")
                .requestMatchers("/update-bonus-info").hasRole("MANAGER")
                .anyRequest().authenticated()
                .and().formLogin().permitAll();
        return http.build();
    }
}
