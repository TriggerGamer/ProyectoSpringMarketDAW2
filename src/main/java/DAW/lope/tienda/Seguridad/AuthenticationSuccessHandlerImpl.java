package DAW.lope.tienda.Seguridad;

import java.io.IOException;
import java.util.Collection;

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

import DAW.lope.tienda.Entidades.Usuario;
import DAW.lope.tienda.servicios.ModuloServicioTemplate;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
  
	
	@Autowired
	private ModuloServicioTemplate Servicio;
 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		HttpSession session = request.getSession();
		Usuario authUser = Servicio.findUsuarioById(0);
		session.setAttribute("apellidos", authUser.getApellidos());
		session.setAttribute("nombre", authUser.getNombre());
		session.setAttribute("id_Usuario", authUser.getId_Usuario());

		boolean isProfesor = false;
		boolean isAdmin = false;
		final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROL_PROFESOR")) {
				isProfesor = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROL_ADMIN")) {
				isAdmin = true;
				break;
			}
		}

		String targetUrl;
		if (isProfesor) {
			targetUrl = "/";
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