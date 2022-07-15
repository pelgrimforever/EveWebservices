/*
 * Created on Okt 8, 2021
 * Generated on 23.0.2022 17:52
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_materialinputavg_default;
import eve.logicview.View_materialinputavg;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_materialinputavg extends EMview_materialinputavg_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4username = SQLSelectAll + " where username = :username: order by name";
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_materialinputavg view_materialinputavg = (View_materialinputavg)super.mapResultSet2Entity(dbresult);
        return view_materialinputavg;
    }    
    
}

