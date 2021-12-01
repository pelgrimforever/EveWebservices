/*
 * XMLConstellation.java
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
import eve.entity.pk.ConstellationPK;
import eve.interfaces.entity.pk.IConstellationPK;
import eve.logicentity.Constellation;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLConstellation {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IConstellationPK constellationPK) {
        PK.addContent(XMLElement.newContent("id", constellationPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element ConstellationXML, Constellation constellation) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, constellation.getPrimaryKey());
        ConstellationXML.addContent(PK);
        if(constellation.getRegionPK()!=null) {
            Element regionPK = XMLElement.newContent("regionPK", "");
            XMLRegion.addXML(regionPK, constellation.getRegionPK());
            ConstellationXML.addContent(regionPK);
        }
        ConstellationXML.addContent(XMLElement.newContent("name", constellation.getName()));
        ConstellationXML.addContent(XMLElement.newContent("noaccess", constellation.getNoaccess()));
    }
}

