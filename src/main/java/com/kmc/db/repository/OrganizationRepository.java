package com.kmc.db.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.kmc.db.model.Organization;

public interface OrganizationRepository extends GraphRepository<Organization>, OrganizationRepositoryCustom {
}
