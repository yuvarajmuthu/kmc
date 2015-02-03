package com.kmc.services;

import org.json.JSONObject;

import com.kmc.db.model.User;


public interface UserService {
	public void createPosition(JSONObject json);
	public User getUser(String userName);
	public void assignPosition(JSONObject json);
}
