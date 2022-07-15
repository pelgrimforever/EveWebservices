package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Trade;
import eve.searchentity.Tradesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONTradeTest {
    
    public JSONTradeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Trade trade = new Trade();
        ArrayList<Trade> tradelist = new ArrayList<>();
        tradelist.add(trade);
        JSONArray jsontradearray = JSONTrade.toJSONArray(tradelist);
        JSONObject jsontrade = (JSONObject)jsontradearray.get(0);
        trade = JSONTrade.toTrade(jsontrade);
        trade = JSONTrade.initTrade(jsontrade);
        JSONTrade.updateTrade(trade, jsontrade);
        Tradesearch search = new Tradesearch();
        JSONObject jsonsearch = JSONTrade.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONTrade.toTradesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

