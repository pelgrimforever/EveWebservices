/*
 * Bview_stock.java
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
import eve.logicview.View_stock;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_stock
 *
 * Superclass for manipulating data- and database objects
 * for View View_stock and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_stock extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_stock as default Entity
     */
    public Bview_stock() {
        super(new SQLMapper_pgsql(connectionpool, "View_stock"), new View_stock());
    }

    /**
     * Map ResultSet Field values to View_stock
     * @param dbresult: Database ResultSet
     */
    public View_stock mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_stock view_stock = new View_stock();
        if(dbresult!=null) {
            try {
                view_stock.setUsername(dbresult.getString("username"));
                view_stock.setEvetype(dbresult.getLong("evetype"));
                view_stock.setAmount(dbresult.getLong("amount"));
                view_stock.setName(dbresult.getString("name"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_stock);
        return view_stock;
    }

    /**
     * get all View_stock objects from database
     * @return ArrayList of View_stock objects
     * @throws DBException
     */
    public ArrayList getView_stocks() throws DBException {
        return getMapper().loadViewVector(this, View_stock.SQLSelectAll);
    }
}
