/*
 * BLview_combinedtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 10.6.2021 18:46
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import db.AbstractSQLMapper;
import eve.logicview.View_combinedtrade;
import eve.BusinessObject.view.Bview_combinedtrade;
import eve.entity.pk.SystemPK;
import eve.interfaces.BusinessObject.IBLview_combinedtrade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_combinedtrade
 *
 * Class for manipulating data- and database objects
 * for View View_combinedtrade and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_combinedtrade extends Bview_combinedtrade implements IBLview_combinedtrade {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_combinedtrade as default Entity
     */
    public BLview_combinedtrade() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_combinedtrade) throws SQLException {
        View_combinedtrade extra = (View_combinedtrade)view_combinedtrade;
        try {
            extra.setStart_system(dbresult.getLong("startsystem_id"));
            extra.setStart_system_jumps(dbresult.getInt("startsystem_jumps"));
        }
        catch(SQLException e) {
        }
    }
    
    /**
     * get all View_combinedtrade objects from database
     * @return ArrayList of View_trade objects
     * @throws DBException
     */
    public ArrayList getView_combinedtrades_Startsystem(SystemPK systemPK) throws DBException {
        return getMapper().loadViewVector(this, View_combinedtrade.SQLSelectAll4Startingsystem, systemPK.getKeyFields());
    }

    /**
     * get combinedtrade for startsystem, endsystem,
     * with jumpcount starting from systemPK
     * @return View_combinedtrade objects
     * @throws DBException
     */
    public View_combinedtrade getView_combinedtrade_Startendsystem(SystemPK systemPK, SystemPK startsystemPK, SystemPK endsystemPK) throws DBException {
        Object[][] parameter = {{ "startsystemid", startsystemPK.getId() }, { "endsystemid", endsystemPK.getId() }};
        parameter = AbstractSQLMapper.addKeyArrays(parameter, systemPK.getKeyFields());
        return (View_combinedtrade)getMapper().loadView(this, View_combinedtrade.SQLSelect4Startendsystem, parameter);
    }
}
