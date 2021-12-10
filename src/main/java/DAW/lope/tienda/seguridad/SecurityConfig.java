package DAW.lope.tienda.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import DAW.lope.tienda.servicios.ServicioUsuarios;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	 
	 @Autowired
	 private ServicioUsuarios userDetailsService;
		
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                .authorizeRequests()
	                    .antMatchers(
	                            "/index",
	                            "/js/**",
	                            "/css/**",
	                            "/img/**",
	                            "/usuario/login",
	                            "/usuario/signup",
	                            "/producto/buscar",
	                            "/producto/{id_Producto}",
	                            "/carrito/guardar/{id_Producto}",
	                            "/carrito/listar",
	                            "/acceso-denegado",
	                            "/webjars/**").permitAll()
	                    .antMatchers(
	                    		"/producto/crear",
	                    		"/producto/borrar/{id_Producto}").hasAuthority("Admin")
	                    .antMatchers(
	                    		"/compra/miscompras",
	                    		"/compra").hasRole("Publico")
	                .and()
	                .formLogin()
	                    .loginPage("/usuario/login")
	                    .loginProcessingUrl("/usuario/login")
	                    .usernameParameter("nombreUsuario")
	                    .passwordParameter("contrasenia")
	                    .successHandler(myAuthenticationSuccessHandler())
	                    .permitAll()
	                .and()
	                .logout()
	                    .invalidateHttpSession(true)
	                    .clearAuthentication(true)
	                    .logoutUrl("/usuario/logOut")
	                    .logoutRequestMatcher(new AntPathRequestMatcher("/usuario/logOut"))
	                    .logoutSuccessUrl("/index")
	                    .permitAll()
	        		.and()
	        		.exceptionHandling().accessDeniedPage("/acceso-denegado");
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