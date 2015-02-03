package com.kmc.db.relationship;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.kmc.db.model.PositionNeo;
import com.kmc.db.model.User;

@RelationshipEntity(type="DESIGNATION")
public class UserToPositionRelation {
	@GraphId Long id;
	
	@StartNode 
	User user;
	
    @EndNode
    PositionNeo position;
}
