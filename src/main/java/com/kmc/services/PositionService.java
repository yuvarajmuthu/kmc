package com.kmc.services;

import java.util.Set;

import org.json.JSONObject;

import com.kmc.db.model.PositionNeo;
import com.kmc.db.relationship.Role;

public interface PositionService {
	public void createPosition(JSONObject json);
	public Set<PositionNeo> getPosition(String title);
	public void reportsToPosition(JSONObject json);
	public void associatePositionToOrganization(JSONObject json);
	public void tagUser(JSONObject json);
}
