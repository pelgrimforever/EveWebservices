package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_tradeorders_lowsec;
import eve.searchentity.View_tradeorders_lowsecsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_tradeorders_lowsecTest {
    
    public JSONView_tradeorders_lowsecTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_tradeorders_lowsec view_tradeorders_lowsec = new View_tradeorders_lowsec();
        ArrayList<View_tradeorders_lowsec> view_tradeorders_lowseclist = new ArrayList<>();
        view_tradeorders_lowseclist.add(view_tradeorders_lowsec);
        JSONArray jsonview_tradeorders_lowsecarray = JSONView_tradeorders_lowsec.toJSONArray(view_tradeorders_lowseclist);
        JSONObject jsonview_tradeorders_lowsec = (JSONObject)jsonview_tradeorders_lowsecarray.get(0);
        view_tradeorders_lowsec = JSONView_tradeorders_lowsec.toView_tradeorders_lowsec(jsonview_tradeorders_lowsec);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

