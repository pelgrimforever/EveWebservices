/*
 * EMview_shipfitorderselected.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.11.2021 17:22
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import static eve.conversion.entity.def.EMview_shipfitorder_default.SQLSelectAll;
import eve.conversion.entity.def.EMview_shipfitorderselected_default;
import eve.logicview.View_shipfitorderselected;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_shipfitorderselected
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_shipfitorderselected extends EMview_shipfitorderselected_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4username = SQLSelectAll + " where username = :username: order by regionname, systemname, evetypename";
    public static final String SQLSelect4usernamesystem = SQLSelectAll + " where username = :username: and system = :systemid: order by regionname, systemname, evetypename";

    /**
     * Map ResultSet Field values to View_shipfitorderselected
     * @param dbresult: Database ResultSet
     * @return View_shipfitorderselected
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_shipfitorderselected view_shipfitorderselected = (View_shipfitorderselected)super.mapResultSet2Entity(dbresult);
        return view_shipfitorderselected;
    }    
    
}

