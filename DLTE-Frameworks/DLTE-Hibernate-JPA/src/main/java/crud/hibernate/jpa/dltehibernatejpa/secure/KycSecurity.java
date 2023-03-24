package crud.hibernate.jpa.dltehibernatejpa.secure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class KycSecurity {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails userDetails1= User.withDefaultPasswordEncoder().username("kirtan").password("acharya").roles("admin").build();
        UserDetails userDetails2= User.withDefaultPasswordEncoder().username("karthik").password("break").roles("manager").build();
        List<UserDetails> userDetailsList= Stream.of(userDetails1,userDetails2).collect(Collectors.toList());
        return new InMemoryUserDetailsManager(userDetailsList);
    }

    @Bean
    public RoleHierarchy roleHierarchy(){
        //String roleRule="admin>manager\nmanager>developers";
        String roleRule="admin>manager";
        RoleHierarchyImpl roleHierarchy=new RoleHierarchyImpl();
        roleHierarchy.setHierarchy(roleRule);
        return roleHierarchy;
    }

    @Bean
    public DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler(){
        DefaultWebSecurityExpressionHandler web=new DefaultWebSecurityExpressionHandler();
        web.setRoleHierarchy(roleHierarchy());
        return web;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //httpSecurity.authorizeRequests().anyRequest().authenticated();
        httpSecurity.httpBasic();
        httpSecurity.csrf().disable();
        httpSecurity.formLogin();

        httpSecurity.authorizeRequests().expressionHandler(defaultWebSecurityExpressionHandler()).
                antMatchers(HttpMethod.GET,"/roleHierarchy").hasRole("manager");

        httpSecurity.authorizeRequests().antMatchers(HttpMethod.PUT).hasRole("admin");
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.POST).hasRole("admin");
        httpSecurity.authorizeRequests().antMatchers(HttpMethod.DELETE).hasRole("admin").anyRequest().authenticated();

        return httpSecurity.build();
    }
}
