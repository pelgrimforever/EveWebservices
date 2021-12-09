/*
 * Bview_tradecombined.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.11.2021 14:30
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_tradecombined;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_tradecombined;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_tradecombined
 *
 * Superclass for manipulating data- and database objects
 * for View View_tradecombined and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_tradecombined extends BLview {

    /**
     * Constructor, sets View_tradecombined as default Entity
     */
    public Bview_tradecombined() {
        super(new View_tradecombined(), new EMview_tradecombined());
    }

    /**
     * get all View_tradecombined objects from database
     * @return ArrayList of View_tradecombined objects
     * @throws DBException
     */
    public ArrayList<View_tradecombined> getView_tradecombineds() throws DBException {
        return getEntities(EMview_tradecombined.SQLSelectAll);
    }
}
