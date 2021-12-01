/*
 * XMLSystem.java
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
import eve.entity.pk.SystemPK;
import eve.interfaces.entity.pk.ISystemPK;
import eve.logicentity.System;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLSystem {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ISystemPK systemPK) {
        PK.addContent(XMLElement.newContent("id", systemPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element SystemXML, System system) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, system.getPrimaryKey());
        SystemXML.addContent(PK);
        if(system.getSecurity_islandPK()!=null) {
            Element security_islandPK = XMLElement.newContent("security_islandPK", "");
            XMLSecurity_island.addXML(security_islandPK, system.getSecurity_islandPK());
            SystemXML.addContent(security_islandPK);
        }
        if(system.getConstellationPK()!=null) {
            Element constellationPK = XMLElement.newContent("constellationPK", "");
            XMLConstellation.addXML(constellationPK, system.getConstellationPK());
            SystemXML.addContent(constellationPK);
        }
        SystemXML.addContent(XMLElement.newContent("name", system.getName()));
        SystemXML.addContent(XMLElement.newContent("security_class", system.getSecurity_class()));
        SystemXML.addContent(XMLElement.newContent("security_status", system.getSecurity_status()));
        SystemXML.addContent(XMLElement.newContent("star_id", system.getStar_id()));
        SystemXML.addContent(XMLElement.newContent("noaccess", system.getNoaccess()));
        SystemXML.addContent(XMLElement.newContent("isconstellationborder", system.getIsconstellationborder()));
        SystemXML.addContent(XMLElement.newContent("isregionborder", system.getIsregionborder()));
    }
}

