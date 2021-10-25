/*
 * XMLRoute.java
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
import eve.entity.pk.RoutePK;
import eve.interfaces.entity.pk.IRoutePK;
import eve.logicentity.Route;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLRoute {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IRoutePK routePK) {
        PK.addContent(XMLElement.newContent("routetype", routePK.getRoutetype()));
        PK.addContent(XMLElement.newContent("system", routePK.getSystem()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element RouteXML, Route route) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, route.getPrimaryKey());
        RouteXML.addContent(PK);
    }
}

