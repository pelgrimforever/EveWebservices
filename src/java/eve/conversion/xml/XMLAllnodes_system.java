/*
 * XMLAllnodes_system.java
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
import eve.entity.pk.Allnodes_systemPK;
import eve.interfaces.entity.pk.IAllnodes_systemPK;
import eve.logicentity.Allnodes_system;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLAllnodes_system {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IAllnodes_systemPK allnodes_systemPK) {
        PK.addContent(XMLElement.newContent("id", allnodes_systemPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Allnodes_systemXML, Allnodes_system allnodes_system) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, allnodes_system.getPrimaryKey());
        Allnodes_systemXML.addContent(PK);
        Allnodes_systemXML.addContent(XMLElement.newContent("deadend", allnodes_system.getDeadend()));
    }
}

