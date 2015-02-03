package com.kmc.services;

import java.util.Set;

import org.json.JSONObject;

import com.kmc.db.model.PositionNeo;
import com.kmc.db.model.User;

public interface OrganizationService {
	public void createOrganization(JSONObject json);
	public Set<PositionNeo> getPositions(String orgName);
	public Set<User> getEmployees(String orgName);

}
