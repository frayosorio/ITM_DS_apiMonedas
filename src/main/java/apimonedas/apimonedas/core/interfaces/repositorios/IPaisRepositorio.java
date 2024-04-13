package apimonedas.apimonedas.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apimonedas.apimonedas.core.entidades.Pais;

import java.util.List;

@Repository
public interface IPaisRepositorio extends JpaRepository<Pais, Long>{
    
    @Query("SELECT p FROM Pais p WHERE p.nombre LIKE '%' || ?1 || '%'")
    List<Pais> buscar(String nombre);


}
