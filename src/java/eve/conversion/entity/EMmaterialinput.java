/*
 * EMmaterialinput.java
 *
 * Created on Okt 8, 2021
 * Generated on 17.0.2022 13:37
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMmaterialinput_default;
import eve.logicentity.Materialinput;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMmaterialinput
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMmaterialinput extends EMmaterialinput_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Materialinput
     * @param dbresult: Database ResultSet
     * @return Materialinput
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Materialinput materialinput = (Materialinput)super.mapResultSet2Entity(dbresult);
        return materialinput;
    }    
    
}

