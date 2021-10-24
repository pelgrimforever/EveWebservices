/*
 * BLtypegroup.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.4.2021 17:46
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.ITypegroup;
import eve.logicentity.Typegroup;
import BusinessObject.BLtable;
import data.conversion.JSONConversion;
import eve.BusinessObject.table.Btypegroup;
import eve.conversion.entity.EMtypegroup;
import eve.entity.pk.CategoryPK;
import general.exception.DataException;
import eve.interfaces.entity.pk.ICategoryPK;
import general.exception.CustomException;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLtypegroup
 *
 * Class for manipulating data- and database objects
 * for Entity Typegroup and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLtypegroup extends Btypegroup {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Typegroup as default Entity
     */
    public BLtypegroup() {
        super();
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Typegroup as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLtypegroup(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public Typegroup updateTypegroup(JSONObject jsongroupdetails) throws DBException, DataException {
        Typegroup typegroup = new Typegroup(JSONConversion.getLong(jsongroupdetails, "group_id"));
        typegroup.setName(JSONConversion.getString(jsongroupdetails, "name"));
        typegroup.setCategoryPK(new CategoryPK(JSONConversion.getLong(jsongroupdetails, "category_id")));
        typegroup.setPublished(JSONConversion.getboolean(jsongroupdetails, "published"));
        this.insertupdateTypegroup(typegroup);
        return typegroup;
    }

    /**
     * @param categoryPK: foreign key for category
     * @return count of all typegroups linked to category
     * @throws eve.general.exception.CustomException
     */
    public long getTypegroup4categorycount(ICategoryPK categoryPK) throws CustomException {
        return count(EMtypegroup.SQLSelect4categoryCount, categoryPK.getSQLprimarykey());
    }

    /**
     * try to insert Typegroup object in database
     * commit transaction
     * @param typegroup: Typegroup Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertTypegroup(ITypegroup typegroup) throws DBException, DataException {
        trans_insertTypegroup(typegroup);
        super.Commit2DB();
    }
    
    /**
     * try to insert Typegroup object in database
     * an alternative to insertTypegroup, which can be made an empty function
     * commit transaction
     * @param typegroup: Typegroup Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertTypegroup(ITypegroup typegroup) throws DBException, DataException {
        trans_insertTypegroup(typegroup);
        super.Commit2DB();
    }
    
    /**
     * try to update Typegroup object in database
     * commit transaction
     * @param typegroup: Typegroup Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateTypegroup(ITypegroup typegroup) throws DBException, DataException {
        trans_updateTypegroup(typegroup);
        super.Commit2DB();
    }
    
    /**
     * try to update Typegroup object in database
     * an alternative to updateTypegroup, which can be made an empty function
     * commit transaction
     * @param typegroup: Typegroup Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateTypegroup(ITypegroup typegroup) throws DBException, DataException {
        trans_updateTypegroup(typegroup);
        super.Commit2DB();
    }
    
    /**
     * try to delete Typegroup object in database
     * commit transaction
     * @param typegroup: Typegroup Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteTypegroup(ITypegroup typegroup) throws DBException {
        trans_deleteTypegroup(typegroup);
        super.Commit2DB();
    }

    /**
     * try to delete Typegroup object in database
     * an alternative to deleteTypegroup, which can be made an empty function
     * commit transaction
     * @param typegroup: Typegroup Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteTypegroup(ITypegroup typegroup) throws DBException {
        trans_deleteTypegroup(typegroup);
        super.Commit2DB();
    }

    /**
     * try to insert Typegroup object in database
     * do not commit transaction
     * @param typegroup: Typegroup Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertTypegroup(ITypegroup typegroup) throws DBException, DataException {
        super.checkDATA(typegroup);
        super.insertTypegroup((Typegroup)typegroup);
    }
    
    /**
     * try to update Typegroup object in database
     * do not commit transaction
     * @param typegroup: Typegroup Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateTypegroup(ITypegroup typegroup) throws DBException, DataException {
        super.checkDATA(typegroup);
        super.updateTypegroup((Typegroup)typegroup);
    }
    
    /**
     * try to delete Typegroup object in database
     * do not commit transaction
     * @param typegroup: Typegroup Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteTypegroup(ITypegroup typegroup) throws DBException {
        super.deleteTypegroup((Typegroup)typegroup);
    }
}
