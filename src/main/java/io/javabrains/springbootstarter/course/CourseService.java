package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.topic.Topic;

@Service
public class CourseService {

	 @Autowired
	 private CourseRepository cr;
	 
	 public List<Course> getAllCourses(String topicId)
	 {
		 List<Course> courses = new ArrayList<> ();
		 cr.findByTopicId(topicId).forEach(courses::add); //method reference from Lambda Expression
		 return courses;
	 }

	 public void addCourse(Course c)
	 {
		 
		 cr.save(c);
	 }
	 
	 public Course getCourse(String id)
	 {
		
		return cr.findById(id).orElse(null);
	 }
	 
	 public void updateCourse(Course c)
	 {
		 cr.save(c);
	 }

	public void deleteCourse(String id) 
	{
		 
		cr.deleteById(id);
	}

	public void addCourse(Course c, Topic t) {
		// TODO Auto-generated method stub
		c.setTopic(t);
		cr.save(c);
	}
}

/*    
 * [
    {
        "id": "java",
        "name": "Java",
        "description": "Java Topic"
    },
    {
        "id": "javaScript",
        "name": "Java Script",
        "description": "JavaScript Topic"
    }
]
*/

/*    {
"id": "java-streams",
"name": "Java Streams",
"description": "Java Streams Course Description"
}*/