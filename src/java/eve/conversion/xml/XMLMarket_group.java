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
import eve.entity.pk.Market_groupPK;
import eve.interfaces.entity.pk.IMarket_groupPK;
import eve.logicentity.Market_group;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLMarket_group {
    
    public static void addXML(Element PK, IMarket_groupPK market_groupPK) {
        PK.addContent(XMLElement.newContent("id", market_groupPK.getId()));
    }

    public static void addXML(Element Market_groupXML, Market_group market_group) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, market_group.getPrimaryKey());
        Market_groupXML.addContent(PK);
        if(market_group.getMarket_groupparent_idPK()!=null) {
            Element market_groupParent_idPK = XMLElement.newContent("market_groupParent_idPK", "");
            XMLMarket_group.addXML(market_groupParent_idPK, market_group.getMarket_groupparent_idPK());
            Market_groupXML.addContent(market_groupParent_idPK);
        }
        Market_groupXML.addContent(XMLElement.newContent("name", market_group.getName()));
        Market_groupXML.addContent(XMLElement.newContent("description", market_group.getDescription()));
    }
}

