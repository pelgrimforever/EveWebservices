/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 17.11.2021 15:41
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_shipfit;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_shipfit_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_shipfit_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_shipfit.* from view_shipfit";
	  
    /**
     * 
     * @return SQL select statement for all View_shipfits
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_shipfit
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

