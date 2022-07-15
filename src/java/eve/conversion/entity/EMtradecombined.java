/*
 * Created on Okt 8, 2021
 * Generated on 22.10.2021 17:26
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMtradecombined_default;
import eve.logicentity.Tradecombined;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMtradecombined extends EMtradecombined_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Tradecombined tradecombined = (Tradecombined)super.mapResultSet2Entity(dbresult);
        return tradecombined;
    }    
    
}

