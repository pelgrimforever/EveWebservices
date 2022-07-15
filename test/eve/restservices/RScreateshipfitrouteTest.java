package eve.restservices;

import eve.logicview.View_system;
import eve.usecases.custom.Security_usecases;
import general.exception.DBException;
import general.exception.DatahandlerException;
import java.io.IOException;
import java.util.ArrayList;
import junit.framework.Assert;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class RScreateshipfitrouteTest {
    
    private String jsonpayload = "{\"auth\": \"\", \"username\": \"\",\"origin\": \"\",\"destination\": \"\"}";
    
    @Mock(name="security_usecases")
    private Security_usecases security_usecases_mock = new Security_usecases();
    
    @Spy
    @InjectMocks
    private RScreateshipfitroute rscreateshipfitroute = new RScreateshipfitroute();    
    
    public RScreateshipfitrouteTest() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        try {
            doReturn(true).when(security_usecases_mock).check_authorization(any(String.class));
        }
        catch(IOException | DatahandlerException e) {
        }
    }

    @Test
    public void rscreateshipfitroute_test() {
        try {
            ArrayList<View_system> view_systems = new ArrayList<>();
            View_system system = new View_system();
            view_systems.add(system);
            doReturn(view_systems).when(rscreateshipfitroute).calculateroute(anyString(), anyLong(), anyLong());
            String result = rscreateshipfitroute.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONArray jsonarray = (JSONArray)parser.parse(result);
            int expectedsize = 1;
            Assert.assertEquals(expectedsize, jsonarray.size());
        }
        catch(DBException | ParseException e) {
        }
    }
    
}
