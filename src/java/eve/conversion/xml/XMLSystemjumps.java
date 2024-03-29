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
import eve.entity.pk.SystemjumpsPK;
import eve.interfaces.entity.pk.ISystemjumpsPK;
import eve.logicentity.Systemjumps;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLSystemjumps {
    
    public static void addXML(Element PK, ISystemjumpsPK systemjumpsPK) {
        PK.addContent(XMLElement.newContent("system_start", systemjumpsPK.getSystem_start()));
        PK.addContent(XMLElement.newContent("system_end", systemjumpsPK.getSystem_end()));
    }

    public static void addXML(Element SystemjumpsXML, Systemjumps systemjumps) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, systemjumps.getPrimaryKey());
        SystemjumpsXML.addContent(PK);
        SystemjumpsXML.addContent(XMLElement.newContent("jumps", systemjumps.getJumps()));
        SystemjumpsXML.addContent(XMLElement.newContent("jumpslowsec", systemjumps.getJumpslowsec()));
        SystemjumpsXML.addContent(XMLElement.newContent("jumpsnullsec", systemjumps.getJumpsnullsec()));
        SystemjumpsXML.addContent(XMLElement.newContent("jumpssafe", systemjumps.getJumpssafe()));
        SystemjumpsXML.addContent(XMLElement.newContent("jumpssafelowsec", systemjumps.getJumpssafelowsec()));
        SystemjumpsXML.addContent(XMLElement.newContent("jumpssafenullsec", systemjumps.getJumpssafenullsec()));
    }
}

