/*
 * BLroute.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 29.4.2021 10:38
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IRoute;
import eve.logicentity.Route;
import BusinessObject.BLtable;
import eve.BusinessObject.table.Broute;
import general.exception.DataException;

/**
 * Business Logic Entity class BLroute
 *
 * Class for manipulating data- and database objects
 * for Entity Route and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLroute extends Broute {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Route as default Entity
     */
    public BLroute() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Route as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLroute(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * try to insert Route object in database
     * commit transaction
     * @param route: Route Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertRoute(IRoute route) throws DBException, DataException {
        trans_insertRoute(route);
        super.Commit2DB();
    }
    
    /**
     * try to insert Route object in database
     * an alternative to insertRoute, which can be made an empty function
     * commit transaction
     * @param route: Route Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertRoute(IRoute route) throws DBException, DataException {
        trans_insertRoute(route);
        super.Commit2DB();
    }
    
    /**
     * try to update Route object in database
     * commit transaction
     * @param route: Route Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateRoute(IRoute route) throws DBException, DataException {
        trans_updateRoute(route);
        super.Commit2DB();
    }
    
    /**
     * try to update Route object in database
     * an alternative to updateRoute, which can be made an empty function
     * commit transaction
     * @param route: Route Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateRoute(IRoute route) throws DBException, DataException {
        trans_updateRoute(route);
        super.Commit2DB();
    }
    
    /**
     * try to delete Route object in database
     * commit transaction
     * @param route: Route Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteRoute(IRoute route) throws DBException {
        trans_deleteRoute(route);
        super.Commit2DB();
    }

    /**
     * try to delete Route object in database
     * an alternative to deleteRoute, which can be made an empty function
     * commit transaction
     * @param route: Route Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteRoute(IRoute route) throws DBException {
        trans_deleteRoute(route);
        super.Commit2DB();
    }

    /**
     * try to insert Route object in database
     * do not commit transaction
     * @param route: Route Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertRoute(IRoute route) throws DBException, DataException {
        super.checkDATA(route);
        super.insertRoute((Route)route);
    }
    
    /**
     * try to update Route object in database
     * do not commit transaction
     * @param route: Route Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateRoute(IRoute route) throws DBException, DataException {
        super.checkDATA(route);
        super.updateRoute((Route)route);
    }
    
    /**
     * try to delete Route object in database
     * do not commit transaction
     * @param route: Route Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteRoute(IRoute route) throws DBException {
        super.deleteRoute((Route)route);
    }
}
