package co.com.smartcats.model.movements.gateways;

import co.com.smartcats.model.movements.Movements;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementsRepository {

    Mono<Movements> saveMovement(Movements movements);

    Flux<Movements> findByCatIdtheMovements(int id);
}
