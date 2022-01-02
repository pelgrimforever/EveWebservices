/*
 * EMshipfitorder.java
 *
 * Created on Okt 8, 2021
 * Generated on 19.11.2021 16:16
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMshipfitorder_default;
import eve.logicentity.Shipfitorder;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMshipfitorder
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMshipfitorder extends EMshipfitorder_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLSelect4user = SQLSelect + " where username = :username: order by shipname";
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Shipfitorder
     * @param dbresult: Database ResultSet
     * @return Shipfitorder
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Shipfitorder shipfitorder = (Shipfitorder)super.mapResultSet2Entity(dbresult);
        return shipfitorder;
    }    
    
}

