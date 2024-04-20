package apimonedas.apimonedas.aplicacion;

import org.springframework.stereotype.Service;

import apimonedas.apimonedas.core.DTOs.CapitalDto;
import apimonedas.apimonedas.core.interfaces.servicios.IPaisServicio;

@Service
public class PaisServicio implements IPaisServicio {

    private PaisCliente paisCliente;

    public PaisServicio(PaisCliente paisCliente) {
        this.paisCliente = paisCliente;
    }

    @Override
    public CapitalDto obtenerCapital(String nombre) {
        return paisCliente.obtenerCapital(nombre);
    }

}
