/*
 * EMview_activemodules.java
 *
 * Created on Okt 8, 2021
 * Generated on 19.11.2021 16:16
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_activemodules_default;
import eve.logicview.View_activemodules;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_activemodules
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_activemodules extends EMview_activemodules_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to View_activemodules
     * @param dbresult: Database ResultSet
     * @return View_activemodules
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_activemodules view_activemodules = (View_activemodules)super.mapResultSet2Entity(dbresult);
        return view_activemodules;
    }    
    
}

