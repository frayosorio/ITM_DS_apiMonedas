package apimonedas.apimonedas.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import apimonedas.apimonedas.core.DTOs.CapitalDto;

@Service
public class PaisCliente {

    @Autowired
    private RestTemplate restTemplate;

    public CapitalDto obtenerCapital(String nombre) {
        String url = "http://localhost:3030/paises/capital/" + nombre;
        ResponseEntity<CapitalDto> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<CapitalDto>() {

                });
        return responseEntity.getBody();
    }

}
