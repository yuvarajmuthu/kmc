package com.kmc.services;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmc.db.model.PositionNeo;
import com.kmc.db.model.User;
import com.kmc.db.repository.PositionRepository;
import com.kmc.db.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	public void createPosition(JSONObject json){
		User user = new User();
		try{
			JSONObject userJson = (JSONObject)json.get("user");
			user.setUserName(userJson.get("userName").toString());

			userRepository.save(user);
		}catch(JSONException e){
			java.lang.System.out.print(e.getMessage());
		}
	}
	
	public User getUser(String userName){
		User user;
		user = userRepository.findByPropertyValue("userName", userName);
		return user;
	}
	
	public void assignPosition(JSONObject json){
		User user;
		try{
			
			JSONArray jsonArray  = (JSONArray)json.get("input");
			
			JSONObject userJson = (JSONObject)((JSONObject)jsonArray.get(0)).get("user");
			String userName = userJson.get("userName").toString();
			user = userRepository.findByPropertyValue("userName", userName);

			JSONObject positionJson = (JSONObject)((JSONObject)jsonArray.get(1)).get("position");
			long positionId = Long.parseLong((String)positionJson.get("positionId"));
			PositionNeo position = positionRepository.findOne(positionId);

			userRepository.assignPosition(user, position, "DESIGNATION");
			
	/*		positionRepository.
			position.setTaggedUser(user);*/
		}catch(JSONException e){
			java.lang.System.out.print(e.getMessage());
		}
	}

}
