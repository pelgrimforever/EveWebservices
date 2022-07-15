package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicview.View_wishlist;
import eve.searchentity.View_wishlistsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_wishlistTest {
    
    public JSONView_wishlistTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_wishlist view_wishlist = new View_wishlist();
        ArrayList<View_wishlist> view_wishlistlist = new ArrayList<>();
        view_wishlistlist.add(view_wishlist);
        JSONArray jsonview_wishlistarray = JSONView_wishlist.toJSONArray(view_wishlistlist);
        JSONObject jsonview_wishlist = (JSONObject)jsonview_wishlistarray.get(0);
        view_wishlist = JSONView_wishlist.toView_wishlist(jsonview_wishlist);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

