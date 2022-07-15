/*
 * Created on Okt 8, 2021
 * Generated on 22.1.2022 8:34
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_bp_profitperregion_default;
import eve.logicview.View_bp_profitperregion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_bp_profitperregion extends EMview_bp_profitperregion_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4lastmonth = SQLSelectAll + 
        " where year = :year: and month = :month: order by percprofit desc";
            
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_bp_profitperregion view_bp_profitperregion = (View_bp_profitperregion)super.mapResultSet2Entity(dbresult);
        return view_bp_profitperregion;
    }    
    
}

