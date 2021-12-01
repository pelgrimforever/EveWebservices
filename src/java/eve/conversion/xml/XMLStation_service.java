/*
 * XMLStation_service.java
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
import eve.entity.pk.Station_servicePK;
import eve.interfaces.entity.pk.IStation_servicePK;
import eve.logicentity.Station_service;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLStation_service {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IStation_servicePK station_servicePK) {
        PK.addContent(XMLElement.newContent("station", station_servicePK.getStation()));
        PK.addContent(XMLElement.newContent("service", station_servicePK.getService()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Station_serviceXML, Station_service station_service) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, station_service.getPrimaryKey());
        Station_serviceXML.addContent(PK);
    }
}

