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
import eve.conversion.entity.EMconstellation_neighbour;
import eve.BusinessObject.Logic.*;
import eve.entity.pk.*;
import eve.interfaces.logicentity.*;
import eve.interfaces.entity.pk.*;
import eve.interfaces.searchentity.IConstellation_neighboursearch;
import eve.logicentity.Constellation_neighbour;

public abstract class Bconstellation_neighbour extends TableBusinessrules {

    public Bconstellation_neighbour(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMconstellation_neighbour()));
    }

    public Bconstellation_neighbour(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMconstellation_neighbour()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IConstellation_neighbour newConstellation_neighbour() {
    	return new Constellation_neighbour();
    }
    
    public IConstellation_neighbour newConstellation_neighbour(long constellation, long neighbour) {
        return new Constellation_neighbour(constellation, neighbour);
    }

    public IConstellation_neighbour newConstellation_neighbour(IConstellation_neighbourPK constellation_neighbourPK) {
        return new Constellation_neighbour((Constellation_neighbourPK)constellation_neighbourPK);
    }

    public IConstellation_neighbourPK newConstellation_neighbourPK() {
        return new Constellation_neighbourPK();
    }

    public IConstellation_neighbourPK newConstellation_neighbourPK(long constellation, long neighbour) {
        return new Constellation_neighbourPK(constellation, neighbour);
    }

    public ArrayList<Constellation_neighbour> getConstellation_neighbours() throws DBException {
        return (ArrayList<Constellation_neighbour>)tableio.getEntities(EMconstellation_neighbour.SQLSelectAll);
    }

    public Constellation_neighbour getConstellation_neighbour(IConstellation_neighbourPK constellation_neighbourPK) throws DBException {
        return (Constellation_neighbour)tableio.getEntity((Constellation_neighbourPK)constellation_neighbourPK);
    }

    public ArrayList<Constellation_neighbour> searchconstellation_neighbours(IConstellation_neighboursearch search) throws DBException {
        return (ArrayList<Constellation_neighbour>)tableio.search(search);
    }

    public ArrayList<Constellation_neighbour> searchconstellation_neighbours(IConstellation_neighboursearch search, String orderby) throws DBException {
        return (ArrayList<Constellation_neighbour>)tableio.search(search, orderby);
    }

    public boolean getConstellation_neighbourExists(IConstellation_neighbourPK constellation_neighbourPK) throws DBException {
        return tableio.getEntityExists((Constellation_neighbourPK)constellation_neighbourPK);
    }

    public Constellation_neighbour getEntity(String sql) throws DBException {
        return (Constellation_neighbour)tableio.getEntity(sql);
    }
    
    public Constellation_neighbour getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Constellation_neighbour)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Constellation_neighbour> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Constellation_neighbour> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Constellation_neighbour> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Constellation_neighbour> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertConstellation_neighbour(SQLTqueue transactionqueue, IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, constellation_neighbour);
    }

    public void insertupdateConstellation_neighbour(SQLTqueue transactionqueue, IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
    	checkDATA(constellation_neighbour);
        if(this.getConstellation_neighbourExists(constellation_neighbour.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, constellation_neighbour);
        } else {
            tableio.insertEntity(transactionqueue, constellation_neighbour);
        }
    }

    public void updateConstellation_neighbour(SQLTqueue transactionqueue, IConstellation_neighbour constellation_neighbour) throws DBException, DataException {
    	checkDATA(constellation_neighbour);
        tableio.updateEntity(transactionqueue, constellation_neighbour);
    }

    public void deleteConstellation_neighbour(SQLTqueue transactionqueue, IConstellation_neighbour constellation_neighbour) throws DBException {
        cascadedeleteConstellation_neighbour(transactionqueue, constellation_neighbour.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, constellation_neighbour);
    }

    private void checkDATA(IConstellation_neighbour constellation_neighbour) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Constellation_neighbour.Constellation - Constellation.Id
        //foreign key Constellation_neighbour.Neighbour - Constellation.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteConstellation_neighbour(SQLTqueue transactionqueue, IConstellation_neighbourPK constellation_neighbourPK) {
    }

    public void delete4constellationNeighbour(SQLTqueue transactionqueue, IConstellationPK constellationPK) {
        tableio.addStatement(transactionqueue, EMconstellation_neighbour.SQLDelete4constellationNeighbour, constellationPK.getSQLprimarykey());
    }

    public ArrayList<Constellation_neighbour> getConstellation_neighbours4constellationNeighbour(IConstellationPK constellationPK) throws CustomException {
        return tableio.getEntities(EMconstellation_neighbour.SQLSelect4constellationNeighbour, constellationPK.getSQLprimarykey());
    }
    public void delete4constellationConstellation(SQLTqueue transactionqueue, IConstellationPK constellationPK) {
        tableio.addStatement(transactionqueue, EMconstellation_neighbour.SQLDelete4constellationConstellation, constellationPK.getSQLprimarykey());
    }

    public ArrayList<Constellation_neighbour> getConstellation_neighbours4constellationConstellation(IConstellationPK constellationPK) throws CustomException {
        return tableio.getEntities(EMconstellation_neighbour.SQLSelect4constellationConstellation, constellationPK.getSQLprimarykey());
    }

    public ArrayList<Constellation_neighbour> getConstellation_neighbours(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMconstellation_neighbour.SQLSelect);
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
        return (ArrayList<Constellation_neighbour>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delConstellation_neighbour(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Constellation_neighbour.table);
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
