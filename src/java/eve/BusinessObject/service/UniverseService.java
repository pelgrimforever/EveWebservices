package eve.BusinessObject.service;

import db.SQLTwriter;
import data.conversion.JSONConversion;
import db.SQLToutput;
import db.SQLTqueue;
import db.SQLreader;
import eve.BusinessObject.Logic.BLalliance;
import eve.BusinessObject.Logic.BLconstellation;
import eve.BusinessObject.Logic.BLconstellation_neighbour;
import eve.BusinessObject.Logic.BLcorporation;
import eve.BusinessObject.Logic.BLfaction;
import eve.BusinessObject.Logic.BLgraphic;
import eve.BusinessObject.Logic.BLrace;
import eve.BusinessObject.Logic.BLregion;
import eve.BusinessObject.Logic.BLregion_neighbour;
import eve.BusinessObject.Logic.BLsecurity_island;
import eve.BusinessObject.Logic.BLstargate;
import eve.BusinessObject.Logic.BLstation;
import eve.BusinessObject.Logic.BLstation_service;
import eve.BusinessObject.Logic.BLsystem;
import eve.BusinessObject.Logic.BLsystemjumps;
import eve.data.Swagger;
import eve.entity.pk.AlliancePK;
import eve.entity.pk.ConstellationPK;
import eve.entity.pk.CorporationPK;
import eve.entity.pk.FactionPK;
import eve.entity.pk.GraphicPK;
import eve.entity.pk.RacePK;
import eve.entity.pk.StargatePK;
import eve.entity.pk.StationPK;
import eve.entity.pk.SystemPK;
import eve.logicentity.Alliance;
import eve.logicentity.Constellation;
import eve.logicentity.Corporation;
import eve.logicentity.Race;
import eve.logicentity.Region;
import eve.logicentity.Security_island;
import general.exception.CustomException;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class UniverseService implements Runnable {
    
    private UniverseStatus universestatus;
    private boolean keeprunning = true;
    
    public void stoprunning() {
        this.keeprunning = false;
    }
    
    public UniverseStatus getStatus() {
        return universestatus;
    }
    
    public class UniverseStatus {
        private long graphics = 0;
        private long totalgraphics = 1;
        private long races = 0;
        private long totalraces = 1;
        private long constellations = 0;
        private long totalconstellations = 1;
        private long systems = 0;
        private long totalsystems = 1;
        private long stations = 0;
        private long totalstations = 1;
        private long stargates = 0;
        private long totalstargates = 1;
        private long corporations = 0;
        private long totalcorporations = 1;
        private long alliances = 0;
        private long totalalliances = 1;
        
        private ArrayList<String> messages = new ArrayList<>();
        private boolean done = false;
        
        public UniverseStatus() {
        }
        
        public void setDone() {
            this.done = true;
        }

        public long getGraphics() {
            return graphics;
        }

        public void incGraphics() {
            this.graphics++;
        }

        public long getConstellations() {
            return constellations;
        }
        
        public void incConstellations() {
            this.constellations++;
        }
        
        public long getSystems() {
            return systems;
        }

        public void incSystems() {
            this.systems++;
        }

        public long getRaces() {
            return races;
        }

        public void incRaces() {
            this.races++;
        }

        public long getStations() {
            return stations;
        }
        
        public void incStations() {
            this.stations++;
        }

        public long getStargates() {
            return stargates;
        }
        
        public void incStargates() {
            this.stargates++;
        }
        
        public long getCorporations() {
            return corporations;
        }
        
        public void incCorporations() {
            this.corporations++;
        }
        
        public long getAlliances() {
            return alliances;
        }
        
        public void incAlliances() {
            this.alliances++;
        }
        
        public long getTotalgraphics() {
            return totalgraphics;
        }

        public long getTotalraces() {
            return totalraces;
        }

        public long getTotalconstellations() {
            return totalconstellations;
        }
        
        public long getTotalsystems() {
            return totalsystems;
        }
        
        public long getTotalstations() {
            return totalstations;
        }
        
        public long getTotalstargates() {
            return totalstargates;
        }

        public long getTotalcorporations() {
            return totalcorporations;
        }
        
        public long getTotalalliances() {
            return totalalliances;
        }
        
        public void addMessage(String message) {
            messages.add(message);
        }

        public ArrayList getMessages() {
            return this.messages;
        }

        public boolean isDone() {
            return this.done;
        }
    }
    
    public UniverseService(SQLreader sqlreader, SQLTwriter sqlwriter) {
        this.sqlreader = sqlreader;
        this.sqlwriter = sqlwriter;
        universestatus = new UniverseStatus();
    }
    
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            initialize_businesslogic();
            downloadSystems();
            processDevsystems();
        }
        catch(DBException e) {
            universestatus.addMessage(e.getMessage());
        }
        
        long end = System.currentTimeMillis();
        universestatus.addMessage("Download time " + ((end - start)/1000) + "sec.");
        universestatus.setDone();
    }
    
    private SQLreader sqlreader;
    private SQLTwriter sqlwriter;
    private SQLTqueue transactionqueue;    
    private BLgraphic blgraphic;
    private BLrace blrace;
    private BLconstellation blconstellation;
    private BLsystem blsystem;
    private BLstation blstation;
    private BLstargate blstargate;
    private BLcorporation blcorporation;
    private BLalliance blalliance;
    private BLregion blregion;
    private BLstation_service blstationservice;
    private BLfaction blfaction;
    private BLconstellation_neighbour blconstellationneighbour;
    private BLregion_neighbour blregionneighbour;
    private BLsecurity_island blsecurityisland;
    
    private int run;
    int graphicscounter;
    private Iterator<Long> jsongraphicsI;
    private JSONObject jsontypegraphicdetails;
    private SQLToutput toutput;
    
    private void initialize_businesslogic() throws DBException {
        transactionqueue = new SQLTqueue();
        blgraphic = new BLgraphic(sqlreader);
        blgraphic.setAuthenticated(true);
        blrace = new BLrace(sqlreader);
        blrace.setAuthenticated(true);
        blconstellation = new BLconstellation(sqlreader);
        blconstellation.setAuthenticated(true);
        blsystem = new BLsystem(sqlreader);
        blsystem.setAuthenticated(true);
        blcorporation = new BLcorporation(sqlreader);
        blcorporation.setAuthenticated(true);
        blalliance = new BLalliance(sqlreader);
        blalliance.setAuthenticated(true);
        blregion = new BLregion(sqlreader);
        blregion.setAuthenticated(true);
        blfaction = new BLfaction(sqlreader);
        blfaction.setAuthenticated(true);
        blconstellationneighbour = new BLconstellation_neighbour(sqlreader);
        blconstellationneighbour.setAuthenticated(true);
        blregionneighbour = new BLregion_neighbour(sqlreader);
        blregionneighbour.setAuthenticated(true);
        blsecurityisland = new BLsecurity_island(sqlreader);
        blsecurityisland.setAuthenticated(true);

        blstation = new BLstation(blsystem);
        blstation.setAuthenticated(true);
        blstargate = new BLstargate(blsystem);
        blstargate.setAuthenticated(true);
        blstationservice = new BLstation_service(blsystem);
        blstationservice.setAuthenticated(true);

        universestatus.totalgraphics = blgraphic.count();
        universestatus.totalraces = blrace.count()-1;
        universestatus.totalconstellations = blconstellation.count();
        universestatus.totalsystems = blsystem.count();
        universestatus.totalstations = blstation.count();
        universestatus.totalstargates = blstargate.count();
        universestatus.totalcorporations = blcorporation.count();
        universestatus.totalalliances = blalliance.count();
    }
    
    private void downloadGraphics() {
        universestatus.addMessage("Download Graphics");
        blgraphic.setAuthenticated(true);        
        try {
            run = 0;
            JSONArray jsongraphics = Swagger.getGraphics();
            jsongraphicsI = jsongraphics.iterator();
            do {
                add_new_graphics();
            } while(keeprunning && blgraphic.count()<jsongraphics.size());        
        }
        catch(DBException e) {
            universestatus.addMessage(e.getMessage());
        }
        catch(DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }

    private void add_new_graphics() throws DBException, DataException {
        graphicscounter = 0;
        while(jsongraphicsI.hasNext())
            add_graphic_if_new((Long)jsongraphicsI.next());
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            universestatus.addMessage("GraphicsDownloader " + toutput.getErrormessage());
        run++;
    }

    private void add_graphic_if_new(long graphicid) throws DataException, DBException {
        if(run==0 || !blgraphic.getGraphicExists(new GraphicPK(graphicid)))
            download_and_save_graphic(graphicid);
    }

    private void download_and_save_graphic(long graphicid) throws DataException, DBException {
        jsontypegraphicdetails = Swagger.getGraphic(graphicid);
        blgraphic.updateGraphic(transactionqueue, jsontypegraphicdetails);
        universestatus.incGraphics();
        graphicscounter++;
        if(graphicscounter==100)
            save_graphics_buffer();
    }

    private void save_graphics_buffer() throws DBException {
        graphicscounter = 0;
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            universestatus.addMessage("GraphicsDownloader " + toutput.getErrormessage());
    }
    
    private void downloadRaces() {
        universestatus.addMessage("Download Races");
        try {
            JSONArray jsonfaction = Swagger.getRaces();
            Iterator<JSONObject> jsonfactionI = jsonfaction.iterator();
            JSONObject jsonfactiondetails;
            while(jsonfactionI.hasNext())
                update_race_in_database((JSONObject)jsonfactionI.next());
            toutput = sqlwriter.Commit2DB(transactionqueue);
            if(toutput.getHaserror())
                universestatus.addMessage("RacesDownloader " + toutput.getErrormessage());
        }
        catch(DBException e) {
            universestatus.addMessage(e.getMessage());
        }
        catch(DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }

    private void update_race_in_database(JSONObject jsonfactiondetails) throws DBException, DataException {
        blrace.updateRace(transactionqueue, jsonfactiondetails);
        universestatus.incRaces();
    }
    
    private JSONArray jsonconstellations;
    private JSONArray jsonconstellationnames;
    private Iterator<Long> jsonconstellationsI;
    private JSONObject jsonalliancedetails;
    private JSONArray jsonstations;
    private JSONArray jsonstargates;
    private JSONArray jsonservices;
    private Iterator<Long> jsonsystemsI;
    private Iterator<Long> jsonstationsI;
    private Iterator<Long> jsonstargatesI;
    private Iterator<String> jsonservicesI;            
    private Long stargateid;
    private String servicename;
    private JSONObject jsonsystemdetails;
    private JSONObject jsonstationdetails;
    private JSONObject jsonstargatedetails;
    
    private void downloadSystems() {
        universestatus.addMessage("Download Systems");
        try {
            long start = System.currentTimeMillis();
            universestatus.addMessage("Download Regions");
            download_update_regions();
            universestatus.addMessage("Download Constellations");
            download_constellations();
            do
                save_new_constellations();
            while(blconstellation.count()<jsonconstellations.size());

            universestatus.addMessage("Download Systems");
            JSONArray jsonsystems = download_systems_initialize();
            do
                save_new_systems();
            while(blsystem.count()<jsonsystems.size());

            add_hardcoded_station_60000001();
            
            universestatus.addMessage("Create empty systemjumps");
            BLsystemjumps blsystemjumps = new BLsystemjumps(sqlreader);
            blsystemjumps.createsystemjumps(transactionqueue);
            sqlwriter.Commit2DB(transactionqueue);
            
            long end = System.currentTimeMillis();
            universestatus.addMessage("Download time Systems " + ((end - start)/1000) + "sec.");
            universestatus.addMessage("ToDo: calculate systemjumps");
            universestatus.setDone();
        }
        catch(DBException e) {
            universestatus.addMessage(e.getMessage());
        }
        catch(DataException e) {
            universestatus.addMessage(e.getMessage());
        }
        catch(CustomException e) {
            universestatus.addMessage(e.getMessage());
        }        
    }

    private void add_hardcoded_station_60000001() throws DataException, DBException {
        Region unknownregion = new Region(1l);
        unknownregion.setName("Unknown");
        blregion.insertupdateRegion(transactionqueue, unknownregion);
        sqlwriter.Commit2DB(transactionqueue);
        Constellation unknownconstellation = new Constellation(1l);
        unknownconstellation.setRegionPK(unknownregion.getPrimaryKey());
        unknownconstellation.setName("Unknown");
        blconstellation.insertupdateConstellation(transactionqueue, unknownconstellation);
        sqlwriter.Commit2DB(transactionqueue);
        eve.logicentity.System unknownsystem = new eve.logicentity.System(1l);
        unknownsystem.setConstellationPK(unknownconstellation.getPrimaryKey());
        unknownsystem.setName("Unknown");
        blsystem.insertupdateSystem(transactionqueue, unknownsystem);
        sqlwriter.Commit2DB(transactionqueue);
        long missing_stationid = 60000001l;
        jsonstationdetails = Swagger.getStation(missing_stationid);
        blstation.updateStation(transactionqueue, jsonstationdetails);
        jsonservices = (JSONArray)jsonstationdetails.get("services");
        jsonservicesI = jsonservices.iterator();
        while(jsonservicesI.hasNext())
            blstationservice.updateStation_service(transactionqueue, new StationPK(missing_stationid), jsonservicesI.next());
        sqlwriter.Commit2DB(transactionqueue);
    }

    private void save_new_systems() throws CustomException, DBException {
        while(jsonsystemsI.hasNext())
            save_system_if_new((Long)jsonsystemsI.next());
        sqlwriter.Commit2DB(transactionqueue);
        run++;
    }

    private void save_system_if_new(long systemid) throws CustomException {
        if(run==0 || !blsystem.getSystemExists(new SystemPK(systemid)))
            download_and_save_system_info(systemid);
    }

    private void download_and_save_system_info(long systemid) throws DBException, DataException, CustomException {
        download_update_system(systemid);
        download_save_system_stations(systemid);
        download_save_system_stargates(systemid);
    }

    private void download_save_system_stations(long systemid) throws CustomException {
        jsonstations = (JSONArray)jsonsystemdetails.get("stations");
        boolean system_has_npc_stations = jsonstations!=null;
        if(system_has_npc_stations)
            download_and_save_all_new_system_stations(systemid);
    }

    private void download_and_save_all_new_system_stations(long systemid) throws CustomException {
        int runstations = 0;
        do {
            runstations = download_and_save_new_system_stations(runstations);
        } while(blstation.getStations4systemcount(new SystemPK(systemid))<jsonstations.size() && runstations<2);
    }

    private int download_and_save_new_system_stations(int runstations) throws DataException, DBException {
        jsonstationsI = jsonstations.iterator();
        while(jsonstationsI.hasNext())
            download_and_save_if_station_new((Long)jsonstationsI.next());
        runstations++;
        return runstations;
    }

    private void download_and_save_if_station_new(long stationid) throws DataException, DBException {
        if(run==0 || !blstation.getStationExists(new StationPK(stationid)))
            download_and_save_station_and_services(stationid);
    }

    private void download_and_save_station_and_services(long stationid) throws DataException, DBException {
        download_and_save_station(stationid);
        download_and_save_stationservices(stationid);
    }

    private void download_and_save_station(long stationid) throws DBException, DataException {
        jsonstationdetails = Swagger.getStation(stationid);
        //race 16 is not listed in Swagger races
        long raceid_check = JSONConversion.getLong(jsonstationdetails, "race_id");
        if(!blrace.getRaceExists(new RacePK(raceid_check)))
            save_race(raceid_check);
        blstation.updateStation(transactionqueue, jsonstationdetails);
        universestatus.incStations();
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            universestatus.addMessage("UniverseDownloader Station " + toutput.getErrormessage());
    }

    private void download_and_save_stationservices(long stationid) throws DBException, DataException {
        jsonservices = (JSONArray)jsonstationdetails.get("services");
        jsonservicesI = jsonservices.iterator();
        while(jsonservicesI.hasNext())
            blstationservice.updateStation_service(transactionqueue, new StationPK(stationid), jsonservicesI.next());
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            universestatus.addMessage("UniverseDownloader Stationservice " + toutput.getErrormessage());
    }

    private void save_race(long raceid_check) throws DataException, DBException {
        Race race = new Race(raceid_check);
        race.setName("Unknown");
        race.setDescription("Not listed in Swagger");
        race.setFactionPK(new FactionPK(Swagger.EVE_CONST_FACTION_UNKNOWN));
        blrace.insertRace(transactionqueue, race);
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            universestatus.addMessage("UniverseDownloader Racecheck " + toutput.getErrormessage());
    }

    private void download_save_system_stargates(long systemid) throws CustomException {
        jsonstargates = (JSONArray)jsonsystemdetails.get("stargates");
        boolean system_has_stargates = jsonstargates!=null;
        if(system_has_stargates)
            download_and_save_all_new_stargates(systemid);
    }

    private void download_and_save_all_new_stargates(long systemid) throws CustomException {
        int runstargates = 0;
        do
            download_and_save_new_stargates();
        while(blstargate.getStargates4systemcount(new SystemPK(systemid))<jsonstargates.size() && runstargates<2);
    }

    private void download_and_save_new_stargates() throws DataException, DBException {
        jsonstargatesI = jsonstargates.iterator();
        while(jsonstargatesI.hasNext())
            download_and_save_if_stargate_is_new();
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            universestatus.addMessage("UniverseDownloader Stargate " + toutput.getErrormessage());
    }

    private void download_and_save_if_stargate_is_new() throws DBException, DataException {
        stargateid = (Long)jsonstargatesI.next();
        universestatus.incStargates();
        if(run==0 || !blstargate.getStargateExists(new StargatePK(stargateid)))
            download_and_save_stargate();
    }

    private void download_and_save_stargate() throws DBException, DataException {
        jsonstargatedetails = Swagger.getStargate(stargateid);
        blstargate.updateStargate(transactionqueue, jsonstargatedetails);
    }

    private void download_update_system(long systemid) throws DBException, DataException {
        jsonsystemdetails = Swagger.getSystem(systemid);
        blsystem.updateSystem(transactionqueue, jsonsystemdetails);
        universestatus.incSystems();
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            universestatus.addMessage("UniverseDownloader System " + toutput.getErrormessage());
    }

    private JSONArray download_systems_initialize() {
        JSONArray jsonsystems = Swagger.getSystems();
        jsonsystemsI = jsonsystems.iterator();
        run = 0;
        return jsonsystems;
    }

    private void download_constellations() {
        jsonconstellations = Swagger.getConstellations();
        jsonconstellationsI = jsonconstellations.iterator();
    }

    private void save_new_constellations() throws DBException, DataException {
        while(jsonconstellationsI.hasNext())
            save_constellation_if_new((Long)jsonconstellationsI.next());
        sqlwriter.Commit2DB(transactionqueue);
        run++;
    }

    private void save_constellation_if_new(long constellationid) throws DBException, DataException {
        if(run==0 || !blconstellation.getConstellationExists(new ConstellationPK(constellationid)))
            download_and_save_constellation_details(constellationid);
        universestatus.incConstellations();
    }

    private void download_and_save_constellation_details(long constellationid) throws DBException, DataException {
        jsonalliancedetails = Swagger.getConstellation(constellationid);
        blconstellation.updateConstellation(transactionqueue, jsonalliancedetails);
    }

    private void download_update_regions() throws DataException, DBException {
        JSONArray jsonregions = Swagger.getRegions();
        JSONArray jsonregionnames = Swagger.getNames(jsonregions.toJSONString());
        blregion.updateRegions(transactionqueue, jsonregionnames);
    }

    private void processDevsystems() {
        universestatus.addMessage("Mark development Systems");
        try {
            blsystem.postprocess(transactionqueue);
            sqlwriter.Commit2DB(transactionqueue);
            blconstellation.postprocess(transactionqueue);
            sqlwriter.Commit2DB(transactionqueue);
            blregion.postprocess(transactionqueue);     
            sqlwriter.Commit2DB(transactionqueue);
        }
        catch(DBException | DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }

    private void downloadFactions() {
        universestatus.addMessage("Download Factions");        
        try {
            JSONArray jsonfaction = Swagger.getFactions();
            Iterator<JSONObject> jsonfactionI = jsonfaction.iterator();
            while(jsonfactionI.hasNext())
                blfaction.updateFaction(transactionqueue, (JSONObject)jsonfactionI.next());
            toutput = sqlwriter.Commit2DB(transactionqueue);
            if(toutput.getHaserror())
                universestatus.addMessage("FactionDownloader " + toutput.getErrormessage());
        }
        catch(DBException | DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }
    
    private Iterator<Long> jsoncorporationsI;
    private StationPK homestationpk;
    private JSONObject jsoncorporationdetails;
    private int corporationcounter;
    
    private void downloadCorporations() {
        universestatus.addMessage("Download Corporations");
        try {
            JSONArray jsoncorporations = Swagger.getNpccorps();
            jsoncorporationsI = jsoncorporations.iterator();
            do
                download_and_save_new_corporations();
            while(blcorporation.count()<jsoncorporations.size());        
        }
        catch(DBException | DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }

    private void download_and_save_new_corporations() throws DBException, DataException {
        corporationcounter = 0;
        while(jsoncorporationsI.hasNext()) {
            download_and_save_if_corporation_new((Long)jsoncorporationsI.next());
        }
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror()) {
            universestatus.addMessage("CorporationDownloader " + toutput.getErrormessage());
        }
        run++;
    }

    private void download_and_save_if_corporation_new(long corporationid) throws DBException, DataException {
        if(run==0 || !blcorporation.getCorporationExists(new CorporationPK(corporationid)))
            download_and_save_corporation(corporationid);
        universestatus.incCorporations();
    }

    private void download_and_save_corporation(long corporationid) throws DBException, DataException {
        jsoncorporationdetails = Swagger.getCorporation(corporationid);
        jsoncorporationdetails.put("corporation_id", corporationid);
        blcorporation.updateCorporation(transactionqueue, jsoncorporationdetails);
        corporationcounter++;
        if(corporationcounter==100)
            save_corporation_buffer();
    }

    private void save_corporation_buffer() throws DBException {
        corporationcounter = 0;
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            universestatus.addMessage("CorporationDownloader " + toutput.getErrormessage());
    }

    private Iterator<Long> jsonalliancesI;
    private Alliance alliance;
    private CorporationPK corporationpk_creator, corporationpk_executor;
    
    private void downloadAlliances() {
        universestatus.addMessage("Download Alliances");
        try {
            run = 0;
            JSONArray jsonalliances = Swagger.getAlliances();
            jsonalliancesI = jsonalliances.iterator();
            do
                download_all_alliances();
            while(blalliance.count()<jsonalliances.size());        
        }
        catch(DBException | DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }

    private int alliancecounter;
    
    private void download_all_alliances() throws DBException, DataException {
        alliancecounter = 0;
        while(jsonalliancesI.hasNext()) {
            download_and_save_if_alliance_is_new(jsonalliancesI.next());
        }
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror()) {
            universestatus.addMessage("AllianceDownloader " + toutput.getErrormessage());
        }
        run++;
    }

    private void download_and_save_if_alliance_is_new(long allianceid) throws DataException, DBException {
        if(run==0 || !blalliance.getAllianceExists(new AlliancePK(allianceid)))
            download_and_save_alliance_details(allianceid);
    }

    private void download_and_save_alliance_details(long allianceid) throws DBException, DataException {
        download_and_save_alliance(allianceid);
        download_and_save_corporationcreator_if_new();
        download_and_save_corporationexecutor_if_new();
        save_corporation_data();
        universestatus.incAlliances();
        alliancecounter++;
        if(alliancecounter==100)
            save_alliance_buffer();
    }

    private void save_alliance_buffer() throws DBException {
        alliancecounter = 0;
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            universestatus.addMessage("AllianceDownloader " + toutput.getErrormessage());
    }

    private void save_corporation_data() throws DBException {
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            universestatus.addMessage("AllianceDownloader PlayerCorporation " + toutput.getErrormessage());
    }

    private void download_and_save_corporationexecutor_if_new() throws DBException, DataException {
        corporationpk_executor = alliance.getCorporationexecutor_corporationPK();
        boolean corporation_has_new_data = !corporationpk_executor.equals(corporationpk_creator) && !blcorporation.getCorporationExists(corporationpk_executor);
        if(corporation_has_new_data)
            download_and_save_corporation();
    }

    private void download_and_save_corporation() throws DBException, DataException {
        jsoncorporationdetails = Swagger.getCorporation(corporationpk_executor.getId());
        jsoncorporationdetails.put("corporation_id", corporationpk_executor.getId());
        blcorporation.updateCorporation(transactionqueue, jsoncorporationdetails);
        universestatus.incCorporations();
    }

    private void download_and_save_corporationcreator_if_new() throws DBException, DataException {
        corporationpk_creator = alliance.getCorporationcreator_corporationPK();
        if(!blcorporation.getCorporationExists(corporationpk_creator))
            download_and_save_corporationcreator();
    }

    private void download_and_save_corporationcreator() throws DataException, DBException {
        jsoncorporationdetails = Swagger.getCorporation(corporationpk_creator.getId());
        jsoncorporationdetails.put("corporation_id", corporationpk_creator.getId());
        blcorporation.updateCorporation(transactionqueue, jsoncorporationdetails);
        universestatus.incCorporations();
    }

    private void download_and_save_alliance(long allianceid) throws DBException, DataException {
        jsonalliancedetails = Swagger.getAlliance(allianceid);
        jsonalliancedetails.put("alliance_id", allianceid);
        alliance = blalliance.updateAlliance(transactionqueue, jsonalliancedetails);
    }

    private void updateCorporations() {
        universestatus.addMessage("Update Corporation: Alliance");
        universestatus.corporations = 0;
        try {
            ArrayList<Corporation> corporationlist = blcorporation.getCorporations();
            for(Corporation corporation: corporationlist)
                download_and_save_corporation(corporation);
            toutput = sqlwriter.Commit2DB(transactionqueue);
            if(toutput.getHaserror())
                universestatus.addMessage("CorporationDownloader " + toutput.getErrormessage());
        }
        catch(DBException | DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }

    private void download_and_save_corporation(Corporation corporation) throws DataException, DBException {
        jsoncorporationdetails = Swagger.getCorporation(corporation.getPrimaryKey().getId());
        universestatus.incCorporations();
        boolean corporation_linked_to_alliance = jsoncorporationdetails.containsKey("alliance_id");
        if(corporation_linked_to_alliance)
            link_alliance_to_corporation(corporation);
    }

    private void link_alliance_to_corporation(Corporation corporation) throws DataException, DBException {
        corporation.setAlliancePK(new AlliancePK(JSONConversion.getLong(jsoncorporationdetails, "alliance_id")));
        blcorporation.updateCorporation(transactionqueue, corporation);
        corporationcounter++;
        if(corporationcounter==100)
            save_corporationalliance_buffer();
    }

    private void save_corporationalliance_buffer() throws DBException {
        corporationcounter = 0;
        toutput = sqlwriter.Commit2DB(transactionqueue);
        if(toutput.getHaserror())
            universestatus.addMessage("Corporation update " + toutput.getErrormessage());
    }

    private Security_island securityisland;
    private Iterator<eve.logicentity.System> systemsI;
    private long securityislandid;
    private boolean systemsfound;
    private ArrayList<eve.logicentity.System> hisecsystems;
    
    private void createSecurityislands() throws DataException, DBException, CustomException {
        blstargate.updateborders(transactionqueue);
        sqlwriter.Commit2DB(transactionqueue);
        blsystem.updateborders(transactionqueue);
        sqlwriter.Commit2DB(transactionqueue);
        blconstellationneighbour.createneighbours(transactionqueue);
        sqlwriter.Commit2DB(transactionqueue);
        blregionneighbour.createneighbours(transactionqueue);
        sqlwriter.Commit2DB(transactionqueue);
        blsecurityisland.deleteAll(transactionqueue);
        sqlwriter.Commit2DB(transactionqueue);
        securityislandid = 0;
        hisecsystems = blsystem.GetSystems_HiSecNoislands();
        while(!hisecsystems.isEmpty())
            create_securityisland_with_first_hisec_system();
    }

    private void create_securityisland_with_first_hisec_system() throws CustomException, DataException, DBException {
        securityislandid++;
        eve.logicentity.System firstsystem = create_securityisland_from_first_system();
        link_system_to_securityisland(firstsystem);
        systemsfound = true;
        while(systemsfound)
            link_connected_systems_to_securityisland();
        hisecsystems = blsystem.GetSystems_HiSecNoislands();
    }

    private void link_connected_systems_to_securityisland() throws DataException, DBException, CustomException {
        systemsI = blsystem.getHiSecConnectedSystems(securityisland.getPrimaryKey()).iterator();
        systemsfound = systemsI.hasNext();
        while(systemsI.hasNext())
            update_system_securityisland(systemsI.next());
        sqlwriter.Commit2DB(transactionqueue);
    }

    private void update_system_securityisland(eve.logicentity.System system) throws DataException, DBException {
        system.setSecurity_islandPK(securityisland.getPrimaryKey());
        blsystem.updateSystem(transactionqueue, system);
    }

    private void link_system_to_securityisland(eve.logicentity.System system) throws DataException, DBException {
        system.setSecurity_islandPK(securityisland.getPrimaryKey());
        blsystem.updateSystem(transactionqueue, system);
    }

    private eve.logicentity.System create_securityisland_from_first_system() throws DataException, DBException {
        eve.logicentity.System system = hisecsystems.get(0);
        securityisland = new Security_island(securityislandid);
        securityisland.setName(system.getName());
        securityisland.setSecurity_status(0.5d);
        blsecurityisland.insertSecurity_island(transactionqueue, securityisland);
        return system;
    }
}
