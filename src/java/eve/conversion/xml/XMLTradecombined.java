/*
 * XMLTradecombined.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.11.2021 14:30
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
import eve.entity.pk.TradecombinedPK;
import eve.interfaces.entity.pk.ITradecombinedPK;
import eve.logicentity.Tradecombined;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLTradecombined {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ITradecombinedPK tradecombinedPK) {
        PK.addContent(XMLElement.newContent("sell_system", tradecombinedPK.getSell_system()));
        PK.addContent(XMLElement.newContent("buy_system", tradecombinedPK.getBuy_system()));
        PK.addContent(XMLElement.newContent("evetype", tradecombinedPK.getEvetype()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element TradecombinedXML, Tradecombined tradecombined) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, tradecombined.getPrimaryKey());
        TradecombinedXML.addContent(PK);
        TradecombinedXML.addContent(XMLElement.newContent("jumps", tradecombined.getJumps()));
        TradecombinedXML.addContent(XMLElement.newContent("jumpslowsec", tradecombined.getJumpslowsec()));
        TradecombinedXML.addContent(XMLElement.newContent("jumpsnullsec", tradecombined.getJumpsnullsec()));
    }
}

