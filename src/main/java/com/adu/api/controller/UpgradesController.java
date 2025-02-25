package com.adu.api.controller;

import com.adu.api.model.Upgrades;
import com.adu.api.service.UpgradesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/upgrades")
@RequiredArgsConstructor
@Tag(name = "upgrades Management", description = "APIs for managing upgrades")
public class UpgradesController {

    private final UpgradesService upgradesService;

    @GetMapping
    @Operation(summary = "Get all upgrades")
    public Flux<Upgrades> getAllUpgrades() {
        return upgradesService.getAllUpgrades();
    }

    @GetMapping("/{upgrade_id}")
    @Operation(summary = "Get upgrades by ID")
    public Mono<Upgrades> getUpgradesById(@PathVariable Long upgrade_id) {
        return upgradesService.getUpgradesById(upgrade_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new upgrades")
    public Mono<Upgrades> createUpgrades(@RequestBody Upgrades upgrade) {
        return upgradesService.createUpgrades(upgrade);
    }

    @PutMapping("/{upgrade_id}")
    @Operation(summary = "Update an existing upgrades")
    public Mono<Upgrades> updateUpgrades(@PathVariable Long upgrade_id, @RequestBody Upgrades upgrade) {
        return upgradesService.updateUpgrades(upgrade_id, upgrade);
    }

    @DeleteMapping("/{upgrade_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a upgrades")
    public Mono<Void> deleteUpgrades(@PathVariable Long upgrade_id) {
        return upgradesService.deleteUpgrades(upgrade_id);
    }
}
