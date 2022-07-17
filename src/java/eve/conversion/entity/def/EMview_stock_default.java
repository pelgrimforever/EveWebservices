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
import eve.logicview.View_stock;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_stock_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_stock.* from view_stock";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_stock"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_stock view_stock = new View_stock();
        if(dbresult!=null) {
            try {
                view_stock.setUsername(dbresult.getString("username"));
                view_stock.setEvetype(dbresult.getLong("evetype"));
                view_stock.setAmount(dbresult.getLong("amount"));
                view_stock.setName(dbresult.getString("name"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_stock;
    }

}

