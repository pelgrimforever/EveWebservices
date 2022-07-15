/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 13.6.2022 11:21
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMcorporation;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.ICorporationsearch;
import eve.logicentity.Corporation;

/**
 * @author Franky Laseure
 */
public abstract class Bcorporation extends TableBusinessrules {

    public Bcorporation(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMcorporation()));
    }

    public Bcorporation(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMcorporation()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ICorporation newCorporation() {
    	return new Corporation();
    }
    
    public ICorporation newCorporation(long id) {
        return new Corporation(id);
    }

    public ICorporation newCorporation(ICorporationPK corporationPK) {
        return new Corporation((CorporationPK)corporationPK);
    }

    public ICorporationPK newCorporationPK() {
        return new CorporationPK();
    }

    public ICorporationPK newCorporationPK(long id) {
        return new CorporationPK(id);
    }

    public ArrayList<Corporation> getCorporations() throws DBException {
        return (ArrayList<Corporation>)tableio.getEntities(EMcorporation.SQLSelectAll);
    }

    public Corporation getCorporation(ICorporationPK corporationPK) throws DBException {
        return (Corporation)tableio.getEntity((CorporationPK)corporationPK);
    }

    public ArrayList<Corporation> searchcorporations(ICorporationsearch search) throws DBException {
        return (ArrayList<Corporation>)tableio.search(search);
    }

    public ArrayList<Corporation> searchcorporations(ICorporationsearch search, String orderby) throws DBException {
        return (ArrayList<Corporation>)tableio.search(search, orderby);
    }

    public boolean getCorporationExists(ICorporationPK corporationPK) throws DBException {
        return tableio.getEntityExists((CorporationPK)corporationPK);
    }

    public Corporation getEntity(String sql) throws DBException {
        return (Corporation)tableio.getEntity(sql);
    }
    
    public Corporation getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Corporation)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Corporation> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Corporation> getEntities(String sql, SQLparameters parameters) throws DBException {
        return tableio.getEntities(sql, parameters);
    }

    public long count() throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }
    
    public long count(String sql, SQLparameters parameters) throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }

    public ArrayList<Corporation> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Corporation> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertCorporation(SQLTqueue transactionqueue, ICorporation corporation) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, corporation);
    }

    public void insertupdateCorporation(SQLTqueue transactionqueue, ICorporation corporation) throws DBException, DataException {
    	checkDATA(corporation);
        if(this.getCorporationExists(corporation.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, corporation);
        } else {
            tableio.insertEntity(transactionqueue, corporation);
        }
    }

    public void updateCorporation(SQLTqueue transactionqueue, ICorporation corporation) throws DBException, DataException {
    	checkDATA(corporation);
        tableio.updateEntity(transactionqueue, corporation);
    }

    public void deleteCorporation(SQLTqueue transactionqueue, ICorporation corporation) throws DBException {
        cascadedeleteCorporation(transactionqueue, corporation.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, corporation);
    }

    private void checkDATA(ICorporation corporation) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(corporation.getName()!=null && corporation.getName().length()>ICorporation.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ICorporation.SIZE_NAME).append("\n");
        }
        if(corporation.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(corporation.getTicker()!=null && corporation.getTicker().length()>ICorporation.SIZE_TICKER) {
            message.append("Ticker is langer dan toegestaan. Max aantal karakters: ").append(ICorporation.SIZE_TICKER).append("\n");
        }
        if(corporation.getTicker()==null) {
            message.append("Ticker mag niet leeg zijn.\n");
        }
        if(corporation.getDescription()!=null && corporation.getDescription().length()>ICorporation.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(ICorporation.SIZE_DESCRIPTION).append("\n");
        }
        if(corporation.getUrl()!=null && corporation.getUrl().length()>ICorporation.SIZE_URL) {
            message.append("Url is langer dan toegestaan. Max aantal karakters: ").append(ICorporation.SIZE_URL).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where corporationPK is used in a primary key
     * @param corporationPK: Corporation primary key
     */
    public void cascadedeleteCorporation(SQLTqueue transactionqueue, ICorporationPK corporationPK) {
    }

    public void delete4station(SQLTqueue transactionqueue, IStationPK stationPK) {
        tableio.addStatement(transactionqueue, EMcorporation.SQLDelete4station, stationPK.getSQLprimarykey());
    }

    public ArrayList<Corporation> getCorporations4station(IStationPK stationPK) throws CustomException {
        return tableio.getEntities(EMcorporation.SQLSelect4station, stationPK.getSQLprimarykey());
    }
    public void delete4faction(SQLTqueue transactionqueue, IFactionPK factionPK) {
        tableio.addStatement(transactionqueue, EMcorporation.SQLDelete4faction, factionPK.getSQLprimarykey());
    }

    public ArrayList<Corporation> getCorporations4faction(IFactionPK factionPK) throws CustomException {
        return tableio.getEntities(EMcorporation.SQLSelect4faction, factionPK.getSQLprimarykey());
    }
    public void delete4alliance(SQLTqueue transactionqueue, IAlliancePK alliancePK) {
        tableio.addStatement(transactionqueue, EMcorporation.SQLDelete4alliance, alliancePK.getSQLprimarykey());
    }

    public ArrayList<Corporation> getCorporations4alliance(IAlliancePK alliancePK) throws CustomException {
        return tableio.getEntities(EMcorporation.SQLSelect4alliance, alliancePK.getSQLprimarykey());
    }

    public ArrayList<Corporation> getCorporations(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMcorporation.SQLSelect);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        if(sortlist.length()>0) {
            sql.append(" order by ").append(sortlist).append(" ").append(sortoperator);
        }
        return (ArrayList<Corporation>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delCorporation(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Corporation.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
