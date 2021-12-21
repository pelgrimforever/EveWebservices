/*
 * XMLEvetype.java
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
import eve.entity.pk.EvetypePK;
import eve.interfaces.entity.pk.IEvetypePK;
import eve.logicentity.Evetype;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLEvetype {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IEvetypePK evetypePK) {
        PK.addContent(XMLElement.newContent("id", evetypePK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element EvetypeXML, Evetype evetype) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, evetype.getPrimaryKey());
        EvetypeXML.addContent(PK);
        if(evetype.getMarket_groupPK()!=null) {
            Element market_groupPK = XMLElement.newContent("market_groupPK", "");
            XMLMarket_group.addXML(market_groupPK, evetype.getMarket_groupPK());
            EvetypeXML.addContent(market_groupPK);
        }
        if(evetype.getTypegroupPK()!=null) {
            Element typegroupPK = XMLElement.newContent("typegroupPK", "");
            XMLTypegroup.addXML(typegroupPK, evetype.getTypegroupPK());
            EvetypeXML.addContent(typegroupPK);
        }
        if(evetype.getGraphicPK()!=null) {
            Element graphicPK = XMLElement.newContent("graphicPK", "");
            XMLGraphic.addXML(graphicPK, evetype.getGraphicPK());
            EvetypeXML.addContent(graphicPK);
        }
        EvetypeXML.addContent(XMLElement.newContent("name", evetype.getName()));
        EvetypeXML.addContent(XMLElement.newContent("published", evetype.getPublished()));
        EvetypeXML.addContent(XMLElement.newContent("description", evetype.getDescription()));
        EvetypeXML.addContent(XMLElement.newContent("capacity", evetype.getCapacity()));
        EvetypeXML.addContent(XMLElement.newContent("icon", evetype.getIcon()));
        EvetypeXML.addContent(XMLElement.newContent("mass", evetype.getMass()));
        EvetypeXML.addContent(XMLElement.newContent("packaged_volume", evetype.getPackaged_volume()));
        EvetypeXML.addContent(XMLElement.newContent("portion_size", evetype.getPortion_size()));
        EvetypeXML.addContent(XMLElement.newContent("radius", evetype.getRadius()));
        EvetypeXML.addContent(XMLElement.newContent("volume", evetype.getVolume()));
        EvetypeXML.addContent(XMLElement.newContent("avg_buyorder", evetype.getAvg_buyorder()));
        EvetypeXML.addContent(XMLElement.newContent("avg_sellorder", evetype.getAvg_sellorder()));
        EvetypeXML.addContent(XMLElement.newContent("min_buyorder", evetype.getMin_buyorder()));
        EvetypeXML.addContent(XMLElement.newContent("max_buyorder", evetype.getMax_buyorder()));
        EvetypeXML.addContent(XMLElement.newContent("min_selorder", evetype.getMin_selorder()));
        EvetypeXML.addContent(XMLElement.newContent("max_selorder", evetype.getMax_selorder()));
    }
}

