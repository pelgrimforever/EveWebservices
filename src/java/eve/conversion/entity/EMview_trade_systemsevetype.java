/*
 * Created on Okt 8, 2021
 * Generated on 30.10.2021 9:16
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_trade_systemsevetype_default;
import eve.logicview.View_trade_systemsevetype;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_trade_systemsevetype extends EMview_trade_systemsevetype_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_trade_systemsevetype view_trade_systemsevetype = (View_trade_systemsevetype)super.mapResultSet2Entity(dbresult);
        return view_trade_systemsevetype;
    }    
    
}

