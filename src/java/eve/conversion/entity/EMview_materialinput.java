/*
 * Created on Okt 8, 2021
 * Generated on 17.0.2022 13:34
 */
package eve.conversion.entity;

import data.interfaces.db.View;
import eve.conversion.entity.def.EMview_materialinput_default;
import eve.logicview.View_materialinput;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_materialinput extends EMview_materialinput_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4username = SQLSelectAll + " where username = :username: order by name";

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_materialinput view_materialinput = (View_materialinput)super.mapResultSet2Entity(dbresult);
        return view_materialinput;
    }    
    
}

