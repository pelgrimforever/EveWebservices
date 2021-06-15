/*
 * Bview_order_region_evetype.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.5.2021 13:35
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
import eve.logicview.View_order_region_evetype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_order_region_evetype
 *
 * Superclass for manipulating data- and database objects
 * for View View_order_region_evetype and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_order_region_evetype extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_order_region_evetype as default Entity
     */
    public Bview_order_region_evetype() {
        super(new SQLMapper_pgsql(connectionpool, "View_order_region_evetype"), new View_order_region_evetype());
    }

    /**
     * Map ResultSet Field values to View_order_region_evetype
     * @param dbresult: Database ResultSet
     */
    public View_order_region_evetype mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_order_region_evetype view_order_region_evetype = new View_order_region_evetype();
        if(dbresult!=null) {
            try {
                view_order_region_evetype.setRegion(dbresult.getLong("region"));
                view_order_region_evetype.setEvetype(dbresult.getLong("evetype"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_order_region_evetype);
        return view_order_region_evetype;
    }

    /**
     * get all View_order_region_evetype objects from database
     * @return ArrayList of View_order_region_evetype objects
     * @throws DBException
     */
    public ArrayList getView_order_region_evetypes() throws DBException {
        return getMapper().loadViewVector(this, View_order_region_evetype.SQLSelectAll);
    }
}
