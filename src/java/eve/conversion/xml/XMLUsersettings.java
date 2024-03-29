/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
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

public class XMLUsersettings {
    
    public static void addXML(Element PK, IUsersettingsPK usersettingsPK) {
        PK.addContent(XMLElement.newContent("username", usersettingsPK.getUsername()));
        PK.addContent(XMLElement.newContent("name", usersettingsPK.getName()));
    }

    public static void addXML(Element UsersettingsXML, Usersettings usersettings) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, usersettings.getPrimaryKey());
        UsersettingsXML.addContent(PK);
        UsersettingsXML.addContent(XMLElement.newContent("value", usersettings.getValue()));
    }
}

