/*
 * Bcategory.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 12.6.2021 13:57
 *
 */

package eve.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONCategory;
import eve.data.ProjectConstants;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ICategorysearch;
import eve.logicentity.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bcategory
 *
 * Superclass for manipulating data- and database objects
 * for Entity Category and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bcategory extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Category as default Entity
     */
    public Bcategory() {
        super(new SQLMapper_pgsql(connectionpool, "Category"), new Category());
    }

    /**
     * Constructor, sets Category as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bcategory(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Category());
    }

    /**
     * Map ResultSet Field values to Category
     * @param dbresult: Database ResultSet
     */
    public Category mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        CategoryPK categoryPK = null;
        Category category;
        if(dbresult==null) {
            category = new Category(categoryPK);
        } else {
            try {
                categoryPK = new CategoryPK(dbresult.getLong("id"));
                category = new Category(categoryPK);
                category.initName(dbresult.getString("name"));
                category.initPublished(dbresult.getBoolean("published"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, category);
        return category;
    }

    /**
     * create new empty Category object
     * @return empty ICategory
     */
    public ICategory newCategory() {
    	return new Category();
    }
    
    /**
     * create new empty Category object
     * create new primary key with given parameters
     * @return ICategory with primary key
     */
    public ICategory newCategory(long id) {
        return new Category(id);
    }

    /**
     * create new empty Category object with given primary key
     * @param categoryPK: primary key for Category
     * @return ICategory with primary key
     */
    public ICategory newCategory(ICategoryPK categoryPK) {
        return new Category((CategoryPK)categoryPK);
    }

    /**
     * create new empty primary key
     * @return empty CategoryPK
     */
    public ICategoryPK newCategoryPK() {
        return new CategoryPK();
    }

    /**
     * create new primary key with given parameters
     * @return new ICategoryPK
     */
    public ICategoryPK newCategoryPK(long id) {
        return new CategoryPK(id);
    }

    /**
     * get all Category objects from database
     * @return ArrayList of Category objects
     * @throws DBException
     */
    public ArrayList getCategorys() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Category.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Category for primary key
     * @param categoryPK: Category primary key
     * @return Category object
     * @throws DBException
     */
    public Category getCategory(ICategoryPK categoryPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Category)super.getEntity((CategoryPK)categoryPK);
        } else return null;
    }

    public ArrayList searchcategorys(ICategorysearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchcategorys(ICategorysearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search category in database for categoryPK:
     * @param categoryPK: Category Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getCategoryExists(ICategoryPK categoryPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((CategoryPK)categoryPK);
        } else return false;
    }

    /**
     * try to insert Category in database
     * @param film: Category object
     * @throws DBException
     */
    public void insertCategory(ICategory category) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(category);
        }
    }

    /**
     * check if CategoryPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Category object
     * @throws DBException
     */
    public void insertupdateCategory(ICategory category) throws DBException, DataException {
        if(this.getCategoryExists(category.getPrimaryKey())) {
            super.updateEntity(category);
        } else {
            super.insertEntity(category);
        }
    }

    /**
     * try to update Category in database
     * @param film: Category object
     * @throws DBException
     */
    public void updateCategory(ICategory category) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(category);
        }
    }

    /**
     * try to delete Category in database
     * @param film: Category object
     * @throws DBException
     */
    public void deleteCategory(ICategory category) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteCategory(category.getOwnerobject(), category.getPrimaryKey());
            super.deleteEntity(category);
        }
    }

    /**
     * check data rules in Category, throw DataException with customized message if rules do not apply
     * @param film: Category object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ICategory category) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(category.getName()!=null && category.getName().length()>ICategory.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: " + ICategory.SIZE_NAME + "\n");
        }
        if(category.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where categoryPK is used in a primary key
     * @param categoryPK: Category primary key
     */
    public void cascadedeleteCategory(String senderobject, ICategoryPK categoryPK) {
    }


    /**
     * get all Category objects for sqlparameters
     * @return ArrayList of Category objects
     * @throws DBException
     */
    public ArrayList getCategorys(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Category.SQLSelect;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        if(sortlist.length()>0) {
            sql += " order by " + sortlist + " " + sortoperator;
        }
        return getMapper().loadEntityVector(this, sql, sqlparameters);
    }

    /**
     * delete all Category objects for sqlparameters
     * @throws DBException
     */
    public void delCategory(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Category.table;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        this.addStatement(senderobject, sql, sqlparameters);
    }


}
