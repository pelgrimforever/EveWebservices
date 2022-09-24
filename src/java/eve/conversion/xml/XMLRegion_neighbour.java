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
import eve.entity.pk.Region_neighbourPK;
import eve.interfaces.entity.pk.IRegion_neighbourPK;
import eve.logicentity.Region_neighbour;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLRegion_neighbour {
    
    public static void addXML(Element PK, IRegion_neighbourPK region_neighbourPK) {
        PK.addContent(XMLElement.newContent("region", region_neighbourPK.getRegion()));
        PK.addContent(XMLElement.newContent("neighbour", region_neighbourPK.getNeighbour()));
    }

    public static void addXML(Element Region_neighbourXML, Region_neighbour region_neighbour) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, region_neighbour.getPrimaryKey());
        Region_neighbourXML.addContent(PK);
    }
}

