/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eve.restservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author pelgrim
 */
@Path("rstest")
public class RStest implements Runnable {
    
    @Context
    private UriInfo context;
    
    private static Thread searcher = null;
    private static boolean keeprunning = false;
    private static int count = 0;

    /**
     * Creates a new instance of RStest
     */
    public RStest() {
    }

    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        return "";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            if(json.containsKey("start") && (Boolean)json.get("start")) {
                keeprunning = true;
                if(searcher==null) {
                    searcher = new Thread(this); 
                    searcher.setPriority(Thread.MIN_PRIORITY);
                    searcher.start();
                }
            }
            if(json.containsKey("stop") && (Boolean)json.get("stop")) {
                keeprunning = false;
                searcher.interrupt();
                searcher = null;
            }
            result = "" + keeprunning + " " + count;
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }

    public void run() {
        while(keeprunning) {
            count++;
            try {
                searcher.sleep(2000);
            }
            catch (InterruptedException ignored) { } 
        }
    }
    
}
