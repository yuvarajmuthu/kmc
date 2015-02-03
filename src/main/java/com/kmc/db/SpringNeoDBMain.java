package com.kmc.db;

import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.support.Neo4jTemplate;
//import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.data.neo4j.template.Neo4jOperations;

import com.kmc.db.model.PositionNeo;
import com.kmc.db.repository.PositionRepository;
import com.kmc.server.context.KMCApplicationContext;

//import com.kmc.db.repository.PositionRepository;

public class SpringNeoDBMain {
//	@Autowired Neo4jTemplate neoTemplate;
	@Autowired 
	PositionRepository positionRepository;
	
	@Autowired 
	GraphDatabase graphDatabaseService;
	
	private ApplicationContext ctx;
	public ApplicationContext getCtx() {
		return ctx;
	}

	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}

	//GraphDatabaseService
	/**
	 * @param args
	 */
	public SpringNeoDBMain(){
		setCtx(KMCApplicationContext.getInstance());
		   // For Annotation
		  //ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		AutowireCapableBeanFactory acbFactory = getCtx().getAutowireCapableBeanFactory();
	    acbFactory.autowireBean(this);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  //ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
//		ApplicationContext ctx = KMCApplicationContext.getInstance();
//		   // For Annotation
//		  //ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
//		AutowireCapableBeanFactory acbFactory = ctx.getAutowireCapableBeanFactory();
//	    acbFactory.autowireBean(this);
		SpringNeoDBMain springNeoDBMain = new SpringNeoDBMain();
		  
//		  GraphDatabase graphDatabase = (GraphDatabase) springNeoDBMain.getCtx().getBean("graphDatabaseService");
//		  Neo4jOperations neoTemplate = new Neo4jTemplate(graphDatabase);
//		  
//		  
//		  GraphRepository<PositionNeo> positionRepository = neoTemplate.repositoryFor(PositionNeo.class);

		springNeoDBMain.doAction();        
	}
	
	private void doAction(){
		Transaction tx = graphDatabaseService.beginTx();
		PositionNeo position = new PositionNeo("new title");
		//PositionNeo position = new PositionNeo(new Long(12345), "Software Engineer");
//		position.setId(new Long(1234));
//		position.setTitle("CEO of KMC");
        try {
        	//neoTemplate.save(position);
        	PositionNeo positionResult = positionRepository.save(position);//.findByPropertyValue("title", "CEO of KMC");
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
	

}
