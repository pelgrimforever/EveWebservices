/*
 * XMLStargate.java
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
import eve.entity.pk.StargatePK;
import eve.interfaces.entity.pk.IStargatePK;
import eve.logicentity.Stargate;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLStargate {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IStargatePK stargatePK) {
        PK.addContent(XMLElement.newContent("id", stargatePK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element StargateXML, Stargate stargate) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, stargate.getPrimaryKey());
        StargateXML.addContent(PK);
        if(stargate.getSystemsystemPK()!=null) {
            Element systemSystemPK = XMLElement.newContent("systemSystemPK", "");
            XMLSystem.addXML(systemSystemPK, stargate.getSystemsystemPK());
            StargateXML.addContent(systemSystemPK);
        }
        if(stargate.getSystemto_systemPK()!=null) {
            Element systemTo_systemPK = XMLElement.newContent("systemTo_systemPK", "");
            XMLSystem.addXML(systemTo_systemPK, stargate.getSystemto_systemPK());
            StargateXML.addContent(systemTo_systemPK);
        }
        StargateXML.addContent(XMLElement.newContent("to_stargate", stargate.getTo_stargate()));
        StargateXML.addContent(XMLElement.newContent("name", stargate.getName()));
        StargateXML.addContent(XMLElement.newContent("x", stargate.getX()));
        StargateXML.addContent(XMLElement.newContent("y", stargate.getY()));
        StargateXML.addContent(XMLElement.newContent("z", stargate.getZ()));
        StargateXML.addContent(XMLElement.newContent("isconstellationborder", stargate.getIsconstellationborder()));
        StargateXML.addContent(XMLElement.newContent("isregionborder", stargate.getIsregionborder()));
        if(stargate.getDownloaddate()!=null) {
            StargateXML.addContent(XMLElement.newContent("downloaddate", stargate.getDownloaddate().getTime()));
        }
    }
}

