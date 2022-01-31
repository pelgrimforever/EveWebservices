/*
 * EMview_userbpmaterial.java
 *
 * Created on Okt 8, 2021
 * Generated on 31.0.2022 17:49
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_userbpmaterial_default;
import eve.logicview.View_userbpmaterial;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_userbpmaterial
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_userbpmaterial extends EMview_userbpmaterial_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4bp_user = SQLSelectAll + " where bp = :bp: and username = :username:";
    
    /**
     * Map ResultSet Field values to View_userbpmaterial
     * @param dbresult: Database ResultSet
     * @return View_userbpmaterial
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_userbpmaterial view_userbpmaterial = (View_userbpmaterial)super.mapResultSet2Entity(dbresult);
        return view_userbpmaterial;
    }    
    
}

