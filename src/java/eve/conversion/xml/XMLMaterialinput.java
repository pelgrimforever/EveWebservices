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
import eve.entity.pk.MaterialinputPK;
import eve.interfaces.entity.pk.IMaterialinputPK;
import eve.logicentity.Materialinput;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLMaterialinput {
    
    public static void addXML(Element PK, IMaterialinputPK materialinputPK) {
        PK.addContent(XMLElement.newContent("username", materialinputPK.getUsername()));
        PK.addContent(XMLElement.newContent("evetype", materialinputPK.getEvetype()));
        if(materialinputPK.getAddtimestamp()!=null) {
          PK.addContent(XMLElement.newContent("addtimestamp", materialinputPK.getAddtimestamp().getTime()));
        }
    }

    public static void addXML(Element MaterialinputXML, Materialinput materialinput) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, materialinput.getPrimaryKey());
        MaterialinputXML.addContent(PK);
        MaterialinputXML.addContent(XMLElement.newContent("amount", materialinput.getAmount()));
        MaterialinputXML.addContent(XMLElement.newContent("unitprice", materialinput.getUnitprice()));
        MaterialinputXML.addContent(XMLElement.newContent("usedamount", materialinput.getUsedamount()));
    }
}

