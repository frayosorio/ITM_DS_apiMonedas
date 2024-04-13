package apimonedas.apimonedas.aplicacion.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import apimonedas.apimonedas.core.entidades.Usuario;
import apimonedas.apimonedas.core.interfaces.repositorios.IUsuarioRepositorio;

@Service
public class UsuarioDetalleServicio implements UserDetailsService {

    @Autowired
    private IUsuarioRepositorio repositorio;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuarioObtenido = repositorio.obtener(nombreUsuario);
        if (usuarioObtenido == null) {
            throw new UsernameNotFoundException(nombreUsuario);
        }
        return new UsuarioDetalles(usuarioObtenido);
    }

}
