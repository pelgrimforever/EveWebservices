/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMcategory;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ICategorysearch;
import eve.logicentity.Category;

/**
 * @author Franky Laseure
 */
public abstract class Bcategory extends TableBusinessrules {

    public Bcategory(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMcategory()));
    }

    public Bcategory(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMcategory()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ICategory newCategory() {
    	return new Category();
    }
    
    public ICategory newCategory(long id) {
        return new Category(id);
    }

    public ICategory newCategory(ICategoryPK categoryPK) {
        return new Category((CategoryPK)categoryPK);
    }

    public ICategoryPK newCategoryPK() {
        return new CategoryPK();
    }

    public ICategoryPK newCategoryPK(long id) {
        return new CategoryPK(id);
    }

    public ArrayList<Category> getCategorys() throws DBException {
        return (ArrayList<Category>)tableio.getEntities(EMcategory.SQLSelectAll);
    }

    public Category getCategory(ICategoryPK categoryPK) throws DBException {
        return (Category)tableio.getEntity((CategoryPK)categoryPK);
    }

    public ArrayList<Category> searchcategorys(ICategorysearch search) throws DBException {
        return (ArrayList<Category>)tableio.search(search);
    }

    public ArrayList<Category> searchcategorys(ICategorysearch search, String orderby) throws DBException {
        return (ArrayList<Category>)tableio.search(search, orderby);
    }

    public boolean getCategoryExists(ICategoryPK categoryPK) throws DBException {
        return tableio.getEntityExists((CategoryPK)categoryPK);
    }

    public Category getEntity(String sql) throws DBException {
        return (Category)tableio.getEntity(sql);
    }
    
    public Category getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Category)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Category> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Category> getEntities(String sql, SQLparameters parameters) throws DBException {
        return tableio.getEntities(sql, parameters);
    }

    public long count() throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }
    
    public long count(String sql, SQLparameters parameters) throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }

    public ArrayList<Category> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Category> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertCategory(SQLTqueue transactionqueue, ICategory category) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, category);
    }

    public void insertupdateCategory(SQLTqueue transactionqueue, ICategory category) throws DBException, DataException {
    	checkDATA(category);
        if(this.getCategoryExists(category.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, category);
        } else {
            tableio.insertEntity(transactionqueue, category);
        }
    }

    public void updateCategory(SQLTqueue transactionqueue, ICategory category) throws DBException, DataException {
    	checkDATA(category);
        tableio.updateEntity(transactionqueue, category);
    }

    public void deleteCategory(SQLTqueue transactionqueue, ICategory category) throws DBException {
        cascadedeleteCategory(transactionqueue, category.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, category);
    }

    private void checkDATA(ICategory category) throws DataException, DBException {
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
    public void cascadedeleteCategory(SQLTqueue transactionqueue, ICategoryPK categoryPK) {
    }


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
        return (ArrayList<Category>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delCategory(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
