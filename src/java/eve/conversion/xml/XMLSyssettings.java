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
import eve.entity.pk.SyssettingsPK;
import eve.interfaces.entity.pk.ISyssettingsPK;
import eve.logicentity.Syssettings;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLSyssettings {
    
    public static void addXML(Element PK, ISyssettingsPK syssettingsPK) {
        PK.addContent(XMLElement.newContent("name", syssettingsPK.getName()));
    }

    public static void addXML(Element SyssettingsXML, Syssettings syssettings) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, syssettings.getPrimaryKey());
        SyssettingsXML.addContent(PK);
        SyssettingsXML.addContent(XMLElement.newContent("value", syssettings.getValue()));
    }
}

