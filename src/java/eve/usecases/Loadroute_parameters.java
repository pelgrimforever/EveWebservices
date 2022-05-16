package eve.usecases;

import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class Loadroute_parameters {

    private long origin;
    private long destination;
    private ArrayList<Long> avoidsystems;
    private ArrayList<Long> routesegmentlist;
    private boolean secure;

    public long getOrigin() {
        return origin;
    }

    public void setOrigin(long origin) {
        this.origin = origin;
    }

    public long getDestination() {
        return destination;
    }

    public void setDestination(long destination) {
        this.destination = destination;
    }

    public ArrayList<Long> getAvoidsystems() {
        return avoidsystems;
    }

    public void setAvoidsystems(ArrayList<Long> avoidsystems) {
        this.avoidsystems = avoidsystems;
    }

    public ArrayList<Long> getRoutesegmentlist() {
        return routesegmentlist;
    }

    public void setRoutesegmentlist(ArrayList<Long> routesegmentlist) {
        this.routesegmentlist = routesegmentlist;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }
}
