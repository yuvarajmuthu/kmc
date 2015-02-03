package com.kmc.services.interfaces;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

public interface StructureService {

	public Boolean insert (JSONObject object);
	public JSONObject readStructure ();
	public Boolean updateStructure (JSONObject structure);
	public Boolean deleteStructure (JSONObject structure);
	
}
