package com.leafy.core.repository;

import com.leafy.core.model.greenhouse.Greenhouse;
import org.springframework.data.repository.CrudRepository;

public interface GreenhouseRepository extends CrudRepository<Greenhouse, Integer> {
}
