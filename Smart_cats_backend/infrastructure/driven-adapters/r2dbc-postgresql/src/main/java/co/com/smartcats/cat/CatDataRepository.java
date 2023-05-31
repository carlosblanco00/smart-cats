package co.com.smartcats.cat;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CatDataRepository extends ReactiveCrudRepository<CatData, Integer> {
}
