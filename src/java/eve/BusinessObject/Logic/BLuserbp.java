/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 28.0.2022 15:59
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import db.*;
import db.SQLTqueue;
import general.exception.DBException;
import eve.interfaces.logicentity.IUserbp;
import eve.logicentity.Userbp;
import eve.BusinessObject.table.Buserbp;
import eve.conversion.entity.EMuserbp;
import eve.entity.pk.EvetypePK;
import eve.entity.pk.UserbpPK;
import eve.logicentity.Bpmaterial;
import eve.logicentity.Materialinput;
import eve.logicview.View_userbp;
import eve.logicview.View_userbpmaterial;
import general.exception.CustomException;
import general.exception.DataException;
import java.util.ArrayList;

public class BLuserbp extends Buserbp {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLuserbp(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLuserbp(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public void insertNewbp(SQLTqueue transactionqueue, IUserbp newuserbp) throws DBException, DataException {
        Userbp userbp = check_existing_blueprints(newuserbp);
        int serialnumber = create_blueprint_serialnumber(userbp);
        set_blueprint_default_values(newuserbp, serialnumber);
        this.insertUserbp(transactionqueue, newuserbp);
    }

    private Userbp check_existing_blueprints(IUserbp newuserbp) throws DBException {
        Object[][] parameters = {{ "username", newuserbp.getPrimaryKey().getUsername()}};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        sqlparameters.add(newuserbp.getPrimaryKey().getEvetypePK().getSQLprimarykey());
        return (Userbp)getEntity(EMuserbp.SQLSelectMaxserial4Evetype, sqlparameters);
    }
    
    private int create_blueprint_serialnumber(Userbp userbp) {
        int serialnumber = 0;
        if(userbp!=null)
            serialnumber = userbp.getPrimaryKey().getSerialnumber() + 1;
        return serialnumber;
    }

    private void set_blueprint_default_values(IUserbp newuserbp, int serialnumber) {
        newuserbp.getPrimaryKey().setSerialnumber(serialnumber);
        newuserbp.setAmountproduced(0);
        newuserbp.setMaterialefficiency(0);
    }

    public void updateProperties(SQLTqueue transactionqueue, IUserbp userbp) throws DBException, DataException {
        Userbp original = getUserbp(userbp.getPrimaryKey());
        original.setTotalamount(userbp.getTotalamount());
        original.setBpprice(userbp.getBpprice());
        original.setAmountproduced(userbp.getAmountproduced());
        original.setMaterialefficiency(userbp.getMaterialefficiency());
        original.setResearchcost(userbp.getResearchcost());
        tableio.updateEntity(transactionqueue, original);
    }
    
}
