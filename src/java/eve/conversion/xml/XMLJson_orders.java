/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
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

public class XMLJson_orders {
    
    public static void addXML(Element PK, IJson_ordersPK json_ordersPK) {
        PK.addContent(XMLElement.newContent("id", json_ordersPK.getId()));
    }

    public static void addXML(Element Json_ordersXML, Json_orders json_orders) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, json_orders.getPrimaryKey());
        Json_ordersXML.addContent(PK);
    }
}

