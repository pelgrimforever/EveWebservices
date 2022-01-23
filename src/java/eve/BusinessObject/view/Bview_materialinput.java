/*
 * Bview_materialinput.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.0.2022 13:34
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_materialinput;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_materialinput;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_materialinput
 *
 * Superclass for manipulating data- and database objects
 * for View View_materialinput and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_materialinput extends BLview {

    /**
     * Constructor, sets View_materialinput as default Entity
     */
    public Bview_materialinput() {
        super(new View_materialinput(), new EMview_materialinput());
    }

    /**
     * get all View_materialinput objects from database
     * @return ArrayList of View_materialinput objects
     * @throws DBException
     */
    public ArrayList<View_materialinput> getView_materialinputs() throws DBException {
        return getEntities(EMview_materialinput.SQLSelectAll);
    }
}
