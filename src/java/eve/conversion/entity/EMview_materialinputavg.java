/*
 * EMview_materialinputavg.java
 *
 * Created on Okt 8, 2021
 * Generated on 23.0.2022 17:52
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_materialinputavg_default;
import eve.logicview.View_materialinputavg;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_materialinputavg
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_materialinputavg extends EMview_materialinputavg_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4username = SQLSelectAll + " where username = :username: order by name";
    
    /**
     * Map ResultSet Field values to View_materialinputavg
     * @param dbresult: Database ResultSet
     * @return View_materialinputavg
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_materialinputavg view_materialinputavg = (View_materialinputavg)super.mapResultSet2Entity(dbresult);
        return view_materialinputavg;
    }    
    
}

