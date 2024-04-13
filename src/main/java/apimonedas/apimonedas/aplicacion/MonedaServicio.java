package apimonedas.apimonedas.aplicacion;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import apimonedas.apimonedas.core.entidades.Moneda;
import apimonedas.apimonedas.core.interfaces.repositorios.IMonedaRepositorio;
import apimonedas.apimonedas.core.interfaces.servicios.IMonedaServicio;

@Service
public class MonedaServicio implements IMonedaServicio {

    private IMonedaRepositorio repositorio;

    public MonedaServicio(IMonedaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Moneda> listar() {
        return repositorio.findAll();
    }

    @Override
    public Moneda obtener(Long id) {
        var moneda = repositorio.findById(id);
        return moneda.isEmpty() ? null : moneda.get();
    }

    @Override
    public List<Moneda> buscar(String nombre) {
        return repositorio.buscar(nombre);
    }

    @Override
    public Moneda buscarPorPais(String nombre) {
        return repositorio.buscarPorPais(nombre);
    }

    public Moneda agregar(Moneda moneda) {
        moneda.setId(0);
        return repositorio.save(moneda);
    }

    @Override
    public Moneda modificar(Moneda moneda) {
        Optional<Moneda> monedaEncontrado = repositorio.findById(moneda.getId());
        if (!monedaEncontrado.isEmpty()) {
            return repositorio.save(moneda);
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
