import as.leap.code.Response;
import as.leap.code.impl.LASJsonParser;
import as.leap.code.test.framework.TestCloudCode;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * User：poplar
 * Date：14-11-5
 */
public class MainTest extends TestCloudCode {

	public MainTest() throws Exception{
		super("http://10.10.10.193:8080");
	}

	@Test
	public void hello(){
		Map<String,Object> map = new HashMap<>();
		map.put("name","Hanmemmei");
		map.put("age",18);
		map.put("male",false);

		Map<String,Object> map2 = new HashMap<>();
		map2.put("name","Lilei");
		map2.put("age",18);
		map2.put("male",false);

		map.put("father",map2);
		String json = "{\"name\":\"jack\",\"ids\":[\"aa\",\"bb\"]}";
		Response response = runFunction("hello", json);
		if (response.succeeded()){
			System.out.println(LASJsonParser.asJson(response.getResult()));
//			Assert.assertEquals("HanMeimei", response.getResult());
		} else {
			Assert.fail(response.getError());
		}
	}

  @Test
  public void helloJob(){
		runJob("helloJob",null);
  }

	@Test
	public void helloUser(){
		Response response = runFunction("helloUser", "");
		if (response.succeeded()){
			System.out.println(LASJsonParser.asJson(response.getResult()));
//			Assert.assertEquals("HanMeimei", response.getResult());
		} else {
			Assert.fail(response.getError());
		}
	}

	@Test
	public void helloUserDelete(){
		Response response = runFunction("helloUserDelete", "");
		if (response.succeeded()){
			System.out.println(LASJsonParser.asJson(response.getResult()));
//			Assert.assertEquals("HanMeimei", response.getResult());
		} else {
			Assert.fail(response.getError());
		}
	}

	@Test
	public void helloAssist(){
		Response response = runFunction("helloAssist", "");
		if (response.succeeded()){
			System.out.println(response.getResult().toString());
		} else {
			Assert.fail(response.getError());
		}
	}

	@Test
	public void receiptTrans(){
		Response response = runFunction("receiptTransaction", "");
		if (response.succeeded()){
			System.out.println(response.getResult().toString());
		} else {
			Assert.fail(response.getError());
		}
	}

	@Test
	public void walletTrans(){
		Response response = runFunction("walletTransaction", "");
		if (response.succeeded()){
			System.out.println(response.getResult().toString());
		} else {
			Assert.fail(response.getError());
		}
	}

	@Test
	public void helloNinja(){
		String params = "{\"name\":\"鸣人\"}";
		Response response = runFunction("helloNinja",params);
		Assert.assertTrue(response.succeeded());
		Assert.assertEquals("鸣人_new", response.getResult().toString());
	}

  @Test
  public void helloCounter(){
    Response response = runFunction("helloCounter","");
    Assert.assertTrue(response.succeeded());
  }

  @Test
  public void helloPushMsg(){
    Response response = runFunction("helloPushMsg","");
    Assert.assertTrue(response.succeeded());
  }

}
