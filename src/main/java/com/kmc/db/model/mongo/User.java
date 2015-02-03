package com.kmc.db.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

 @Id
 private String id;

 private String name;
 private int age;
  
 public User(String name, int age) {
   this.name = name;
   this.age = age;
 }
 
 public String getId() {
   return id;
 }
 public String getName() {
   return name;
 }
 public int getAge() {
   return age;
 }
 
 @Override
 public String toString() {
   return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
 }
}