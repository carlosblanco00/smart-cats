package co.com.smartcats.api;

import co.com.smartcats.model.areneroentity.AreneroEntity;
import co.com.smartcats.usecase.arenero.AreneroUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private  final AreneroUseCase areneroUseCase;
//private  final UseCase2 useCase2;
    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return serverRequest.bodyToMono(AreneroEntity.class)
                .flatMap(areneroUseCase::saveMoveSandbox)
                .flatMap(areneroEntity -> ServerResponse.ok().bodyValue(areneroEntity));
    }
}
