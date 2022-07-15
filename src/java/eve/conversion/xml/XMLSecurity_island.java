/*
 * XMLSecurity_island.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.5.2022 8:27
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
import eve.entity.pk.Security_islandPK;
import eve.interfaces.entity.pk.ISecurity_islandPK;
import eve.logicentity.Security_island;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLSecurity_island {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ISecurity_islandPK security_islandPK) {
        PK.addContent(XMLElement.newContent("id", security_islandPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Security_islandXML, Security_island security_island) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, security_island.getPrimaryKey());
        Security_islandXML.addContent(PK);
        Security_islandXML.addContent(XMLElement.newContent("name", security_island.getName()));
        Security_islandXML.addContent(XMLElement.newContent("security_status", security_island.getSecurity_status()));
    }
}

