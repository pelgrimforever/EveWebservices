/*
 * XMLOrder_hist.java
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
import eve.entity.pk.Order_histPK;
import eve.interfaces.entity.pk.IOrder_histPK;
import eve.logicentity.Order_hist;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLOrder_hist {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IOrder_histPK order_histPK) {
        PK.addContent(XMLElement.newContent("id", order_histPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Order_histXML, Order_hist order_hist) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, order_hist.getPrimaryKey());
        Order_histXML.addContent(PK);
        if(order_hist.getEvetypePK()!=null) {
            Element evetypePK = XMLElement.newContent("evetypePK", "");
            XMLEvetype.addXML(evetypePK, order_hist.getEvetypePK());
            Order_histXML.addContent(evetypePK);
        }
        if(order_hist.getSystemPK()!=null) {
            Element systemPK = XMLElement.newContent("systemPK", "");
            XMLSystem.addXML(systemPK, order_hist.getSystemPK());
            Order_histXML.addContent(systemPK);
        }
        Order_histXML.addContent(XMLElement.newContent("isopen", order_hist.getIsopen()));
        Order_histXML.addContent(XMLElement.newContent("volume_total", order_hist.getVolume_total()));
        Order_histXML.addContent(XMLElement.newContent("volume_remain", order_hist.getVolume_remain()));
        Order_histXML.addContent(XMLElement.newContent("range", order_hist.getRange()));
        Order_histXML.addContent(XMLElement.newContent("range_number", order_hist.getRange_number()));
        Order_histXML.addContent(XMLElement.newContent("price", order_hist.getPrice()));
        Order_histXML.addContent(XMLElement.newContent("min_volume", order_hist.getMin_volume()));
        Order_histXML.addContent(XMLElement.newContent("location", order_hist.getLocation()));
        Order_histXML.addContent(XMLElement.newContent("is_buy_order", order_hist.getIs_buy_order()));
        if(order_hist.getIssued()!=null) {
            Order_histXML.addContent(XMLElement.newContent("issued", order_hist.getIssued().toString()));
        }
        Order_histXML.addContent(XMLElement.newContent("duration", order_hist.getDuration()));
    }
}

