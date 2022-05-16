/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 13.4.2022 19:13
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_userbp;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_userbp_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_userbp_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_userbp.* from view_userbp";
	  
    /**
     * 
     * @return SQL select statement for all View_userbps
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_userbp
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_userbp view_userbp = new View_userbp();
        if(dbresult!=null) {
            try {
                view_userbp.setBlueprintname(dbresult.getString("blueprintname"));
                view_userbp.setTypegroupname(dbresult.getString("typegroupname"));
                view_userbp.setUsername(dbresult.getString("username"));
                view_userbp.setBp(dbresult.getLong("bp"));
                view_userbp.setSerialnumber(dbresult.getInt("serialnumber"));
                view_userbp.setOriginal(dbresult.getBoolean("original"));
                view_userbp.setMaterialefficiency(dbresult.getInt("materialefficiency"));
                view_userbp.setAmountproduced(dbresult.getInt("amountproduced"));
                view_userbp.setTotalamount(dbresult.getInt("totalamount"));
                view_userbp.setBpprice(dbresult.getDouble("bpprice"));
                view_userbp.setResearchcost(dbresult.getDouble("researchcost"));
                view_userbp.setStationfee(dbresult.getDouble("stationfee"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_userbp;
    }

}

