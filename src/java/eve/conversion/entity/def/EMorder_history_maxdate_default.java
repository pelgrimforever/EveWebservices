/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 14.0.2022 16:56
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.Order_history_maxdate;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMorder_history_maxdate_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMorder_history_maxdate_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select order_history_maxdate.* from order_history_maxdate";
	  
    /**
     * 
     * @return SQL select statement for all Order_history_maxdates
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Order_history_maxdate
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

