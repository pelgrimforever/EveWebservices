package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import eve.logicentity.Market_group;
import eve.logicentity.Order_history;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.Date;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class BLmarket_groupTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLmarket_group blmarket_group = new BLmarket_group(sqlreader_mock);
    
    public BLmarket_groupTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateMarket_group_test() {
        try {
            doNothing().when(blmarket_group).insertupdateMarket_group(any(SQLTqueue.class), any(Market_group.class));
            JSONObject jsonmarketgroupdetails = new JSONObject();
            long expected_market_group_id = 10000;
            jsonmarketgroupdetails.put("market_group_id", expected_market_group_id);
            String expected_name = "test";
            jsonmarketgroupdetails.put("name", expected_name);
            String expected_description = "testdescription";
            jsonmarketgroupdetails.put("description", expected_description);
            Market_group market_group = blmarket_group.updateMarket_group(transactionqueue, jsonmarketgroupdetails);
            Assert.assertEquals(market_group.getPrimaryKey().getId(), expected_market_group_id);
            Assert.assertEquals(market_group.getName(), expected_name);
            Assert.assertEquals(market_group.getDescription(), expected_description);
        }
        catch(DBException | DataException e) {
        }
    }
    
    @Test
    public void updateParent_test() {
        JSONObject jsonmarketgroupdetails = new JSONObject();
        long expected_parent_group_id = 10000;
        jsonmarketgroupdetails.put("parent_group_id", expected_parent_group_id);
        Market_group marketgroup_input = new Market_group();
        Market_group market_group = blmarket_group.updateParent(marketgroup_input, jsonmarketgroupdetails);
        Assert.assertEquals(market_group.getMarket_groupparent_idPK().getId(), expected_parent_group_id);
    }
}
