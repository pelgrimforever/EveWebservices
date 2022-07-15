package eve.restservices;

import data.conversion.JSONConversion;
import eve.logicview.View_evetypes;
import eve.logicview.View_userbpmaterial;
import eve.usecases.custom.Security_usecases;
import eve.usecases.custom.Bpsimulatemarket_parameters;
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
public class RSbpsimulatemarketTest {
    
    private View_evetypes bpresultevetype = new View_evetypes();
    private View_userbpmaterial material1 = new View_userbpmaterial();
    private View_userbpmaterial material2 = new View_userbpmaterial();
    
    @Mock(name="security_usecases")
    private Security_usecases security_usecases_mock = new Security_usecases();

    @Spy
    @InjectMocks
    private RSbpsimulatemarket rsbpsimulatemarket = new RSbpsimulatemarket();
    
    public RSbpsimulatemarketTest() {
        MockitoAnnotations.initMocks(this);
        bpresultevetype.setCategory(0);
        bpresultevetype.setConfiguredbp(true);
        bpresultevetype.setId(0);
        bpresultevetype.setName("test");
        bpresultevetype.setTypegroupid(0);
        bpresultevetype.setTypegroupname("");
        try {
            doReturn(true).when(security_usecases_mock).check_authorization(anyString());   
            doReturn(bpresultevetype).when(rsbpsimulatemarket).getBlueprintresult(any(Bpsimulatemarket_parameters.class));   
        }
        catch(IOException | DBException | DatahandlerException e) {
        }
    }
    
