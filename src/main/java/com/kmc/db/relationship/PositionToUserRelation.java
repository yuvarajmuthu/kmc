package com.kmc.db.relationship;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.kmc.db.model.PositionNeo;
import com.kmc.db.model.User;

@RelationshipEntity(type="TAGGED_USER")
public class PositionToUserRelation {
	@StartNode 
    PositionNeo position;
	
    @EndNode
	User user;

}
