package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;
import io.javabrains.springbootstarter.topic.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics/{id}/courses")//will get courses associated with a particular topic
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/topics/{topicId}/courses") 
	public void addCourse(@RequestBody Course c, @PathVariable String topicId)
	{
		Topic t = topicService.getTopic(topicId);
		c.setTopic(t);
		courseService.addCourse(c, t);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course c, @PathVariable String topicId, @PathVariable String courseId)
	{
		Topic t = topicService.getTopic(topicId);
		c.setTopic(t);
		courseService.updateCourse(c);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/topics/{id}/courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId)
	{
		courseService.deleteCourse(courseId);
	}
}