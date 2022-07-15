package eve.usecases;

import db.SQLreader;
import eve.BusinessObject.Logic.BLview_tradecombined_sell;
import eve.entity.pk.SystemPK;
import eve.entity.pk.TradecombinedPK;
import eve.logicview.View_order;
import eve.logicview.View_tradecombined_sell;
import eve.usecases.custom.Swagger_usecases;
import general.exception.DBException;
import java.util.ArrayList;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;

/**
 * @author Franky Laseure
 */
public class View_tradecombined_sell_usecasesTest {
    
    public View_tradecombined_sell_usecasesTest() {
    }
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock;
    
    @Mock(name="blview_tradecombined_sell")
    private BLview_tradecombined_sell blview_tradecombined_sell_mock = new BLview_tradecombined_sell(sqlreader_mock);
    
    @Mock(name="view_order_usecases")
    private View_order_usecases view_order_usecases_mock = new View_order_usecases(true);
    
    @Mock(name="swaggerorder")
    private Swagger_usecases swagger_usecases_mock = new Swagger_usecases();
    
    @InjectMocks
    private View_tradecombined_sell_usecases view_tradecombined_sell_usecases;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getView_tradecombined_sells_for_evetype_test_Swagger_finds_noorders() {
        try {
            //mock tradelines orderlines from database
            ArrayList<View_tradecombined_sell> tradelines = new ArrayList<>();
            View_tradecombined_sell tradeline1 = new View_tradecombined_sell();
            tradeline1.setSell_id(0);
            tradeline1.setBuy_id(1);
            tradelines.add(tradeline1);
            doReturn(tradelines).when(blview_tradecombined_sell_mock).getView_tradecombined_sells_for_evetype(any(TradecombinedPK.class));
            //mock return values for orders
            View_order sellorder1 = new View_order();
            sellorder1.setRegion(0);
            sellorder1.setPage(0);
            sellorder1.setId(tradeline1.getSell_id());
            sellorder1.setVolume_remain(10);
            doReturn(sellorder1).when(view_order_usecases_mock).getView_order_for_orderid_usecase(tradeline1.getSell_id());
            View_order buyorder1 = new View_order();
            buyorder1.setRegion(1);
            buyorder1.setPage(0);
            buyorder1.setId(tradeline1.getSell_id());
            buyorder1.setVolume_remain(5);
            doReturn(buyorder1).when(view_order_usecases_mock).getView_order_for_orderid_usecase(tradeline1.getBuy_id());
            //mock swagger calls
            doReturn(null).when(swagger_usecases_mock).findOrder(sellorder1.getRegion(), sellorder1.getPage(), sellorder1.getId());
            doReturn(null).when(swagger_usecases_mock).findOrder(buyorder1.getRegion(), buyorder1.getPage(), buyorder1.getId());
            //test usecase
            TradecombinedPK tradecombinedPK = new TradecombinedPK();
            ArrayList<View_tradecombined_sell> resultarray = view_tradecombined_sell_usecases.getView_tradecombined_sells_for_evetype(tradecombinedPK);
            View_tradecombined_sell resultfirstline = resultarray.get(0);
            Assert.assertEquals(resultfirstline.getSell_updated(), 0);
            Assert.assertEquals(resultfirstline.getBuy_updated(), 0);
        }
        catch(DBException e) {
            System.out.println(e.getDetailedMessage());
        }
    }
    
    @Test
    public void getView_tradecombined_sells_for_evetype_test_Swagger_finds_orders() {
        try {
            //mock tradelines orderlines from database
            ArrayList<View_tradecombined_sell> tradelines = new ArrayList<>();
            View_tradecombined_sell tradeline1 = new View_tradecombined_sell();
            tradeline1.setSell_id(0);
            tradeline1.setBuy_id(1);
            tradelines.add(tradeline1);
            doReturn(tradelines).when(blview_tradecombined_sell_mock).getView_tradecombined_sells_for_evetype(any(TradecombinedPK.class));
            //mock return values for orders
            View_order sellorder1 = new View_order();
            sellorder1.setRegion(0);
            sellorder1.setPage(0);
            sellorder1.setId(tradeline1.getSell_id());
            sellorder1.setVolume_remain(10);
            doReturn(sellorder1).when(view_order_usecases_mock).getView_order_for_orderid_usecase(tradeline1.getSell_id());
            View_order buyorder1 = new View_order();
            buyorder1.setRegion(1);
            buyorder1.setPage(0);
            buyorder1.setId(tradeline1.getSell_id());
            buyorder1.setVolume_remain(5);
            doReturn(buyorder1).when(view_order_usecases_mock).getView_order_for_orderid_usecase(tradeline1.getBuy_id());
            //mock swagger calls
            JSONObject jsonsellorder1 = new JSONObject();
            long expectedsellvolumeremain = 10;
            jsonsellorder1.put("volume_remain", expectedsellvolumeremain);
            doReturn(jsonsellorder1).when(swagger_usecases_mock).findOrder(sellorder1.getRegion(), sellorder1.getPage(), sellorder1.getId());
            JSONObject jsonbuyorder1 = new JSONObject();
            long expectedbuyvolumeremain = 3;
            jsonbuyorder1.put("volume_remain", expectedbuyvolumeremain);
            doReturn(jsonbuyorder1).when(swagger_usecases_mock).findOrder(buyorder1.getRegion(), buyorder1.getPage(), buyorder1.getId());
            //test usecase
            TradecombinedPK tradecombinedPK = new TradecombinedPK();
            ArrayList<View_tradecombined_sell> resultarray = view_tradecombined_sell_usecases.getView_tradecombined_sells_for_evetype(tradecombinedPK);
            View_tradecombined_sell resultfirstline = resultarray.get(0);
            Assert.assertEquals(resultfirstline.getSell_updated(), expectedsellvolumeremain);
            Assert.assertEquals(resultfirstline.getBuy_updated(), expectedbuyvolumeremain);
        }
        catch(DBException e) {
            System.out.println(e.getDetailedMessage());
        }
    }
    
