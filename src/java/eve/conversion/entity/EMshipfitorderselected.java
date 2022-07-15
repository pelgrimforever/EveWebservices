/*
 * Created on Okt 8, 2021
 * Generated on 20.11.2021 17:22
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMshipfitorderselected_default;
import eve.logicentity.Shipfitorderselected;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMshipfitorderselected extends EMshipfitorderselected_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Shipfitorderselected shipfitorderselected = (Shipfitorderselected)super.mapResultSet2Entity(dbresult);
        return shipfitorderselected;
    }    
    
}

