/*
 * Created on Okt 8, 2021
 * Generated on 28.0.2022 15:59
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMuserbp_default;
import eve.logicentity.Userbp;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMuserbp extends EMuserbp_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    
    public static final String SQLSelectMaxserial4Evetype = SQLSelect + 
        " where username = :username: and bp = :evetype.id: " +
        "order by serialnumber desc";

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Userbp userbp = (Userbp)super.mapResultSet2Entity(dbresult);
        return userbp;
    }    
    
}

