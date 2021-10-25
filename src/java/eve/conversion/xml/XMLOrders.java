/*
 * XMLOrders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
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
import eve.entity.pk.OrdersPK;
import eve.interfaces.entity.pk.IOrdersPK;
import eve.logicentity.Orders;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLOrders {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IOrdersPK ordersPK) {
        PK.addContent(XMLElement.newContent("id", ordersPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element OrdersXML, Orders orders) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, orders.getPrimaryKey());
        OrdersXML.addContent(PK);
        if(orders.getEvetypePK()!=null) {
            Element evetypePK = XMLElement.newContent("evetypePK", "");
            XMLEvetype.addXML(evetypePK, orders.getEvetypePK());
            OrdersXML.addContent(evetypePK);
        }
        if(orders.getSystemPK()!=null) {
            Element systemPK = XMLElement.newContent("systemPK", "");
            XMLSystem.addXML(systemPK, orders.getSystemPK());
            OrdersXML.addContent(systemPK);
        }
        OrdersXML.addContent(XMLElement.newContent("isopen", orders.getIsopen()));
        OrdersXML.addContent(XMLElement.newContent("volume_total", orders.getVolume_total()));
        OrdersXML.addContent(XMLElement.newContent("volume_remain", orders.getVolume_remain()));
        OrdersXML.addContent(XMLElement.newContent("range", orders.getRange()));
        OrdersXML.addContent(XMLElement.newContent("range_number", orders.getRange_number()));
        OrdersXML.addContent(XMLElement.newContent("price", orders.getPrice()));
        OrdersXML.addContent(XMLElement.newContent("min_volume", orders.getMin_volume()));
        OrdersXML.addContent(XMLElement.newContent("location", orders.getLocation()));
        OrdersXML.addContent(XMLElement.newContent("is_buy_order", orders.getIs_buy_order()));
        if(orders.getIssued()!=null) {
            OrdersXML.addContent(XMLElement.newContent("issued", orders.getIssued().toString()));
        }
        OrdersXML.addContent(XMLElement.newContent("duration", orders.getDuration()));
        OrdersXML.addContent(XMLElement.newContent("page", orders.getPage()));
    }
}

