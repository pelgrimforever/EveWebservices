/*
 * Bview_combinedtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2021 13:57
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
import eve.logicview.View_combinedtrade;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_combinedtrade
 *
 * Superclass for manipulating data- and database objects
 * for View View_combinedtrade and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_combinedtrade extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_combinedtrade as default Entity
     */
    public Bview_combinedtrade() {
        super(new SQLMapper_pgsql(connectionpool, "View_combinedtrade"), new View_combinedtrade());
    }

    /**
     * Map ResultSet Field values to View_combinedtrade
     * @param dbresult: Database ResultSet
     */
    public View_combinedtrade mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_combinedtrade view_combinedtrade = new View_combinedtrade();
        if(dbresult!=null) {
            try {
                view_combinedtrade.setSellregion(dbresult.getString("sellregion"));
                view_combinedtrade.setBuyregion(dbresult.getString("buyregion"));
                view_combinedtrade.setSell_systemid(dbresult.getLong("sell_systemid"));
                view_combinedtrade.setSellsystem(dbresult.getString("sellsystem"));
                view_combinedtrade.setBuy_systemid(dbresult.getLong("buy_systemid"));
                view_combinedtrade.setBuysystem(dbresult.getString("buysystem"));
                view_combinedtrade.setTotal_volume(dbresult.getDouble("total_volume"));
                view_combinedtrade.setBuy_order_value(dbresult.getDouble("buy_order_value"));
                view_combinedtrade.setSell_order_value(dbresult.getDouble("sell_order_value"));
                view_combinedtrade.setProfit(dbresult.getDouble("profit"));
                view_combinedtrade.setJumps(dbresult.getInt("jumps"));
                view_combinedtrade.setRuns(dbresult.getLong("runs"));
                view_combinedtrade.setOrdercount(dbresult.getLong("ordercount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_combinedtrade);
        return view_combinedtrade;
    }

    /**
     * get all View_combinedtrade objects from database
     * @return ArrayList of View_combinedtrade objects
     * @throws DBException
     */
    public ArrayList getView_combinedtrades() throws DBException {
        return getMapper().loadViewVector(this, View_combinedtrade.SQLSelectAll);
    }
}
