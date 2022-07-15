/*
 * Created on Okt 8, 2021
 * Generated on 11.11.2021 13:40
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMsyssettings_default;
import eve.logicentity.Syssettings;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMsyssettings extends EMsyssettings_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Syssettings syssettings = (Syssettings)super.mapResultSet2Entity(dbresult);
        return syssettings;
    }    
    
}

