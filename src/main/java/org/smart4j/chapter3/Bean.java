package org.smart4j.chapter3;

public class Bean {
private String name;
private String age;


public Bean() {
}
public Bean(String name, String age) {
	this.name = name;
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}


}
