import java.sql.*;
import java.util.ArrayList;

public class SQLiteJDBC {
    public static Connection connect() { // Connet to the SQlite database
        Connection connection = null;
      
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:customers.db");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return connection;
    }

    public static void updateRow(int id, String name, long contact_no, String email_id){ // Insert record into the database
        String sql = "INSERT INTO customers VALUES('"+id+"', '"+name+"', '"+contact_no+"', '"+email_id+"')";

        try (Connection connect = connect();
             PreparedStatement updateRow = connect.prepareStatement(sql)){
            updateRow.executeUpdate();

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id) { // Delete record from the database
        String sql = "DELETE FROM customers WHERE id = ?";

        try (Connection connect = connect();
             PreparedStatement del = connect.prepareStatement(sql)) {
            del.setInt(1, id);
            del.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update(int old_id, int id, String name, long contact_no, String email_id) { // Update record into the database
        delete(old_id);
        updateRow(id, name, contact_no, email_id);
    }

    public static ArrayList<Customer> getData() { // Retrieve all records from the database
        ArrayList<Customer> customers= new ArrayList<>();
        Statement stmt = null;
        Connection c;
            try {
                c = connect();
                stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery( "SELECT * FROM customers;" );

                while (rs.next()){
                    customers.add(new Customer(rs.getInt(1),rs.getString(2), rs.getLong(3), rs.getString(4)));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        return customers;
    }

    public static Customer search(int id) { // Search for a record in the database
        ArrayList<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE id = ?";

        try (Connection connect = connect();
             PreparedStatement stmt = connect.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                    customers.add(new Customer(rs.getInt(1),rs.getString(2), rs.getLong(3), rs.getString(4)));
            }

        } catch (SQLException e) {
            System.out.println("Hello");
            System.out.println(e.getMessage());
            System.out.println(e);

        }
        
        if (customers.size() == 0)
            return null;
        else
            return customers.get(0);
    }
}