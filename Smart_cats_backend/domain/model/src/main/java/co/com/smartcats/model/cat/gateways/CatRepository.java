package co.com.smartcats.model.cat.gateways;

import co.com.smartcats.model.cat.Cat;
import reactor.core.publisher.Mono;

public interface CatRepository {

    Mono<Cat> saveCat(Cat cat);

    Mono<Cat> findByIdCat(int id);
}
