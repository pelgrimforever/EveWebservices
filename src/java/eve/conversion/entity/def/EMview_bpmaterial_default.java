/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 31.0.2022 17:49
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import eve.logicview.View_bpmaterial;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_bpmaterial_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMview_bpmaterial_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_bpmaterial.* from view_bpmaterial";
	  
    /**
     * 
     * @return SQL select statement for all View_bpmaterials
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_bpmaterial
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_bpmaterial view_bpmaterial = new View_bpmaterial();
        if(dbresult!=null) {
            try {
                view_bpmaterial.setBp(dbresult.getLong("bp"));
                view_bpmaterial.setMaterial(dbresult.getLong("material"));
                view_bpmaterial.setAmount(dbresult.getLong("amount"));
                view_bpmaterial.setCategory(dbresult.getLong("category"));
                view_bpmaterial.setTypegroupid(dbresult.getLong("typegroupid"));
                view_bpmaterial.setTypegroupname(dbresult.getString("typegroupname"));
                view_bpmaterial.setName(dbresult.getString("name"));
                view_bpmaterial.setAverage(dbresult.getDouble("average"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_bpmaterial;
    }

}

