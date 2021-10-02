package david.hababou.mongoSandBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoSandBoxController {
	
	@Autowired
	MongoTemplate tmpl;
	
	@GetMapping("/demo/{param1}")
	public String getDemo(@PathVariable MongoSandBoxElement param1) {
		return "Hello ";
	}
	@PostMapping("/demo")
	public void PostDemo(@RequestBody MongoSandBoxElement body) {
		tmpl.insert(body);
	}
}
