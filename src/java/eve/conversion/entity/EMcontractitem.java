/*
 * EMcontractitem.java
 *
 * Created on Okt 8, 2021
 * Generated on 2.0.2022 18:23
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMcontractitem_default;
import eve.logicentity.Contractitem;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMcontractitem
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMcontractitem extends EMcontractitem_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLdeletedeactivateditems = "delete from contractitem where contract in (select id from contract where not active)";
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Contractitem
     * @param dbresult: Database ResultSet
     * @return Contractitem
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Contractitem contractitem = (Contractitem)super.mapResultSet2Entity(dbresult);
        return contractitem;
    }    
    
}