    @Test
    public void getView_tradecombined_sells_for_all_evetypes_test_Swagger_finds_noorders() {
        try {
            //mock tradelines orderlines from database
            ArrayList<View_tradecombined_sell> tradelines = new ArrayList<>();
            View_tradecombined_sell tradeline1 = new View_tradecombined_sell();
            tradeline1.setSell_id(0);
            tradeline1.setBuy_id(1);
            tradelines.add(tradeline1);
            doReturn(tradelines).when(blview_tradecombined_sell_mock).getView_tradecombined_sells_for_all_evetypes(any(SystemPK.class), any(SystemPK.class));
            //mock return values for orders
            View_order sellorder1 = new View_order();
            sellorder1.setRegion(0);
            sellorder1.setPage(0);
            sellorder1.setId(tradeline1.getSell_id());
            sellorder1.setVolume_remain(10);
            doReturn(sellorder1).when(view_order_usecases_mock).getView_order_for_orderid_usecase(tradeline1.getSell_id());
            View_order buyorder1 = new View_order();
            buyorder1.setRegion(1);
            buyorder1.setPage(0);
            buyorder1.setId(tradeline1.getSell_id());
            buyorder1.setVolume_remain(5);
            doReturn(buyorder1).when(view_order_usecases_mock).getView_order_for_orderid_usecase(tradeline1.getBuy_id());
            //mock swagger calls
            doReturn(null).when(swagger_usecases_mock).findOrder(sellorder1.getRegion(), sellorder1.getPage(), sellorder1.getId());
            doReturn(null).when(swagger_usecases_mock).findOrder(buyorder1.getRegion(), buyorder1.getPage(), buyorder1.getId());
            //test usecase
            SystemPK systemPK = new SystemPK();
            ArrayList<View_tradecombined_sell> resultarray = view_tradecombined_sell_usecases.getView_tradecombined_sells_for_all_evetypes(systemPK, systemPK);
            View_tradecombined_sell resultfirstline = resultarray.get(0);
            Assert.assertEquals(resultfirstline.getSell_updated(), 0);
            Assert.assertEquals(resultfirstline.getBuy_updated(), 0);
        }
        catch(DBException e) {
            System.out.println(e.getDetailedMessage());
        }
    }
    
    @Test
    public void getView_tradecombined_sells_for_all_evetypes_test_Swagger_finds_orders() {
        try {
            //mock tradelines orderlines from database
            ArrayList<View_tradecombined_sell> tradelines = new ArrayList<>();
            View_tradecombined_sell tradeline1 = new View_tradecombined_sell();
            tradeline1.setSell_id(0);
            tradeline1.setBuy_id(1);
            tradelines.add(tradeline1);
            doReturn(tradelines).when(blview_tradecombined_sell_mock).getView_tradecombined_sells_for_all_evetypes(any(SystemPK.class), any(SystemPK.class));
            //mock return values for orders
            View_order sellorder1 = new View_order();
            sellorder1.setRegion(0);
            sellorder1.setPage(0);
            sellorder1.setId(tradeline1.getSell_id());
            sellorder1.setVolume_remain(10);
            doReturn(sellorder1).when(view_order_usecases_mock).getView_order_for_orderid_usecase(tradeline1.getSell_id());
            View_order buyorder1 = new View_order();
            buyorder1.setRegion(1);
            buyorder1.setPage(0);
            buyorder1.setId(tradeline1.getSell_id());
            buyorder1.setVolume_remain(5);
            doReturn(buyorder1).when(view_order_usecases_mock).getView_order_for_orderid_usecase(tradeline1.getBuy_id());
            //mock swagger calls
            JSONObject jsonsellorder1 = new JSONObject();
            long expectedsellvolumeremain = 10;
            jsonsellorder1.put("volume_remain", expectedsellvolumeremain);
            doReturn(jsonsellorder1).when(swagger_usecases_mock).findOrder(sellorder1.getRegion(), sellorder1.getPage(), sellorder1.getId());
            JSONObject jsonbuyorder1 = new JSONObject();
            long expectedbuyvolumeremain = 3;
            jsonbuyorder1.put("volume_remain", expectedbuyvolumeremain);
            doReturn(jsonbuyorder1).when(swagger_usecases_mock).findOrder(buyorder1.getRegion(), buyorder1.getPage(), buyorder1.getId());
            //test usecase
            SystemPK systemPK = new SystemPK();
            ArrayList<View_tradecombined_sell> resultarray = view_tradecombined_sell_usecases.getView_tradecombined_sells_for_all_evetypes(systemPK, systemPK);
            View_tradecombined_sell resultfirstline = resultarray.get(0);
            Assert.assertEquals(resultfirstline.getSell_updated(), expectedsellvolumeremain);
            Assert.assertEquals(resultfirstline.getBuy_updated(), expectedbuyvolumeremain);
        }
        catch(DBException e) {
            System.out.println(e.getDetailedMessage());
        }
    }
}
