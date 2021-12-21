/*
 * XMLShipfit.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.11.2021 15:34
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
import eve.entity.pk.ShipfitPK;
import eve.interfaces.entity.pk.IShipfitPK;
import eve.logicentity.Shipfit;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLShipfit {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IShipfitPK shipfitPK) {
        PK.addContent(XMLElement.newContent("username", shipfitPK.getUsername()));
        PK.addContent(XMLElement.newContent("shipname", shipfitPK.getShipname()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element ShipfitXML, Shipfit shipfit) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, shipfit.getPrimaryKey());
        ShipfitXML.addContent(PK);
        if(shipfit.getEvetypePK()!=null) {
            Element evetypePK = XMLElement.newContent("evetypePK", "");
            XMLEvetype.addXML(evetypePK, shipfit.getEvetypePK());
            ShipfitXML.addContent(evetypePK);
        }
    }
}

