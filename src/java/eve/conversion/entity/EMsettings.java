/*
 * Created on Okt 8, 2021
 * Generated on 25.9.2021 14:36
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMsettings_default;
import eve.logicentity.Settings;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMsettings extends EMsettings_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Settings settings = (Settings)super.mapResultSet2Entity(dbresult);
        return settings;
    }    
    
}

