/*
 * XMLSystemactivity.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.3.2022 17:21
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
import eve.entity.pk.SystemactivityPK;
import eve.interfaces.entity.pk.ISystemactivityPK;
import eve.logicentity.Systemactivity;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLSystemactivity {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ISystemactivityPK systemactivityPK) {
        PK.addContent(XMLElement.newContent("systemid", systemactivityPK.getSystemid()));
        if(systemactivityPK.getTimeslot()!=null) {
          PK.addContent(XMLElement.newContent("timeslot", systemactivityPK.getTimeslot().getTime()));
        }
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element SystemactivityXML, Systemactivity systemactivity) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, systemactivity.getPrimaryKey());
        SystemactivityXML.addContent(PK);
        SystemactivityXML.addContent(XMLElement.newContent("ship_jumps", systemactivity.getShip_jumps()));
        SystemactivityXML.addContent(XMLElement.newContent("npc_kills", systemactivity.getNpc_kills()));
        SystemactivityXML.addContent(XMLElement.newContent("ship_kills", systemactivity.getShip_kills()));
        SystemactivityXML.addContent(XMLElement.newContent("pod_kills", systemactivity.getPod_kills()));
    }
}

