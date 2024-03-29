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
import eve.logicview.View_contractitem;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_contractitem_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_contractitem.* from view_contractitem";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_contractitem"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_contractitem view_contractitem = new View_contractitem();
        if(dbresult!=null) {
            try {
                view_contractitem.setId(dbresult.getLong("id"));
                view_contractitem.setContract(dbresult.getLong("contract"));
                view_contractitem.setBlueprint_copy(dbresult.getBoolean("blueprint_copy"));
                view_contractitem.setIncluded(dbresult.getBoolean("included"));
                view_contractitem.setQuantity(dbresult.getLong("quantity"));
                view_contractitem.setEvetype(dbresult.getLong("evetype"));
                view_contractitem.setMaterial_efficiency(dbresult.getInt("material_efficiency"));
                view_contractitem.setRuns(dbresult.getInt("runs"));
                view_contractitem.setTime_efficiency(dbresult.getInt("time_efficiency"));
                view_contractitem.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_contractitem.setTypename(dbresult.getString("typename"));
                view_contractitem.setTypegroupid(dbresult.getLong("typegroupid"));
                view_contractitem.setGroupname(dbresult.getString("groupname"));
                view_contractitem.setCategoryid(dbresult.getLong("categoryid"));
                view_contractitem.setCategoryname(dbresult.getString("categoryname"));
                view_contractitem.setAvg_buyorder(dbresult.getDouble("avg_buyorder"));
                view_contractitem.setMin_buyorder(dbresult.getDouble("min_buyorder"));
                view_contractitem.setMax_buyorder(dbresult.getDouble("max_buyorder"));
                view_contractitem.setAvg_sellorder(dbresult.getDouble("avg_sellorder"));
                view_contractitem.setMin_selorder(dbresult.getDouble("min_selorder"));
                view_contractitem.setMax_selorder(dbresult.getDouble("max_selorder"));
                view_contractitem.setAverage(dbresult.getDouble("average"));
                view_contractitem.setHighest(dbresult.getDouble("highest"));
                view_contractitem.setLowest(dbresult.getDouble("lowest"));
                view_contractitem.setOrder_count(dbresult.getLong("order_count"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_contractitem;
    }

}

