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
import eve.entity.pk.BpmaterialPK;
import eve.interfaces.entity.pk.IBpmaterialPK;
import eve.logicentity.Bpmaterial;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLBpmaterial {
    
    public static void addXML(Element PK, IBpmaterialPK bpmaterialPK) {
        PK.addContent(XMLElement.newContent("bp", bpmaterialPK.getBp()));
        PK.addContent(XMLElement.newContent("material", bpmaterialPK.getMaterial()));
    }

    public static void addXML(Element BpmaterialXML, Bpmaterial bpmaterial) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, bpmaterial.getPrimaryKey());
        BpmaterialXML.addContent(PK);
        BpmaterialXML.addContent(XMLElement.newContent("amount", bpmaterial.getAmount()));
    }
}

