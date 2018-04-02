package com.rsrit.Dops.Server.Security;

/**
 * @author gn.teja created on 02/23/2017
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@EnableWebSecurity
@ComponentScan("com.rsrit.Dops.Server.Security")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService userService;
	
	@Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
 
    @Autowired
    private CustomAuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	public void globalConfigure(AuthenticationManagerBuilder auth) throws Exception { 
		
//		 auth
//		 .inMemoryAuthentication()
//		 	.withUser("admin").password("admin").roles("ADMIN")
//		 	.and()
//		 	.withUser("user").password("pass").roles("USER");
		 
		 auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	    .cors()
	    .and()
        .csrf().disable()
        .exceptionHandling()
        .authenticationEntryPoint(restAuthenticationEntryPoint)
        .and()
        .authorizeRequests()
		.antMatchers("/api/user/login")
		.permitAll()
        .antMatchers("/api/user/registration")
        .permitAll()
		.antMatchers("/api/user/loggout")
		.permitAll()
		/*.antMatchers("/api/user/cloudenv")
		.permitAll()
		.antMatchers("/api/user/getcloud")
		.permitAll()
		.antMatchers("/api/user/getcloudone/{id}")
		.permitAll()*/
		.and()
		.authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/api/user/login")
        .successHandler(authenticationSuccessHandler)
        .failureHandler(new SimpleUrlAuthenticationFailureHandler())
        .and()
        .logout()
        .logoutUrl("/api/user/logout")
        .logoutSuccessUrl("/api/user/loggout");
	}
	
		@Bean
	    public CustomAuthenticationSuccessHandler mySuccessHandler(){
	        return new CustomAuthenticationSuccessHandler();
	    }
	    @Bean
	    public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
	        return new SimpleUrlAuthenticationFailureHandler();
	    }
	
}
