package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Stocktrade;
import eve.searchentity.Stocktradesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONStocktradeTest {
    
    public JSONStocktradeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Stocktrade stocktrade = new Stocktrade();
        ArrayList<Stocktrade> stocktradelist = new ArrayList<>();
        stocktradelist.add(stocktrade);
        JSONArray jsonstocktradearray = JSONStocktrade.toJSONArray(stocktradelist);
        JSONObject jsonstocktrade = (JSONObject)jsonstocktradearray.get(0);
        stocktrade = JSONStocktrade.toStocktrade(jsonstocktrade);
        stocktrade = JSONStocktrade.initStocktrade(jsonstocktrade);
        JSONStocktrade.updateStocktrade(stocktrade, jsonstocktrade);
        Stocktradesearch search = new Stocktradesearch();
        JSONObject jsonsearch = JSONStocktrade.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONStocktrade.toStocktradesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

