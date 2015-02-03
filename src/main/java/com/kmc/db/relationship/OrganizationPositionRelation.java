package com.kmc.db.relationship;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.kmc.db.model.Organization;
import com.kmc.db.model.PositionNeo;
import com.kmc.db.model.User;

@RelationshipEntity(type="PART_OF")
public class OrganizationPositionRelation {
	@GraphId Long id;
	
	@StartNode 
	PositionNeo position;
	
    @EndNode
    Organization organization;
    
}
