package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import eve.logicentity.Evetype;
import eve.logicentity.Faction;
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
public class BLevetypeTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLevetype blevetype = new BLevetype(sqlreader_mock);
    
    public BLevetypeTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateEvetype_allvalues_test() {
        try {
            doNothing().when(blevetype).insertupdateEvetype(any(SQLTqueue.class), any(Evetype.class));
            JSONObject jsontypedetails = new JSONObject();
            long expected_type_id = 10000;
            jsontypedetails.put("type_id", expected_type_id);
            String expected_name = "name";
            jsontypedetails.put("name", expected_name);
            String expected_description = "description";
            jsontypedetails.put("description", expected_description);
            long expected_group_id = 10001;
            jsontypedetails.put("group_id", expected_group_id);
            boolean expected_published = true;
            jsontypedetails.put("published", expected_published);
            long expected_market_group_id = 10002;
            jsontypedetails.put("market_group_id", expected_market_group_id);
            double expected_capacity = 500;
            jsontypedetails.put("capacity", expected_capacity);
            long expected_graphic_id = 10003;
            jsontypedetails.put("graphic_id", expected_graphic_id);
            long expected_icon_id = 10004;
            jsontypedetails.put("icon_id", expected_icon_id);
            double expected_mass = 200000;
            jsontypedetails.put("mass", expected_mass);
            double expected_packaged_volume = 2500;
            jsontypedetails.put("packaged_volume", expected_packaged_volume);
            long expected_portion_size = 100;
            jsontypedetails.put("portion_size", expected_portion_size);
            double expected_radius = 60;
            jsontypedetails.put("radius", expected_radius);
            double expected_volume = 50000;
            jsontypedetails.put("volume", expected_volume);
            Evetype evetype = blevetype.updateEvetype(transactionqueue, jsontypedetails);
            Assert.assertEquals(evetype.getPrimaryKey().getId(), expected_type_id);
            Assert.assertEquals(evetype.getName(), expected_name);
            Assert.assertEquals(evetype.getDescription(), expected_description);
            Assert.assertEquals(evetype.getTypegroupPK().getId(), expected_group_id);
            Assert.assertEquals(evetype.getPublished(), expected_published);
            Assert.assertEquals(evetype.getMarket_groupPK().getId(), expected_market_group_id);
            Assert.assertEquals(evetype.getCapacity(), expected_capacity, 0.001);
            Assert.assertEquals(evetype.getGraphicPK().getId(), expected_graphic_id);
            Assert.assertEquals(evetype.getIcon(), expected_icon_id);
            Assert.assertEquals(evetype.getMass(), expected_mass, 0.001);
            Assert.assertEquals(evetype.getPackaged_volume(), expected_packaged_volume, 0.001);
            Assert.assertEquals(evetype.getPortion_size(), expected_portion_size);
            Assert.assertEquals(evetype.getRadius(), expected_radius, 0.001);
            Assert.assertEquals(evetype.getVolume(), expected_volume, 0.001);
        }
        catch(DBException | DataException e) {
        }        
    }
    
    @Test
    public void updateEvetype_missingvalues_test() {
        try {
            doNothing().when(blevetype).insertupdateEvetype(any(SQLTqueue.class), any(Evetype.class));
            JSONObject jsontypedetails = new JSONObject();
            long expected_type_id = 10000;
            jsontypedetails.put("type_id", expected_type_id);
            String expected_name = "name";
            jsontypedetails.put("name", expected_name);
            String expected_description = "description";
            jsontypedetails.put("description", expected_description);
            long expected_group_id = 10001;
            jsontypedetails.put("group_id", expected_group_id);
            boolean expected_published = true;
            jsontypedetails.put("published", expected_published);
            long expected_market_group_id = 0;
            double expected_capacity = 0;
            long expected_graphic_id = 0;
            long expected_icon_id = 0;
            double expected_mass = 0;
            double expected_packaged_volume = 0;
            long expected_portion_size = 0;
            double expected_radius = 0;
            double expected_volume = 0;
            Evetype evetype = blevetype.updateEvetype(transactionqueue, jsontypedetails);
            Assert.assertEquals(evetype.getPrimaryKey().getId(), expected_type_id);
            Assert.assertEquals(evetype.getName(), expected_name);
            Assert.assertEquals(evetype.getDescription(), expected_description);
            Assert.assertEquals(evetype.getTypegroupPK().getId(), expected_group_id);
            Assert.assertEquals(evetype.getPublished(), expected_published);
            Assert.assertEquals(evetype.getMarket_groupPK(), null);
            Assert.assertEquals(evetype.getCapacity(), expected_capacity, 0.001);
            Assert.assertEquals(evetype.getGraphicPK(), null);
            Assert.assertEquals(evetype.getIcon(), expected_icon_id);
            Assert.assertEquals(evetype.getMass(), expected_mass, 0.001);
            Assert.assertEquals(evetype.getPackaged_volume(), expected_packaged_volume, 0.001);
            Assert.assertEquals(evetype.getPortion_size(), expected_portion_size);
            Assert.assertEquals(evetype.getRadius(), expected_radius, 0.001);
            Assert.assertEquals(evetype.getVolume(), expected_volume, 0.001);
        }
        catch(DBException | DataException e) {
        }        
    }
}
