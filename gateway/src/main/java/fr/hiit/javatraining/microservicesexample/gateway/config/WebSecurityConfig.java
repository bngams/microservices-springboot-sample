package fr.hiit.javatraining.microservicesexample.gateway.config;


import fr.hiit.javatraining.microservicesexample.gateway.config.jwt.JWTRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JWTRequestFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // we dont use csrf
                .csrf().disable()
                // we will use a stateless session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // add a filter to validate the tokens with every request
                // put after  UsernamePasswordAuthenticationFilter to avoid exception in filters chaining
                .addFilterAfter(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                // allow access to authentication routes
                .antMatchers(HttpMethod.POST, "/auth/**").permitAll()
                .antMatchers(HttpMethod.GET, "/gallery/admin").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/gallery/**").authenticated()
                // other requests must be auth
                .anyRequest().authenticated().and()
                // if not authenticated  => unauthorized
                .exceptionHandling().accessDeniedHandler((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED));
    }
}
