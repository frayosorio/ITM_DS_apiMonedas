package apimonedas.apimonedas.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import apimonedas.apimonedas.core.entidades.Moneda;

@Repository
public interface IMonedaRepositorio extends JpaRepository<Moneda, Long> {
   
    @Query("SELECT m FROM Moneda m WHERE m.nombre LIKE '%' || ?1 || '%'")
    List<Moneda> buscar(String nombre);

    @Query("SELECT m FROM Pais p JOIN p.moneda m WHERE p.nombre=?1")
    Moneda buscarPorPais(String nombre);

}
