package co.com.smartcats.cat;

import co.com.smartcats.model.cat.Cat;
import co.com.smartcats.model.cat.gateways.CatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class CatRepositoryAdapter implements CatRepository {
    private final CatDataRepository catDataRepository;

    @Override
    public Mono<Cat> saveCat(Cat cat) {
        return mapperToCatData(cat)
                .flatMap(catDataRepository::save)
                .flatMap(this::mapperToCat);
    }

    @Override
    public Mono<Cat> findByIdCat(int id) {
        return catDataRepository.findById(id)
                .flatMap(this::mapperToCat);
    }


    private Mono<CatData> mapperToCatData(Cat cat) {
        return Mono.just(CatData.builder()
                .id(cat.getId())
                .nombre(cat.getNombre())
                .edad(cat.getEdad())
                .raza(cat.getRaza())
                .peso(cat.getPeso())
                .tipoComida(cat.getTipoComida())
                .build());
    }

    private Mono<Cat> mapperToCat(CatData catData) {
        return Mono.just(Cat.builder()
                .id(catData.getId())
                .nombre(catData.getNombre())
                .edad(catData.getEdad())
                .raza(catData.getRaza())
                .peso(catData.getPeso())
                .tipoComida(catData.getTipoComida())
                .build());
    }
}
