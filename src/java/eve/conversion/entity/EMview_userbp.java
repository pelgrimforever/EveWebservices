/*
 * EMview_userbp.java
 *
 * Created on Okt 8, 2021
 * Generated on 28.0.2022 15:57
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_userbp_default;
import eve.logicview.View_userbp;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_userbp
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_userbp extends EMview_userbp_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4user = SQLSelectAll + " where username = :username:";

    /**
     * Map ResultSet Field values to View_userbp
     * @param dbresult: Database ResultSet
     * @return View_userbp
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_userbp view_userbp = (View_userbp)super.mapResultSet2Entity(dbresult);
        return view_userbp;
    }    
    
}

