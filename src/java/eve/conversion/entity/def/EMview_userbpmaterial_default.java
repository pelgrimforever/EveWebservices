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
import eve.logicview.View_userbpmaterial;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_userbpmaterial_default implements eveDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_userbpmaterial.* from view_userbpmaterial";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_userbpmaterial"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_userbpmaterial view_userbpmaterial = new View_userbpmaterial();
        if(dbresult!=null) {
            try {
                view_userbpmaterial.setUsername(dbresult.getString("username"));
                view_userbpmaterial.setSerialnumber(dbresult.getInt("serialnumber"));
                view_userbpmaterial.setBp(dbresult.getLong("bp"));
                view_userbpmaterial.setMaterial(dbresult.getLong("material"));
                view_userbpmaterial.setAmount(dbresult.getLong("amount"));
                view_userbpmaterial.setCategory(dbresult.getLong("category"));
                view_userbpmaterial.setTypegroupid(dbresult.getLong("typegroupid"));
                view_userbpmaterial.setTypegroupname(dbresult.getString("typegroupname"));
                view_userbpmaterial.setName(dbresult.getString("name"));
                view_userbpmaterial.setMarketaverage(dbresult.getDouble("marketaverage"));
                view_userbpmaterial.setMaterialinputaverage(dbresult.getDouble("materialinputaverage"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_userbpmaterial;
    }

}

