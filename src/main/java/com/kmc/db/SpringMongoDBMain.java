package com.kmc.db;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.kmc.db.model.mongo.User;

public class SpringMongoDBMain{
 public static void main(String[] args) {
	  // For XML
	 try{
	  ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
	   // For Annotation
	  //ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	
	  MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
	///////////////////////////////////////////////////////////
	  User user = new User("user2", 2);
	  // save
	  mongoOperation.save(user);
	  // now user object got the created id.
	  System.out.println("1. user : " + user);
	  
	  // query to search user

	  Query searchUserQuery = new Query(Criteria.where("name").is("user1"));

	 

	  // find the saved user again.

	  User savedUser = mongoOperation.findOne(searchUserQuery, User.class);

	  System.out.println("2. find - savedUser : " + savedUser);

	 

	  // update password

	  mongoOperation.updateFirst(searchUserQuery,

	                          Update.update("age", 5),User.class);

	 

	  // find the updated user object

	  User updatedUser = mongoOperation.findOne(searchUserQuery, User.class);

	 

	  System.out.println("3. updatedUser : " + updatedUser);

	 

	  // delete

	  mongoOperation.remove(searchUserQuery, User.class);

	 

	  // List, it should be empty now.

	  List<User> listUser = mongoOperation.findAll(User.class);

	  System.out.println("4. Number of user = " + listUser.size());
	  
	 }catch(Exception e){
		 System.out.println(e.getMessage());
	 }
		 /*
		 MongoOperations mongoOps = new MongoTemplate(new Mongo(), "kmc");

		    mongoOps.insert(new User("Joe", 34));

	 }catch(Exception e){
		 System.out.println(e.getMessage());
	 }
	  */
	
	  ///////////////////////////////////////////////////////
	  /*
	  // query to search user
	  Query searchUserQuery = new Query(Criteria.where("username").is("ymuthu"));
	
	  // find the saved user again.
	  User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
	
	  System.out.println("2. find - savedUser : " + savedUser);
	
	///////////////////////////////////////////////////////////////
	
	  // update password
	  mongoOperation.updateFirst(searchUserQuery,
	
	  Update.update("password", "123test"),User.class);
	
	  // find the updated user object
	
	  User updatedUser = mongoOperation.findOne(searchUserQuery, User.class);
	
	  System.out.println("3. updatedUser : " + updatedUser);
	
	/////////////////////////////////////////////////////////////////////////// 
	
	  // delete
	  mongoOperation.remove(searchUserQuery, User.class);
	  // List, it should be empty now.
	
	  List<User> listUser = mongoOperation.findAll(User.class);
	
	  System.out.println("4. Number of user = " + listUser.size());
	  */

  }

}