/*
 * Bview_trade_systemsevetype.java
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
import eve.conversion.entity.EMview_trade_systemsevetype;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_trade_systemsevetype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_trade_systemsevetype
 *
 * Superclass for manipulating data- and database objects
 * for View View_trade_systemsevetype and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_trade_systemsevetype extends BLview {

    /**
     * Constructor, sets View_trade_systemsevetype as default Entity
     */
    public Bview_trade_systemsevetype() {
        super(new View_trade_systemsevetype(), new EMview_trade_systemsevetype());
    }

    /**
     * get all View_trade_systemsevetype objects from database
     * @return ArrayList of View_trade_systemsevetype objects
     * @throws DBException
     */
    public ArrayList<View_trade_systemsevetype> getView_trade_systemsevetypes() throws DBException {
        return getEntities(EMview_trade_systemsevetype.SQLSelectAll);
    }
}
