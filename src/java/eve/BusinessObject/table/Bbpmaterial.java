/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMbpmaterial;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IBpmaterialsearch;
import eve.logicentity.Bpmaterial;

public abstract class Bbpmaterial extends TableBusinessrules {

    public Bbpmaterial(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMbpmaterial()));
    }

    public Bbpmaterial(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMbpmaterial()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IBpmaterial newBpmaterial() {
    	return new Bpmaterial();
    }
    
    public IBpmaterial newBpmaterial(long bp, long material) {
        return new Bpmaterial(bp, material);
    }

    public IBpmaterial newBpmaterial(IBpmaterialPK bpmaterialPK) {
        return new Bpmaterial((BpmaterialPK)bpmaterialPK);
    }

    public IBpmaterialPK newBpmaterialPK() {
        return new BpmaterialPK();
    }

    public IBpmaterialPK newBpmaterialPK(long bp, long material) {
        return new BpmaterialPK(bp, material);
    }

    public ArrayList<Bpmaterial> getBpmaterials() throws DBException {
        return (ArrayList<Bpmaterial>)tableio.getEntities(EMbpmaterial.SQLSelectAll);
    }

    public Bpmaterial getBpmaterial(IBpmaterialPK bpmaterialPK) throws DBException {
        return (Bpmaterial)tableio.getEntity((BpmaterialPK)bpmaterialPK);
    }

    public ArrayList<Bpmaterial> searchbpmaterials(IBpmaterialsearch search) throws DBException {
        return (ArrayList<Bpmaterial>)tableio.search(search);
    }

    public ArrayList<Bpmaterial> searchbpmaterials(IBpmaterialsearch search, String orderby) throws DBException {
        return (ArrayList<Bpmaterial>)tableio.search(search, orderby);
    }

    public boolean getBpmaterialExists(IBpmaterialPK bpmaterialPK) throws DBException {
        return tableio.getEntityExists((BpmaterialPK)bpmaterialPK);
    }

    public Bpmaterial getEntity(String sql) throws DBException {
        return (Bpmaterial)tableio.getEntity(sql);
    }
    
    public Bpmaterial getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Bpmaterial)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Bpmaterial> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Bpmaterial> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Bpmaterial> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Bpmaterial> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertBpmaterial(SQLTqueue transactionqueue, IBpmaterial bpmaterial) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, bpmaterial);
    }

    public void insertupdateBpmaterial(SQLTqueue transactionqueue, IBpmaterial bpmaterial) throws DBException, DataException {
    	checkDATA(bpmaterial);
        if(this.getBpmaterialExists(bpmaterial.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, bpmaterial);
        } else {
            tableio.insertEntity(transactionqueue, bpmaterial);
        }
    }

    public void updateBpmaterial(SQLTqueue transactionqueue, IBpmaterial bpmaterial) throws DBException, DataException {
    	checkDATA(bpmaterial);
        tableio.updateEntity(transactionqueue, bpmaterial);
    }

    public void deleteBpmaterial(SQLTqueue transactionqueue, IBpmaterial bpmaterial) throws DBException {
        cascadedeleteBpmaterial(transactionqueue, bpmaterial.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, bpmaterial);
    }

    private void checkDATA(IBpmaterial bpmaterial) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Bpmaterial.Bp - Evetype.Id
        //foreign key Bpmaterial.Material - Evetype.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteBpmaterial(SQLTqueue transactionqueue, IBpmaterialPK bpmaterialPK) {
    }

    public void delete4evetypeBp(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMbpmaterial.SQLDelete4evetypeBp, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Bpmaterial> getBpmaterials4evetypeBp(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMbpmaterial.SQLSelect4evetypeBp, evetypePK.getSQLprimarykey());
    }
    public void delete4evetypeMaterial(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMbpmaterial.SQLDelete4evetypeMaterial, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Bpmaterial> getBpmaterials4evetypeMaterial(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMbpmaterial.SQLSelect4evetypeMaterial, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Bpmaterial> getBpmaterials(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMbpmaterial.SQLSelect);
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
        return (ArrayList<Bpmaterial>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delBpmaterial(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Bpmaterial.table);
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
