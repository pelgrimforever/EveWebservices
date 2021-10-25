/*
 * XMLSystemjumps.java
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
import eve.entity.pk.SystemjumpsPK;
import eve.interfaces.entity.pk.ISystemjumpsPK;
import eve.logicentity.Systemjumps;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLSystemjumps {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ISystemjumpsPK systemjumpsPK) {
        PK.addContent(XMLElement.newContent("system_start", systemjumpsPK.getSystem_start()));
        PK.addContent(XMLElement.newContent("system_end", systemjumpsPK.getSystem_end()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element SystemjumpsXML, Systemjumps systemjumps) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, systemjumps.getPrimaryKey());
        SystemjumpsXML.addContent(PK);
        SystemjumpsXML.addContent(XMLElement.newContent("jumps", systemjumps.getJumps()));
    }
}

