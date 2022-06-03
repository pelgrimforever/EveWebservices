/*
 * Generated on 20.4.2022 10:3
 */

package eve.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.Category;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Category_usecases {

    private boolean loggedin = false;
    private BLcategory blcategory = new BLcategory();
    
    public Category_usecases() {
        this(false);
    }
    
    public Category_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blcategory.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blcategory.count();
    }
    
    public ArrayList<Category> get_all() throws DBException {
        return blcategory.getCategorys();
    }
    
    public boolean getCategoryExists(ICategoryPK categoryPK) throws DBException {
        return blcategory.getEntityExists(categoryPK);
    }
    
    public Category get_category_by_primarykey(ICategoryPK categoryPK) throws DBException {
        return blcategory.getCategory(categoryPK);
    }

    public ArrayList<Category> search_category(ICategorysearch categorysearch) throws CustomException {
        return blcategory.search(categorysearch);
    }
    
    public long search_category_count(ICategorysearch categorysearch) throws CustomException {
        return blcategory.searchcount(categorysearch);
    }

    public void secureinsertCategory(ICategory category) throws DBException, DataException {
        blcategory.secureinsertCategory(category);
    }

    public void secureupdateCategory(ICategory category) throws DBException, DataException {
        blcategory.secureupdateCategory(category);
    }

    public void securedeleteCategory(ICategory category) throws DBException, DataException {
        blcategory.securedeleteCategory(category);
    }
}

