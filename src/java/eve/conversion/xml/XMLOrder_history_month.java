/*
 * XMLOrder_history_month.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
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
import eve.entity.pk.Order_history_monthPK;
import eve.interfaces.entity.pk.IOrder_history_monthPK;
import eve.logicentity.Order_history_month;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLOrder_history_month {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IOrder_history_monthPK order_history_monthPK) {
        PK.addContent(XMLElement.newContent("region", order_history_monthPK.getRegion()));
        PK.addContent(XMLElement.newContent("evetype", order_history_monthPK.getEvetype()));
        PK.addContent(XMLElement.newContent("year", order_history_monthPK.getYear()));
        PK.addContent(XMLElement.newContent("month", order_history_monthPK.getMonth()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Order_history_monthXML, Order_history_month order_history_month) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, order_history_month.getPrimaryKey());
        Order_history_monthXML.addContent(PK);
        Order_history_monthXML.addContent(XMLElement.newContent("average", order_history_month.getAverage()));
        Order_history_monthXML.addContent(XMLElement.newContent("highest", order_history_month.getHighest()));
        Order_history_monthXML.addContent(XMLElement.newContent("lowest", order_history_month.getLowest()));
        Order_history_monthXML.addContent(XMLElement.newContent("volume", order_history_month.getVolume()));
        Order_history_monthXML.addContent(XMLElement.newContent("order_count", order_history_month.getOrder_count()));
    }
}

