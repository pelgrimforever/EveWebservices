/*
 * XMLSettings.java
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
import eve.entity.pk.SettingsPK;
import eve.interfaces.entity.pk.ISettingsPK;
import eve.logicentity.Settings;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLSettings {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ISettingsPK settingsPK) {
        PK.addContent(XMLElement.newContent("name", settingsPK.getName()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element SettingsXML, Settings settings) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, settings.getPrimaryKey());
        SettingsXML.addContent(PK);
        SettingsXML.addContent(XMLElement.newContent("value", settings.getValue()));
    }
}

