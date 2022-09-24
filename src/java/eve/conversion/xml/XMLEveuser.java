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
import eve.entity.pk.EveuserPK;
import eve.interfaces.entity.pk.IEveuserPK;
import eve.logicentity.Eveuser;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLEveuser {
    
    public static void addXML(Element PK, IEveuserPK eveuserPK) {
        PK.addContent(XMLElement.newContent("username", eveuserPK.getUsername()));
    }

    public static void addXML(Element EveuserXML, Eveuser eveuser) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, eveuser.getPrimaryKey());
        EveuserXML.addContent(PK);
        if(eveuser.getCreatedat()!=null) {
            EveuserXML.addContent(XMLElement.newContent("createdat", eveuser.getCreatedat().getTime()));
        }
        EveuserXML.addContent(XMLElement.newContent("admin", eveuser.getAdmin()));
    }
}

