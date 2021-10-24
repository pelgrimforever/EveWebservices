/*
 * EMview_systemtradeorders.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_systemtradeorders_default;
import eve.logicview.View_systemtradeorders;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_systemtradeorders
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_systemtradeorders extends EMview_systemtradeorders_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to View_systemtradeorders
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_systemtradeorders view_systemtradeorders = (View_systemtradeorders)super.mapResultSet2Entity(dbresult);
        return view_systemtradeorders;
    }    
    
}

