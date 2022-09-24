/*
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
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
import eve.logicentity.Trade;
import eve.logicview.*;
import eve.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Trade_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLtrade bltrade = new BLtrade(sqlreader);
    
    public Trade_usecases() {
        this(false);
    }
    
    public Trade_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bltrade.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    private BLorders blorders;
    private Orders sellorder;
    private Orders buyorder;

    public void executetrade(ITradePK tradePK, long volume) throws DBException, DataException {
        SQLTqueue transactionqueue = new SQLTqueue();
        blorders = new BLorders(bltrade);
        sellorder = blorders.getOrders(tradePK.getOrderssell_order_idPK());
        buyorder = blorders.getOrders(tradePK.getOrdersbuy_order_idPK());
        update_ordervolumes(volume);
        ArrayList<Trade> trades = bltrade.getSellbuyorders(tradePK);
        Iterator<Trade> tradeI = trades.iterator();
        while(tradeI.hasNext())
            update_tradeline(transactionqueue, tradeI.next(), tradePK);
        sqlwriter.Commit2DB(transactionqueue);
    }

    private void update_ordervolumes(long volume) {
        subtractOrdervolume(sellorder, volume);
        subtractOrdervolume(buyorder, volume);
    }
    
    private void update_tradeline(SQLTqueue transactionqueue, Trade trade, ITradePK tradePK) throws DataException, DBException {
        Orders trade_sellorder = sellorder;
        Orders trade_buyorder = buyorder;
        if(!trade.getPrimaryKey().equals(tradePK)) {
            if(trade.getPrimaryKey().getOrderssell_order_idPK().equals(tradePK.getOrderssell_order_idPK()))
                trade_buyorder = blorders.getOrders(trade.getPrimaryKey().getOrdersbuy_order_idPK());
            if(trade.getPrimaryKey().getOrdersbuy_order_idPK().equals(tradePK.getOrdersbuy_order_idPK()))
                trade_sellorder = blorders.getOrders(trade.getPrimaryKey().getOrderssell_order_idPK());
        }
        recalculateTrade(trade, trade_sellorder, trade_buyorder);
        if(trade.getTotal_volume()==0)
            bltrade.deleteTrade(transactionqueue, trade);
        else
            bltrade.updateTrade(transactionqueue, trade);
    }

    private void recalculateTrade(Trade trade, Orders trade_sellorder, Orders trade_buyorder) {
        long volume = Math.min(trade_sellorder.getVolume_remain(), trade_buyorder.getVolume_remain());
        trade.setTotal_volume(volume);
        trade.setSell_order_value(volume * trade_sellorder.getPrice());
        trade.setBuy_order_value(volume * trade_buyorder.getPrice());
        trade.setProfit(trade.getBuy_order_value()*0.95 - trade.getSell_order_value());
        trade.setProfit_per_jump(trade.getProfit() / trade.getJumps());
        if(trade.getRuns()>1) {
            trade.setRuns(1);
            trade.setSinglerun_profit_per_jump(0);
        }
    }
    
    private void subtractOrdervolume(Orders order, long volume) {
        order.setVolume_remain(order.getVolume_remain() - volume);
    }
    
//Custom code, do not change this line   

    public long count() throws DBException {
        return bltrade.count();
    }
    
    public ArrayList<Trade> get_all() throws DBException {
        return bltrade.getTrades();
    }
    
    public boolean getTradeExists(ITradePK tradePK) throws DBException {
        return bltrade.getTradeExists(tradePK);
    }
    
    public Trade get_trade_by_primarykey(ITradePK tradePK) throws DBException {
        return bltrade.getTrade(tradePK);
    }

    public ArrayList<Trade> get_trade_with_foreignkey_ordersSell_order_id(IOrdersPK ordersSell_order_idPK) throws CustomException {
        return bltrade.getTrades4ordersSell_order_id(ordersSell_order_idPK);
    }
    
    public ArrayList<Trade> get_trade_with_foreignkey_ordersBuy_order_id(IOrdersPK ordersBuy_order_idPK) throws CustomException {
        return bltrade.getTrades4ordersBuy_order_id(ordersBuy_order_idPK);
    }
    
    public ArrayList<Trade> search_trade(ITradesearch tradesearch) throws CustomException {
        return bltrade.search(tradesearch);
    }
    
    public long search_trade_count(ITradesearch tradesearch) throws CustomException {
        return bltrade.searchcount(tradesearch);
    }

    public void insertTrade(ITrade trade) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bltrade.insertTrade(tq, trade);
        sqlwriter.Commit2DB(tq);
    }

    public void updateTrade(ITrade trade) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bltrade.updateTrade(tq, trade);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteTrade(ITrade trade) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        bltrade.deleteTrade(tq, trade);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Orderssell_order_id(IOrdersPK ordersSell_order_idPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        bltrade.delete4ordersSell_order_id(tq, ordersSell_order_idPK);
        sqlwriter.Commit2DB(tq);
    }
    
    public void delete_all_containing_Ordersbuy_order_id(IOrdersPK ordersBuy_order_idPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        bltrade.delete4ordersBuy_order_id(tq, ordersBuy_order_idPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

