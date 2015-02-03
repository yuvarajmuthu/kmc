import static org.junit.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.neo4j.core.GraphDatabase;

import com.kmc.db.repository.PositionRepository;
import com.kmc.db.repository.PositionRepositoryImpl;
import com.kmc.services.PositionService;


public class PositionTest {

	
	//static GenericXmlApplicationContext ctx;
//	@Autowired
//	PositionService positionService;
	private static GraphDatabase graphDatabaseService;

	private static PositionService positionService;
	
	@BeforeClass
    public static void testSetup() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
	    ctx.load("classpath:SpringConfig.xml");
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");
//		AutowireCapableBeanFactory acbFactory = ctx.getAutowireCapableBeanFactory();
//	    acbFactory.autowireBean(PositionTest.class);
//	    
//	    ctx = new GenericXmlApplicationContext();
//	    ctx.load("classpath:SpringConfig.xml");
	    
        //ctx.refresh();
	    graphDatabaseService = ctx.getBean("graphDatabaseService", GraphDatabase.class);
	    positionService = ctx.getBean("positionService", PositionService.class);

	    //
//        positionRepository = ctx.getBean("positionRepository123", PositionRepositoryImpl.class); 
      
	}
	
	@Test
	public void testCreatePosition() {
		JSONObject json = null;
		try {
//			json = new JSONObject("{'parentPosition':{'title': 'CEO', 'responsibilities' : 'Grow the organization'}, " +
//					"'childPosition':{'title': 'VP of sales', 'responsibilities' : 'head of sales department'}}");
			json = new JSONObject("{'position':{'title': 'CEO', 'responsibilities' : 'Grow the organization'}}");

		} catch (JSONException e) {
			e.printStackTrace();
		}
		positionService.createPosition(json);
		fail("Not yet implemented");
	}

}
