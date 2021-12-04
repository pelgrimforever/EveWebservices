/*
 * XMLLocation.java
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
import eve.entity.pk.LocationPK;
import eve.interfaces.entity.pk.ILocationPK;
import eve.logicentity.Location;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLLocation {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ILocationPK locationPK) {
        PK.addContent(XMLElement.newContent("id", locationPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element LocationXML, Location location) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, location.getPrimaryKey());
        LocationXML.addContent(PK);
        if(location.getSystemPK()!=null) {
            Element systemPK = XMLElement.newContent("systemPK", "");
            XMLSystem.addXML(systemPK, location.getSystemPK());
            LocationXML.addContent(systemPK);
        }
        LocationXML.addContent(XMLElement.newContent("name", location.getName()));
        LocationXML.addContent(XMLElement.newContent("visited", location.getVisited()));
        LocationXML.addContent(XMLElement.newContent("access", location.getAccess()));
    }
}

