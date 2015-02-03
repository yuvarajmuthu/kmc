import static org.junit.Assert.fail;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.test.TestGraphDatabaseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.kmc.db.model.Organization;
import com.kmc.db.model.PositionNeo;
import com.kmc.db.repository.OrganizationRepository;
import com.kmc.services.OrganizationService;
import com.kmc.services.PositionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:SpringConfig.xml")
public class OrganizationTest {

	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private OrganizationRepository orgRepo;
	
	@Test
	public void testOrgExistence(){
		try{
		//Organization org = orgRepo.findByPropertyValue("name", "kmc");
		EndResult<Organization> orgList= orgRepo.findAll();
		Iterator itre = orgList.iterator();
		while(itre.hasNext()){
			System.out.print(((Organization)itre.next()).getName());
		}
		}catch(Exception e){
			System.out.print(e.getMessage());
		}

	}
	
	
	@Test
	public void testCreateOrganization() {

		JSONObject json = null;
		Organization org;
		try {
//			json = new JSONObject("{'parentPosition':{'title': 'CEO', 'responsibilities' : 'Grow the organization'}, " +
//					"'childPosition':{'title': 'VP of sales', 'responsibilities' : 'head of sales department'}}");
			json = new JSONObject("{'organization':{'name': 'kmc', 'foundedDate' : '1369024659000', 'location':'India'}}");

		} catch (JSONException e) {
			e.printStackTrace();
		}
		//positionService.createPosition(json);
		//positionService.getPosition("CEO");
		organizationService.createOrganization(json);
	}
}
