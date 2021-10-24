/*
 * BLview_order.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 18.6.2021 14:35
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.logicview.View_order;
import eve.BusinessObject.view.Bview_order;
import eve.conversion.entity.EMview_order;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.OrdersPK;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_order
 *
 * Class for manipulating data- and database objects
 * for View View_order and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_order extends Bview_order {
//ProjectGenerator: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_order as default Entity
     */
    public BLview_order() {
    }

    /**
     * get View_order line for order primary key
     * @param orderPK
     * @return View_order
     * @throws DBException
     */
    public View_order getView_order(OrdersPK orderPK) throws DBException {
        return (View_order)getEntity(EMview_order.SQLSelectOne, orderPK.getSQLprimarykey());
    }

    /**
     * get all View_order sell orders for evetype
     * @param evetypePK
     * @return ArrayList of View_order objects
     * @throws DBException
     */
    public ArrayList getView_orders4evetype_sell(EvetypePK evetypePK) throws DBException {
        return getEntities(EMview_order.SQLSelect4Evetypesell, evetypePK.getSQLprimarykey());
    }

    /**
     * get all View_order buy orders for evetype
     * @param evetypePK
     * @return ArrayList of View_order objects
     * @throws DBException
     */
    public ArrayList getView_orders4evetype_buy(EvetypePK evetypePK) throws DBException {
        return getEntities(EMview_order.SQLSelect4Evetypebuy, evetypePK.getSQLprimarykey());
    }

}
