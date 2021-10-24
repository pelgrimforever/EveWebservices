/*
 * XMLJson_orders.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:40
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
import eve.entity.pk.Json_ordersPK;
import eve.interfaces.entity.pk.IJson_ordersPK;
import eve.logicentity.Json_orders;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLJson_orders {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IJson_ordersPK json_ordersPK) {
        PK.addContent(XMLElement.newContent("id", json_ordersPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Json_ordersXML, Json_orders json_orders) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, json_orders.getPrimaryKey());
        Json_ordersXML.addContent(PK);
    }
}

