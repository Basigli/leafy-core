package com.leafy.core.service;

import com.leafy.core.model.greenhouse.Greenhouse;
import com.leafy.core.repository.GreenhouseRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GreenhouseService {
    private final Map<Integer, Greenhouse> greenhouses;
    private final GreenhouseRepository repository;
    public GreenhouseService(GreenhouseRepository repository) {
        this.repository = repository;
        this.greenhouses = new HashMap<>();
    }

    public Iterable<Greenhouse> get() {
        return repository.findAll();
    }

    public Greenhouse get(Integer greenhouseId) {
        Greenhouse greenhouse = null;
        // search in cache for the greenhouse, if not found ask the database
        greenhouse = greenhouses.getOrDefault(greenhouseId, repository.findById(greenhouseId).orElse(null));
        greenhouses.put(greenhouse.getId(), greenhouse); // update the cache
        return greenhouse;
    }

    public void remove(Integer id) {
        repository.deleteById(id);
        greenhouses.remove(id);
    }
}
