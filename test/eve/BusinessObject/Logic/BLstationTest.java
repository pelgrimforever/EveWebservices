package eve.BusinessObject.Logic;

import db.SQLTqueue;
import db.SQLreader;
import eve.logicentity.Station;
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
public class BLstationTest {
    
    private SQLTqueue transactionqueue = new SQLTqueue();
    
    @Mock(name="sqlreader")
    private SQLreader sqlreader_mock = new SQLreader();
    
    @Spy
    @InjectMocks
    private BLstation blstation = new BLstation(sqlreader_mock);
    
    public BLstationTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void updateStation_allvalues_test() {
        try {
            doNothing().when(blstation).insertupdateStation(any(SQLTqueue.class), any(Station.class));
            JSONObject jsonstationdetails = new JSONObject();
            long expected_station_id = 1000;
            jsonstationdetails.put("station_id", expected_station_id);
            String expected_name = "test";
            jsonstationdetails.put("name", expected_name);
            long expected_type_id = 1001;
            jsonstationdetails.put("type_id", expected_type_id);
            double expected_office_rental_cost = 0.95;
            jsonstationdetails.put("office_rental_cost", expected_office_rental_cost);
            long expected_owner = 1002;
            jsonstationdetails.put("owner", expected_owner);
            long expected_race_id = 1003;
            jsonstationdetails.put("race_id", expected_race_id);
            double expected_reprocessing_efficiency = 0.45;
            jsonstationdetails.put("reprocessing_efficiency", expected_reprocessing_efficiency);
            double expected_reprocessing_stations_take = 0.15;
            jsonstationdetails.put("reprocessing_stations_take", expected_reprocessing_stations_take);
            long expected_system_id = 1004;
            jsonstationdetails.put("system_id", expected_system_id);
            double expected_max_dockable_ship_volume = 9999999;
            jsonstationdetails.put("max_dockable_ship_volume", expected_max_dockable_ship_volume);
            Station station = blstation.updateStation(transactionqueue, jsonstationdetails);
            Assert.assertEquals(station.getPrimaryKey().getId(), expected_station_id);
            Assert.assertEquals(station.getName(), expected_name);
            Assert.assertEquals(station.getEvetypePK().getId(), expected_type_id);
            Assert.assertEquals(station.getOffice_rental_cost(), expected_office_rental_cost, 0.001);
            Assert.assertEquals(station.getOwner(), expected_owner);
            Assert.assertEquals(station.getRacePK().getId(), expected_race_id);
            Assert.assertEquals(station.getReprocessing_efficiency(), expected_reprocessing_efficiency, 0.001);
            Assert.assertEquals(station.getReprocessing_stations_take(), expected_reprocessing_stations_take, 0.001);
            Assert.assertEquals(station.getSystemPK().getId(), expected_system_id);
            Assert.assertEquals(station.getMax_dockable_ship_volume(), expected_max_dockable_ship_volume, 0.001);
        }
        catch(DBException | DataException e) {
        }
    }
    
    @Test
    public void updateStation_missingvalues_test() {
        try {
            doNothing().when(blstation).insertupdateStation(any(SQLTqueue.class), any(Station.class));
            JSONObject jsonstationdetails = new JSONObject();
            long expected_station_id = 1000;
            jsonstationdetails.put("station_id", expected_station_id);
            String expected_name = "test";
            jsonstationdetails.put("name", expected_name);
            long expected_type_id = 1001;
            jsonstationdetails.put("type_id", expected_type_id);
            double expected_office_rental_cost = 0.95;
            jsonstationdetails.put("office_rental_cost", expected_office_rental_cost);
            long expected_owner = 0;
            
            long expected_race_id = 0;
            
            double expected_reprocessing_efficiency = 0.45;
            jsonstationdetails.put("reprocessing_efficiency", expected_reprocessing_efficiency);
            double expected_reprocessing_stations_take = 0.15;
            jsonstationdetails.put("reprocessing_stations_take", expected_reprocessing_stations_take);
            long expected_system_id = 1004;
            jsonstationdetails.put("system_id", expected_system_id);
            double expected_max_dockable_ship_volume = 9999999;
            jsonstationdetails.put("max_dockable_ship_volume", expected_max_dockable_ship_volume);
            Station station = blstation.updateStation(transactionqueue, jsonstationdetails);
            Assert.assertEquals(station.getOwner(), expected_owner);
            Assert.assertEquals(station.getRacePK(), null);
        }
        catch(DBException | DataException e) {
        }
    }
}
