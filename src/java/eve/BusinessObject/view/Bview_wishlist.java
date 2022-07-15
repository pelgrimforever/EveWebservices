/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2022 10:8
 *
 */

package eve.BusinessObject.view;

import db.*;
import data.gis.shape.*;
import eve.conversion.entity.EMview_wishlist;
import general.exception.*;
import java.util.ArrayList;
import eve.logicview.View_wishlist;
import java.sql.Time;

/**
 * @author Franky Laseure
 */
public abstract class Bview_wishlist extends ViewBusinessrules {

    public Bview_wishlist(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMview_wishlist()));
    }
    
    public ArrayList<View_wishlist> getView_wishlists() throws DBException {
        return (ArrayList<View_wishlist>)viewio.getEntities(EMview_wishlist.SQLSelectAll);
    }
}
