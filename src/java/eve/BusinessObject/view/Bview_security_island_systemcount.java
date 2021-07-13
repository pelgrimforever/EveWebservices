/*
 * Bview_security_island_systemcount.java
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
import eve.logicview.View_security_island_systemcount;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_security_island_systemcount
 *
 * Superclass for manipulating data- and database objects
 * for View View_security_island_systemcount and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_security_island_systemcount extends GeneralViewObject implements ProjectConstants {

    /**
     * Constructor, sets View_security_island_systemcount as default Entity
     */
    public Bview_security_island_systemcount() {
        super(new SQLMapper_pgsql(connectionpool, "View_security_island_systemcount"), new View_security_island_systemcount());
    }

    /**
     * Map ResultSet Field values to View_security_island_systemcount
     * @param dbresult: Database ResultSet
     */
    public View_security_island_systemcount mapResultSet2View(ResultSet dbresult) throws SQLException {
        View_security_island_systemcount view_security_island_systemcount = new View_security_island_systemcount();
        if(dbresult!=null) {
            try {
                view_security_island_systemcount.setId(dbresult.getLong("id"));
                view_security_island_systemcount.setName(dbresult.getString("name"));
                view_security_island_systemcount.setSystems(dbresult.getLong("systems"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, view_security_island_systemcount);
        return view_security_island_systemcount;
    }

    /**
     * get all View_security_island_systemcount objects from database
     * @return ArrayList of View_security_island_systemcount objects
     * @throws DBException
     */
    public ArrayList getView_security_island_systemcounts() throws DBException {
        return getMapper().loadViewVector(this, View_security_island_systemcount.SQLSelectAll);
    }
}
