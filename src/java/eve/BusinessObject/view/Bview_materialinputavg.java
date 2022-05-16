/*
 * Bview_materialinputavg.java
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
import eve.conversion.entity.EMview_materialinputavg;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_materialinputavg;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_materialinputavg
 *
 * Superclass for manipulating data- and database objects
 * for View View_materialinputavg and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_materialinputavg extends BLview {

    /**
     * Constructor, sets View_materialinputavg as default Entity
     */
    public Bview_materialinputavg() {
        super(new View_materialinputavg(), new EMview_materialinputavg());
    }

    /**
     * get all View_materialinputavg objects from database
     * @return ArrayList of View_materialinputavg objects
     * @throws DBException
     */
    public ArrayList<View_materialinputavg> getView_materialinputavgs() throws DBException {
        return getEntities(EMview_materialinputavg.SQLSelectAll);
    }
}
