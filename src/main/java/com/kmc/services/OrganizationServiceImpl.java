package com.kmc.services;

import java.util.Date;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmc.db.model.Organization;
import com.kmc.db.model.PositionNeo;
import com.kmc.db.model.User;
import com.kmc.db.repository.OrganizationRepository;
import com.kmc.db.repository.PositionRepository;

@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService{
	@Autowired
	private OrganizationRepository orgRepository;
	
	public void createOrganization(JSONObject json){
		Organization org = new Organization();
		try{
			JSONObject organizationJson = (JSONObject)json.get("organization");
			org.setName(organizationJson.get("name").toString());
			org.setFoundedDate(new Date(new Long(organizationJson.get("foundedDate").toString())));
			orgRepository.save(org);
		}catch(JSONException e){
			java.lang.System.out.print(e.getMessage());
		}
	}

	public Set<PositionNeo> getPositions(String orgName){
		Organization org;
		org = orgRepository.findByPropertyValue("name", orgName);
		
		Set<PositionNeo> positions = org.getPositions();
		
		return positions;
		
	}
	
	public Set<User> getEmployees(String orgName){
		Organization org;
		org = orgRepository.findByPropertyValue("name", orgName);
		
		Set<User> users = org.getUsers();
		
		return users;
		
	}
	
}
