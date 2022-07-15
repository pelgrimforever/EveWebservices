package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
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
public class BLcorporationTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLcorporation blcorporation = new BLcorporation(sqlreader_mock);

    public BLcorporationTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateCorporation_allvalues_test() {
        try {
            doNothing().when(blcorporation).insertupdateCorporation(any(SQLTqueue.class), any(Corporation.class));
            JSONObject jsoncorporationdetails = new JSONObject();
            long expected_corporation_id = 10000;
            jsoncorporationdetails.put("corporation_id", expected_corporation_id);
            String expected_name = "name";
            jsoncorporationdetails.put("name", expected_name);
            String expected_ticker = "ticker";
            jsoncorporationdetails.put("ticker", expected_ticker);
            String expected_description = "description";
            jsoncorporationdetails.put("description", expected_description);
            long expected_creator_id = 10001;
            jsoncorporationdetails.put("creator_id", expected_creator_id);
            long expected_ceo_id = 10002;
            jsoncorporationdetails.put("ceo_id", expected_ceo_id);
            long expected_member_count = 110;
            jsoncorporationdetails.put("member_count", expected_member_count);
            double expected_tax_rate = 0.5;
            jsoncorporationdetails.put("tax_rate", expected_tax_rate);
            String inputdate_founded = "2022-01-30T09:10:20Z";
            jsoncorporationdetails.put("date_founded", inputdate_founded);
            Timestamp expected_date_founded = new Timestamp(2022-1900, 0, 30, 9, 10, 20, 0);
            long expected_faction_id = 10003;
            jsoncorporationdetails.put("faction_id", expected_faction_id);
            long expected_home_station_id = 10004;
            jsoncorporationdetails.put("home_station_id", expected_home_station_id);
            long expected_shares = 20000;
            jsoncorporationdetails.put("shares", expected_shares);
            String expected_url = "url";
            jsoncorporationdetails.put("url", expected_url);
            boolean expected_war_eligible = true;
            jsoncorporationdetails.put("war_eligible", expected_war_eligible);
            Corporation corporation = blcorporation.updateCorporation(transactionqueue, jsoncorporationdetails);
            Assert.assertEquals(corporation.getPrimaryKey().getId(), expected_corporation_id);
            Assert.assertEquals(corporation.getName(), expected_name);
            Assert.assertEquals(corporation.getDescription(), expected_description);
            Assert.assertEquals(corporation.getTicker(), expected_ticker);
            Assert.assertEquals(corporation.getCreator(), expected_creator_id);
            Assert.assertEquals(corporation.getCeo(), expected_ceo_id);
            Assert.assertEquals(corporation.getMember_count(), expected_member_count);
            Assert.assertEquals(corporation.getTax_rate(), expected_tax_rate, 0.001);
            Assert.assertEquals(corporation.getDate_founded(), expected_date_founded);
            Assert.assertEquals(corporation.getFactionPK().getId(), expected_faction_id);
            Assert.assertEquals(corporation.getStationPK().getId(), expected_home_station_id);
            Assert.assertEquals(corporation.getShares(), expected_shares);
            Assert.assertEquals(corporation.getUrl(), expected_url);
            Assert.assertEquals(corporation.getWar_eligible(), expected_war_eligible);
        }
        catch(DBException | DataException e) {
        }        
    }
    
    @Test
    public void updateCorporation_missingvalues_test() {
        try {
            doNothing().when(blcorporation).insertupdateCorporation(any(SQLTqueue.class), any(Corporation.class));
            JSONObject jsoncorporationdetails = new JSONObject();
            long expected_corporation_id = 10000;
            jsoncorporationdetails.put("corporation_id", expected_corporation_id);
            String expected_name = "name";
            jsoncorporationdetails.put("name", expected_name);
            String expected_ticker = "ticker";
            jsoncorporationdetails.put("ticker", expected_ticker);
            String expected_description = null;

            long expected_creator_id = 10001;
            jsoncorporationdetails.put("creator_id", expected_creator_id);
            long expected_ceo_id = 10002;
            jsoncorporationdetails.put("ceo_id", expected_ceo_id);
            long expected_member_count = 110;
            jsoncorporationdetails.put("member_count", expected_member_count);
            double expected_tax_rate = 0.5;
            jsoncorporationdetails.put("tax_rate", expected_tax_rate);
            Timestamp expected_date_founded = null;
            
            long expected_faction_id = 0;

            long expected_home_station_id = 0;

            long expected_shares = 0;

            String expected_url = null;

            boolean expected_war_eligible = false;

            Corporation corporation = blcorporation.updateCorporation(transactionqueue, jsoncorporationdetails);
            Assert.assertEquals(corporation.getPrimaryKey().getId(), expected_corporation_id);
            Assert.assertEquals(corporation.getName(), expected_name);
            Assert.assertEquals(corporation.getDescription(), expected_description);
            Assert.assertEquals(corporation.getTicker(), expected_ticker);
            Assert.assertEquals(corporation.getCreator(), expected_creator_id);
            Assert.assertEquals(corporation.getCeo(), expected_ceo_id);
            Assert.assertEquals(corporation.getMember_count(), expected_member_count);
            Assert.assertEquals(corporation.getTax_rate(), expected_tax_rate, 0.001);
            Assert.assertEquals(corporation.getDate_founded(), expected_date_founded);
            Assert.assertEquals(corporation.getFactionPK(), null);
            Assert.assertEquals(corporation.getStationPK(), null);
            Assert.assertEquals(corporation.getShares(), expected_shares);
            Assert.assertEquals(corporation.getUrl(), expected_url);
            Assert.assertEquals(corporation.getWar_eligible(), expected_war_eligible);
        }
        catch(DBException | DataException e) {
        }        
    }
}
