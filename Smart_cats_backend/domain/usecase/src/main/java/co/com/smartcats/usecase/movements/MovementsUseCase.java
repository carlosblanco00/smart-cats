package co.com.smartcats.usecase.movements;

import co.com.smartcats.model.cat.Cat;
import co.com.smartcats.model.movements.Movements;
import co.com.smartcats.model.movements.gateways.MovementsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Log4j2
public class MovementsUseCase {
    private final MovementsRepository movementsRepository;

    public Mono<Movements> saveMovement(Movements movement) {
        return movementsRepository.saveMovement(movement).doOnSuccess(movement1 -> log.info("Movement saved: {}", movement1));
    }

    public Flux<Movements> findByIdCatMovements(int id) {return movementsRepository.findByCatIdtheMovements(id);}
}
