/*
 * Created on Okt 8, 2021
 * Generated on 5.3.2022 17:21
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMsystemactivity_default;
import eve.logicentity.Systemactivity;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMsystemactivity extends EMsystemactivity_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Systemactivity systemactivity = (Systemactivity)super.mapResultSet2Entity(dbresult);
        return systemactivity;
    }    
    
}

