package eve.restservices;

import data.conversion.JSONConversion;
import db.SQLTwriter;
import db.SQLreader;
import eve.BusinessObject.service.ContractService;
import eve.BusinessObject.service.Markethistory;
import eve.usecases.custom.Security_usecases;
import eve.usecases.custom.Downloadmarkethistory_usecase;
import general.exception.DBException;
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
public class RSdownloadmarkethistoryTest {

    private Markethistory markethistory = new Markethistory(new SQLreader(), new SQLTwriter());
    
    @Mock(name="security_usecases")
    private Security_usecases security_usecases_mock = new Security_usecases();
    
    @Mock(name="downloadmarkethistory_usecase")
    private Downloadmarkethistory_usecase downloadmarkethistory_usecase_mock = new Downloadmarkethistory_usecase();    

    @Spy
    @InjectMocks
    private RSdownloadmarkethistory rsdownloadmarkethistory = new RSdownloadmarkethistory();
    
    public RSdownloadmarkethistoryTest() {
        MockitoAnnotations.initMocks(this);
        try {
            doReturn(true).when(security_usecases_mock).check_authorization(anyString());   
            doReturn(true).when(security_usecases_mock).isadmin(anyString());   
            doReturn(true).when(downloadmarkethistory_usecase_mock).isServiceRunning();   
        }
        catch(IOException | DatahandlerException e) {
        }
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void downloadmarkethistoryTest() {
        try {
            doNothing().when(downloadmarkethistory_usecase_mock).processRequest(anyBoolean(), anyBoolean(), anyBoolean());   
            Markethistory.MarkethistoryStatus historystatus = markethistory.new MarkethistoryStatus();
            historystatus.setDone();
            historystatus.incMarkethistorylines();
            doReturn(historystatus).when(downloadmarkethistory_usecase_mock).getStatus();  
            String jsonpayload = "{\"auth\": \"\", \"start\": false, \"stop\": false}";
            String result = rsdownloadmarkethistory.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONObject jsonhistory = (JSONObject)jsonresult.get("history");
            long totalmarkethistorylines = JSONConversion.getLong(jsonhistory, "totalmarkethistorylines");
            Assert.assertEquals(totalmarkethistorylines, 1);
            long markethistorylines = JSONConversion.getLong(jsonhistory, "markethistorylines");
            Assert.assertEquals(markethistorylines, 1);
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
