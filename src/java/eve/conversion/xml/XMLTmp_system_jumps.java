/*
 * XMLTmp_system_jumps.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:40
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
import eve.entity.pk.Tmp_system_jumpsPK;
import eve.interfaces.entity.pk.ITmp_system_jumpsPK;
import eve.logicentity.Tmp_system_jumps;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLTmp_system_jumps {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ITmp_system_jumpsPK tmp_system_jumpsPK) {
        PK.addContent(XMLElement.newContent("system", tmp_system_jumpsPK.getSystem()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Tmp_system_jumpsXML, Tmp_system_jumps tmp_system_jumps) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, tmp_system_jumps.getPrimaryKey());
        Tmp_system_jumpsXML.addContent(PK);
        Tmp_system_jumpsXML.addContent(XMLElement.newContent("jump", tmp_system_jumps.getJump()));
        Tmp_system_jumpsXML.addContent(XMLElement.newContent("maxjumps", tmp_system_jumps.getMaxjumps()));
        Tmp_system_jumpsXML.addContent(XMLElement.newContent("previoussystem", tmp_system_jumps.getPrevioussystem()));
    }
}

