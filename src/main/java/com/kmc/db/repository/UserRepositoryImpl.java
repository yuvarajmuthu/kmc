package com.kmc.db.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.support.Neo4jTemplate;

import com.kmc.db.model.PositionNeo;
import com.kmc.db.model.User;
import com.kmc.db.relationship.UserToPositionRelation;

public class UserRepositoryImpl implements UserRepositoryCustom{
	@Autowired 
	Neo4jTemplate neoTemplate;
	
	public void assignPosition(User user, PositionNeo position, String relationName){
		//Neo4jOperations neoTemplate = new Neo4jTemplate(graphDatabaseService);
		neoTemplate.createRelationshipBetween(user, position, UserToPositionRelation.class, relationName, true); // true - allowDuplicates
		//neoTemplate.save(role);
	}

}
