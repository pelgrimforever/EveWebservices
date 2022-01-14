/*
 * Bview_tradeorders_lowsec.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 14.0.2022 16:56
 *
 */

package eve.BusinessObject.view;

import BusinessObject.BLview;
import db.SQLMapperFactory;
import data.gis.shape.*;
import db.SQLMapper_pgsql;
import eve.conversion.entity.EMview_tradeorders_lowsec;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_tradeorders_lowsec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;

/**
 * Business View class Bview_tradeorders_lowsec
 *
 * Superclass for manipulating data- and database objects
 * for View View_tradeorders_lowsec and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bview_tradeorders_lowsec extends BLview {

    /**
     * Constructor, sets View_tradeorders_lowsec as default Entity
     */
    public Bview_tradeorders_lowsec() {
        super(new View_tradeorders_lowsec(), new EMview_tradeorders_lowsec());
    }

    /**
     * get all View_tradeorders_lowsec objects from database
     * @return ArrayList of View_tradeorders_lowsec objects
     * @throws DBException
     */
    public ArrayList<View_tradeorders_lowsec> getView_tradeorders_lowsecs() throws DBException {
        return getEntities(EMview_tradeorders_lowsec.SQLSelectAll);
    }
}
