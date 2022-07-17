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
import eve.logicview.View_trade_systemsevetype;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_trade_systemsevetype_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_trade_systemsevetype.* from view_trade_systemsevetype";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_trade_systemsevetype"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

