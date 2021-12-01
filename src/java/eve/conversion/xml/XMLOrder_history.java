/*
 * XMLOrder_history.java
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
import eve.entity.pk.Order_historyPK;
import eve.interfaces.entity.pk.IOrder_historyPK;
import eve.logicentity.Order_history;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLOrder_history {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IOrder_historyPK order_historyPK) {
        PK.addContent(XMLElement.newContent("region", order_historyPK.getRegion()));
        PK.addContent(XMLElement.newContent("evetype", order_historyPK.getEvetype()));
        if(order_historyPK.getDate()!=null) {
            PK.addContent(XMLElement.newContent("date", order_historyPK.getDate().getTime()));
        }
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Order_historyXML, Order_history order_history) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, order_history.getPrimaryKey());
        Order_historyXML.addContent(PK);
        Order_historyXML.addContent(XMLElement.newContent("average", order_history.getAverage()));
        Order_historyXML.addContent(XMLElement.newContent("highest", order_history.getHighest()));
        Order_historyXML.addContent(XMLElement.newContent("lowest", order_history.getLowest()));
        Order_historyXML.addContent(XMLElement.newContent("volume", order_history.getVolume()));
        Order_historyXML.addContent(XMLElement.newContent("order_count", order_history.getOrder_count()));
    }
}

