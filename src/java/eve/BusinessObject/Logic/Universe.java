/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.BusinessObject.Logic;

import data.conversion.JSONConversion;
import eve.data.Swagger;
import eve.entity.pk.AlliancePK;
import eve.entity.pk.CategoryPK;
import eve.entity.pk.ConstellationPK;
import eve.entity.pk.CorporationPK;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.FactionPK;
import eve.entity.pk.GraphicPK;
import eve.entity.pk.Market_groupPK;
import eve.entity.pk.RacePK;
import eve.entity.pk.StargatePK;
import eve.entity.pk.StationPK;
import eve.entity.pk.SystemPK;
import eve.entity.pk.TypegroupPK;
import eve.logicentity.Constellation;
import eve.logicentity.Market_group;
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
 *
 * @author pelgrim
 */
public class Universe {
    
    public static void downloadGraphics() throws DataException, DBException {
        BLgraphic blgraphic = new BLgraphic();
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
                    graphicscounter++;
                    if(graphicscounter==1000) {
                        graphicscounter = 0;
                        blgraphic.Commit2DB();
                    }
                }
            }
            blgraphic.Commit2DB();
            run++;
        } while(blgraphic.count()<jsongraphics.size());        
    }
    
    public static void downloadMarketgroups() throws DataException, DBException {
        BLmarket_group blmarketgroup = new BLmarket_group();
        int run = 0;
        //add marketgroups / categories / typegroups / evetypes
        JSONArray jsonmarketgroup = Swagger.getMarketgroups();
        Iterator<Long> jsonmarketgroupI = jsonmarketgroup.iterator();
        Long marketgroupid;
        JSONObject jsonmarketgroupdetails;
        int marketgroupcounter = 0;
        ArrayList<Market_group> parentupdates = new ArrayList<>();
        Market_group marketgroup;
        do {
            while(jsonmarketgroupI.hasNext()) {
                marketgroupid = (Long)jsonmarketgroupI.next();
                if(run==0 || !blmarketgroup.getMarket_groupExists(new Market_groupPK(marketgroupid))) {
                    jsonmarketgroupdetails = Swagger.getMarketgroup(marketgroupid);
                    marketgroup = blmarketgroup.updateMarket_group(jsonmarketgroupdetails);
                    if(run==0 && jsonmarketgroupdetails.containsKey("parent_group_id")) {
                        parentupdates.add(blmarketgroup.updateParent(marketgroup, jsonmarketgroupdetails));
                    }                
                    marketgroupcounter++;
                    if(marketgroupcounter==1000) {
                        marketgroupcounter = 0;
                        blmarketgroup.Commit2DB();
                    }
                }
            }
            blmarketgroup.Commit2DB();
            run++;
        } while(blmarketgroup.count()<jsonmarketgroup.size());

        Iterator<Market_group> marketgroupI = parentupdates.iterator();
        while(marketgroupI.hasNext()) {
            blmarketgroup.trans_updateMarket_group(marketgroupI.next());
        }
        blmarketgroup.Commit2DB();
    }
    
    public static void downloadTypes() throws DataException, DBException, CustomException {
        BLcategory blcategory = new BLcategory();
        BLtypegroup bltypegroup = new BLtypegroup(blcategory);
        BLevetype blevetype = new BLevetype(bltypegroup);
        int run = 0;
        //add categories
        JSONArray jsoncategories = Swagger.getCategories();
        JSONArray jsontypegroups;
        JSONArray jsonevetypes;
        Iterator<Long> jsoncategoriesI = jsoncategories.iterator();
        Iterator<Long> jsontypegroupsI;
        Iterator<Long> jsonevetypesI;
        Long categoryid;
        Long typegroupid;
        Long evetypeid;
        JSONObject jsoncategorydetails;
        JSONObject jsontypegroupdetails;
        JSONObject jsonevetypedetails;
        int typegrouprun;
        int evetyperun;
        int evetypecounter;

        do {
            while(jsoncategoriesI.hasNext()) {
                categoryid = (Long)jsoncategoriesI.next();
                jsoncategorydetails = Swagger.getCategory(categoryid);
                //get typegroups
                jsontypegroups = (JSONArray)jsoncategorydetails.get("groups");
                typegrouprun = 0;
                do {
                    if(run==0 || !blcategory.getCategoryExists(new CategoryPK(categoryid))) {
                        blcategory.updateCategory(jsoncategorydetails);
                        blcategory.Commit2DB();
                    }
                    jsontypegroupsI = jsontypegroups.iterator();
                    while(jsontypegroupsI.hasNext()) {
                        typegroupid = (Long)jsontypegroupsI.next();
                        jsontypegroupdetails = Swagger.getGroup(typegroupid);
                        jsonevetypes = (JSONArray)jsontypegroupdetails.get("types");
                        evetyperun = 0;
                        do {
                            if(typegrouprun==0 || !bltypegroup.getTypegroupExists(new TypegroupPK(typegroupid))) {
                                bltypegroup.updateTypegroup(jsontypegroupdetails);
                                bltypegroup.Commit2DB();
                            }
                            jsonevetypesI = jsonevetypes.iterator();
                            evetypecounter = 0;
                            while(jsonevetypesI.hasNext()) {
                                evetypeid = (Long)jsonevetypesI.next();
                                if(evetyperun==0 || !blevetype.getEvetypeExists(new EvetypePK(evetypeid))) {
                                    jsonevetypedetails = Swagger.getType(evetypeid);
                                    blevetype.updateEvetype(jsonevetypedetails);
                                    evetypecounter++;
                                    if(evetypecounter==100) {
                                        blevetype.Commit2DB();
                                        evetypecounter = 0;
                                    }
                                }
                            }
                            blevetype.Commit2DB();
                            evetyperun++;
                        } while(blevetype.getEvetypes4typegroupcount(new TypegroupPK(typegroupid))<jsonevetypes.size());
                    }
                    typegrouprun++;
                } while(bltypegroup.getTypegroup4categorycount(new CategoryPK(categoryid))<jsontypegroups.size());
            }
            run++;
        } while(blcategory.count()<jsoncategories.size());
    }

    public static void downloadRaces() throws DataException, DBException {
        BLrace blrace = new BLrace();
        //add races
        JSONArray jsonfaction = Swagger.getRaces();
        Iterator<JSONObject> jsonfactionI = jsonfaction.iterator();
        Long factionid;
        JSONObject jsonfactiondetails;
        while(jsonfactionI.hasNext()) {
            jsonfactiondetails = (JSONObject)jsonfactionI.next();
            blrace.updateRace(jsonfactiondetails);
        }
        blrace.Commit2DB();
        
    }
    
    public static void downloadSystems() throws DataException, DBException, CustomException {
        BLregion blregion = new BLregion();
        BLconstellation blconstellation = new BLconstellation();
        BLsystem blsystem = new BLsystem();
        BLstation blstation = new BLstation(blsystem);
        BLstargate blstargate = new BLstargate(blsystem);
        BLstation_service blstationservice = new BLstation_service(blsystem);
        BLrace blrace_check = new BLrace();
        int run = 0;

        //add/update regions
        JSONArray jsonregions = Swagger.getRegions();
        JSONArray jsonregionnames = Swagger.getNames(jsonregions.toJSONString());
        blregion.updateRegions(jsonregionnames);
        
        //adds/updates Constellation names and references
        JSONArray jsonconstellations = Swagger.getConstellations();
        JSONArray jsonconstellationnames;
        Iterator<Long> jsonalliancesI = jsonconstellations.iterator();
        Long allianceid;
        JSONObject jsonalliancedetails;
        do {
            while(jsonalliancesI.hasNext()) {
                allianceid = (Long)jsonalliancesI.next();
                if(run==0 || !blconstellation.getConstellationExists(new ConstellationPK(allianceid))) {
                    jsonalliancedetails = Swagger.getConstellation(allianceid);
                    blconstellation.updateConstellation(jsonalliancedetails);
                }
            }
            blconstellation.Commit2DB();
            run++;
        } while(blconstellation.count()<jsonconstellations.size());

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
                if(run==0 || !blsystem.getSystemExists(new SystemPK(systemid))) {
                    jsonsystemdetails = Swagger.getSystem(systemid);
                    blsystem.updateSystem(jsonsystemdetails);
                    blsystem.Commit2DB();
                    jsonstations = (JSONArray)jsonsystemdetails.get("stations");
                    jsonstargates = (JSONArray)jsonsystemdetails.get("stargates");
                    //process stations
                    if(jsonstations!=null) {
                        jsonstationsI = jsonstations.iterator();
                        int runstations = 0;
                        do {
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
                                        blrace_check.Commit2DB();
                                    }

                                    blstation.updateStation(jsonstationdetails);
                                    blstation.Commit2DB();
                                    dataoperatios++;
                                    jsonservices = (JSONArray)jsonstationdetails.get("services");
                                    jsonservicesI = jsonservices.iterator();
                                    while(jsonservicesI.hasNext()) {
                                        blstationservice.updateStation_service(new StationPK(stationid), jsonservicesI.next());
                                    }
                                    blstationservice.Commit2DB();
                                }
                            }
                            runstations++;
                        } while(blstation.getStations4systemcount(new SystemPK(systemid))<jsonstations.size());
                    }
                    //process stargates
                    if(jsonstargates!=null) {
                        jsonstargatesI = jsonstargates.iterator();
                        int runstargates = 0;
                        do {
                            while(jsonstargatesI.hasNext()) {
                                stargateid = (Long)jsonstargatesI.next();
                                if(run==0 || !blstargate.getStargateExists(new StargatePK(stargateid))) {
                                    jsonstargatedetails = Swagger.getStargate(stargateid);
                                    blstargate.updateStargate(jsonstargatedetails);
                                    dataoperatios++;
                                }
                            }
                            blsystem.Commit2DB();
                        } while(blstargate.getStargates4systemcount(new SystemPK(systemid))<jsonstargates.size());
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
    }
    
    public static void downloadFactions() throws DataException, DBException {
        BLfaction blfaction = new BLfaction();
        //add factions
        JSONArray jsonfaction = Swagger.getFactions();
        Iterator<JSONObject> jsonfactionI = jsonfaction.iterator();
        Long factionid;
        JSONObject jsonfactiondetails;
        while(jsonfactionI.hasNext()) {
            jsonfactiondetails = (JSONObject)jsonfactionI.next();
            blfaction.updateFaction(jsonfactiondetails);
        }
        blfaction.Commit2DB();        
    }
    
    public static void downloadCorporations() throws DataException, DBException {
        BLcorporation blcorporation = new BLcorporation();
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
                    corporationcounter++;
                    if(corporationcounter==100) {
                        corporationcounter = 0;
                        blcorporation.Commit2DB();
                    }
                }
            }
            blcorporation.Commit2DB();
            run++;
        } while(blcorporation.count()<jsoncorporations.size());        
    }

    public static void downloadAlliances() throws DataException, DBException {
        //adds/updates alliance
        BLalliance blcorporation = new BLalliance();
        int run = 0;
        JSONArray jsonalliances = Swagger.getAlliances();
        Iterator<Long> jsonalliancesI = jsonalliances.iterator();
        Long allianceid;
        JSONObject jsonalliancedetails;
        do {
            int alliancecounter = 0;
            while(jsonalliancesI.hasNext()) {
                allianceid = (Long)jsonalliancesI.next();
                if(run==0 || !blcorporation.getAllianceExists(new AlliancePK(allianceid))) {
                    jsonalliancedetails = Swagger.getAlliance(allianceid);
                    jsonalliancedetails.put("alliance_id", allianceid);
                    blcorporation.updateAlliance(jsonalliancedetails);
                    alliancecounter++;
                    if(alliancecounter==100) {
                        alliancecounter = 0;
                        blcorporation.Commit2DB();
                    }
                }
            }
            blcorporation.Commit2DB();
            run++;
        } while(blcorporation.count()<jsonalliances.size());        
    }

    public static void processDevsystems() throws DataException, DBException {
        BLregion blregion = new BLregion();
        BLconstellation blconstellation = new BLconstellation();
        BLsystem blsystem = new BLsystem();
        //mark all systems/constellations/regions with no stargates as dev systems
        blsystem.postprocess();
        blconstellation.postprocess();
        blregion.postprocess();        
    }
    
    public static void createSecurityislands() throws DataException, DBException, CustomException {
        BLsystem blsystem = new BLsystem();
        BLstargate blstargate = new BLstargate(blsystem);
        BLconstellation_neighbour blconstellationneighbour = new BLconstellation_neighbour();
        BLregion_neighbour blregionneighbour = new BLregion_neighbour();
        BLsecurity_island blsecurityisland = new BLsecurity_island();
        
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
