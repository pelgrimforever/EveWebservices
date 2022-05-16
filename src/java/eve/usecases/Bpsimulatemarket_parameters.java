package eve.usecases;

import eve.logicview.View_evetypes;

/**
 * @author pelgrim
 */
public class Bpsimulatemarket_parameters {
    
    private String username;
    private View_evetypes viewevetype;
    private long bpprice;
    private int bpbreakeven;
    private int bpmaterialefficiency;
    private long researchcost;
    private long stationfee;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public View_evetypes getViewevetype() {
        return viewevetype;
    }

    public void setViewevetype(View_evetypes viewevetype) {
        this.viewevetype = viewevetype;
    }

    
    public long getBpprice() {
        return bpprice;
    }

    public void setBpprice(long bpprice) {
        this.bpprice = bpprice;
    }

    public int getBpbreakeven() {
        return bpbreakeven;
    }

    public void setBpbreakeven(int bpbreakeven) {
        this.bpbreakeven = bpbreakeven;
    }

    public int getBpmaterialefficiency() {
        return bpmaterialefficiency;
    }

    public void setBpmaterialefficiency(int bpmaterialefficiency) {
        this.bpmaterialefficiency = bpmaterialefficiency;
    }

    public long getResearchcost() {
        return researchcost;
    }

    public void setResearchcost(long researchcost) {
        this.researchcost = researchcost;
    }

    public long getStationfee() {
        return stationfee;
    }

    public void setStationfee(long stationfee) {
        this.stationfee = stationfee;
    }
    
    
}
