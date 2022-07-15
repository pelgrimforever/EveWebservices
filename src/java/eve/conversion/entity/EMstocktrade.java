/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 15:35
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMstocktrade_default;
import eve.logicentity.Stocktrade;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMstocktrade extends EMstocktrade_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLdeleteall = "delete from stocktrade";
    public static final String SQLdelete4user = "delete from stocktrade where username = :username:";
    public static final String SQL4usersystem = SQLSelect + " join orders o ON o.id = stocktrade.orderid " +
        "where stocktrade.username = :username: and o.system = :system:";

    @Override
    public LogicEntity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Stocktrade stocktrade = (Stocktrade)super.mapResultSet2Entity(dbresult);
        return stocktrade;
    }    
    
}

