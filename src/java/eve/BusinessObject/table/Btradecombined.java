/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.6.2022 13:4
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMtradecombined;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ITradecombinedsearch;
import eve.logicentity.Tradecombined;

/**
 * @author Franky Laseure
 */
public abstract class Btradecombined extends TableBusinessrules {

    public Btradecombined(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMtradecombined()));
    }

    public Btradecombined(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMtradecombined()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ITradecombined newTradecombined() {
    	return new Tradecombined();
    }
    
    public ITradecombined newTradecombined(long sell_system, long buy_system, long evetype) {
        return new Tradecombined(sell_system, buy_system, evetype);
    }

    public ITradecombined newTradecombined(ITradecombinedPK tradecombinedPK) {
        return new Tradecombined((TradecombinedPK)tradecombinedPK);
    }

    public ITradecombinedPK newTradecombinedPK() {
        return new TradecombinedPK();
    }

    public ITradecombinedPK newTradecombinedPK(long sell_system, long buy_system, long evetype) {
        return new TradecombinedPK(sell_system, buy_system, evetype);
    }

    public ArrayList<Tradecombined> getTradecombineds() throws DBException {
        return (ArrayList<Tradecombined>)tableio.getEntities(EMtradecombined.SQLSelectAll);
    }

    public Tradecombined getTradecombined(ITradecombinedPK tradecombinedPK) throws DBException {
        return (Tradecombined)tableio.getEntity((TradecombinedPK)tradecombinedPK);
    }

    public ArrayList<Tradecombined> searchtradecombineds(ITradecombinedsearch search) throws DBException {
        return (ArrayList<Tradecombined>)tableio.search(search);
    }

    public ArrayList<Tradecombined> searchtradecombineds(ITradecombinedsearch search, String orderby) throws DBException {
        return (ArrayList<Tradecombined>)tableio.search(search, orderby);
    }

    public boolean getTradecombinedExists(ITradecombinedPK tradecombinedPK) throws DBException {
        return tableio.getEntityExists((TradecombinedPK)tradecombinedPK);
    }

    public Tradecombined getEntity(String sql) throws DBException {
        return (Tradecombined)tableio.getEntity(sql);
    }
    
    public Tradecombined getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Tradecombined)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Tradecombined> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Tradecombined> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Tradecombined> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Tradecombined> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertTradecombined(SQLTqueue transactionqueue, ITradecombined tradecombined) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, tradecombined);
    }

    public void insertupdateTradecombined(SQLTqueue transactionqueue, ITradecombined tradecombined) throws DBException, DataException {
    	checkDATA(tradecombined);
        if(this.getTradecombinedExists(tradecombined.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, tradecombined);
        } else {
            tableio.insertEntity(transactionqueue, tradecombined);
        }
    }

    public void updateTradecombined(SQLTqueue transactionqueue, ITradecombined tradecombined) throws DBException, DataException {
    	checkDATA(tradecombined);
        tableio.updateEntity(transactionqueue, tradecombined);
    }

    public void deleteTradecombined(SQLTqueue transactionqueue, ITradecombined tradecombined) throws DBException {
        cascadedeleteTradecombined(transactionqueue, tradecombined.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, tradecombined);
    }

    private void checkDATA(ITradecombined tradecombined) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Tradecombined.Sell_system - System.Id
        //foreign key Tradecombined.Buy_system - System.Id
        //foreign key Tradecombined.Evetype - Evetype.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where tradecombinedPK is used in a primary key
     * @param tradecombinedPK: Tradecombined primary key
     */
    public void cascadedeleteTradecombined(SQLTqueue transactionqueue, ITradecombinedPK tradecombinedPK) {
        BLtradecombined_sell bltradecombined_sell = new BLtradecombined_sell(this);
        bltradecombined_sell.setAuthenticated(isAuthenticated());
        bltradecombined_sell.delete4tradecombined(transactionqueue, tradecombinedPK);
    }

    public void delete4evetype(SQLTqueue transactionqueue, IEvetypePK evetypePK) {
        tableio.addStatement(transactionqueue, EMtradecombined.SQLDelete4evetype, evetypePK.getSQLprimarykey());
    }

    public ArrayList<Tradecombined> getTradecombineds4evetype(IEvetypePK evetypePK) throws CustomException {
        return tableio.getEntities(EMtradecombined.SQLSelect4evetype, evetypePK.getSQLprimarykey());
    }
    public void delete4systemBuy_system(SQLTqueue transactionqueue, ISystemPK systemPK) {
        tableio.addStatement(transactionqueue, EMtradecombined.SQLDelete4systemBuy_system, systemPK.getSQLprimarykey());
    }

    public ArrayList<Tradecombined> getTradecombineds4systemBuy_system(ISystemPK systemPK) throws CustomException {
        return tableio.getEntities(EMtradecombined.SQLSelect4systemBuy_system, systemPK.getSQLprimarykey());
    }
    public void delete4systemSell_system(SQLTqueue transactionqueue, ISystemPK systemPK) {
        tableio.addStatement(transactionqueue, EMtradecombined.SQLDelete4systemSell_system, systemPK.getSQLprimarykey());
    }

    public ArrayList<Tradecombined> getTradecombineds4systemSell_system(ISystemPK systemPK) throws CustomException {
        return tableio.getEntities(EMtradecombined.SQLSelect4systemSell_system, systemPK.getSQLprimarykey());
    }
    public Tradecombined getTradecombined_sell(ITradecombined_sellPK tradecombined_sellPK) throws CustomException {
        TradecombinedPK tradecombinedPK = new TradecombinedPK(tradecombined_sellPK.getSell_system(), tradecombined_sellPK.getBuy_system(), tradecombined_sellPK.getEvetype());
        return this.getTradecombined(tradecombinedPK);
    }


    public ArrayList<Tradecombined> getTradecombineds(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMtradecombined.SQLSelect);
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
        return (ArrayList<Tradecombined>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delTradecombined(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Tradecombined.table);
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
