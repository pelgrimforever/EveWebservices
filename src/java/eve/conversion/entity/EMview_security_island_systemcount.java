/*
 * EMview_security_island_systemcount.java
 *
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMview_security_island_systemcount_default;
import eve.logicview.View_security_island_systemcount;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_security_island_systemcount
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_security_island_systemcount extends EMview_security_island_systemcount_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to View_security_island_systemcount
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_security_island_systemcount view_security_island_systemcount = (View_security_island_systemcount)super.mapResultSet2Entity(dbresult);
        return view_security_island_systemcount;
    }    
    
}

