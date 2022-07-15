package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import eve.logicentity.Constellation;
import eve.logicentity.Corporation;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.Timestamp;
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
public class BLconstellationTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLconstellation blconstellation = new BLconstellation(sqlreader_mock);
    
    public BLconstellationTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateConstellation_test() {
        try {
            doNothing().when(blconstellation).insertupdateConstellation(any(SQLTqueue.class), any(Constellation.class));
            JSONObject jsonconstellationdetails = new JSONObject();
            long expected_constellation_id = 10000;
            jsonconstellationdetails.put("constellation_id", expected_constellation_id);
            String expected_name = "name";
            jsonconstellationdetails.put("name", expected_name);
            long expected_region_id = 10001;
            jsonconstellationdetails.put("region_id", expected_region_id);
            Constellation constellation = blconstellation.updateConstellation(transactionqueue, jsonconstellationdetails);
            Assert.assertEquals(constellation.getPrimaryKey().getId(), expected_constellation_id);
            Assert.assertEquals(constellation.getName(), expected_name);
            Assert.assertEquals(constellation.getRegionPK().getId(), expected_region_id);
        }
        catch(DBException | DataException e) {
        }        
    }
    
}
