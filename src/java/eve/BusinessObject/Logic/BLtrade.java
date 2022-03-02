/*
 * BLtrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 1.5.2021 17:54
 *
 */

package eve.BusinessObject.Logic;

import general.exception.DBException;
import eve.interfaces.logicentity.ITrade;
import BusinessObject.BLtable;
import eve.BusinessObject.table.Btrade;
import eve.conversion.entity.EMtrade;
import general.exception.DataException;
import eve.interfaces.entity.pk.ITradePK;
import eve.logicentity.Orders;
import eve.logicentity.Trade;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Business Logic Entity class BLtrade
 *
 * Class for manipulating data- and database objects
 * for Entity Trade and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLtrade extends Btrade {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Trade as default Entity
     */
    public BLtrade() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Trade as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLtrade(BLtable transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * update all trade lines that contain a sell or buy order from this trade line
     * @param tradePK: trade primary key
     * @param volume: traded volume
     * @throws DBException
     * @throws DataException 
     */
    public void executetrade(ITradePK tradePK, long volume) throws DBException, DataException {
        ArrayList trades = getEntities(EMtrade.SQLSellBuyOrders, tradePK.getSQLprimarykey());
        BLorders blorders = new BLorders();
        Orders sellorder = blorders.getOrders(tradePK.getOrderssell_order_idPK());
        Orders buyorder = blorders.getOrders(tradePK.getOrdersbuy_order_idPK());
        Iterator<Trade> tradeI = trades.iterator();
        Trade trade;
        //update sell and buy orders
        subtractOrdervolume(sellorder, volume);
        subtractOrdervolume(buyorder, volume);
        //update trade lines
        Orders trade_sellorder = null;
        Orders trade_buyorder = null;
        while(tradeI.hasNext()) {
            trade = tradeI.next();
            if(trade.getPrimaryKey().equals(tradePK)) {
                trade_sellorder = sellorder;
                trade_buyorder = buyorder;
            } else {
                if(trade.getPrimaryKey().getOrderssell_order_idPK().equals(tradePK.getOrderssell_order_idPK())) {
                    trade_sellorder = sellorder;
                    trade_buyorder = blorders.getOrders(trade.getPrimaryKey().getOrdersbuy_order_idPK());
                }
                if(trade.getPrimaryKey().getOrdersbuy_order_idPK().equals(tradePK.getOrdersbuy_order_idPK())) {
                    trade_sellorder = blorders.getOrders(trade.getPrimaryKey().getOrderssell_order_idPK());
                    trade_buyorder = buyorder;
                }
            }
            recalculateTrade(trade, trade_sellorder, trade_buyorder);
            if(trade.getTotal_volume()==0) {
                trans_deleteTrade(trade);
            } else {
                trans_updateTrade(trade);
            }
        }
        Commit2DB();
    }
    
    public void subtractOrdervolume(Orders order, long volume) {
        order.setVolume_remain(order.getVolume_remain() - volume);
    }
    
    public void recalculateTrade(Trade trade, Orders sellorder, Orders buyorder) {
        long volume = Math.min(sellorder.getVolume_remain(), buyorder.getVolume_remain());
        trade.setTotal_volume(volume);
        trade.setSell_order_value(volume * sellorder.getPrice());
        trade.setBuy_order_value(volume * buyorder.getPrice());
        trade.setProfit(trade.getBuy_order_value()*0.95 - trade.getSell_order_value());
        trade.setProfit_per_jump(trade.getProfit() / trade.getJumps());
        if(trade.getRuns()>1) {
            trade.setRuns(1);
            trade.setSinglerun_profit_per_jump(0);
        }
    }
    
    /**
     * delete all trade lines
     * @throws DBException
     * @throws DataException 
     */
    public void deletetrade() throws DBException, DataException {
        this.addStatement(EMtrade.SQLdeleteall);
        this.Commit2DB();
    }
    
    /**
     * try to insert Trade object in database
     * commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void insertTrade(ITrade trade) throws DBException, DataException {
        trans_insertTrade(trade);
        super.Commit2DB();
    }
    
    /**
     * try to insert Trade object in database
     * an alternative to insertTrade, which can be made an empty function
     * commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureinsertTrade(ITrade trade) throws DBException, DataException {
        trans_insertTrade(trade);
        super.Commit2DB();
    }
    
    /**
     * try to update Trade object in database
     * commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    @Override
    public void updateTrade(ITrade trade) throws DBException, DataException {
        trans_updateTrade(trade);
        super.Commit2DB();
    }
    
    /**
     * try to update Trade object in database
     * an alternative to updateTrade, which can be made an empty function
     * commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void secureupdateTrade(ITrade trade) throws DBException, DataException {
        trans_updateTrade(trade);
        super.Commit2DB();
    }
    
    /**
     * try to delete Trade object in database
     * commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     */
    @Override
    public void deleteTrade(ITrade trade) throws DBException {
        trans_deleteTrade(trade);
        super.Commit2DB();
    }

    /**
     * try to delete Trade object in database
     * an alternative to deleteTrade, which can be made an empty function
     * commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void securedeleteTrade(ITrade trade) throws DBException {
        trans_deleteTrade(trade);
        super.Commit2DB();
    }

    /**
     * try to insert Trade object in database
     * do not commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_insertTrade(ITrade trade) throws DBException, DataException {
        super.checkDATA(trade);
        super.insertTrade((Trade)trade);
    }
    
    /**
     * try to update Trade object in database
     * do not commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     * @throws eve.general.exception.DataException
     */
    public void trans_updateTrade(ITrade trade) throws DBException, DataException {
        super.checkDATA(trade);
        super.updateTrade((Trade)trade);
    }
    
    /**
     * try to delete Trade object in database
     * do not commit transaction
     * @param trade: Trade Entity Object
     * @throws eve.general.exception.CustomException
     */
    public void trans_deleteTrade(ITrade trade) throws DBException {
        super.deleteTrade((Trade)trade);
    }
}
