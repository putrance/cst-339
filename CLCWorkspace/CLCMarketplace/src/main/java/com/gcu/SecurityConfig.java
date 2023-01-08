package com.gcu;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.gcu.business.*;

// Import WebSecurityConfigurerAdapater librarys
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//Autowire Authentication Datasource
	@Autowired
	private DataSource dataSource;
	//Configure Auth Manager to use Datasource
	@Override
	public void configure(AuthenticationManagerBuilder auth)
	    throws Exception {
	    
	  auth.jdbcAuthentication()
	      .dataSource(dataSource)
	      ;
	}
	
//Create passwordencoder bean
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
//Set HTTP Security
  @Override
  protected void configure(final HttpSecurity http) throws Exception {

    //@formatter:off
    http.authorizeRequests()
        .antMatchers("/login").permitAll()
        .antMatchers("/register").permitAll()
        .antMatchers("/doRegister").permitAll()
        .antMatchers("/Products").permitAll()
        .antMatchers("/ProductsAddation").permitAll()
        .antMatchers("/doProduct").permitAll()
        .antMatchers("/").permitAll()
        .antMatchers("/**").hasAnyRole("USER", "ADMIN")
        .antMatchers("/admin/**").hasAnyRole("ADMIN")
        .and()
          .formLogin()
          .loginPage("/login")
          .loginProcessingUrl("/doLogin")
          .defaultSuccessUrl("/")
          .failureUrl("/login?error=true")
          .permitAll()
        .and()
          .logout()
          .logoutSuccessUrl("/login?logout=true")
          .invalidateHttpSession(true)
          .deleteCookies("JSESSIONID")
          .permitAll()
        .and()
          .csrf()
          .disable();
    //@formatter:on
    http.formLogin()
    	.successHandler(authenticationSuccessHandler());
 //   	.failureHandler(authenticationFailureHandler())
  }
//Create Custom Auth Success Handler
  @Bean(name="authenticationSuccessHandler")
  AuthenticationSuccessHandler authenticationSuccessHandler() {
    return new CustomAuthenticationSuccessHandler();
  }
//Create Custom Auth failure Handler
  @Bean(name="authenticationFailureHandler")
  AuthenticationFailureHandler authenticationFailureHandler() {
    return new CustomAuthenticationFailureHandler();
  }
 //WebSecurity filter to allow public access to static content 
  @Override
  public void configure(WebSecurity web) {
    web.ignoring()
        .antMatchers("/resources/**", "/static/**", "/images/**", "/Products/**", "/ProductAddition**");
  }

}
