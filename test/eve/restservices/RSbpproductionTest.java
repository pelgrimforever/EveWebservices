package eve.restservices;

import data.conversion.JSONConversion;
import eve.logicview.View_userbp;
import eve.logicview.View_userbpmaterial;
import eve.usecases.custom.Security_usecases;
import general.exception.DBException;
import general.exception.DatahandlerException;
import java.io.IOException;
import java.util.ArrayList;
import junit.framework.Assert;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class RSbpproductionTest {
    
    private View_userbpmaterial material1 = new View_userbpmaterial();
    private View_userbpmaterial material2 = new View_userbpmaterial();
    
    @Mock(name="security_usecases")
    private Security_usecases security_usecases_mock = new Security_usecases();

    @Spy
    @InjectMocks
    private RSbpproduction rsbpproduction = new RSbpproduction();
    
    public RSbpproductionTest() {
        material1.setAmount(5);
        material1.setBp(0);
        material1.setMarketaverage(250);
        material1.setMaterial(9990);
        material1.setMaterialinputaverage(0);
        material2.setAmount(2);
        material2.setBp(0);
        material2.setMarketaverage(6000);
        material2.setMaterial(9991);
        material2.setMaterialinputaverage(5500);
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        try {
            doReturn(true).when(security_usecases_mock).check_authorization(anyString());   
        }
        catch(IOException | DatahandlerException e) {
        }
    }

    @Test
    public void calculate_productionprice_with_no_materials() {
        try {
            ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
            doReturn(view_userbpmaterials).when(rsbpproduction).find_user_materials_for_blueprint(any(View_userbp.class));  
            String jsonpayload = "{\"auth\": \"\", \"viewuserbp\": "
                    + "{\"blueprintname\": \"test\", \"typegroupname\": \"test\", "
                    + "\"amountproduced\": 0, \"bp\": \"0\", \"bpprice\": \"1000000\", "
                    + "\"materialefficiency\": 0, \"original\": true, "
                    + "\"researchcost\": \"0\", \"serialnumber\": 0, "
                    + "\"stationfee\": \"200\", \"totalamount\": 0, "
                    + "\"username\": \"test\"}}";
            String result = rsbpproduction.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONArray jsonarray_material = (JSONArray)jsonresult.get("material");
            double totalprice_market = JSONConversion.getDouble(jsonresult, "totalprice_market");
            double totalprice_user = JSONConversion.getDouble(jsonresult, "totalprice_user");
            int expectedsize = 0;
            Assert.assertEquals(expectedsize, jsonarray_material.size());
            double expectedmarketprice = 200;
            Assert.assertEquals(totalprice_market, expectedmarketprice);
            double expecteduserprice = 200;
            Assert.assertEquals(totalprice_user, expecteduserprice);
        }
        catch(DBException | DatahandlerException | ParseException e) {
        }
    }
    
    @Test
    public void calculate_productionprice_with_1_material_no_userprice() {
        try {
            ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
            view_userbpmaterials.add(material1);
            doReturn(view_userbpmaterials).when(rsbpproduction).find_user_materials_for_blueprint(any(View_userbp.class));  
            String jsonpayload = "{\"auth\": \"\", \"viewuserbp\": "
                    + "{\"blueprintname\": \"test\", \"typegroupname\": \"test\", "
                    + "\"amountproduced\": 0, \"bp\": \"0\", \"bpprice\": \"1000000\", "
                    + "\"materialefficiency\": 0, \"original\": true, "
                    + "\"researchcost\": \"0\", \"serialnumber\": 0, "
                    + "\"stationfee\": \"200\", \"totalamount\": 0, "
                    + "\"username\": \"test\"}}";
            String result = rsbpproduction.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONArray jsonarray_material = (JSONArray)jsonresult.get("material");
            double totalprice_market = JSONConversion.getDouble(jsonresult, "totalprice_market");
            double totalprice_user = JSONConversion.getDouble(jsonresult, "totalprice_user");
            int expectedsize = 1;
            Assert.assertEquals(expectedsize, jsonarray_material.size());
            double expectedmarketprice = 1450;
            Assert.assertEquals(totalprice_market, expectedmarketprice);
            double expecteduserprice = 1450;
            Assert.assertEquals(totalprice_user, expecteduserprice);
        }
        catch(DBException | DatahandlerException | ParseException e) {
        }
    }
    
    @Test
    public void calculate_productionprice_with_1_material_with_userprice() {
        try {
            ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
            view_userbpmaterials.add(material2);
            doReturn(view_userbpmaterials).when(rsbpproduction).find_user_materials_for_blueprint(any(View_userbp.class));  
            String jsonpayload = "{\"auth\": \"\", \"viewuserbp\": "
                    + "{\"blueprintname\": \"test\", \"typegroupname\": \"test\", "
                    + "\"amountproduced\": 0, \"bp\": \"0\", \"bpprice\": \"1000000\", "
                    + "\"materialefficiency\": 0, \"original\": true, "
                    + "\"researchcost\": \"0\", \"serialnumber\": 0, "
                    + "\"stationfee\": \"200\", \"totalamount\": 0, "
                    + "\"username\": \"test\"}}";
            String result = rsbpproduction.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONArray jsonarray_material = (JSONArray)jsonresult.get("material");
            double totalprice_market = JSONConversion.getDouble(jsonresult, "totalprice_market");
            double totalprice_user = JSONConversion.getDouble(jsonresult, "totalprice_user");
            int expectedsize = 1;
            Assert.assertEquals(expectedsize, jsonarray_material.size());
            double expectedmarketprice = 12200;
            Assert.assertEquals(totalprice_market, expectedmarketprice);
            double expecteduserprice = 11200;
            Assert.assertEquals(totalprice_user, expecteduserprice);
        }
        catch(DBException | DatahandlerException | ParseException e) {
        }
    }
    
    @Test
    public void calculate_productionprice_with_1_material_no_userprice_1_material_with_userprice() {
        try {
            ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
            view_userbpmaterials.add(material1);
            view_userbpmaterials.add(material2);
            doReturn(view_userbpmaterials).when(rsbpproduction).find_user_materials_for_blueprint(any(View_userbp.class));  
            String jsonpayload = "{\"auth\": \"\", \"viewuserbp\": "
                    + "{\"blueprintname\": \"test\", \"typegroupname\": \"test\", "
                    + "\"amountproduced\": 0, \"bp\": \"0\", \"bpprice\": \"1000000\", "
                    + "\"materialefficiency\": 0, \"original\": true, "
                    + "\"researchcost\": \"0\", \"serialnumber\": 0, "
                    + "\"stationfee\": \"200\", \"totalamount\": 0, "
                    + "\"username\": \"test\"}}";
            String result = rsbpproduction.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONArray jsonarray_material = (JSONArray)jsonresult.get("material");
            double totalprice_market = JSONConversion.getDouble(jsonresult, "totalprice_market");
            double totalprice_user = JSONConversion.getDouble(jsonresult, "totalprice_user");
            int expectedsize = 2;
            Assert.assertEquals(expectedsize, jsonarray_material.size());
            double expectedmarketprice = 13450;
            Assert.assertEquals(totalprice_market, expectedmarketprice);
            double expecteduserprice = 12450;
            Assert.assertEquals(totalprice_user, expecteduserprice);
        }
        catch(DBException | DatahandlerException | ParseException e) {
        }
    }
    
    @Test
    public void calculate_productionprice_with_1_material_no_userprice_1_material_with_userprice_materialefficiency_9() {
        try {
            ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
            view_userbpmaterials.add(material1);
            view_userbpmaterials.add(material2);
            doReturn(view_userbpmaterials).when(rsbpproduction).find_user_materials_for_blueprint(any(View_userbp.class));  
            String jsonpayload = "{\"auth\": \"\", \"viewuserbp\": "
                    + "{\"blueprintname\": \"test\", \"typegroupname\": \"test\", "
                    + "\"amountproduced\": 0, \"bp\": \"0\", \"bpprice\": \"1000000\", "
                    + "\"materialefficiency\": 9, \"original\": true, "
                    + "\"researchcost\": \"0\", \"serialnumber\": 0, "
                    + "\"stationfee\": \"200\", \"totalamount\": 0, "
                    + "\"username\": \"test\"}}";
            String result = rsbpproduction.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONArray jsonarray_material = (JSONArray)jsonresult.get("material");
            double totalprice_market = JSONConversion.getDouble(jsonresult, "totalprice_market");
            double totalprice_user = JSONConversion.getDouble(jsonresult, "totalprice_user");
            int expectedsize = 2;
            Assert.assertEquals(expectedsize, jsonarray_material.size());
            double expectedmarketprice = 12257.5;
            Assert.assertEquals(totalprice_market, expectedmarketprice);
            double expecteduserprice = 11347.5;
            Assert.assertEquals(totalprice_user, expecteduserprice);
        }
        catch(DBException | DatahandlerException | ParseException e) {
        }
    }
}
