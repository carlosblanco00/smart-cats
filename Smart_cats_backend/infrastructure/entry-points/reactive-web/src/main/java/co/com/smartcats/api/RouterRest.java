package co.com.smartcats.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(GET("/api/smartcats/cat/{id}"), handler::getCatById)
            .and(route(POST("/api/smartcats/cat/"), handler::createCat))
            .and(route(GET("/api/smartcats/movements/{id}"), handler::getMovementsByIdCat))
            .and(route(POST("/api/smartcats/movements/"), handler::createMovement));

    }
}
