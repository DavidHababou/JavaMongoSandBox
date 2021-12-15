package david.hababou.sandbox.mongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import david.hababou.sandbox.model.SandBoxElement;

public class SandBoxMongoExecutor {
	
	@Autowired
	private static MongoTemplate tmpl;
	
	static void writeElement(SandBoxElement elem) {
		tmpl.insert(elem, "elems");
	}
	static void getElement(SandBoxElement elem) {
		tmpl.findById(elem, null, null);
	}
}
