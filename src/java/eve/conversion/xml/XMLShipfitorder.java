/*
 * XMLShipfitorder.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 19.11.2021 16:16
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
import eve.entity.pk.ShipfitorderPK;
import eve.interfaces.entity.pk.IShipfitorderPK;
import eve.logicentity.Shipfitorder;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLShipfitorder {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IShipfitorderPK shipfitorderPK) {
        PK.addContent(XMLElement.newContent("username", shipfitorderPK.getUsername()));
        PK.addContent(XMLElement.newContent("shipname", shipfitorderPK.getShipname()));
        PK.addContent(XMLElement.newContent("evetype", shipfitorderPK.getEvetype()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element ShipfitorderXML, Shipfitorder shipfitorder) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, shipfitorder.getPrimaryKey());
        ShipfitorderXML.addContent(PK);
        ShipfitorderXML.addContent(XMLElement.newContent("amountwanted", shipfitorder.getAmountwanted()));
        ShipfitorderXML.addContent(XMLElement.newContent("amountinstock", shipfitorder.getAmountinstock()));
    }
}

