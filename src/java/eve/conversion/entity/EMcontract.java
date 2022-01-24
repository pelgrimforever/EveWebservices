/*
 * EMcontract.java
 *
 * Created on Okt 8, 2021
 * Generated on 2.0.2022 18:23
 *
 */
package eve.conversion.entity;

import data.interfaces.db.LogicEntity;
import eve.conversion.entity.def.EMcontract_default;
import eve.logicentity.Contract;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMcontract
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMcontract extends EMcontract_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
//Custom code, do not change this line
    public static final String SQLSelectAll = SQLSelect + OrderBy;
    public static final String SQLtruncate = "truncate contractitem, contract";
    public static final String SQLdeactivate = "update contract set active = false";
    public static final String SQLactivatecontract = "update contract set active = true where " + SQLWhere1;
    public static final String SQLdeletedeactivatedcontacts = "delete from contract where not active";
    
    public static final String SQLcontracts4type = SQLSelect + " where type = :type:";
//Custom code, do not change this line

    /**
     * Map ResultSet Field values to Contract
     * @param dbresult: Database ResultSet
     * @return Contract
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Contract contract = (Contract)super.mapResultSet2Entity(dbresult);
        return contract;
    }    
    
}
