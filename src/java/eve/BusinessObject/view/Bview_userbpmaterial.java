/*
 * Bview_userbpmaterial.java
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
import eve.conversion.entity.EMview_userbpmaterial;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_userbpmaterial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_userbpmaterial
 *
 * Superclass for manipulating data- and database objects
 * for View View_userbpmaterial and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_userbpmaterial extends BLview {

    /**
     * Constructor, sets View_userbpmaterial as default Entity
     */
    public Bview_userbpmaterial() {
        super(new View_userbpmaterial(), new EMview_userbpmaterial());
    }

    /**
     * get all View_userbpmaterial objects from database
     * @return ArrayList of View_userbpmaterial objects
     * @throws DBException
     */
    public ArrayList<View_userbpmaterial> getView_userbpmaterials() throws DBException {
        return getEntities(EMview_userbpmaterial.SQLSelectAll);
    }
}
