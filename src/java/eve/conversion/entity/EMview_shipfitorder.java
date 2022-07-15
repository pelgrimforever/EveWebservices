/*
 * Created on Okt 8, 2021
 * Generated on 19.11.2021 16:16
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_shipfitorder_default;
import eve.logicview.View_shipfitorder;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_shipfitorder extends EMview_shipfitorder_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4username = SQLSelectAll + " where username = :username: order by shipname, evetypename";

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_shipfitorder view_shipfitorder = (View_shipfitorder)super.mapResultSet2Entity(dbresult);
        return view_shipfitorder;
    }    
    
}

