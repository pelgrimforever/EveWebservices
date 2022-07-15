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
public class BLsystemTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLsystem blsystem = new BLsystem(sqlreader_mock);
    
    public BLsystemTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateSystem_allvalues_test() {
        try {
            doNothing().when(blsystem).insertupdateSystem(any(SQLTqueue.class), any(eve.logicentity.System.class));
            JSONObject jsonsystemdetails = new JSONObject();
            long expected_system_id = 1000;
            jsonsystemdetails.put("system_id", expected_system_id);
            String expected_name = "test";
            jsonsystemdetails.put("name", expected_name);
            long expected_constellation_id = 1001;
            jsonsystemdetails.put("constellation_id", expected_constellation_id);
            String expected_security_class = "sectest";
            jsonsystemdetails.put("security_class", expected_security_class);
            double expected_security_status = 0.95;
            jsonsystemdetails.put("security_status", expected_security_status);
            long expected_star_id = 1002;
            jsonsystemdetails.put("star_id", expected_star_id);
            eve.logicentity.System system = blsystem.updateSystem(transactionqueue, jsonsystemdetails);
            Assert.assertEquals(system.getPrimaryKey().getId(), expected_system_id);
            Assert.assertEquals(system.getName(), expected_name);
            Assert.assertEquals(system.getConstellationPK().getId(), expected_constellation_id);
            Assert.assertEquals(system.getSecurity_class(), expected_security_class);
            Assert.assertEquals(system.getSecurity_status(), expected_security_status, 0.001);
            Assert.assertEquals(system.getStar_id(), expected_star_id);
        }
        catch(DBException | DataException e) {
        }
    }
    
    @Test
    public void updateSystem_missingvalues_test() {
        try {
            doNothing().when(blsystem).insertupdateSystem(any(SQLTqueue.class), any(eve.logicentity.System.class));
            JSONObject jsonsystemdetails = new JSONObject();
            long expected_system_id = 1000;
            jsonsystemdetails.put("system_id", expected_system_id);
            String expected_name = "test";
            jsonsystemdetails.put("name", expected_name);
            long expected_constellation_id = 1001;
            jsonsystemdetails.put("constellation_id", expected_constellation_id);
            double expected_security_status = 0.95;
            jsonsystemdetails.put("security_status", expected_security_status);
            eve.logicentity.System system = blsystem.updateSystem(transactionqueue, jsonsystemdetails);
            Assert.assertEquals(system.getPrimaryKey().getId(), expected_system_id);
            Assert.assertEquals(system.getName(), expected_name);
            Assert.assertEquals(system.getConstellationPK().getId(), expected_constellation_id);
            Assert.assertEquals(system.getSecurity_class(), null);
            Assert.assertEquals(system.getSecurity_status(), expected_security_status, 0.001);
            Assert.assertEquals(system.getStar_id(), 0);
        }
        catch(DBException | DataException e) {
        }
    }
    
}
