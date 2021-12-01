/*
 * XMLTypegroup.java
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
import eve.entity.pk.TypegroupPK;
import eve.interfaces.entity.pk.ITypegroupPK;
import eve.logicentity.Typegroup;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLTypegroup {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ITypegroupPK typegroupPK) {
        PK.addContent(XMLElement.newContent("id", typegroupPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element TypegroupXML, Typegroup typegroup) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, typegroup.getPrimaryKey());
        TypegroupXML.addContent(PK);
        if(typegroup.getCategoryPK()!=null) {
            Element categoryPK = XMLElement.newContent("categoryPK", "");
            XMLCategory.addXML(categoryPK, typegroup.getCategoryPK());
            TypegroupXML.addContent(categoryPK);
        }
        TypegroupXML.addContent(XMLElement.newContent("name", typegroup.getName()));
        TypegroupXML.addContent(XMLElement.newContent("published", typegroup.getPublished()));
    }
}

