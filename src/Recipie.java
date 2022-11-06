import java.sql.*;
import java.util.Scanner;
public class Recipie {

    public static void main(String args[])
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
        }
        catch (Exception e){
            System.out.println(e);
        }
        int choice;
        String name,category,taste;                       ;
        int price;
        Scanner s= new Scanner(System.in);
        while(true){
            System.out.println("1.select any option");
            System.out.println("1.insert");
            System.out.println("2.select");
            System.out.println("3.search");
            System.out.println("4.update");
            System.out.println("5.delete");
            System.out.println("6.exit");
            System.out.println("enter the choice");
            choice = s.nextInt();
            switch (choice)
            {

                case 1:
                    System.out.println("insertdata");
                    System.out.println("enter recipe name");
                    name=s.next();
                    System.out.println("enter category");
                    category=s.next();
                    System.out.println("enter taste");
                    taste=s.next();
                    System.out.println("enter price");
                    price=s.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
                        String sql="INSERT INTO `recipe`(`name`, `category`, `taste`, `price`) VALUES (?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,name);
                        stmt.setString(2,category);
                        stmt.setString(3,taste);
                        stmt.setInt(4,price);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;




                case 2:
                    System.out.println("select data");



                    break;
                case 3:
                    System.out.println("search data");

                    break;
                case 4:
                    System.out.println("Update the data");

                    break;
                case 5:
                    System.out.println("delete data");

                    break;
                case 6:
                    System.out.println("exit");
                    break;
            }
        }
    }
}
