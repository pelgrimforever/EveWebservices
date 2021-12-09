/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.11.2021 14:30
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_trade_systemsevetype;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_trade_systemsevetype_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_trade_systemsevetype_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_trade_systemsevetype.* from view_trade_systemsevetype";
	  
    /**
     * 
     * @return SQL select statement for all View_trade_systemsevetypes
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_trade_systemsevetype
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_trade_systemsevetype view_trade_systemsevetype = new View_trade_systemsevetype();
        if(dbresult!=null) {
            try {
                view_trade_systemsevetype.setSystemsell(dbresult.getLong("systemsell"));
                view_trade_systemsevetype.setSystembuy(dbresult.getLong("systembuy"));
                view_trade_systemsevetype.setEvetype(dbresult.getLong("evetype"));
                view_trade_systemsevetype.setJumps(dbresult.getInt("jumps"));
                view_trade_systemsevetype.setJumpslowsec(dbresult.getInt("jumpslowsec"));
                view_trade_systemsevetype.setJumpsnullsec(dbresult.getInt("jumpsnullsec"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_trade_systemsevetype;
    }

}

