package eve.restservices;

import data.conversion.JSONConversion;
import db.SQLTwriter;
import db.SQLreader;
import eve.BusinessObject.service.CategoryService;
import eve.BusinessObject.service.Market_groupService;
import eve.BusinessObject.service.Markethistory;
import eve.BusinessObject.service.Markethistory.MarkethistoryStatus;
import eve.usecases.custom.Security_usecases;
import eve.usecases.custom.Downloadmarkettypes_usecase;
import general.exception.DatahandlerException;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class RSdownloadmarkettypesTest {
    
    private Market_groupService market_groupservice = new Market_groupService(new SQLreader(), new SQLTwriter());
    private CategoryService categoryservice = new CategoryService(new SQLreader(), new SQLTwriter());
    
    @Mock(name="security_usecases")
    private Security_usecases security_usecases_mock = new Security_usecases();
    
    @Mock(name="downloadmarkettypes_usecase")
    private Downloadmarkettypes_usecase downloadmarkettypes_usecase_mock = new Downloadmarkettypes_usecase();    

    @Spy
    @InjectMocks
    private RSdownloadmarkettypes rsdownloadmarkettypes = new RSdownloadmarkettypes();
    
    public RSdownloadmarkettypesTest() {
        MockitoAnnotations.initMocks(this);
        try {
            doReturn(true).when(security_usecases_mock).check_authorization(anyString());   
            doReturn(true).when(security_usecases_mock).isadmin(anyString());   
            doReturn(true).when(downloadmarkettypes_usecase_mock).isMarketgroupServiceRunning();   
        }
        catch(IOException | DatahandlerException e) {
        }
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSomeMethod() {
        try {
            doNothing().when(downloadmarkettypes_usecase_mock).processRequest(anyBoolean(), anyBoolean(), anyBoolean());   
            Market_groupService.Market_groupStatus market_groupstatus = market_groupservice.new Market_groupStatus();
            market_groupstatus.setDone();
            market_groupstatus.incMarketgroups();
            doReturn(market_groupstatus).when(downloadmarkettypes_usecase_mock).getMarketgroupStatus();  
            CategoryService.CategoryStatus categorystatus = categoryservice.new CategoryStatus();
            categorystatus.setDone();
            categorystatus.incCategories();
            categorystatus.incTypegroups();
            categorystatus.incTypegroups();
            categorystatus.incTypes();
            categorystatus.incTypes();
            categorystatus.incTypes();
            doReturn(categorystatus).when(downloadmarkettypes_usecase_mock).getCategoryStatus();  
            String jsonpayload = "{\"auth\": \"\", \"start\": false, \"stop\": false}";
            String result = rsdownloadmarkettypes.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONObject jsonmarket_groups = (JSONObject)jsonresult.get("market_groups");
            long totalmarketgroups = JSONConversion.getLong(jsonmarket_groups, "totalmarketgroups");
            Assert.assertEquals(totalmarketgroups, 1);
            long marketgroups = JSONConversion.getLong(jsonmarket_groups, "marketgroups");
            Assert.assertEquals(marketgroups, 1);
            JSONObject jsoncategories = (JSONObject)jsonresult.get("categories");
            long totalcategories = JSONConversion.getLong(jsoncategories, "totalcategories");
            Assert.assertEquals(totalcategories, 1);
            long categories = JSONConversion.getLong(jsoncategories, "categories");
            Assert.assertEquals(categories, 1);
            long totaltypegroups = JSONConversion.getLong(jsoncategories, "totaltypegroups");
            Assert.assertEquals(totaltypegroups, 1);
            long typegroups = JSONConversion.getLong(jsoncategories, "typegroups");
            Assert.assertEquals(typegroups, 2);
            long totaltypes = JSONConversion.getLong(jsoncategories, "totaltypes");
            Assert.assertEquals(totaltypes, 1);
            long types = JSONConversion.getLong(jsoncategories, "types");
            Assert.assertEquals(types, 3);
            JSONArray jsonmessages = (JSONArray)jsonresult.get("messages");
            Assert.assertEquals(jsonmessages.size(), 0);
            boolean resultdone = JSONConversion.getboolean(jsonresult, "done");
            Assert.assertEquals(resultdone, true);
            String resultstatus = JSONConversion.getString(jsonresult, "status");
            Assert.assertTrue(resultstatus.equals("OK"));
        }
        catch(ParseException e) {
        }
    }
    
}
