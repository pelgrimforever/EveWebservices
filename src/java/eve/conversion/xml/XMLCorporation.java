/*
 * XMLCorporation.java
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
import eve.entity.pk.CorporationPK;
import eve.interfaces.entity.pk.ICorporationPK;
import eve.logicentity.Corporation;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLCorporation {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ICorporationPK corporationPK) {
        PK.addContent(XMLElement.newContent("id", corporationPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element CorporationXML, Corporation corporation) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, corporation.getPrimaryKey());
        CorporationXML.addContent(PK);
        if(corporation.getStationPK()!=null) {
            Element stationPK = XMLElement.newContent("stationPK", "");
            XMLStation.addXML(stationPK, corporation.getStationPK());
            CorporationXML.addContent(stationPK);
        }
        if(corporation.getFactionPK()!=null) {
            Element factionPK = XMLElement.newContent("factionPK", "");
            XMLFaction.addXML(factionPK, corporation.getFactionPK());
            CorporationXML.addContent(factionPK);
        }
        if(corporation.getAlliancePK()!=null) {
            Element alliancePK = XMLElement.newContent("alliancePK", "");
            XMLAlliance.addXML(alliancePK, corporation.getAlliancePK());
            CorporationXML.addContent(alliancePK);
        }
        CorporationXML.addContent(XMLElement.newContent("name", corporation.getName()));
        CorporationXML.addContent(XMLElement.newContent("ceo", corporation.getCeo()));
        CorporationXML.addContent(XMLElement.newContent("creator", corporation.getCreator()));
        CorporationXML.addContent(XMLElement.newContent("member_count", corporation.getMember_count()));
        CorporationXML.addContent(XMLElement.newContent("tax_rate", corporation.getTax_rate()));
        CorporationXML.addContent(XMLElement.newContent("ticker", corporation.getTicker()));
        if(corporation.getDate_founded()!=null) {
            CorporationXML.addContent(XMLElement.newContent("date_founded", corporation.getDate_founded().toString()));
        }
        CorporationXML.addContent(XMLElement.newContent("description", corporation.getDescription()));
        CorporationXML.addContent(XMLElement.newContent("shares", corporation.getShares()));
        CorporationXML.addContent(XMLElement.newContent("url", corporation.getUrl()));
        CorporationXML.addContent(XMLElement.newContent("war_eligible", corporation.getWar_eligible()));
    }
}

