package eve.restservices;

import data.conversion.JSONConversion;
import db.SQLTwriter;
import db.SQLreader;
import eve.BusinessObject.service.MarketService;
import eve.logicentity.Region;
import eve.usecases.Frontendpage_auth_usecases;
import eve.usecases.custom.Security_usecases;
import eve.usecases.custom.Downloadmarket_usecase;
import general.exception.DBException;
import general.exception.DatahandlerException;
import java.io.IOException;
import java.util.ArrayList;
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
public class RSdownloadswaggerTest {
    
    private MarketService marketservice = new MarketService(new SQLreader(), new SQLTwriter(), "");
    
    @Mock(name="security_usecases")
    private Security_usecases security_usecases_mock = new Security_usecases();

    @Mock(name="frontendpage_auth_usecases")
    private Frontendpage_auth_usecases frontendpage_auth_usecases_mock = new Frontendpage_auth_usecases();

    @Mock(name="downloadmarket_usecase")
    private Downloadmarket_usecase downloadmarket_usecase_mock = new Downloadmarket_usecase();
    
    @Spy
    @InjectMocks
    private RSdownloadswagger rsdownloadswagger = new RSdownloadswagger();
    
    public RSdownloadswaggerTest() {
        MockitoAnnotations.initMocks(this);
        try {
            doReturn(true).when(security_usecases_mock).check_authorization(anyString());   
            doReturn(true).when(security_usecases_mock).isadmin(anyString());   
            doReturn(true).when(downloadmarket_usecase_mock).isServiceRunning();   
            doReturn(true).when(rsdownloadswagger).isauthorized();   
            doNothing().when(downloadmarket_usecase_mock).resetMarket();   
        }
        catch(DBException | IOException | DatahandlerException e) {
        }
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void downloadswaggerTest() {
        try {
            doNothing().when(downloadmarket_usecase_mock).processRequest(anyBoolean(), anyString(), anyBoolean(), anyBoolean());   
            ArrayList<Region> regionsarray = new ArrayList();
            MarketService.MarketStatus marketstatus = marketservice.new MarketStatus(regionsarray);
            marketstatus.setDone();
            doReturn(marketstatus).when(downloadmarket_usecase_mock).getStatus();  
            String jsonpayload = "{\"auth\": \"\", \"start\": false, \"stop\": false}";
            String result = rsdownloadswagger.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONArray jsonregions = (JSONArray)jsonresult.get("regions");
            Assert.assertEquals(jsonregions.size(), 0);
            JSONArray jsonmessages = (JSONArray)jsonresult.get("messages");
            Assert.assertEquals(jsonmessages.size(), 0);
            boolean resultdone = JSONConversion.getboolean(jsonresult, "done");
            Assert.assertEquals(resultdone, true);
            String resultstatus = JSONConversion.getString(jsonresult, "status");
            Assert.assertTrue(resultstatus.equals("OK"));
        }
        catch(DBException | ParseException e) {
        }
    }
    
}
