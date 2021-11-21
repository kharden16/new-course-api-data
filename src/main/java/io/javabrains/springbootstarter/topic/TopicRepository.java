package io.javabrains.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

	//another option is to extend JpaRepository
		//findall returns a list
	
	//get all topics
	
	//get topic by id
	
	//update topic
	
	//delete topic
	
	//add topic
	 
}
