/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMtypegroup;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ITypegroupsearch;
import eve.logicentity.Typegroup;

/**
 * @author Franky Laseure
 */
public abstract class Btypegroup extends TableBusinessrules {

    public Btypegroup(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMtypegroup()));
    }

    public Btypegroup(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMtypegroup()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ITypegroup newTypegroup() {
    	return new Typegroup();
    }
    
    public ITypegroup newTypegroup(long id) {
        return new Typegroup(id);
    }

    public ITypegroup newTypegroup(ITypegroupPK typegroupPK) {
        return new Typegroup((TypegroupPK)typegroupPK);
    }

    public ITypegroupPK newTypegroupPK() {
        return new TypegroupPK();
    }

    public ITypegroupPK newTypegroupPK(long id) {
        return new TypegroupPK(id);
    }

    public ArrayList<Typegroup> getTypegroups() throws DBException {
        return (ArrayList<Typegroup>)tableio.getEntities(EMtypegroup.SQLSelectAll);
    }

    public Typegroup getTypegroup(ITypegroupPK typegroupPK) throws DBException {
        return (Typegroup)tableio.getEntity((TypegroupPK)typegroupPK);
    }

    public ArrayList<Typegroup> searchtypegroups(ITypegroupsearch search) throws DBException {
        return (ArrayList<Typegroup>)tableio.search(search);
    }

    public ArrayList<Typegroup> searchtypegroups(ITypegroupsearch search, String orderby) throws DBException {
        return (ArrayList<Typegroup>)tableio.search(search, orderby);
    }

    public boolean getTypegroupExists(ITypegroupPK typegroupPK) throws DBException {
        return tableio.getEntityExists((TypegroupPK)typegroupPK);
    }

    public Typegroup getEntity(String sql) throws DBException {
        return (Typegroup)tableio.getEntity(sql);
    }
    
    public Typegroup getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Typegroup)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Typegroup> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Typegroup> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Typegroup> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Typegroup> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertTypegroup(SQLTqueue transactionqueue, ITypegroup typegroup) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, typegroup);
    }

    public void insertupdateTypegroup(SQLTqueue transactionqueue, ITypegroup typegroup) throws DBException, DataException {
    	checkDATA(typegroup);
        if(this.getTypegroupExists(typegroup.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, typegroup);
        } else {
            tableio.insertEntity(transactionqueue, typegroup);
        }
    }

    public void updateTypegroup(SQLTqueue transactionqueue, ITypegroup typegroup) throws DBException, DataException {
    	checkDATA(typegroup);
        tableio.updateEntity(transactionqueue, typegroup);
    }

    public void deleteTypegroup(SQLTqueue transactionqueue, ITypegroup typegroup) throws DBException {
        cascadedeleteTypegroup(transactionqueue, typegroup.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, typegroup);
    }

    private void checkDATA(ITypegroup typegroup) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(typegroup.getName()!=null && typegroup.getName().length()>ITypegroup.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ITypegroup.SIZE_NAME).append("\n");
        }
        if(typegroup.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where typegroupPK is used in a primary key
     * @param typegroupPK: Typegroup primary key
     */
    public void cascadedeleteTypegroup(SQLTqueue transactionqueue, ITypegroupPK typegroupPK) {
    }

    public void delete4category(SQLTqueue transactionqueue, ICategoryPK categoryPK) {
        tableio.addStatement(transactionqueue, EMtypegroup.SQLDelete4category, categoryPK.getSQLprimarykey());
    }

    public ArrayList<Typegroup> getTypegroups4category(ICategoryPK categoryPK) throws CustomException {
        return tableio.getEntities(EMtypegroup.SQLSelect4category, categoryPK.getSQLprimarykey());
    }

    public ArrayList<Typegroup> getTypegroups(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMtypegroup.SQLSelect);
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
        return (ArrayList<Typegroup>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delTypegroup(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Typegroup.table);
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
