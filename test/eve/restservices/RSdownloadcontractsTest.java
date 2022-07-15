package eve.restservices;

import data.conversion.JSONConversion;
import db.SQLTwriter;
import db.SQLreader;
import eve.BusinessObject.service.ContractService;
import eve.BusinessObject.service.ContractService.ContractStatus;
import eve.usecases.Frontendpage_auth_usecases;
import eve.usecases.custom.Security_usecases;
import eve.usecases.custom.Downloadcontracts_usecase;
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
public class RSdownloadcontractsTest {
    
    private ContractService contractService = new ContractService("", new SQLreader(), new SQLTwriter());
    
    @Mock(name="security_usecases")
    private Security_usecases security_usecases_mock = new Security_usecases();

    @Mock(name="frontendpage_auth_usecases")
    private Frontendpage_auth_usecases frontendpage_auth_usecases_mock = new Frontendpage_auth_usecases();

    @Mock(name="downloadcontracts_usecase")
    private Downloadcontracts_usecase downloadcontracts_usecase_mock = new Downloadcontracts_usecase();
    
    @Spy
    @InjectMocks
    private RSdownloadcontracts rsdownloadcontracts = new RSdownloadcontracts();
    
    public RSdownloadcontractsTest() {
        MockitoAnnotations.initMocks(this);
        try {
            doReturn(true).when(security_usecases_mock).check_authorization(anyString());   
            doReturn(true).when(security_usecases_mock).isadmin(anyString());   
            doReturn(true).when(downloadcontracts_usecase_mock).isServiceRunning();   
            doReturn(true).when(rsdownloadcontracts).isauthorized();   
        }
        catch(DBException | IOException | DatahandlerException e) {
        }
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void downloadcontractsTest() {
        try {
            doNothing().when(downloadcontracts_usecase_mock).processRequest(anyBoolean(), anyString(), anyBoolean(), anyBoolean());   
            ContractService.ContractStatus contractstatus = contractService.new ContractStatus();
            contractstatus.setDone();
            doReturn(contractstatus).when(downloadcontracts_usecase_mock).getStatus();  
            String jsonpayload = "{\"auth\": \"\", \"start\": false, \"stop\": false}";
            String result = rsdownloadcontracts.post(jsonpayload);
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
        catch(ParseException e) {
        }
    }
    
}
