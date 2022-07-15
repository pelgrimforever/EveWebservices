/*
 * Created on Okt 8, 2021
 * Generated on 13.6.2022 11:21
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.*;
import data.json.piJson;
import db.ViewMapper;
import eve.eveDatabaseproperties;
import eve.logicview.View_shipfit;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_shipfit_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_shipfit.* from view_shipfit";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_shipfit"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_shipfit view_shipfit = new View_shipfit();
        if(dbresult!=null) {
            try {
                view_shipfit.setShiptype(dbresult.getString("shiptype"));
                view_shipfit.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_shipfit.setUsername(dbresult.getString("username"));
                view_shipfit.setShipname(dbresult.getString("shipname"));
                view_shipfit.setEvetype(dbresult.getLong("evetype"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_shipfit;
    }

}

