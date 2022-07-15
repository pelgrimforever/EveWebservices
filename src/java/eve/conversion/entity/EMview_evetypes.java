/*
 * Created on Okt 8, 2021
 * Generated on 18.11.2021 18:23
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_evetypes_default;
import eve.logicview.View_evetypes;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_evetypes extends EMview_evetypes_default {
//Metacoder: NO AUTHOMATIC UPDATE

    public static final String SQLSelect4Category = SQLSelectAll + " where category = :category: order by name";
    public static final String SQLSelect4Categorysearch = SQLSelectAll + " where category = :category: and name like :searchstring: order by name";
    public static final String SQLSelect4Typegroup = SQLSelectAll + " where typegroupid = :typegroupid: order by name";
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_evetypes view_evetypes = (View_evetypes)super.mapResultSet2Entity(dbresult);
        return view_evetypes;
    }    
    
}

