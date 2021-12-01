/*
 * XMLRegion.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 30.10.2021 10:3
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
import eve.entity.pk.RegionPK;
import eve.interfaces.entity.pk.IRegionPK;
import eve.logicentity.Region;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLRegion {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IRegionPK regionPK) {
        PK.addContent(XMLElement.newContent("id", regionPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element RegionXML, Region region) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, region.getPrimaryKey());
        RegionXML.addContent(PK);
        RegionXML.addContent(XMLElement.newContent("name", region.getName()));
        RegionXML.addContent(XMLElement.newContent("noaccess", region.getNoaccess()));
        RegionXML.addContent(XMLElement.newContent("orderpages", region.getOrderpages()));
        RegionXML.addContent(XMLElement.newContent("ordererrors", region.getOrdererrors()));
    }
}

