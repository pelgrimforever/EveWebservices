package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import eve.logicentity.Race;
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
public class BLraceTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLrace blrace = new BLrace(sqlreader_mock);
    
    public BLraceTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateRacetest() {
        try {
            doNothing().when(blrace).insertupdateRace(any(SQLTqueue.class), any(Race.class));
            JSONObject jsonracedetails = new JSONObject();
            long expected_race_id = 1000;
            jsonracedetails.put("race_id", expected_race_id);
            String expected_name = "test";
            jsonracedetails.put("name", expected_name);
            String expected_description = "description";
            jsonracedetails.put("description", expected_description);
            long expected_alliance_id = 1001;
            jsonracedetails.put("alliance_id", expected_alliance_id);
            Race race = blrace.updateRace(transactionqueue, jsonracedetails);
            Assert.assertEquals(race.getPrimaryKey().getId(), expected_race_id);
            Assert.assertEquals(race.getName(), expected_name);
            Assert.assertEquals(race.getDescription(), expected_description);
            Assert.assertEquals(race.getFactionPK().getId(), expected_alliance_id);
        }
        catch(DBException | DataException e) {
        }
    }
    
}
