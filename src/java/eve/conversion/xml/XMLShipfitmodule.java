/*
 * XMLShipfitmodule.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.5.2022 8:27
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
import eve.entity.pk.ShipfitmodulePK;
import eve.interfaces.entity.pk.IShipfitmodulePK;
import eve.logicentity.Shipfitmodule;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLShipfitmodule {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IShipfitmodulePK shipfitmodulePK) {
        PK.addContent(XMLElement.newContent("username", shipfitmodulePK.getUsername()));
        PK.addContent(XMLElement.newContent("shipname", shipfitmodulePK.getShipname()));
        PK.addContent(XMLElement.newContent("moduletype", shipfitmodulePK.getModuletype()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element ShipfitmoduleXML, Shipfitmodule shipfitmodule) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, shipfitmodule.getPrimaryKey());
        ShipfitmoduleXML.addContent(PK);
        ShipfitmoduleXML.addContent(XMLElement.newContent("amount", shipfitmodule.getAmount()));
    }
}

