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
import eve.logicview.View_materialinput;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_materialinput_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_materialinput.* from view_materialinput";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_materialinput"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_materialinput view_materialinput = new View_materialinput();
        if(dbresult!=null) {
            try {
                view_materialinput.setUsername(dbresult.getString("username"));
                view_materialinput.setEvetype(dbresult.getLong("evetype"));
                view_materialinput.setAddtimestamp(dbresult.getTimestamp("addtimestamp"));
                view_materialinput.setAmount(dbresult.getLong("amount"));
                view_materialinput.setUnitprice(dbresult.getDouble("unitprice"));
                view_materialinput.setUsedamount(dbresult.getLong("usedamount"));
                view_materialinput.setName(dbresult.getString("name"));
                view_materialinput.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_materialinput.setAverage(dbresult.getDouble("average"));
                view_materialinput.setHighest(dbresult.getDouble("highest"));
                view_materialinput.setLowest(dbresult.getDouble("lowest"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_materialinput;
    }

}

