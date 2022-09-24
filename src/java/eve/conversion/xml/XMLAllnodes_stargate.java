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
import eve.entity.pk.Allnodes_stargatePK;
import eve.interfaces.entity.pk.IAllnodes_stargatePK;
import eve.logicentity.Allnodes_stargate;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLAllnodes_stargate {
    
    public static void addXML(Element PK, IAllnodes_stargatePK allnodes_stargatePK) {
        PK.addContent(XMLElement.newContent("id", allnodes_stargatePK.getId()));
    }

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

