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
import eve.logicview.View_shipfitmodule;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_shipfitmodule_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_shipfitmodule.* from view_shipfitmodule";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_shipfitmodule"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_shipfitmodule view_shipfitmodule = new View_shipfitmodule();
        if(dbresult!=null) {
            try {
                view_shipfitmodule.setModulename(dbresult.getString("modulename"));
                view_shipfitmodule.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_shipfitmodule.setUsername(dbresult.getString("username"));
                view_shipfitmodule.setShipname(dbresult.getString("shipname"));
                view_shipfitmodule.setModuletype(dbresult.getLong("moduletype"));
                view_shipfitmodule.setAmount(dbresult.getInt("amount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_shipfitmodule;
    }

}

