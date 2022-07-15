/*
 * Created on Okt 8, 2021
 * Generated on 24.0.2022 17:38
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_bpmaterial_default;
import eve.logicview.View_bpmaterial;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_bpmaterial extends EMview_bpmaterial_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4blueprint = SQLSelectAll + " where bp = :bp:";

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_bpmaterial view_bpmaterial = (View_bpmaterial)super.mapResultSet2Entity(dbresult);
        return view_bpmaterial;
    }    
    
}

