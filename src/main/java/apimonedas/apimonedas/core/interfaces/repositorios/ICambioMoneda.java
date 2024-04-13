package apimonedas.apimonedas.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apimonedas.apimonedas.core.entidades.CambioMoneda;

@Repository
public interface ICambioMoneda extends JpaRepository<CambioMoneda, Long> {

    
} 