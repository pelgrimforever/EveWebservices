/*
 * EMview_shipfitmodule.java
 *
 * Created on Okt 8, 2021
 * Generated on 18.11.2021 16:29
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_shipfitmodule_default;
import eve.logicview.View_shipfitmodule;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_shipfitmodule
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_shipfitmodule extends EMview_shipfitmodule_default {
//Metacoder: NO AUTHOMATIC UPDATE

    public static final String SQLSelect4shipfit = SQLSelectAll + " where username = :username: and shipname = :shipname: order by modulename";
    
    /**
     * Map ResultSet Field values to View_shipfitmodule
     * @param dbresult: Database ResultSet
     * @return View_shipfitmodule
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_shipfitmodule view_shipfitmodule = (View_shipfitmodule)super.mapResultSet2Entity(dbresult);
        return view_shipfitmodule;
    }    
    
}

