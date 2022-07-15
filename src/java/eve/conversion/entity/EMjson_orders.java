/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMjson_orders_default;
import eve.logicentity.Json_orders;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMjson_orders extends EMjson_orders_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Json_orders json_orders = (Json_orders)super.mapResultSet2Entity(dbresult);
        return json_orders;
    }    
    
}

