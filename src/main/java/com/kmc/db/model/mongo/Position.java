package com.kmc.db.model.mongo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "position")
public class Position {
	
	@Id
	private String id;
	private String name;
	private String[] parent;
	private String[] children;
	private String[] ancestors;
	private String path;
	private String[] peers;
	private int depthLevel;
	private String[] followers;
	private String associatedStructureID;
	private String taggedUserID;
	private Date creationTimestamp;
	private Date lastModifiedTimestamp;
	
}
