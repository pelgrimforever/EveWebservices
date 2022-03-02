/*
 * XMLFrontendpage.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.1.2022 17:48
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
import eve.entity.pk.FrontendpagePK;
import eve.interfaces.entity.pk.IFrontendpagePK;
import eve.logicentity.Frontendpage;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLFrontendpage {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IFrontendpagePK frontendpagePK) {
        PK.addContent(XMLElement.newContent("name", frontendpagePK.getName()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element FrontendpageXML, Frontendpage frontendpage) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, frontendpage.getPrimaryKey());
        FrontendpageXML.addContent(PK);
    }
}

