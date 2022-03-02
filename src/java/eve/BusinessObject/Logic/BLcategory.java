/*
 * BLcategory.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.4.2021 17:46
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.ICategory;
import eve.logicentity.Category;
import BusinessObject.BLtable;
import data.conversion.JSONConversion;
import eve.BusinessObject.table.Bcategory;
import general.exception.DataException;
import org.json.simple.JSONObject;

/**
 * Business Logic Entity class BLcategory
 *
 * Class for manipulating data- and database objects
 * for Entity Category and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLcategory extends Bcategory {
//Metacoder: NO AUTHOMATIC UPDATE

    //categories
    public static final long MATERIAL = 4;
    public static final long SHIP = 6;
    public static final long MODULE = 7;
    public static final long CHARGE = 8;
    public static final long BLUEPRINT = 9;
    public static final long COMMODITY = 17;
    public static final long DRONE = 18;
    public static final long DEPLOYABLE = 22;
    public static final long PLANETARYCOMMODITY = 43;
	
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Category as default Entity
     */
    public BLcategory() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Category as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLcategory(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    public void updateCategory(JSONObject jsoncategorydetails) throws DBException, DataException {
        Category category = new Category(JSONConversion.getLong(jsoncategorydetails, "category_id"));
        category.setName(JSONConversion.getString(jsoncategorydetails, "name"));
        category.setPublished(JSONConversion.getboolean(jsoncategorydetails, "published"));
        insertupdateCategory(category);
    }

    /**
     * try to insert Category object in database
     * commit transaction
     * @param category: Category Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertCategory(ICategory category) throws DBException, DataException {
        trans_insertCategory(category);
        super.Commit2DB();
    }
    
    /**
     * try to insert Category object in database
     * an alternative to insertCategory, which can be made an empty function
     * commit transaction
     * @param category: Category Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertCategory(ICategory category) throws DBException, DataException {
        trans_insertCategory(category);
        super.Commit2DB();
    }
    
    /**
     * try to update Category object in database
     * commit transaction
     * @param category: Category Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateCategory(ICategory category) throws DBException, DataException {
        trans_updateCategory(category);
        super.Commit2DB();
    }
    
    /**
     * try to update Category object in database
     * an alternative to updateCategory, which can be made an empty function
     * commit transaction
     * @param category: Category Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateCategory(ICategory category) throws DBException, DataException {
        trans_updateCategory(category);
        super.Commit2DB();
    }
    
    /**
     * try to delete Category object in database
     * commit transaction
     * @param category: Category Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteCategory(ICategory category) throws DBException {
        trans_deleteCategory(category);
        super.Commit2DB();
    }

    /**
     * try to delete Category object in database
     * an alternative to deleteCategory, which can be made an empty function
     * commit transaction
     * @param category: Category Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteCategory(ICategory category) throws DBException {
        trans_deleteCategory(category);
        super.Commit2DB();
    }

    /**
     * try to insert Category object in database
     * do not commit transaction
     * @param category: Category Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertCategory(ICategory category) throws DBException, DataException {
        super.checkDATA(category);
        super.insertCategory((Category)category);
    }
    
    /**
     * try to update Category object in database
     * do not commit transaction
     * @param category: Category Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateCategory(ICategory category) throws DBException, DataException {
        super.checkDATA(category);
        super.updateCategory((Category)category);
    }
    
    /**
     * try to delete Category object in database
     * do not commit transaction
     * @param category: Category Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteCategory(ICategory category) throws DBException {
        super.deleteCategory((Category)category);
    }
}
