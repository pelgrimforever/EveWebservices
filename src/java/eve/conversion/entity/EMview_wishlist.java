/*
 * Created on Okt 8, 2021
 * Generated on 16.11.2021 15:51
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_wishlist_default;
import eve.logicview.View_wishlist;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_wishlist extends EMview_wishlist_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4username = SQLSelectAll + " where username = :username: order by name";

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_wishlist view_wishlist = (View_wishlist)super.mapResultSet2Entity(dbresult);
        return view_wishlist;
    }    
    
}

