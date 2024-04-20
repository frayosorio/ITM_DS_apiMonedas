package apimonedas.apimonedas.core.interfaces.servicios;

import apimonedas.apimonedas.core.DTOs.CapitalDto;

public interface IPaisServicio {

    public CapitalDto obtenerCapital(String nombre);

}
