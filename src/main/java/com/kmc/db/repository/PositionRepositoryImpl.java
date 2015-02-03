package com.kmc.db.repository;

import java.util.Set;

import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kmc.db.model.Organization;
import com.kmc.db.model.PositionNeo;
import com.kmc.db.relationship.OrganizationPositionRelation;
import com.kmc.db.relationship.Role;

@Repository
public class PositionRepositoryImpl implements PositionRepositoryCustom{
	@Autowired 
	private GraphDatabase graphDatabaseService;
	
	@Autowired 
	Neo4jTemplate neoTemplate;
	
	public void createPosition(PositionNeo position){
		//graphDatabaseService = ctx.getBean("graphDatabaseService", GraphDatabase.class);
		Transaction tx = graphDatabaseService.beginTx();
//		PositionNeo position = new PositionNeo("new title");

        try {
//        	Neo4jOperations neoTemplate = new Neo4jTemplate(graphDatabaseService);
        	neoTemplate.save(position);
        	//PositionNeo positionResult = save(position)
            tx.success();
            System.out.print("sucess");
        } catch (Exception e) {
        	tx.failure();
        	e.printStackTrace();
        } 
        finally {
            tx.finish();
        }
	}
	
	public Object getPositionGraph(){
		return null;
	}
	
	public void relatePositions(PositionNeo childPosition, PositionNeo parentPosition, String relationName){
		//Neo4jOperations neoTemplate = new Neo4jTemplate(graphDatabaseService);
		Role role = neoTemplate.createRelationshipBetween(childPosition, parentPosition, Role.class, relationName, true); // true - allowDuplicates
		//neoTemplate.save(role);
	}	
	
	public void associateToOrganization(PositionNeo position, Organization org, String relationName){
		//Neo4jOperations neoTemplate = new Neo4jTemplate(graphDatabaseService);
		neoTemplate.createRelationshipBetween(position, org, OrganizationPositionRelation.class, relationName, true); // true - allowDuplicates
		//neoTemplate.save(role);
	}
	
	public Set<PositionNeo> getManagers(PositionNeo childPosition){
		return childPosition.getParents();
	}
	
	public Set<PositionNeo> getReportees(PositionNeo parentPosition){
		return parentPosition.getChilds();
	}
}
