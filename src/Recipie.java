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
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
                        String sql="SELECT `id`, `name`, `category`, `taste`, `price` FROM `recipe` ";
                        Statement stmt = con.createStatement();
                        ResultSet rs= stmt.executeQuery(sql);
                        while (rs.next()){
                            String getname=rs.getString("name");
                            String getcategory=rs.getString("category");
                            String gettaste=rs.getString("taste");
                            String getprice=rs.getString("price");
                            System.out.println("recipename="+getname);
                            System.out.println("preparedby="+getcategory);
                            System.out.println("ingredients="+gettaste);
                            System.out.println("price="+getprice);
                        }

                    }

                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("search data");
                    System.out.println("enter price:");
                    price=s.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
                        String sql="SELECT `id`, `name`, `category`, `taste`, `price` FROM `recipe` WHERE `price`="+price;
                        Statement stmt = con.createStatement();
                        ResultSet rs= stmt.executeQuery(sql);
                        while(rs.next()){
                            String getname=rs.getString("name");
                            String getcategory=rs.getString("category");
                            String gettaste=rs.getString("taste");
                            String getprice=rs.getString("price");
                            System.out.println("recipename="+getname);
                            System.out.println("preparedby="+getcategory);
                            System.out.println("ingredients="+gettaste);
                            System.out.println("price="+getprice);
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Update the data");
                    System.out.println("Enter the id ");
                    int id = s.nextInt();
                    System.out.println("Name of the food");
                    name = s.next();
                    System.out.println("Category");
                    String cate = s.next();
                    System.out.println("Taste");
                    taste = s.next();
                    System.out.println("price");
                    price = s.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb", "root", "");
                        String sql = "UPDATE `recipe` SET `name`='"+name+"',`category`='"+cate+"',`taste`='"+taste+"',`price`='"+price+"' WHERE `id`="+id;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Updated successfully");

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.println("delete data");
                    System.out.println("enter price:");
                    price = s.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");
                        String sql="DELETE FROM `recipe` WHERE `price`="+price;
                        Statement stmt =con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 6:
                    System.out.println("exit");
                    break;
            }
        }
    }
}
