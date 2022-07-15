package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Contract;
import eve.searchentity.Contractsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONContractTest {
    
    public JSONContractTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Contract contract = new Contract();
        ArrayList<Contract> contractlist = new ArrayList<>();
        contractlist.add(contract);
        JSONArray jsoncontractarray = JSONContract.toJSONArray(contractlist);
        JSONObject jsoncontract = (JSONObject)jsoncontractarray.get(0);
        contract = JSONContract.toContract(jsoncontract);
        contract = JSONContract.initContract(jsoncontract);
        JSONContract.updateContract(contract, jsoncontract);
        Contractsearch search = new Contractsearch();
        JSONObject jsonsearch = JSONContract.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONContract.toContractsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

