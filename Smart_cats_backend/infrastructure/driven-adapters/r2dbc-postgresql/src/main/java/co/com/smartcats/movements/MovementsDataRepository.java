package co.com.smartcats.movements;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface MovementsDataRepository extends ReactiveCrudRepository<MovementsData, Integer> {

    @Query("SELECT * FROM movimientos WHERE gato_id = :idGato")
    Flux<MovementsData> findByGatoId(int idGato);
}
