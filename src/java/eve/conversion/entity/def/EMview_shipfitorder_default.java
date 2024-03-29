/*
 * Created on Okt 8, 2021
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.*;
import data.json.piJson;
import db.ViewMapper;
import eve.eveDatabaseproperties;
import eve.logicview.View_shipfitorder;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_shipfitorder_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_shipfitorder.* from view_shipfitorder";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_shipfitorder"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_shipfitorder view_shipfitorder = new View_shipfitorder();
        if(dbresult!=null) {
            try {
                view_shipfitorder.setEvetypename(dbresult.getString("evetypename"));
                view_shipfitorder.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_shipfitorder.setUsername(dbresult.getString("username"));
                view_shipfitorder.setShipname(dbresult.getString("shipname"));
                view_shipfitorder.setEvetype(dbresult.getLong("evetype"));
                view_shipfitorder.setAmountwanted(dbresult.getInt("amountwanted"));
                view_shipfitorder.setAmountinstock(dbresult.getInt("amountinstock"));
                view_shipfitorder.setAmountplanned(dbresult.getLong("amountplanned"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_shipfitorder;
    }

}

