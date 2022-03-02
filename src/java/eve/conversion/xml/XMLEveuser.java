/*
 * XMLEveuser.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.1.2022 20:54
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
import eve.entity.pk.EveuserPK;
import eve.interfaces.entity.pk.IEveuserPK;
import eve.logicentity.Eveuser;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLEveuser {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IEveuserPK eveuserPK) {
        PK.addContent(XMLElement.newContent("username", eveuserPK.getUsername()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
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

