package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import eve.logicentity.Alliance;
import eve.logicentity.Constellation;
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
public class BLallianceTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLalliance blalliance = new BLalliance(sqlreader_mock);
    
    public BLallianceTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateAlliance_allvalues_test() {
        try {
            doNothing().when(blalliance).insertupdateAlliance(any(SQLTqueue.class), any(Alliance.class));
            JSONObject jsonalliancedetails = new JSONObject();
            long expected_alliance_id = 10000;
            jsonalliancedetails.put("alliance_id", expected_alliance_id);
            String expected_name = "name";
            jsonalliancedetails.put("name", expected_name);
            String expected_ticker = "ticker";
            jsonalliancedetails.put("ticker", expected_ticker);
            long expected_creator_id = 10001;
            jsonalliancedetails.put("creator_id", expected_creator_id);
            long expected_creator_corporation_id = 10002;
            jsonalliancedetails.put("creator_corporation_id", expected_creator_corporation_id);
            String inputdate_founded = "2022-01-30T09:10:20Z";
            jsonalliancedetails.put("date_founded", inputdate_founded);
            Timestamp expected_date_founded = new Timestamp(2022-1900, 0, 30, 9, 10, 20, 0);
            long expected_executor_corporation_id = 10003;
            jsonalliancedetails.put("executor_corporation_id", expected_executor_corporation_id);
            long expected_faction_id = 10004;
            jsonalliancedetails.put("faction_id", expected_faction_id);
            Alliance alliance = blalliance.updateAlliance(transactionqueue, jsonalliancedetails);
            Assert.assertEquals(alliance.getPrimaryKey().getId(), expected_alliance_id);
            Assert.assertEquals(alliance.getName(), expected_name);
            Assert.assertEquals(alliance.getTicker(), expected_ticker);
            Assert.assertEquals(alliance.getCreator(), expected_creator_id);
            Assert.assertEquals(alliance.getCorporationcreator_corporationPK().getId(), expected_creator_corporation_id);
            Assert.assertEquals(alliance.getDate_founded(), expected_date_founded);
            Assert.assertEquals(alliance.getCorporationexecutor_corporationPK().getId(), expected_executor_corporation_id);
            Assert.assertEquals(alliance.getFaction_id(), expected_faction_id);
        }
        catch(DBException | DataException e) {
        }        
    }
    
    @Test
    public void updateAlliance_missingvalues_test() {
        try {
            doNothing().when(blalliance).insertupdateAlliance(any(SQLTqueue.class), any(Alliance.class));
            JSONObject jsonalliancedetails = new JSONObject();
            long expected_alliance_id = 10000;
            jsonalliancedetails.put("alliance_id", expected_alliance_id);
            String expected_name = "name";
            jsonalliancedetails.put("name", expected_name);
            String expected_ticker = "ticker";
            jsonalliancedetails.put("ticker", expected_ticker);
            long expected_creator_id = 10001;
            jsonalliancedetails.put("creator_id", expected_creator_id);
            long expected_creator_corporation_id = 10002;
            jsonalliancedetails.put("creator_corporation_id", expected_creator_corporation_id);
            String inputdate_founded = "2022-01-30T09:10:20Z";
            jsonalliancedetails.put("date_founded", inputdate_founded);
            Timestamp expected_date_founded = new Timestamp(2022-1900, 0, 30, 9, 10, 20, 0);
            long expected_executor_corporation_id = 0;
            long expected_faction_id = 0;
            Alliance alliance = blalliance.updateAlliance(transactionqueue, jsonalliancedetails);
            Assert.assertEquals(alliance.getPrimaryKey().getId(), expected_alliance_id);
            Assert.assertEquals(alliance.getName(), expected_name);
            Assert.assertEquals(alliance.getTicker(), expected_ticker);
            Assert.assertEquals(alliance.getCreator(), expected_creator_id);
            Assert.assertEquals(alliance.getCorporationcreator_corporationPK().getId(), expected_creator_corporation_id);
            Assert.assertEquals(alliance.getDate_founded(), expected_date_founded);
            Assert.assertEquals(alliance.getCorporationexecutor_corporationPK(), null);
            Assert.assertEquals(alliance.getFaction_id(), expected_faction_id);
        }
        catch(DBException | DataException e) {
        }        
    }
}
