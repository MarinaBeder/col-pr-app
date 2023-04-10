package com.Fintech.CoPro.config;



import javax.servlet.http.HttpServletResponse;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Fintech.CoPro.filter.JwtFilter;
import com.Fintech.CoPro.util.CustomPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired

		private JwtFilter jwtFilter;//ourfilter
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private CustomPasswordEncoder customPasswordEncoder;
	@Override @Bean
	public AuthenticationManager authenticationManagerBean ()throws Exception{
		return super.authenticationManagerBean();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(customPasswordEncoder.getPasswordEncoder());
	}
	
	@Override
	//what access should you have in this apps and that is where this next configure methid comes from
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	//	super.configure(http);
	
		        // Enable CORS and disable CSRF
		        http = http.cors().and().csrf().disable();

		        // Set session management to stateless
		        http = http
		            .sessionManagement()
		            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		            .and();

		        // Set unauthorized requests exception handler
		        http = http
		            .exceptionHandling()
		            .authenticationEntryPoint(
		                (request, response, ex) -> {
		                    response.sendError(
		                        HttpServletResponse.SC_UNAUTHORIZED,
		                        ex.getMessage()
		                    );
		                }
		            )
		            .and();
		        http.cors(); 

   http. authorizeRequests()
   .antMatchers("/Co-Pro/SignUp/**").permitAll()
   .antMatchers("/Co-Pro/Auth/**").permitAll()
		  .anyRequest().authenticated();
  
   // add filter :inject our filter  before usernamepasswordauthentivcationfilter
  http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		  
	}

	
}
