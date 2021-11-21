package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	 @Autowired
	 private TopicRepository tr;
	
	 /*private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
				new Topic("basic", "Basic", "Basic Development Course"),
				new Topic("fortran", "Fortran", "Fortran Development course"),
				new Topic("pascal", "Pascal", "Pascal Development Course"))); */
	 
	 public List<Topic> getAllTopics()
	 {
		 //return topics;
		 List<Topic> topics = new ArrayList<> ();
		 tr.findAll().forEach(topics::add); //method reference from Lambda Expression
		 return topics;
	 }

	 public void addTopic(Topic t)
	 {
		// topics.add(t);
		tr.save(t);
	 }
	 
	 public Topic getTopic(String id)
	 {
		/*for(Topic t: topics)
		{
			if(t.getId().equals(id))
				return t;
		}
		return null; */
		
		return tr.findById(id).orElse(null);
	 }
	 
	
	 
	 public void updateTopic(Topic t, String id)
	 {
		 /*for(int i = 0; i < topics.size(); i++)
			{
				if(topics.get(i).getId().equals(id))
					topics.set(i, t);
			}*/
		 tr.save(t);
	 }

	public void deleteTopic(String id) {
		/* for(int i = 0; i < topics.size(); i++)
			{
				if(topics.get(i).getId().equals(id))
					topics.remove(i);
			}*/
		tr.deleteById(id);
	}
}
