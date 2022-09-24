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
import eve.entity.pk.CategoryPK;
import eve.interfaces.entity.pk.ICategoryPK;
import eve.logicentity.Category;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLCategory {
    
    public static void addXML(Element PK, ICategoryPK categoryPK) {
        PK.addContent(XMLElement.newContent("id", categoryPK.getId()));
    }

    public static void addXML(Element CategoryXML, Category category) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, category.getPrimaryKey());
        CategoryXML.addContent(PK);
        CategoryXML.addContent(XMLElement.newContent("name", category.getName()));
        CategoryXML.addContent(XMLElement.newContent("published", category.getPublished()));
    }
}

