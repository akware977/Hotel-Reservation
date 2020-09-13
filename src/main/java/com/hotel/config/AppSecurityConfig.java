package com.hotel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.hotel.repository.UserRepository;
import com.hotel.service.MyUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * private static final Logger logger = LoggerFactory
	 * .getLogger(AppSecurityConfig.class);
	 */
	
	@Autowired 
	private UserDetailsService userDetailsService;
	
	@Autowired
	CustomLoginSuccessHandler customLoginSuccessHandler;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new MyUserDetailsService();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/resources/**","/static/**","/assets/**","/css/**","/fonts/**","/js/**","/img/**","/vendor/**",
					 "/OwlCarousel/**","/noUiSlider/**","/images/**","/lang/**","/skins/**","/moono-lisa/**",
					 "/hidpi/**").permitAll()
			.antMatchers("/index","/register","/").permitAll()
			.antMatchers("/admin/**").authenticated()   
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login").permitAll()  //default page for spring security either custome login or required page
				.successHandler(customLoginSuccessHandler)
				.and()
			.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login").permitAll()
				.and()
			.exceptionHandling().accessDeniedPage("/403");
	}
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() { 
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder; 
	}
	

}
