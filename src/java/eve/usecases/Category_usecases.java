/*
 * Generated on 17.6.2022 13:4
 */

package eve.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.searchentity.*;
import eve.interfaces.entity.pk.*;
import eve.logicentity.*;
import eve.logicentity.Category;
import eve.logicview.*;
import eve.usecases.custom.*;
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
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLcategory blcategory = new BLcategory(sqlreader);
    
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
        return blcategory.getCategoryExists(categoryPK);
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

    public void insertCategory(ICategory category) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcategory.insertCategory(tq, category);
        sqlwriter.Commit2DB(tq);
    }

    public void updateCategory(ICategory category) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcategory.updateCategory(tq, category);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteCategory(ICategory category) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcategory.deleteCategory(tq, category);
        sqlwriter.Commit2DB(tq);
    }

}

