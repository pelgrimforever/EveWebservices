/*
 * XMLSyssettings.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
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
import eve.entity.pk.SyssettingsPK;
import eve.interfaces.entity.pk.ISyssettingsPK;
import eve.logicentity.Syssettings;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLSyssettings {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ISyssettingsPK syssettingsPK) {
        PK.addContent(XMLElement.newContent("name", syssettingsPK.getName()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element SyssettingsXML, Syssettings syssettings) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, syssettings.getPrimaryKey());
        SyssettingsXML.addContent(PK);
        SyssettingsXML.addContent(XMLElement.newContent("value", syssettings.getValue()));
    }
}

