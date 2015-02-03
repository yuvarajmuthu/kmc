package com.kmc.db.model;

import java.util.Date;
import java.util.Set;


import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity 
public class Organization {

    public Date getFoundedDate() {
		return foundedDate;
	}
	public void setFoundedDate(Date foundedDate) {
		this.foundedDate = foundedDate;
	}
	public Set<PositionNeo> getPositions() {
		return positions;
	}
	public void setPositions(Set<PositionNeo> positions) {
		this.positions = positions;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	//@Indexed(unique=true) String id;
	@GraphId Long id;
	
	private String name;
	
	private Date foundedDate;
	
	@RelatedTo(type = "POSITION")
	private Set<PositionNeo> positions;
	
	@RelatedTo(type = "EMPLOYEES")
	private Set<User> users;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}