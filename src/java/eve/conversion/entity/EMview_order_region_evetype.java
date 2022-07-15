/*
 * Created on Okt 8, 2021
 * Generated on 9.9.2021 18:23
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_order_region_evetype_default;
import eve.logicview.View_order_region_evetype;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_order_region_evetype extends EMview_order_region_evetype_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_order_region_evetype view_order_region_evetype = (View_order_region_evetype)super.mapResultSet2Entity(dbresult);
        return view_order_region_evetype;
    }    
    
}

