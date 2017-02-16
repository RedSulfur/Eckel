package fowler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonMapper extends AbstractMapper {

    private static final String COLUMNS = "id, firstname, lastname, number_of_dependants";
    private static final String UPDATE_STATEMENT_STRING = "UPDATE people " +
            "SET firstname = ?, lastname = ?, number_of_dependents = ? WHERE id = ?";

    protected String findStatement() {
        return "SELECT " + COLUMNS +
                " FROM people WHERE id = ?";
    }

    public Person find(Long id) {
        return (Person) abstractFind(id);
    }

    public void update(Person person) {
        PreparedStatement updateStatement = null;
        Connection conn = null;
        try {
            conn = dbSingleton.getConnection();
            updateStatement = conn.prepareStatement(UPDATE_STATEMENT_STRING);
            updateStatement.setString(1, person.getFirstName());
            updateStatement.setString(2, person.getLastName());
            updateStatement.setInt(3, person.getNumberOfDependants());
            updateStatement.setLong(4, person.getId());
            updateStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
