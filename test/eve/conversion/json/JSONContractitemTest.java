package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Contractitem;
import eve.searchentity.Contractitemsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONContractitemTest {
    
    public JSONContractitemTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Contractitem contractitem = new Contractitem();
        ArrayList<Contractitem> contractitemlist = new ArrayList<>();
        contractitemlist.add(contractitem);
        JSONArray jsoncontractitemarray = JSONContractitem.toJSONArray(contractitemlist);
        JSONObject jsoncontractitem = (JSONObject)jsoncontractitemarray.get(0);
        contractitem = JSONContractitem.toContractitem(jsoncontractitem);
        contractitem = JSONContractitem.initContractitem(jsoncontractitem);
        JSONContractitem.updateContractitem(contractitem, jsoncontractitem);
        Contractitemsearch search = new Contractitemsearch();
        JSONObject jsonsearch = JSONContractitem.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONContractitem.toContractitemsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

