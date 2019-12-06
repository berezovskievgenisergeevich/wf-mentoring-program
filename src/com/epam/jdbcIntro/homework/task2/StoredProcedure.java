package com.epam.jdbcIntro.homework.task2;

import com.epam.jdbcIntro.homework.task1.MyFirstConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StoredProcedure {
    static String proc1 = "CREATE PROCEDURE test_print() " +
            "SELECT * FROM products ";
    static String proc2 = "create PROCEDURE printProduct(productId INT)\n" +
            "select * from products where id = productId";

    public static void main(String[] args) throws SQLException {
        Connection connection = MyFirstConnection.getConnection();


        // callProductCountProcedure(connection);

        createProcedures(connection, proc1);
        callProductSummaryProcedure(connection, "ProductSummary");

        createProcedures(connection, proc2);
        callPrintProductProc(connection, 2);

        printAllProcedureName(connection);

        dropAllProcedure(connection);

    }

    private static void callPrintProductProc(Connection connection, int number) throws SQLException {
        try (CallableStatement call = connection.prepareCall("{call printProduct(" + number + ")}")) {
            call.execute();
            printProduct(call);
        }
    }

    /**
     * Prints all data from the table - products
     *
     * @param connection
     * @throws SQLException
     */
    private static void callProductSummaryProcedure(Connection connection, String procName) throws SQLException {
        try (CallableStatement proc = connection.prepareCall("{call " + procName + "}")) {
            proc.execute();
            printProduct(proc);
        }
    }

    /**
     * Returns the number of records from the table - products
     * <p>
     * PROCEDURE:
     * <p>
     * create PROCEDURE ProductCount(OUT cnt INT)
     * <p>
     * select count(*) into cnt from products
     * <p>
     *
     * @param connection to MS_SQL
     * @throws SQLException
     */
    private static void callProductCountProcedure(Connection connection) throws SQLException {
        try (CallableStatement call = connection.prepareCall("{call ProductCount(?)}")) {
            call.registerOutParameter(1, Types.INTEGER);
            call.execute();
            System.out.println(call.getInt(1));
        }
    }

    public static void createProcedures(Connection con, String procedure) throws SQLException {
        dropProcedure(con, getProcedureName(procedure));
        try (Statement statement = con.createStatement()) {
            statement.executeUpdate(procedure);
        }
    }

    /**
     * Get  all stored procedure in your database
     *
     * @param connection
     * @return
     * @throws SQLException
     */
    private static List<String> getProcNames(Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        List<String> procNames = new ArrayList<>();
        try (ResultSet rs = metaData.getProcedures(null, null, "%")) {
            while (rs.next()) {
                procNames.add(rs.getString(3));
            }
            return procNames;
        }
    }

    /**
     * Print out all stored procedure in your database
     *
     * @param connection
     */
    public static void printAllProcedureName(Connection connection) {
        try {
            getProcNames(connection).forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void dropProcedure(Connection con, String procedureName) throws SQLException {
        String queryDrop = "DROP PROCEDURE IF EXISTS " + procedureName;
        try (Statement stmtDrop = con.createStatement()) {
            System.out.println("Calling DROP PROCEDURE");
            stmtDrop.execute(queryDrop);
        }
    }

    public static void dropAllProcedure(Connection connection) throws SQLException {
        getProcNames(connection).forEach(name -> {
            try {
                dropProcedure(connection, name);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private static String getProcedureName(String data) {
        Pattern pattern = Pattern.compile("(\\w*)[(]");
        Matcher matcher = pattern.matcher(data);
        matcher.find();
        return matcher.group(1);
    }

    private static void printProduct(CallableStatement call) throws SQLException {
        ResultSet rs = call.getResultSet();
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
    }
}
