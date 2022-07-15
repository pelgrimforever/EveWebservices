/*
 * Created on Okt 8, 2021
 * Generated on 2.0.2022 18:23
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMcontractitem_default;
import eve.logicentity.Contractitem;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMcontractitem extends EMcontractitem_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLdeletedeactivateditems = "delete from contractitem where contract in (select id from contract where not active)";

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Contractitem contractitem = (Contractitem)super.mapResultSet2Entity(dbresult);
        return contractitem;
    }    
    
}

