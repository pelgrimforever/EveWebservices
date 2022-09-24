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
import eve.entity.pk.RacePK;
import eve.interfaces.entity.pk.IRacePK;
import eve.logicentity.Race;
import eve.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLRace {
    
    public static void addXML(Element PK, IRacePK racePK) {
        PK.addContent(XMLElement.newContent("id", racePK.getId()));
    }

    public static void addXML(Element RaceXML, Race race) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, race.getPrimaryKey());
        RaceXML.addContent(PK);
        if(race.getFactionPK()!=null) {
            Element factionPK = XMLElement.newContent("factionPK", "");
            XMLFaction.addXML(factionPK, race.getFactionPK());
            RaceXML.addContent(factionPK);
        }
        RaceXML.addContent(XMLElement.newContent("name", race.getName()));
        RaceXML.addContent(XMLElement.newContent("description", race.getDescription()));
    }
}

