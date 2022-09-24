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
import eve.conversion.entity.EMevetype;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IEvetypesearch;
import eve.logicentity.Evetype;

public abstract class Bevetype extends TableBusinessrules {

    public Bevetype(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMevetype()));
    }

    public Bevetype(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMevetype()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IEvetype newEvetype() {
    	return new Evetype();
    }
    
    public IEvetype newEvetype(long id) {
        return new Evetype(id);
    }

    public IEvetype newEvetype(IEvetypePK evetypePK) {
        return new Evetype((EvetypePK)evetypePK);
    }

    public IEvetypePK newEvetypePK() {
        return new EvetypePK();
    }

    public IEvetypePK newEvetypePK(long id) {
        return new EvetypePK(id);
    }

    public ArrayList<Evetype> getEvetypes() throws DBException {
        return (ArrayList<Evetype>)tableio.getEntities(EMevetype.SQLSelectAll);
    }

    public Evetype getEvetype(IEvetypePK evetypePK) throws DBException {
        return (Evetype)tableio.getEntity((EvetypePK)evetypePK);
    }

    public ArrayList<Evetype> searchevetypes(IEvetypesearch search) throws DBException {
        return (ArrayList<Evetype>)tableio.search(search);
    }

    public ArrayList<Evetype> searchevetypes(IEvetypesearch search, String orderby) throws DBException {
        return (ArrayList<Evetype>)tableio.search(search, orderby);
    }

    public boolean getEvetypeExists(IEvetypePK evetypePK) throws DBException {
        return tableio.getEntityExists((EvetypePK)evetypePK);
    }

    public Evetype getEntity(String sql) throws DBException {
        return (Evetype)tableio.getEntity(sql);
    }
    
    public Evetype getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Evetype)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Evetype> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Evetype> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Evetype> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Evetype> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertEvetype(SQLTqueue transactionqueue, IEvetype evetype) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, evetype);
    }

    public void insertupdateEvetype(SQLTqueue transactionqueue, IEvetype evetype) throws DBException, DataException {
    	checkDATA(evetype);
        if(this.getEvetypeExists(evetype.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, evetype);
        } else {
            tableio.insertEntity(transactionqueue, evetype);
        }
    }

    public void updateEvetype(SQLTqueue transactionqueue, IEvetype evetype) throws DBException, DataException {
    	checkDATA(evetype);
        tableio.updateEntity(transactionqueue, evetype);
    }

    public void deleteEvetype(SQLTqueue transactionqueue, IEvetype evetype) throws DBException {
        cascadedeleteEvetype(transactionqueue, evetype.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, evetype);
    }

    private void checkDATA(IEvetype evetype) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(evetype.getName()!=null && evetype.getName().length()>IEvetype.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IEvetype.SIZE_NAME).append("\n");
        }
        if(evetype.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(evetype.getDescription()!=null && evetype.getDescription().length()>IEvetype.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IEvetype.SIZE_DESCRIPTION).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteEvetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        BLwishlist blwishlist = new BLwishlist(this);
        blwishlist.setAuthenticated(isAuthenticated());
        blwishlist.delete4evetype(transactionqueue, evetypePK);
        BLmaterialinput blmaterialinput = new BLmaterialinput(this);
        blmaterialinput.setAuthenticated(isAuthenticated());
        blmaterialinput.delete4evetype(transactionqueue, evetypePK);
        BLbpmaterial blbpmaterialBp = new BLbpmaterial(this);
        blbpmaterialBp.setAuthenticated(isAuthenticated());
        blbpmaterialBp.delete4evetypeBp(transactionqueue, evetypePK);
        BLbpmaterial blbpmaterialMaterial = new BLbpmaterial(this);
        blbpmaterialMaterial.setAuthenticated(isAuthenticated());
        blbpmaterialMaterial.delete4evetypeMaterial(transactionqueue, evetypePK);
        BLorder_history_month blorder_history_month = new BLorder_history_month(this);
        blorder_history_month.setAuthenticated(isAuthenticated());
        blorder_history_month.delete4evetype(transactionqueue, evetypePK);
        BLstock blstock = new BLstock(this);
        blstock.setAuthenticated(isAuthenticated());
        blstock.delete4evetype(transactionqueue, evetypePK);
        BLorder_history blorder_history = new BLorder_history(this);
        blorder_history.setAuthenticated(isAuthenticated());
        blorder_history.delete4evetype(transactionqueue, evetypePK);
        BLshipfitmodule blshipfitmodule = new BLshipfitmodule(this);
        blshipfitmodule.setAuthenticated(isAuthenticated());
        blshipfitmodule.delete4evetype(transactionqueue, evetypePK);
        BLshipfitorder blshipfitorder = new BLshipfitorder(this);
        blshipfitorder.setAuthenticated(isAuthenticated());
        blshipfitorder.delete4evetype(transactionqueue, evetypePK);
        BLtradecombined bltradecombined = new BLtradecombined(this);
        bltradecombined.setAuthenticated(isAuthenticated());
        bltradecombined.delete4evetype(transactionqueue, evetypePK);
        BLuserbp bluserbp = new BLuserbp(this);
        bluserbp.setAuthenticated(isAuthenticated());
        bluserbp.delete4evetype(transactionqueue, evetypePK);
    }

    public void delete4market_group(SQLTqueue transactionqueue, IMarket_groupPK market_groupPK) {
        tableio.addStatement(transactionqueue, EMevetype.SQLDelete4market_group, market_groupPK.getSQLprimarykey());
    }

    public ArrayList<Evetype> getEvetypes4market_group(IMarket_groupPK market_groupPK) throws CustomException {
        return tableio.getEntities(EMevetype.SQLSelect4market_group, market_groupPK.getSQLprimarykey());
    }
    public void delete4typegroup(SQLTqueue transactionqueue, ITypegroupPK typegroupPK) {
        tableio.addStatement(transactionqueue, EMevetype.SQLDelete4typegroup, typegroupPK.getSQLprimarykey());
    }

    public ArrayList<Evetype> getEvetypes4typegroup(ITypegroupPK typegroupPK) throws CustomException {
        return tableio.getEntities(EMevetype.SQLSelect4typegroup, typegroupPK.getSQLprimarykey());
    }
    public void delete4graphic(SQLTqueue transactionqueue, IGraphicPK graphicPK) {
        tableio.addStatement(transactionqueue, EMevetype.SQLDelete4graphic, graphicPK.getSQLprimarykey());
    }

    public ArrayList<Evetype> getEvetypes4graphic(IGraphicPK graphicPK) throws CustomException {
        return tableio.getEntities(EMevetype.SQLSelect4graphic, graphicPK.getSQLprimarykey());
    }
    public Evetype getWishlist(IWishlistPK wishlistPK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(wishlistPK.getEvetype());
        return this.getEvetype(evetypePK);
    }

    public Evetype getMaterialinput(IMaterialinputPK materialinputPK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(materialinputPK.getEvetype());
        return this.getEvetype(evetypePK);
    }

    public Evetype getBpmaterialbp(IBpmaterialPK bpmaterialPK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(bpmaterialPK.getBp());
        return this.getEvetype(evetypePK);
    }

    public Evetype getBpmaterialmaterial(IBpmaterialPK bpmaterialPK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(bpmaterialPK.getMaterial());
        return this.getEvetype(evetypePK);
    }

    public Evetype getOrder_history_month(IOrder_history_monthPK order_history_monthPK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(order_history_monthPK.getEvetype());
        return this.getEvetype(evetypePK);
    }

    public Evetype getStock(IStockPK stockPK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(stockPK.getEvetype());
        return this.getEvetype(evetypePK);
    }

    public Evetype getOrder_history(IOrder_historyPK order_historyPK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(order_historyPK.getEvetype());
        return this.getEvetype(evetypePK);
    }

    public Evetype getShipfitmodule(IShipfitmodulePK shipfitmodulePK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(shipfitmodulePK.getModuletype());
        return this.getEvetype(evetypePK);
    }

    public Evetype getShipfitorder(IShipfitorderPK shipfitorderPK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(shipfitorderPK.getEvetype());
        return this.getEvetype(evetypePK);
    }

    public Evetype getTradecombined(ITradecombinedPK tradecombinedPK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(tradecombinedPK.getEvetype());
        return this.getEvetype(evetypePK);
    }

    public Evetype getUserbp(IUserbpPK userbpPK) throws CustomException {
        EvetypePK evetypePK = new EvetypePK(userbpPK.getBp());
        return this.getEvetype(evetypePK);
    }


    public ArrayList<Evetype> getEvetypes(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMevetype.SQLSelect);
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
        return (ArrayList<Evetype>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delEvetype(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Evetype.table);
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
