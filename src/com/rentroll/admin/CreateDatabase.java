package com.rentroll.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rentroll.business.Address;
import com.rentroll.business.EmailAddress;
import com.rentroll.business.Owner;
import com.rentroll.business.PhoneNumber;
import com.rentroll.business.Property;
import com.rentroll.business.Tenant;
import com.rentroll.business.Unit;
import com.rentroll.business.Vendor;
import com.rentroll.data.DbFunctions;

/**
 * Servlet implementation class CreateDatabase
 */
@WebServlet("/CreateDatabase")
public class CreateDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Owner jack = new Owner("Jack","Richard","Cranial", "wire");
		Owner joey = new Owner("Joey","Jack","Jackson", "check");
		Owner joe= new Owner("Joe","Jack", "Shmuck", "check");
		Owner robert= new Owner("Robert", "Joseph","Hogan", "check");
		Owner jane= new Owner("Jane","Rose", "Smith", "check");
		
		DbFunctions.insert(jack);
		DbFunctions.insert(joey);
		DbFunctions.insert(joe);
		DbFunctions.insert(robert);
		DbFunctions.insert(jane);
		
		
		EmailAddress jackHomeEmail= new EmailAddress(jack,false, "work", "jackWork@aol.com");
		EmailAddress jackWorkEmail= new EmailAddress(jack,true, "home", "jackHome@aol.com");
		EmailAddress jackOtherEmail= new EmailAddress(jack,false, "other", "jackOther@aol.com");
		

		DbFunctions.insert(jackHomeEmail);
		DbFunctions.insert(jackWorkEmail);
		DbFunctions.insert(jackOtherEmail);
		
		
		EmailAddress joeHomeEmail= new EmailAddress(joe,false, "home", "joeHome@aol.com");
		EmailAddress joeWorkEmail= new EmailAddress(joe,true, "work", "joeWork@aol.com");
		EmailAddress joeOtherEmail= new EmailAddress(joe,false, "other", "joeOther@aol.com");
		

		DbFunctions.insert(joeHomeEmail);
		DbFunctions.insert(joeWorkEmail);
		DbFunctions.insert(joeOtherEmail);
		
		EmailAddress joeyHomeEmail= new EmailAddress(joey,false, "work", "joeyWork@aol.com");
		EmailAddress joeyWorkEmail= new EmailAddress(joey,true, "home", "joeyHome@aol.com");
		EmailAddress joeyOtherEmail= new EmailAddress(joey,false, "other", "joeyOther@aol.com");
		

		DbFunctions.insert(joeyHomeEmail);
		DbFunctions.insert(joeyWorkEmail);
		DbFunctions.insert(joeyOtherEmail);
		
		EmailAddress robertHomeEmail= new EmailAddress(robert,false, "work", "robertWork@aol.com");
		EmailAddress robertWorkEmail= new EmailAddress(robert,true, "home", "robertHome@aol.com");
		EmailAddress robertOtherEmail= new EmailAddress(robert,false, "other", "robertOther@aol.com");
		

		DbFunctions.insert(robertHomeEmail);
		DbFunctions.insert(robertWorkEmail);
		DbFunctions.insert(robertOtherEmail);
		
		EmailAddress janeHomeEmail= new EmailAddress(jane,false, "work", "janeWork@aol.com");
		EmailAddress janeWorkEmail= new EmailAddress(jane,true, "home", "janeHome@aol.com");
		EmailAddress janeOtherEmail= new EmailAddress(jane,false, "other", "janeOther@aol.com");
		

		DbFunctions.insert(janeHomeEmail);
		DbFunctions.insert(janeWorkEmail);
		DbFunctions.insert(janeOtherEmail);
		
		
		PhoneNumber jackCellPhone =new PhoneNumber(jack , true , "Cell" , "512-447-1234");
		PhoneNumber jackHomePhone =new PhoneNumber(jack , false , "Home" , "512-412-4344");
		PhoneNumber jackWorkPhone =new PhoneNumber(jack , false , "Work" , "512-443-1234");
		
		DbFunctions.insert(jackCellPhone);
		DbFunctions.insert(jackHomePhone);
		DbFunctions.insert(jackWorkPhone);
		
		PhoneNumber joeyCellPhone =new PhoneNumber(joey , false , "Cell" , "512-447-1234");
		PhoneNumber joeyHomePhone =new PhoneNumber(joey , true , "Home" , "512-412-4344");
		PhoneNumber joeyWorkPhone =new PhoneNumber(joey , false , "Work" , "512-443-1234");
		
		DbFunctions.insert(joeyCellPhone);
		DbFunctions.insert(joeyHomePhone);
		DbFunctions.insert(joeyWorkPhone);
		
		PhoneNumber joeCellPhone =new PhoneNumber(joe , false , "Cell" , "512-447-1234");
		PhoneNumber joeHomePhone =new PhoneNumber(joe , false , "Home" , "512-412-4344");
		PhoneNumber joeWorkPhone =new PhoneNumber(joe , true , "Work" , "512-443-1234");
		
		DbFunctions.insert(joeCellPhone);
		DbFunctions.insert(joeHomePhone);
		DbFunctions.insert(joeWorkPhone);
		
		PhoneNumber robertCellPhone =new PhoneNumber(robert , true , "Cell" , "512-447-1234");
		PhoneNumber robertHomePhone =new PhoneNumber(robert , false , "Home" , "512-412-4344");
		PhoneNumber robertWorkPhone =new PhoneNumber(robert , false , "Work" , "512-443-1234");
		
		DbFunctions.insert(robertCellPhone);
		DbFunctions.insert(robertHomePhone);
		DbFunctions.insert(robertWorkPhone);
		
		PhoneNumber janeCellPhone =new PhoneNumber(jane , true , "Cell" , "512-447-1234");
		PhoneNumber janeHomePhone =new PhoneNumber(jane , false , "Home" , "512-412-4344");
		PhoneNumber janeWorkPhone =new PhoneNumber(jane , false , "Work" , "512-443-1234");
		
		DbFunctions.insert(janeCellPhone);
		DbFunctions.insert(janeHomePhone);
		DbFunctions.insert(janeWorkPhone);
		
		
		Address jackHomeAddress = new Address(jack,false,"home", "123 Home St", "","Austin", "Texas", "78704");
		Address jackWorkAddress = new Address(jack,true,"work", "123 Work St", "","Austin", "Texas", "78704");

		DbFunctions.insert(jackHomeAddress);
		DbFunctions.insert(jackWorkAddress);
		
		Address joeyHomeAddress = new Address(joey,false,"home", "123 Home St", "","Austin", "Texas", "78704");
		Address joeyWorkAddress = new Address(joey,true,"work", "123 Work St", "","Austin", "Texas", "78704");

		DbFunctions.insert(joeyHomeAddress);
		DbFunctions.insert(joeyWorkAddress);
		
		Address joeHomeAddress = new Address(joe,false,"home", "123 Home St", "","Austin", "Texas", "78704");
		Address joeWorkAddress = new Address(joe,true,"work", "123 Work St", "","Austin", "Texas", "78704");

		DbFunctions.insert(joeHomeAddress);
		DbFunctions.insert(joeWorkAddress);
		
		Address robertHomeAddress = new Address(robert,false,"home", "123 Home St", "","Austin", "Texas", "78704");
		Address robertWorkAddress = new Address(robert,true,"work", "123 Work St", "","Austin", "Texas", "78704");

		DbFunctions.insert(robertHomeAddress);
		DbFunctions.insert(robertWorkAddress);
		
		Address janeHomeAddress = new Address(jane,false,"home", "123 Home St", "","Austin", "Texas", "78704");
		Address janeWorkAddress = new Address(jane,true,"work", "123 Work St", "","Austin", "Texas", "78704");

		DbFunctions.insert(janeHomeAddress);
		DbFunctions.insert(janeWorkAddress);
		
		
		Property jackProp1 = new Property();
		jackProp1.setPropAddress1("6649 N Blue Gum St");
		jackProp1.setPropCity("Austin");
		jackProp1.setOwner(jack);
		jackProp1.setPropertyType("Duplex");
		jackProp1.setNumberOfUnits(2);
		jackProp1.setPropZip("78704");
		jackProp1.setCommission(.05);
		jackProp1.setPropState("Texas");
		
		Property jackProp2 = new Property();
		jackProp2.setPropName("Jack's Apartments");
		jackProp2.setPropAddress1("74874 Atlantic Ave");
		jackProp2.setPropCity("Austin");
		jackProp2.setOwner(jack);
		jackProp2.setPropertyType("Apratment");
		jackProp2.setNumberOfUnits(20);
		jackProp2.setPropZip("78704");
		jackProp2.setCommission(.03);
		jackProp2.setPropState("Texas");
		
		
		
		
		DbFunctions.insert(jackProp1);
		DbFunctions.insert(jackProp2);

		
		

		
		Property joeyProp1 = new Property();
		joeyProp1.setPropName("Joey's Apartments");
		joeyProp1.setPropAddress1("74874 Atlantic Ave");
		joeyProp1.setPropCity("Austin");
		joeyProp1.setOwner(joey);
		joeyProp1.setPropertyType("Apratment");
		joeyProp1.setNumberOfUnits(15);
		joeyProp1.setPropZip("78704");
		joeyProp1.setCommission(.04);
		joeyProp1.setPropState("Texas");
		
		DbFunctions.insert(joeyProp1);

		Property joeProp1 = new Property();
		joeProp1.setPropAddress1("6649 N Blue Gum St");
		joeProp1.setPropCity("Austin");
		joeProp1.setOwner(joe);
		joeProp1.setPropertyType("Single Family");
		joeProp1.setNumberOfUnits(1);
		joeProp1.setPropZip("78704");
		joeProp1.setCommission(.05);
		joeProp1.setPropState("Texas");
		
		Property joeProp2 = new Property();
		joeProp2.setPropName("Joe's Apartments");
		joeProp2.setPropAddress1("74874 Atlantic Ave");
		joeProp2.setPropCity("Austin");
		joeProp2.setOwner(joe);
		joeProp2.setPropertyType("Single Family");
		joeProp2.setNumberOfUnits(1);
		joeProp2.setPropZip("78704");
		joeProp2.setCommission(.03);
		joeProp2.setPropState("Texas");
		
		Property joeProp3 = new Property();
		joeProp3.setPropAddress1("123 Live Oak St");
		joeProp3.setPropCity("Austin");
		joeProp3.setOwner(joe);
		joeProp3.setPropertyType("Single Family");
		joeProp3.setNumberOfUnits(1);
		joeProp3.setPropZip("78758");
		joeProp3.setCommission(.06);
		joeProp3.setPropState("Texas");
		
		Property joeProp4 = new Property();
		joeProp4.setPropAddress1("123 Dead Oak St");
		joeProp4.setPropCity("Austin");
		joeProp4.setOwner(joe);
		joeProp4.setPropertyType("Single Family");
		joeProp4.setNumberOfUnits(1);
		joeProp4.setPropZip("78758");
		joeProp4.setCommission(.06);
		joeProp4.setPropState("Texas");
		
		DbFunctions.insert(joeProp1);
		DbFunctions.insert(joeProp2);
		DbFunctions.insert(joeProp3);
		DbFunctions.insert(joeProp4);
		
		
		Property janeProp1 = new Property();
		janeProp1.setPropName("Jane's Apartments");
		janeProp1.setPropAddress1("74874 Atlantic Ave");
		janeProp1.setPropCity("Austin");
		janeProp1.setOwner(jane);
		janeProp1.setPropertyType("Apratment");
		janeProp1.setNumberOfUnits(10);
		janeProp1.setPropZip("78704");
		janeProp1.setCommission(.04);
		janeProp1.setPropState("Texas");
		
		DbFunctions.insert(janeProp1);


		
		Property robertProp1 = new Property();
		robertProp1.setPropAddress1("6649 N Blue Gum St");
		robertProp1.setPropCity("Austin");
		robertProp1.setOwner(robert);
		robertProp1.setPropertyType("Duplex");
		robertProp1.setNumberOfUnits(2);
		robertProp1.setPropZip("78704");
		robertProp1.setCommission(.05);
		robertProp1.setPropState("Texas");
		
		Property robertProp2 = new Property();
		robertProp2.setPropAddress1("74874 Atlantic Ave");
		robertProp2.setPropCity("Austin");
		robertProp2.setOwner(robert);
		robertProp2.setPropertyType("Duplex");
		robertProp2.setNumberOfUnits(2);
		robertProp2.setPropZip("78704");
		robertProp2.setCommission(.03);
		robertProp2.setPropState("Texas");
		
		Property robertProp3 = new Property();
		robertProp3.setPropAddress1("123 Live Oak St");
		robertProp3.setPropCity("Austin");
		robertProp3.setOwner(robert);
		robertProp3.setPropertyType("Duplex");
		robertProp3.setNumberOfUnits(2);
		robertProp3.setPropZip("78758");
		robertProp3.setCommission(.06);
		robertProp3.setPropState("Texas");
		
		
		DbFunctions.insert(robertProp1);
		DbFunctions.insert(robertProp2);
		DbFunctions.insert(robertProp3);
		
		Unit jackProp1Unit1 = new Unit(jackProp1, "001",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit jackProp1Unit2 = new Unit(jackProp1, "002",2, 2, 1200D, 1000D, "Two Bedroom", "Vacant");

		DbFunctions.insert(jackProp1Unit1);
		DbFunctions.insert(jackProp1Unit2);

		Unit jackProp2Unit1 = new Unit(jackProp2, "001",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit2 = new Unit(jackProp2, "002",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit3 = new Unit(jackProp2, "003",2, 2, 1200D, 1000D, "Two Bedroom", "Vacant");
		Unit jackProp2Unit4 = new Unit(jackProp2, "004",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit5 = new Unit(jackProp2, "005",2, 2, 1200D, 1000D, "Two Bedroom", "Vacant");
		Unit jackProp2Unit6 = new Unit(jackProp2, "006",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit7 = new Unit(jackProp2, "007",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit8 = new Unit(jackProp2, "008",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit9 = new Unit(jackProp2, "009",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit10 = new Unit(jackProp2, "010",1, 1, 900D, 1000D, "One Bedroom", "Occupied");
		Unit jackProp2Unit11 = new Unit(jackProp2, "011",1, 1, 900D, 1000D, "One Bedroom", "Occupied");
		Unit jackProp2Unit12 = new Unit(jackProp2, "012",1, 1, 900D, 1000D, "One Bedroom", "Occupied");
		Unit jackProp2Unit13 = new Unit(jackProp2, "013",1, 1, 900D, 1000D, "One Bedroom", "Vacant");
		Unit jackProp2Unit14 = new Unit(jackProp2, "014",1, 1, 900D, 1000D, "One Bedroom", "Occupied");
		Unit jackProp2Unit15 = new Unit(jackProp2, "015",1, 1, 900D, 1000D, "One Bedroom", "Occupied");
		Unit jackProp2Unit16 = new Unit(jackProp2, "016",1, 1, 700D, 1000D, "Efficiency", "Occupied");
		Unit jackProp2Unit17 = new Unit(jackProp2, "017",1, 1, 700D, 1000D, "Efficiency", "Occupied");
		Unit jackProp2Unit18 = new Unit(jackProp2, "018",1, 1, 700D, 1000D, "Efficiency", "Occupied");
		Unit jackProp2Unit19 = new Unit(jackProp2, "019",1, 1, 700D, 1000D, "Efficiency", "Occupied");
		Unit jackProp2Unit20 = new Unit(jackProp2, "020",1, 1, 700D, 1000D, "Efficiency", "Occupied");

		DbFunctions.insert(jackProp2Unit1);
		DbFunctions.insert(jackProp2Unit2);
		
//Property other_property = DbFunctions.selectProperty(1);
//		
//		
//		
//		for (Unit unit : other_property.getUnits()){
//			System.out.println(unit.getUnitId()+ " "+ unit.getUnitNumber());
//		}
		
		DbFunctions.insert(jackProp2Unit3);
		DbFunctions.insert(jackProp2Unit4);
		DbFunctions.insert(jackProp2Unit5);
		DbFunctions.insert(jackProp2Unit6);
		DbFunctions.insert(jackProp2Unit7);
		DbFunctions.insert(jackProp2Unit8);
		DbFunctions.insert(jackProp2Unit9);
		DbFunctions.insert(jackProp2Unit10);
		DbFunctions.insert(jackProp2Unit11);
		DbFunctions.insert(jackProp2Unit12);
		DbFunctions.insert(jackProp2Unit13);
		DbFunctions.insert(jackProp2Unit14);
		DbFunctions.insert(jackProp2Unit15);
		DbFunctions.insert(jackProp2Unit16);
		DbFunctions.insert(jackProp2Unit17);
		DbFunctions.insert(jackProp2Unit18);
		DbFunctions.insert(jackProp2Unit19);
		DbFunctions.insert(jackProp2Unit20);


		Unit joeyProp1Unit1 = new Unit(joeyProp1, "001",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit2 = new Unit(joeyProp1, "002",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit3 = new Unit(joeyProp1, "003",2, 2, 1200D, 1000D, "Two Bedroom", "Vacant");
		Unit joeyProp1Unit4 = new Unit(joeyProp1, "004",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit5 = new Unit(joeyProp1, "005",2, 2, 1200D, 1000D, "Two Bedroom", "Vacant");
		Unit joeyProp1Unit6 = new Unit(joeyProp1, "006",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit7 = new Unit(joeyProp1, "007",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit8 = new Unit(joeyProp1, "008",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit9 = new Unit(joeyProp1, "009",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit10 = new Unit(joeyProp1, "010",1, 1, 900D, 1000D, "One Bedroom", "Occupied");
		Unit joeyProp1Unit11 = new Unit(joeyProp1, "011",1, 1, 900D, 1000D, "One Bedroom", "Occupied");
		Unit joeyProp1Unit12 = new Unit(joeyProp1, "012",1, 1, 900D, 1000D, "One Bedroom", "Occupied");
		Unit joeyProp1Unit13 = new Unit(joeyProp1, "013",1, 1, 900D, 1000D, "One Bedroom", "Vacant");
		Unit joeyProp1Unit14 = new Unit(joeyProp1, "014",1, 1, 900D, 1000D, "One Bedroom", "Occupied");
		Unit joeyProp1Unit15 = new Unit(joeyProp1, "015",1, 1, 900D, 1000D, "One Bedroom", "Occupied");

		DbFunctions.insert(joeyProp1Unit1);
		DbFunctions.insert(joeyProp1Unit2);
		DbFunctions.insert(joeyProp1Unit3);
		DbFunctions.insert(joeyProp1Unit4);
		DbFunctions.insert(joeyProp1Unit5);
		DbFunctions.insert(joeyProp1Unit6);
		DbFunctions.insert(joeyProp1Unit7);
		DbFunctions.insert(joeyProp1Unit8);
		DbFunctions.insert(joeyProp1Unit9);
		DbFunctions.insert(joeyProp1Unit10);
		DbFunctions.insert(joeyProp1Unit11);
		DbFunctions.insert(joeyProp1Unit12);
		DbFunctions.insert(joeyProp1Unit13);
		DbFunctions.insert(joeyProp1Unit14);
		DbFunctions.insert(joeyProp1Unit15);

		Unit joeProp1Unit1 = new Unit(joeProp1, "001", 3, 4, 2000D, 2500D, "Three Bedroom House", "Occupied");
		Unit joeProp2Unit1 = new Unit(joeProp2, "001", 3, 4, 2000D, 2500D, "Three Bedroom House", "Occupied");
		Unit joeProp3Unit1 = new Unit(joeProp3, "001", 3, 4, 2000D, 2500D, "Three Bedroom House", "Occupied");
		Unit joeProp4Unit1 = new Unit(joeProp4, "001", 3, 4, 2000D, 2500D, "Three Bedroom House", "Occupied");

		DbFunctions.insert(joeProp1Unit1);
		DbFunctions.insert(joeProp2Unit1);
		DbFunctions.insert(joeProp3Unit1);
		DbFunctions.insert(joeProp4Unit1);

		Unit janeProp1Unit1 = new Unit(janeProp1, "001",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit2 = new Unit(janeProp1, "002",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit3 = new Unit(janeProp1, "003",2, 2, 1200D, 1000D, "Two Bedroom", "Vacant");
		Unit janeProp1Unit4 = new Unit(janeProp1, "004",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit5 = new Unit(janeProp1, "005",2, 2, 1200D, 1000D, "Two Bedroom", "Vacant");
		Unit janeProp1Unit6 = new Unit(janeProp1, "006",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit7 = new Unit(janeProp1, "007",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit8 = new Unit(janeProp1, "008",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit9 = new Unit(janeProp1, "009",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit10 = new Unit(janeProp1, "010",1, 1, 900D, 1000D, "One Bedroom", "Occupied");
		Unit janeProp1Unit11 = new Unit(janeProp1, "011",1, 1, 900D, 1000D, "One Bedroom", "Occupied");
		Unit janeProp1Unit12 = new Unit(janeProp1, "012",1, 1, 900D, 1000D, "One Bedroom", "Occupied");
		Unit janeProp1Unit13 = new Unit(janeProp1, "013",1, 1, 900D, 1000D, "One Bedroom", "Vacant");
		Unit janeProp1Unit14 = new Unit(janeProp1, "014",1, 1, 900D, 1000D, "One Bedroom", "Occupied");
		Unit janeProp1Unit15 = new Unit(janeProp1, "015",1, 1, 900D, 1000D, "One Bedroom", "Occupied");


		DbFunctions.insert(janeProp1Unit1);
		DbFunctions.insert(janeProp1Unit2);
		DbFunctions.insert(janeProp1Unit3);
		DbFunctions.insert(janeProp1Unit4);
		DbFunctions.insert(janeProp1Unit5);
		DbFunctions.insert(janeProp1Unit6);
		DbFunctions.insert(janeProp1Unit7);
		DbFunctions.insert(janeProp1Unit8);
		DbFunctions.insert(janeProp1Unit9);
		DbFunctions.insert(janeProp1Unit10);
		DbFunctions.insert(janeProp1Unit11);
		DbFunctions.insert(janeProp1Unit12);
		DbFunctions.insert(janeProp1Unit13);
		DbFunctions.insert(janeProp1Unit14);
		DbFunctions.insert(janeProp1Unit15);

		Unit robertProp1Unit1 = new Unit(robertProp1, "001",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit robertProp1Unit2 = new Unit(robertProp1, "002",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");

		DbFunctions.insert(robertProp1Unit1);
		DbFunctions.insert(robertProp1Unit2);

		Unit robertProp2Unit1 = new Unit(robertProp2, "001",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit robertProp2Unit2 = new Unit(robertProp2, "002",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");

		DbFunctions.insert(robertProp2Unit1);
		DbFunctions.insert(robertProp2Unit2);

		Unit robertProp3Unit1 = new Unit(robertProp3, "001",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");
		Unit robertProp3Unit2 = new Unit(robertProp3, "002",2, 2, 1200D, 1000D, "Two Bedroom", "Occupied");

		DbFunctions.insert(robertProp3Unit1);
		DbFunctions.insert(robertProp3Unit2);
		
		
		Tenant jackProp1Unit1Tenant = new Tenant ( jackProp1Unit1, "Tawna ", " Teddy" , "Villanueva" , "06/22/1995", "12/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit1Tenant = new Tenant ( jackProp2Unit1, "Virgie ", " Filiberto" , "Bevelacqua" , "11/04/1966", "05/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit2Tenant = new Tenant ( jackProp2Unit2, "Marguerita ", " Weldon" , "Louissant" , "03/07/1970", "02/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit4Tenant = new Tenant ( jackProp2Unit4, "Kristeen ", " Virgie" , "Paa" , "12/02/1998", "09/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit6Tenant = new Tenant ( jackProp2Unit6, "Alex ", " Taryn" , "Paulas" , "01/13/1967", "12/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit7Tenant = new Tenant ( jackProp2Unit7, "Wynell ", " Felix" , "Hanafan" , "11/13/1977", "06/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit8Tenant = new Tenant ( jackProp2Unit8, "Taryn ", " Willodean" , "Lietz" , "07/19/1968", "06/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit9Tenant = new Tenant ( jackProp2Unit9, "Ammie ", " Kimberlie" , "Birkner" , "07/15/1980", "07/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit10Tenant = new Tenant ( jackProp2Unit10, "Iluminada ", " Merilyn" , "Zurcher" , "07/26/1989", "04/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit11Tenant = new Tenant ( jackProp2Unit11, "Jaclyn ", " Allene" , "Madarang" , "01/25/1991", "11/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit12Tenant = new Tenant ( jackProp2Unit12, "Raina ", " Felicidad" , "Nachor" , "05/16/1968", "01/01/2017", 12345678, "Texas");
		Tenant jackProp2Unit14Tenant = new Tenant ( jackProp2Unit14, "Lenna ", " Sharen" , "Hamilton" , "04/12/1990", "04/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit15Tenant = new Tenant ( jackProp2Unit15, "Ozell ", " Daron" , "Nicolozakes" , "02/02/1965", "12/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit16Tenant = new Tenant ( jackProp2Unit16, "Mozell ", " Tiffiny" , "Chaffins" , "05/23/1987", "04/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit17Tenant = new Tenant ( jackProp2Unit17, "Sylvie ", " Vallie" , "Treston" , "12/07/1984", "04/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit18Tenant = new Tenant ( jackProp2Unit18, "Bernardine ", " Annmarie" , "Jillson" , "03/09/1987", "07/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit19Tenant = new Tenant ( jackProp2Unit19, "Vincenza ", " Ernie" , "Schirpke" , "07/23/1998", "12/01/2016", 12345678, "Texas");
		Tenant jackProp2Unit20Tenant = new Tenant ( jackProp2Unit20, "Erick ", " Cecil" , "Dickerson" , "09/22/1983", "01/01/2017", 12345678, "Texas");
		Tenant joeyProp1Unit1Tenant = new Tenant ( joeyProp1Unit1, "Lashaunda ", " Abel" , "Martabano" , "03/07/1981", "01/01/2017", 12345678, "Texas");
		Tenant joeyProp1Unit2Tenant = new Tenant ( joeyProp1Unit2, "Edna ", " Britt" , "Lapage" , "03/12/1992", "12/01/2016", 12345678, "Texas");
		Tenant joeyProp1Unit4Tenant = new Tenant ( joeyProp1Unit4, "Annabelle ", " Lemuel" , "Heimann" , "04/24/1998", "02/01/2016", 12345678, "Texas");
		Tenant joeyProp1Unit6Tenant = new Tenant ( joeyProp1Unit6, "Erick ", " Cecily" , "Kalafatis" , "12/03/1989", "11/01/2016", 12345678, "Texas");
		Tenant joeyProp1Unit7Tenant = new Tenant ( joeyProp1Unit7, "Howard ", " Chaya" , "Syrop" , "10/21/1995", "09/01/2016", 12345678, "Texas");
		Tenant joeyProp1Unit8Tenant = new Tenant ( joeyProp1Unit8, "Heike ", " Pete" , "Funnell" , "01/08/1982", "06/01/2016", 12345678, "Texas");
		Tenant joeyProp1Unit9Tenant = new Tenant ( joeyProp1Unit9, "Brittni ", " Garry" , "Gotter" , "11/19/1978", "11/01/2016", 12345678, "Texas");
		Tenant joeyProp1Unit10Tenant = new Tenant ( joeyProp1Unit10, "Casie ", " Mariann" , "Isaacs" , "01/05/1982", "12/01/2016", 12345678, "Texas");
		Tenant joeyProp1Unit11Tenant = new Tenant ( joeyProp1Unit11, "Edna ", " Leatha" , "Foller" , "12/12/1976", "07/01/2016", 12345678, "Texas");
		Tenant joeyProp1Unit12Tenant = new Tenant ( joeyProp1Unit12, "Evangelina ", " Candida" , "Juhas" , "12/03/1975", "02/01/2016", 12345678, "Texas");
		Tenant joeyProp1Unit14Tenant = new Tenant ( joeyProp1Unit14, "Christiane ", " Derick" , "Gato" , "03/14/1989", "03/01/2016", 12345678, "Texas");
		Tenant joeyProp1Unit15Tenant = new Tenant ( joeyProp1Unit15, "Viva ", " Virgie" , "Korando" , "07/05/1970", "10/01/2016", 12345678, "Texas");
		Tenant joeProp1Unit1Tenant = new Tenant ( joeProp1Unit1, "Cherry ", " Terrilyn" , "Nabours" , "05/26/1975", "11/01/2016", 12345678, "Texas");
		Tenant joeProp2Unit1Tenant = new Tenant ( joeProp2Unit1, "Reena ", " Jennie" , "Koppinger" , "09/10/1965", "12/01/2016", 12345678, "Texas");
		Tenant joeProp3Unit1Tenant = new Tenant ( joeProp3Unit1, "Helaine ", " Lizette" , "Monterrubio" , "12/08/1968", "06/01/2016", 12345678, "Texas");
		Tenant joeProp4Unit1Tenant = new Tenant ( joeProp4Unit1, "Shenika ", " Jaclyn" , "Bilden" , "04/05/1988", "04/01/2016", 12345678, "Texas");
		Tenant janeProp1Unit1Tenant = new Tenant ( janeProp1Unit1, "Donette ", " Viola" , "Lother" , "10/13/1974", "03/01/2016", 12345678, "Texas");
		Tenant janeProp1Unit2Tenant = new Tenant ( janeProp1Unit2, "Bette ", " Sarah" , "Riopelle" , "10/02/1982", "05/01/2016", 12345678, "Texas");
		Tenant janeProp1Unit4Tenant = new Tenant ( janeProp1Unit4, "Hermila ", " Shawna" , "Yglesias" , "02/04/1984", "08/01/2016", 12345678, "Texas");
		Tenant janeProp1Unit6Tenant = new Tenant ( janeProp1Unit6, "Raina ", " Bernardine" , "Melnyk" , "02/25/1971", "12/01/2016", 12345678, "Texas");
		Tenant janeProp1Unit7Tenant = new Tenant ( janeProp1Unit7, "Glenn ", " Herminia" , "Schirpke" , "12/01/1978", "10/01/2016", 12345678, "Texas");
		Tenant janeProp1Unit8Tenant = new Tenant ( janeProp1Unit8, "Raylene ", " Kallie" , "Labreche" , "05/08/1998", "07/01/2016", 12345678, "Texas");
		Tenant janeProp1Unit9Tenant = new Tenant ( janeProp1Unit9, "Malcolm ", " Yolando" , "Threets" , "01/13/1993", "05/01/2016", 12345678, "Texas");
		Tenant janeProp1Unit10Tenant = new Tenant ( janeProp1Unit10, "Erick ", " Casie" , "Rochin" , "09/18/1985", "09/01/2016", 12345678, "Texas");
		Tenant janeProp1Unit11Tenant = new Tenant ( janeProp1Unit11, "Mirta ", " Loren" , "Corbley" , "08/05/1965", "03/01/2016", 12345678, "Texas");
		Tenant janeProp1Unit12Tenant = new Tenant ( janeProp1Unit12, "Felix ", " Marge" , "Goldammer" , "11/29/1987", "10/01/2016", 12345678, "Texas");
		Tenant janeProp1Unit14Tenant = new Tenant ( janeProp1Unit14, "Regenia ", " Ciara" , "Wolfgramm" , "03/14/1987", "11/01/2016", 12345678, "Texas");
		Tenant janeProp1Unit15Tenant = new Tenant ( janeProp1Unit15, "Colette ", " Willodean" , "Kardas" , "06/29/1998", "11/01/2016", 12345678, "Texas");
		Tenant robertProp1Unit1Tenant = new Tenant ( robertProp1Unit1, "Markus ", " Lai" , "Aredondo" , "01/17/1989", "12/01/2016", 12345678, "Texas");
		Tenant robertProp1Unit2Tenant = new Tenant ( robertProp1Unit2, "Barbra ", " Diane" , "Threets" , "12/22/1988", "09/01/2016", 12345678, "Texas");
		Tenant robertProp2Unit1Tenant = new Tenant ( robertProp2Unit1, "Lili ", " Kaitlyn" , "Corrio" , "03/27/1998", "12/01/2016", 12345678, "Texas");
		Tenant robertProp2Unit2Tenant = new Tenant ( robertProp2Unit2, "Jennifer ", " Irma" , "Thyberg" , "06/11/1979", "04/01/2016", 12345678, "Texas");
		Tenant robertProp3Unit1Tenant = new Tenant ( robertProp3Unit1, "Heike ", " Bette" , "Lungren" , "07/17/1990", "02/01/2016", 12345678, "Texas");
		Tenant robertProp3Unit2Tenant = new Tenant ( robertProp3Unit2, "Kris ", " Glenna" , "Claucherty" , "03/30/1972", "10/01/2016", 12345678, "Texas");

		DbFunctions.insert(jackProp1Unit1Tenant);
		DbFunctions.insert(jackProp2Unit1Tenant);
		DbFunctions.insert(jackProp2Unit2Tenant);
		DbFunctions.insert(jackProp2Unit4Tenant);
		DbFunctions.insert(jackProp2Unit6Tenant);
		DbFunctions.insert(jackProp2Unit7Tenant);
		DbFunctions.insert(jackProp2Unit8Tenant);
		DbFunctions.insert(jackProp2Unit9Tenant);
		DbFunctions.insert(jackProp2Unit10Tenant);
		DbFunctions.insert(jackProp2Unit11Tenant);
		DbFunctions.insert(jackProp2Unit12Tenant);
		DbFunctions.insert(jackProp2Unit14Tenant);
		DbFunctions.insert(jackProp2Unit15Tenant);
		DbFunctions.insert(jackProp2Unit16Tenant);
		DbFunctions.insert(jackProp2Unit17Tenant);
		DbFunctions.insert(jackProp2Unit18Tenant);
		DbFunctions.insert(jackProp2Unit19Tenant);
		DbFunctions.insert(jackProp2Unit20Tenant);
		DbFunctions.insert(joeyProp1Unit1Tenant);
		DbFunctions.insert(joeyProp1Unit2Tenant);
		DbFunctions.insert(joeyProp1Unit4Tenant);
		DbFunctions.insert(joeyProp1Unit6Tenant);
		DbFunctions.insert(joeyProp1Unit7Tenant);
		DbFunctions.insert(joeyProp1Unit8Tenant);
		DbFunctions.insert(joeyProp1Unit9Tenant);
		DbFunctions.insert(joeyProp1Unit10Tenant);
		DbFunctions.insert(joeyProp1Unit11Tenant);
		DbFunctions.insert(joeyProp1Unit12Tenant);
		DbFunctions.insert(joeyProp1Unit14Tenant);
		DbFunctions.insert(joeyProp1Unit15Tenant);
		DbFunctions.insert(joeProp1Unit1Tenant);
		DbFunctions.insert(joeProp2Unit1Tenant);
		DbFunctions.insert(joeProp3Unit1Tenant);
		DbFunctions.insert(joeProp4Unit1Tenant);
		DbFunctions.insert(janeProp1Unit1Tenant);
		DbFunctions.insert(janeProp1Unit2Tenant);
		DbFunctions.insert(janeProp1Unit4Tenant);
		DbFunctions.insert(janeProp1Unit6Tenant);
		DbFunctions.insert(janeProp1Unit7Tenant);
		DbFunctions.insert(janeProp1Unit8Tenant);
		DbFunctions.insert(janeProp1Unit9Tenant);
		DbFunctions.insert(janeProp1Unit10Tenant);
		DbFunctions.insert(janeProp1Unit11Tenant);
		DbFunctions.insert(janeProp1Unit12Tenant);
		DbFunctions.insert(janeProp1Unit14Tenant);
		DbFunctions.insert(janeProp1Unit15Tenant);
		DbFunctions.insert(robertProp1Unit1Tenant);
		DbFunctions.insert(robertProp1Unit2Tenant);
		DbFunctions.insert(robertProp2Unit1Tenant);
		DbFunctions.insert(robertProp2Unit2Tenant);
		DbFunctions.insert(robertProp3Unit1Tenant);
		DbFunctions.insert(robertProp3Unit2Tenant);
		
		EmailAddress jackProp1Unit1TenantEmail = new EmailAddress(jackProp1Unit1Tenant, false, "work", "TawnaVillanuevaWork@aol.com");
		EmailAddress jackProp2Unit1TenantEmail = new EmailAddress(jackProp2Unit1Tenant, false, "work", "VirgieBevelacquaWork@aol.com");
		EmailAddress jackProp2Unit2TenantEmail = new EmailAddress(jackProp2Unit2Tenant, false, "work", "MargueritaLouissantWork@aol.com");
		EmailAddress jackProp2Unit4TenantEmail = new EmailAddress(jackProp2Unit4Tenant, false, "work", "KristeenPaaWork@aol.com");
		EmailAddress jackProp2Unit6TenantEmail = new EmailAddress(jackProp2Unit6Tenant, false, "work", "AlexPaulasWork@aol.com");
		EmailAddress jackProp2Unit7TenantEmail = new EmailAddress(jackProp2Unit7Tenant, false, "work", "WynellHanafanWork@aol.com");
		EmailAddress jackProp2Unit8TenantEmail = new EmailAddress(jackProp2Unit8Tenant, false, "work", "TarynLietzWork@aol.com");
		EmailAddress jackProp2Unit9TenantEmail = new EmailAddress(jackProp2Unit9Tenant, false, "work", "AmmieBirknerWork@aol.com");
		EmailAddress jackProp2Unit10TenantEmail = new EmailAddress(jackProp2Unit10Tenant, false, "work", "IluminadaZurcherWork@aol.com");
		EmailAddress jackProp2Unit11TenantEmail = new EmailAddress(jackProp2Unit11Tenant, false, "work", "JaclynMadarangWork@aol.com");
		EmailAddress jackProp2Unit12TenantEmail = new EmailAddress(jackProp2Unit12Tenant, false, "work", "RainaNachorWork@aol.com");
		EmailAddress jackProp2Unit14TenantEmail = new EmailAddress(jackProp2Unit14Tenant, false, "work", "LennaHamiltonWork@aol.com");
		EmailAddress jackProp2Unit15TenantEmail = new EmailAddress(jackProp2Unit15Tenant, false, "work", "OzellNicolozakesWork@aol.com");
		EmailAddress jackProp2Unit16TenantEmail = new EmailAddress(jackProp2Unit16Tenant, false, "work", "MozellChaffinsWork@aol.com");
		EmailAddress jackProp2Unit17TenantEmail = new EmailAddress(jackProp2Unit17Tenant, false, "work", "SylvieTrestonWork@aol.com");
		EmailAddress jackProp2Unit18TenantEmail = new EmailAddress(jackProp2Unit18Tenant, false, "work", "BernardineJillsonWork@aol.com");
		EmailAddress jackProp2Unit19TenantEmail = new EmailAddress(jackProp2Unit19Tenant, false, "work", "VincenzaSchirpkeWork@aol.com");
		EmailAddress jackProp2Unit20TenantEmail = new EmailAddress(jackProp2Unit20Tenant, false, "work", "ErickDickersonWork@aol.com");
		EmailAddress joeyProp1Unit1TenantEmail = new EmailAddress(joeyProp1Unit1Tenant, false, "work", "LashaundaMartabanoWork@aol.com");
		EmailAddress joeyProp1Unit2TenantEmail = new EmailAddress(joeyProp1Unit2Tenant, false, "work", "EdnaLapageWork@aol.com");
		EmailAddress joeyProp1Unit4TenantEmail = new EmailAddress(joeyProp1Unit4Tenant, false, "work", "AnnabelleHeimannWork@aol.com");
		EmailAddress joeyProp1Unit6TenantEmail = new EmailAddress(joeyProp1Unit6Tenant, false, "work", "ErickKalafatisWork@aol.com");
		EmailAddress joeyProp1Unit7TenantEmail = new EmailAddress(joeyProp1Unit7Tenant, false, "work", "HowardSyropWork@aol.com");
		EmailAddress joeyProp1Unit8TenantEmail = new EmailAddress(joeyProp1Unit8Tenant, false, "work", "HeikeFunnellWork@aol.com");
		EmailAddress joeyProp1Unit9TenantEmail = new EmailAddress(joeyProp1Unit9Tenant, false, "work", "BrittniGotterWork@aol.com");
		EmailAddress joeyProp1Unit10TenantEmail = new EmailAddress(joeyProp1Unit10Tenant, false, "work", "CasieIsaacsWork@aol.com");
		EmailAddress joeyProp1Unit11TenantEmail = new EmailAddress(joeyProp1Unit11Tenant, false, "work", "EdnaFollerWork@aol.com");
		EmailAddress joeyProp1Unit12TenantEmail = new EmailAddress(joeyProp1Unit12Tenant, false, "work", "EvangelinaJuhasWork@aol.com");
		EmailAddress joeyProp1Unit14TenantEmail = new EmailAddress(joeyProp1Unit14Tenant, false, "work", "ChristianeGatoWork@aol.com");
		EmailAddress joeyProp1Unit15TenantEmail = new EmailAddress(joeyProp1Unit15Tenant, false, "work", "VivaKorandoWork@aol.com");
		EmailAddress joeProp1Unit1TenantEmail = new EmailAddress(joeProp1Unit1Tenant, false, "work", "CherryNaboursWork@aol.com");
		EmailAddress joeProp2Unit1TenantEmail = new EmailAddress(joeProp2Unit1Tenant, false, "work", "ReenaKoppingerWork@aol.com");
		EmailAddress joeProp3Unit1TenantEmail = new EmailAddress(joeProp3Unit1Tenant, false, "work", "HelaineMonterrubioWork@aol.com");
		EmailAddress joeProp4Unit1TenantEmail = new EmailAddress(joeProp4Unit1Tenant, false, "work", "ShenikaBildenWork@aol.com");
		EmailAddress janeProp1Unit1TenantEmail = new EmailAddress(janeProp1Unit1Tenant, false, "work", "DonetteLotherWork@aol.com");
		EmailAddress janeProp1Unit2TenantEmail = new EmailAddress(janeProp1Unit2Tenant, false, "work", "BetteRiopelleWork@aol.com");
		EmailAddress janeProp1Unit4TenantEmail = new EmailAddress(janeProp1Unit4Tenant, false, "work", "HermilaYglesiasWork@aol.com");
		EmailAddress janeProp1Unit6TenantEmail = new EmailAddress(janeProp1Unit6Tenant, false, "work", "RainaMelnykWork@aol.com");
		EmailAddress janeProp1Unit7TenantEmail = new EmailAddress(janeProp1Unit7Tenant, false, "work", "GlennSchirpkeWork@aol.com");
		EmailAddress janeProp1Unit8TenantEmail = new EmailAddress(janeProp1Unit8Tenant, false, "work", "RayleneLabrecheWork@aol.com");
		EmailAddress janeProp1Unit9TenantEmail = new EmailAddress(janeProp1Unit9Tenant, false, "work", "MalcolmThreetsWork@aol.com");
		EmailAddress janeProp1Unit10TenantEmail = new EmailAddress(janeProp1Unit10Tenant, false, "work", "ErickRochinWork@aol.com");
		EmailAddress janeProp1Unit11TenantEmail = new EmailAddress(janeProp1Unit11Tenant, false, "work", "MirtaCorbleyWork@aol.com");
		EmailAddress janeProp1Unit12TenantEmail = new EmailAddress(janeProp1Unit12Tenant, false, "work", "FelixGoldammerWork@aol.com");
		EmailAddress janeProp1Unit14TenantEmail = new EmailAddress(janeProp1Unit14Tenant, false, "work", "RegeniaWolfgrammWork@aol.com");
		EmailAddress janeProp1Unit15TenantEmail = new EmailAddress(janeProp1Unit15Tenant, false, "work", "ColetteKardasWork@aol.com");
		EmailAddress robertProp1Unit1TenantEmail = new EmailAddress(robertProp1Unit1Tenant, false, "work", "MarkusAredondoWork@aol.com");
		EmailAddress robertProp1Unit2TenantEmail = new EmailAddress(robertProp1Unit2Tenant, false, "work", "BarbraThreetsWork@aol.com");
		EmailAddress robertProp2Unit1TenantEmail = new EmailAddress(robertProp2Unit1Tenant, false, "work", "LiliCorrioWork@aol.com");
		EmailAddress robertProp2Unit2TenantEmail = new EmailAddress(robertProp2Unit2Tenant, false, "work", "JenniferThybergWork@aol.com");
		EmailAddress robertProp3Unit1TenantEmail = new EmailAddress(robertProp3Unit1Tenant, false, "work", "HeikeLungrenWork@aol.com");
		EmailAddress robertProp3Unit2TenantEmail = new EmailAddress(robertProp3Unit2Tenant, false, "work", "KrisClauchertyWork@aol.com");		
	
		DbFunctions.insert(jackProp1Unit1TenantEmail);
		DbFunctions.insert(jackProp2Unit1TenantEmail);
		DbFunctions.insert(jackProp2Unit2TenantEmail);
		DbFunctions.insert(jackProp2Unit4TenantEmail);
		DbFunctions.insert(jackProp2Unit6TenantEmail);
		DbFunctions.insert(jackProp2Unit7TenantEmail);
		DbFunctions.insert(jackProp2Unit8TenantEmail);
		DbFunctions.insert(jackProp2Unit9TenantEmail);
		DbFunctions.insert(jackProp2Unit10TenantEmail);
		DbFunctions.insert(jackProp2Unit11TenantEmail);
		DbFunctions.insert(jackProp2Unit12TenantEmail);
		DbFunctions.insert(jackProp2Unit14TenantEmail);
		DbFunctions.insert(jackProp2Unit15TenantEmail);
		DbFunctions.insert(jackProp2Unit16TenantEmail);
		DbFunctions.insert(jackProp2Unit17TenantEmail);
		DbFunctions.insert(jackProp2Unit18TenantEmail);
		DbFunctions.insert(jackProp2Unit19TenantEmail);
		DbFunctions.insert(jackProp2Unit20TenantEmail);
		DbFunctions.insert(joeyProp1Unit1TenantEmail);
		DbFunctions.insert(joeyProp1Unit2TenantEmail);
		DbFunctions.insert(joeyProp1Unit4TenantEmail);
		DbFunctions.insert(joeyProp1Unit6TenantEmail);
		DbFunctions.insert(joeyProp1Unit7TenantEmail);
		DbFunctions.insert(joeyProp1Unit8TenantEmail);
		DbFunctions.insert(joeyProp1Unit9TenantEmail);
		DbFunctions.insert(joeyProp1Unit10TenantEmail);
		DbFunctions.insert(joeyProp1Unit11TenantEmail);
		DbFunctions.insert(joeyProp1Unit12TenantEmail);
		DbFunctions.insert(joeyProp1Unit14TenantEmail);
		DbFunctions.insert(joeyProp1Unit15TenantEmail);
		DbFunctions.insert(joeProp1Unit1TenantEmail);
		DbFunctions.insert(joeProp2Unit1TenantEmail);
		DbFunctions.insert(joeProp3Unit1TenantEmail);
		DbFunctions.insert(joeProp4Unit1TenantEmail);
		DbFunctions.insert(janeProp1Unit1TenantEmail);
		DbFunctions.insert(janeProp1Unit2TenantEmail);
		DbFunctions.insert(janeProp1Unit4TenantEmail);
		DbFunctions.insert(janeProp1Unit6TenantEmail);
		DbFunctions.insert(janeProp1Unit7TenantEmail);
		DbFunctions.insert(janeProp1Unit8TenantEmail);
		DbFunctions.insert(janeProp1Unit9TenantEmail);
		DbFunctions.insert(janeProp1Unit10TenantEmail);
		DbFunctions.insert(janeProp1Unit11TenantEmail);
		DbFunctions.insert(janeProp1Unit12TenantEmail);
		DbFunctions.insert(janeProp1Unit14TenantEmail);
		DbFunctions.insert(janeProp1Unit15TenantEmail);
		DbFunctions.insert(robertProp1Unit1TenantEmail);
		DbFunctions.insert(robertProp1Unit2TenantEmail);
		DbFunctions.insert(robertProp2Unit1TenantEmail);
		DbFunctions.insert(robertProp2Unit2TenantEmail);
		DbFunctions.insert(robertProp3Unit1TenantEmail);
		DbFunctions.insert(robertProp3Unit2TenantEmail);
		
		
		EmailAddress jackProp1Unit1TenantHomeEmail = new EmailAddress(jackProp1Unit1Tenant, true, "home", "TawnaVillanuevaHome@aol.com");
		EmailAddress jackProp2Unit1TenantHomeEmail = new EmailAddress(jackProp2Unit1Tenant, true, "home", "VirgieBevelacquaHome@aol.com");
		EmailAddress jackProp2Unit2TenantHomeEmail = new EmailAddress(jackProp2Unit2Tenant, true, "home", "MargueritaLouissantHome@aol.com");
		EmailAddress jackProp2Unit4TenantHomeEmail = new EmailAddress(jackProp2Unit4Tenant, true, "home", "KristeenPaaHome@aol.com");
		EmailAddress jackProp2Unit6TenantHomeEmail = new EmailAddress(jackProp2Unit6Tenant, true, "home", "AlexPaulasHome@aol.com");
		EmailAddress jackProp2Unit7TenantHomeEmail = new EmailAddress(jackProp2Unit7Tenant, true, "home", "WynellHanafanHome@aol.com");
		EmailAddress jackProp2Unit8TenantHomeEmail = new EmailAddress(jackProp2Unit8Tenant, true, "home", "TarynLietzHome@aol.com");
		EmailAddress jackProp2Unit9TenantHomeEmail = new EmailAddress(jackProp2Unit9Tenant, true, "home", "AmmieBirknerHome@aol.com");
		EmailAddress jackProp2Unit10TenantHomeEmail = new EmailAddress(jackProp2Unit10Tenant, true, "home", "IluminadaZurcherHome@aol.com");
		EmailAddress jackProp2Unit11TenantHomeEmail = new EmailAddress(jackProp2Unit11Tenant, true, "home", "JaclynMadarangHome@aol.com");
		EmailAddress jackProp2Unit12TenantHomeEmail = new EmailAddress(jackProp2Unit12Tenant, true, "home", "RainaNachorHome@aol.com");
		EmailAddress jackProp2Unit14TenantHomeEmail = new EmailAddress(jackProp2Unit14Tenant, true, "home", "LennaHamiltonHome@aol.com");
		EmailAddress jackProp2Unit15TenantHomeEmail = new EmailAddress(jackProp2Unit15Tenant, true, "home", "OzellNicolozakesHome@aol.com");
		EmailAddress jackProp2Unit16TenantHomeEmail = new EmailAddress(jackProp2Unit16Tenant, true, "home", "MozellChaffinsHome@aol.com");
		EmailAddress jackProp2Unit17TenantHomeEmail = new EmailAddress(jackProp2Unit17Tenant, true, "home", "SylvieTrestonHome@aol.com");
		EmailAddress jackProp2Unit18TenantHomeEmail = new EmailAddress(jackProp2Unit18Tenant, true, "home", "BernardineJillsonHome@aol.com");
		EmailAddress jackProp2Unit19TenantHomeEmail = new EmailAddress(jackProp2Unit19Tenant, true, "home", "VincenzaSchirpkeHome@aol.com");
		EmailAddress jackProp2Unit20TenantHomeEmail = new EmailAddress(jackProp2Unit20Tenant, true, "home", "ErickDickersonHome@aol.com");
		EmailAddress joeyProp1Unit1TenantHomeEmail = new EmailAddress(joeyProp1Unit1Tenant, true, "home", "LashaundaMartabanoHome@aol.com");
		EmailAddress joeyProp1Unit2TenantHomeEmail = new EmailAddress(joeyProp1Unit2Tenant, true, "home", "EdnaLapageHome@aol.com");
		EmailAddress joeyProp1Unit4TenantHomeEmail = new EmailAddress(joeyProp1Unit4Tenant, true, "home", "AnnabelleHeimannHome@aol.com");
		EmailAddress joeyProp1Unit6TenantHomeEmail = new EmailAddress(joeyProp1Unit6Tenant, true, "home", "ErickKalafatisHome@aol.com");
		EmailAddress joeyProp1Unit7TenantHomeEmail = new EmailAddress(joeyProp1Unit7Tenant, true, "home", "HowardSyropHome@aol.com");
		EmailAddress joeyProp1Unit8TenantHomeEmail = new EmailAddress(joeyProp1Unit8Tenant, true, "home", "HeikeFunnellHome@aol.com");
		EmailAddress joeyProp1Unit9TenantHomeEmail = new EmailAddress(joeyProp1Unit9Tenant, true, "home", "BrittniGotterHome@aol.com");
		EmailAddress joeyProp1Unit10TenantHomeEmail = new EmailAddress(joeyProp1Unit10Tenant, true, "home", "CasieIsaacsHome@aol.com");
		EmailAddress joeyProp1Unit11TenantHomeEmail = new EmailAddress(joeyProp1Unit11Tenant, true, "home", "EdnaFollerHome@aol.com");
		EmailAddress joeyProp1Unit12TenantHomeEmail = new EmailAddress(joeyProp1Unit12Tenant, true, "home", "EvangelinaJuhasHome@aol.com");
		EmailAddress joeyProp1Unit14TenantHomeEmail = new EmailAddress(joeyProp1Unit14Tenant, true, "home", "ChristianeGatoHome@aol.com");
		EmailAddress joeyProp1Unit15TenantHomeEmail = new EmailAddress(joeyProp1Unit15Tenant, true, "home", "VivaKorandoHome@aol.com");
		EmailAddress joeProp1Unit1TenantHomeEmail = new EmailAddress(joeProp1Unit1Tenant, true, "home", "CherryNaboursHome@aol.com");
		EmailAddress joeProp2Unit1TenantHomeEmail = new EmailAddress(joeProp2Unit1Tenant, true, "home", "ReenaKoppingerHome@aol.com");
		EmailAddress joeProp3Unit1TenantHomeEmail = new EmailAddress(joeProp3Unit1Tenant, true, "home", "HelaineMonterrubioHome@aol.com");
		EmailAddress joeProp4Unit1TenantHomeEmail = new EmailAddress(joeProp4Unit1Tenant, true, "home", "ShenikaBildenHome@aol.com");
		EmailAddress janeProp1Unit1TenantHomeEmail = new EmailAddress(janeProp1Unit1Tenant, true, "home", "DonetteLotherHome@aol.com");
		EmailAddress janeProp1Unit2TenantHomeEmail = new EmailAddress(janeProp1Unit2Tenant, true, "home", "BetteRiopelleHome@aol.com");
		EmailAddress janeProp1Unit4TenantHomeEmail = new EmailAddress(janeProp1Unit4Tenant, true, "home", "HermilaYglesiasHome@aol.com");
		EmailAddress janeProp1Unit6TenantHomeEmail = new EmailAddress(janeProp1Unit6Tenant, true, "home", "RainaMelnykHome@aol.com");
		EmailAddress janeProp1Unit7TenantHomeEmail = new EmailAddress(janeProp1Unit7Tenant, true, "home", "GlennSchirpkeHome@aol.com");
		EmailAddress janeProp1Unit8TenantHomeEmail = new EmailAddress(janeProp1Unit8Tenant, true, "home", "RayleneLabrecheHome@aol.com");
		EmailAddress janeProp1Unit9TenantHomeEmail = new EmailAddress(janeProp1Unit9Tenant, true, "home", "MalcolmThreetsHome@aol.com");
		EmailAddress janeProp1Unit10TenantHomeEmail = new EmailAddress(janeProp1Unit10Tenant, true, "home", "ErickRochinHome@aol.com");
		EmailAddress janeProp1Unit11TenantHomeEmail = new EmailAddress(janeProp1Unit11Tenant, true, "home", "MirtaCorbleyHome@aol.com");
		EmailAddress janeProp1Unit12TenantHomeEmail = new EmailAddress(janeProp1Unit12Tenant, true, "home", "FelixGoldammerHome@aol.com");
		EmailAddress janeProp1Unit14TenantHomeEmail = new EmailAddress(janeProp1Unit14Tenant, true, "home", "RegeniaWolfgrammHome@aol.com");
		EmailAddress janeProp1Unit15TenantHomeEmail = new EmailAddress(janeProp1Unit15Tenant, true, "home", "ColetteKardasHome@aol.com");
		EmailAddress robertProp1Unit1TenantHomeEmail = new EmailAddress(robertProp1Unit1Tenant, true, "home", "MarkusAredondoHome@aol.com");
		EmailAddress robertProp1Unit2TenantHomeEmail = new EmailAddress(robertProp1Unit2Tenant, true, "home", "BarbraThreetsHome@aol.com");
		EmailAddress robertProp2Unit1TenantHomeEmail = new EmailAddress(robertProp2Unit1Tenant, true, "home", "LiliCorrioHome@aol.com");
		EmailAddress robertProp2Unit2TenantHomeEmail = new EmailAddress(robertProp2Unit2Tenant, true, "home", "JenniferThybergHome@aol.com");
		EmailAddress robertProp3Unit1TenantHomeEmail = new EmailAddress(robertProp3Unit1Tenant, true, "home", "HeikeLungrenHome@aol.com");
		EmailAddress robertProp3Unit2TenantHomeEmail = new EmailAddress(robertProp3Unit2Tenant, true, "home", "KrisClauchertyHome@aol.com");
		
		
		DbFunctions.insert(jackProp1Unit1TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit1TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit2TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit4TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit6TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit7TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit8TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit9TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit10TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit11TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit12TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit14TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit15TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit16TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit17TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit18TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit19TenantHomeEmail);
		DbFunctions.insert(jackProp2Unit20TenantHomeEmail);
		DbFunctions.insert(joeyProp1Unit1TenantHomeEmail);
		DbFunctions.insert(joeyProp1Unit2TenantHomeEmail);
		DbFunctions.insert(joeyProp1Unit4TenantHomeEmail);
		DbFunctions.insert(joeyProp1Unit6TenantHomeEmail);
		DbFunctions.insert(joeyProp1Unit7TenantHomeEmail);
		DbFunctions.insert(joeyProp1Unit8TenantHomeEmail);
		DbFunctions.insert(joeyProp1Unit9TenantHomeEmail);
		DbFunctions.insert(joeyProp1Unit10TenantHomeEmail);
		DbFunctions.insert(joeyProp1Unit11TenantHomeEmail);
		DbFunctions.insert(joeyProp1Unit12TenantHomeEmail);
		DbFunctions.insert(joeyProp1Unit14TenantHomeEmail);
		DbFunctions.insert(joeyProp1Unit15TenantHomeEmail);
		DbFunctions.insert(joeProp1Unit1TenantHomeEmail);
		DbFunctions.insert(joeProp2Unit1TenantHomeEmail);
		DbFunctions.insert(joeProp3Unit1TenantHomeEmail);
		DbFunctions.insert(joeProp4Unit1TenantHomeEmail);
		DbFunctions.insert(janeProp1Unit1TenantHomeEmail);
		DbFunctions.insert(janeProp1Unit2TenantHomeEmail);
		DbFunctions.insert(janeProp1Unit4TenantHomeEmail);
		DbFunctions.insert(janeProp1Unit6TenantHomeEmail);
		DbFunctions.insert(janeProp1Unit7TenantHomeEmail);
		DbFunctions.insert(janeProp1Unit8TenantHomeEmail);
		DbFunctions.insert(janeProp1Unit9TenantHomeEmail);
		DbFunctions.insert(janeProp1Unit10TenantHomeEmail);
		DbFunctions.insert(janeProp1Unit11TenantHomeEmail);
		DbFunctions.insert(janeProp1Unit12TenantHomeEmail);
		DbFunctions.insert(janeProp1Unit14TenantHomeEmail);
		DbFunctions.insert(janeProp1Unit15TenantHomeEmail);
		DbFunctions.insert(robertProp1Unit1TenantHomeEmail);
		DbFunctions.insert(robertProp1Unit2TenantHomeEmail);
		DbFunctions.insert(robertProp2Unit1TenantHomeEmail);
		DbFunctions.insert(robertProp2Unit2TenantHomeEmail);
		DbFunctions.insert(robertProp3Unit1TenantHomeEmail);
		DbFunctions.insert(robertProp3Unit2TenantHomeEmail);
		
		PhoneNumber jackProp1Unit1TenantCellPhone =new PhoneNumber(jackProp1Unit1Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit1TenantCellPhone =new PhoneNumber(jackProp2Unit1Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit2TenantCellPhone =new PhoneNumber(jackProp2Unit2Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit4TenantCellPhone =new PhoneNumber(jackProp2Unit4Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit6TenantCellPhone =new PhoneNumber(jackProp2Unit6Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit7TenantCellPhone =new PhoneNumber(jackProp2Unit7Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit8TenantCellPhone =new PhoneNumber(jackProp2Unit8Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit9TenantCellPhone =new PhoneNumber(jackProp2Unit9Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit10TenantCellPhone =new PhoneNumber(jackProp2Unit10Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit11TenantCellPhone =new PhoneNumber(jackProp2Unit11Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit12TenantCellPhone =new PhoneNumber(jackProp2Unit12Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit14TenantCellPhone =new PhoneNumber(jackProp2Unit14Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit15TenantCellPhone =new PhoneNumber(jackProp2Unit15Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit16TenantCellPhone =new PhoneNumber(jackProp2Unit16Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit17TenantCellPhone =new PhoneNumber(jackProp2Unit17Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit18TenantCellPhone =new PhoneNumber(jackProp2Unit18Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit19TenantCellPhone =new PhoneNumber(jackProp2Unit19Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber jackProp2Unit20TenantCellPhone =new PhoneNumber(jackProp2Unit20Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeyProp1Unit1TenantCellPhone =new PhoneNumber(joeyProp1Unit1Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeyProp1Unit2TenantCellPhone =new PhoneNumber(joeyProp1Unit2Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeyProp1Unit4TenantCellPhone =new PhoneNumber(joeyProp1Unit4Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeyProp1Unit6TenantCellPhone =new PhoneNumber(joeyProp1Unit6Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeyProp1Unit7TenantCellPhone =new PhoneNumber(joeyProp1Unit7Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeyProp1Unit8TenantCellPhone =new PhoneNumber(joeyProp1Unit8Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeyProp1Unit9TenantCellPhone =new PhoneNumber(joeyProp1Unit9Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeyProp1Unit10TenantCellPhone =new PhoneNumber(joeyProp1Unit10Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeyProp1Unit11TenantCellPhone =new PhoneNumber(joeyProp1Unit11Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeyProp1Unit12TenantCellPhone =new PhoneNumber(joeyProp1Unit12Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeyProp1Unit14TenantCellPhone =new PhoneNumber(joeyProp1Unit14Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeyProp1Unit15TenantCellPhone =new PhoneNumber(joeyProp1Unit15Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeProp1Unit1TenantCellPhone =new PhoneNumber(joeProp1Unit1Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeProp2Unit1TenantCellPhone =new PhoneNumber(joeProp2Unit1Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeProp3Unit1TenantCellPhone =new PhoneNumber(joeProp3Unit1Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber joeProp4Unit1TenantCellPhone =new PhoneNumber(joeProp4Unit1Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber janeProp1Unit1TenantCellPhone =new PhoneNumber(janeProp1Unit1Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber janeProp1Unit2TenantCellPhone =new PhoneNumber(janeProp1Unit2Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber janeProp1Unit4TenantCellPhone =new PhoneNumber(janeProp1Unit4Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber janeProp1Unit6TenantCellPhone =new PhoneNumber(janeProp1Unit6Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber janeProp1Unit7TenantCellPhone =new PhoneNumber(janeProp1Unit7Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber janeProp1Unit8TenantCellPhone =new PhoneNumber(janeProp1Unit8Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber janeProp1Unit9TenantCellPhone =new PhoneNumber(janeProp1Unit9Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber janeProp1Unit10TenantCellPhone =new PhoneNumber(janeProp1Unit10Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber janeProp1Unit11TenantCellPhone =new PhoneNumber(janeProp1Unit11Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber janeProp1Unit12TenantCellPhone =new PhoneNumber(janeProp1Unit12Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber janeProp1Unit14TenantCellPhone =new PhoneNumber(janeProp1Unit14Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber janeProp1Unit15TenantCellPhone =new PhoneNumber(janeProp1Unit15Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber robertProp1Unit1TenantCellPhone =new PhoneNumber(robertProp1Unit1Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber robertProp1Unit2TenantCellPhone =new PhoneNumber(robertProp1Unit2Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber robertProp2Unit1TenantCellPhone =new PhoneNumber(robertProp2Unit1Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber robertProp2Unit2TenantCellPhone =new PhoneNumber(robertProp2Unit2Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber robertProp3Unit1TenantCellPhone =new PhoneNumber(robertProp3Unit1Tenant, false , "Cell" , "512-447-1234");
		PhoneNumber robertProp3Unit2TenantCellPhone =new PhoneNumber(robertProp3Unit2Tenant, false , "Cell" , "512-447-1234");		
		
		DbFunctions.insert(jackProp1Unit1TenantCellPhone);
		DbFunctions.insert(jackProp2Unit1TenantCellPhone);
		DbFunctions.insert(jackProp2Unit2TenantCellPhone);
		DbFunctions.insert(jackProp2Unit4TenantCellPhone);
		DbFunctions.insert(jackProp2Unit6TenantCellPhone);
		DbFunctions.insert(jackProp2Unit7TenantCellPhone);
		DbFunctions.insert(jackProp2Unit8TenantCellPhone);
		DbFunctions.insert(jackProp2Unit9TenantCellPhone);
		DbFunctions.insert(jackProp2Unit10TenantCellPhone);
		DbFunctions.insert(jackProp2Unit11TenantCellPhone);
		DbFunctions.insert(jackProp2Unit12TenantCellPhone);
		DbFunctions.insert(jackProp2Unit14TenantCellPhone);
		DbFunctions.insert(jackProp2Unit15TenantCellPhone);
		DbFunctions.insert(jackProp2Unit16TenantCellPhone);
		DbFunctions.insert(jackProp2Unit17TenantCellPhone);
		DbFunctions.insert(jackProp2Unit18TenantCellPhone);
		DbFunctions.insert(jackProp2Unit19TenantCellPhone);
		DbFunctions.insert(jackProp2Unit20TenantCellPhone);
		DbFunctions.insert(joeyProp1Unit1TenantCellPhone);
		DbFunctions.insert(joeyProp1Unit2TenantCellPhone);
		DbFunctions.insert(joeyProp1Unit4TenantCellPhone);
		DbFunctions.insert(joeyProp1Unit6TenantCellPhone);
		DbFunctions.insert(joeyProp1Unit7TenantCellPhone);
		DbFunctions.insert(joeyProp1Unit8TenantCellPhone);
		DbFunctions.insert(joeyProp1Unit9TenantCellPhone);
		DbFunctions.insert(joeyProp1Unit10TenantCellPhone);
		DbFunctions.insert(joeyProp1Unit11TenantCellPhone);
		DbFunctions.insert(joeyProp1Unit12TenantCellPhone);
		DbFunctions.insert(joeyProp1Unit14TenantCellPhone);
		DbFunctions.insert(joeyProp1Unit15TenantCellPhone);
		DbFunctions.insert(joeProp1Unit1TenantCellPhone);
		DbFunctions.insert(joeProp2Unit1TenantCellPhone);
		DbFunctions.insert(joeProp3Unit1TenantCellPhone);
		DbFunctions.insert(joeProp4Unit1TenantCellPhone);
		DbFunctions.insert(janeProp1Unit1TenantCellPhone);
		DbFunctions.insert(janeProp1Unit2TenantCellPhone);
		DbFunctions.insert(janeProp1Unit4TenantCellPhone);
		DbFunctions.insert(janeProp1Unit6TenantCellPhone);
		DbFunctions.insert(janeProp1Unit7TenantCellPhone);
		DbFunctions.insert(janeProp1Unit8TenantCellPhone);
		DbFunctions.insert(janeProp1Unit9TenantCellPhone);
		DbFunctions.insert(janeProp1Unit10TenantCellPhone);
		DbFunctions.insert(janeProp1Unit11TenantCellPhone);
		DbFunctions.insert(janeProp1Unit12TenantCellPhone);
		DbFunctions.insert(janeProp1Unit14TenantCellPhone);
		DbFunctions.insert(janeProp1Unit15TenantCellPhone);
		DbFunctions.insert(robertProp1Unit1TenantCellPhone);
		DbFunctions.insert(robertProp1Unit2TenantCellPhone);
		DbFunctions.insert(robertProp2Unit1TenantCellPhone);
		DbFunctions.insert(robertProp2Unit2TenantCellPhone);
		DbFunctions.insert(robertProp3Unit1TenantCellPhone);
		DbFunctions.insert(robertProp3Unit2TenantCellPhone);
		
		
		PhoneNumber jackProp1Unit1TenantHomePhone =new PhoneNumber(jackProp1Unit1Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit1TenantHomePhone =new PhoneNumber(jackProp2Unit1Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit2TenantHomePhone =new PhoneNumber(jackProp2Unit2Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit4TenantHomePhone =new PhoneNumber(jackProp2Unit4Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit6TenantHomePhone =new PhoneNumber(jackProp2Unit6Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit7TenantHomePhone =new PhoneNumber(jackProp2Unit7Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit8TenantHomePhone =new PhoneNumber(jackProp2Unit8Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit9TenantHomePhone =new PhoneNumber(jackProp2Unit9Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit10TenantHomePhone =new PhoneNumber(jackProp2Unit10Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit11TenantHomePhone =new PhoneNumber(jackProp2Unit11Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit12TenantHomePhone =new PhoneNumber(jackProp2Unit12Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit14TenantHomePhone =new PhoneNumber(jackProp2Unit14Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit15TenantHomePhone =new PhoneNumber(jackProp2Unit15Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit16TenantHomePhone =new PhoneNumber(jackProp2Unit16Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit17TenantHomePhone =new PhoneNumber(jackProp2Unit17Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit18TenantHomePhone =new PhoneNumber(jackProp2Unit18Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit19TenantHomePhone =new PhoneNumber(jackProp2Unit19Tenant, true , "Home" , "512-447-1234");
		PhoneNumber jackProp2Unit20TenantHomePhone =new PhoneNumber(jackProp2Unit20Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeyProp1Unit1TenantHomePhone =new PhoneNumber(joeyProp1Unit1Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeyProp1Unit2TenantHomePhone =new PhoneNumber(joeyProp1Unit2Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeyProp1Unit4TenantHomePhone =new PhoneNumber(joeyProp1Unit4Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeyProp1Unit6TenantHomePhone =new PhoneNumber(joeyProp1Unit6Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeyProp1Unit7TenantHomePhone =new PhoneNumber(joeyProp1Unit7Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeyProp1Unit8TenantHomePhone =new PhoneNumber(joeyProp1Unit8Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeyProp1Unit9TenantHomePhone =new PhoneNumber(joeyProp1Unit9Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeyProp1Unit10TenantHomePhone =new PhoneNumber(joeyProp1Unit10Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeyProp1Unit11TenantHomePhone =new PhoneNumber(joeyProp1Unit11Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeyProp1Unit12TenantHomePhone =new PhoneNumber(joeyProp1Unit12Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeyProp1Unit14TenantHomePhone =new PhoneNumber(joeyProp1Unit14Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeyProp1Unit15TenantHomePhone =new PhoneNumber(joeyProp1Unit15Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeProp1Unit1TenantHomePhone =new PhoneNumber(joeProp1Unit1Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeProp2Unit1TenantHomePhone =new PhoneNumber(joeProp2Unit1Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeProp3Unit1TenantHomePhone =new PhoneNumber(joeProp3Unit1Tenant, true , "Home" , "512-447-1234");
		PhoneNumber joeProp4Unit1TenantHomePhone =new PhoneNumber(joeProp4Unit1Tenant, true , "Home" , "512-447-1234");
		PhoneNumber janeProp1Unit1TenantHomePhone =new PhoneNumber(janeProp1Unit1Tenant, true , "Home" , "512-447-1234");
		PhoneNumber janeProp1Unit2TenantHomePhone =new PhoneNumber(janeProp1Unit2Tenant, true , "Home" , "512-447-1234");
		PhoneNumber janeProp1Unit4TenantHomePhone =new PhoneNumber(janeProp1Unit4Tenant, true , "Home" , "512-447-1234");
		PhoneNumber janeProp1Unit6TenantHomePhone =new PhoneNumber(janeProp1Unit6Tenant, true , "Home" , "512-447-1234");
		PhoneNumber janeProp1Unit7TenantHomePhone =new PhoneNumber(janeProp1Unit7Tenant, true , "Home" , "512-447-1234");
		PhoneNumber janeProp1Unit8TenantHomePhone =new PhoneNumber(janeProp1Unit8Tenant, true , "Home" , "512-447-1234");
		PhoneNumber janeProp1Unit9TenantHomePhone =new PhoneNumber(janeProp1Unit9Tenant, true , "Home" , "512-447-1234");
		PhoneNumber janeProp1Unit10TenantHomePhone =new PhoneNumber(janeProp1Unit10Tenant, true , "Home" , "512-447-1234");
		PhoneNumber janeProp1Unit11TenantHomePhone =new PhoneNumber(janeProp1Unit11Tenant, true , "Home" , "512-447-1234");
		PhoneNumber janeProp1Unit12TenantHomePhone =new PhoneNumber(janeProp1Unit12Tenant, true , "Home" , "512-447-1234");
		PhoneNumber janeProp1Unit14TenantHomePhone =new PhoneNumber(janeProp1Unit14Tenant, true , "Home" , "512-447-1234");
		PhoneNumber janeProp1Unit15TenantHomePhone =new PhoneNumber(janeProp1Unit15Tenant, true , "Home" , "512-447-1234");
		PhoneNumber robertProp1Unit1TenantHomePhone =new PhoneNumber(robertProp1Unit1Tenant, true , "Home" , "512-447-1234");
		PhoneNumber robertProp1Unit2TenantHomePhone =new PhoneNumber(robertProp1Unit2Tenant, true , "Home" , "512-447-1234");
		PhoneNumber robertProp2Unit1TenantHomePhone =new PhoneNumber(robertProp2Unit1Tenant, true , "Home" , "512-447-1234");
		PhoneNumber robertProp2Unit2TenantHomePhone =new PhoneNumber(robertProp2Unit2Tenant, true , "Home" , "512-447-1234");
		PhoneNumber robertProp3Unit1TenantHomePhone =new PhoneNumber(robertProp3Unit1Tenant, true , "Home" , "512-447-1234");
		PhoneNumber robertProp3Unit2TenantHomePhone =new PhoneNumber(robertProp3Unit2Tenant, true , "Home" , "512-447-1234");
		
		DbFunctions.insert(jackProp1Unit1TenantHomePhone);
		DbFunctions.insert(jackProp2Unit1TenantHomePhone);
		DbFunctions.insert(jackProp2Unit2TenantHomePhone);
		DbFunctions.insert(jackProp2Unit4TenantHomePhone);
		DbFunctions.insert(jackProp2Unit6TenantHomePhone);
		DbFunctions.insert(jackProp2Unit7TenantHomePhone);
		DbFunctions.insert(jackProp2Unit8TenantHomePhone);
		DbFunctions.insert(jackProp2Unit9TenantHomePhone);
		DbFunctions.insert(jackProp2Unit10TenantHomePhone);
		DbFunctions.insert(jackProp2Unit11TenantHomePhone);
		DbFunctions.insert(jackProp2Unit12TenantHomePhone);
		DbFunctions.insert(jackProp2Unit14TenantHomePhone);
		DbFunctions.insert(jackProp2Unit15TenantHomePhone);
		DbFunctions.insert(jackProp2Unit16TenantHomePhone);
		DbFunctions.insert(jackProp2Unit17TenantHomePhone);
		DbFunctions.insert(jackProp2Unit18TenantHomePhone);
		DbFunctions.insert(jackProp2Unit19TenantHomePhone);
		DbFunctions.insert(jackProp2Unit20TenantHomePhone);
		DbFunctions.insert(joeyProp1Unit1TenantHomePhone);
		DbFunctions.insert(joeyProp1Unit2TenantHomePhone);
		DbFunctions.insert(joeyProp1Unit4TenantHomePhone);
		DbFunctions.insert(joeyProp1Unit6TenantHomePhone);
		DbFunctions.insert(joeyProp1Unit7TenantHomePhone);
		DbFunctions.insert(joeyProp1Unit8TenantHomePhone);
		DbFunctions.insert(joeyProp1Unit9TenantHomePhone);
		DbFunctions.insert(joeyProp1Unit10TenantHomePhone);
		DbFunctions.insert(joeyProp1Unit11TenantHomePhone);
		DbFunctions.insert(joeyProp1Unit12TenantHomePhone);
		DbFunctions.insert(joeyProp1Unit14TenantHomePhone);
		DbFunctions.insert(joeyProp1Unit15TenantHomePhone);
		DbFunctions.insert(joeProp1Unit1TenantHomePhone);
		DbFunctions.insert(joeProp2Unit1TenantHomePhone);
		DbFunctions.insert(joeProp3Unit1TenantHomePhone);
		DbFunctions.insert(joeProp4Unit1TenantHomePhone);
		DbFunctions.insert(janeProp1Unit1TenantHomePhone);
		DbFunctions.insert(janeProp1Unit2TenantHomePhone);
		DbFunctions.insert(janeProp1Unit4TenantHomePhone);
		DbFunctions.insert(janeProp1Unit6TenantHomePhone);
		DbFunctions.insert(janeProp1Unit7TenantHomePhone);
		DbFunctions.insert(janeProp1Unit8TenantHomePhone);
		DbFunctions.insert(janeProp1Unit9TenantHomePhone);
		DbFunctions.insert(janeProp1Unit10TenantHomePhone);
		DbFunctions.insert(janeProp1Unit11TenantHomePhone);
		DbFunctions.insert(janeProp1Unit12TenantHomePhone);
		DbFunctions.insert(janeProp1Unit14TenantHomePhone);
		DbFunctions.insert(janeProp1Unit15TenantHomePhone);
		DbFunctions.insert(robertProp1Unit1TenantHomePhone);
		DbFunctions.insert(robertProp1Unit2TenantHomePhone);
		DbFunctions.insert(robertProp2Unit1TenantHomePhone);
		DbFunctions.insert(robertProp2Unit2TenantHomePhone);
		DbFunctions.insert(robertProp3Unit1TenantHomePhone);
		DbFunctions.insert(robertProp3Unit2TenantHomePhone);
		
		PhoneNumber jackProp1Unit1TenantWorkPhone =new PhoneNumber(jackProp1Unit1Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit1TenantWorkPhone =new PhoneNumber(jackProp2Unit1Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit2TenantWorkPhone =new PhoneNumber(jackProp2Unit2Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit4TenantWorkPhone =new PhoneNumber(jackProp2Unit4Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit6TenantWorkPhone =new PhoneNumber(jackProp2Unit6Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit7TenantWorkPhone =new PhoneNumber(jackProp2Unit7Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit8TenantWorkPhone =new PhoneNumber(jackProp2Unit8Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit9TenantWorkPhone =new PhoneNumber(jackProp2Unit9Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit10TenantWorkPhone =new PhoneNumber(jackProp2Unit10Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit11TenantWorkPhone =new PhoneNumber(jackProp2Unit11Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit12TenantWorkPhone =new PhoneNumber(jackProp2Unit12Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit14TenantWorkPhone =new PhoneNumber(jackProp2Unit14Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit15TenantWorkPhone =new PhoneNumber(jackProp2Unit15Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit16TenantWorkPhone =new PhoneNumber(jackProp2Unit16Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit17TenantWorkPhone =new PhoneNumber(jackProp2Unit17Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit18TenantWorkPhone =new PhoneNumber(jackProp2Unit18Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit19TenantWorkPhone =new PhoneNumber(jackProp2Unit19Tenant, false , "Work" , "512-447-1234");
		PhoneNumber jackProp2Unit20TenantWorkPhone =new PhoneNumber(jackProp2Unit20Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeyProp1Unit1TenantWorkPhone =new PhoneNumber(joeyProp1Unit1Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeyProp1Unit2TenantWorkPhone =new PhoneNumber(joeyProp1Unit2Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeyProp1Unit4TenantWorkPhone =new PhoneNumber(joeyProp1Unit4Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeyProp1Unit6TenantWorkPhone =new PhoneNumber(joeyProp1Unit6Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeyProp1Unit7TenantWorkPhone =new PhoneNumber(joeyProp1Unit7Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeyProp1Unit8TenantWorkPhone =new PhoneNumber(joeyProp1Unit8Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeyProp1Unit9TenantWorkPhone =new PhoneNumber(joeyProp1Unit9Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeyProp1Unit10TenantWorkPhone =new PhoneNumber(joeyProp1Unit10Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeyProp1Unit11TenantWorkPhone =new PhoneNumber(joeyProp1Unit11Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeyProp1Unit12TenantWorkPhone =new PhoneNumber(joeyProp1Unit12Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeyProp1Unit14TenantWorkPhone =new PhoneNumber(joeyProp1Unit14Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeyProp1Unit15TenantWorkPhone =new PhoneNumber(joeyProp1Unit15Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeProp1Unit1TenantWorkPhone =new PhoneNumber(joeProp1Unit1Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeProp2Unit1TenantWorkPhone =new PhoneNumber(joeProp2Unit1Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeProp3Unit1TenantWorkPhone =new PhoneNumber(joeProp3Unit1Tenant, false , "Work" , "512-447-1234");
		PhoneNumber joeProp4Unit1TenantWorkPhone =new PhoneNumber(joeProp4Unit1Tenant, false , "Work" , "512-447-1234");
		PhoneNumber janeProp1Unit1TenantWorkPhone =new PhoneNumber(janeProp1Unit1Tenant, false , "Work" , "512-447-1234");
		PhoneNumber janeProp1Unit2TenantWorkPhone =new PhoneNumber(janeProp1Unit2Tenant, false , "Work" , "512-447-1234");
		PhoneNumber janeProp1Unit4TenantWorkPhone =new PhoneNumber(janeProp1Unit4Tenant, false , "Work" , "512-447-1234");
		PhoneNumber janeProp1Unit6TenantWorkPhone =new PhoneNumber(janeProp1Unit6Tenant, false , "Work" , "512-447-1234");
		PhoneNumber janeProp1Unit7TenantWorkPhone =new PhoneNumber(janeProp1Unit7Tenant, false , "Work" , "512-447-1234");
		PhoneNumber janeProp1Unit8TenantWorkPhone =new PhoneNumber(janeProp1Unit8Tenant, false , "Work" , "512-447-1234");
		PhoneNumber janeProp1Unit9TenantWorkPhone =new PhoneNumber(janeProp1Unit9Tenant, false , "Work" , "512-447-1234");
		PhoneNumber janeProp1Unit10TenantWorkPhone =new PhoneNumber(janeProp1Unit10Tenant, false , "Work" , "512-447-1234");
		PhoneNumber janeProp1Unit11TenantWorkPhone =new PhoneNumber(janeProp1Unit11Tenant, false , "Work" , "512-447-1234");
		PhoneNumber janeProp1Unit12TenantWorkPhone =new PhoneNumber(janeProp1Unit12Tenant, false , "Work" , "512-447-1234");
		PhoneNumber janeProp1Unit14TenantWorkPhone =new PhoneNumber(janeProp1Unit14Tenant, false , "Work" , "512-447-1234");
		PhoneNumber janeProp1Unit15TenantWorkPhone =new PhoneNumber(janeProp1Unit15Tenant, false , "Work" , "512-447-1234");
		PhoneNumber robertProp1Unit1TenantWorkPhone =new PhoneNumber(robertProp1Unit1Tenant, false , "Work" , "512-447-1234");
		PhoneNumber robertProp1Unit2TenantWorkPhone =new PhoneNumber(robertProp1Unit2Tenant, false , "Work" , "512-447-1234");
		PhoneNumber robertProp2Unit1TenantWorkPhone =new PhoneNumber(robertProp2Unit1Tenant, false , "Work" , "512-447-1234");
		PhoneNumber robertProp2Unit2TenantWorkPhone =new PhoneNumber(robertProp2Unit2Tenant, false , "Work" , "512-447-1234");
		PhoneNumber robertProp3Unit1TenantWorkPhone =new PhoneNumber(robertProp3Unit1Tenant, false , "Work" , "512-447-1234");
		PhoneNumber robertProp3Unit2TenantWorkPhone =new PhoneNumber(robertProp3Unit2Tenant, false , "Work" , "512-447-1234");
		
		
		DbFunctions.insert(jackProp1Unit1TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit1TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit2TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit4TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit6TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit7TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit8TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit9TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit10TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit11TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit12TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit14TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit15TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit16TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit17TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit18TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit19TenantWorkPhone);
		DbFunctions.insert(jackProp2Unit20TenantWorkPhone);
		DbFunctions.insert(joeyProp1Unit1TenantWorkPhone);
		DbFunctions.insert(joeyProp1Unit2TenantWorkPhone);
		DbFunctions.insert(joeyProp1Unit4TenantWorkPhone);
		DbFunctions.insert(joeyProp1Unit6TenantWorkPhone);
		DbFunctions.insert(joeyProp1Unit7TenantWorkPhone);
		DbFunctions.insert(joeyProp1Unit8TenantWorkPhone);
		DbFunctions.insert(joeyProp1Unit9TenantWorkPhone);
		DbFunctions.insert(joeyProp1Unit10TenantWorkPhone);
		DbFunctions.insert(joeyProp1Unit11TenantWorkPhone);
		DbFunctions.insert(joeyProp1Unit12TenantWorkPhone);
		DbFunctions.insert(joeyProp1Unit14TenantWorkPhone);
		DbFunctions.insert(joeyProp1Unit15TenantWorkPhone);
		DbFunctions.insert(joeProp1Unit1TenantWorkPhone);
		DbFunctions.insert(joeProp2Unit1TenantWorkPhone);
		DbFunctions.insert(joeProp3Unit1TenantWorkPhone);
		DbFunctions.insert(joeProp4Unit1TenantWorkPhone);
		DbFunctions.insert(janeProp1Unit1TenantWorkPhone);
		DbFunctions.insert(janeProp1Unit2TenantWorkPhone);
		DbFunctions.insert(janeProp1Unit4TenantWorkPhone);
		DbFunctions.insert(janeProp1Unit6TenantWorkPhone);
		DbFunctions.insert(janeProp1Unit7TenantWorkPhone);
		DbFunctions.insert(janeProp1Unit8TenantWorkPhone);
		DbFunctions.insert(janeProp1Unit9TenantWorkPhone);
		DbFunctions.insert(janeProp1Unit10TenantWorkPhone);
		DbFunctions.insert(janeProp1Unit11TenantWorkPhone);
		DbFunctions.insert(janeProp1Unit12TenantWorkPhone);
		DbFunctions.insert(janeProp1Unit14TenantWorkPhone);
		DbFunctions.insert(janeProp1Unit15TenantWorkPhone);
		DbFunctions.insert(robertProp1Unit1TenantWorkPhone);
		DbFunctions.insert(robertProp1Unit2TenantWorkPhone);
		DbFunctions.insert(robertProp2Unit1TenantWorkPhone);
		DbFunctions.insert(robertProp2Unit2TenantWorkPhone);
		DbFunctions.insert(robertProp3Unit1TenantWorkPhone);
		DbFunctions.insert(robertProp3Unit2TenantWorkPhone);
		
		

		
	
		Vendor vendor1 = new Vendor("Robert", "" , "Reyes", "Reyes HVAC", "HVAC",true);
		Vendor vendor2 = new Vendor( "Tawna", "Teddy", "Villanueva", "Austin HVAC", "HVAC", true);
		Vendor vendor3 = new Vendor( "Virgie", "Filiberto", "Bevelacqua", "Austin Handy Man", "General Repair", true);
		Vendor vendor4 = new Vendor( "Marguerita", "Weldon", "Louissant", "Joe's landscaping", "Landscaping", true);
		Vendor vendor5 = new Vendor( "Kristeen", "Virgie", "Paa", "John's Plumbing", "Plumbing", true);
		Vendor vendor6 = new Vendor( "Alex", "Taryn", "Paulas", "Debbie's Cleaning", "Cleaning", true);
		Vendor vendor7 = new Vendor( "Wynell", "Felix", "Hanafan", "Molly Maids", "Cleaning", true);
		Vendor vendor8 = new Vendor( "Taryn", "Willodean", "Lietz", "South Austin Electric", "Electrician", true);
		Vendor vendor9 = new Vendor( "Ammie", "Kimberlie", "Birkner", "North Austin Plumbing", "Plumbing", true);
		Vendor vendor10 = new Vendor( "Iluminada", "Merilyn", "Zurcher", "Buda Handy Man", "General Repair", true);	
		
		DbFunctions.insert(vendor1);
		DbFunctions.insert(vendor2);
		DbFunctions.insert(vendor3);
		DbFunctions.insert(vendor4);
		DbFunctions.insert(vendor5);
		DbFunctions.insert(vendor6);
		DbFunctions.insert(vendor7);
		DbFunctions.insert(vendor8);
		DbFunctions.insert(vendor9);
		DbFunctions.insert(vendor10);
		
//		Property other_property = DbFunctions.selectProperty(1);
//		
//		
//		
//		for (Unit unit : other_property.getUnits()){
//			System.out.println(unit.getUnitId()+ " "+ unit.getUnitNumber());
//		}
		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp")
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
