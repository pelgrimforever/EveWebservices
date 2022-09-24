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
import eve.entity.pk.Allnodes_systemPK;
import eve.interfaces.entity.pk.IAllnodes_systemPK;
import eve.logicentity.Allnodes_system;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLAllnodes_system {
    
    public static void addXML(Element PK, IAllnodes_systemPK allnodes_systemPK) {
        PK.addContent(XMLElement.newContent("id", allnodes_systemPK.getId()));
    }

    public static void addXML(Element Allnodes_systemXML, Allnodes_system allnodes_system) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, allnodes_system.getPrimaryKey());
        Allnodes_systemXML.addContent(PK);
        Allnodes_systemXML.addContent(XMLElement.newContent("deadend", allnodes_system.getDeadend()));
    }
}

