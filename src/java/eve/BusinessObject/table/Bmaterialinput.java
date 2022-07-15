/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMmaterialinput;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IMaterialinputsearch;
import eve.logicentity.Materialinput;

/**
 * @author Franky Laseure
 */
public abstract class Bmaterialinput extends TableBusinessrules {

    public Bmaterialinput(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMmaterialinput()));
    }

    public Bmaterialinput(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMmaterialinput()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IMaterialinput newMaterialinput() {
    	return new Materialinput();
    }
    
    public IMaterialinput newMaterialinput(java.lang.String username, long evetype, java.sql.Timestamp addtimestamp) {
        return new Materialinput(username, evetype, addtimestamp);
    }

    public IMaterialinput newMaterialinput(IMaterialinputPK materialinputPK) {
        return new Materialinput((MaterialinputPK)materialinputPK);
    }

    public IMaterialinputPK newMaterialinputPK() {
        return new MaterialinputPK();
    }

    public IMaterialinputPK newMaterialinputPK(java.lang.String username, long evetype, java.sql.Timestamp addtimestamp) {
        return new MaterialinputPK(username, evetype, addtimestamp);
    }

    public ArrayList<Materialinput> getMaterialinputs() throws DBException {
        return (ArrayList<Materialinput>)tableio.getEntities(EMmaterialinput.SQLSelectAll);
    }

    public Materialinput getMaterialinput(IMaterialinputPK materialinputPK) throws DBException {
        return (Materialinput)tableio.getEntity((MaterialinputPK)materialinputPK);
    }

    public ArrayList<Materialinput> searchmaterialinputs(IMaterialinputsearch search) throws DBException {
        return (ArrayList<Materialinput>)tableio.search(search);
    }

    public ArrayList<Materialinput> searchmaterialinputs(IMaterialinputsearch search, String orderby) throws DBException {
        return (ArrayList<Materialinput>)tableio.search(search, orderby);
    }

    public boolean getMaterialinputExists(IMaterialinputPK materialinputPK) throws DBException {
        return tableio.getEntityExists((MaterialinputPK)materialinputPK);
    }

    public Materialinput getEntity(String sql) throws DBException {
        return (Materialinput)tableio.getEntity(sql);
    }
    
    public Materialinput getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Materialinput)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Materialinput> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Materialinput> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Materialinput> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Materialinput> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertMaterialinput(SQLTqueue transactionqueue, IMaterialinput materialinput) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, materialinput);
    }

    public void insertupdateMaterialinput(SQLTqueue transactionqueue, IMaterialinput materialinput) throws DBException, DataException {
    	checkDATA(materialinput);
        if(this.getMaterialinputExists(materialinput.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, materialinput);
        } else {
            tableio.insertEntity(transactionqueue, materialinput);
        }
    }

    public void updateMaterialinput(SQLTqueue transactionqueue, IMaterialinput materialinput) throws DBException, DataException {
    	checkDATA(materialinput);
        tableio.updateEntity(transactionqueue, materialinput);
    }

    public void deleteMaterialinput(SQLTqueue transactionqueue, IMaterialinput materialinput) throws DBException {
        cascadedeleteMaterialinput(transactionqueue, materialinput.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, materialinput);
    }

    private void checkDATA(IMaterialinput materialinput) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Materialinput.Evetype - Evetype.Id
        //Primary key
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where materialinputPK is used in a primary key
     * @param materialinputPK: Materialinput primary key
     */
    public void cascadedeleteMaterialinput(SQLTqueue transactionqueue, IMaterialinputPK materialinputPK) {
    }

    public void delete4evetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMmaterialinput.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Materialinput> getMaterialinputs4evetype(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMmaterialinput.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Materialinput> getMaterialinputs(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMmaterialinput.SQLSelect);
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
        return (ArrayList<Materialinput>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delMaterialinput(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Materialinput.table);
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
