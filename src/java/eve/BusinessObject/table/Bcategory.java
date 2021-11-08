/*
 * Bcategory.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.10.2021 7:21
 *
 */

package eve.BusinessObject.table;

import BusinessObject.BLtable;
import general.exception.*;
import java.util.ArrayList;
import db.SQLMapperFactory;
import db.SQLparameters;
import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import eve.BusinessObject.Logic.*;
import eve.conversion.json.JSONCategory;
import eve.conversion.entity.EMcategory;
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
public abstract class Bcategory extends BLtable {

    /**
     * Constructor, sets Category as default Entity
     */
    public Bcategory() {
        super(new Category(), new EMcategory());
    }

    /**
     * Constructor, sets Category as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bcategory(BLtable transactionobject) {
        super(transactionobject, new Category(), new EMcategory());
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
     * @param id primary key field
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
     * @param id primary key field
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
    public ArrayList<Category> getCategorys() throws DBException {
        return (ArrayList<Category>)super.getEntities(EMcategory.SQLSelectAll);
    }

    /**
     * search Category for primary key
     * @param categoryPK: Category primary key
     * @return Category object
     * @throws DBException
     */
    public Category getCategory(ICategoryPK categoryPK) throws DBException {
        return (Category)super.getEntity((CategoryPK)categoryPK);
    }

    /**
     * search category with ICategorysearch parameters
     * @param search ICategorysearch
     * @return ArrayList of Category
     * @throws DBException 
     */
    public ArrayList<Category> searchcategorys(ICategorysearch search) throws DBException {
        return (ArrayList<Category>)this.search(search);
    }

    /**
     * search category with ICategorysearch parameters, order by orderby sql clause
     * @param search ICategorysearch
     * @param orderby sql order by string
     * @return ArrayList of Category
     * @throws DBException 
     */
    public ArrayList<Category> searchcategorys(ICategorysearch search, String orderby) throws DBException {
        return (ArrayList<Category>)this.search(search, orderby);
    }

    /**
     * Search category in database for categoryPK:
     * @param categoryPK: Category Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getCategoryExists(ICategoryPK categoryPK) throws DBException {
        return super.getEntityExists((CategoryPK)categoryPK);
    }

    /**
     * try to insert Category in database
     * @param category Category object
     * @throws DBException
     * @throws DataException
     */
    public void insertCategory(ICategory category) throws DBException, DataException {
        super.insertEntity(category);
    }

    /**
     * check if CategoryPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param category Category object
     * @throws DBException
     * @throws DataException
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
     * @param category Category object
     * @throws DBException
     * @throws DataException
     */
    public void updateCategory(ICategory category) throws DBException, DataException {
        super.updateEntity(category);
    }

    /**
     * try to delete Category in database
     * @param category Category object
     * @throws DBException
     */
    public void deleteCategory(ICategory category) throws DBException {
        cascadedeleteCategory(category.getPrimaryKey());
        super.deleteEntity(category);
    }

    /**
     * check data rules in Category, throw DataException with customized message if rules do not apply
     * @param category Category object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ICategory category) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(category.getName()!=null && category.getName().length()>ICategory.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ICategory.SIZE_NAME).append("\n");
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
    public void cascadedeleteCategory(ICategoryPK categoryPK) {
    }


    /**
     * get all Category objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Category objects
     * @throws DBException
     */
    public ArrayList<Category> getCategorys(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMcategory.SQLSelect);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        if(sortlist.length()>0) {
            sql.append(" order by ").append(sortlist).append(" ").append(sortoperator);
        }
        return (ArrayList<Category>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Category objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delCategory(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Category.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        this.addStatement(sql.toString(), sqlparameters);
    }


}
