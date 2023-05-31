package co.com.smartcats.movements;

import co.com.smartcats.cat.CatData;
import co.com.smartcats.model.cat.Cat;
import co.com.smartcats.model.movements.Movements;
import co.com.smartcats.model.movements.gateways.MovementsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class MovementsRepositoryAdapter implements MovementsRepository {

    private final MovementsDataRepository movementsDataRepository;

    @Override
    public Mono<Movements> saveMovement(Movements movements) {
        return mapperToMovementsData(movements)
                .flatMap(movementsDataRepository::save)
                .flatMap(this::mapperToMovements);
    }

    @Override
    public Flux<Movements> findByCatIdtheMovements(int id) {
        return movementsDataRepository.findByGatoId(id)
                .flatMap(this::mapperToMovements);
    }


    private Mono<MovementsData> mapperToMovementsData(Movements movements) {
        return Mono.just(MovementsData.builder()
                .id(movements.getId())
                .componente(movements.getComponente())
                .gatoId(movements.getGatoId())
                .createdAt(movements.getCreatedAt())
                .build());
    }

    private Mono<Movements> mapperToMovements(MovementsData movements) {
        return Mono.just(Movements.builder()
                .id(movements.getId())
                .componente(movements.getComponente())
                .gatoId(movements.getGatoId())
                .createdAt(movements.getCreatedAt())
                .build());
    }
}
