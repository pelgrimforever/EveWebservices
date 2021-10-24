/*
 * XMLRoutetype.java
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
import eve.entity.pk.RoutetypePK;
import eve.interfaces.entity.pk.IRoutetypePK;
import eve.logicentity.Routetype;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLRoutetype {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IRoutetypePK routetypePK) {
        PK.addContent(XMLElement.newContent("id", routetypePK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element RoutetypeXML, Routetype routetype) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, routetype.getPrimaryKey());
        RoutetypeXML.addContent(PK);
        if(routetype.getSecurity_islandPK()!=null) {
            Element security_islandPK = XMLElement.newContent("security_islandPK", "");
            XMLSecurity_island.addXML(security_islandPK, routetype.getSecurity_islandPK());
            RoutetypeXML.addContent(security_islandPK);
        }
        RoutetypeXML.addContent(XMLElement.newContent("name", routetype.getName()));
    }
}

