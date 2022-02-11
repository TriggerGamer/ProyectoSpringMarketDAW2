package DAW.lope.tienda.seguridad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import DAW.lope.tienda.entidades.Usuario;
import DAW.lope.tienda.servicios.ServicioUsuarios;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
  
	@Autowired
	private ServicioUsuarios servicio;
 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		HttpSession session = request.getSession();
		Usuario authUser = servicio.login(userDetails.getUsername());
		session.setAttribute("user", userDetails.getUsername());
		session.setAttribute("id_Usuario", authUser.getId_Usuario());
		

		boolean isRegistrado = false;
		boolean isAdmin = false;
		final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("Registrado")) {
				session.setAttribute("rol2", "Registrado");
				isRegistrado = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("Admin")) {
				isAdmin = true;
				
				session.setAttribute("rol", "Admin");
				session.setAttribute("rol2", "Registrado");
				
				break;
			}
		}

		String targetUrl;
		if (isRegistrado) {
			targetUrl = "/index";
		} else if (isAdmin) {
			targetUrl = "/index";
		} else {
			throw new IllegalStateException();
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

    public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
    

}