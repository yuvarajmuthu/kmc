package com.kmc.db.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kmc.db.model.PositionNeo;
import com.kmc.db.relationship.Role;


public interface PositionRepository extends GraphRepository<PositionNeo>, PositionRepositoryCustom {
	
	//@Query("start position=node:PositionNeo(title={0}) return position")
	//@Query("MATCH (position:PositionNeo { title:{0} }) where has(position.__type__) RETURN position")
	//@Query("START n=node(9) RETURN n")
	@Query("START user=node:__types__(className='com.kmc.db.model.PositionNeo') WHERE user.title = {0} RETURN user")
	Set<PositionNeo> getPositionByTitle(String title);
}