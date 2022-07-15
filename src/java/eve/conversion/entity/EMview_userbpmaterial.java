/*
 * Created on Okt 8, 2021
 * Generated on 31.0.2022 17:49
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_userbpmaterial_default;
import eve.logicview.View_userbpmaterial;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_userbpmaterial extends EMview_userbpmaterial_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4bp_user = SQLSelectAll + " where bp = :bp: and username = :username: and serialnumber = :serialnumber:";
    
    public static final String SQLSimulate4bp_user = "SELECT :username: as username, " +
        "0 as serialnumber, bpmaterial.bp, bpmaterial.material, bpmaterial.amount, typegroup.category, typegroup.id AS typegroupid, typegroup.name AS typegroupname, evetype.name, evetype.average AS marketaverage, miavg.avgunitprice AS materialinputaverage FROM userbp " +
        "JOIN bpmaterial ON bpmaterial.bp = userbp.bp " +
        "JOIN evetype ON bpmaterial.material = evetype.id " +
        "JOIN typegroup ON evetype.typegroup = typegroup.id " +
        "LEFT JOIN ( SELECT materialinput.username, materialinput.evetype, " +
        "sum(materialinput.unitprice * materialinput.amount) / sum(materialinput.amount) AS avgunitprice " +
        "FROM materialinput " +
        "JOIN evetype evetype_1 ON evetype_1.id = materialinput.evetype " +
        "GROUP BY materialinput.username, materialinput.evetype) miavg " +
        "ON miavg.evetype = bpmaterial.material AND miavg.username::text = :username: " +
        "where bpmaterial.bp = :bp:";
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_userbpmaterial view_userbpmaterial = (View_userbpmaterial)super.mapResultSet2Entity(dbresult);
        return view_userbpmaterial;
    }    
    
}

