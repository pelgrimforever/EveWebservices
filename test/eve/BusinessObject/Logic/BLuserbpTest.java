package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLparameters;
import db.SQLreader;
import db.TableIO;
import eve.conversion.entity.EMuserbp;
import eve.entity.pk.UserbpPK;
import eve.interfaces.logicentity.IUserbp;
import eve.logicentity.Userbp;
import general.exception.DBException;
import general.exception.DataException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author Franky Laseure
 */
public class BLuserbpTest {
    
    private Userbp userbp = new Userbp(new UserbpPK());
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    SQLreader sqlreader_mock = new SQLreader();
    @Mock(name="tableio")
    private TableIO tableio_mock = new TableIO(sqlreader_mock, new EMuserbp());
    
    @Spy
    @InjectMocks
    BLuserbp bluserbp = new BLuserbp(sqlreader_mock);
    
    public BLuserbpTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void insertNewbp_noserialnumbers_found_test() {
        try {
            doReturn(null).when(bluserbp).getEntity(anyString(), any(SQLparameters.class));
            doNothing().when(bluserbp).insertUserbp(any(SQLTqueue.class), any(IUserbp.class));
            bluserbp.insertNewbp(transactionqueue, userbp);
            Assert.assertEquals(userbp.getPrimaryKey().getSerialnumber(), 0);
        }
        catch(DBException | DataException e) {
        }
    }
    
    @Test
    public void insertNewbp_serialnumbers_found_test() {
        try {
            Userbp existinguserbp = new Userbp(new UserbpPK());
            existinguserbp.getPrimaryKey().setSerialnumber(1);
            doReturn(existinguserbp).when(bluserbp).getEntity(anyString(), any(SQLparameters.class));
            doNothing().when(bluserbp).insertUserbp(any(SQLTqueue.class), any(IUserbp.class));
            bluserbp.insertNewbp(transactionqueue, userbp);
            Assert.assertEquals(userbp.getPrimaryKey().getSerialnumber(), 2);
        }
        catch(DBException | DataException e) {
        }
    }

    @Test
    public void updateProperties_test() {
        try {
            Userbp newuserbp = new Userbp(new UserbpPK());
            int expectedtotalamount = 100;
            newuserbp.setTotalamount(expectedtotalamount);
            double expectedbpprice = 1000000;
            newuserbp.setBpprice(expectedbpprice);
            int expectedamountproduced = 10;
            newuserbp.setAmountproduced(expectedamountproduced);
            int expectedmaterialefficiency = 10;
            newuserbp.setMaterialefficiency(expectedmaterialefficiency);
            double expectedresearchcost = 5500;
            newuserbp.setResearchcost(expectedresearchcost);
            doReturn(userbp).when(bluserbp).getUserbp(any(UserbpPK.class));
            doNothing().when(tableio_mock).updateEntity(any(SQLTqueue.class), any(IUserbp.class));
            bluserbp.updateProperties(transactionqueue, newuserbp);
            Assert.assertEquals(userbp.getTotalamount(), expectedtotalamount);
            Assert.assertEquals(userbp.getBpprice(), expectedbpprice);
            Assert.assertEquals(userbp.getAmountproduced(), expectedamountproduced);
            Assert.assertEquals(userbp.getMaterialefficiency(), expectedmaterialefficiency);
            Assert.assertEquals(userbp.getResearchcost(), expectedresearchcost);
        }
        catch(DBException | DataException e) {
        }
    }
}
