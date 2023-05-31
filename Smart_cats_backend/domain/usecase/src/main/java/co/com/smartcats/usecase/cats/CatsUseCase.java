package co.com.smartcats.usecase.cats;

import co.com.smartcats.model.cat.Cat;
import co.com.smartcats.model.cat.gateways.CatRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CatsUseCase {
    private final CatRepository catsRepository;

    public Mono<Cat> saveCat(Cat cat) {
        return catsRepository.saveCat(cat);
    }

    public Mono<Cat> findByIdCat(int id) {
        return catsRepository.findByIdCat(id);
    }
}
