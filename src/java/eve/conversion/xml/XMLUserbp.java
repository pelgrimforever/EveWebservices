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
import eve.entity.pk.UserbpPK;
import eve.interfaces.entity.pk.IUserbpPK;
import eve.logicentity.Userbp;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLUserbp {
    
    public static void addXML(Element PK, IUserbpPK userbpPK) {
        PK.addContent(XMLElement.newContent("username", userbpPK.getUsername()));
        PK.addContent(XMLElement.newContent("bp", userbpPK.getBp()));
        PK.addContent(XMLElement.newContent("serialnumber", userbpPK.getSerialnumber()));
    }

    public static void addXML(Element UserbpXML, Userbp userbp) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, userbp.getPrimaryKey());
        UserbpXML.addContent(PK);
        UserbpXML.addContent(XMLElement.newContent("original", userbp.getOriginal()));
        UserbpXML.addContent(XMLElement.newContent("materialefficiency", userbp.getMaterialefficiency()));
        UserbpXML.addContent(XMLElement.newContent("amountproduced", userbp.getAmountproduced()));
        UserbpXML.addContent(XMLElement.newContent("totalamount", userbp.getTotalamount()));
        UserbpXML.addContent(XMLElement.newContent("bpprice", userbp.getBpprice()));
        UserbpXML.addContent(XMLElement.newContent("researchcost", userbp.getResearchcost()));
        UserbpXML.addContent(XMLElement.newContent("stationfee", userbp.getStationfee()));
    }
}

