/*
 * XMLStock.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 8.10.2021 7:21
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
import eve.entity.pk.StockPK;
import eve.interfaces.entity.pk.IStockPK;
import eve.logicentity.Stock;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLStock {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IStockPK stockPK) {
        PK.addContent(XMLElement.newContent("username", stockPK.getUsername()));
        PK.addContent(XMLElement.newContent("evetype", stockPK.getEvetype()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element StockXML, Stock stock) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, stock.getPrimaryKey());
        StockXML.addContent(PK);
        StockXML.addContent(XMLElement.newContent("amount", stock.getAmount()));
    }
}

