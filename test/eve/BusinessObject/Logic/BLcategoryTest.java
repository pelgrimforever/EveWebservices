package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import general.exception.DBException;
import general.exception.DataException;
import java.util.Locale.Category;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class BLcategoryTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLcategory blcategory = new BLcategory(sqlreader_mock);
    
    public BLcategoryTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateCategory_test() {
        try {
            doNothing().when(blcategory).insertupdateCategory(any(SQLTqueue.class), any(eve.logicentity.Category.class));
            JSONObject jsoncategorydetails = new JSONObject();
            long expected_category_id = 10000;
            jsoncategorydetails.put("category_id", expected_category_id);
            String expected_name = "name";
            jsoncategorydetails.put("name", expected_name);
            boolean expected_published = true;
            jsoncategorydetails.put("published", expected_published);
            eve.logicentity.Category category = blcategory.updateCategory(transactionqueue, jsoncategorydetails);
            Assert.assertEquals(category.getPrimaryKey().getId(), expected_category_id);
            Assert.assertEquals(category.getName(), expected_name);
            Assert.assertEquals(category.getPublished(), expected_published);
        }
        catch(DBException | DataException e) {
        }        
    }
    
}
