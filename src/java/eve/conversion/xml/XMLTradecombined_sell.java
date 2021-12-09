/*
 * XMLTradecombined_sell.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.11.2021 14:30
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
import eve.entity.pk.Tradecombined_sellPK;
import eve.interfaces.entity.pk.ITradecombined_sellPK;
import eve.logicentity.Tradecombined_sell;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLTradecombined_sell {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ITradecombined_sellPK tradecombined_sellPK) {
        PK.addContent(XMLElement.newContent("sell_system", tradecombined_sellPK.getSell_system()));
        PK.addContent(XMLElement.newContent("buy_system", tradecombined_sellPK.getBuy_system()));
        PK.addContent(XMLElement.newContent("evetype", tradecombined_sellPK.getEvetype()));
        PK.addContent(XMLElement.newContent("buy_order_id", tradecombined_sellPK.getBuy_order_id()));
        PK.addContent(XMLElement.newContent("sell_order_id", tradecombined_sellPK.getSell_order_id()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Tradecombined_sellXML, Tradecombined_sell tradecombined_sell) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, tradecombined_sell.getPrimaryKey());
        Tradecombined_sellXML.addContent(PK);
        Tradecombined_sellXML.addContent(XMLElement.newContent("amount", tradecombined_sell.getAmount()));
        Tradecombined_sellXML.addContent(XMLElement.newContent("buy_order_value", tradecombined_sell.getBuy_order_value()));
        Tradecombined_sellXML.addContent(XMLElement.newContent("sell_order_value", tradecombined_sell.getSell_order_value()));
        Tradecombined_sellXML.addContent(XMLElement.newContent("profit", tradecombined_sell.getProfit()));
    }
}

