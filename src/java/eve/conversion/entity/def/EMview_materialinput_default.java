/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.4.2022 10:3
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_materialinput;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_materialinput_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_materialinput_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_materialinput.* from view_materialinput";
	  
    /**
     * 
     * @return SQL select statement for all View_materialinputs
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_materialinput
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

