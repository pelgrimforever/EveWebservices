/*
 * XMLCategory.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 16.11.2021 15:46
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
import eve.entity.pk.CategoryPK;
import eve.interfaces.entity.pk.ICategoryPK;
import eve.logicentity.Category;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLCategory {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ICategoryPK categoryPK) {
        PK.addContent(XMLElement.newContent("id", categoryPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element CategoryXML, Category category) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, category.getPrimaryKey());
        CategoryXML.addContent(PK);
        CategoryXML.addContent(XMLElement.newContent("name", category.getName()));
        CategoryXML.addContent(XMLElement.newContent("published", category.getPublished()));
    }
}

