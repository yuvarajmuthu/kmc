package com.kmc.services;

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
import com.kmc.db.repository.UserRepository;
import com.kmc.services.PositionService;

@Service("positionService")
public class PositionServiceImpl implements PositionService{

	@Autowired
	private PositionRepository positionRepository;
	
	@Autowired
	private OrganizationRepository orgRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void createPosition(JSONObject json){
		PositionNeo position = new PositionNeo();
		try{
			JSONObject positionJson = (JSONObject)json.get("position");
			position.setTitle(positionJson.get("title").toString());
			position.setResponsibilities(positionJson.get("responsibilities").toString());
			//positionRepository.createPosition(position);
			positionRepository.save(position);
		}catch(JSONException e){
			java.lang.System.out.print(e.getMessage());
		}
	}
	
	public Set<PositionNeo> getPosition(String title){
		PositionNeo position;
		Set<PositionNeo> positions;
		//option 1
/*		PositionNeo position = positionRepository.findAllByPropertyValue("title", title).single();
		java.lang.System.out.println(position.getResponsibilities());
		java.lang.System.out.print(position);*/
		
		//option 2
		positions = positionRepository.getPositionByTitle(title);
		
		return positions;
	}
	
	public void reportsToPosition(JSONObject json){
		Long parentPositionId;
		Long childPositionId;
		
		try {
			parentPositionId = Long.getLong((String)json.get("parentPositionId"));
			childPositionId = Long.getLong((String)json.get("childPositionId"));
			
			PositionNeo parentPosition = positionRepository.findOne(parentPositionId);
			PositionNeo childPosition = positionRepository.findOne(childPositionId);
			
	/*		PositionNeo parentPosition = positionRepository.getPositionByTitle((String)json.get("parentPositionTitle"));
			PositionNeo childPosition = positionRepository.getPositionByTitle((String)json.get("childPositionTitle"));
			
	*/
			positionRepository.relatePositions(childPosition, parentPosition, "REPORTS_TO");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void associatePositionToOrganization(JSONObject json){
		Long positionId;
		Long orgId;
		
		try {
			positionId = new Long(json.get("positionId").toString());
			orgId = new Long(json.get("organizationId").toString());
			
			PositionNeo position = positionRepository.findOne(positionId);
			Organization org = orgRepository.findOne(orgId);
			
	/*		PositionNeo parentPosition = positionRepository.getPositionByTitle((String)json.get("parentPositionTitle"));
			PositionNeo childPosition = positionRepository.getPositionByTitle((String)json.get("childPositionTitle"));
			
	*/
			positionRepository.associateToOrganization(position, org, "PART_OF");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void tagUser(JSONObject json){
		User user;
		try{
			JSONObject userJson = (JSONObject)json.get("user");
			String userName = userJson.get("userName").toString();
			user = userRepository.findByPropertyValue("userName", userName);

			JSONObject positionJson = (JSONObject)json.get("position");
			long positionId = Long.getLong((String)positionJson.get("positionId"));
			PositionNeo position = positionRepository.findOne(positionId);
			

			
	/*		positionRepository.
			position.setTaggedUser(user);*/
		}catch(JSONException e){
			java.lang.System.out.print(e.getMessage());
		}
	}
}
