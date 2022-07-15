/*
 * Created on Okt 8, 2021
 * Generated on 17.11.2021 15:28
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMshipfit_default;
import eve.logicentity.Shipfit;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMshipfit extends EMshipfit_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Shipfit shipfit = (Shipfit)super.mapResultSet2Entity(dbresult);
        return shipfit;
    }    
    
}

