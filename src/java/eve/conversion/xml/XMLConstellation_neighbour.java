/*
 * XMLConstellation_neighbour.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.11.2021 14:30
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
import eve.entity.pk.Constellation_neighbourPK;
import eve.interfaces.entity.pk.IConstellation_neighbourPK;
import eve.logicentity.Constellation_neighbour;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLConstellation_neighbour {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IConstellation_neighbourPK constellation_neighbourPK) {
        PK.addContent(XMLElement.newContent("constellation", constellation_neighbourPK.getConstellation()));
        PK.addContent(XMLElement.newContent("neighbour", constellation_neighbourPK.getNeighbour()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Constellation_neighbourXML, Constellation_neighbour constellation_neighbour) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, constellation_neighbour.getPrimaryKey());
        Constellation_neighbourXML.addContent(PK);
    }
}

