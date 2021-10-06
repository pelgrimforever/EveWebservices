/*
 * Bview_systemtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.9.2021 16:29
 *
 */

package eve.BusinessObject.view;

import BusinessObject.GeneralViewObject;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.data.ProjectConstants;
import db.ArchiveViewMapper;
import db.ViewMapper;
import db.ViewMapperInterface;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_systemtrade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_systemtrade
 *
 * Superclass for manipulating data- and database objects
 * for View View_systemtrade and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_systemtrade extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_systemtrade as default Entity
     */
    public Bview_systemtrade() {
        super(new SQLMapper_pgsql(connectionpool, "View_systemtrade"), new View_systemtrade());
    }

    /**
     * Map ResultSet Field values to View_systemtrade
     * @param dbresult: Database ResultSet
     */
    public View_systemtrade mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_systemtrade view_systemtrade = new View_systemtrade();
        if(dbresult!=null) {
            try {
                view_systemtrade.setSell_system(dbresult.getLong("sell_system"));
                view_systemtrade.setBuy_system(dbresult.getLong("buy_system"));
                view_systemtrade.setOrdercount(dbresult.getLong("ordercount"));
                view_systemtrade.setTotalsell(dbresult.getDouble("totalsell"));
                view_systemtrade.setTotalbuy(dbresult.getDouble("totalbuy"));
                view_systemtrade.setProfit(dbresult.getDouble("profit"));
                view_systemtrade.setTotal_cargo_volume(dbresult.getDouble("total_cargo_volume"));
                view_systemtrade.setJumps(dbresult.getInt("jumps"));
                view_systemtrade.setRegionsellname(dbresult.getString("regionsellname"));
                view_systemtrade.setSystemsellname(dbresult.getString("systemsellname"));
                view_systemtrade.setRegionbuyname(dbresult.getString("regionbuyname"));
                view_systemtrade.setSystembuyname(dbresult.getString("systembuyname"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_systemtrade);
        return view_systemtrade;
    }

    /**
     * get all View_systemtrade objects from database
     * @return ArrayList of View_systemtrade objects
     * @throws DBException
     */
    public ArrayList getView_systemtrades() throws DBException {
        return getMapper().loadViewVector(this, View_systemtrade.SQLSelectAll);
    }
}
