package DAW.lope.tienda.Seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	 
	@Autowired
	 private UserDetailsService userDetailsService;
		

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                .authorizeRequests()
	                    .antMatchers(
	                            "/","/index",
	                            "/js/**",
	                            "/css/**",
	                            "/img/**",
	                            "/usuario/login",
	                            "/usuario/signup",
	                            "/webjars/**").permitAll()
	                    .antMatchers("/crear").hasAuthority("admin")
	                    .anyRequest().authenticated()
	                .and()
	                .formLogin()
	                    .loginPage("/usuario/login")
	                    .loginProcessingUrl("/usuario/login")
	                    .successHandler(myAuthenticationSuccessHandler())
	                    .permitAll()
	                .and()
	                .logout()
	                    .invalidateHttpSession(true)
	                    .deleteCookies("")
	                    .clearAuthentication(true)
	                    .logoutUrl("/usuario/logOut")
	                    .logoutRequestMatcher(new AntPathRequestMatcher("/usuario/logOut"))
	                    .logoutSuccessUrl("/index")
	                    .permitAll();
	    }

		@Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
			
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
	    }
	    
		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			return bCryptPasswordEncoder;
		}

		@Bean
		public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
			return new AuthenticationSuccessHandlerImpl();
		}
		
}