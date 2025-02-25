package com.adu.api.service;

import com.adu.api.model.Upgrades;
import com.adu.api.repository.UpgradesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UpgradesService {

    private final UpgradesRepository upgradesRepository;

    public Flux<Upgrades> getAllUpgrades() {
        return upgradesRepository.findAll();
    }

    public Mono<Upgrades> getUpgradesById(Long upgrade_id) {
        return upgradesRepository.findById(upgrade_id);
    }

    public Mono<Upgrades> createUpgrades(Upgrades upgrade) {
        return upgradesRepository.save(upgrade);
    }

    public Mono<Upgrades> updateUpgrades(Long upgrade_id, Upgrades upgrade) {
        return upgradesRepository.findById(upgrade_id)
                .flatMap(existingUpgrades -> {
                    existingUpgrades.setDescription(upgrade.getDescription());
                    existingUpgrades.setExt_description(upgrade.getExt_description());
                    existingUpgrades.setDetails(upgrade.getDetails());
                    existingUpgrades.setPrice(upgrade.getPrice());

                    existingUpgrades.setUpdated_at(LocalDateTime.now());
                
                    return upgradesRepository.save(existingUpgrades);
                });
    }

    public Mono<Void> deleteUpgrades(Long upgrade_id) {
        return upgradesRepository.deleteById(upgrade_id);
    }
}
