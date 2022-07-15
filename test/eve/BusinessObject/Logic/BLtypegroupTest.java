package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import eve.logicentity.Typegroup;
import general.exception.DBException;
import general.exception.DataException;
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
public class BLtypegroupTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLtypegroup bltypegroup = new BLtypegroup(sqlreader_mock);
    
    public BLtypegroupTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateTypegroup_test() {
        try {
            doNothing().when(bltypegroup).insertupdateTypegroup(any(SQLTqueue.class), any(Typegroup.class));
            JSONObject jsongroupdetails = new JSONObject();
            long expected_id = 1000;
            jsongroupdetails.put("group_id", expected_id);
            String expected_name = "test";
            jsongroupdetails.put("name", expected_name);
            long expected_category_id = 1001;
            jsongroupdetails.put("category_id", expected_category_id);
            boolean expected_published = true;
            jsongroupdetails.put("published", expected_published);
            Typegroup typegroup = bltypegroup.updateTypegroup(transactionqueue, jsongroupdetails);
            Assert.assertEquals(typegroup.getPrimaryKey().getId(), expected_id);
            Assert.assertEquals(typegroup.getName(), expected_name);
            Assert.assertEquals(typegroup.getCategoryPK().getId(), expected_category_id);
            Assert.assertEquals(typegroup.getPublished(), expected_published);
        }
        catch(DBException | DataException e) {
        }
    }
    
}
