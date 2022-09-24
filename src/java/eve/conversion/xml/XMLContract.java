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
import eve.entity.pk.ContractPK;
import eve.interfaces.entity.pk.IContractPK;
import eve.logicentity.Contract;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLContract {
    
    public static void addXML(Element PK, IContractPK contractPK) {
        PK.addContent(XMLElement.newContent("id", contractPK.getId()));
    }

    public static void addXML(Element ContractXML, Contract contract) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, contract.getPrimaryKey());
        ContractXML.addContent(PK);
        ContractXML.addContent(XMLElement.newContent("collateral", contract.getCollateral()));
        if(contract.getDate_expired()!=null) {
            ContractXML.addContent(XMLElement.newContent("date_expired", contract.getDate_expired().toString()));
        }
        if(contract.getDate_issued()!=null) {
            ContractXML.addContent(XMLElement.newContent("date_issued", contract.getDate_issued().toString()));
        }
        ContractXML.addContent(XMLElement.newContent("days_to_complete", contract.getDays_to_complete()));
        ContractXML.addContent(XMLElement.newContent("end_location_id", contract.getEnd_location_id()));
        ContractXML.addContent(XMLElement.newContent("for_corporation", contract.getFor_corporation()));
        ContractXML.addContent(XMLElement.newContent("price", contract.getPrice()));
        ContractXML.addContent(XMLElement.newContent("reward", contract.getReward()));
        ContractXML.addContent(XMLElement.newContent("start_location_id", contract.getStart_location_id()));
        ContractXML.addContent(XMLElement.newContent("title", contract.getTitle()));
        ContractXML.addContent(XMLElement.newContent("type", contract.getType()));
        ContractXML.addContent(XMLElement.newContent("volume", contract.getVolume()));
        ContractXML.addContent(XMLElement.newContent("page", contract.getPage()));
        ContractXML.addContent(XMLElement.newContent("active", contract.getActive()));
    }
}

