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
import eve.entity.pk.FrontendpagePK;
import eve.interfaces.entity.pk.IFrontendpagePK;
import eve.logicentity.Frontendpage;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLFrontendpage {
    
    public static void addXML(Element PK, IFrontendpagePK frontendpagePK) {
        PK.addContent(XMLElement.newContent("name", frontendpagePK.getName()));
    }

    public static void addXML(Element FrontendpageXML, Frontendpage frontendpage) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, frontendpage.getPrimaryKey());
        FrontendpageXML.addContent(PK);
    }
}

