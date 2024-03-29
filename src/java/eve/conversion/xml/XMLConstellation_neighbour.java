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
import eve.entity.pk.Constellation_neighbourPK;
import eve.interfaces.entity.pk.IConstellation_neighbourPK;
import eve.logicentity.Constellation_neighbour;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLConstellation_neighbour {
    
    public static void addXML(Element PK, IConstellation_neighbourPK constellation_neighbourPK) {
        PK.addContent(XMLElement.newContent("constellation", constellation_neighbourPK.getConstellation()));
        PK.addContent(XMLElement.newContent("neighbour", constellation_neighbourPK.getNeighbour()));
    }

    public static void addXML(Element Constellation_neighbourXML, Constellation_neighbour constellation_neighbour) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, constellation_neighbour.getPrimaryKey());
        Constellation_neighbourXML.addContent(PK);
    }
}

