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
import eve.entity.pk.Frontendpage_authPK;
import eve.interfaces.entity.pk.IFrontendpage_authPK;
import eve.logicentity.Frontendpage_auth;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLFrontendpage_auth {
    
    public static void addXML(Element PK, IFrontendpage_authPK frontendpage_authPK) {
        PK.addContent(XMLElement.newContent("username", frontendpage_authPK.getUsername()));
        PK.addContent(XMLElement.newContent("frontendpage", frontendpage_authPK.getFrontendpage()));
    }

    public static void addXML(Element Frontendpage_authXML, Frontendpage_auth frontendpage_auth) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, frontendpage_auth.getPrimaryKey());
        Frontendpage_authXML.addContent(PK);
    }
}

