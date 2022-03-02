/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.service;

import data.conversion.JSONConversion;
import db.TransactionOutput;
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
 * Market loader service
 * @author pelgrim
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
        private long totalconstellations = 0;
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
            BLgraphic blgraphic = new BLgraphic();
            blgraphic.setAuthenticated(true);
            BLrace blrace = new BLrace();
            blrace.setAuthenticated(true);
            BLconstellation blconstellation = new BLconstellation();
            blconstellation.setAuthenticated(true);
            BLsystem blsystem = new BLsystem();
            blsystem.setAuthenticated(true);
            BLstation blstation = new BLstation();
            blstation.setAuthenticated(true);
            BLstargate blstargate = new BLstargate();
            blstargate.setAuthenticated(true);
            BLcorporation blcorporation = new BLcorporation();
            blcorporation.setAuthenticated(true);
            BLalliance blalliance = new BLalliance();
            blalliance.setAuthenticated(true);
            try {
                totalgraphics = blgraphic.count();
                totalraces = blrace.count()-1;
                totalconstellations = blconstellation.count();
                totalsystems = blsystem.count();
                totalstations = blstation.count();
                totalstargates = blstargate.count();
                totalcorporations = blcorporation.count();
                totalalliances = blalliance.count();
            }
            catch(DBException e) {
                
            }
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
    
    public UniverseService() {
        universestatus = new UniverseStatus();
    }
    
    @Override
    public void run() {
        long start = System.currentTimeMillis();

        downloadGraphics();
        downloadRaces();
        downloadSystems();
        processDevsystems();
        downloadFactions();
        downloadCorporations();
        downloadAlliances();
        updateCorporations();
        
        long end = System.currentTimeMillis();
        universestatus.addMessage("Download time " + ((end - start)/1000) + "sec.");
        universestatus.setDone();
    }

    private void downloadGraphics() {
        universestatus.addMessage("Download Graphics");
        TransactionOutput toutput;
        BLgraphic blgraphic = new BLgraphic();
        blgraphic.setAuthenticated(true);
        
        try {
            int run = 0;
            //add graphics
            JSONArray jsongraphics = Swagger.getGraphics();
            Iterator<Long> jsongraphicsI = jsongraphics.iterator();
            Long graphicid;
            JSONObject jsontypegraphicdetails;
            do {
                int graphicscounter = 0;
                while(jsongraphicsI.hasNext()) {
                    graphicid = (Long)jsongraphicsI.next();
                    if(run==0 || !blgraphic.getGraphicExists(new GraphicPK(graphicid))) {
                        jsontypegraphicdetails = Swagger.getGraphic(graphicid);
                        blgraphic.updateGraphic(jsontypegraphicdetails);
                        universestatus.incGraphics();
                        graphicscounter++;
                        if(graphicscounter==100) {
                            graphicscounter = 0;
                            toutput = blgraphic.Commit2DB();
                            if(toutput.getHaserror()) {
                                universestatus.addMessage("GraphicsDownloader " + toutput.getErrormessage());
                            }
                        }
                    }
                }
                toutput = blgraphic.Commit2DB();
                if(toutput.getHaserror()) {
                    universestatus.addMessage("GraphicsDownloader " + toutput.getErrormessage());
                }
                run++;
            } while(keeprunning && blgraphic.count()<jsongraphics.size());        
        }
        catch(DBException e) {
            universestatus.addMessage(e.getMessage());
        }
        catch(DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }
    
    private void downloadRaces() {
        universestatus.addMessage("Download Races");
        TransactionOutput toutput;
        BLrace blrace = new BLrace();
        blrace.setAuthenticated(true);
        
        try {
            //add races
            JSONArray jsonfaction = Swagger.getRaces();
            Iterator<JSONObject> jsonfactionI = jsonfaction.iterator();
            Long factionid;
            JSONObject jsonfactiondetails;
            while(jsonfactionI.hasNext()) {
                jsonfactiondetails = (JSONObject)jsonfactionI.next();
                blrace.updateRace(jsonfactiondetails);
                universestatus.incRaces();
            }
            toutput = blrace.Commit2DB();
            if(toutput.getHaserror()) {
                universestatus.addMessage("RacesDownloader " + toutput.getErrormessage());
            }
        }
        catch(DBException e) {
            universestatus.addMessage(e.getMessage());
        }
        catch(DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }
    
    private void downloadSystems() {
        universestatus.addMessage("Download Systems");
        TransactionOutput toutput;
        BLregion blregion = new BLregion();
        blregion.setAuthenticated(true);
        BLconstellation blconstellation = new BLconstellation();
        blconstellation.setAuthenticated(true);
        BLsystem blsystem = new BLsystem();
        blsystem.setAuthenticated(true);
        BLstation blstation = new BLstation(blsystem);
        blstation.setAuthenticated(true);
        BLstargate blstargate = new BLstargate(blsystem);
        blstargate.setAuthenticated(true);
        BLstation_service blstationservice = new BLstation_service(blsystem);
        blstationservice.setAuthenticated(true);
        BLrace blrace_check = new BLrace();
        blrace_check.setAuthenticated(true);
        
        try {
            long start = System.currentTimeMillis();
            int run = 0;

            universestatus.addMessage("Download Regions");
            //add/update regions
            JSONArray jsonregions = Swagger.getRegions();
            JSONArray jsonregionnames = Swagger.getNames(jsonregions.toJSONString());
            blregion.updateRegions(jsonregionnames);

            universestatus.addMessage("Download Constellations");
            //adds/updates Constellation names and references
            JSONArray jsonconstellations = Swagger.getConstellations();
            JSONArray jsonconstellationnames;
            Iterator<Long> jsonconstellationsI = jsonconstellations.iterator();
            Long allianceid;
            JSONObject jsonalliancedetails;
            do {
                while(jsonconstellationsI.hasNext()) {
                    allianceid = (Long)jsonconstellationsI.next();
                    if(run==0 || !blconstellation.getConstellationExists(new ConstellationPK(allianceid))) {
                        jsonalliancedetails = Swagger.getConstellation(allianceid);
                        blconstellation.updateConstellation(jsonalliancedetails);
                        universestatus.incConstellations();
                    }
                }
                blconstellation.Commit2DB();
                run++;
            } while(blconstellation.count()<jsonconstellations.size());

            universestatus.addMessage("Download Systems");
            //adds/updates System names and references
            //add station services
            JSONArray jsonsystems = Swagger.getSystems();
            JSONArray jsonstations;
            JSONArray jsonstargates;
            JSONArray jsonservices;
            Iterator<Long> jsonsystemsI = jsonsystems.iterator();
            Iterator<Long> jsonstationsI;
            Iterator<Long> jsonstargatesI;
            Iterator<String> jsonservicesI;            
            Long systemid;
            Long stationid;
            Long stargateid;
            Long raceid_check;
            String servicename;
            JSONObject jsonsystemdetails;
            JSONObject jsonstationdetails;
            JSONObject jsonstargatedetails;
            int dataoperatios = 0;
            run = 0;
            do {
                while(jsonsystemsI.hasNext()) {
                    systemid = (Long)jsonsystemsI.next();
                    if(systemid==30000141) {
                        boolean stop = true;
                    }
                    if(run==0 || !blsystem.getSystemExists(new SystemPK(systemid))) {
                        jsonsystemdetails = Swagger.getSystem(systemid);
                        blsystem.updateSystem(jsonsystemdetails);
                        universestatus.incSystems();
                        toutput = blsystem.Commit2DB();
                        if(toutput.getHaserror()) {
                            universestatus.addMessage("UniverseDownloader System " + toutput.getErrormessage());
                        }
                        jsonstations = (JSONArray)jsonsystemdetails.get("stations");
                        jsonstargates = (JSONArray)jsonsystemdetails.get("stargates");
                        //process stations
                        if(jsonstations!=null) {
                            int runstations = 0;
                            do {
                                jsonstationsI = jsonstations.iterator();
                                while(jsonstationsI.hasNext()) {
                                    stationid = (Long)jsonstationsI.next();
                                    if(run==0 || !blstation.getStationExists(new StationPK(stationid))) {
                                        jsonstationdetails = Swagger.getStation(stationid);
                                        //race 16 is not listed in Swagger races
                                        raceid_check = JSONConversion.getLong(jsonstationdetails, "race_id");
                                        if(!blrace_check.getRaceExists(new RacePK(raceid_check))) {
                                            Race race = new Race(raceid_check);
                                            race.setName("Unknown");
                                            race.setDescription("Not listed in Swagger");
                                            race.setFactionPK(new FactionPK(Swagger.EVE_CONST_FACTION_UNKNOWN));
                                            blrace_check.insertRace(race);
                                            toutput = blrace_check.Commit2DB();
                                            if(toutput.getHaserror()) {
                                                universestatus.addMessage("UniverseDownloader Racecheck " + toutput.getErrormessage());
                                            }
                                        }

                                        blstation.updateStation(jsonstationdetails);
                                        universestatus.incStations();
                                        toutput = blstation.Commit2DB();
                                        if(toutput.getHaserror()) {
                                            universestatus.addMessage("UniverseDownloader Station " + toutput.getErrormessage());
                                        }
                                        dataoperatios++;
                                        jsonservices = (JSONArray)jsonstationdetails.get("services");
                                        jsonservicesI = jsonservices.iterator();
                                        while(jsonservicesI.hasNext()) {
                                            blstationservice.updateStation_service(new StationPK(stationid), jsonservicesI.next());
                                        }
                                        toutput = blstationservice.Commit2DB();
                                        if(toutput.getHaserror()) {
                                            universestatus.addMessage("UniverseDownloader Stationservice " + toutput.getErrormessage());
                                        }
                                    }
                                }
                                runstations++;
                            } while(blstation.getStations4systemcount(new SystemPK(systemid))<jsonstations.size() && runstations<2);
                        }
                        //process stargates
                        if(jsonstargates!=null) {
                            int runstargates = 0;
                            do {
                                jsonstargatesI = jsonstargates.iterator();
                                while(jsonstargatesI.hasNext()) {
                                    stargateid = (Long)jsonstargatesI.next();
                                    universestatus.incStargates();
                                    if(run==0 || !blstargate.getStargateExists(new StargatePK(stargateid))) {
                                        jsonstargatedetails = Swagger.getStargate(stargateid);
                                        blstargate.updateStargate(jsonstargatedetails);
                                        dataoperatios++;
                                    }
                                }
                                toutput = blsystem.Commit2DB();
                                if(toutput.getHaserror()) {
                                    universestatus.addMessage("UniverseDownloader Stargate " + toutput.getErrormessage());
                                }
                            } while(blstargate.getStargates4systemcount(new SystemPK(systemid))<jsonstargates.size() && runstargates<2);
                        }                        
                    }
                }
                blsystem.Commit2DB();
                run++;
            } while(blsystem.count()<jsonsystems.size());

            //hard coded: add station 60000001, unknownsystem 1, it has not a valid unknownsystem
            //WH space ?
            Region unknownregion = new Region(1l);
            unknownregion.setName("Unknown");
            blregion.insertupdateRegion(unknownregion);
            blregion.Commit2DB();
            Constellation unknownconstellation = new Constellation(1l);
            unknownconstellation.setRegionPK(unknownregion.getPrimaryKey());
            unknownconstellation.setName("Unknown");
            blconstellation.insertupdateConstellation(unknownconstellation);
            blconstellation.Commit2DB();
            eve.logicentity.System unknownsystem = new eve.logicentity.System(1l);
            unknownsystem.setConstellationPK(unknownconstellation.getPrimaryKey());
            unknownsystem.setName("Unknown");
            blsystem.insertupdateSystem(unknownsystem);
            blsystem.Commit2DB();
            stationid = 60000001l;
            jsonstationdetails = Swagger.getStation(stationid);            
            blstation.updateStation(jsonstationdetails);
            jsonservices = (JSONArray)jsonstationdetails.get("services");
            jsonservicesI = jsonservices.iterator();
            while(jsonservicesI.hasNext()) {
                blstationservice.updateStation_service(new StationPK(stationid), jsonservicesI.next());
            }
            blstation.Commit2DB();
            
            universestatus.addMessage("Create empty systemjumps");
            BLsystemjumps blsystemjumps = new BLsystemjumps();
            blsystemjumps.createsystemjumps();
            
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

    private void processDevsystems() {
        universestatus.addMessage("Mark development Systems");
        BLregion blregion = new BLregion();
        blregion.setAuthenticated(true);
        BLconstellation blconstellation = new BLconstellation();
        blconstellation.setAuthenticated(true);
        BLsystem blsystem = new BLsystem();
        blsystem.setAuthenticated(true);

        try {
            //mark all systems/constellations/regions with no stargates as dev systems
            blsystem.postprocess();
            blconstellation.postprocess();
            blregion.postprocess();        
        }
        catch(DBException | DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }

    public void downloadFactions() {
        universestatus.addMessage("Download Factions");
        TransactionOutput toutput;
        BLfaction blfaction = new BLfaction();
        blfaction.setAuthenticated(true);
        
        try {
            //add factions
            JSONArray jsonfaction = Swagger.getFactions();
            Iterator<JSONObject> jsonfactionI = jsonfaction.iterator();
            Long factionid;
            JSONObject jsonfactiondetails;
            while(jsonfactionI.hasNext()) {
                jsonfactiondetails = (JSONObject)jsonfactionI.next();
                blfaction.updateFaction(jsonfactiondetails);
            }
            toutput = blfaction.Commit2DB();
            if(toutput.getHaserror()) {
                universestatus.addMessage("FactionDownloader " + toutput.getErrormessage());
            }
        }
        catch(DBException | DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }
    
    public void downloadCorporations() {
        universestatus.addMessage("Download Corporations");
        TransactionOutput toutput;
        BLcorporation blcorporation = new BLcorporation();
        blcorporation.setAuthenticated(true);
        
        try {
            int run = 0;
            //adds/updates corporation
            JSONArray jsoncorporations = Swagger.getNpccorps();
            Iterator<Long> jsoncorporationsI = jsoncorporations.iterator();
            Long corporationid;
            StationPK homestationpk;
            JSONObject jsoncorporationdetails;
            do {
                int corporationcounter = 0;
                while(jsoncorporationsI.hasNext()) {
                    corporationid = (Long)jsoncorporationsI.next();
                    if(run==0 || !blcorporation.getCorporationExists(new CorporationPK(corporationid))) {
                        jsoncorporationdetails = Swagger.getCorporation(corporationid);
                        jsoncorporationdetails.put("corporation_id", corporationid);
                        blcorporation.updateCorporation(jsoncorporationdetails);
                        universestatus.incCorporations();
                        corporationcounter++;
                        if(corporationcounter==100) {
                            corporationcounter = 0;
                            toutput = blcorporation.Commit2DB();
                            if(toutput.getHaserror()) {
                                universestatus.addMessage("CorporationDownloader " + toutput.getErrormessage());
                            }
                        }
                    }
                }
                toutput = blcorporation.Commit2DB();
                if(toutput.getHaserror()) {
                    universestatus.addMessage("CorporationDownloader " + toutput.getErrormessage());
                }
                run++;
            } while(blcorporation.count()<jsoncorporations.size());        
        }
        catch(DBException | DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }

    public void downloadAlliances() {
        universestatus.addMessage("Download Alliances");
        TransactionOutput toutput;
        BLalliance blalliance = new BLalliance();
        blalliance.setAuthenticated(true);
        BLcorporation blcorporation = new BLcorporation();
        blcorporation.setAuthenticated(true);

        try {
            //adds/updates alliance
            int run = 0;
            JSONArray jsonalliances = Swagger.getAlliances();
            Iterator<Long> jsonalliancesI = jsonalliances.iterator();
            Long allianceid;
            Alliance alliance;
            CorporationPK corporationpk_creator, corporationpk_executor;
            JSONObject jsoncorporationdetails;
            JSONObject jsonalliancedetails;
            do {
                int alliancecounter = 0;
                while(jsonalliancesI.hasNext()) {
                    allianceid = (Long)jsonalliancesI.next();
                    if(run==0 || !blalliance.getAllianceExists(new AlliancePK(allianceid))) {
                        jsonalliancedetails = Swagger.getAlliance(allianceid);
                        jsonalliancedetails.put("alliance_id", allianceid);
                        //check if refered corporations exist in database
                        alliance = blalliance.updateAlliance(jsonalliancedetails);
                        corporationpk_creator = alliance.getCorporationcreator_corporationPK();
                        if(!blcorporation.getEntityExists(corporationpk_creator)) {
                            jsoncorporationdetails = Swagger.getCorporation(corporationpk_creator.getId());
                            jsoncorporationdetails.put("corporation_id", corporationpk_creator.getId());
                            blcorporation.updateCorporation(jsoncorporationdetails);
                            universestatus.incCorporations();
                        }
                        corporationpk_executor = alliance.getCorporationexecutor_corporationPK();
                        if(!corporationpk_executor.equals(corporationpk_creator)) {
                            if(!blcorporation.getEntityExists(corporationpk_executor)) {
                                jsoncorporationdetails = Swagger.getCorporation(corporationpk_executor.getId());
                                jsoncorporationdetails.put("corporation_id", corporationpk_executor.getId());
                                blcorporation.updateCorporation(jsoncorporationdetails);
                                universestatus.incCorporations();
                            }
                        }
                        toutput = blcorporation.Commit2DB();
                        if(toutput.getHaserror()) {
                            universestatus.addMessage("AllianceDownloader PlayerCorporation " + toutput.getErrormessage());
                        }
                        universestatus.incAlliances();
                        alliancecounter++;
                        if(alliancecounter==100) {
                            alliancecounter = 0;
                            toutput = blalliance.Commit2DB();
                            if(toutput.getHaserror()) {
                                universestatus.addMessage("AllianceDownloader " + toutput.getErrormessage());
                            }
                        }
                    }
                }
                toutput = blalliance.Commit2DB();
                if(toutput.getHaserror()) {
                    universestatus.addMessage("AllianceDownloader " + toutput.getErrormessage());
                }
                run++;
            } while(blalliance.count()<jsonalliances.size());        
        }
        catch(DBException | DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }
    
    public void updateCorporations() {
        universestatus.addMessage("Update Corporation: Alliance");
        universestatus.corporations = 0;
        TransactionOutput toutput;
        int corporationcounter = 0;
        BLcorporation blcorporation = new BLcorporation();
        blcorporation.setAuthenticated(true);

        try {
            //adds/updates corporation
            ArrayList<Corporation> corporationlist = blcorporation.getAll();
            JSONObject jsoncorporationdetails;
            for(Corporation corporation: corporationlist) {
                jsoncorporationdetails = Swagger.getCorporation(corporation.getPrimaryKey().getId());
                universestatus.incCorporations();
                if(jsoncorporationdetails.containsKey("alliance_id")) {
                    corporation.setAlliancePK(new AlliancePK(JSONConversion.getLong(jsoncorporationdetails, "alliance_id")));
                    blcorporation.updateCorporation(corporation);
                    corporationcounter++;
                    if(corporationcounter==100) {
                        corporationcounter = 0;
                        toutput = blcorporation.Commit2DB();
                        if(toutput.getHaserror()) {
                            universestatus.addMessage("Corporation update " + toutput.getErrormessage());
                        }
                    }
                }
            }
            toutput = blcorporation.Commit2DB();
            if(toutput.getHaserror()) {
                universestatus.addMessage("CorporationDownloader " + toutput.getErrormessage());
            }
        }
        catch(DBException | DataException e) {
            universestatus.addMessage(e.getMessage());
        }
    }

    public void createSecurityislands() throws DataException, DBException, CustomException {
        BLsystem blsystem = new BLsystem();
        blsystem.setAuthenticated(true);
        BLstargate blstargate = new BLstargate(blsystem);
        blstargate.setAuthenticated(true);
        BLconstellation_neighbour blconstellationneighbour = new BLconstellation_neighbour();
        blconstellationneighbour.setAuthenticated(true);
        BLregion_neighbour blregionneighbour = new BLregion_neighbour();
        blregionneighbour.setAuthenticated(true);
        BLsecurity_island blsecurityisland = new BLsecurity_island();
        blsecurityisland.setAuthenticated(true);
        
        //set isconstellationborder and isregionborder on stargates
        //create security_islands
        blstargate.updateborders();
        blsystem.updateborders();

        //save constellation and region neighbours
        blconstellationneighbour.createneighbours();
        blregionneighbour.createneighbours();

        //create security islands, delete old ones
        blsecurityisland.deleteAll();
        Security_island securityisland;
        eve.logicentity.System system;
        Iterator<eve.logicentity.System> systemsI;
        long securityislandid = 0;
        boolean systemsfound;
        ArrayList<eve.logicentity.System> hisecsystems = blsystem.GetSystems_HiSecNoislands();
        while(!hisecsystems.isEmpty()) {
            //create new Island with starting point and name same as first system
            securityislandid++;
            system = hisecsystems.get(0);
            securityisland = new Security_island(securityislandid);
            securityisland.setName(system.getName());
            securityisland.setSecurity_status(0.5d);
            blsecurityisland.insertSecurity_island(securityisland);
            //link first system to security island
            system.setSecurity_islandPK(securityisland.getPrimaryKey());
            blsystem.updateSystem(system);
            //search new connected systems and link them to security island, until nothing new is found
            systemsfound = true;
            while(systemsfound) {
                systemsI = blsystem.getHiSecConnectedSystems(securityisland.getPrimaryKey()).iterator();
                systemsfound = systemsI.hasNext();
                while(systemsI.hasNext()) {
                    system = systemsI.next();
                    system.setSecurity_islandPK(securityisland.getPrimaryKey());
                    blsystem.trans_updateSystem(system);
                }
                blsystem.Commit2DB();
            }
            //load remaining systems
            hisecsystems = blsystem.GetSystems_HiSecNoislands();
        }        
    }
}
