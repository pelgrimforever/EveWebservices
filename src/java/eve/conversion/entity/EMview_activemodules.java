/*
 * Created on Okt 8, 2021
 * Generated on 19.11.2021 16:16
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_activemodules_default;
import eve.logicview.View_activemodules;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_activemodules extends EMview_activemodules_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_activemodules view_activemodules = (View_activemodules)super.mapResultSet2Entity(dbresult);
        return view_activemodules;
    }    
    
}

