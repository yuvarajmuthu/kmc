package com.kmc.db.relationship;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import com.kmc.db.model.Organization;
import com.kmc.db.model.User;

@RelationshipEntity(type="EMPLOYEES")
public class OrganizationUserRelation {
	@GraphId Long id;
	
	@StartNode 
	Organization organization;
	
    @EndNode
    User user;
}
