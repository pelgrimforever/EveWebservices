/*
 * XMLSystemtrade.java
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
import eve.entity.pk.SystemtradePK;
import eve.interfaces.entity.pk.ISystemtradePK;
import eve.logicentity.Systemtrade;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLSystemtrade {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ISystemtradePK systemtradePK) {
        PK.addContent(XMLElement.newContent("sell_system", systemtradePK.getSell_system()));
        PK.addContent(XMLElement.newContent("buy_system", systemtradePK.getBuy_system()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element SystemtradeXML, Systemtrade systemtrade) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, systemtrade.getPrimaryKey());
        SystemtradeXML.addContent(PK);
        SystemtradeXML.addContent(XMLElement.newContent("profit", systemtrade.getProfit()));
        SystemtradeXML.addContent(XMLElement.newContent("total_cargo_volume", systemtrade.getTotal_cargo_volume()));
        SystemtradeXML.addContent(XMLElement.newContent("jumps", systemtrade.getJumps()));
    }
}

