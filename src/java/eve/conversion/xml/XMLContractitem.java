/*
 * XMLContractitem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 2.0.2022 18:23
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
import eve.entity.pk.ContractitemPK;
import eve.interfaces.entity.pk.IContractitemPK;
import eve.logicentity.Contractitem;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLContractitem {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IContractitemPK contractitemPK) {
        PK.addContent(XMLElement.newContent("id", contractitemPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element ContractitemXML, Contractitem contractitem) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, contractitem.getPrimaryKey());
        ContractitemXML.addContent(PK);
        if(contractitem.getEvetypePK()!=null) {
            Element evetypePK = XMLElement.newContent("evetypePK", "");
            XMLEvetype.addXML(evetypePK, contractitem.getEvetypePK());
            ContractitemXML.addContent(evetypePK);
        }
        if(contractitem.getContractPK()!=null) {
            Element contractPK = XMLElement.newContent("contractPK", "");
            XMLContract.addXML(contractPK, contractitem.getContractPK());
            ContractitemXML.addContent(contractPK);
        }
        ContractitemXML.addContent(XMLElement.newContent("blueprint_copy", contractitem.getBlueprint_copy()));
        ContractitemXML.addContent(XMLElement.newContent("included", contractitem.getIncluded()));
        ContractitemXML.addContent(XMLElement.newContent("quantity", contractitem.getQuantity()));
        ContractitemXML.addContent(XMLElement.newContent("material_efficiency", contractitem.getMaterial_efficiency()));
        ContractitemXML.addContent(XMLElement.newContent("runs", contractitem.getRuns()));
        ContractitemXML.addContent(XMLElement.newContent("time_efficiency", contractitem.getTime_efficiency()));
    }
}

