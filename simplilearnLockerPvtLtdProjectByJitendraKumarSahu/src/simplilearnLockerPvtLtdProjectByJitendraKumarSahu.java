import java.util.*;
import java.io.*;


class Employee implements Serializable{
	int empno;
	String ename;
	int salary;
	
	Employee(int empno, String ename, int salary){
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
	}
	
	public String toString() {
		return empno+" "+ename+" "+salary;
	}
}
public class simplilearnLockerPvtLtdProjectByJitendraKumarSahu {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String file_1 = System.getProperty("user.dir")+"/EmpData";
		File file5 = new File(file_1);
		file5.mkdir();
		
		int choice = -1;
		Scanner s = new Scanner(System.in);
		Scanner s1 = new Scanner(System.in);
		
		ArrayList<Employee> al = new ArrayList<Employee>();
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ListIterator li = null;
	
		do {
			System.out.println("1. To Display files in Assending Order, Enter 1");
			System.out.println("2. To Add New Employee Details in New File , Enter 2");
			System.out.println("3. To Delete Employee Files, Enter 3");
			System.out.println("4. To Search Employee files, Enter 4");
			System.out.println("5. To View Employee Details from files, 5");
			System.out.println("0. Exit");
			
			System.out.print("Enter Your Choice : ");
			
			choice = s.nextInt();
			
			switch(choice) {
			case 1: 
				///To Display data in to ascending order
				System.out.println("-------------------------------------------------------------------");
				File directoryPath = new File(file_1);
			      //List of all files and directories
			      String contents[] = directoryPath.list();
			      System.out.println("List of files in the specified directory:");
			      for(int i=0; i<contents.length; i++) {
			         System.out.println(contents[i]);
			      }
				System.out.println("-------------------------------------------------------------------");
				
			break;
			case 2:
				//To Add Files
				
				System.out.print("Enter Employee No: ");
				int empno = s.nextInt();
				
				System.out.print("Enter Employee Name: ");
				String ename = s1.nextLine();
				
				System.out.println("Enter Employee Salary: ");
				int salary = s.nextInt();
				
				
				File file = new File(file_1+"/"+ename+".txt");
				if(file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>)ois.readObject();
					ois.close();
				}
				al.add(new Employee(empno,ename,salary));
				
				oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(al);
				oos.close();
										
			break;
			case 3:
				//Delete the file
				System.out.print("Enter Employee Name to Delete : ");
				String ename1 = s1.nextLine();
				File file1 = new File(file_1+"/"+ename1+".txt");
				System.out.println("-------------------------------------------------------------------");
				
					if(file1.isFile()) {
						file1.delete();
						System.out.println("File deleted: "+ file1.getName());
					}
					else {
						System.out.println("File not Exists....!");
					}
				System.out.println("-------------------------------------------------------------------");
			break;
			case 4:
				//Search Employee file
				System.out.print("Enter Employee Name to Search : ");
				String ename2 = s1.nextLine();
				File file2 = new File(file_1+"/"+ename2+".txt");
				System.out.println("-------------------------------------------------------------------");

					if(file2.isFile()) {
						System.out.println("File Name "+ file2);
					}
					else {
						System.out.println("File not Exists....!");
					}
				System.out.println("-------------------------------------------------------------------");
				
			break;

			}
		}while(choice!=0);
	}

}
