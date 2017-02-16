package fowler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMapper {

    protected DbSingleton dbSingleton = DbSingleton.getInstance();

    protected Map loadedMap = new HashMap();

    abstract protected String findStatement();

    protected DomainObject abstractFind(Long id) {
        DomainObject result = (DomainObject) loadedMap.get(id);
        if(result != null) return result;
        PreparedStatement findStatement;
        Connection conn = dbSingleton.getConnection();
        try {
            findStatement = conn.prepareStatement(findStatement());
            findStatement.setLong(1, id);
            ResultSet rs = findStatement.executeQuery();
            rs.next();
            result = load(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    protected DomainObject load(ResultSet rs) {
        DomainObject result = null;
        try {
            Long id = rs.getLong(1);
            if(loadedMap.containsKey(id)) return (DomainObject) loadedMap.get(id);
            result = doLoad(id, rs);
            loadedMap.put(id, result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    protected DomainObject doLoad(Long id, ResultSet rs) {
        try {
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            int numberOfDependents = rs.getInt(4);
            return new Person(id, firstName, lastName, numberOfDependents);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
