import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class MainCitizenInformation {
	
	public static void main(String[] args) {
		
		try {
			
			//create reader
			BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\User\\eclipse-workspace\\FINAL P SWC3344\\src\\citizen.txt"));
			
			//create linkedlist for citizen
			LinkedList<Citizen> citizenList = new LinkedList<>();
            LinkedList<Citizen> completedList = new LinkedList<>();
            
            LinkedList<Citizen> groupList1 = new LinkedList<>();
            LinkedList<Citizen> groupList2 = new LinkedList<>();
            LinkedList<Citizen> groupList3 = new LinkedList<>();
            
            LinkedList<Citizen> firstdoseComp1 = new LinkedList<>();
            LinkedList<Citizen> firstdoseComp2 = new LinkedList<>();
            LinkedList<Citizen> firstdoseComp3 = new LinkedList<>();
            
            //create stack to divide citizen 
            Stack<Citizen> stCenter1 = new Stack<>();
            Stack<Citizen> stCenter2 = new Stack<>();
            Stack<Citizen> stCenter3 = new Stack<>();
            
            //create queue to divide citizen
            Queue<Citizen> qCenter1 = new LinkedList<>();
            Queue<Citizen> qCenter2 = new LinkedList<>();
            Queue<Citizen> qCenter3 = new LinkedList<>();
            
            Citizen citizen; //declare object name
            String indata = null; //declare indata
            
            //read file Vaccine.txt
            while((indata = in.readLine())!=null) {
            	
            	StringTokenizer st = new StringTokenizer(indata, ";");
                String name = st.nextToken();
                String ic = st.nextToken();
                String state = st.nextToken();
                int age = Integer.parseInt(st.nextToken());
                String category = st.nextToken();
                String FirstDoseStatus = st.nextToken();
                String SecondDoseStatus = st.nextToken();
                String certificate = st.nextToken();
                
                //create object
                citizen = new Citizen(name, ic, state, age, category, FirstDoseStatus, SecondDoseStatus, certificate);
                //add into citizenlist
                citizenList.add(citizen);
                
            }in.close();
            
            int main_menu = 0;
            
            do {
            	
            	main_menu = Integer.parseInt(JOptionPane.showInputDialog("Please Choose The Following Menu : \n Menu 1 - Add New Recipient \n Menu 2 - Remove Recipient \n Menu 3 - Choose Center \n Menu 4 - Exit"));
            	
            	if(main_menu == 1) { //menu to add recipient
            		
            		//ask user to enter recipient data
            		String name = JOptionPane.showInputDialog("Enter Recipient Name : ");
            		String ic = JOptionPane.showInputDialog("Enter Recipient IC: ");
            		String state = JOptionPane.showInputDialog("Enter Recipient State : ");
                    int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Recipient Age Above 18 Years Old : "));
                    while(age<18) { 
                    	
                    	//error pop up message to notify user to put correctly
                    	JOptionPane.showMessageDialog(null, "18 years and above are eligible for vaccination!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    	age = Integer.parseInt(JOptionPane.showInputDialog("Enter Recipient Age Above 18 Years Old : "));
                    	
                    }
                    String category = JOptionPane.showInputDialog("Enter Recipient Category ");
                    String FirstDoseStatus = "null";
                    String SecondDoseStatus = "null";
                    String certificate = "null";
                    
                    //create object
                    citizen = new Citizen(name, ic, state, age, category, FirstDoseStatus, SecondDoseStatus, certificate);
                    //add into citizenlist
                    citizenList.addFirst(citizen);
            	}
            	else if(main_menu == 2) { //menu to remove recipient
            		
            		//ask user to enter recipient identification number
            		String ic  = JOptionPane.showInputDialog("Enter Recipient IC : ");
            		for(int i=0;i<citizenList.size();i++) {
            			
            			citizen = citizenList.get(i); //retrieve object
            			if(citizen.getIc().equalsIgnoreCase(ic)) {
            				
            				citizenList.remove(citizen); //remove object
            				
            				}
            			
            			}
            		}
            	
            	else if(main_menu == 3) { //menu to choose st center category that user want to display including recipient that has been remove
            		
            		 while(!citizenList.isEmpty()) {
                         
                         citizen = citizenList.removeLast(); //to remove recipient
                         
                         //to divide st center based on age group
                         if(citizen.getAge()>=18 && citizen.getAge()<=30) {
                             
                             stCenter1.push(citizen);
                         }
                         else if(citizen.getAge()>=31 && citizen.getAge()<=49) {
                             
                             stCenter2.push(citizen);
                         }
                         else if(citizen.getAge()>=50) {
                             
                             stCenter3.push(citizen);
                         }
                     }
            		 
            		 int menu = 0;
            		 do {
            			 
            			 menu = Integer.parseInt(JOptionPane.showInputDialog("Please Choose The Following Menu : \n Menu 1 - stCenter 1 \n Menu 2 - stCenter 2 \n Menu 3 - stCenter 3 \n Menu 4 - Display First Dose Vaccinated \n Menu 5 - Display Fully Vaccinated \n Menu 6 - Return"));
            			 
            			 if(menu == 1) {
            				 
            				 int submenu = 0;
            				 do {
            					 
            					 submenu = Integer.parseInt(JOptionPane.showInputDialog("Menu 1 - Update 1st Dose Vaccination \n Menu 2 - Update 2nd Dose Vaccination \n Menu 3 - Return"));
            					 
            					 if(submenu == 1) { //menu to demo 1st dose completed
            						 
            						 while (!stCenter1.isEmpty()) {
            							 
            							 citizen = stCenter1.pop(); //retrieve recipient in st center 1
            							 if(citizen.getFirstDoseStatus().equalsIgnoreCase("Null")) {
            								 
            								 citizen.setFirstDoseStatus("Completed");
            								 
            								 //add into qCenter1
            								 qCenter1.add(citizen);
            								 //add into firstdoseComp1
            								 firstdoseComp1.add(citizen);
            							 }
            						 }
            						 //to display st Center 1 recipient that have completed their 1st dose vaccination
            						 System.out.println("\t\t\t\t\t\t\t\tstCenter1 Information\n");
            						 System.out.format("\n \t%-23s \t%-9s \t%-16s \t%-8s \t%-15s     %-12s\t   %-16s\t %-19s %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "1ST DOSE", "2ND DOSE", "CERTIFICATE");
            						 System.out.println(firstdoseComp1);
            					 }
            					 else if(submenu == 2) { //menu to demo 2nd dose completed
            						 
            						 while (!qCenter1.isEmpty()) {
            							 
            							 citizen = qCenter1.remove(); //retrieve and remove element
            							 if(citizen.getSecondDoseStatus().equalsIgnoreCase("Null")) {
            								 
            								 citizen.setSecondDoseStatus("Completed");
            								 
            								 if(citizen.getCertificate().equalsIgnoreCase("Null")) {
            									 
            									 citizen.setCertificate("Fully Vaccinated");
            								 }
            								 //add into groupList1
            								 groupList1.add(citizen);
            								 //add into completedList
            								 completedList.add(citizen);
            							 }
            						 }
            						 //to display st Center 1 recipient that have completed their 2nd dose vaccination
            						 System.out.println("\n\t\t\t\t\t\t\t\tstCenter1 Information\n");
            						 System.out.format("\n \t%-23s \t%-9s \t%-16s \t%-8s \t%-15s    %-12s\t   %-16s\t %-19s %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "1ST DOSE", "2ND DOSE", "CERTIFICATE");
            						 System.out.println(groupList1);
            						
            					 }
            					 
            					 
            				 }while (submenu != 3);
            			 }
            			 else if(menu == 2) {
            				 
            				 int submenu = 0;
            				 do {
            					 
            					 submenu = Integer.parseInt(JOptionPane.showInputDialog("Menu 1 - Update 1st Dose Vaccination \n Menu 2 - Update 2nd Dose Vaccination \n Menu 3 - Return"));
            					 
            					 if(submenu == 1) { //menu to demo 1st dose completed
            						 
            						 while (!stCenter2.isEmpty()) {
            							 
            							 citizen = stCenter2.pop(); //retrieve recipient in st center 2
            							 if(citizen.getFirstDoseStatus().equalsIgnoreCase("Null")) {
            								 
            								 citizen.setFirstDoseStatus("Completed");
            								 
            								 //add into qCenter2
            								 qCenter2.add(citizen);
            								 //add into firstdoseComp2
            								 firstdoseComp2.add(citizen);
            							 }
            						 }
            						//to display st Center 2 recipient that have completed their 1st dose vaccination
            						 System.out.println("\n\t\t\t\t\t\t\t\tstCenter2 Information\n");
            						 System.out.format("\n \t%-23s \t%-9s \t%-16s \t%-8s \t%-15s|    %-12s\t   %-16s\t %-19s %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "1ST DOSE", "2ND DOSE", "CERTIFICATE");
            						 System.out.println(firstdoseComp2);
            						 
            					 }
            					 else if(submenu == 2) { //menu to demo 2nd dose completed
            						 
            						 while (!qCenter2.isEmpty()) {
            							 
            							 citizen = qCenter2.remove(); //retrieve and remove element
            							 if(citizen.getSecondDoseStatus().equalsIgnoreCase("Null")) {
            								 
            								 citizen.setSecondDoseStatus("Completed");
            								 
            								 if(citizen.getCertificate().equalsIgnoreCase("Null")) {
            									 
            									 citizen.setCertificate("Fully Vaccinated");
            								 }
            								 //add into groupList2
            								 groupList2.add(citizen);
            								 //add into completedList
            								 completedList.add(citizen);
            							 }
            						 }
            						//to display st Center 2 recipient that have completed their 2nd dose vaccination
            						 System.out.println("\n\t\t\t\t\t\t\t\tstCenter2 Information\n");
            						 System.out.format("\n \t%-23s \t%-9s \t%-16s \t%-8s \t%-15s    %-12s\t   %-16s\t %-19s %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "1ST DOSE", "2ND DOSE", "CERTIFICATE");
            						 System.out.println(groupList2);
            						 
            					 }
            				 }while (submenu != 3);
            			 }
            			 else if(menu == 3) {
            				 
            				 int submenu = 0;
            				 
            				 do {
            					 
            					 submenu = Integer.parseInt(JOptionPane.showInputDialog("Menu 1 - Update 1st Dose Vaccination \n Menu 2 - Update 2nd Dose Vaccination \n Menu 3 - Return"));
            					 
            					 if(submenu == 1) { //menu to demo 1st dose completed
            						 
            						 while (!stCenter3.isEmpty()) {
            							 
            							 citizen = stCenter3.pop(); //retrieve recipient in st center 3
            							 if(citizen.getFirstDoseStatus().equalsIgnoreCase("Null")) {
            								 
            								 citizen.setFirstDoseStatus("Completed");
            								 
            								 //add into qCenter3
            								 qCenter3.add(citizen);
            								 //add into firstdoseComp3
            								 firstdoseComp3.add(citizen);
            							 }
            						 }
            						//to display st Center 3 recipient that have completed their 1st dose vaccination
            						 System.out.println("\n\t\t\t\t\t\t\t\tstCenter3 Information\n");
            						 System.out.format("\n \t%-23s \t%-9s \t%-16s \t%-8s \t%-15s    %-12s\t   %-16s\t %-19s %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "1ST DOSE", "2ND DOSE", "CERTIFICATE");
            						 System.out.println(firstdoseComp3);
            						 
            					 }
            					 else if(submenu == 2) { //menu to demo 2nd dose completed
            						 
            						 while (!qCenter3.isEmpty()) {
            							 
            							 citizen = qCenter3.remove(); //retrieve and remove element
            							 if(citizen.getSecondDoseStatus().equalsIgnoreCase("Null")) {
            								 
            								 citizen.setSecondDoseStatus("Completed");
            								 if(citizen.getCertificate().equalsIgnoreCase("Null")) {
            									 
            									 citizen.setCertificate("Fully Vaccinated");
            								 }
            								 
            								 //add into groupList3
            								 groupList3.add(citizen);
            								 //add into completedList
            								 completedList.add(citizen);
            							 }
            							 
            						 }
            						//to display st Center 3 recipient that have completed their 2nd dose vaccination
            						 System.out.println("\n\t\t\t\t\t\t\t\tstCenter3 Information\n");
            						 System.out.format("\n \t%-23s \t%-9s \t%-16s \t%-8s \t%-15s    %-12s\t   %-16s\t %-19s %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "1ST DOSE", "2ND DOSE", "CERTIFICATE"); 
            						 System.out.println(groupList3);
            						 
            					 }
            					 
            				 }while (submenu != 3);
            				 
            			 }
            			 else if(menu == 4) { //menu to display all citizen that have done vaccinated for 1st dose
            				 
            				 System.out.println("\n\t\t\t\t\t\t\t\t1ST DOSE INFORMATION\n");
    						 System.out.format("\n \t%-23s \t%-9s \t%-16s \t%-8s \t%-15s    %-12s\t   %-16s\t %-19s %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "1ST DOSE", "2ND DOSE", "CERTIFICATE");
            				 System.out.println(firstdoseComp1);
                             System.out.println(firstdoseComp2);
                             System.out.println(firstdoseComp3);
                             
            			 }
            			 else if(menu == 5) { //menu to display all citizen that have fully vaccinated
            				 
            				 System.out.println("\n\t\t\t\t\t\t\t\tFULLY VACCINATED INFORMATION\n");
    						 System.out.format("\n \t%-23s \t%-9s \t%-16s \t%-8s \t%-15s    %-12s\t   %-16s\t %-19s %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "1ST DOSE", "2ND DOSE", "CERTIFICATE");
            				 System.out.println(completedList);
            				 
            			 }
 
            		 }while (menu != 6);
            	}
            	 	
            	
            }while (main_menu!=4);
			
		}
		catch(FileNotFoundException fnf) {
            System.out.println("File not found");
        }
        catch(EOFException eof) {
            System.out.println("End of file error");
        }
        catch(IOException io) {
            System.out.println("wrong input!!!");
        }
        catch(NullPointerException npe) {
            System.out.println("null string");
        }
        catch(NumberFormatException nfe) {
            System.out.println("wrong input!!!");
        }
        finally {
            System.out.println("\nSystem end here.Bye!");
            }
	}

}
