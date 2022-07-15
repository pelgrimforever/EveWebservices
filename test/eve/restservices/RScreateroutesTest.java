package eve.restservices;

import eve.usecases.custom.Loadroute_parameters;
import eve.usecases.custom.Loadroute_usecases;
import general.exception.DBException;
import java.util.ArrayList;
import junit.framework.Assert;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;

/**
 * @author Franky Laseure
 */
public class RScreateroutesTest {
    
    //30000044 -> Faspera
    //30005310 -> Scheenins
    private String jsonpayload = "{\"origin\": \"30002512\",\"destination\": \"30002507\",\"viasystems\": [\"0\"],\"avoidsystems\": [\"1\", \"2\"],\"secure\": true}";

    @Mock(name="loadroute_usecases")
    Loadroute_usecases loadroute_usecases_mock = new Loadroute_usecases();
    
    @InjectMocks
    private RScreateroutes rscreateroutes = new RScreateroutes();    
    
    public RScreateroutesTest() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ArrayList<eve.logicentity.System> systems = new ArrayList<eve.logicentity.System>();
        eve.logicentity.System system = new eve.logicentity.System();
        systems.add(system);
        system = new eve.logicentity.System();
        systems.add(system);
        try {
            doReturn(systems).when(loadroute_usecases_mock).Loadroute_localservice_usecase(any(Loadroute_parameters.class));
        }
        catch(DBException e) {
        }
    }

    @Test
    public void findroute_test() {
        try {
            String result = rscreateroutes.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONArray jsonarray = (JSONArray)parser.parse(result);
            int expectedsize = 2;
            Assert.assertEquals(expectedsize, jsonarray.size());
        }
        catch(ParseException e) {
        }
    }
    
}
