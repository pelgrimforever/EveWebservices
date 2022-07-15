package eve.conversion.json;

import data.conversion.JSONConversion;
import eve.logicentity.Category;
import eve.searchentity.Categorysearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONCategoryTest {
    
    public JSONCategoryTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Category category = new Category();
        ArrayList<Category> categorylist = new ArrayList<>();
        categorylist.add(category);
        JSONArray jsoncategoryarray = JSONCategory.toJSONArray(categorylist);
        JSONObject jsoncategory = (JSONObject)jsoncategoryarray.get(0);
        category = JSONCategory.toCategory(jsoncategory);
        category = JSONCategory.initCategory(jsoncategory);
        JSONCategory.updateCategory(category, jsoncategory);
        Categorysearch search = new Categorysearch();
        JSONObject jsonsearch = JSONCategory.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONCategory.toCategorysearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

