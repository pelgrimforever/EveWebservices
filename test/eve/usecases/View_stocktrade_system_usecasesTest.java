package eve.usecases;

import db.SQLreader;
import eve.BusinessObject.Logic.BLsyssettings;
import eve.BusinessObject.Logic.BLusersettings;
import eve.BusinessObject.Logic.BLview_stocktrade_system;
import eve.logicentity.Settings;
import eve.logicentity.Syssettings;
import eve.logicentity.Usersettings;
import eve.logicview.View_stocktrade_system;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;

/**
 * @author Franky Laseure
 */
public class View_stocktrade_system_usecasesTest {
    
    private ArrayList<Usersettings> usersettings;
    private ArrayList<View_stocktrade_system> viewstocktradesystems;
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    @Mock(name="blview_stocktrade_system")
    private BLview_stocktrade_system blview_stocktrade_system_mock = new BLview_stocktrade_system(sqlreader_mock);
    @Mock(name="usersettings_usecases")
    private Usersettings_usecases usersettings_usecases_mock = new Usersettings_usecases();
    @Mock(name="blusersettings")
    private BLusersettings blusersettings_mock = new BLusersettings(sqlreader_mock);
    @Mock(name="blsyssettings")
    private BLsyssettings blsyssettings_mock = new BLsyssettings(sqlreader_mock);
    @InjectMocks
    private View_stocktrade_system_usecases View_stocktrade_system_usecases;
    
    public View_stocktrade_system_usecasesTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
        usersettings = new ArrayList<>();
        viewstocktradesystems = new ArrayList<>();
    }

    @Test
    public void getView_stocktrade_system4username_usecase_test() {
        try {
            Usersettings usersettingStocksystemid = new Usersettings("user", Settings.STOCKSYSTEMID);
            usersettingStocksystemid.setValue("1000");
            usersettings.add(usersettingStocksystemid);
            doReturn(usersettings).when(usersettings_usecases_mock).get_all_4user_usecase(anyString());
            Syssettings syssettingBrokerfee = new Syssettings(Syssettings.BROKER_FEE);
            syssettingBrokerfee.setValue("0.08");
            doReturn(usersettingStocksystemid).when(blusersettings_mock).getUsersetting(any(ArrayList.class), anyString());
            doReturn(syssettingBrokerfee).when(blsyssettings_mock).getSyssettings(anyString());
            View_stocktrade_system view_stocktrade_system = new View_stocktrade_system();
            view_stocktrade_system.setSellprice(2000);
            viewstocktradesystems.add(view_stocktrade_system);
            doReturn(viewstocktradesystems).when(blview_stocktrade_system_mock).getViewstocktradesystems_for_user_startsystem(anyString(), anyLong());
            ArrayList<View_stocktrade_system> result = View_stocktrade_system_usecases.getView_stocktrade_system4username_usecase("user");
            View_stocktrade_system result1 = result.get(0);
            double expected_sellprice = 1840;
            Assert.assertEquals(result1.getSellprice(), expected_sellprice, 0.001);
        }
        catch(DataException | DBException e) {
        }
    }
    
}
