/*
 * Created on Okt 8, 2021
 * Generated on 13.1.2022 17:48
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMeveuser_default;
import eve.logicentity.Eveuser;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMeveuser
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMeveuser extends EMeveuser_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Eveuser eveuser = (Eveuser)super.mapResultSet2Entity(dbresult);
        return eveuser;
    }    
    
}

