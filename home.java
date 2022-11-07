import java.sql.*;
import java.util.Scanner;

public class home {

            public static void main(String args[])
            {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeautomationdb","root","");

                }
                catch (Exception e){
                    System.out.println(e);
                }
                int choice;
                 String date                      ;
                int temprature,hummidity,moisture;
                Scanner s= new Scanner(System.in);
                while(true){
                    System.out.println("select any option");
                    System.out.println("1.insert");
                    System.out.println("2.view");
                    System.out.println("3.search");
                    System.out.println("4.exit");
                    System.out.println("enter the choice");
                    choice = s.nextInt();
                    switch (choice)
                    {
                        case 1:
                            System.out.println("insertdata");
                            System.out.println("enter tempreature");
                            temprature=s.nextInt();
                            System.out.println("enter  hummidity");
                            hummidity=s.nextInt();
                            System.out.println("enter ingridents");
                            moisture=s.nextInt();
                            System.out.println("enter date");
                            date=s.next();

                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipedb","root","");

                                String sql="INSERT INTO `sensorvalue`(`id`, `temprature`, `hummidity`, `moisture`, `date`) VALUES (?,?,?,?)";
                                PreparedStatement stmt = con.prepareStatement(sql);
                                stmt.setInt(1,temprature);
                                stmt.setInt(2,hummidity);
                                stmt.setInt(3,moisture);
                                stmt.setString(5,date);

                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                        case 2:
                            System.out.println("select data");
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeautomationdb","root","");
                                String sql="SELECT  `temprature`, `hummidity`, `moisture`, `date` FROM `sensorvalue`";
                                Statement stmt = con.createStatement();
                                ResultSet rs= stmt.executeQuery(sql);
                                while (rs.next()){
                                    String gettemprature=rs.getString("temprature");
                                    String gethummidity=rs.getString("hummidity");
                                    String getmoisture=rs.getString("moisture");
                                    String getdate=rs.getString("date");
                                    System.out.println("temprature="+gettemprature);
                                    System.out.println("preparedby="+gethummidity);
                                    System.out.println("moisture="+getmoisture);
                                    System.out.println("date="+getdate);

                                }

                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                        case 3:
                            System.out.println("search selected");
                            System.out.println("Enter the date : ");
                            date = s.next();
                            try {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeautomationdb","root","");
                                String sql = "SELECT `id`, `temprature`, `hummidity`, `moisture`, `date` FROM `sensorvalue` WHERE`date`='"+date+"'";
                                Statement stmt = con.createStatement();
                                ResultSet rs = stmt.executeQuery(sql);
                                while (rs.next()) {
                                    String getTemp = rs.getString("temprature");
                                    String getHum = rs.getString("hummidity");
                                    String getMoi = rs.getString("moisture");
                                    String getDate = rs.getString("date");
                                    System.out.println("temprature=" + getTemp);
                                    System.out.println("hummidity=" + getHum);
                                    System.out.println("moisture=" + getMoi);
                                    System.out.println("date=" + getDate + "\n");
                                }
                            }
                            catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 4:
                            System.out.println("exit");
                            break;

                            }

                    }
                }
            }