    @Before
    public void setUp() {
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

    @Test
    public void calculate_simulatedprice_with_no_materials() {
        try {
            ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
            doReturn(view_userbpmaterials).when(rsbpsimulatemarket).getView_userbpmaterials_for_blueprint_user(any(Bpsimulatemarket_parameters.class));  
            String jsonpayload = "{\"auth\": \"\", "
                    + "\"bpbreakeven\": 1, \"bpmaterialefficiency\": 0, "
                    + "\"bpprice\": 1000000, \"researchcost\": 0, "
                    + "\"stationfee\": 200, \"username\": \"test\", "
                    + "\"viewblueprint\": {\"category\": \"0\", \"typegroupid\": \"0\", \"typegroupname\": \"\", \"id\": \"0\", \"configuredbp\": true, \"name\": \"test Blueprint\"}}";
            String result = rsbpsimulatemarket.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONObject jsonbpresult = (JSONObject)jsonresult.get("bpresult");
            JSONArray jsonarray_material = (JSONArray)jsonresult.get("material");
            double totalprice_market = JSONConversion.getDouble(jsonresult, "totalprice_market");
            double totalprice_user = JSONConversion.getDouble(jsonresult, "totalprice_user");
            int expectedsize = 0;
            Assert.assertEquals(expectedsize, jsonarray_material.size());
            double expectedmarketprice = 1000200;
            Assert.assertEquals(totalprice_market, expectedmarketprice);
            double expecteduserprice = 1000200;
            Assert.assertEquals(totalprice_user, expecteduserprice);
        }
        catch(DBException | DatahandlerException | ParseException e) {
        }
    }
    
    @Test
    public void calculate_simulatedprice_with_1_material_no_userprice() {
        try {
            ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
            view_userbpmaterials.add(material1);
            doReturn(view_userbpmaterials).when(rsbpsimulatemarket).getView_userbpmaterials_for_blueprint_user(any(Bpsimulatemarket_parameters.class));  
            String jsonpayload = "{\"auth\": \"\", "
                    + "\"bpbreakeven\": 1, \"bpmaterialefficiency\": 0, "
                    + "\"bpprice\": 1000000, \"researchcost\": 0, "
                    + "\"stationfee\": 200, \"username\": \"test\", "
                    + "\"viewblueprint\": {\"category\": \"0\", \"typegroupid\": \"0\", \"typegroupname\": \"\", \"id\": \"0\", \"configuredbp\": true, \"name\": \"test Blueprint\"}}";
            String result = rsbpsimulatemarket.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONObject jsonbpresult = (JSONObject)jsonresult.get("bpresult");
            JSONArray jsonarray_material = (JSONArray)jsonresult.get("material");
            double totalprice_market = JSONConversion.getDouble(jsonresult, "totalprice_market");
            double totalprice_user = JSONConversion.getDouble(jsonresult, "totalprice_user");
            int expectedsize = 1;
            Assert.assertEquals(expectedsize, jsonarray_material.size());
            double expectedmarketprice = 1001450;
            Assert.assertEquals(totalprice_market, expectedmarketprice);
            double expecteduserprice = 1001450;
            Assert.assertEquals(totalprice_user, expecteduserprice);
        }
        catch(DBException | DatahandlerException | ParseException e) {
        }
    }
    
    @Test
    public void calculate_simulatedprice_with_1_material_with_userprice() {
        try {
            ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
            view_userbpmaterials.add(material2);
            doReturn(view_userbpmaterials).when(rsbpsimulatemarket).getView_userbpmaterials_for_blueprint_user(any(Bpsimulatemarket_parameters.class));  
            String jsonpayload = "{\"auth\": \"\", "
                    + "\"bpbreakeven\": 1, \"bpmaterialefficiency\": 0, "
                    + "\"bpprice\": 1000000, \"researchcost\": 0, "
                    + "\"stationfee\": 200, \"username\": \"test\", "
                    + "\"viewblueprint\": {\"category\": \"0\", \"typegroupid\": \"0\", \"typegroupname\": \"\", \"id\": \"0\", \"configuredbp\": true, \"name\": \"test Blueprint\"}}";
            String result = rsbpsimulatemarket.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONObject jsonbpresult = (JSONObject)jsonresult.get("bpresult");
            JSONArray jsonarray_material = (JSONArray)jsonresult.get("material");
            double totalprice_market = JSONConversion.getDouble(jsonresult, "totalprice_market");
            double totalprice_user = JSONConversion.getDouble(jsonresult, "totalprice_user");
            int expectedsize = 1;
            Assert.assertEquals(expectedsize, jsonarray_material.size());
            double expectedmarketprice = 1012200;
            Assert.assertEquals(totalprice_market, expectedmarketprice);
            double expecteduserprice = 1011200;
            Assert.assertEquals(totalprice_user, expecteduserprice);
        }
        catch(DBException | DatahandlerException | ParseException e) {
        }
    }
    
    @Test
    public void calculate_simulatedprice_with_1_material_no_userprice_1_material_with_userprice() {
        try {
            ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
            view_userbpmaterials.add(material1);
            view_userbpmaterials.add(material2);
            doReturn(view_userbpmaterials).when(rsbpsimulatemarket).getView_userbpmaterials_for_blueprint_user(any(Bpsimulatemarket_parameters.class));  
            String jsonpayload = "{\"auth\": \"\", "
                    + "\"bpbreakeven\": 1, \"bpmaterialefficiency\": 0, "
                    + "\"bpprice\": 1000000, \"researchcost\": 0, "
                    + "\"stationfee\": 200, \"username\": \"test\", "
                    + "\"viewblueprint\": {\"category\": \"0\", \"typegroupid\": \"0\", \"typegroupname\": \"\", \"id\": \"0\", \"configuredbp\": true, \"name\": \"test Blueprint\"}}";
            String result = rsbpsimulatemarket.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONObject jsonbpresult = (JSONObject)jsonresult.get("bpresult");
            JSONArray jsonarray_material = (JSONArray)jsonresult.get("material");
            double totalprice_market = JSONConversion.getDouble(jsonresult, "totalprice_market");
            double totalprice_user = JSONConversion.getDouble(jsonresult, "totalprice_user");
            int expectedsize = 2;
            Assert.assertEquals(expectedsize, jsonarray_material.size());
            double expectedmarketprice = 1013450;
            Assert.assertEquals(totalprice_market, expectedmarketprice);
            double expecteduserprice = 1012450;
            Assert.assertEquals(totalprice_user, expecteduserprice);
        }
        catch(DBException | DatahandlerException | ParseException e) {
        }
    }
    
    @Test
    public void calculate_simulatedprice_with_1_material_no_userprice_1_material_with_userprice_materialefficiency_9() {
        try {
            ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
            view_userbpmaterials.add(material1);
            view_userbpmaterials.add(material2);
            doReturn(view_userbpmaterials).when(rsbpsimulatemarket).getView_userbpmaterials_for_blueprint_user(any(Bpsimulatemarket_parameters.class));  
            String jsonpayload = "{\"auth\": \"\", "
                    + "\"bpbreakeven\": 1, \"bpmaterialefficiency\": 9, "
                    + "\"bpprice\": 1000000, \"researchcost\": 0, "
                    + "\"stationfee\": 200, \"username\": \"test\", "
                    + "\"viewblueprint\": {\"category\": \"0\", \"typegroupid\": \"0\", \"typegroupname\": \"\", \"id\": \"0\", \"configuredbp\": true, \"name\": \"test Blueprint\"}}";
            String result = rsbpsimulatemarket.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONObject jsonbpresult = (JSONObject)jsonresult.get("bpresult");
            JSONArray jsonarray_material = (JSONArray)jsonresult.get("material");
            double totalprice_market = JSONConversion.getDouble(jsonresult, "totalprice_market");
            double totalprice_user = JSONConversion.getDouble(jsonresult, "totalprice_user");
            int expectedsize = 2;
            Assert.assertEquals(expectedsize, jsonarray_material.size());
            double expectedmarketprice = 1012257.5;
            Assert.assertEquals(totalprice_market, expectedmarketprice);
            double expecteduserprice = 1011347.5;
            Assert.assertEquals(totalprice_user, expecteduserprice);
        }
        catch(DBException | DatahandlerException | ParseException e) {
        }
    }

    @Test
    public void calculate_simulatedprice_with_1_material_no_userprice_1_material_with_userprice_materialefficiency_9_breakeven_20() {
        try {
            ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
            view_userbpmaterials.add(material1);
            view_userbpmaterials.add(material2);
            doReturn(view_userbpmaterials).when(rsbpsimulatemarket).getView_userbpmaterials_for_blueprint_user(any(Bpsimulatemarket_parameters.class));  
            String jsonpayload = "{\"auth\": \"\", "
                    + "\"bpbreakeven\": 20, \"bpmaterialefficiency\": 9, "
                    + "\"bpprice\": 1000000, \"researchcost\": 0, "
                    + "\"stationfee\": 200, \"username\": \"test\", "
                    + "\"viewblueprint\": {\"category\": \"0\", \"typegroupid\": \"0\", \"typegroupname\": \"\", \"id\": \"0\", \"configuredbp\": true, \"name\": \"test Blueprint\"}}";
            String result = rsbpsimulatemarket.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONObject jsonbpresult = (JSONObject)jsonresult.get("bpresult");
            JSONArray jsonarray_material = (JSONArray)jsonresult.get("material");
            double totalprice_market = JSONConversion.getDouble(jsonresult, "totalprice_market");
            double totalprice_user = JSONConversion.getDouble(jsonresult, "totalprice_user");
            int expectedsize = 2;
            Assert.assertEquals(expectedsize, jsonarray_material.size());
            double expectedmarketprice = 62257.5;
            Assert.assertEquals(totalprice_market, expectedmarketprice);
            double expecteduserprice = 61347.5;
            Assert.assertEquals(totalprice_user, expecteduserprice);
        }
        catch(DBException | DatahandlerException | ParseException e) {
        }
    }

    @Test
    public void calculate_simulatedprice_with_1_material_no_userprice_1_material_with_userprice_materialefficiency_9_breakeven_20_researchcost() {
        try {
            ArrayList<View_userbpmaterial> view_userbpmaterials = new ArrayList<>();
            view_userbpmaterials.add(material1);
            view_userbpmaterials.add(material2);
            doReturn(view_userbpmaterials).when(rsbpsimulatemarket).getView_userbpmaterials_for_blueprint_user(any(Bpsimulatemarket_parameters.class));  
            String jsonpayload = "{\"auth\": \"\", "
                    + "\"bpbreakeven\": 20, \"bpmaterialefficiency\": 9, "
                    + "\"bpprice\": 1000000, \"researchcost\": 800000, "
                    + "\"stationfee\": 200, \"username\": \"test\", "
                    + "\"viewblueprint\": {\"category\": \"0\", \"typegroupid\": \"0\", \"typegroupname\": \"\", \"id\": \"0\", \"configuredbp\": true, \"name\": \"test Blueprint\"}}";
            String result = rsbpsimulatemarket.post(jsonpayload);
            JSONParser parser = new JSONParser();
            JSONObject jsonresult = (JSONObject)parser.parse(result);
            JSONObject jsonbpresult = (JSONObject)jsonresult.get("bpresult");
            JSONArray jsonarray_material = (JSONArray)jsonresult.get("material");
            double totalprice_market = JSONConversion.getDouble(jsonresult, "totalprice_market");
            double totalprice_user = JSONConversion.getDouble(jsonresult, "totalprice_user");
            int expectedsize = 2;
            Assert.assertEquals(expectedsize, jsonarray_material.size());
            double expectedmarketprice = 102257.5;
            Assert.assertEquals(totalprice_market, expectedmarketprice);
            double expecteduserprice = 101347.5;
            Assert.assertEquals(totalprice_user, expecteduserprice);
        }
        catch(DBException | DatahandlerException | ParseException e) {
        }
    }
}
