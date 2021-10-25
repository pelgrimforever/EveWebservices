/*
 * XMLFaction.java
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
import eve.entity.pk.FactionPK;
import eve.interfaces.entity.pk.IFactionPK;
import eve.logicentity.Faction;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLFaction {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IFactionPK factionPK) {
        PK.addContent(XMLElement.newContent("id", factionPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element FactionXML, Faction faction) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, faction.getPrimaryKey());
        FactionXML.addContent(PK);
        if(faction.getSystemPK()!=null) {
            Element systemPK = XMLElement.newContent("systemPK", "");
            XMLSystem.addXML(systemPK, faction.getSystemPK());
            FactionXML.addContent(systemPK);
        }
        FactionXML.addContent(XMLElement.newContent("name", faction.getName()));
        FactionXML.addContent(XMLElement.newContent("description", faction.getDescription()));
        FactionXML.addContent(XMLElement.newContent("is_unique", faction.getIs_unique()));
        FactionXML.addContent(XMLElement.newContent("size_factor", faction.getSize_factor()));
        FactionXML.addContent(XMLElement.newContent("station_count", faction.getStation_count()));
        FactionXML.addContent(XMLElement.newContent("station_system_count", faction.getStation_system_count()));
        FactionXML.addContent(XMLElement.newContent("corporation", faction.getCorporation()));
        FactionXML.addContent(XMLElement.newContent("militia_corporation", faction.getMilitia_corporation()));
    }
}

