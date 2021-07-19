/*
 * Bview_systemtradeorders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.6.2021 14:35
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
import eve.logicview.View_systemtradeorders;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_systemtradeorders
 *
 * Superclass for manipulating data- and database objects
 * for View View_systemtradeorders and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_systemtradeorders extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_systemtradeorders as default Entity
     */
    public Bview_systemtradeorders() {
        super(new SQLMapper_pgsql(connectionpool, "View_systemtradeorders"), new View_systemtradeorders());
    }

    /**
     * Map ResultSet Field values to View_systemtradeorders
     * @param dbresult: Database ResultSet
     */
    public View_systemtradeorders mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_systemtradeorders view_systemtradeorders = new View_systemtradeorders();
        if(dbresult!=null) {
            try {
                view_systemtradeorders.setBuy_totalprice(dbresult.getDouble("buy_totalprice"));
                view_systemtradeorders.setSell_totalprice(dbresult.getDouble("sell_totalprice"));
                view_systemtradeorders.setCargo_volume(dbresult.getDouble("cargo_volume"));
                view_systemtradeorders.setSellorderid(dbresult.getLong("sellorderid"));
                view_systemtradeorders.setBuyorderid(dbresult.getLong("buyorderid"));
                view_systemtradeorders.setEvetype(dbresult.getLong("evetype"));
                view_systemtradeorders.setPackaged_volume(dbresult.getDouble("packaged_volume"));
                view_systemtradeorders.setSecurity_island(dbresult.getLong("security_island"));
                view_systemtradeorders.setSell_system(dbresult.getLong("sell_system"));
                view_systemtradeorders.setBuy_system(dbresult.getLong("buy_system"));
                view_systemtradeorders.setJumps(dbresult.getInt("jumps"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_systemtradeorders);
        return view_systemtradeorders;
    }

    /**
     * get all View_systemtradeorders objects from database
     * @return ArrayList of View_systemtradeorders objects
     * @throws DBException
     */
    public ArrayList getView_systemtradeorderss() throws DBException {
        return getMapper().loadViewVector(this, View_systemtradeorders.SQLSelectAll);
    }
}
