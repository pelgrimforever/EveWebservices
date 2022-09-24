/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:38
 * @author Franky Laseure
 */

package eve.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import eve.conversion.entity.EMconstellation;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IConstellationsearch;
import eve.logicentity.Constellation;

public abstract class Bconstellation extends TableBusinessrules {

    public Bconstellation(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMconstellation()));
    }

    public Bconstellation(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMconstellation()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IConstellation newConstellation() {
    	return new Constellation();
    }
    
    public IConstellation newConstellation(long id) {
        return new Constellation(id);
    }

    public IConstellation newConstellation(IConstellationPK constellationPK) {
        return new Constellation((ConstellationPK)constellationPK);
    }

    public IConstellationPK newConstellationPK() {
        return new ConstellationPK();
    }

    public IConstellationPK newConstellationPK(long id) {
        return new ConstellationPK(id);
    }

    public ArrayList<Constellation> getConstellations() throws DBException {
        return (ArrayList<Constellation>)tableio.getEntities(EMconstellation.SQLSelectAll);
    }

    public Constellation getConstellation(IConstellationPK constellationPK) throws DBException {
        return (Constellation)tableio.getEntity((ConstellationPK)constellationPK);
    }

    public ArrayList<Constellation> searchconstellations(IConstellationsearch search) throws DBException {
        return (ArrayList<Constellation>)tableio.search(search);
    }

    public ArrayList<Constellation> searchconstellations(IConstellationsearch search, String orderby) throws DBException {
        return (ArrayList<Constellation>)tableio.search(search, orderby);
    }

    public boolean getConstellationExists(IConstellationPK constellationPK) throws DBException {
        return tableio.getEntityExists((ConstellationPK)constellationPK);
    }

    public Constellation getEntity(String sql) throws DBException {
        return (Constellation)tableio.getEntity(sql);
    }
    
    public Constellation getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Constellation)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Constellation> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Constellation> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Constellation> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Constellation> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertConstellation(SQLTqueue transactionqueue, IConstellation constellation) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, constellation);
    }

    public void insertupdateConstellation(SQLTqueue transactionqueue, IConstellation constellation) throws DBException, DataException {
    	checkDATA(constellation);
        if(this.getConstellationExists(constellation.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, constellation);
        } else {
            tableio.insertEntity(transactionqueue, constellation);
        }
    }

    public void updateConstellation(SQLTqueue transactionqueue, IConstellation constellation) throws DBException, DataException {
    	checkDATA(constellation);
        tableio.updateEntity(transactionqueue, constellation);
    }

    public void deleteConstellation(SQLTqueue transactionqueue, IConstellation constellation) throws DBException {
        cascadedeleteConstellation(transactionqueue, constellation.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, constellation);
    }

    private void checkDATA(IConstellation constellation) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(constellation.getName()!=null && constellation.getName().length()>IConstellation.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(IConstellation.SIZE_NAME).append("\n");
        }
        if(constellation.getName()==null) {
            message.append("Name mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteConstellation(SQLTqueue transactionqueue, IConstellationPK constellationPK) {
        BLconstellation_neighbour blconstellation_neighbourNeighbour = new BLconstellation_neighbour(this);
        blconstellation_neighbourNeighbour.setAuthenticated(isAuthenticated());
        blconstellation_neighbourNeighbour.delete4constellationNeighbour(transactionqueue, constellationPK);
        BLconstellation_neighbour blconstellation_neighbourConstellation = new BLconstellation_neighbour(this);
        blconstellation_neighbourConstellation.setAuthenticated(isAuthenticated());
        blconstellation_neighbourConstellation.delete4constellationConstellation(transactionqueue, constellationPK);
    }

    public void delete4region(SQLTqueue transactionqueue, IRegionPK regionPK) {
        tableio.addStatement(transactionqueue, EMconstellation.SQLDelete4region, regionPK.getSQLprimarykey());
    }

    public ArrayList<Constellation> getConstellations4region(IRegionPK regionPK) throws CustomException {
        return tableio.getEntities(EMconstellation.SQLSelect4region, regionPK.getSQLprimarykey());
    }
    public Constellation getConstellation_neighbourneighbour(IConstellation_neighbourPK constellation_neighbourPK) throws CustomException {
        ConstellationPK constellationPK = new ConstellationPK(constellation_neighbourPK.getNeighbour());
        return this.getConstellation(constellationPK);
    }

    public Constellation getConstellation_neighbourconstellation(IConstellation_neighbourPK constellation_neighbourPK) throws CustomException {
        ConstellationPK constellationPK = new ConstellationPK(constellation_neighbourPK.getConstellation());
        return this.getConstellation(constellationPK);
    }


    public ArrayList<Constellation> getConstellations(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMconstellation.SQLSelect);
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
        return (ArrayList<Constellation>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delConstellation(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Constellation.table);
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
