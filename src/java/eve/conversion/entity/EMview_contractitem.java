/*
 * Created on Okt 8, 2021
 * Generated on 9.0.2022 7:52
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_contractitem_default;
import eve.logicview.View_contractitem;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_contractitem extends EMview_contractitem_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4contract = SQLSelectAll + " where " + EMcontractitem.SQLWherecontract + " order by categoryname, groupname, typename";

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_contractitem view_contractitem = (View_contractitem)super.mapResultSet2Entity(dbresult);
        return view_contractitem;
    }    
    
}

