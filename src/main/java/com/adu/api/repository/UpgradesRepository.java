package com.adu.api.repository;

import com.adu.api.model.Upgrades;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UpgradesRepository extends ReactiveCrudRepository<Upgrades, Long> {

    Flux<Upgrades> findByDescription(String description);    
}
