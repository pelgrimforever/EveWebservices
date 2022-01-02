/*
 * EMview_system.java
 *
 * Created on Okt 8, 2021
 * Generated on 30.11.2021 19:35
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_system_default;
import eve.logicview.View_system;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_system
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_system extends EMview_system_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4startend = "select view_system.* from view_system where system_start = :system_start: and system_end = :system_end:";

    /**
     * Map ResultSet Field values to View_system
     * @param dbresult: Database ResultSet
     * @return View_system
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_system view_system = (View_system)super.mapResultSet2Entity(dbresult);
        return view_system;
    }    
    
}

