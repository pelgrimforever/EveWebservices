/*
 * Created on Okt 8, 2021
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.*;
import data.json.piJson;
import db.ViewMapper;
import eve.eveDatabaseproperties;
import eve.logicview.View_userbp;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_userbp_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_userbp.* from view_userbp";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_userbp"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

