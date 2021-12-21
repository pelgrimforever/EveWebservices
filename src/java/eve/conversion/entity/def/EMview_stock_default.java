/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 16.11.2021 15:46
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_stock;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_stock_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_stock_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_stock.* from view_stock";
	  
    /**
     * 
     * @return SQL select statement for all View_stocks
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_stock
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

