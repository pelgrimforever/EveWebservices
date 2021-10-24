/*
 * XMLStocktrade.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:40
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
import eve.entity.pk.StocktradePK;
import eve.interfaces.entity.pk.IStocktradePK;
import eve.logicentity.Stocktrade;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLStocktrade {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IStocktradePK stocktradePK) {
        PK.addContent(XMLElement.newContent("username", stocktradePK.getUsername()));
        PK.addContent(XMLElement.newContent("evetype", stocktradePK.getEvetype()));
        PK.addContent(XMLElement.newContent("orderid", stocktradePK.getOrderid()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element StocktradeXML, Stocktrade stocktrade) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, stocktrade.getPrimaryKey());
        StocktradeXML.addContent(PK);
        StocktradeXML.addContent(XMLElement.newContent("sellamount", stocktrade.getSellamount()));
    }
}

