/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 17.0.2022 13:37
 * @author Franky Laseure
 */

package eve.BusinessObject.Logic;

import db.*;
import db.*;
import db.SQLTqueue;
import general.exception.DBException;
import eve.interfaces.logicentity.IMaterialinput;
import eve.logicentity.Materialinput;
import eve.BusinessObject.table.Bmaterialinput;
import eve.conversion.entity.EMmaterialinput;
import eve.interfaces.entity.pk.IEvetypePK;
import general.exception.DataException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BLmaterialinput extends Bmaterialinput {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLmaterialinput(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(true);
    }

    public BLmaterialinput(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }
    
    public void useMaterial(SQLTqueue transactionqueue, String username, IEvetypePK evetypepk, long amount) throws DBException, DataException {
        ArrayList<Materialinput> stock = get_Material_in_stock_for_user(username, evetypepk);
        long amountremaining = amount;
        long stock_usadamount;
        for(Materialinput materialinput: stock) {
            stock_usadamount = Math.min(materialinput.getAmount()-materialinput.getUsedamount(), amountremaining);
            materialinput.setUsedamount(materialinput.getUsedamount() + stock_usadamount);
            amountremaining -= stock_usadamount;
            this.updateMaterialinput(transactionqueue, materialinput);
            if(amountremaining==0)
                break;
        }
    }

    private ArrayList<Materialinput> get_Material_in_stock_for_user(String username, IEvetypePK evetypepk) throws DBException {
        Object[][] parameters = {{ "username", username }};
        SQLparameters sqlparameters = new SQLparameters(parameters);
        sqlparameters.add(evetypepk.getSQLprimarykey());
        return getEntities(EMmaterialinput.SQLSelect4usage, sqlparameters);
    }
    
    @Override
    public void insertMaterialinput(SQLTqueue transactionqueue, IMaterialinput materialinput) throws DBException, DataException {
        materialinput.getPrimaryKey().setAddtimestamp(new Timestamp(System.currentTimeMillis()));
        super.insertMaterialinput(transactionqueue, materialinput);
    }
    
}
