/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2021 15:56
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.SQLTwriter;
import general.exception.DBException;
import eve.logicentity.Evetype;
import db.*;
import data.conversion.JSONConversion;
import db.SQLTqueue;
import eve.BusinessObject.table.Bevetype;
import eve.conversion.entity.EMevetype;
import eve.entity.pk.GraphicPK;
import eve.entity.pk.Market_groupPK;
import eve.entity.pk.TypegroupPK;
import eve.interfaces.entity.pk.IEvetypePK;
import general.exception.DataException;
import eve.interfaces.entity.pk.ITypegroupPK;
import eve.logicview.View_bpmaterial;
import eve.usecases.Bpproduction_usecases;
import general.exception.CustomException;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.simple.JSONObject;

public class BLevetype extends Bevetype {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLevetype(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLevetype(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public Evetype convert2Evetype(JSONObject jsontypedetails) throws DBException, DataException {
        Evetype evetype = new Evetype(JSONConversion.getLong(jsontypedetails, "type_id"));
        evetype.setName(JSONConversion.getString(jsontypedetails, "name"));
        evetype.setDescription(JSONConversion.getString(jsontypedetails, "description"));
        evetype.setTypegroupPK(new TypegroupPK(JSONConversion.getLong(jsontypedetails, "group_id")));
        evetype.setPublished(JSONConversion.getboolean(jsontypedetails, "published"));
        if(jsontypedetails.containsKey("market_group_id")) evetype.setMarket_groupPK(new Market_groupPK(JSONConversion.getLong(jsontypedetails, "market_group_id")));
        if(jsontypedetails.containsKey("capacity")) evetype.setCapacity(JSONConversion.getDouble(jsontypedetails, "capacity"));
        if(jsontypedetails.containsKey("graphic_id")) evetype.setGraphicPK(new GraphicPK(JSONConversion.getLong(jsontypedetails, "graphic_id")));
        if(jsontypedetails.containsKey("icon_id")) evetype.setIcon(JSONConversion.getLong(jsontypedetails, "icon_id"));
        if(jsontypedetails.containsKey("mass")) evetype.setMass(JSONConversion.getDouble(jsontypedetails, "mass"));
        if(jsontypedetails.containsKey("packaged_volume")) evetype.setPackaged_volume(JSONConversion.getDouble(jsontypedetails, "packaged_volume"));
        if(jsontypedetails.containsKey("portion_size")) evetype.setPortion_size(JSONConversion.getint(jsontypedetails, "portion_size"));
        if(jsontypedetails.containsKey("radius")) evetype.setRadius(JSONConversion.getDouble(jsontypedetails, "radius"));
        if(jsontypedetails.containsKey("volume")) evetype.setVolume(JSONConversion.getDouble(jsontypedetails, "volume"));
        return evetype;
    }

    public void toggleConfiguredbp(SQLTqueue transactionqueue, IEvetypePK evetypepk) throws DBException, DataException {
        Evetype evetype = this.getEvetype(evetypepk);
        evetype.setConfiguredbp(!evetype.getConfiguredbp());
        this.updateEvetype(transactionqueue, evetype);
    }
    
    public long getEvetypes4typegroupcount(ITypegroupPK typegroupPK) throws CustomException {
        return count(EMevetype.SQLSelect4typegroupCount, typegroupPK.getSQLprimarykey());
    }

    public void updateaverageprices(SQLTqueue transactionqueue) throws DBException, DataException {
        addStatement(transactionqueue, EMevetype.SQLUpdateBuyprices);
        addStatement(transactionqueue, EMevetype.SQLUpdateSellprices);
    }

    public void updateHistoryaverages(SQLTqueue transactionqueue) throws DBException, DataException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        Object[][] parameters = {{ "year", year }, { "month", month+1 }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        addStatement(transactionqueue, EMevetype.SQLUpdateAverages, sqlparameters);
    }
    
    public ArrayList<Evetype> getConfiguredblueprints() throws DBException {
        return getEntities(EMevetype.SQLSelect4configuredbp, null);
    }
    
}
