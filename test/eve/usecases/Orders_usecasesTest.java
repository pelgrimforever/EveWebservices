package eve.usecases;

import db.SQLreader;
import eve.BusinessObject.Logic.BLorders;
import eve.BusinessObject.Logic.BLview_tradecombined_sell;
import eve.entity.pk.OrdersPK;
import eve.interfaces.entity.pk.IOrdersPK;
import general.exception.DBException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class Orders_usecasesTest {
    
    @Spy
    private Orders_usecases orders_usecases_mock = new Orders_usecases();
    
    public Orders_usecasesTest() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void get_ordersupdate_usecase_test() {
        try {
            OrdersPK sellordersPK = new OrdersPK(0);
            OrdersPK buyordersPK = new OrdersPK(1);
            doReturn(20l).doReturn(10l).when(orders_usecases_mock).get_order_amount_from_swagger(any(OrdersPK.class));
            Orders_usecases.Orderupdate_data testresult = orders_usecases_mock.get_ordersupdate_usecase(sellordersPK, buyordersPK);
            Assert.assertEquals(testresult.getSellamount(), 20);
            Assert.assertEquals(testresult.getBuyamount(), 10);
        }
        catch(DBException e) {
        }
    }
    
}
