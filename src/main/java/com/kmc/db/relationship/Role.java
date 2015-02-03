package com.kmc.db.relationship;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.kmc.db.model.PositionNeo;

@RelationshipEntity(type="REPORTS_TO")
public class Role {
	@GraphId Long id;
	
	@StartNode 
	PositionNeo childPosition;
	
    @EndNode
    PositionNeo parentPosition;
    
    String role;
}
