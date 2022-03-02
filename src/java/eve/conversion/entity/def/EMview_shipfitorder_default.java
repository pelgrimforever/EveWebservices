/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 22.1.2022 10:55
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_shipfitorder;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_shipfitorder_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_shipfitorder_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_shipfitorder.* from view_shipfitorder";
	  
    /**
     * 
     * @return SQL select statement for all View_shipfitorders
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_shipfitorder
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

