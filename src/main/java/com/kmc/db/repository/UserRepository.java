package com.kmc.db.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.support.Neo4jTemplate;

import com.kmc.db.model.PositionNeo;
import com.kmc.db.model.User;
import com.kmc.db.relationship.Role;

public interface UserRepository extends GraphRepository<User>, UserRepositoryCustom {
	//public void assignPosition(User user, PositionNeo position, String relationName);
}
