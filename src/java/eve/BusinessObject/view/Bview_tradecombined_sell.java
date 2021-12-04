/*
 * Bview_tradecombined_sell.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.11.2021 14:51
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_tradecombined_sell;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_tradecombined_sell;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_tradecombined_sell
 *
 * Superclass for manipulating data- and database objects
 * for View View_tradecombined_sell and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_tradecombined_sell extends BLview {

    /**
     * Constructor, sets View_tradecombined_sell as default Entity
     */
    public Bview_tradecombined_sell() {
        super(new View_tradecombined_sell(), new EMview_tradecombined_sell());
    }

    /**
     * get all View_tradecombined_sell objects from database
     * @return ArrayList of View_tradecombined_sell objects
     * @throws DBException
     */
    public ArrayList<View_tradecombined_sell> getView_tradecombined_sells() throws DBException {
        return getEntities(EMview_tradecombined_sell.SQLSelectAll);
    }
}
