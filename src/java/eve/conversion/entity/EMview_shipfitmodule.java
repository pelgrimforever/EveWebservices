/*
 * Created on Okt 8, 2021
 * Generated on 18.11.2021 16:29
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_shipfitmodule_default;
import eve.logicview.View_shipfitmodule;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_shipfitmodule extends EMview_shipfitmodule_default {
//Metacoder: NO AUTHOMATIC UPDATE

    public static final String SQLSelect4shipfit = SQLSelectAll + " where username = :username: and shipname = :shipname: order by modulename";
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_shipfitmodule view_shipfitmodule = (View_shipfitmodule)super.mapResultSet2Entity(dbresult);
        return view_shipfitmodule;
    }    
    
}

