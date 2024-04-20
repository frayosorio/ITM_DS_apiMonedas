package apimonedas.apimonedas.presentacion;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apimonedas.apimonedas.core.DTOs.CapitalDto;

import apimonedas.apimonedas.core.interfaces.servicios.IPaisServicio;

@RestController
@RequestMapping("/api/paises")
public class PaisControlador {

    private IPaisServicio servicio;

    public PaisControlador(IPaisServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/capital/{pais}", method = RequestMethod.GET)
    public CapitalDto obtener(@PathVariable String pais) {
        return servicio.obtenerCapital(pais);
    }

}
