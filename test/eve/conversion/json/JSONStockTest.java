package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Stock;
import eve.searchentity.Stocksearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONStockTest {
    
    public JSONStockTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Stock stock = new Stock();
        ArrayList<Stock> stocklist = new ArrayList<>();
        stocklist.add(stock);
        JSONArray jsonstockarray = JSONStock.toJSONArray(stocklist);
        JSONObject jsonstock = (JSONObject)jsonstockarray.get(0);
        stock = JSONStock.toStock(jsonstock);
        stock = JSONStock.initStock(jsonstock);
        JSONStock.updateStock(stock, jsonstock);
        Stocksearch search = new Stocksearch();
        JSONObject jsonsearch = JSONStock.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONStock.toStocksearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

