package co.com.smartcats.api;

import co.com.smartcats.model.cat.Cat;
import co.com.smartcats.model.movements.Movements;
import co.com.smartcats.usecase.cats.CatsUseCase;
import co.com.smartcats.usecase.movements.MovementsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private  final CatsUseCase catsUseCase;

    private  final MovementsUseCase movementsUseCase;

    public Mono<ServerResponse> getCatById(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        return catsUseCase.findByIdCat(id)
                .flatMap(cat -> ServerResponse.ok().bodyValue(cat));
    }

    public Mono<ServerResponse> createCat(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Cat.class)
                .flatMap(catsUseCase::saveCat)
                .flatMap(cat -> ServerResponse.ok().bodyValue(cat));
    }

    public Mono<ServerResponse> getMovementsByIdCat(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        return movementsUseCase.findByIdCatMovements(id)
                .collectList()
                .flatMap(movements -> ServerResponse.ok().bodyValue(movements));
    }

    public Mono<ServerResponse> createMovement(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Movements.class)
                        .flatMap(movementsUseCase::saveMovement)
                .flatMap(movements -> ServerResponse.ok().bodyValue(movements));
    }
}
