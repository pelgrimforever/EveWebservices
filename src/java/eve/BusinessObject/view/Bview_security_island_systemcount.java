/*
 * Bview_security_island_systemcount.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.10.2021 10:3
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_security_island_systemcount;
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
public abstract class Bview_security_island_systemcount extends BLview {

    /**
     * Constructor, sets View_security_island_systemcount as default Entity
     */
    public Bview_security_island_systemcount() {
        super(new View_security_island_systemcount(), new EMview_security_island_systemcount());
    }

    /**
     * get all View_security_island_systemcount objects from database
     * @return ArrayList of View_security_island_systemcount objects
     * @throws DBException
     */
    public ArrayList<View_security_island_systemcount> getView_security_island_systemcounts() throws DBException {
        return getEntities(EMview_security_island_systemcount.SQLSelectAll);
    }
}
