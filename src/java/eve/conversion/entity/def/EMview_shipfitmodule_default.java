/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 19.0.2022 22:13
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_shipfitmodule;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_shipfitmodule_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_shipfitmodule_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_shipfitmodule.* from view_shipfitmodule";
	  
    /**
     * 
     * @return SQL select statement for all View_shipfitmodules
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_shipfitmodule
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

