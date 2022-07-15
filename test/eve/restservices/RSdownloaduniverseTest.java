package eve.restservices;

import data.conversion.JSONConversion;
import db.SQLTwriter;
import db.SQLreader;
import eve.BusinessObject.service.UniverseService;
import eve.BusinessObject.service.UniverseService.UniverseStatus;
import eve.logicentity.Region;
import eve.usecases.custom.Security_usecases;
import eve.usecases.custom.Downloaduniverse_usecase;
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
public class RSdownloaduniverseTest {
    
    private UniverseService universeservice = new UniverseService(new SQLreader(), new SQLTwriter());
    
    @Mock(name="security_usecases")
    private Security_usecases security_usecases_mock = new Security_usecases();

    @Mock(name="downloaduniverse_usecase")
    private Downloaduniverse_usecase downloaduniverse_usecase_mock = new Downloaduniverse_usecase();
    
    @Spy
    @InjectMocks
    private RSdownloaduniverse rsdownloaduniverse = new RSdownloaduniverse();
    
    public RSdownloaduniverseTest() {
        MockitoAnnotations.initMocks(this);
        try {
            doReturn(true).when(security_usecases_mock).check_authorization(anyString());   
            doReturn(true).when(security_usecases_mock).isadmin(anyString());   
            doReturn(true).when(downloaduniverse_usecase_mock).isServiceRunning();   
        }
        catch(IOException | DatahandlerException e) {
        }
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void downloaduniverseTest() {
        try {
            doNothing().when(downloaduniverse_usecase_mock).processRequest(anyBoolean(), anyBoolean(), anyBoolean());   
            UniverseService.UniverseStatus universestatus = universeservice.new UniverseStatus();
            universestatus.setDone();
            universestatus.incAlliances();
            universestatus.incConstellations();
            universestatus.incConstellations();
            universestatus.incCorporations();
            universestatus.incCorporations();
            universestatus.incCorporations();
            universestatus.incGraphics();
            universestatus.incGraphics();
            universestatus.incGraphics();
            universestatus.incGraphics();
            universestatus.incRaces();
            universestatus.incRaces();
            universestatus.incRaces();
            universestatus.incRaces();
            universestatus.incRaces();
            universestatus.incStargates();
            universestatus.incStargates();
            universestatus.incStargates();
            universestatus.incStargates();
            universestatus.incStargates();
            universestatus.incStargates();
            universestatus.incStations();
            universestatus.incStations();
            universestatus.incStations();
            universestatus.incStations();
            universestatus.incStations();
            universestatus.incStations();
            universestatus.incStations();
            universestatus.incSystems();
            universestatus.incSystems();
            universestatus.incSystems();
            universestatus.incSystems();
            universestatus.incSystems();
            universestatus.incSystems();
            universestatus.incSystems();
            universestatus.incSystems();
            doReturn(universestatus).when(downloaduniverse_usecase_mock).getStatus();  
            String jsonpayload = "{\"auth\": \"\", \"start\": false, \"stop\": false}";
            String result = rsdownloaduniverse.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONObject jsonuniverse = (JSONObject)jsonresult.get("universe");
            long totalgraphics = JSONConversion.getLong(jsonuniverse, "totalgraphics");
            Assert.assertEquals(totalgraphics, 1);
            long totalraces = JSONConversion.getLong(jsonuniverse, "totalraces");
            Assert.assertEquals(totalraces, 1);
            long totalsystems = JSONConversion.getLong(jsonuniverse, "totalsystems");
            Assert.assertEquals(totalsystems, 1);
            long totalconstellations = JSONConversion.getLong(jsonuniverse, "totalconstellations");
            Assert.assertEquals(totalconstellations, 1);
            long totalstations = JSONConversion.getLong(jsonuniverse, "totalstations");
            Assert.assertEquals(totalstations, 1);
            long totalstargates = JSONConversion.getLong(jsonuniverse, "totalstargates");
            Assert.assertEquals(totalstargates, 1);
            long totalcorporations = JSONConversion.getLong(jsonuniverse, "totalcorporations");
            Assert.assertEquals(totalcorporations, 1);
            long totalalliances = JSONConversion.getLong(jsonuniverse, "totalalliances");
            Assert.assertEquals(totalalliances, 1);
            
            long alliances = JSONConversion.getLong(jsonuniverse, "alliances");
            Assert.assertEquals(alliances, 1);
            long constellations = JSONConversion.getLong(jsonuniverse, "constellations");
            Assert.assertEquals(constellations, 2);
            long corporations = JSONConversion.getLong(jsonuniverse, "corporations");
            Assert.assertEquals(corporations, 3);
            long graphics = JSONConversion.getLong(jsonuniverse, "graphics");
            Assert.assertEquals(graphics, 4);
            long races = JSONConversion.getLong(jsonuniverse, "races");
            Assert.assertEquals(races, 5);
            long stargates = JSONConversion.getLong(jsonuniverse, "stargates");
            Assert.assertEquals(stargates, 6);
            long stations = JSONConversion.getLong(jsonuniverse, "stations");
            Assert.assertEquals(stations, 7);
            long systems = JSONConversion.getLong(jsonuniverse, "systems");
            Assert.assertEquals(systems, 8);

            boolean resultdone = JSONConversion.getboolean(jsonresult, "done");
            Assert.assertEquals(resultdone, true);
            String resultstatus = JSONConversion.getString(jsonresult, "status");
            Assert.assertTrue(resultstatus.equals("OK"));
        }
        catch(ParseException e) {
        }
    }
    
}
