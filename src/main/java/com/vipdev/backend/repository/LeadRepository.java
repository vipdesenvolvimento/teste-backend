package com.vipdev.backend.repository;

import com.vipdev.backend.model.Lead;
import org.springframework.data.repository.CrudRepository;

public interface LeadRepository extends CrudRepository<Lead, Integer> {
}
