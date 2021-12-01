/*
 * XMLSystemtrade_order.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.10.2021 10:3
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
import eve.entity.pk.Systemtrade_orderPK;
import eve.interfaces.entity.pk.ISystemtrade_orderPK;
import eve.logicentity.Systemtrade_order;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLSystemtrade_order {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ISystemtrade_orderPK systemtrade_orderPK) {
        PK.addContent(XMLElement.newContent("sell_system", systemtrade_orderPK.getSell_system()));
        PK.addContent(XMLElement.newContent("buy_system", systemtrade_orderPK.getBuy_system()));
        PK.addContent(XMLElement.newContent("sell_order", systemtrade_orderPK.getSell_order()));
        PK.addContent(XMLElement.newContent("buy_order", systemtrade_orderPK.getBuy_order()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Systemtrade_orderXML, Systemtrade_order systemtrade_order) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, systemtrade_order.getPrimaryKey());
        Systemtrade_orderXML.addContent(PK);
        Systemtrade_orderXML.addContent(XMLElement.newContent("amount", systemtrade_order.getAmount()));
        Systemtrade_orderXML.addContent(XMLElement.newContent("sellprice", systemtrade_order.getSellprice()));
        Systemtrade_orderXML.addContent(XMLElement.newContent("buyprice", systemtrade_order.getBuyprice()));
        Systemtrade_orderXML.addContent(XMLElement.newContent("profit", systemtrade_order.getProfit()));
        Systemtrade_orderXML.addContent(XMLElement.newContent("cargovolume", systemtrade_order.getCargovolume()));
    }
}

