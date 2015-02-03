import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.Assert;

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
import com.kmc.db.model.User;
import com.kmc.db.repository.OrganizationRepository;
import com.kmc.db.repository.PositionRepository;
import com.kmc.services.PositionService;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:SpringConfig.xml")*/
public class PositionNeoTest extends AbstractTest{
	@Autowired
	private PositionService positionService;
	
	
	@Autowired
	private PositionRepository positionRepository;
	
	
	@Autowired
	private OrganizationRepository orgRepository;
	
	@Test
	public void testPositionExistence(){
		PositionNeo positionNeo;
		try{
		//PositionNeo positionNeo = positionRepository.findByPropertyValue("name", "kmc");
			Set<PositionNeo> positionList = positionRepository.getPositionByTitle("CEO11");
		//EndResult<PositionNeo> positionList= positionRepository.findAll();
		Iterator itre = positionList.iterator();
		while(itre.hasNext()){
			positionNeo = (PositionNeo)itre.next();
			System.out.println(positionNeo.get_type_() +  positionNeo.getId());
		}
		}catch(Exception e){
			System.out.print(e.getMessage());
		}

		
		/*PositionNeo position = positionRepository.findOne(24L);
		System.out.print(position.get_type_());*/
	}
/*	@Test
	public void test() {

		JSONObject json = null;
		try {
			json = new JSONObject("{'position':{'title': 'CEO', 'responsibilities' : 'Grow the organization'}}");

		} catch (JSONException e) {
			e.printStackTrace();
		}

		PositionNeo position = positionRepository.findOne(1L);
		Set<User> users = position.getTaggedUser();

		assertEquals("yuvaraj.muthu@gmail.com", ((User)users.toArray()[0]).getUserName());


	}
*/	
/*	@Test
	public void associateToOrg() {

		JSONObject json = null;
		try {

			json = new JSONObject("{'positionId': '2', 'organizationId': '9'}");
			positionService.associatePositionToOrganization(json);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		assertEquals(1, 1);
	}*/

}
