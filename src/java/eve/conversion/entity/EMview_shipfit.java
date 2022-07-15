/*
 * Created on Okt 8, 2021
 * Generated on 17.11.2021 15:41
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_shipfit_default;
import eve.logicview.View_shipfit;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_shipfit extends EMview_shipfit_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4username = SQLSelectAll + " where username = :username: order by shiptype, shipname";

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_shipfit view_shipfit = (View_shipfit)super.mapResultSet2Entity(dbresult);
        return view_shipfit;
    }    
    
}

