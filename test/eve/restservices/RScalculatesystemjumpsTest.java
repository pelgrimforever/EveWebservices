package eve.restservices;

import data.conversion.JSONConversion;
import db.SQLTwriter;
import db.SQLreader;
import eve.BusinessObject.service.SystemjumpsService;
import eve.usecases.custom.Security_usecases;
import eve.usecases.custom.Calculatesystemjumps_usecase;
import general.exception.DatahandlerException;
import java.io.IOException;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;

/**
 * @author Franky Laseure
 */
public class RScalculatesystemjumpsTest {
    
    private SystemjumpsService systemjumpsservice = new SystemjumpsService(new SQLreader(), new SQLTwriter());
    
    @Mock(name="security_usecases")
    private Security_usecases security_usecases_mock = new Security_usecases();

    @Mock(name="calculatesystemjumps_usecase")
    private Calculatesystemjumps_usecase calculatesystemjumps_usecase_mock = new Calculatesystemjumps_usecase();

    @InjectMocks
    private RScalculatesystemjumps rscalculatesystemjumps = new RScalculatesystemjumps();
    
    public RScalculatesystemjumpsTest() {
        MockitoAnnotations.initMocks(this);
        try {
            doReturn(true).when(security_usecases_mock).check_authorization(anyString());   
        }
        catch(IOException | DatahandlerException e) {
        }
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_service() {
        doNothing().when(calculatesystemjumps_usecase_mock).processRequest(anyBoolean(), anyBoolean(), anyBoolean());  
        doReturn(true).when(calculatesystemjumps_usecase_mock).isServiceRunning();  
        SystemjumpsService.SystemjumpsStatus systemjumpsstatus = systemjumpsservice.new SystemjumpsStatus();
        doReturn(systemjumpsstatus).when(calculatesystemjumps_usecase_mock).getStatus();  
        String jsonpayload = "{\"auth\": \"\", \"start\": false, \"stop\": false}";
        try {
            String result = rscalculatesystemjumps.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONObject jsoncalcjump = (JSONObject)jsonresult.get("calcjump");
            long totalcombinations = JSONConversion.getLong(jsoncalcjump, "totalcombinations");
            long expectedtotalcombinations = 1;
            Assert.assertEquals(totalcombinations, expectedtotalcombinations);
            long combinations = JSONConversion.getLong(jsoncalcjump, "combinations");
            long expectedcombinations = 0;
            boolean done = JSONConversion.getboolean(jsoncalcjump, "done");
            boolean expecteddone = false;
            Assert.assertEquals(done, expecteddone);
        }
        catch(ParseException e) {
        }
    }
    
    @Test
    public void test_service_done() {
        doNothing().when(calculatesystemjumps_usecase_mock).processRequest(anyBoolean(), anyBoolean(), anyBoolean());  
        doReturn(true).when(calculatesystemjumps_usecase_mock).isServiceRunning();  
        SystemjumpsService.SystemjumpsStatus systemjumpsstatus = systemjumpsservice.new SystemjumpsStatus();
        systemjumpsstatus.setDone();
        systemjumpsstatus.incCombinations();
        doReturn(systemjumpsstatus).when(calculatesystemjumps_usecase_mock).getStatus();  
        String jsonpayload = "{\"auth\": \"\", "
                + "\"start\": false, \"stop\": false}";
        try {
            String result = rscalculatesystemjumps.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONObject jsoncalcjump = (JSONObject)jsonresult.get("calcjump");
            long totalcombinations = JSONConversion.getLong(jsoncalcjump, "totalcombinations");
            long expectedtotalcombinations = 1;
            Assert.assertEquals(totalcombinations, expectedtotalcombinations);
            long combinations = JSONConversion.getLong(jsoncalcjump, "combinations");
            long expectedcombinations = 1;
            boolean done = JSONConversion.getboolean(jsoncalcjump, "done");
            boolean expecteddone = true;
            Assert.assertEquals(done, expecteddone);
        }
        catch(ParseException e) {
        }
    }
    
}
