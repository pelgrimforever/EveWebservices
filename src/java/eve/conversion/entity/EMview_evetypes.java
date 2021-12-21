/*
 * EMview_evetypes.java
 *
 * Created on Okt 8, 2021
 * Generated on 18.11.2021 18:23
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_evetypes_default;
import eve.logicview.View_evetypes;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_evetypes
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_evetypes extends EMview_evetypes_default {
//Metacoder: NO AUTHOMATIC UPDATE

    public static final String SQLSelect4Category = SQLSelectAll + " where category = :category: order by name";
    
    /**
     * Map ResultSet Field values to View_evetypes
     * @param dbresult: Database ResultSet
     * @return View_evetypes
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_evetypes view_evetypes = (View_evetypes)super.mapResultSet2Entity(dbresult);
        return view_evetypes;
    }    
    
}

