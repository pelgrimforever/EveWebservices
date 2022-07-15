package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import eve.logicentity.Graphic;
import eve.logicentity.Market_group;
import general.exception.DBException;
import general.exception.DataException;
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
public class BLgraphicTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLgraphic blgraphic = new BLgraphic(sqlreader_mock);
    
    public BLgraphicTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateGraphic_allvalues_test() {
        try {
            doNothing().when(blgraphic).insertupdateGraphic(any(SQLTqueue.class), any(Graphic.class));
            JSONObject jsongraphicdetails = new JSONObject();
            long expected_graphic_id = 10000;
            jsongraphicdetails.put("graphic_id", expected_graphic_id);
            String expected_collision_file = "collision_file";
            jsongraphicdetails.put("collision_file", expected_collision_file);
            String expected_graphic_file = "graphic_file";
            jsongraphicdetails.put("graphic_file", expected_graphic_file);
            String expected_icon_folder = "icon_folder";
            jsongraphicdetails.put("icon_folder", expected_icon_folder);
            String expected_sof_dna = "sof_dna";
            jsongraphicdetails.put("sof_dna", expected_sof_dna);
            String expected_sof_fation_name = "sof_fation_name";
            jsongraphicdetails.put("sof_fation_name", expected_sof_fation_name);
            String expected_sof_hull_name = "sof_hull_name";
            jsongraphicdetails.put("sof_hull_name", expected_sof_hull_name);
            String expected_sof_race_name = "sof_race_name";
            jsongraphicdetails.put("sof_race_name", expected_sof_race_name);
            Graphic graphic = blgraphic.updateGraphic(transactionqueue, jsongraphicdetails);
            Assert.assertEquals(graphic.getPrimaryKey().getId(), expected_graphic_id);
            Assert.assertEquals(graphic.getCollision_file(), expected_collision_file);
            Assert.assertEquals(graphic.getGraphic_file(), expected_graphic_file);
            Assert.assertEquals(graphic.getIcon_folder(), expected_icon_folder);
            Assert.assertEquals(graphic.getSof_dna(), expected_sof_dna);
            Assert.assertEquals(graphic.getSof_fation_name(), expected_sof_fation_name);
            Assert.assertEquals(graphic.getSof_hull_name(), expected_sof_hull_name);
            Assert.assertEquals(graphic.getSof_race_name(), expected_sof_race_name);
        }
        catch(DBException | DataException e) {
        }        
    }
    
    @Test
    public void updateGraphic_novalues_test() {
        try {
            doNothing().when(blgraphic).insertupdateGraphic(any(SQLTqueue.class), any(Graphic.class));
            JSONObject jsongraphicdetails = new JSONObject();
            long expected_graphic_id = 10000;
            jsongraphicdetails.put("graphic_id", expected_graphic_id);
            Graphic graphic = blgraphic.updateGraphic(transactionqueue, jsongraphicdetails);
            Assert.assertEquals(graphic.getPrimaryKey().getId(), expected_graphic_id);
            Assert.assertEquals(graphic.getCollision_file(), null);
            Assert.assertEquals(graphic.getGraphic_file(), null);
            Assert.assertEquals(graphic.getIcon_folder(), null);
            Assert.assertEquals(graphic.getSof_dna(), null);
            Assert.assertEquals(graphic.getSof_fation_name(), null);
            Assert.assertEquals(graphic.getSof_hull_name(), null);
            Assert.assertEquals(graphic.getSof_race_name(), null);
        }
        catch(DBException | DataException e) {
        }        
    }
    
}
