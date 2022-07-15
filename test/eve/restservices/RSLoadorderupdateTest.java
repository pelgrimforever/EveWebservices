package eve.restservices;

import eve.usecases.Orders_usecases;
import eve.usecases.Orders_usecases.Orderupdate_data;
import eve.usecases.custom.Security_usecases;
import general.exception.CustomException;
import general.exception.DatahandlerException;
import java.io.IOException;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class RSLoadorderupdateTest {
    
    public RSLoadorderupdateTest() {
    }
    
    private String jsonpayload = "\"auth\": \"\", \"sellorderid\": \"0\", \"buyorderid\": \"1\"";
    
    @Mock(name="orders_usecases")
    private Orders_usecases orders_usecases_mock = new Orders_usecases(true);
    
    @Mock(name="security_usecases")
    private Security_usecases security_usecases_mock = new Security_usecases();
    
    @Spy
    @InjectMocks
    private RSLoadorderupdate rsloadorderupdate = new RSLoadorderupdate();    
    
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
    public void post_emptyString_ParseException() {
        String result = rsloadorderupdate.post("");
        Assert.assertEquals(result, "{\"status\":null}");
    }
    
    @Test
    public void post_ParseException() {
        try {
            Orderupdate_data orderupdate_data = orders_usecases_mock.new Orderupdate_data();
            orderupdate_data.setBuyamount(1);
            orderupdate_data.setSellamount(2);
            doReturn(orderupdate_data).when(rsloadorderupdate).getSwaggerupdate(any(Orders_usecases.class), any(JSONObject.class));
            String result = rsloadorderupdate.post("{" + jsonpayload + "}");
            String expectedresult = "{\"buyamount\":1,\"sellamount\":2}";
            Assert.assertEquals(result, expectedresult);
        }
        catch(CustomException e) {
        }
    }
}
