/*
 * XMLUsersettings.java
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
import eve.entity.pk.UsersettingsPK;
import eve.interfaces.entity.pk.IUsersettingsPK;
import eve.logicentity.Usersettings;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLUsersettings {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IUsersettingsPK usersettingsPK) {
        PK.addContent(XMLElement.newContent("username", usersettingsPK.getUsername()));
        PK.addContent(XMLElement.newContent("name", usersettingsPK.getName()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element UsersettingsXML, Usersettings usersettings) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, usersettings.getPrimaryKey());
        UsersettingsXML.addContent(PK);
        UsersettingsXML.addContent(XMLElement.newContent("value", usersettings.getValue()));
    }
}

