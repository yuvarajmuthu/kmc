package com.kmc.db.repository;

import com.kmc.db.model.PositionNeo;
import com.kmc.db.model.User;

public interface UserRepositoryCustom {
	public void assignPosition(User user, PositionNeo position, String relationName);

}
