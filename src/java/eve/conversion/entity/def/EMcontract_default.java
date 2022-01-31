/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 31.0.2022 17:49
 *
 */
package eve.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import eve.entity.pk.*;
import eve.logicentity.Contract;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMcontract_default
 * Maps SQL ResultSet to eve.logicentity objects
 * @author Franky Laseure
 */
public class EMcontract_default implements TableMapper {
    
    public static final String SQLWhere1 = "id = :contract.id:";
    public static final String SQLSelect1 = "select contract.* from contract where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from contract where " + SQLWhere1;
    public static final String SQLSelectAll = "select contract.* from contract";

    public static final String SQLSelect = "select contract.* from contract";

//Custom code, do not change this line
    public static final String OrderBy = " order by id";
//Custom code, do not change this line


    /**
     * 
     * @return SQL where clause for one Contract (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Contract (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Contracts
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Contract
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        ContractPK contractPK = null;
        Contract contract;
        if(dbresult==null) {
            contract = new Contract(contractPK);
        } else {
            try {
                contractPK = new ContractPK(dbresult.getLong("id"));
                contract = new Contract(contractPK);
                contract.initCollateral(dbresult.getDouble("collateral"));
                contract.initDate_expired(dbresult.getTimestamp("date_expired"));
                contract.initDate_issued(dbresult.getTimestamp("date_issued"));
                contract.initDays_to_complete(dbresult.getInt("days_to_complete"));
                contract.initEnd_location_id(dbresult.getLong("end_location_id"));
                contract.initFor_corporation(dbresult.getBoolean("for_corporation"));
                contract.initPrice(dbresult.getDouble("price"));
                contract.initReward(dbresult.getDouble("reward"));
                contract.initStart_location_id(dbresult.getLong("start_location_id"));
                contract.initTitle(dbresult.getString("title"));
                contract.initType(dbresult.getString("type"));
                contract.initVolume(dbresult.getDouble("volume"));
                contract.initPage(dbresult.getInt("page"));
                contract.initActive(dbresult.getBoolean("active"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return contract;
    }

}

