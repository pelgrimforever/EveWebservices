/*
 * XMLAllnodes_stargate.java
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
import eve.entity.pk.Allnodes_stargatePK;
import eve.interfaces.entity.pk.IAllnodes_stargatePK;
import eve.logicentity.Allnodes_stargate;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLAllnodes_stargate {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IAllnodes_stargatePK allnodes_stargatePK) {
        PK.addContent(XMLElement.newContent("id", allnodes_stargatePK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Allnodes_stargateXML, Allnodes_stargate allnodes_stargate) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, allnodes_stargate.getPrimaryKey());
        Allnodes_stargateXML.addContent(PK);
        Allnodes_stargateXML.addContent(XMLElement.newContent("to_stargate", allnodes_stargate.getTo_stargate()));
        Allnodes_stargateXML.addContent(XMLElement.newContent("system", allnodes_stargate.getSystem()));
        Allnodes_stargateXML.addContent(XMLElement.newContent("to_system", allnodes_stargate.getTo_system()));
        Allnodes_stargateXML.addContent(XMLElement.newContent("deadend", allnodes_stargate.getDeadend()));
    }
}

