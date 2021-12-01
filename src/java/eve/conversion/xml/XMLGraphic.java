/*
 * XMLGraphic.java
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
import eve.entity.pk.GraphicPK;
import eve.interfaces.entity.pk.IGraphicPK;
import eve.logicentity.Graphic;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLGraphic {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IGraphicPK graphicPK) {
        PK.addContent(XMLElement.newContent("id", graphicPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element GraphicXML, Graphic graphic) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, graphic.getPrimaryKey());
        GraphicXML.addContent(PK);
        GraphicXML.addContent(XMLElement.newContent("collision_file", graphic.getCollision_file()));
        GraphicXML.addContent(XMLElement.newContent("graphic_file", graphic.getGraphic_file()));
        GraphicXML.addContent(XMLElement.newContent("icon_folder", graphic.getIcon_folder()));
        GraphicXML.addContent(XMLElement.newContent("sof_dna", graphic.getSof_dna()));
        GraphicXML.addContent(XMLElement.newContent("sof_fation_name", graphic.getSof_fation_name()));
        GraphicXML.addContent(XMLElement.newContent("sof_hull_name", graphic.getSof_hull_name()));
        GraphicXML.addContent(XMLElement.newContent("sof_race_name", graphic.getSof_race_name()));
    }
}

