package david.hababou.mongoSandBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

@Configuration
public class MongoSandBoxConfiguration {
	@Autowired
	MongoClient mongoClient;
	 @Bean
	 public MongoClient mongoClient() {
		 return MongoClients.create("mongodb+srv://demongo:d4Rz9SSTRblTCctu@cluster0.zmzme.mongodb.net/demo?retryWrites=true&w=majority");
	 }

	 @Bean
	 public MongoTemplate mongoTemplate() throws Exception {
	     MongoTemplate ret = new MongoTemplate(mongoClient, "demo");
		 return ret;
	 }
}
