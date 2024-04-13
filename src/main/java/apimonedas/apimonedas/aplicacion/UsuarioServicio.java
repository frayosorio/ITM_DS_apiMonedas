package apimonedas.apimonedas.aplicacion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apimonedas.apimonedas.aplicacion.seguridad.SeguridadServicio;
import apimonedas.apimonedas.core.DTOs.UsuarioLoginDto;
import apimonedas.apimonedas.core.entidades.Usuario;
import apimonedas.apimonedas.core.interfaces.repositorios.IUsuarioRepositorio;
import apimonedas.apimonedas.core.interfaces.servicios.IUsuarioServicio;

@Service
public class UsuarioServicio implements IUsuarioServicio {

    @Autowired
    private IUsuarioRepositorio repositorio;

    @Autowired
    private SeguridadServicio servicioSeguridad;

    @Override
    public UsuarioLoginDto login(String nombreUsuario, String clave) {
        Usuario usuarioObtenido = repositorio.validarUsuario(nombreUsuario, clave);
        UsuarioLoginDto userLoginResponseDto = new UsuarioLoginDto(usuarioObtenido);
        if (usuarioObtenido != null) {
            userLoginResponseDto.setToken(servicioSeguridad.generarToken(nombreUsuario));
        }
        return userLoginResponseDto;
    }

    @Override
    public List<Usuario> listar() {
        return repositorio.findAll();
    }

    @Override
    public Usuario obtener(Long id) {
        var usuario = repositorio.findById(id);
        return usuario.isEmpty() ? null : usuario.get();
    }

    @Override
    public List<Usuario> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    public Usuario agregar(Usuario usuario) {
        usuario.setId(0);
        return repositorio.save(usuario);
    }

    @Override
    public Usuario modificar(Usuario usuario) {
        Optional<Usuario> usuarioEncontrado = repositorio.findById(usuario.getId());
        if (!usuarioEncontrado.isEmpty()) {
            return repositorio.save(usuario);
        } else {
            return null;
        }
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
