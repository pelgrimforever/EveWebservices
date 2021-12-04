/*
 * XMLTrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.11.2021 14:51
 *
 */
 
package eve.conversion.xml;

import XML.XMLElement;
import java.io.IOException;
import object.Objectoperation;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import eve.entity.pk.TradePK;
import eve.interfaces.entity.pk.ITradePK;
import eve.logicentity.Trade;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLTrade {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ITradePK tradePK) {
        PK.addContent(XMLElement.newContent("sell_order_id", tradePK.getSell_order_id()));
        PK.addContent(XMLElement.newContent("buy_order_id", tradePK.getBuy_order_id()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element TradeXML, Trade trade) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, trade.getPrimaryKey());
        TradeXML.addContent(PK);
        TradeXML.addContent(XMLElement.newContent("total_volume", trade.getTotal_volume()));
        TradeXML.addContent(XMLElement.newContent("buy_order_value", trade.getBuy_order_value()));
        TradeXML.addContent(XMLElement.newContent("sell_order_value", trade.getSell_order_value()));
        TradeXML.addContent(XMLElement.newContent("profit", trade.getProfit()));
        TradeXML.addContent(XMLElement.newContent("jumps", trade.getJumps()));
        TradeXML.addContent(XMLElement.newContent("runs", trade.getRuns()));
        TradeXML.addContent(XMLElement.newContent("total_jumps", trade.getTotal_jumps()));
        TradeXML.addContent(XMLElement.newContent("profit_per_jump", trade.getProfit_per_jump()));
        TradeXML.addContent(XMLElement.newContent("singlerun_profit_per_jump", trade.getSinglerun_profit_per_jump()));
        TradeXML.addContent(XMLElement.newContent("maxunits_per_run", trade.getMaxunits_per_run()));
    }
}

