package com.kmc.db.model;

import java.util.Date;
import java.util.Map;
import java.util.Set;


import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity 
public class PositionNeo {

	//unique key = position title, organization id, tagger user
	
    //@Indexed(unique=true) String id;
	@GraphId Long id;
	private String title;
	private String responsibilities;
	private String __type__;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String get_type_() {
		return __type__;
	}

	public void set_type_(String _type_) {
		this.__type__ = _type_;
	}

	public Set<User> getTaggedUsers() {
		return taggedUsers;
	}

	public void setTaggedUsers(Set<User> taggedUsers) {
		this.taggedUsers = taggedUsers;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PositionNeo(){
		
	}

	public PositionNeo(String title){
		this.title = title;
	}

	@RelatedTo(type = "REPORTS_TO", direction = Direction.OUTGOING)
	Set<PositionNeo> parents;
	
	public Set<PositionNeo> getParents() {
		return parents;
	}

	public void setParents(Set<PositionNeo> parents) {
		this.parents = parents;
	}
	
	@RelatedTo(type = "REPORTS_TO", direction = Direction.INCOMING)
	Set<PositionNeo> childs;

	public Set<PositionNeo> getChilds() {
		return childs;
	}

	public void setChilds(Set<PositionNeo> childs) {
		this.childs = childs;
	}
	
	@Fetch @RelatedTo (type = "DESIGNATION", direction = Direction.INCOMING)
	Set<User> taggedUsers;

	public Set<User> getTaggedUser() {
		return taggedUsers;
	}

	public void setTaggedUser(Set<User> taggedUser) {
		this.taggedUsers = taggedUser;
	}
	
	@RelatedTo (type = "PART_OF", direction = Direction.OUTGOING)
	Organization organization;

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
}