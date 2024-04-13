package apimonedas.apimonedas.core.interfaces.servicios;

import java.util.List;

import apimonedas.apimonedas.core.entidades.Moneda;

public interface IMonedaServicio {

    public List<Moneda> listar();

    public Moneda obtener(Long id);

    public List<Moneda> buscar(String nombre);

    public Moneda buscarPorPais(String nombre);

    public Moneda agregar(Moneda moneda);

    public Moneda modificar(Moneda moneda);

    public boolean eliminar(Long id);

}
