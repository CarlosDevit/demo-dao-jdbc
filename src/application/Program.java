package application;

import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Program {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();

            /* st = conn.prepareStatement(
                    "insert into seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + "values"
                    + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            st.setString(1, "Carl Purple");
            st.setString(2, "carl@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4);*/
            st = conn.prepareStatement("insert into txt (Name) values ('Carlos'), ('Devit')",
                     Statement.RETURN_GENERATED_KEYS);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {

                rs = st.getGeneratedKeys();

                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);

                }
                System.out.println("Rows Affected: " + rowsAffected);

            } else {

                System.out.println("No Rows Affected! ");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            DB.closeConnection();
            DB.closeResultSet(rs);
            DB.closeStatement(st);

        }

    }

}