package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import eve.logicentity.Faction;
import eve.logicentity.Graphic;
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
public class BLfactionTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLfaction blfaction = new BLfaction(sqlreader_mock);
    
    public BLfactionTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateFaction_allvalues_test() {
        try {
            doNothing().when(blfaction).insertupdateFaction(any(SQLTqueue.class), any(Faction.class));
            JSONObject jsonfactiondetails = new JSONObject();
            long expected_faction_id = 10000;
            jsonfactiondetails.put("faction_id", expected_faction_id);
            String expected_name = "name";
            jsonfactiondetails.put("name", expected_name);
            String expected_description = "description";
            jsonfactiondetails.put("description", expected_description);
            boolean expected_is_unique = true;
            jsonfactiondetails.put("is_unique", expected_is_unique);
            double expected_size_factor = 10;
            jsonfactiondetails.put("size_factor", expected_size_factor);
            long expected_station_count = 5;
            jsonfactiondetails.put("station_count", expected_station_count);
            long expected_station_system_count = 4;
            jsonfactiondetails.put("station_system_count", expected_station_system_count);
            long expected_corporation_id = 10001;
            jsonfactiondetails.put("corporation_id", expected_corporation_id);
            long expected_militia_corporation_id = 10002;
            jsonfactiondetails.put("militia_corporation_id", expected_militia_corporation_id);
            long expected_solar_system_id = 10003;
            jsonfactiondetails.put("solar_system_id", expected_solar_system_id);
            Faction faction = blfaction.updateFaction(transactionqueue, jsonfactiondetails);
            Assert.assertEquals(faction.getPrimaryKey().getId(), expected_faction_id);
            Assert.assertEquals(faction.getName(), expected_name);
            Assert.assertEquals(faction.getDescription(), expected_description);
            Assert.assertEquals(faction.getIs_unique(), expected_is_unique);
            Assert.assertEquals(faction.getSize_factor(), expected_size_factor, 0.001);
            Assert.assertEquals(faction.getStation_count(), expected_station_count);
            Assert.assertEquals(faction.getStation_system_count(), expected_station_system_count);
            Assert.assertEquals(faction.getCorporation(), expected_corporation_id);
            Assert.assertEquals(faction.getMilitia_corporation(), expected_militia_corporation_id);
            Assert.assertEquals(faction.getSystemPK().getId(), expected_solar_system_id);
        }
        catch(DBException | DataException e) {
        }        
    }
    
    @Test
    public void updateFaction_missingvalues_test() {
        try {
            doNothing().when(blfaction).insertupdateFaction(any(SQLTqueue.class), any(Faction.class));
            JSONObject jsonfactiondetails = new JSONObject();
            long expected_faction_id = 10000;
            jsonfactiondetails.put("faction_id", expected_faction_id);
            String expected_name = "name";
            jsonfactiondetails.put("name", expected_name);
            String expected_description = "description";
            jsonfactiondetails.put("description", expected_description);
            boolean expected_is_unique = true;
            jsonfactiondetails.put("is_unique", expected_is_unique);
            double expected_size_factor = 10;
            jsonfactiondetails.put("size_factor", expected_size_factor);
            long expected_station_count = 5;
            jsonfactiondetails.put("station_count", expected_station_count);
            long expected_station_system_count = 4;
            jsonfactiondetails.put("station_system_count", expected_station_system_count);
            long expected_corporation_id = 0;
            long expected_militia_corporation_id = 0;
            long expected_solar_system_id = 0;
            Faction faction = blfaction.updateFaction(transactionqueue, jsonfactiondetails);
            Assert.assertEquals(faction.getPrimaryKey().getId(), expected_faction_id);
            Assert.assertEquals(faction.getName(), expected_name);
            Assert.assertEquals(faction.getDescription(), expected_description);
            Assert.assertEquals(faction.getIs_unique(), expected_is_unique);
            Assert.assertEquals(faction.getSize_factor(), expected_size_factor, 0.001);
            Assert.assertEquals(faction.getStation_count(), expected_station_count);
            Assert.assertEquals(faction.getStation_system_count(), expected_station_system_count);
            Assert.assertEquals(faction.getCorporation(), expected_corporation_id);
            Assert.assertEquals(faction.getMilitia_corporation(), expected_militia_corporation_id);
            Assert.assertEquals(faction.getSystemPK(), null);
        }
        catch(DBException | DataException e) {
        }        
    }
}
