/*
 * Bview_shipfitorder.java
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
import eve.conversion.entity.EMview_shipfitorder;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_shipfitorder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_shipfitorder
 *
 * Superclass for manipulating data- and database objects
 * for View View_shipfitorder and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_shipfitorder extends BLview {

    /**
     * Constructor, sets View_shipfitorder as default Entity
     */
    public Bview_shipfitorder() {
        super(new View_shipfitorder(), new EMview_shipfitorder());
    }

    /**
     * get all View_shipfitorder objects from database
     * @return ArrayList of View_shipfitorder objects
     * @throws DBException
     */
    public ArrayList<View_shipfitorder> getView_shipfitorders() throws DBException {
        return getEntities(EMview_shipfitorder.SQLSelectAll);
    }
}
