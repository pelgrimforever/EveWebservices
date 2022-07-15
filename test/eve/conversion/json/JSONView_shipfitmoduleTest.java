package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_shipfitmodule;
import eve.searchentity.View_shipfitmodulesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_shipfitmoduleTest {
    
    public JSONView_shipfitmoduleTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_shipfitmodule view_shipfitmodule = new View_shipfitmodule();
        ArrayList<View_shipfitmodule> view_shipfitmodulelist = new ArrayList<>();
        view_shipfitmodulelist.add(view_shipfitmodule);
        JSONArray jsonview_shipfitmodulearray = JSONView_shipfitmodule.toJSONArray(view_shipfitmodulelist);
        JSONObject jsonview_shipfitmodule = (JSONObject)jsonview_shipfitmodulearray.get(0);
        view_shipfitmodule = JSONView_shipfitmodule.toView_shipfitmodule(jsonview_shipfitmodule);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

