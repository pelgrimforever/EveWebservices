/*
 * BLview_trade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.5.2021 16:45
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.View;
import eve.logicview.View_trade;
import eve.BusinessObject.view.Bview_trade;
import eve.entity.pk.SystemPK;
import eve.interfaces.BusinessObject.IBLview_trade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_trade
 *
 * Class for manipulating data- and database objects
 * for View View_trade and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_trade extends Bview_trade implements IBLview_trade {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_trade as default Entity
     */
    public BLview_trade() {
    }

    @Override
    public void loadExtra(ResultSet dbresult, View view_trade) throws SQLException {
        View_trade extra = (View_trade)view_trade;
        try {
            extra.setStart_system(dbresult.getLong("startsystem_id"));
            extra.setStart_system_jumps(dbresult.getInt("startsystem_jumps"));
        }
        catch(SQLException e) {
        }
    }
    
    /**
     * get all View_trade lines starting on systemPK
     * @param startsystemPK: start system primary key
     * @return ArrayList of View_trade objects
     * @throws DBException
     */
    public ArrayList getView_trades_Startsystem(SystemPK systemPK) throws DBException {
        return getMapper().loadViewVector(this, View_trade.SQLSelectAll4Startingsystem, systemPK.getKeyFields());
    }

    /**
     * get all Vie_trade lines starting at startsystem, ending at endsystem
     * @param startsystemPK: start system primary key
     * @param endsystemPK: end system primary key
     * @return
     * @throws DBException 
     */
    public ArrayList getView_trades_Startendsystem(SystemPK startsystemPK, SystemPK endsystemPK) throws DBException {
        Object[][] parameter = {{ "startsystemid", startsystemPK.getId() }, { "endsystemid", endsystemPK.getId() }};
        return getMapper().loadViewVector(this, View_trade.SQLSelectAll4Startendsystem, parameter);
    }
}
