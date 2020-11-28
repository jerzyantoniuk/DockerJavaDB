

import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DockerJavaDB {

    static String url = "jdbc:mysql://10.0.10.3:3306/full";
    static String driver="com.mysql.jdbc.Driver";

    public static void main(String[] args) {
        // write your code here
          Class.forName(driver);
        Scanner scanner= new Scanner(System.in);
        CreateTable();
        while(true) {
            getMenu();
            Integer val=Integer.parseInt(scanner.nextLine());
            switch (val) {
                case 1:
                    System.out.println("Wyświetlanie danych");
                    GetData();
                    break;
                case 2:
                    System.out.println("Dodaj osobę");
                    System.out.println("Podaj imie");
                    String imie = scanner.nextLine();
                    System.out.println("Podaj nazwisko");
                    String nazwisko = scanner.nextLine();
                    System.out.println("Podaj adres");
                    String address = scanner.nextLine();
                    System.out.println("Podaj miasto");
                    String miasto = scanner.nextLine();
                    AddData(imie, nazwisko, address, miasto);
                    break;
                case 3:
                    System.out.println("Edytuj");
                    System.out.println("Podaj id");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Podaj imie");
                    String imie2 = scanner.nextLine();
                    System.out.println("Podaj nazwisko");
                    String nazwisko2 = scanner.nextLine();
                    System.out.println("Podaj adres");
                    String address2 = scanner.nextLine();
                    System.out.println("Podaj miasto");
                    String miasto2 = scanner.nextLine();
                    UpdateData(id, imie2, nazwisko2, address2, miasto2);
                    break;
                case 4:
                    System.out.println("Usuwanie");
                    System.out.println("Podaj id");
                    int id3 = Integer.parseInt(scanner.nextLine());
                    DeleteData(id3);
                    break;

                case 5:
                    System.out.println("Wyjście z aplikacji");
                    System.exit(0);

            }
        }


//       DeleteData(1);
    }

    public static void GetData() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, "root", "");
            Statement st = connection.createStatement();
            String sql = "select * from persons";
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("ID: "+resultSet.getInt("ID"));
                System.out.println("FirstName: "+resultSet.getString("FirstName"));
                System.out.println("LastName: "+resultSet.getString("LastName"));
                System.out.println("Address : "+resultSet.getString("Address"));
                System.out.println("City: "+resultSet.getString("City"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void DeleteData(Integer id) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, "root", "");
            Statement st = connection.createStatement();
            String del = "DELETE FROM Persons WHERE ID =('" + id+ "')";
            st.executeUpdate(del);
            connection.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void AddData(String lastName,String firstName,String address,String city) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, "root", "");
            Statement st = connection.createStatement();
            String sqlStatement =
                    "insert into persons(LastName,FirstName,Address,City) values('"+lastName+"','"+firstName+"','"+address+"','"+city+"')";
            System.out.println("Sql "+sqlStatement);
            st.executeUpdate(sqlStatement);
            connection.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static  void CreateTable(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, "root", "");
            Statement st = connection.createStatement();
            String delete="drop table persons";
            String sqlStatement="CREATE TABLE `full`.`persons` ( `ID` INT(6) NULL AUTO_INCREMENT , `LastName` VARCHAR(255) NOT NULL , `FirstName` VARCHAR(255) NOT NULL , `Address` VARCHAR(255) NOT NULL , `City` VARCHAR(255) NOT NULL , PRIMARY KEY (`ID`));";
            st.executeUpdate(delete);
            st.executeUpdate(sqlStatement);
            connection.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void UpdateData(Integer id,String lastName,String firstName,String address,String city) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, "root", "root");
            Statement st = connection.createStatement();
            String sqlStatement =
                    "update persons set LastName='"+lastName+"',FirstName='"+firstName+"',Address='"+address+"',City='"+city+"' where id="+id;
            System.out.println("Sql "+sqlStatement);
            st.executeUpdate(sqlStatement);
            connection.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void getMenu(){
        System.out.println("Menu");
        System.out.println("1. Wyświetlanie danych");
        System.out.println("2.Dodawanie danych");
        System.out.println("3.Aktulizowanie danych");
        System.out.println("4.Usuwanie danych");
        System.out.println("Podaj numer");
    }
}
