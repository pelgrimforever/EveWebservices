package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import eve.logicentity.Stargate;
import eve.logicentity.Station;
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
public class BLstargateTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLstargate blstargate = new BLstargate(sqlreader_mock);
    
    public BLstargateTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateStargate_allvalues_test() {
        try {
            doNothing().when(blstargate).insertupdateStargate(any(SQLTqueue.class), any(Stargate.class));
            JSONObject jsonstargatedetails = new JSONObject();
            long expected_stargate_id = 1000;
            jsonstargatedetails.put("stargate_id", expected_stargate_id);
            String expected_name = "test";
            jsonstargatedetails.put("name", expected_name);
            long expected_system_id = 2001;
            jsonstargatedetails.put("system_id", expected_system_id);
            JSONObject jsondestination = new JSONObject();
            jsonstargatedetails.put("destination", jsondestination);
            long expected_destinationstargate_id = 1001;
            jsondestination.put("stargate_id", expected_destinationstargate_id);
            long expected_destinationsystem_id = 2001;
            jsondestination.put("system_id", expected_destinationsystem_id);
            JSONObject jsonposition = new JSONObject();
            jsonstargatedetails.put("position", jsonposition);
            double expected_x = 1.111;
            jsonposition.put("x", expected_x);
            double expected_y = 2.222;
            jsonposition.put("y", expected_y);
            double expected_z = 3.333;
            jsonposition.put("z", expected_z);
            Stargate stargate = blstargate.updateStargate(transactionqueue, jsonstargatedetails);
            Assert.assertEquals(stargate.getPrimaryKey().getId(), expected_stargate_id);
            Assert.assertEquals(stargate.getName(), expected_name);
            Assert.assertEquals(stargate.getTo_stargate(), expected_destinationstargate_id);
            Assert.assertEquals(stargate.getSystemto_systemPK().getId(), expected_destinationsystem_id);
            Assert.assertEquals(stargate.getX(), expected_x, 0.001);
            Assert.assertEquals(stargate.getY(), expected_y, 0.001);
            Assert.assertEquals(stargate.getZ(), expected_z, 0.001);
        }
        catch(DBException | DataException e) {
        }
    }
    
}
