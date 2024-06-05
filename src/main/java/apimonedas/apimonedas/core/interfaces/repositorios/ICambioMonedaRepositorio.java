package apimonedas.apimonedas.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

import apimonedas.apimonedas.core.entidades.CambioMoneda;

@Repository
public interface ICambioMonedaRepositorio extends JpaRepository<CambioMoneda, Long> {

    @Query("SELECT cm FROM CambioMoneda cm  WHERE cm.moneda.id=?1 AND cm.fecha >= ?2 AND cm.fecha <= ?3")
    public List<CambioMoneda> listarPorPeriodo(long idMoneda, Date fecha1, Date fecha2);

} 