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
import eve.entity.pk.ShipfitorderselectedPK;
import eve.interfaces.entity.pk.IShipfitorderselectedPK;
import eve.logicentity.Shipfitorderselected;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLShipfitorderselected {
    
    public static void addXML(Element PK, IShipfitorderselectedPK shipfitorderselectedPK) {
        PK.addContent(XMLElement.newContent("username", shipfitorderselectedPK.getUsername()));
        PK.addContent(XMLElement.newContent("shipname", shipfitorderselectedPK.getShipname()));
        PK.addContent(XMLElement.newContent("evetype", shipfitorderselectedPK.getEvetype()));
        PK.addContent(XMLElement.newContent("orderid", shipfitorderselectedPK.getOrderid()));
    }

    public static void addXML(Element ShipfitorderselectedXML, Shipfitorderselected shipfitorderselected) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, shipfitorderselected.getPrimaryKey());
        ShipfitorderselectedXML.addContent(PK);
        ShipfitorderselectedXML.addContent(XMLElement.newContent("amount", shipfitorderselected.getAmount()));
    }
}

