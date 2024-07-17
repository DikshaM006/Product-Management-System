import java.util.*;
import java.util.stream.Collectors;

public class ProductDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductDuo pd = new ProductDuo();
		while (true) {
			System.out.println("1.save Product");
			System.out.println("2.update Product");
			System.out.println("3.find Product by ID");
			System.out.println("4.display Product");
			System.out.println("5.delete Product");
			System.out.println("6. Exit");
			System.out.print("Enter your choice:");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				pd.saveProduct(pd.p);
			}
				break;
			case 2: {

				pd.updateProduct(pd.p);
			}
				break;
			case 3: {
				System.out.println("Enter id:");
				int id = sc.nextInt();

				pd.findById(id);
			}
			break;
			case 4:{
				pd.displayAll().forEach(System.out::println);;
			}
			case 5:{
				System.out.print("Enter id to Delete:");
				int id = sc.nextInt();
				pd.deleteProduct(id);
			}
			break;
			case 6: {
				System.exit(0);
			}
			}
		}
	}
	
	
}
