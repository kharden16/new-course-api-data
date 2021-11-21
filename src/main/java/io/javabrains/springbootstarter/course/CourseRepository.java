package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

	//another option is to extend JpaRepository
		//findall returns a list
	
	//get all topics
	
	//get topic by id
	
	//update topic
	
	//delete topic
	
	//add topic
	
	public List<Course> findByTopicId(String toipicId); //crud action by a column and the column of that corresponding table
	public List<Course> findByName(String name); //define crud action by filter in the course table w/ the name property
	 
}
