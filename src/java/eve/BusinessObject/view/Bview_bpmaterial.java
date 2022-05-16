/*
 * Bview_bpmaterial.java
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
import eve.conversion.entity.EMview_bpmaterial;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_bpmaterial;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_bpmaterial
 *
 * Superclass for manipulating data- and database objects
 * for View View_bpmaterial and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_bpmaterial extends BLview {

    /**
     * Constructor, sets View_bpmaterial as default Entity
     */
    public Bview_bpmaterial() {
        super(new View_bpmaterial(), new EMview_bpmaterial());
    }

    /**
     * get all View_bpmaterial objects from database
     * @return ArrayList of View_bpmaterial objects
     * @throws DBException
     */
    public ArrayList<View_bpmaterial> getView_bpmaterials() throws DBException {
        return getEntities(EMview_bpmaterial.SQLSelectAll);
    }
}
