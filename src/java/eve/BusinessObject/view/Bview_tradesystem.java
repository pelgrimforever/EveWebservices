/*
 * Bview_tradesystem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 11.4.2022 9:13
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_tradesystem;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_tradesystem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_tradesystem
 *
 * Superclass for manipulating data- and database objects
 * for View View_tradesystem and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_tradesystem extends BLview {

    /**
     * Constructor, sets View_tradesystem as default Entity
     */
    public Bview_tradesystem() {
        super(new View_tradesystem(), new EMview_tradesystem());
    }

    /**
     * get all View_tradesystem objects from database
     * @return ArrayList of View_tradesystem objects
     * @throws DBException
     */
    public ArrayList<View_tradesystem> getView_tradesystems() throws DBException {
        return getEntities(EMview_tradesystem.SQLSelectAll);
    }
}
