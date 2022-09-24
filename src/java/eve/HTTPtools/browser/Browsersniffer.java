/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.HTTPtools.browser;

import java.util.*;
import java.io.*;
import javax.servlet.http.HttpServletRequest;

public final class Browsersniffer {

    private HttpServletRequest request = null;
    private String useragent = null;
    private boolean netEnabled = false;
    private boolean ie = false;
    private boolean ns = false;
    private boolean mo = false;

    private String browsername;
    private String browserversion;

    private String[] incompatible = {
        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"
    };

    public Browsersniffer(HttpServletRequest req) {
        request = req;
        useragent = request.getHeader("User-Agent");
        String user = useragent.toLowerCase();
        findBrowsername(user);
        findBrowserversion(user);
        if(user.indexOf(".net clr") != -1)
            netEnabled = true;
    }

    private void findBrowsername(String user) {
        if(user.indexOf("msie") != -1) {
            ie = true;
            browsername = "MSIE";
        } else if(user.indexOf("netscape") != -1) {
            ns = true;
            browsername = "Netscape";
        } else if(user.indexOf("mozilla") != -1) {
            mo = true;
            browsername = "Mozilla";
        }
    }

    private void findBrowserversion(String user) {
        if(ie) {
            browserversion = user.substring(user.indexOf("msie")+4);
            if(browserversion.length()>5) browserversion = browserversion.substring(1, 5).trim();
        }
        if(ns) {
            browserversion = user.substring(user.indexOf("netscape")+8);
            if(browserversion.length()>5) browserversion = browserversion.substring(1, 5).trim();
        }
        if(mo) {
            browserversion = user.substring(user.indexOf("mozilla")+7);
            if(browserversion.length()>5) browserversion = browserversion.substring(1, 5).trim();
        }
    }

    public String getUseragent() {
        return useragent;
    }

    public boolean isNetEnabled() {
        return netEnabled;
    }

    public String getBrowsername() {
        return browsername;
    }

    public String getBrowserversion() {
        return browserversion;
    }

    public boolean isIE() {
        return ie;
    }

    public boolean isNS() {
        return ns;
    }

    public boolean isMo() {
        return mo;
    }

    public boolean isCompatible() {
        boolean compatible = true;
        for(int i=0; i<incompatible.length; i++) {
            compatible = compatible && !useragent.equals(incompatible[i]);
        }
        return compatible;
    }
}
