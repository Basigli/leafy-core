package com.leafy.core.service;

import com.leafy.core.model.greenhouse.Greenhouse;
import com.leafy.core.repository.GreenhouseRepository;

import java.util.HashMap;
import java.util.Map;

public class GreenhouseService {
    private Map<Integer, Greenhouse> greenhouses;
    private final GreenhouseRepository repository;
    public GreenhouseService(GreenhouseRepository repository) {

        this.repository = repository;
        this.greenhouses = new HashMap<>();
        for (Greenhouse gh : this.get()) {
            this.greenhouses.put(gh.getId(), gh);
        }

    }

    public Iterable<Greenhouse> get() {
        return repository.findAll();
    }


    public Greenhouse get(Integer id) {
        Greenhouse greenhouse = null;
        // search in cache for the greenhouse, if not found ask the database
        greenhouse = greenhouses.getOrDefault(id, repository.findById(id).orElse(null));
        greenhouses.put(greenhouse.getId(), greenhouse); // update the cache
        return greenhouse;
    }

    public void remove(Integer id) {
        repository.deleteById(id);
        greenhouses.remove(id);
    }



}
