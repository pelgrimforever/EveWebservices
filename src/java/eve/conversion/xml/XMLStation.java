/*
 * XMLStation.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2021 15:16
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
import eve.entity.pk.StationPK;
import eve.interfaces.entity.pk.IStationPK;
import eve.logicentity.Station;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLStation {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IStationPK stationPK) {
        PK.addContent(XMLElement.newContent("id", stationPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element StationXML, Station station) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, station.getPrimaryKey());
        StationXML.addContent(PK);
        if(station.getRacePK()!=null) {
            Element racePK = XMLElement.newContent("racePK", "");
            XMLRace.addXML(racePK, station.getRacePK());
            StationXML.addContent(racePK);
        }
        if(station.getEvetypePK()!=null) {
            Element evetypePK = XMLElement.newContent("evetypePK", "");
            XMLEvetype.addXML(evetypePK, station.getEvetypePK());
            StationXML.addContent(evetypePK);
        }
        if(station.getSystemPK()!=null) {
            Element systemPK = XMLElement.newContent("systemPK", "");
            XMLSystem.addXML(systemPK, station.getSystemPK());
            StationXML.addContent(systemPK);
        }
        StationXML.addContent(XMLElement.newContent("name", station.getName()));
        StationXML.addContent(XMLElement.newContent("office_rental_cost", station.getOffice_rental_cost()));
        StationXML.addContent(XMLElement.newContent("reprocessing_efficiency", station.getReprocessing_efficiency()));
        StationXML.addContent(XMLElement.newContent("reprocessing_stations_take", station.getReprocessing_stations_take()));
        StationXML.addContent(XMLElement.newContent("max_dockable_ship_volume", station.getMax_dockable_ship_volume()));
        StationXML.addContent(XMLElement.newContent("owner", station.getOwner()));
    }
}

