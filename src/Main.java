import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/alo";
        String usr = "root";
        String pss = "169169";
        Scanner myObj = new Scanner(System.in);

        System.out.println("enter number 1 for get all the data");
        System.out.println("enter number 2 to add an emp");
        System.out.println("enter number 3 to delete an emp");
        System.out.println("enter number 4 to update an emp");
        System.out.println("enter number 5 to search for an emp");
        System.out.println("**********************************************");
        for (int i = 0;;i++) {
            System.out.print("Enter a number: ");

            int no = myObj.nextInt();  // Read user input
            switch (no) {
                case 1:
                    try {
                        //get connection to database
                        Connection myconn = DriverManager.getConnection(url, usr, pss);
                        //create a statement
                        PreparedStatement mystt = myconn.prepareStatement("SELECT * FROM alo.coustomers");
                        //exe a sql code
                        ResultSet myres = mystt.executeQuery("SELECT * FROM alo.coustomers");
                        //process
                        while (myres.next()) {
                            System.out.println(myres.getString("custID") + " " + myres.getString("custname") + " " + myres.getString("custphon"));
                        }
                        myconn.close();
                    } catch (Exception exc) {
                        System.out.println(exc);
                    }   break;
                case 2:
                {
                    int id = myObj.nextInt();  // Read user input
                    myObj.nextLine();
                    String name = myObj.nextLine();  // Read user input
                    int phone = myObj.nextInt();  // Read user input
                    myObj.nextLine();
                    try {
                        //get connection to database
                        Connection myconn = DriverManager.getConnection(url, usr, pss);
                        //create a statement
                        String sql = "INSERT INTO `alo`.`coustomers` (`custname`, `custID`, `custphon`) VALUES (?,?,?)";
                        PreparedStatement mystt = myconn.prepareStatement(sql);
                        //exe a sql code

                        //process
                        mystt.setString(1, name);
                        mystt.setInt(2,id);
                        mystt.setInt(3, phone);

                        int rows = mystt.executeUpdate();
                        if (rows >0){
                            System.out.println("success");
                        }
                        myconn.close();
                    } catch (Exception exc) {
                        System.out.println(exc);
                    }       break;
                }
                case 3:
                {
                    int id = myObj.nextInt();  // Read user input
                    myObj.nextLine();
                    try {
                        //get connection to database
                        Connection myconn = DriverManager.getConnection(url, usr, pss);
                        //create a statement
                        PreparedStatement mystt = myconn.prepareStatement("delete FROM bank.customers where custID = ?");
                        //exe a sql code
                        //process

                        mystt.setInt(1, id);
                        mystt.executeUpdate();
                        myconn.close();


                    } catch (Exception exc) {
                        System.out.println(exc);
                    }       break;
                }
                case 4:
                {
                    int id = myObj.nextInt();  // Read user input
                    myObj.nextLine();
                    String name = myObj.nextLine();  // Read user input
                    String email = myObj.nextLine();  // Read user input
                    try {
                        //get connection to database
                        Connection myconn = DriverManager.getConnection(url, usr, pss);
                        //create a statement    //exe a sql code
                        PreparedStatement mystt = myconn.prepareStatement("UPDATE bank.customers SET custphon = ? ,customer_name = ?where custID = ?");
                        //process

                        mystt.setInt(3, id);
                        mystt.setString(1, name);
                        mystt.setString(2, email);

                        mystt.executeUpdate();
                        myconn.close();

                    } catch (Exception exc) {
                        System.out.println(exc);
                    }       break;
                }
                case 5:
                    try {
                        int id = myObj.nextInt();  // Read user input
                        myObj.nextLine();

                        //get connection to database
                        Connection myconn = DriverManager.getConnection(url, usr, pss);
                        //create a statement
                        PreparedStatement mystt=myconn.prepareStatement("SELECT * FROM bank.customers WHERE custID = ?");
                        //exe a sql code

                        //process
                        mystt.setInt(1, id);
                        mystt.executeUpdate();

                        myconn.close();
                    } catch (Exception exc) {
                        System.out.println(exc);
                    }   break;
                default:
                    System.out.println("wrong input");
                    break;
            }
        }
    }
}