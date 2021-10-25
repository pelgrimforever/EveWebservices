/*
 * XMLAlliance.java
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
import eve.entity.pk.AlliancePK;
import eve.interfaces.entity.pk.IAlliancePK;
import eve.logicentity.Alliance;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLAlliance {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IAlliancePK alliancePK) {
        PK.addContent(XMLElement.newContent("id", alliancePK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element AllianceXML, Alliance alliance) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, alliance.getPrimaryKey());
        AllianceXML.addContent(PK);
        if(alliance.getCorporationcreator_corporationPK()!=null) {
            Element corporationCreator_corporationPK = XMLElement.newContent("corporationCreator_corporationPK", "");
            XMLCorporation.addXML(corporationCreator_corporationPK, alliance.getCorporationcreator_corporationPK());
            AllianceXML.addContent(corporationCreator_corporationPK);
        }
        if(alliance.getCorporationexecutor_corporationPK()!=null) {
            Element corporationExecutor_corporationPK = XMLElement.newContent("corporationExecutor_corporationPK", "");
            XMLCorporation.addXML(corporationExecutor_corporationPK, alliance.getCorporationexecutor_corporationPK());
            AllianceXML.addContent(corporationExecutor_corporationPK);
        }
        AllianceXML.addContent(XMLElement.newContent("name", alliance.getName()));
        AllianceXML.addContent(XMLElement.newContent("creator", alliance.getCreator()));
        if(alliance.getDate_founded()!=null) {
            AllianceXML.addContent(XMLElement.newContent("date_founded", alliance.getDate_founded().toString()));
        }
        AllianceXML.addContent(XMLElement.newContent("ticker", alliance.getTicker()));
        AllianceXML.addContent(XMLElement.newContent("faction_id", alliance.getFaction_id()));
    }
}

