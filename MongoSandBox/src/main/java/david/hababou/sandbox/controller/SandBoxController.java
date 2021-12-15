package david.hababou.sandbox.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.admin.DeleteTopicsOptions;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import david.hababou.sandbox.model.SandBoxElement;
@RestController
public class SandBoxController {
	                  
	@Autowired
	MongoTemplate mngtmpl;
	@Autowired
	KafkaTemplate<String, SandBoxElement> kfktmpl;
	@Autowired
	KafkaAdmin kfkadm;
	@Autowired
	KafkaAdminClient kfkadmclnt;
	
	@GetMapping("/mongodemo/{collection}/{id}")
	public List<SandBoxElement> getFromMongo(@PathVariable String collection, @PathVariable String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return (List<SandBoxElement>)mngtmpl.find(query, SandBoxElement.class, collection);
		//MongoCollection<Document> mngCol = tmpl.getCollection(collection);
		//return (List<MongoSandBoxElement>)mngCol.find(com.mongodb.client.model.Filters.eq("id",id);
	}
	@PostMapping("/mongodemo")
	public void PostToMongo(@RequestBody SandBoxElement body) {
		mngtmpl.insert(body);
	}
	@PostMapping("/kafkatopics/{topic}")
	public void PostTopicToKafka(@PathVariable String topic) {
		kfkadm.createOrModifyTopics(new NewTopic(topic,
				1, (short)1));
	}
	@DeleteMapping("/kafkatopics/{topic}")
	public void DeleteTopic(@PathVariable String topic) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(topic);
		kfkadmclnt.deleteTopics(arr);
	}
	@PostMapping("/kafka/{topic}")
	public void PostToKafka(@PathVariable String topic, @RequestBody SandBoxElement body) {
		kfktmpl.send(topic, "1", body);
	}
}
