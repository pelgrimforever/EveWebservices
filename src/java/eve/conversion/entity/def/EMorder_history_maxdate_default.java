/*
 * Created on Okt 8, 2021
 * Generated on 17.6.2022 13:4
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.*;
import data.json.piJson;
import db.ViewMapper;
import eve.eveDatabaseproperties;
import eve.logicview.Order_history_maxdate;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMorder_history_maxdate_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select order_history_maxdate.* from order_history_maxdate";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "order_history_maxdate"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Order_history_maxdate order_history_maxdate = new Order_history_maxdate();
        if(dbresult!=null) {
            try {
                order_history_maxdate.setMaxdate(dbresult.getDate("maxdate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return order_history_maxdate;
    }

}

