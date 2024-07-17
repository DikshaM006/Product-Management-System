import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDuo {
	Product p = new Product();
	String url = "jdbc:postgresql://localhost:5432/eca_jdbc";
	String username = "postgres";
	String password = "root";
	Scanner sc = new Scanner(System.in);

	void saveProduct(Product product) {
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(url, username, password);

			// Statement smt=con.createStatement();

			System.out.print("Enter pid:");
			product.setPid(sc.nextInt());
			sc.nextLine();

			System.out.print("Enter pname:");
			product.setPname(sc.nextLine());

			System.out.print("Enter ptype:");
			product.setPtype(sc.nextLine());

			System.out.print("Enter pcost:");
			product.setPcost(sc.nextDouble());

			String sql = "INSERT INTO product VALUES(?,?,?,?)";

			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, product.getPid());
			psmt.setString(2, product.getPname());
			psmt.setString(3, product.getPtype());
			psmt.setDouble(4, product.getPcost());

			psmt.execute();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	void updateProduct(Product product) {

		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(url, username, password);

			while (true) {
				System.out.println("1.update name");
				System.out.println("2.update type");
				System.out.println("3.update cost");
				System.out.println("4.exit");
				System.out.print("Enter your choice:");
				int choice = sc.nextInt();sc.nextLine();
				switch (choice) {
				case 1: {
					 System.out.print("Enter new name:");
                     String newName = sc.nextLine();
                     System.out.print("Enter id:");
                     int id1=sc.nextInt();

                     String sql = "UPDATE product SET Pname = ? WHERE Pid = ?";
                     PreparedStatement psmt = con.prepareStatement(sql);
                     psmt.setString(1, newName); // Set first parameter as name
                     psmt.setInt(2, id1); // Set second parameter as PID

                     int res=psmt.executeUpdate(); // Use executeUpdate() for UPDATE
                     if(res>0)
                     {

                         System.out.println("Name updated successfully");
                        
                     } else {
                     	System.out.println("id does not exist");
                     }
				}
					break;
				case 2: {
					System.out.print("Enter new type:");
                    String newType = sc.nextLine();
                    System.out.print("Enter id:");
                    int id1=sc.nextInt();

                    String sql = "UPDATE product SET Ptype = ? WHERE Pid = ?";
                    PreparedStatement psmt = con.prepareStatement(sql);
                    psmt.setString(1, newType); // Set first parameter as name
                    psmt.setInt(2, id1); // Set second parameter as PID

                    int res=psmt.executeUpdate(); // Use executeUpdate() for UPDATE
                    if(res>0)
                    {

                        System.out.println("Type updated successfully");
                       
                    } else {
                    	System.out.println("id does not exist");
                    }
				}
					break;
				case 3: {
					System.out.print("Enter new Cost:");
					double newCost=sc.nextDouble();
					System.out.print("Enter id:");
                    int id1=sc.nextInt();
                    
                    String sql="UPDATE product SET Pcost=? WHERE Pid=?";
                    PreparedStatement psmt=con.prepareStatement(sql);
                    psmt.setDouble(1, newCost);
                    psmt.setInt(2, id1);
                    
                    int res = psmt.executeUpdate();
                    
                    if(res>0)
                    {

                        System.out.println("Cost updated successfully");
                       
                    } else {
                    	System.out.println("id does not exist");
                    }
				}
				case 4: {
					System.exit(0);
				}
				default:
					System.out.println("Enter valid choice");
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Exception ocuured");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	Product findById(int Pid) {
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con=DriverManager.getConnection(url,username,password);
			
			String sql="SELECT * FROM product WHERE Pid=?";
						
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setInt(1, Pid);
			
			ResultSet rs=psmt.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String type=rs.getString(3);
				double cost=rs.getDouble(4);
				
				System.out.println("ID is: "+id);
			    System.out.println("Name is: "+name);
			    System.out.println("Type is: "+type);
			    System.out.println("Cost is: "+cost);
			    System.out.println("------------------------");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
		
	}
	List<Product>displayAll(){
		List<Product>list=new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con=DriverManager.getConnection(url,username,password);
			
			Statement smt=con.createStatement();
			String sql="SELECT * FROM product";
			ResultSet rs=smt.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String type=rs.getString(3);
				double cost=rs.getDouble(4);
				
				System.out.println("ID is: "+id);
			    System.out.println("Name is: "+name);
			    System.out.println("Type is: "+type);
			    System.out.println("Cost is: "+cost);
			    System.out.println("------------------------");
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deleteProduct(int Pid) {
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con=DriverManager.getConnection(url,username,password);
			
			String sql="DELETE FROM product WHERE Pid=?";
						
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setInt(1, Pid);
			
			psmt.execute();
			con.close();
			System.out.println("Deleted Sucessfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
		
		
	}
}
