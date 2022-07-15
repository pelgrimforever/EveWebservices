/*
 * Created on Okt 8, 2021
 * Generated on 8.0.2022 16:17
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_contractswithprofit_default;
import eve.logicview.View_contractswithprofit;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_contractswithprofit extends EMview_contractswithprofit_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_contractswithprofit view_contractswithprofit = (View_contractswithprofit)super.mapResultSet2Entity(dbresult);
        return view_contractswithprofit;
    }    
    
}

