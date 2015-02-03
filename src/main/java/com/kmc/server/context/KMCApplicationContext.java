package com.kmc.server.context;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class KMCApplicationContext {
	static GenericXmlApplicationContext ctx = null;
	
	public static GenericXmlApplicationContext getInstance(){
		if(ctx == null)  
			ctx = new GenericXmlApplicationContext("SpringConfig.xml");
		
		return ctx;

	}
}
