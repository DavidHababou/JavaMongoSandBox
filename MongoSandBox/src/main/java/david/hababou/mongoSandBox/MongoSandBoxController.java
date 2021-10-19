package david.hababou.mongoSandBox;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mongodb.client.MongoCollection;

@RestController
public class MongoSandBoxController {
	
	@Autowired
	MongoTemplate tmpl;
	
	@GetMapping("/mongodemo/{param1}")
	public List<MongoSandBoxElement> getDemo(@PathVariable String collection, @PathVariable String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return (List<MongoSandBoxElement>)tmpl.find(query, MongoSandBoxElement.class);
		//MongoCollection<Document> mngCol = tmpl.getCollection(collection);
		//return (List<MongoSandBoxElement>)mngCol.find(com.mongodb.client.model.Filters.eq("id",id);
	}
	@PostMapping("/mongodemo")
	public void PostDemo(@RequestBody MongoSandBoxElement body) {
		tmpl.insert(body);
	}
}