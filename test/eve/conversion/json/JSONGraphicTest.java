package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Graphic;
import eve.searchentity.Graphicsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONGraphicTest {
    
    public JSONGraphicTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Graphic graphic = new Graphic();
        ArrayList<Graphic> graphiclist = new ArrayList<>();
        graphiclist.add(graphic);
        JSONArray jsongraphicarray = JSONGraphic.toJSONArray(graphiclist);
        JSONObject jsongraphic = (JSONObject)jsongraphicarray.get(0);
        graphic = JSONGraphic.toGraphic(jsongraphic);
        graphic = JSONGraphic.initGraphic(jsongraphic);
        JSONGraphic.updateGraphic(graphic, jsongraphic);
        Graphicsearch search = new Graphicsearch();
        JSONObject jsonsearch = JSONGraphic.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONGraphic.toGraphicsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

