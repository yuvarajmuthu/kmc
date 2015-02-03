package com.kmc.db.model;

import java.util.Set;


import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity 
public class User {

    //@Indexed(unique=true) String id;
	@GraphId Long id;
	
	@Indexed(unique=true)
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String firstName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	private String password;
	
	@RelatedTo(type = "DESIGNATION")
	Set<PositionNeo> positions;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<PositionNeo> getPositions() {
		return positions;
	}

	public void setPositions(Set<PositionNeo> positions) {
		this.positions = positions;
	}
	

}