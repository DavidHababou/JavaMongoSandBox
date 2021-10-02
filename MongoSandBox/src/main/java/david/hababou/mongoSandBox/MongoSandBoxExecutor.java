package david.hababou.mongoSandBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoSandBoxExecutor {
	
	private static MongoTemplate tmpl;
	
	@Autowired
	public MongoSandBoxExecutor(MongoTemplate mongoTemplate) {
		tmpl = mongoTemplate;
	}
	
	static void writeElement(MongoSandBoxElement elem) {
		tmpl.insert(elem, "elems");
	}
	static void getElement(MongoSandBoxElement elem) {
		tmpl.findById(elem, null, null);
	}
}
