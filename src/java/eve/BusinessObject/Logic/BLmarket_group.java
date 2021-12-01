/*
 * BLmarket_group.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2021 17:24
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.IMarket_group;
import eve.logicentity.Market_group;
import BusinessObject.BLtable;
import data.conversion.JSONConversion;
import eve.BusinessObject.table.Bmarket_group;
import eve.entity.pk.Market_groupPK;
import general.exception.DataException;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLmarket_group
 *
 * Class for manipulating data- and database objects
 * for Entity Market_group and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLmarket_group extends Bmarket_group {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Market_group as default Entity
     */
    public BLmarket_group() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Market_group as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLmarket_group(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public Market_group updateMarket_group(JSONObject jsonmarketgroupdetails) throws DBException, DataException {
        Market_group marketgroup = new Market_group(JSONConversion.getLong(jsonmarketgroupdetails, "market_group_id"));
        marketgroup.setName(JSONConversion.getString(jsonmarketgroupdetails, "name"));
        marketgroup.setDescription(JSONConversion.getString(jsonmarketgroupdetails, "description"));
        this.insertupdateMarket_group(marketgroup);
        return marketgroup;
    }
    
    public Market_group updateParent(Market_group marketgroup, JSONObject jsonmarketgroupdetails) throws DBException, DataException {
        if(jsonmarketgroupdetails.containsKey("parent_group_id")) marketgroup.setMarket_groupparent_idPK(new Market_groupPK(JSONConversion.getLong(jsonmarketgroupdetails, "parent_group_id")));
        return marketgroup;
    }

    /**
     * try to insert Market_group object in database
     * commit transaction
     * @param market_group: Market_group Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertMarket_group(IMarket_group market_group) throws DBException, DataException {
        trans_insertMarket_group(market_group);
        super.Commit2DB();
    }
    
    /**
     * try to insert Market_group object in database
     * an alternative to insertMarket_group, which can be made an empty function
     * commit transaction
     * @param market_group: Market_group Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertMarket_group(IMarket_group market_group) throws DBException, DataException {
        trans_insertMarket_group(market_group);
        super.Commit2DB();
    }
    
    /**
     * try to update Market_group object in database
     * commit transaction
     * @param market_group: Market_group Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateMarket_group(IMarket_group market_group) throws DBException, DataException {
        trans_updateMarket_group(market_group);
        super.Commit2DB();
    }
    
    /**
     * try to update Market_group object in database
     * an alternative to updateMarket_group, which can be made an empty function
     * commit transaction
     * @param market_group: Market_group Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateMarket_group(IMarket_group market_group) throws DBException, DataException {
        trans_updateMarket_group(market_group);
        super.Commit2DB();
    }
    
    /**
     * try to delete Market_group object in database
     * commit transaction
     * @param market_group: Market_group Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteMarket_group(IMarket_group market_group) throws DBException {
        trans_deleteMarket_group(market_group);
        super.Commit2DB();
    }

    /**
     * try to delete Market_group object in database
     * an alternative to deleteMarket_group, which can be made an empty function
     * commit transaction
     * @param market_group: Market_group Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteMarket_group(IMarket_group market_group) throws DBException {
        trans_deleteMarket_group(market_group);
        super.Commit2DB();
    }

    /**
     * try to insert Market_group object in database
     * do not commit transaction
     * @param market_group: Market_group Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertMarket_group(IMarket_group market_group) throws DBException, DataException {
        super.checkDATA(market_group);
        super.insertMarket_group((Market_group)market_group);
    }
    
    /**
     * try to update Market_group object in database
     * do not commit transaction
     * @param market_group: Market_group Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateMarket_group(IMarket_group market_group) throws DBException, DataException {
        super.checkDATA(market_group);
        super.updateMarket_group((Market_group)market_group);
    }
    
    /**
     * try to delete Market_group object in database
     * do not commit transaction
     * @param market_group: Market_group Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteMarket_group(IMarket_group market_group) throws DBException {
        super.deleteMarket_group((Market_group)market_group);
    }
}
