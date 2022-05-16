/*
 * Bview_wishlist.java
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
import eve.conversion.entity.EMview_wishlist;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_wishlist;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_wishlist
 *
 * Superclass for manipulating data- and database objects
 * for View View_wishlist and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_wishlist extends BLview {

    /**
     * Constructor, sets View_wishlist as default Entity
     */
    public Bview_wishlist() {
        super(new View_wishlist(), new EMview_wishlist());
    }

    /**
     * get all View_wishlist objects from database
     * @return ArrayList of View_wishlist objects
     * @throws DBException
     */
    public ArrayList<View_wishlist> getView_wishlists() throws DBException {
        return getEntities(EMview_wishlist.SQLSelectAll);
    }
}
