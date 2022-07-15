/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_stock_default;
import eve.logicview.View_stock;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_stock extends EMview_stock_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4username = SQLSelectAll + " where username = :username: order by name";

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_stock view_stock = (View_stock)super.mapResultSet2Entity(dbresult);
        return view_stock;
    }    
    
}

