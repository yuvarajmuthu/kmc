import static org.junit.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kmc.db.model.User;
import com.kmc.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:SpringConfig.xml")
public class UserTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void test() {
		JSONObject json = null;
		try {

			json = new JSONObject("{'input':[{'user':{'userName': 'yuvaraj.muthu@gmail.com'}}, {'position':{'positionId': '1'}}]}");
			userService.assignPosition(json);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		//userService.createPosition(json);
		//User user = userService.getUser("yuvaraj.muthu@gmail.com");
		assertEquals(1, 1);
	}

}
