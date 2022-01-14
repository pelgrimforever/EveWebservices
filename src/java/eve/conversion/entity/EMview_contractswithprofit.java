/*
 * EMview_contractswithprofit.java
 *
 * Created on Okt 8, 2021
 * Generated on 8.0.2022 16:17
 *
 */
package eve.conversion.entity;

import eve.conversion.entity.def.EMview_contractswithprofit_default;
import eve.logicview.View_contractswithprofit;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_contractswithprofit
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_contractswithprofit extends EMview_contractswithprofit_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to View_contractswithprofit
     * @param dbresult: Database ResultSet
     * @return View_contractswithprofit
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_contractswithprofit view_contractswithprofit = (View_contractswithprofit)super.mapResultSet2Entity(dbresult);
        return view_contractswithprofit;
    }    
    
}

