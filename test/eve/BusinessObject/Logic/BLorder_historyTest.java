package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import eve.logicentity.Order_history;
import general.exception.DBException;
import general.exception.DataException;
import java.sql.Date;
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
public class BLorder_historyTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLorder_history blorder_history = new BLorder_history(sqlreader_mock);
    
    public BLorder_historyTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateOrder_historytest() {
        try {
            doNothing().when(blorder_history).insertupdateOrder_history(any(SQLTqueue.class), any(Order_history.class));
            long regionid = 9000;
            long evetypeid = 9001;
            JSONObject jsonhistory = new JSONObject();
            String inputdate = "2022-01-30";
            jsonhistory.put("date", inputdate);
            Date expected_date = new Date(2022-1900, 0, 30);
            double expected_average = 5000;
            jsonhistory.put("average", expected_average);
            double expected_highest = 6000;
            jsonhistory.put("highest", expected_highest);
            double expected_lowest = 4000;
            jsonhistory.put("lowest", expected_highest);
            long expected_order_count = 20;
            jsonhistory.put("order_count", expected_order_count);
            long expected_volume = 40;
            jsonhistory.put("volume", expected_volume);
            Order_history order_history = blorder_history.updateOrder_history(transactionqueue, regionid, evetypeid, jsonhistory);
            Assert.assertEquals(order_history.getPrimaryKey().getDate(), expected_date);
            Assert.assertEquals(order_history.getAverage(), expected_average, 0.001);
            Assert.assertEquals(order_history.getHighest(), expected_highest, 0.001);
            Assert.assertEquals(order_history.getLowest(), expected_highest, 0.001);
            Assert.assertEquals(order_history.getOrder_count(), expected_order_count);
            Assert.assertEquals(order_history.getVolume(), expected_volume);
        }
        catch(DBException | DataException e) {
        }
    }
    
}
