package com.rentroll.admin;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.rentroll.business.Address;
import com.rentroll.business.EmailAddress;
import com.rentroll.business.LedgerEntry;
import com.rentroll.business.Owner;
import com.rentroll.business.PhoneNumber;
import com.rentroll.business.Picture;
import com.rentroll.business.PropertyManager;
import com.rentroll.business.RentProperty;
import com.rentroll.business.ServiceCall;
import com.rentroll.business.Tenant;
import com.rentroll.business.Unit;
import com.rentroll.business.Vendor;
import com.rentroll.data.DbFunctions;
import com.rentroll.lists.AmenityList;
import com.rentroll.lists.PaymentMethod;
import com.rentroll.lists.VendorType;

/**
 * Servlet implementation  class CreateDatabase
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
		PropertyManager bg = new PropertyManager();
		bg.setFirstName("Billy");
		bg.setLastName("Gold");
		bg.setCompanyname("Bill Gold Realty");
		bg.setUserId("BGold100");
		bg.setPmType("admin");
		bg.setPassword(DbFunctions.hashPassword("BGPassword", bg.getSalt() ));
		DbFunctions.insert(bg);
		
		PaymentMethod cash= new PaymentMethod("Cash");
		PaymentMethod check= new PaymentMethod("Check");
		PaymentMethod bankTransfer= new PaymentMethod("Bank Transfer");
		PaymentMethod escrow= new PaymentMethod("Escrow");
		
		DbFunctions.insert(cash);
		DbFunctions.insert(check);
		DbFunctions.insert(bankTransfer);
		DbFunctions.insert(escrow);
		
		VendorType plumber = new VendorType("Plumber");
		VendorType electricain = new VendorType("Electrician");
		VendorType hvac = new VendorType("HVAC");
		VendorType landscape = new VendorType("Landscape");
		VendorType painter = new VendorType("Painter");
		VendorType handyMan = new VendorType("Handy Man");
		VendorType cleaning = new VendorType("Cleaning");
		
		DbFunctions.insert(plumber);
		DbFunctions.insert(electricain);
		DbFunctions.insert(hvac);
		DbFunctions.insert(landscape);
		DbFunctions.insert(painter);
		DbFunctions.insert(handyMan);
		DbFunctions.insert(cleaning);
		
		AmenityList pool = new AmenityList("Pool");
		AmenityList gym = new AmenityList("Fitness Studio");
		AmenityList gameRoom = new AmenityList("Gaming Room");
		AmenityList todlerRoom = new AmenityList("Toddler Room");
		AmenityList spa = new AmenityList("Spa");
		AmenityList indoorBasketball = new AmenityList("Indoor Basketball");
		AmenityList doorperson = new AmenityList("Doorperson");
		AmenityList freeWiFi = new AmenityList("Free Wi-Fi");
		AmenityList storage = new AmenityList("On Site Storage");
		AmenityList clubhouse = new AmenityList("Resident Clubhouse");
		AmenityList businessCenter = new AmenityList("Business Center");
		AmenityList onSiteMgt = new AmenityList("On-site Management");
		
		DbFunctions.insert(pool);
		DbFunctions.insert(gym);
		DbFunctions.insert(gameRoom);
		DbFunctions.insert(todlerRoom);
		DbFunctions.insert(spa);
		DbFunctions.insert(indoorBasketball);
		DbFunctions.insert(doorperson);
		DbFunctions.insert(freeWiFi);
		DbFunctions.insert(storage);
		DbFunctions.insert(clubhouse);
		DbFunctions.insert(businessCenter);
		DbFunctions.insert(onSiteMgt);
		
		
		Owner jack = new Owner("Jack","Richard","Cranial", "wire");
		Owner joey = new Owner("Joey","Jack","Jackson", "check");
		Owner joe= new Owner("Joe","Jack", "Shmuck", "check");
		Owner robert= new Owner("Robert", "Joseph","Hogan", "check");
		Owner jane= new Owner("Jane","Rose", "Smith", "check");
		
		jack.setUserId("Jackid");
		joey.setUserId("JoeyId");
		joe.setUserId("JoeId");
		robert.setUserId("RobertId");
		jane.setUserId("JaneId");
		jack.setPassword(DbFunctions.hashPassword("MyPassword", jack.getSalt() ));
		joey.setPassword(DbFunctions.hashPassword("JoeyPassword", joey.getSalt() ));
		joe.setPassword(DbFunctions.hashPassword("JoePassword", joe.getSalt() ));
		robert.setPassword(DbFunctions.hashPassword("RobertPassword", robert.getSalt() ));
		jane.setPassword(DbFunctions.hashPassword("JanePassword", jane.getSalt() ));
		

		
		
		jack.setActivePerson(true);
		joey.setActivePerson(true);
		joe.setActivePerson(true);
		robert.setActivePerson(true);
		jane.setActivePerson(true);
		

		
		
		
		
		
		EmailAddress jackHomeEmail= new EmailAddress(false, "work", "jackWork@aol.com");
		EmailAddress jackWorkEmail= new EmailAddress(true, "home", "jackHome@aol.com");
		EmailAddress jackOtherEmail= new EmailAddress(false, "other", "jackOther@aol.com");
		
		Set<EmailAddress> jackEmails = new HashSet<>();
		jackEmails.add(jackHomeEmail);
		jackEmails.add(jackWorkEmail);
		jackEmails.add(jackOtherEmail);
		jack.setEmailAddresses(jackEmails);
		
		
		EmailAddress joeHomeEmail= new EmailAddress(false, "home", "joeHome@aol.com");
		EmailAddress joeWorkEmail= new EmailAddress(true, "work", "joeWork@aol.com");
		EmailAddress joeOtherEmail= new EmailAddress(false, "other", "joeOther@aol.com");
		
		Set<EmailAddress> joeEmails = new HashSet<>();
		joeEmails.add(joeHomeEmail);
		joeEmails.add(joeWorkEmail);
		joeEmails.add(joeOtherEmail);
		joe.setEmailAddresses(joeEmails);
		
		EmailAddress joeyHomeEmail= new EmailAddress(false, "work", "joeyWork@aol.com");
		EmailAddress joeyWorkEmail= new EmailAddress(true, "home", "joeyHome@aol.com");
		EmailAddress joeyOtherEmail= new EmailAddress(false, "other", "joeyOther@aol.com");
		
		Set<EmailAddress> joeyEmails = new HashSet<>();
		joeyEmails.add(joeyHomeEmail);
		joeyEmails.add(joeyWorkEmail);
		joeyEmails.add(joeyOtherEmail);
		joe.setEmailAddresses(joeyEmails);		
		
		EmailAddress robertHomeEmail= new EmailAddress(false, "work", "robertWork@aol.com");
		EmailAddress robertWorkEmail= new EmailAddress(true, "home", "robertHome@aol.com");
		EmailAddress robertOtherEmail= new EmailAddress(false, "other", "robertOther@aol.com");
		

		Set<EmailAddress> robertEmails = new HashSet<>();
		robertEmails.add(robertHomeEmail);
		robertEmails.add(robertWorkEmail);
		robertEmails.add(robertOtherEmail);
		robert.setEmailAddresses(robertEmails);
		
		EmailAddress janeHomeEmail= new EmailAddress(false, "work", "janeWork@aol.com");
		EmailAddress janeWorkEmail= new EmailAddress(true, "home", "janeHome@aol.com");
		EmailAddress janeOtherEmail= new EmailAddress(false, "other", "janeOther@aol.com");
		

		Set<EmailAddress> janeEmails = new HashSet<>();
		janeEmails.add(janeHomeEmail);
		janeEmails.add(janeWorkEmail);
		janeEmails.add(janeOtherEmail);
		jane.setEmailAddresses(janeEmails);
		
		
		PhoneNumber jackCellPhone =new PhoneNumber(true , "Cell" , "512-447-1234");
		PhoneNumber jackHomePhone =new PhoneNumber(false , "Home" , "512-412-4344");
		PhoneNumber jackWorkPhone =new PhoneNumber(false , "Work" , "512-443-1234");
		
		Set<PhoneNumber> jacksPhoneNumbers = new HashSet<>();
		jacksPhoneNumbers.add(jackCellPhone);
		jacksPhoneNumbers.add(jackHomePhone);
		jacksPhoneNumbers.add(jackWorkPhone);
		
		jack.setPhoneNumbers(jacksPhoneNumbers);
//		DbFunctions.update(jack);
		
		PhoneNumber joeyCellPhone =new PhoneNumber(false , "Cell" , "512-447-1234");
		PhoneNumber joeyHomePhone =new PhoneNumber(true , "Home" , "512-412-4344");
		PhoneNumber joeyWorkPhone =new PhoneNumber(false , "Work" , "512-443-1234");
		
		Set<PhoneNumber> joeysPhoneNumbers = new HashSet<>();
		joeysPhoneNumbers.add(joeyCellPhone);
		joeysPhoneNumbers.add(joeyHomePhone);
		joeysPhoneNumbers.add(joeyWorkPhone);
		
		joey.setPhoneNumbers(joeysPhoneNumbers);
		
		PhoneNumber joeCellPhone =new PhoneNumber(false , "Cell" , "512-447-1234");
		PhoneNumber joeHomePhone =new PhoneNumber(false , "Home" , "512-412-4344");
		PhoneNumber joeWorkPhone =new PhoneNumber(true , "Work" , "512-443-1234");
		
		Set<PhoneNumber> joePhoneNumbers = new HashSet<>();
		joePhoneNumbers.add(joeCellPhone);
		joePhoneNumbers.add(joeHomePhone);
		joePhoneNumbers.add(joeWorkPhone);
		
		joe.setPhoneNumbers(joePhoneNumbers);
		
		
		PhoneNumber robertCellPhone =new PhoneNumber(true , "Cell" , "512-447-1234");
		PhoneNumber robertHomePhone =new PhoneNumber(false , "Home" , "512-412-4344");
		PhoneNumber robertWorkPhone =new PhoneNumber(false , "Work" , "512-443-1234");
		
		Set<PhoneNumber> robertPhoneNumbers = new HashSet<>();
		robertPhoneNumbers.add(robertCellPhone);
		robertPhoneNumbers.add(robertHomePhone);
		robertPhoneNumbers.add(robertWorkPhone);
		
		robert.setPhoneNumbers(robertPhoneNumbers);
		
		PhoneNumber janeCellPhone =new PhoneNumber( true , "Cell" , "512-447-1234");
		PhoneNumber janeHomePhone =new PhoneNumber( false , "Home" , "512-412-4344");
		PhoneNumber janeWorkPhone =new PhoneNumber(false , "Work" , "512-443-1234");
		
		Set<PhoneNumber> janePhoneNumbers = new HashSet<>();
		janePhoneNumbers.add(janeCellPhone);
		janePhoneNumbers.add(janeHomePhone);
		janePhoneNumbers.add(janeWorkPhone);
		
		jane.setPhoneNumbers(janePhoneNumbers);
		
		
		Address jackHomeAddress = new Address(jack,false,"home", "123 Jack Home St", "","Austin", "Texas", "78704");
		Address jackWorkAddress = new Address(jack,true,"work", "123 Jack Work St", "","Austin", "Texas", "78704");
		
		Set<Address> jackAddresses = new HashSet<>();
		jackAddresses.add(jackHomeAddress);
		jackAddresses.add(jackWorkAddress);
		
		jack.setAddresses(jackAddresses);
		
		
		Address joeyHomeAddress = new Address(joey,false,"home", "123 Joey Home St", "","Austin", "Texas", "78704");
		Address joeyWorkAddress = new Address(joey,true,"work", "123 Joey Work St", "","Austin", "Texas", "78704");
		
		Set<Address> joeyAddresses = new HashSet<>();
		joeyAddresses.add(joeyWorkAddress);
		joeyAddresses.add(joeyHomeAddress);
		
		joey.setAddresses(joeyAddresses);
		
		
		Address joeHomeAddress = new Address(joe,false,"home", "123 Joe Home St", "","Austin", "Texas", "78704");
		Address joeWorkAddress = new Address(joe,true,"work", "123 Joe Work St", "","Austin", "Texas", "78704");

		Set<Address> joeAddresses = new HashSet<>();
		joeAddresses.add(joeWorkAddress);
		joeAddresses.add(joeHomeAddress);
		
		joe.setAddresses(joeAddresses);
		
		Address robertHomeAddress = new Address(robert,false,"home", "123 Robert Home St", "","Austin", "Texas", "78704");
		Address robertWorkAddress = new Address(robert,true,"work", "123 Robert Work St", "","Austin", "Texas", "78704");
		robert.getAddresses().add(robertHomeAddress);
		robert.getAddresses().add(robertWorkAddress);
		
		Address janeHomeAddress = new Address(jane,false,"home", "123 Jane Home St", "","Austin", "Texas", "78704");
		Address janeWorkAddress = new Address(jane,true,"work", "123 Jane Work St", "","Austin", "Texas", "78704");
		
		jane.getAddresses().add(janeHomeAddress);
		jane.getAddresses().add(janeWorkAddress);
		
		DbFunctions.insert(jack);
		DbFunctions.insert(joey);
		DbFunctions.insert(joe);
		DbFunctions.insert(robert);
		DbFunctions.insert(jane);
		
		RentProperty jackProp1 = new RentProperty();
		jackProp1.setPropAddress1("66 Rainey St");
		jackProp1.setPropCity("Austin");
		jackProp1.setOwner(jack);
		jackProp1.setPropertyType("Duplex");
		jackProp1.setNumberOfUnits(2);
		jackProp1.setPropZip("78701");
		jackProp1.setCommission(new BigDecimal(".05"));
		jackProp1.setPropState("Texas");
		jackProp1.setDescription("66 Rainey St, is perfect for renters who want to be close to Downtown but also cherish some peace and quiet. This 2 bedroom, 1.5 bath, 2-story unit is currently prepping for kitchen and bathroom renovation. New countertops, stainless steal hardware, decor, paint, etc. and will be ready for move in on Saturday, February 13th, 2016!");
		
		RentProperty jackProp2 = new RentProperty();
		jackProp2.setPropName("Atlantic Ave Apartments");
		jackProp2.setPropAddress1("74874 Atlantic Ave");
		jackProp2.setPropCity("Austin");
		jackProp2.setOwner(jack);
		jackProp2.setPropertyType("Apratment");
		jackProp2.setNumberOfUnits(20);
		jackProp2.setPropZip("78704");
		jackProp2.setCommission(new BigDecimal(".03"));
		jackProp2.setPropState("Texas");
		jackProp2.setDescription("Welcome to Atlantic Ave Apartments, South Austins newest premier address. Conveniently located in booming South Austin, residents are minutes away from an array of entertainment, dining, and shopping. Designed with first class amenities and designer features, Lenox Parkview was developed with your unique lifestyle in mind. Choose from our one, two or three bedroom luxury apartment homes with custom features including gourmet kitchens with stainless steel appliances, granite countertops, faux wood flooring, wood cabinets complimented by modern hardware, full-size washer and dryers, and private yards. From the luxury swimming pool with outdoor kitchen to the twenty-four hour fitness and wellness studio, Atlantic Ave is designed to enhance your lifestyle! NOW LEASING, Atlantic Ave invites you to learn more about our premier community!");
		
		
		
		
		DbFunctions.insert(jackProp1);
		DbFunctions.insert(jackProp2);

		
		

		
		RentProperty joeyProp1 = new RentProperty();
		joeyProp1.setPropName("Esperanza Xing Apartments");
		joeyProp1.setPropAddress1("74874 Esperanza Xing");
		joeyProp1.setPropCity("Austin");
		joeyProp1.setOwner(joey);
		joeyProp1.setPropertyType("Apratment");
		joeyProp1.setNumberOfUnits(15);
		joeyProp1.setPropZip("78704");
		joeyProp1.setCommission(new BigDecimal(".04"));
		joeyProp1.setPropState("Texas");
		joeyProp1.setDescription("High on style with elegantly appointed finishes. Esperanza Xing is centrally located across from The Domain & next to Top Golf in the high-tech corridor. With added extras at every corner, you will enjoy a choice of studio, 1 bedroom, 1 bedroom+den, 2 bedroom and 3 bedroom apartments- each fully equipped with stainless steel appliances, espresso cabinets, granite counter tops, wood-like flooring and large windows with solar shades.Relax with friends at any of the two pools, entertain in our clubroom, stay healthy in our fully equipped fitness center, and enjoy our indoor/outdoor bar and lounge for ultimate relaxation.");
		
		DbFunctions.insert(joeyProp1);

		RentProperty joeProp1 = new RentProperty();
		joeProp1.setPropAddress1("2400 Nueces Street");
		joeProp1.setPropCity("Austin");
		joeProp1.setOwner(joe);
		joeProp1.setPropertyType("Single Family");
		joeProp1.setNumberOfUnits(1);
		joeProp1.setPropZip("78704");
		joeProp1.setCommission(new BigDecimal(".05"));
		joeProp1.setPropState("Texas");
		joeProp1.setDescription("CLOSE TO SETON MEDICAL CENTER, CENTRAL MARKET, JEFFERSON SQUARE, AND EASY COMMUTE TO UT/DOWNTOWN. FRESH PAINT. DECK AND SMALL SIDE YARD");
		
		RentProperty joeProp2 = new RentProperty();
		joeProp2.setPropName("EAST KOENIG RUGHS");
		joeProp2.setPropAddress1("545321 Avenue F");
		joeProp2.setPropCity("Austin");
		joeProp2.setOwner(joe);
		joeProp2.setPropertyType("Single Family");
		joeProp2.setNumberOfUnits(1);
		joeProp2.setPropZip("78704");
		joeProp2.setCommission(new BigDecimal(".03"));
		joeProp2.setPropState("Texas");
		joeProp2.setDescription("Nestled in the quiet outskirts of Hyde Park, East Koening Rughs are redefining luxury apartments in the North Loop district. Surrounded by bistros, hybrid coffee shop-cocktail spots, pubs, vintage boutiques and record stores, the developing North Loop Neighborhood parallels the eclectic feel of South Congress with edgy entertainment. Choose from any of our one, two and three bedroom floorplans with stylish features and sophisticated design. Our homes for rent offer a resort infinity edge pool with a water wading lounge, poolside grilling stations, an entertainment patio, an urban dog park, state of the art fitness center and business center. In addition, we include direct-level garage parking. Located just north of the UT intermural fields, we offer easy access to I-35, Mopac, Highway 183 and 290 making East Koening Rughs a perfect blend of distinct style and location. Please contact our professional and dedicated staff to schedule an appointment today!");
		
		RentProperty joeProp3 = new RentProperty();
		joeProp3.setPropAddress1("2710 San Pedro Street");
		joeProp3.setPropCity("Austin");
		joeProp3.setOwner(joe);
		joeProp3.setPropertyType("Single Family");
		joeProp3.setNumberOfUnits(1);
		joeProp3.setPropZip("78758");
		joeProp3.setCommission(new BigDecimal(".06"));
		joeProp3.setPropState("Texas");
		joeProp3.setDescription("2x2 two story vaulted ceilings nice floorplan one car garage small yard one bedroom up one bedroom down let negotiable no barking dogs or restricted prohibited breeds");
		
		RentProperty joeProp4 = new RentProperty();
		joeProp4.setPropAddress1("123 Dead Oak St");
		joeProp4.setPropCity("Austin");
		joeProp4.setOwner(joe);
		joeProp4.setPropertyType("Single Family");
		joeProp4.setNumberOfUnits(1);
		joeProp4.setPropZip("78758");
		joeProp4.setCommission(new BigDecimal(".06"));
		joeProp4.setPropState("Texas");
		joeProp4.setDescription("123 Dead Oak Street is perfect for renters who want to be close to Downtown but also cherish some peace and quiet. This 2 bedroom, 1.5 bath, 2-story unit is currently prepping for kitchen and bathroom renovation. New countertops, stainless steal hardware, decor, paint, etc. and will be ready for move in on Saturday, February 13th, 2016! Park your car or take advantage of extra storage in Unit B's 1-car garage, with additional parking available on the driveway and street. Feel free to warm up near the fireplace in the winter and outside on the two decks in the summer. One large deck extends right off the main level, and the second deck is private to the master bedroom upstairs. Both wood decks look over an un-developed, beautiful green space for maximum relaxation and great views of south east Austin. Tile covers the entire first floor of the unit with carpet upstairs. The owner will accept 1 dog under 35 pounds or 2 cats. The pet deposit is $300 per pet. The backyard would be great for dogs too. The kitchen comes with a fridge, gas stove, oven and dishwasher. Electric washer and electric/gas dryer hookups are available in the garage! 1713 Burton DR is conveniently located only blocks from a convenient store, gas station, Emo's Music Venue and bus stops. Future residents will be only a 5 minute drive to South Congress shopping, 10 minute drive to 6th Street and the Capital, and a 15 minute drive to UT campus");
		
		DbFunctions.insert(joeProp1);
		DbFunctions.insert(joeProp2);
		DbFunctions.insert(joeProp3);
		DbFunctions.insert(joeProp4);
		
		
		RentProperty janeProp1 = new RentProperty();
		janeProp1.setPropName("Jane's Grandview");
		janeProp1.setPropAddress1("9756 Champion Grandview Way");
		janeProp1.setPropCity("Austin");
		janeProp1.setOwner(jane);
		janeProp1.setPropertyType("Apratment");
		janeProp1.setNumberOfUnits(10);
		janeProp1.setPropZip("78704");
		janeProp1.setCommission(new BigDecimal(".04"));
		janeProp1.setPropState("Texas");
		janeProp1.setDescription("Jane's Grandview is all about LIFE and STYLE. Yours! Our exquisite community nestled in the Hill Country, offers breathtaking views of surrounding canyons, yet is only minutes away from the Arboretum. Take a dip in the infinity edge pool while enjoying majestic views of the hills. Jane's Grandview is luxury living at its finest!");
		
		DbFunctions.insert(janeProp1);


		
		RentProperty robertProp1 = new RentProperty();
		robertProp1.setPropAddress1("6649 N Blue Gum St");
		robertProp1.setPropCity("Round Rock");
		robertProp1.setOwner(robert);
		robertProp1.setPropertyType("Duplex");
		robertProp1.setNumberOfUnits(2);
		robertProp1.setPropZip("78628");
		robertProp1.setCommission(new BigDecimal(".05"));
		robertProp1.setPropState("Texas");
		robertProp1.setDescription("Totally renovated, well maintained 2 Bedroom/1 Bathroom duplex on Greenlawn in Round Rock. This very clean and just updated duplex is just minutes away from I-45 (tollway) and I-35. The duplex is available now!");
		
		RentProperty robertProp2 = new RentProperty();
		robertProp2.setPropAddress1("74874 Pecan Springs Road");
		robertProp2.setPropCity("Austin");
		robertProp2.setOwner(robert);
		robertProp2.setPropertyType("Duplex");
		robertProp2.setNumberOfUnits(2);
		robertProp2.setPropZip("78704");
		robertProp2.setCommission(new BigDecimal(".03"));
		robertProp2.setPropState("Texas");
		robertProp2.setDescription("Walking distance to the booming Manor district with TONS of dining shopping entertainment. Private deck that is GREAT for entertaining. Original 4FXJGJ hardwood floors and a spacious downstairs that is decked out with updated finishes. Large lot with 2 reserved parking spaces.");
		
		RentProperty robertProp3 = new RentProperty();
		robertProp3.setPropAddress1("123 Live Oak St");
		robertProp3.setPropCity("Austin");
		robertProp3.setOwner(robert);
		robertProp3.setPropertyType("Duplex");
		robertProp3.setNumberOfUnits(2);
		robertProp3.setPropZip("78758");
		robertProp3.setCommission(new BigDecimal(".06"));
		robertProp3.setPropState("Texas");
		robertProp3.setDescription("Spacious unit, all bedrooms upstairs withcarpet, wood on stairs and stained concrete in living and kitchen. Units have been updated, remodel still in process, all new paint, 4FJMCX carpet, appliances! Pets negotiable. Small to medium sized pet okay. Unit has one car garage, Brand new fridge, gas stove and dishwasher provided.");
		
		
		DbFunctions.insert(robertProp1);
		DbFunctions.insert(robertProp2);
		DbFunctions.insert(robertProp3);
		
		Unit jackProp1Unit1 = new Unit(jackProp1, "001",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit jackProp1Unit2 = new Unit(jackProp1, "002",2, 2, "1200", 1000D, "Two Bedroom", "Vacant");

		DbFunctions.insert(jackProp1Unit1);
		DbFunctions.insert(jackProp1Unit2);

		Unit jackProp2Unit1 = new Unit(jackProp2, "001",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit2 = new Unit(jackProp2, "002",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit3 = new Unit(jackProp2, "003",2, 2, "1200", 1000D, "Two Bedroom", "Vacant");
		Unit jackProp2Unit4 = new Unit(jackProp2, "004",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit5 = new Unit(jackProp2, "005",2, 2, "1200", 1000D, "Two Bedroom", "Vacant");
		Unit jackProp2Unit6 = new Unit(jackProp2, "006",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit7 = new Unit(jackProp2, "007",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit8 = new Unit(jackProp2, "008",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit9 = new Unit(jackProp2, "009",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit jackProp2Unit10 = new Unit(jackProp2, "010",1, 1, "900", 1000D, "One Bedroom", "Occupied");
		Unit jackProp2Unit11 = new Unit(jackProp2, "011",1, 1, "900", 1000D, "One Bedroom", "Occupied");
		Unit jackProp2Unit12 = new Unit(jackProp2, "012",1, 1, "900", 1000D, "One Bedroom", "Occupied");
		Unit jackProp2Unit13 = new Unit(jackProp2, "013",1, 1, "900", 1000D, "One Bedroom", "Vacant");
		Unit jackProp2Unit14 = new Unit(jackProp2, "014",1, 1, "900", 1000D, "One Bedroom", "Occupied");
		Unit jackProp2Unit15 = new Unit(jackProp2, "015",1, 1, "900", 1000D, "One Bedroom", "Occupied");
		Unit jackProp2Unit16 = new Unit(jackProp2, "016",1, 1, "700", 1000D, "Efficiency", "Occupied");
		Unit jackProp2Unit17 = new Unit(jackProp2, "017",1, 1, "700", 1000D, "Efficiency", "Occupied");
		Unit jackProp2Unit18 = new Unit(jackProp2, "018",1, 1, "700", 1000D, "Efficiency", "Occupied");
		Unit jackProp2Unit19 = new Unit(jackProp2, "019",1, 1, "700", 1000D, "Efficiency", "Occupied");
		Unit jackProp2Unit20 = new Unit(jackProp2, "020",1, 1, "700", 1000D, "Efficiency", "Occupied");

		DbFunctions.insert(jackProp2Unit1);
		DbFunctions.insert(jackProp2Unit2);
		
		
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


		Unit joeyProp1Unit1 = new Unit(joeyProp1, "001",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit2 = new Unit(joeyProp1, "002",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit3 = new Unit(joeyProp1, "003",2, 2, "1200", 1000D, "Two Bedroom", "Available");
		Unit joeyProp1Unit4 = new Unit(joeyProp1, "004",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit5 = new Unit(joeyProp1, "005",2, 2, "1200", 1000D, "Two Bedroom", "Available");
		Unit joeyProp1Unit6 = new Unit(joeyProp1, "006",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit7 = new Unit(joeyProp1, "007",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit8 = new Unit(joeyProp1, "008",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit9 = new Unit(joeyProp1, "009",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit joeyProp1Unit10 = new Unit(joeyProp1, "010",1, 1, "900", 1000D, "One Bedroom", "Occupied");
		Unit joeyProp1Unit11 = new Unit(joeyProp1, "011",1, 1, "900", 1000D, "One Bedroom", "Occupied");
		Unit joeyProp1Unit12 = new Unit(joeyProp1, "012",1, 1, "900", 1000D, "One Bedroom", "Occupied");
		Unit joeyProp1Unit13 = new Unit(joeyProp1, "013",1, 1, "900", 1000D, "One Bedroom", "Available");
		Unit joeyProp1Unit14 = new Unit(joeyProp1, "014",1, 1, "900", 1000D, "One Bedroom", "Occupied");
		Unit joeyProp1Unit15 = new Unit(joeyProp1, "015",1, 1, "900", 1000D, "One Bedroom", "Occupied");

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

		Unit joeProp1Unit1 = new Unit(joeProp1, "001", 3, 4, "2000", 2500D, "Three Bedroom House", "Occupied");
		Unit joeProp2Unit1 = new Unit(joeProp2, "001", 3, 4, "2000", 2500D, "Three Bedroom House", "Occupied");
		Unit joeProp3Unit1 = new Unit(joeProp3, "001", 3, 4, "2000", 2500D, "Three Bedroom House", "Occupied");
		Unit joeProp4Unit1 = new Unit(joeProp4, "001", 3, 4, "2000", 2500D, "Three Bedroom House", "Occupied");

		DbFunctions.insert(joeProp1Unit1);
		DbFunctions.insert(joeProp2Unit1);
		DbFunctions.insert(joeProp3Unit1);
		DbFunctions.insert(joeProp4Unit1);

		Unit janeProp1Unit1 = new Unit(janeProp1, "001",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit2 = new Unit(janeProp1, "002",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit3 = new Unit(janeProp1, "003",2, 2, "1200", 1000D, "Two Bedroom", "Available");
		Unit janeProp1Unit4 = new Unit(janeProp1, "004",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit5 = new Unit(janeProp1, "005",2, 2, "1200", 1000D, "Two Bedroom", "Vacant");
		Unit janeProp1Unit6 = new Unit(janeProp1, "006",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit7 = new Unit(janeProp1, "007",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit8 = new Unit(janeProp1, "008",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit9 = new Unit(janeProp1, "009",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit janeProp1Unit10 = new Unit(janeProp1, "010",1, 1, "900", 1000D, "One Bedroom", "Occupied");
		Unit janeProp1Unit11 = new Unit(janeProp1, "011",1, 1, "900", 1000D, "One Bedroom", "Occupied");
		Unit janeProp1Unit12 = new Unit(janeProp1, "012",1, 1, "900", 1000D, "One Bedroom", "Occupied");
		Unit janeProp1Unit13 = new Unit(janeProp1, "013",1, 1, "900", 1000D, "One Bedroom", "Available");
		Unit janeProp1Unit14 = new Unit(janeProp1, "014",1, 1, "900", 1000D, "One Bedroom", "Occupied");
		Unit janeProp1Unit15 = new Unit(janeProp1, "015",1, 1, "900", 1000D, "One Bedroom", "Occupied");


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

		Unit robertProp1Unit1 = new Unit(robertProp1, "001",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit robertProp1Unit2 = new Unit(robertProp1, "002",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");

		DbFunctions.insert(robertProp1Unit1);
		DbFunctions.insert(robertProp1Unit2);

		Unit robertProp2Unit1 = new Unit(robertProp2, "001",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit robertProp2Unit2 = new Unit(robertProp2, "002",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");

		DbFunctions.insert(robertProp2Unit1);
		DbFunctions.insert(robertProp2Unit2);

		Unit robertProp3Unit1 = new Unit(robertProp3, "001",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");
		Unit robertProp3Unit2 = new Unit(robertProp3, "002",2, 2, "1200", 1000D, "Two Bedroom", "Occupied");

		DbFunctions.insert(robertProp3Unit1);
		DbFunctions.insert(robertProp3Unit2);
		
		Tenant jackProp1Unit1Tenant = new Tenant ( jackProp1Unit1, "Catalina", "Katina" , "Wildfong" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp1Unit1Tenant.setUserId("Catalina.Wildfong@gmail.com");
		jackProp1Unit1Tenant.setPassword(DbFunctions.hashPassword("Katina", jackProp1Unit1Tenant.getSalt() ));

		PhoneNumber jackProp1Unit1TenantCellPhone =new PhoneNumber( true , "Cell" , "714-523-6653");
		PhoneNumber jackProp1Unit1TenantWorkPhone =new PhoneNumber( false , "Work" , "936-988-8171");
		PhoneNumber jackProp1Unit1TenantHomePhone =new PhoneNumber( false , "Home" , "216-871-6876");

		jackProp1Unit1Tenant.getPhoneNumbers().add(jackProp1Unit1TenantCellPhone);
		jackProp1Unit1Tenant.getPhoneNumbers().add(jackProp1Unit1TenantWorkPhone);
		jackProp1Unit1Tenant.getPhoneNumbers().add(jackProp1Unit1TenantHomePhone);

		EmailAddress jackProp1Unit1TenantHomeEmail= new EmailAddress(true, "Home", "CatalinaWildfong@gmail.com");
		EmailAddress jackProp1Unit1TenantWorkEmail= new EmailAddress(false, "Work", "CatalinaWildfong@work.com");
		EmailAddress jackProp1Unit1TenantOtherEmail= new EmailAddress(false, "Other", "CatalinaWildfong@aol.com");

		jackProp1Unit1Tenant.getEmailAddresses().add(jackProp1Unit1TenantHomeEmail);
		jackProp1Unit1Tenant.getEmailAddresses().add(jackProp1Unit1TenantWorkEmail);
		jackProp1Unit1Tenant.getEmailAddresses().add(jackProp1Unit1TenantOtherEmail);

		Tenant jackProp1Unit1Tenant2 = new Tenant ( jackProp1Unit1, "Karan", "Kristeen" , "Nicka" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp1Unit1Tenant2.setUserId("Karan.Nicka@gmail.com");
		jackProp1Unit1Tenant2.setPassword("Kristeen");
		jackProp1Unit1Tenant2.setPassword(DbFunctions.hashPassword("Kristeen", jackProp1Unit1Tenant2.getSalt() ));

		PhoneNumber jackProp1Unit1Tenant2CellPhone =new PhoneNumber( true , "Cell" , "817-213-8851");
		PhoneNumber jackProp1Unit1Tenant2WorkPhone =new PhoneNumber( false , "Work" , "847-265-6609");
		PhoneNumber jackProp1Unit1Tenant2HomePhone =new PhoneNumber( false , "Home" , "314-697-3652");

		jackProp1Unit1Tenant2.getPhoneNumbers().add(jackProp1Unit1Tenant2CellPhone);
		jackProp1Unit1Tenant2.getPhoneNumbers().add(jackProp1Unit1Tenant2WorkPhone);
		jackProp1Unit1Tenant2.getPhoneNumbers().add(jackProp1Unit1Tenant2HomePhone);

		EmailAddress jackProp1Unit1Tenant2HomeEmail= new EmailAddress(true, "Home", "KaranNicka@gmail.com");
		EmailAddress jackProp1Unit1Tenant2WorkEmail= new EmailAddress(false, "Work", "KaranNicka@work.com");
		EmailAddress jackProp1Unit1Tenant2OtherEmail= new EmailAddress(false, "Other", "KaranNicka@aol.com");

		jackProp1Unit1Tenant2.getEmailAddresses().add(jackProp1Unit1Tenant2HomeEmail);
		jackProp1Unit1Tenant2.getEmailAddresses().add(jackProp1Unit1Tenant2WorkEmail);
		jackProp1Unit1Tenant2.getEmailAddresses().add(jackProp1Unit1Tenant2OtherEmail);

		DbFunctions.insert(jackProp1Unit1Tenant);
		DbFunctions.insert(jackProp1Unit1Tenant2);

		Set<Tenant> jackProp1Unit1Tenanats = new HashSet<>();
		jackProp1Unit1Tenanats.add(jackProp1Unit1Tenant);
		jackProp1Unit1Tenanats.add(jackProp1Unit1Tenant2);
		jackProp1Unit1.setTenants(jackProp1Unit1Tenanats);
		DbFunctions.update(jackProp1Unit1);




		Tenant jackProp2Unit1Tenant = new Tenant ( jackProp2Unit1, "Lezlie", "Roosevelt" , "Kippley" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit1Tenant.setUserId("Lezlie.Kippley@gmail.com");
		jackProp2Unit1Tenant.setPassword(DbFunctions.hashPassword("Roosevelt", jackProp2Unit1Tenant.getSalt() ));

		PhoneNumber jackProp2Unit1TenantCellPhone =new PhoneNumber( true , "Cell" , "415-306-7897");
		PhoneNumber jackProp2Unit1TenantWorkPhone =new PhoneNumber( false , "Work" , "508-315-3867");
		PhoneNumber jackProp2Unit1TenantHomePhone =new PhoneNumber( false , "Home" , "215-511-3531");

		jackProp2Unit1Tenant.getPhoneNumbers().add(jackProp2Unit1TenantCellPhone);
		jackProp2Unit1Tenant.getPhoneNumbers().add(jackProp2Unit1TenantWorkPhone);
		jackProp2Unit1Tenant.getPhoneNumbers().add(jackProp2Unit1TenantHomePhone);

		EmailAddress jackProp2Unit1TenantHomeEmail= new EmailAddress(true, "Home", "LezlieKippley@gmail.com");
		EmailAddress jackProp2Unit1TenantWorkEmail= new EmailAddress(false, "Work", "LezlieKippley@work.com");
		EmailAddress jackProp2Unit1TenantOtherEmail= new EmailAddress(false, "Other", "LezlieKippley@aol.com");

		jackProp2Unit1Tenant.getEmailAddresses().add(jackProp2Unit1TenantHomeEmail);
		jackProp2Unit1Tenant.getEmailAddresses().add(jackProp2Unit1TenantWorkEmail);
		jackProp2Unit1Tenant.getEmailAddresses().add(jackProp2Unit1TenantOtherEmail);

		Tenant jackProp2Unit1Tenant2 = new Tenant ( jackProp2Unit1, "Fletcher", "Youlanda" , "Threets" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit1Tenant2.setUserId("Fletcher.Threets@gmail.com");
		jackProp2Unit1Tenant2.setPassword("Youlanda");
		jackProp2Unit1Tenant2.setPassword(DbFunctions.hashPassword("Youlanda", jackProp2Unit1Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit1Tenant2CellPhone =new PhoneNumber( true , "Cell" , "503-939-3153");
		PhoneNumber jackProp2Unit1Tenant2WorkPhone =new PhoneNumber( false , "Work" , "919-715-3791");
		PhoneNumber jackProp2Unit1Tenant2HomePhone =new PhoneNumber( false , "Home" , "773-352-3437");

		jackProp2Unit1Tenant2.getPhoneNumbers().add(jackProp2Unit1Tenant2CellPhone);
		jackProp2Unit1Tenant2.getPhoneNumbers().add(jackProp2Unit1Tenant2WorkPhone);
		jackProp2Unit1Tenant2.getPhoneNumbers().add(jackProp2Unit1Tenant2HomePhone);

		EmailAddress jackProp2Unit1Tenant2HomeEmail= new EmailAddress(true, "Home", "FletcherThreets@gmail.com");
		EmailAddress jackProp2Unit1Tenant2WorkEmail= new EmailAddress(false, "Work", "FletcherThreets@work.com");
		EmailAddress jackProp2Unit1Tenant2OtherEmail= new EmailAddress(false, "Other", "FletcherThreets@aol.com");

		jackProp2Unit1Tenant2.getEmailAddresses().add(jackProp2Unit1Tenant2HomeEmail);
		jackProp2Unit1Tenant2.getEmailAddresses().add(jackProp2Unit1Tenant2WorkEmail);
		jackProp2Unit1Tenant2.getEmailAddresses().add(jackProp2Unit1Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit1Tenant);
		DbFunctions.insert(jackProp2Unit1Tenant2);

		Set<Tenant> jackProp2Unit1Tenanats = new HashSet<>();
		jackProp2Unit1Tenanats.add(jackProp2Unit1Tenant);
		jackProp2Unit1Tenanats.add(jackProp2Unit1Tenant2);
		jackProp2Unit1.setTenants(jackProp2Unit1Tenanats);
		DbFunctions.update(jackProp2Unit1);




		Tenant jackProp2Unit2Tenant = new Tenant ( jackProp2Unit2, "Marge", "Nickolas" , "Latzke" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit2Tenant.setUserId("Marge.Latzke@gmail.com");
		jackProp2Unit2Tenant.setPassword(DbFunctions.hashPassword("Nickolas", jackProp2Unit2Tenant.getSalt() ));

		PhoneNumber jackProp2Unit2TenantCellPhone =new PhoneNumber( true , "Cell" , "701-898-2154");
		PhoneNumber jackProp2Unit2TenantWorkPhone =new PhoneNumber( false , "Work" , "732-635-3453");
		PhoneNumber jackProp2Unit2TenantHomePhone =new PhoneNumber( false , "Home" , "574-330-1884");

		jackProp2Unit2Tenant.getPhoneNumbers().add(jackProp2Unit2TenantCellPhone);
		jackProp2Unit2Tenant.getPhoneNumbers().add(jackProp2Unit2TenantWorkPhone);
		jackProp2Unit2Tenant.getPhoneNumbers().add(jackProp2Unit2TenantHomePhone);

		EmailAddress jackProp2Unit2TenantHomeEmail= new EmailAddress(true, "Home", "MargeLatzke@gmail.com");
		EmailAddress jackProp2Unit2TenantWorkEmail= new EmailAddress(false, "Work", "MargeLatzke@work.com");
		EmailAddress jackProp2Unit2TenantOtherEmail= new EmailAddress(false, "Other", "MargeLatzke@aol.com");

		jackProp2Unit2Tenant.getEmailAddresses().add(jackProp2Unit2TenantHomeEmail);
		jackProp2Unit2Tenant.getEmailAddresses().add(jackProp2Unit2TenantWorkEmail);
		jackProp2Unit2Tenant.getEmailAddresses().add(jackProp2Unit2TenantOtherEmail);

		Tenant jackProp2Unit2Tenant2 = new Tenant ( jackProp2Unit2, "Lai", "Gracia" , "Sergi" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit2Tenant2.setUserId("Lai.Sergi@gmail.com");
		jackProp2Unit2Tenant2.setPassword("Gracia");
		jackProp2Unit2Tenant2.setPassword(DbFunctions.hashPassword("Gracia", jackProp2Unit2Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit2Tenant2CellPhone =new PhoneNumber( true , "Cell" , "631-443-4710");
		PhoneNumber jackProp2Unit2Tenant2WorkPhone =new PhoneNumber( false , "Work" , "337-991-8070");
		PhoneNumber jackProp2Unit2Tenant2HomePhone =new PhoneNumber( false , "Home" , "248-793-4966");

		jackProp2Unit2Tenant2.getPhoneNumbers().add(jackProp2Unit2Tenant2CellPhone);
		jackProp2Unit2Tenant2.getPhoneNumbers().add(jackProp2Unit2Tenant2WorkPhone);
		jackProp2Unit2Tenant2.getPhoneNumbers().add(jackProp2Unit2Tenant2HomePhone);

		EmailAddress jackProp2Unit2Tenant2HomeEmail= new EmailAddress(true, "Home", "LaiSergi@gmail.com");
		EmailAddress jackProp2Unit2Tenant2WorkEmail= new EmailAddress(false, "Work", "LaiSergi@work.com");
		EmailAddress jackProp2Unit2Tenant2OtherEmail= new EmailAddress(false, "Other", "LaiSergi@aol.com");

		jackProp2Unit2Tenant2.getEmailAddresses().add(jackProp2Unit2Tenant2HomeEmail);
		jackProp2Unit2Tenant2.getEmailAddresses().add(jackProp2Unit2Tenant2WorkEmail);
		jackProp2Unit2Tenant2.getEmailAddresses().add(jackProp2Unit2Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit2Tenant);
		DbFunctions.insert(jackProp2Unit2Tenant2);

		Set<Tenant> jackProp2Unit2Tenanats = new HashSet<>();
		jackProp2Unit2Tenanats.add(jackProp2Unit2Tenant);
		jackProp2Unit2Tenanats.add(jackProp2Unit2Tenant2);
		jackProp2Unit2.setTenants(jackProp2Unit2Tenanats);
		DbFunctions.update(jackProp2Unit2);




		Tenant jackProp2Unit4Tenant = new Tenant ( jackProp2Unit4, "Rozella", "Natalie" , "Meisel" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit4Tenant.setUserId("Rozella.Meisel@gmail.com");
		jackProp2Unit4Tenant.setPassword(DbFunctions.hashPassword("Natalie", jackProp2Unit4Tenant.getSalt() ));

		PhoneNumber jackProp2Unit4TenantCellPhone =new PhoneNumber( true , "Cell" , "208-862-5339");
		PhoneNumber jackProp2Unit4TenantWorkPhone =new PhoneNumber( false , "Work" , "901-869-4314");
		PhoneNumber jackProp2Unit4TenantHomePhone =new PhoneNumber( false , "Home" , "269-431-9464");

		jackProp2Unit4Tenant.getPhoneNumbers().add(jackProp2Unit4TenantCellPhone);
		jackProp2Unit4Tenant.getPhoneNumbers().add(jackProp2Unit4TenantWorkPhone);
		jackProp2Unit4Tenant.getPhoneNumbers().add(jackProp2Unit4TenantHomePhone);

		EmailAddress jackProp2Unit4TenantHomeEmail= new EmailAddress(true, "Home", "RozellaMeisel@gmail.com");
		EmailAddress jackProp2Unit4TenantWorkEmail= new EmailAddress(false, "Work", "RozellaMeisel@work.com");
		EmailAddress jackProp2Unit4TenantOtherEmail= new EmailAddress(false, "Other", "RozellaMeisel@aol.com");

		jackProp2Unit4Tenant.getEmailAddresses().add(jackProp2Unit4TenantHomeEmail);
		jackProp2Unit4Tenant.getEmailAddresses().add(jackProp2Unit4TenantWorkEmail);
		jackProp2Unit4Tenant.getEmailAddresses().add(jackProp2Unit4TenantOtherEmail);

		Tenant jackProp2Unit4Tenant2 = new Tenant ( jackProp2Unit4, "Dulce", "Hubert" , "Schirpke" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit4Tenant2.setUserId("Dulce.Schirpke@gmail.com");
		jackProp2Unit4Tenant2.setPassword("Hubert");
		jackProp2Unit4Tenant2.setPassword(DbFunctions.hashPassword("Hubert", jackProp2Unit4Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit4Tenant2CellPhone =new PhoneNumber( true , "Cell" , "215-907-9111");
		PhoneNumber jackProp2Unit4Tenant2WorkPhone =new PhoneNumber( false , "Work" , "208-206-9848");
		PhoneNumber jackProp2Unit4Tenant2HomePhone =new PhoneNumber( false , "Home" , "601-973-5754");

		jackProp2Unit4Tenant2.getPhoneNumbers().add(jackProp2Unit4Tenant2CellPhone);
		jackProp2Unit4Tenant2.getPhoneNumbers().add(jackProp2Unit4Tenant2WorkPhone);
		jackProp2Unit4Tenant2.getPhoneNumbers().add(jackProp2Unit4Tenant2HomePhone);

		EmailAddress jackProp2Unit4Tenant2HomeEmail= new EmailAddress(true, "Home", "DulceSchirpke@gmail.com");
		EmailAddress jackProp2Unit4Tenant2WorkEmail= new EmailAddress(false, "Work", "DulceSchirpke@work.com");
		EmailAddress jackProp2Unit4Tenant2OtherEmail= new EmailAddress(false, "Other", "DulceSchirpke@aol.com");

		jackProp2Unit4Tenant2.getEmailAddresses().add(jackProp2Unit4Tenant2HomeEmail);
		jackProp2Unit4Tenant2.getEmailAddresses().add(jackProp2Unit4Tenant2WorkEmail);
		jackProp2Unit4Tenant2.getEmailAddresses().add(jackProp2Unit4Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit4Tenant);
		DbFunctions.insert(jackProp2Unit4Tenant2);

		Set<Tenant> jackProp2Unit4Tenanats = new HashSet<>();
		jackProp2Unit4Tenanats.add(jackProp2Unit4Tenant);
		jackProp2Unit4Tenanats.add(jackProp2Unit4Tenant2);
		jackProp2Unit4.setTenants(jackProp2Unit4Tenanats);
		DbFunctions.update(jackProp2Unit4);




		Tenant jackProp2Unit6Tenant = new Tenant ( jackProp2Unit6, "Sarah", "Alease" , "Bowley" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit6Tenant.setUserId("Sarah.Bowley@gmail.com");
		jackProp2Unit6Tenant.setPassword(DbFunctions.hashPassword("Alease", jackProp2Unit6Tenant.getSalt() ));

		PhoneNumber jackProp2Unit6TenantCellPhone =new PhoneNumber( true , "Cell" , "973-310-1634");
		PhoneNumber jackProp2Unit6TenantWorkPhone =new PhoneNumber( false , "Work" , "775-578-1214");
		PhoneNumber jackProp2Unit6TenantHomePhone =new PhoneNumber( false , "Home" , "602-953-6360");

		jackProp2Unit6Tenant.getPhoneNumbers().add(jackProp2Unit6TenantCellPhone);
		jackProp2Unit6Tenant.getPhoneNumbers().add(jackProp2Unit6TenantWorkPhone);
		jackProp2Unit6Tenant.getPhoneNumbers().add(jackProp2Unit6TenantHomePhone);

		EmailAddress jackProp2Unit6TenantHomeEmail= new EmailAddress(true, "Home", "SarahBowley@gmail.com");
		EmailAddress jackProp2Unit6TenantWorkEmail= new EmailAddress(false, "Work", "SarahBowley@work.com");
		EmailAddress jackProp2Unit6TenantOtherEmail= new EmailAddress(false, "Other", "SarahBowley@aol.com");

		jackProp2Unit6Tenant.getEmailAddresses().add(jackProp2Unit6TenantHomeEmail);
		jackProp2Unit6Tenant.getEmailAddresses().add(jackProp2Unit6TenantWorkEmail);
		jackProp2Unit6Tenant.getEmailAddresses().add(jackProp2Unit6TenantOtherEmail);

		Tenant jackProp2Unit6Tenant2 = new Tenant ( jackProp2Unit6, "Daron", "Corinne" , "Palaspas" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit6Tenant2.setUserId("Daron.Palaspas@gmail.com");
		jackProp2Unit6Tenant2.setPassword("Corinne");
		jackProp2Unit6Tenant2.setPassword(DbFunctions.hashPassword("Corinne", jackProp2Unit6Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit6Tenant2CellPhone =new PhoneNumber( true , "Cell" , "561-470-4574");
		PhoneNumber jackProp2Unit6Tenant2WorkPhone =new PhoneNumber( false , "Work" , "401-559-8961");
		PhoneNumber jackProp2Unit6Tenant2HomePhone =new PhoneNumber( false , "Home" , "208-737-8439");

		jackProp2Unit6Tenant2.getPhoneNumbers().add(jackProp2Unit6Tenant2CellPhone);
		jackProp2Unit6Tenant2.getPhoneNumbers().add(jackProp2Unit6Tenant2WorkPhone);
		jackProp2Unit6Tenant2.getPhoneNumbers().add(jackProp2Unit6Tenant2HomePhone);

		EmailAddress jackProp2Unit6Tenant2HomeEmail= new EmailAddress(true, "Home", "DaronPalaspas@gmail.com");
		EmailAddress jackProp2Unit6Tenant2WorkEmail= new EmailAddress(false, "Work", "DaronPalaspas@work.com");
		EmailAddress jackProp2Unit6Tenant2OtherEmail= new EmailAddress(false, "Other", "DaronPalaspas@aol.com");

		jackProp2Unit6Tenant2.getEmailAddresses().add(jackProp2Unit6Tenant2HomeEmail);
		jackProp2Unit6Tenant2.getEmailAddresses().add(jackProp2Unit6Tenant2WorkEmail);
		jackProp2Unit6Tenant2.getEmailAddresses().add(jackProp2Unit6Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit6Tenant);
		DbFunctions.insert(jackProp2Unit6Tenant2);

		Set<Tenant> jackProp2Unit6Tenanats = new HashSet<>();
		jackProp2Unit6Tenanats.add(jackProp2Unit6Tenant);
		jackProp2Unit6Tenanats.add(jackProp2Unit6Tenant2);
		jackProp2Unit6.setTenants(jackProp2Unit6Tenanats);
		DbFunctions.update(jackProp2Unit6);




		Tenant jackProp2Unit7Tenant = new Tenant ( jackProp2Unit7, "Kimberlie", "Deeanna" , "Berray" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit7Tenant.setUserId("Kimberlie.Berray@gmail.com");
		jackProp2Unit7Tenant.setPassword(DbFunctions.hashPassword("Deeanna", jackProp2Unit7Tenant.getSalt() ));

		PhoneNumber jackProp2Unit7TenantCellPhone =new PhoneNumber( true , "Cell" , "337-740-9323");
		PhoneNumber jackProp2Unit7TenantWorkPhone =new PhoneNumber( false , "Work" , "615-726-4537");
		PhoneNumber jackProp2Unit7TenantHomePhone =new PhoneNumber( false , "Home" , "908-470-4661");

		jackProp2Unit7Tenant.getPhoneNumbers().add(jackProp2Unit7TenantCellPhone);
		jackProp2Unit7Tenant.getPhoneNumbers().add(jackProp2Unit7TenantWorkPhone);
		jackProp2Unit7Tenant.getPhoneNumbers().add(jackProp2Unit7TenantHomePhone);

		EmailAddress jackProp2Unit7TenantHomeEmail= new EmailAddress(true, "Home", "KimberlieBerray@gmail.com");
		EmailAddress jackProp2Unit7TenantWorkEmail= new EmailAddress(false, "Work", "KimberlieBerray@work.com");
		EmailAddress jackProp2Unit7TenantOtherEmail= new EmailAddress(false, "Other", "KimberlieBerray@aol.com");

		jackProp2Unit7Tenant.getEmailAddresses().add(jackProp2Unit7TenantHomeEmail);
		jackProp2Unit7Tenant.getEmailAddresses().add(jackProp2Unit7TenantWorkEmail);
		jackProp2Unit7Tenant.getEmailAddresses().add(jackProp2Unit7TenantOtherEmail);

		Tenant jackProp2Unit7Tenant2 = new Tenant ( jackProp2Unit7, "Lavonna", "Shawnda" , "Jeanty" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit7Tenant2.setUserId("Lavonna.Jeanty@gmail.com");
		jackProp2Unit7Tenant2.setPassword("Shawnda");
		jackProp2Unit7Tenant2.setPassword(DbFunctions.hashPassword("Shawnda", jackProp2Unit7Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit7Tenant2CellPhone =new PhoneNumber( true , "Cell" , "850-430-1663");
		PhoneNumber jackProp2Unit7Tenant2WorkPhone =new PhoneNumber( false , "Work" , "972-961-4968");
		PhoneNumber jackProp2Unit7Tenant2HomePhone =new PhoneNumber( false , "Home" , "718-478-8568");

		jackProp2Unit7Tenant2.getPhoneNumbers().add(jackProp2Unit7Tenant2CellPhone);
		jackProp2Unit7Tenant2.getPhoneNumbers().add(jackProp2Unit7Tenant2WorkPhone);
		jackProp2Unit7Tenant2.getPhoneNumbers().add(jackProp2Unit7Tenant2HomePhone);

		EmailAddress jackProp2Unit7Tenant2HomeEmail= new EmailAddress(true, "Home", "LavonnaJeanty@gmail.com");
		EmailAddress jackProp2Unit7Tenant2WorkEmail= new EmailAddress(false, "Work", "LavonnaJeanty@work.com");
		EmailAddress jackProp2Unit7Tenant2OtherEmail= new EmailAddress(false, "Other", "LavonnaJeanty@aol.com");

		jackProp2Unit7Tenant2.getEmailAddresses().add(jackProp2Unit7Tenant2HomeEmail);
		jackProp2Unit7Tenant2.getEmailAddresses().add(jackProp2Unit7Tenant2WorkEmail);
		jackProp2Unit7Tenant2.getEmailAddresses().add(jackProp2Unit7Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit7Tenant);
		DbFunctions.insert(jackProp2Unit7Tenant2);

		Set<Tenant> jackProp2Unit7Tenanats = new HashSet<>();
		jackProp2Unit7Tenanats.add(jackProp2Unit7Tenant);
		jackProp2Unit7Tenanats.add(jackProp2Unit7Tenant2);
		jackProp2Unit7.setTenants(jackProp2Unit7Tenanats);
		DbFunctions.update(jackProp2Unit7);




		Tenant jackProp2Unit8Tenant = new Tenant ( jackProp2Unit8, "Gilma", "Theodora" , "Menter" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit8Tenant.setUserId("Gilma.Menter@gmail.com");
		jackProp2Unit8Tenant.setPassword(DbFunctions.hashPassword("Theodora", jackProp2Unit8Tenant.getSalt() ));

		PhoneNumber jackProp2Unit8TenantCellPhone =new PhoneNumber( true , "Cell" , "601-567-5386");
		PhoneNumber jackProp2Unit8TenantWorkPhone =new PhoneNumber( false , "Work" , "914-796-3775");
		PhoneNumber jackProp2Unit8TenantHomePhone =new PhoneNumber( false , "Home" , "904-627-4341");

		jackProp2Unit8Tenant.getPhoneNumbers().add(jackProp2Unit8TenantCellPhone);
		jackProp2Unit8Tenant.getPhoneNumbers().add(jackProp2Unit8TenantWorkPhone);
		jackProp2Unit8Tenant.getPhoneNumbers().add(jackProp2Unit8TenantHomePhone);

		EmailAddress jackProp2Unit8TenantHomeEmail= new EmailAddress(true, "Home", "GilmaMenter@gmail.com");
		EmailAddress jackProp2Unit8TenantWorkEmail= new EmailAddress(false, "Work", "GilmaMenter@work.com");
		EmailAddress jackProp2Unit8TenantOtherEmail= new EmailAddress(false, "Other", "GilmaMenter@aol.com");

		jackProp2Unit8Tenant.getEmailAddresses().add(jackProp2Unit8TenantHomeEmail);
		jackProp2Unit8Tenant.getEmailAddresses().add(jackProp2Unit8TenantWorkEmail);
		jackProp2Unit8Tenant.getEmailAddresses().add(jackProp2Unit8TenantOtherEmail);

		Tenant jackProp2Unit8Tenant2 = new Tenant ( jackProp2Unit8, "Lenna", "Teri" , "Acey" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit8Tenant2.setUserId("Lenna.Acey@gmail.com");
		jackProp2Unit8Tenant2.setPassword("Teri");
		jackProp2Unit8Tenant2.setPassword(DbFunctions.hashPassword("Teri", jackProp2Unit8Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit8Tenant2CellPhone =new PhoneNumber( true , "Cell" , "973-482-2430");
		PhoneNumber jackProp2Unit8Tenant2WorkPhone =new PhoneNumber( false , "Work" , "586-247-1614");
		PhoneNumber jackProp2Unit8Tenant2HomePhone =new PhoneNumber( false , "Home" , "715-530-9863");

		jackProp2Unit8Tenant2.getPhoneNumbers().add(jackProp2Unit8Tenant2CellPhone);
		jackProp2Unit8Tenant2.getPhoneNumbers().add(jackProp2Unit8Tenant2WorkPhone);
		jackProp2Unit8Tenant2.getPhoneNumbers().add(jackProp2Unit8Tenant2HomePhone);

		EmailAddress jackProp2Unit8Tenant2HomeEmail= new EmailAddress(true, "Home", "LennaAcey@gmail.com");
		EmailAddress jackProp2Unit8Tenant2WorkEmail= new EmailAddress(false, "Work", "LennaAcey@work.com");
		EmailAddress jackProp2Unit8Tenant2OtherEmail= new EmailAddress(false, "Other", "LennaAcey@aol.com");

		jackProp2Unit8Tenant2.getEmailAddresses().add(jackProp2Unit8Tenant2HomeEmail);
		jackProp2Unit8Tenant2.getEmailAddresses().add(jackProp2Unit8Tenant2WorkEmail);
		jackProp2Unit8Tenant2.getEmailAddresses().add(jackProp2Unit8Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit8Tenant);
		DbFunctions.insert(jackProp2Unit8Tenant2);

		Set<Tenant> jackProp2Unit8Tenanats = new HashSet<>();
		jackProp2Unit8Tenanats.add(jackProp2Unit8Tenant);
		jackProp2Unit8Tenanats.add(jackProp2Unit8Tenant2);
		jackProp2Unit8.setTenants(jackProp2Unit8Tenanats);
		DbFunctions.update(jackProp2Unit8);




		Tenant jackProp2Unit9Tenant = new Tenant ( jackProp2Unit9, "Vi", "Vallie" , "Timenez" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit9Tenant.setUserId("Vi.Timenez@gmail.com");
		jackProp2Unit9Tenant.setPassword(DbFunctions.hashPassword("Vallie", jackProp2Unit9Tenant.getSalt() ));

		PhoneNumber jackProp2Unit9TenantCellPhone =new PhoneNumber( true , "Cell" , "314-359-9566");
		PhoneNumber jackProp2Unit9TenantWorkPhone =new PhoneNumber( false , "Work" , "952-906-4597");
		PhoneNumber jackProp2Unit9TenantHomePhone =new PhoneNumber( false , "Home" , "215-794-4519");

		jackProp2Unit9Tenant.getPhoneNumbers().add(jackProp2Unit9TenantCellPhone);
		jackProp2Unit9Tenant.getPhoneNumbers().add(jackProp2Unit9TenantWorkPhone);
		jackProp2Unit9Tenant.getPhoneNumbers().add(jackProp2Unit9TenantHomePhone);

		EmailAddress jackProp2Unit9TenantHomeEmail= new EmailAddress(true, "Home", "ViTimenez@gmail.com");
		EmailAddress jackProp2Unit9TenantWorkEmail= new EmailAddress(false, "Work", "ViTimenez@work.com");
		EmailAddress jackProp2Unit9TenantOtherEmail= new EmailAddress(false, "Other", "ViTimenez@aol.com");

		jackProp2Unit9Tenant.getEmailAddresses().add(jackProp2Unit9TenantHomeEmail);
		jackProp2Unit9Tenant.getEmailAddresses().add(jackProp2Unit9TenantWorkEmail);
		jackProp2Unit9Tenant.getEmailAddresses().add(jackProp2Unit9TenantOtherEmail);

		Tenant jackProp2Unit9Tenant2 = new Tenant ( jackProp2Unit9, "Andra", "Clay" , "Felger" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit9Tenant2.setUserId("Andra.Felger@gmail.com");
		jackProp2Unit9Tenant2.setPassword("Clay");
		jackProp2Unit9Tenant2.setPassword(DbFunctions.hashPassword("Clay", jackProp2Unit9Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit9Tenant2CellPhone =new PhoneNumber( true , "Cell" , "407-538-5106");
		PhoneNumber jackProp2Unit9Tenant2WorkPhone =new PhoneNumber( false , "Work" , "248-697-7722");
		PhoneNumber jackProp2Unit9Tenant2HomePhone =new PhoneNumber( false , "Home" , "325-667-7868");

		jackProp2Unit9Tenant2.getPhoneNumbers().add(jackProp2Unit9Tenant2CellPhone);
		jackProp2Unit9Tenant2.getPhoneNumbers().add(jackProp2Unit9Tenant2WorkPhone);
		jackProp2Unit9Tenant2.getPhoneNumbers().add(jackProp2Unit9Tenant2HomePhone);

		EmailAddress jackProp2Unit9Tenant2HomeEmail= new EmailAddress(true, "Home", "AndraFelger@gmail.com");
		EmailAddress jackProp2Unit9Tenant2WorkEmail= new EmailAddress(false, "Work", "AndraFelger@work.com");
		EmailAddress jackProp2Unit9Tenant2OtherEmail= new EmailAddress(false, "Other", "AndraFelger@aol.com");

		jackProp2Unit9Tenant2.getEmailAddresses().add(jackProp2Unit9Tenant2HomeEmail);
		jackProp2Unit9Tenant2.getEmailAddresses().add(jackProp2Unit9Tenant2WorkEmail);
		jackProp2Unit9Tenant2.getEmailAddresses().add(jackProp2Unit9Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit9Tenant);
		DbFunctions.insert(jackProp2Unit9Tenant2);

		Set<Tenant> jackProp2Unit9Tenanats = new HashSet<>();
		jackProp2Unit9Tenanats.add(jackProp2Unit9Tenant);
		jackProp2Unit9Tenanats.add(jackProp2Unit9Tenant2);
		jackProp2Unit9.setTenants(jackProp2Unit9Tenanats);
		DbFunctions.update(jackProp2Unit9);




		Tenant jackProp2Unit10Tenant = new Tenant ( jackProp2Unit10, "Mattie", "Louvenia" , "Harabedian" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit10Tenant.setUserId("Mattie.Harabedian@gmail.com");
		jackProp2Unit10Tenant.setPassword(DbFunctions.hashPassword("Louvenia", jackProp2Unit10Tenant.getSalt() ));

		PhoneNumber jackProp2Unit10TenantCellPhone =new PhoneNumber( true , "Cell" , "619-509-5282");
		PhoneNumber jackProp2Unit10TenantWorkPhone =new PhoneNumber( false , "Work" , "626-293-7678");
		PhoneNumber jackProp2Unit10TenantHomePhone =new PhoneNumber( false , "Home" , "856-702-3676");

		jackProp2Unit10Tenant.getPhoneNumbers().add(jackProp2Unit10TenantCellPhone);
		jackProp2Unit10Tenant.getPhoneNumbers().add(jackProp2Unit10TenantWorkPhone);
		jackProp2Unit10Tenant.getPhoneNumbers().add(jackProp2Unit10TenantHomePhone);

		EmailAddress jackProp2Unit10TenantHomeEmail= new EmailAddress(true, "Home", "MattieHarabedian@gmail.com");
		EmailAddress jackProp2Unit10TenantWorkEmail= new EmailAddress(false, "Work", "MattieHarabedian@work.com");
		EmailAddress jackProp2Unit10TenantOtherEmail= new EmailAddress(false, "Other", "MattieHarabedian@aol.com");

		jackProp2Unit10Tenant.getEmailAddresses().add(jackProp2Unit10TenantHomeEmail);
		jackProp2Unit10Tenant.getEmailAddresses().add(jackProp2Unit10TenantWorkEmail);
		jackProp2Unit10Tenant.getEmailAddresses().add(jackProp2Unit10TenantOtherEmail);

		Tenant jackProp2Unit10Tenant2 = new Tenant ( jackProp2Unit10, "Erick", "Mirta" , "Lorens" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit10Tenant2.setUserId("Erick.Lorens@gmail.com");
		jackProp2Unit10Tenant2.setPassword("Mirta");
		jackProp2Unit10Tenant2.setPassword(DbFunctions.hashPassword("Mirta", jackProp2Unit10Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit10Tenant2CellPhone =new PhoneNumber( true , "Cell" , "203-461-1949");
		PhoneNumber jackProp2Unit10Tenant2WorkPhone =new PhoneNumber( false , "Work" , "516-357-3362");
		PhoneNumber jackProp2Unit10Tenant2HomePhone =new PhoneNumber( false , "Home" , "919-715-3791");

		jackProp2Unit10Tenant2.getPhoneNumbers().add(jackProp2Unit10Tenant2CellPhone);
		jackProp2Unit10Tenant2.getPhoneNumbers().add(jackProp2Unit10Tenant2WorkPhone);
		jackProp2Unit10Tenant2.getPhoneNumbers().add(jackProp2Unit10Tenant2HomePhone);

		EmailAddress jackProp2Unit10Tenant2HomeEmail= new EmailAddress(true, "Home", "ErickLorens@gmail.com");
		EmailAddress jackProp2Unit10Tenant2WorkEmail= new EmailAddress(false, "Work", "ErickLorens@work.com");
		EmailAddress jackProp2Unit10Tenant2OtherEmail= new EmailAddress(false, "Other", "ErickLorens@aol.com");

		jackProp2Unit10Tenant2.getEmailAddresses().add(jackProp2Unit10Tenant2HomeEmail);
		jackProp2Unit10Tenant2.getEmailAddresses().add(jackProp2Unit10Tenant2WorkEmail);
		jackProp2Unit10Tenant2.getEmailAddresses().add(jackProp2Unit10Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit10Tenant);
		DbFunctions.insert(jackProp2Unit10Tenant2);

		Set<Tenant> jackProp2Unit10Tenanats = new HashSet<>();
		jackProp2Unit10Tenanats.add(jackProp2Unit10Tenant);
		jackProp2Unit10Tenanats.add(jackProp2Unit10Tenant2);
		jackProp2Unit10.setTenants(jackProp2Unit10Tenanats);
		DbFunctions.update(jackProp2Unit10);




		Tenant jackProp2Unit11Tenant = new Tenant ( jackProp2Unit11, "Selma", "Kaitlyn" , "Hidvegi" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit11Tenant.setUserId("Selma.Hidvegi@gmail.com");
		jackProp2Unit11Tenant.setPassword(DbFunctions.hashPassword("Kaitlyn", jackProp2Unit11Tenant.getSalt() ));

		PhoneNumber jackProp2Unit11TenantCellPhone =new PhoneNumber( true , "Cell" , "910-922-3672");
		PhoneNumber jackProp2Unit11TenantWorkPhone =new PhoneNumber( false , "Work" , "760-465-4762");
		PhoneNumber jackProp2Unit11TenantHomePhone =new PhoneNumber( false , "Home" , "719-223-2074");

		jackProp2Unit11Tenant.getPhoneNumbers().add(jackProp2Unit11TenantCellPhone);
		jackProp2Unit11Tenant.getPhoneNumbers().add(jackProp2Unit11TenantWorkPhone);
		jackProp2Unit11Tenant.getPhoneNumbers().add(jackProp2Unit11TenantHomePhone);

		EmailAddress jackProp2Unit11TenantHomeEmail= new EmailAddress(true, "Home", "SelmaHidvegi@gmail.com");
		EmailAddress jackProp2Unit11TenantWorkEmail= new EmailAddress(false, "Work", "SelmaHidvegi@work.com");
		EmailAddress jackProp2Unit11TenantOtherEmail= new EmailAddress(false, "Other", "SelmaHidvegi@aol.com");

		jackProp2Unit11Tenant.getEmailAddresses().add(jackProp2Unit11TenantHomeEmail);
		jackProp2Unit11Tenant.getEmailAddresses().add(jackProp2Unit11TenantWorkEmail);
		jackProp2Unit11Tenant.getEmailAddresses().add(jackProp2Unit11TenantOtherEmail);

		Tenant jackProp2Unit11Tenant2 = new Tenant ( jackProp2Unit11, "Leonora", "Earleen" , "Fredicks" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit11Tenant2.setUserId("Leonora.Fredicks@gmail.com");
		jackProp2Unit11Tenant2.setPassword("Earleen");
		jackProp2Unit11Tenant2.setPassword(DbFunctions.hashPassword("Earleen", jackProp2Unit11Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit11Tenant2CellPhone =new PhoneNumber( true , "Cell" , "608-382-4541");
		PhoneNumber jackProp2Unit11Tenant2WorkPhone =new PhoneNumber( false , "Work" , "404-607-8435");
		PhoneNumber jackProp2Unit11Tenant2HomePhone =new PhoneNumber( false , "Home" , "602-953-6360");

		jackProp2Unit11Tenant2.getPhoneNumbers().add(jackProp2Unit11Tenant2CellPhone);
		jackProp2Unit11Tenant2.getPhoneNumbers().add(jackProp2Unit11Tenant2WorkPhone);
		jackProp2Unit11Tenant2.getPhoneNumbers().add(jackProp2Unit11Tenant2HomePhone);

		EmailAddress jackProp2Unit11Tenant2HomeEmail= new EmailAddress(true, "Home", "LeonoraFredicks@gmail.com");
		EmailAddress jackProp2Unit11Tenant2WorkEmail= new EmailAddress(false, "Work", "LeonoraFredicks@work.com");
		EmailAddress jackProp2Unit11Tenant2OtherEmail= new EmailAddress(false, "Other", "LeonoraFredicks@aol.com");

		jackProp2Unit11Tenant2.getEmailAddresses().add(jackProp2Unit11Tenant2HomeEmail);
		jackProp2Unit11Tenant2.getEmailAddresses().add(jackProp2Unit11Tenant2WorkEmail);
		jackProp2Unit11Tenant2.getEmailAddresses().add(jackProp2Unit11Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit11Tenant);
		DbFunctions.insert(jackProp2Unit11Tenant2);

		Set<Tenant> jackProp2Unit11Tenanats = new HashSet<>();
		jackProp2Unit11Tenanats.add(jackProp2Unit11Tenant);
		jackProp2Unit11Tenanats.add(jackProp2Unit11Tenant2);
		jackProp2Unit11.setTenants(jackProp2Unit11Tenanats);
		DbFunctions.update(jackProp2Unit11);




		Tenant jackProp2Unit12Tenant = new Tenant ( jackProp2Unit12, "Judy", "Carmelina" , "Rhym" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit12Tenant.setUserId("Judy.Rhym@gmail.com");
		jackProp2Unit12Tenant.setPassword(DbFunctions.hashPassword("Carmelina", jackProp2Unit12Tenant.getSalt() ));

		PhoneNumber jackProp2Unit12TenantCellPhone =new PhoneNumber( true , "Cell" , "410-890-7866");
		PhoneNumber jackProp2Unit12TenantWorkPhone =new PhoneNumber( false , "Work" , "775-848-9135");
		PhoneNumber jackProp2Unit12TenantHomePhone =new PhoneNumber( false , "Home" , "907-227-6777");

		jackProp2Unit12Tenant.getPhoneNumbers().add(jackProp2Unit12TenantCellPhone);
		jackProp2Unit12Tenant.getPhoneNumbers().add(jackProp2Unit12TenantWorkPhone);
		jackProp2Unit12Tenant.getPhoneNumbers().add(jackProp2Unit12TenantHomePhone);

		EmailAddress jackProp2Unit12TenantHomeEmail= new EmailAddress(true, "Home", "JudyRhym@gmail.com");
		EmailAddress jackProp2Unit12TenantWorkEmail= new EmailAddress(false, "Work", "JudyRhym@work.com");
		EmailAddress jackProp2Unit12TenantOtherEmail= new EmailAddress(false, "Other", "JudyRhym@aol.com");

		jackProp2Unit12Tenant.getEmailAddresses().add(jackProp2Unit12TenantHomeEmail);
		jackProp2Unit12Tenant.getEmailAddresses().add(jackProp2Unit12TenantWorkEmail);
		jackProp2Unit12Tenant.getEmailAddresses().add(jackProp2Unit12TenantOtherEmail);

		Tenant jackProp2Unit12Tenant2 = new Tenant ( jackProp2Unit12, "Raul", "James" , "Lapage" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit12Tenant2.setUserId("Raul.Lapage@gmail.com");
		jackProp2Unit12Tenant2.setPassword("James");
		jackProp2Unit12Tenant2.setPassword(DbFunctions.hashPassword("James", jackProp2Unit12Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit12Tenant2CellPhone =new PhoneNumber( true , "Cell" , "907-385-4412");
		PhoneNumber jackProp2Unit12Tenant2WorkPhone =new PhoneNumber( false , "Work" , "973-355-2120");
		PhoneNumber jackProp2Unit12Tenant2HomePhone =new PhoneNumber( false , "Home" , "216-733-8494");

		jackProp2Unit12Tenant2.getPhoneNumbers().add(jackProp2Unit12Tenant2CellPhone);
		jackProp2Unit12Tenant2.getPhoneNumbers().add(jackProp2Unit12Tenant2WorkPhone);
		jackProp2Unit12Tenant2.getPhoneNumbers().add(jackProp2Unit12Tenant2HomePhone);

		EmailAddress jackProp2Unit12Tenant2HomeEmail= new EmailAddress(true, "Home", "RaulLapage@gmail.com");
		EmailAddress jackProp2Unit12Tenant2WorkEmail= new EmailAddress(false, "Work", "RaulLapage@work.com");
		EmailAddress jackProp2Unit12Tenant2OtherEmail= new EmailAddress(false, "Other", "RaulLapage@aol.com");

		jackProp2Unit12Tenant2.getEmailAddresses().add(jackProp2Unit12Tenant2HomeEmail);
		jackProp2Unit12Tenant2.getEmailAddresses().add(jackProp2Unit12Tenant2WorkEmail);
		jackProp2Unit12Tenant2.getEmailAddresses().add(jackProp2Unit12Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit12Tenant);
		DbFunctions.insert(jackProp2Unit12Tenant2);

		Set<Tenant> jackProp2Unit12Tenanats = new HashSet<>();
		jackProp2Unit12Tenanats.add(jackProp2Unit12Tenant);
		jackProp2Unit12Tenanats.add(jackProp2Unit12Tenant2);
		jackProp2Unit12.setTenants(jackProp2Unit12Tenanats);
		DbFunctions.update(jackProp2Unit12);




		Tenant jackProp2Unit14Tenant = new Tenant ( jackProp2Unit14, "Dierdre", "Devorah" , "Isenhower" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit14Tenant.setUserId("Dierdre.Isenhower@gmail.com");
		jackProp2Unit14Tenant.setPassword(DbFunctions.hashPassword("Devorah", jackProp2Unit14Tenant.getSalt() ));

		PhoneNumber jackProp2Unit14TenantCellPhone =new PhoneNumber( true , "Cell" , "616-737-3085");
		PhoneNumber jackProp2Unit14TenantWorkPhone =new PhoneNumber( false , "Work" , "310-968-1219");
		PhoneNumber jackProp2Unit14TenantHomePhone =new PhoneNumber( false , "Home" , "315-640-6357");

		jackProp2Unit14Tenant.getPhoneNumbers().add(jackProp2Unit14TenantCellPhone);
		jackProp2Unit14Tenant.getPhoneNumbers().add(jackProp2Unit14TenantWorkPhone);
		jackProp2Unit14Tenant.getPhoneNumbers().add(jackProp2Unit14TenantHomePhone);

		EmailAddress jackProp2Unit14TenantHomeEmail= new EmailAddress(true, "Home", "DierdreIsenhower@gmail.com");
		EmailAddress jackProp2Unit14TenantWorkEmail= new EmailAddress(false, "Work", "DierdreIsenhower@work.com");
		EmailAddress jackProp2Unit14TenantOtherEmail= new EmailAddress(false, "Other", "DierdreIsenhower@aol.com");

		jackProp2Unit14Tenant.getEmailAddresses().add(jackProp2Unit14TenantHomeEmail);
		jackProp2Unit14Tenant.getEmailAddresses().add(jackProp2Unit14TenantWorkEmail);
		jackProp2Unit14Tenant.getEmailAddresses().add(jackProp2Unit14TenantOtherEmail);

		Tenant jackProp2Unit14Tenant2 = new Tenant ( jackProp2Unit14, "Theodora", "Ahmed" , "Lipke" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit14Tenant2.setUserId("Theodora.Lipke@gmail.com");
		jackProp2Unit14Tenant2.setPassword("Ahmed");
		jackProp2Unit14Tenant2.setPassword(DbFunctions.hashPassword("Ahmed", jackProp2Unit14Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit14Tenant2CellPhone =new PhoneNumber( true , "Cell" , "803-352-5387");
		PhoneNumber jackProp2Unit14Tenant2WorkPhone =new PhoneNumber( false , "Work" , "410-863-8263");
		PhoneNumber jackProp2Unit14Tenant2HomePhone =new PhoneNumber( false , "Home" , "408-813-1105");

		jackProp2Unit14Tenant2.getPhoneNumbers().add(jackProp2Unit14Tenant2CellPhone);
		jackProp2Unit14Tenant2.getPhoneNumbers().add(jackProp2Unit14Tenant2WorkPhone);
		jackProp2Unit14Tenant2.getPhoneNumbers().add(jackProp2Unit14Tenant2HomePhone);

		EmailAddress jackProp2Unit14Tenant2HomeEmail= new EmailAddress(true, "Home", "TheodoraLipke@gmail.com");
		EmailAddress jackProp2Unit14Tenant2WorkEmail= new EmailAddress(false, "Work", "TheodoraLipke@work.com");
		EmailAddress jackProp2Unit14Tenant2OtherEmail= new EmailAddress(false, "Other", "TheodoraLipke@aol.com");

		jackProp2Unit14Tenant2.getEmailAddresses().add(jackProp2Unit14Tenant2HomeEmail);
		jackProp2Unit14Tenant2.getEmailAddresses().add(jackProp2Unit14Tenant2WorkEmail);
		jackProp2Unit14Tenant2.getEmailAddresses().add(jackProp2Unit14Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit14Tenant);
		DbFunctions.insert(jackProp2Unit14Tenant2);

		Set<Tenant> jackProp2Unit14Tenanats = new HashSet<>();
		jackProp2Unit14Tenanats.add(jackProp2Unit14Tenant);
		jackProp2Unit14Tenanats.add(jackProp2Unit14Tenant2);
		jackProp2Unit14.setTenants(jackProp2Unit14Tenanats);
		DbFunctions.update(jackProp2Unit14);




		Tenant jackProp2Unit15Tenant = new Tenant ( jackProp2Unit15, "Jina", "Jaclyn" , "Hollack" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit15Tenant.setUserId("Jina.Hollack@gmail.com");
		jackProp2Unit15Tenant.setPassword(DbFunctions.hashPassword("Jaclyn", jackProp2Unit15Tenant.getSalt() ));

		PhoneNumber jackProp2Unit15TenantCellPhone =new PhoneNumber( true , "Cell" , "918-644-9555");
		PhoneNumber jackProp2Unit15TenantWorkPhone =new PhoneNumber( false , "Work" , "717-632-5831");
		PhoneNumber jackProp2Unit15TenantHomePhone =new PhoneNumber( false , "Home" , "508-315-3867");

		jackProp2Unit15Tenant.getPhoneNumbers().add(jackProp2Unit15TenantCellPhone);
		jackProp2Unit15Tenant.getPhoneNumbers().add(jackProp2Unit15TenantWorkPhone);
		jackProp2Unit15Tenant.getPhoneNumbers().add(jackProp2Unit15TenantHomePhone);

		EmailAddress jackProp2Unit15TenantHomeEmail= new EmailAddress(true, "Home", "JinaHollack@gmail.com");
		EmailAddress jackProp2Unit15TenantWorkEmail= new EmailAddress(false, "Work", "JinaHollack@work.com");
		EmailAddress jackProp2Unit15TenantOtherEmail= new EmailAddress(false, "Other", "JinaHollack@aol.com");

		jackProp2Unit15Tenant.getEmailAddresses().add(jackProp2Unit15TenantHomeEmail);
		jackProp2Unit15Tenant.getEmailAddresses().add(jackProp2Unit15TenantWorkEmail);
		jackProp2Unit15Tenant.getEmailAddresses().add(jackProp2Unit15TenantOtherEmail);

		Tenant jackProp2Unit15Tenant2 = new Tenant ( jackProp2Unit15, "Kanisha", "Mitsue" , "Hollack" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit15Tenant2.setUserId("Kanisha.Hollack@gmail.com");
		jackProp2Unit15Tenant2.setPassword("Mitsue");
		jackProp2Unit15Tenant2.setPassword(DbFunctions.hashPassword("Mitsue", jackProp2Unit15Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit15Tenant2CellPhone =new PhoneNumber( true , "Cell" , "626-866-2339");
		PhoneNumber jackProp2Unit15Tenant2WorkPhone =new PhoneNumber( false , "Work" , "952-479-2375");
		PhoneNumber jackProp2Unit15Tenant2HomePhone =new PhoneNumber( false , "Home" , "602-442-3092");

		jackProp2Unit15Tenant2.getPhoneNumbers().add(jackProp2Unit15Tenant2CellPhone);
		jackProp2Unit15Tenant2.getPhoneNumbers().add(jackProp2Unit15Tenant2WorkPhone);
		jackProp2Unit15Tenant2.getPhoneNumbers().add(jackProp2Unit15Tenant2HomePhone);

		EmailAddress jackProp2Unit15Tenant2HomeEmail= new EmailAddress(true, "Home", "KanishaHollack@gmail.com");
		EmailAddress jackProp2Unit15Tenant2WorkEmail= new EmailAddress(false, "Work", "KanishaHollack@work.com");
		EmailAddress jackProp2Unit15Tenant2OtherEmail= new EmailAddress(false, "Other", "KanishaHollack@aol.com");

		jackProp2Unit15Tenant2.getEmailAddresses().add(jackProp2Unit15Tenant2HomeEmail);
		jackProp2Unit15Tenant2.getEmailAddresses().add(jackProp2Unit15Tenant2WorkEmail);
		jackProp2Unit15Tenant2.getEmailAddresses().add(jackProp2Unit15Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit15Tenant);
		DbFunctions.insert(jackProp2Unit15Tenant2);

		Set<Tenant> jackProp2Unit15Tenanats = new HashSet<>();
		jackProp2Unit15Tenanats.add(jackProp2Unit15Tenant);
		jackProp2Unit15Tenanats.add(jackProp2Unit15Tenant2);
		jackProp2Unit15.setTenants(jackProp2Unit15Tenanats);
		DbFunctions.update(jackProp2Unit15);




		Tenant jackProp2Unit16Tenant = new Tenant ( jackProp2Unit16, "Emerson", "Keneth" , "Adkin" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit16Tenant.setUserId("Emerson.Adkin@gmail.com");
		jackProp2Unit16Tenant.setPassword(DbFunctions.hashPassword("Keneth", jackProp2Unit16Tenant.getSalt() ));

		PhoneNumber jackProp2Unit16TenantCellPhone =new PhoneNumber( true , "Cell" , "631-748-6479");
		PhoneNumber jackProp2Unit16TenantWorkPhone =new PhoneNumber( false , "Work" , "508-897-7916");
		PhoneNumber jackProp2Unit16TenantHomePhone =new PhoneNumber( false , "Home" , "386-208-6976");

		jackProp2Unit16Tenant.getPhoneNumbers().add(jackProp2Unit16TenantCellPhone);
		jackProp2Unit16Tenant.getPhoneNumbers().add(jackProp2Unit16TenantWorkPhone);
		jackProp2Unit16Tenant.getPhoneNumbers().add(jackProp2Unit16TenantHomePhone);

		EmailAddress jackProp2Unit16TenantHomeEmail= new EmailAddress(true, "Home", "EmersonAdkin@gmail.com");
		EmailAddress jackProp2Unit16TenantWorkEmail= new EmailAddress(false, "Work", "EmersonAdkin@work.com");
		EmailAddress jackProp2Unit16TenantOtherEmail= new EmailAddress(false, "Other", "EmersonAdkin@aol.com");

		jackProp2Unit16Tenant.getEmailAddresses().add(jackProp2Unit16TenantHomeEmail);
		jackProp2Unit16Tenant.getEmailAddresses().add(jackProp2Unit16TenantWorkEmail);
		jackProp2Unit16Tenant.getEmailAddresses().add(jackProp2Unit16TenantOtherEmail);

		Tenant jackProp2Unit16Tenant2 = new Tenant ( jackProp2Unit16, "Lilli", "Rolland" , "Greenbush" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit16Tenant2.setUserId("Lilli.Greenbush@gmail.com");
		jackProp2Unit16Tenant2.setPassword("Rolland");
		jackProp2Unit16Tenant2.setPassword(DbFunctions.hashPassword("Rolland", jackProp2Unit16Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit16Tenant2CellPhone =new PhoneNumber( true , "Cell" , "330-537-5358");
		PhoneNumber jackProp2Unit16Tenant2WorkPhone =new PhoneNumber( false , "Work" , "505-335-5293");
		PhoneNumber jackProp2Unit16Tenant2HomePhone =new PhoneNumber( false , "Home" , "212-428-9538");

		jackProp2Unit16Tenant2.getPhoneNumbers().add(jackProp2Unit16Tenant2CellPhone);
		jackProp2Unit16Tenant2.getPhoneNumbers().add(jackProp2Unit16Tenant2WorkPhone);
		jackProp2Unit16Tenant2.getPhoneNumbers().add(jackProp2Unit16Tenant2HomePhone);

		EmailAddress jackProp2Unit16Tenant2HomeEmail= new EmailAddress(true, "Home", "LilliGreenbush@gmail.com");
		EmailAddress jackProp2Unit16Tenant2WorkEmail= new EmailAddress(false, "Work", "LilliGreenbush@work.com");
		EmailAddress jackProp2Unit16Tenant2OtherEmail= new EmailAddress(false, "Other", "LilliGreenbush@aol.com");

		jackProp2Unit16Tenant2.getEmailAddresses().add(jackProp2Unit16Tenant2HomeEmail);
		jackProp2Unit16Tenant2.getEmailAddresses().add(jackProp2Unit16Tenant2WorkEmail);
		jackProp2Unit16Tenant2.getEmailAddresses().add(jackProp2Unit16Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit16Tenant);
		DbFunctions.insert(jackProp2Unit16Tenant2);

		Set<Tenant> jackProp2Unit16Tenanats = new HashSet<>();
		jackProp2Unit16Tenanats.add(jackProp2Unit16Tenant);
		jackProp2Unit16Tenanats.add(jackProp2Unit16Tenant2);
		jackProp2Unit16.setTenants(jackProp2Unit16Tenanats);
		DbFunctions.update(jackProp2Unit16);




		Tenant jackProp2Unit17Tenant = new Tenant ( jackProp2Unit17, "Cammy", "Veronika" , "Treston" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit17Tenant.setUserId("Cammy.Treston@gmail.com");
		jackProp2Unit17Tenant.setPassword(DbFunctions.hashPassword("Veronika", jackProp2Unit17Tenant.getSalt() ));

		PhoneNumber jackProp2Unit17TenantCellPhone =new PhoneNumber( true , "Cell" , "908-722-7128");
		PhoneNumber jackProp2Unit17TenantWorkPhone =new PhoneNumber( false , "Work" , "307-279-3793");
		PhoneNumber jackProp2Unit17TenantHomePhone =new PhoneNumber( false , "Home" , "904-514-9918");

		jackProp2Unit17Tenant.getPhoneNumbers().add(jackProp2Unit17TenantCellPhone);
		jackProp2Unit17Tenant.getPhoneNumbers().add(jackProp2Unit17TenantWorkPhone);
		jackProp2Unit17Tenant.getPhoneNumbers().add(jackProp2Unit17TenantHomePhone);

		EmailAddress jackProp2Unit17TenantHomeEmail= new EmailAddress(true, "Home", "CammyTreston@gmail.com");
		EmailAddress jackProp2Unit17TenantWorkEmail= new EmailAddress(false, "Work", "CammyTreston@work.com");
		EmailAddress jackProp2Unit17TenantOtherEmail= new EmailAddress(false, "Other", "CammyTreston@aol.com");

		jackProp2Unit17Tenant.getEmailAddresses().add(jackProp2Unit17TenantHomeEmail);
		jackProp2Unit17Tenant.getEmailAddresses().add(jackProp2Unit17TenantWorkEmail);
		jackProp2Unit17Tenant.getEmailAddresses().add(jackProp2Unit17TenantOtherEmail);

		Tenant jackProp2Unit17Tenant2 = new Tenant ( jackProp2Unit17, "Leota", "Jolanda" , "Arceo" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit17Tenant2.setUserId("Leota.Arceo@gmail.com");
		jackProp2Unit17Tenant2.setPassword("Jolanda");
		jackProp2Unit17Tenant2.setPassword(DbFunctions.hashPassword("Jolanda", jackProp2Unit17Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit17Tenant2CellPhone =new PhoneNumber( true , "Cell" , "901-901-4726");
		PhoneNumber jackProp2Unit17Tenant2WorkPhone =new PhoneNumber( false , "Work" , "214-529-1949");
		PhoneNumber jackProp2Unit17Tenant2HomePhone =new PhoneNumber( false , "Home" , "706-616-5131");

		jackProp2Unit17Tenant2.getPhoneNumbers().add(jackProp2Unit17Tenant2CellPhone);
		jackProp2Unit17Tenant2.getPhoneNumbers().add(jackProp2Unit17Tenant2WorkPhone);
		jackProp2Unit17Tenant2.getPhoneNumbers().add(jackProp2Unit17Tenant2HomePhone);

		EmailAddress jackProp2Unit17Tenant2HomeEmail= new EmailAddress(true, "Home", "LeotaArceo@gmail.com");
		EmailAddress jackProp2Unit17Tenant2WorkEmail= new EmailAddress(false, "Work", "LeotaArceo@work.com");
		EmailAddress jackProp2Unit17Tenant2OtherEmail= new EmailAddress(false, "Other", "LeotaArceo@aol.com");

		jackProp2Unit17Tenant2.getEmailAddresses().add(jackProp2Unit17Tenant2HomeEmail);
		jackProp2Unit17Tenant2.getEmailAddresses().add(jackProp2Unit17Tenant2WorkEmail);
		jackProp2Unit17Tenant2.getEmailAddresses().add(jackProp2Unit17Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit17Tenant);
		DbFunctions.insert(jackProp2Unit17Tenant2);

		Set<Tenant> jackProp2Unit17Tenanats = new HashSet<>();
		jackProp2Unit17Tenanats.add(jackProp2Unit17Tenant);
		jackProp2Unit17Tenanats.add(jackProp2Unit17Tenant2);
		jackProp2Unit17.setTenants(jackProp2Unit17Tenanats);
		DbFunctions.update(jackProp2Unit17);




		Tenant jackProp2Unit18Tenant = new Tenant ( jackProp2Unit18, "Cecilia", "Janey" , "Caiafa" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit18Tenant.setUserId("Cecilia.Caiafa@gmail.com");
		jackProp2Unit18Tenant.setPassword(DbFunctions.hashPassword("Janey", jackProp2Unit18Tenant.getSalt() ));

		PhoneNumber jackProp2Unit18TenantCellPhone =new PhoneNumber( true , "Cell" , "518-966-7987");
		PhoneNumber jackProp2Unit18TenantWorkPhone =new PhoneNumber( false , "Work" , "414-377-2880");
		PhoneNumber jackProp2Unit18TenantHomePhone =new PhoneNumber( false , "Home" , "212-428-9538");

		jackProp2Unit18Tenant.getPhoneNumbers().add(jackProp2Unit18TenantCellPhone);
		jackProp2Unit18Tenant.getPhoneNumbers().add(jackProp2Unit18TenantWorkPhone);
		jackProp2Unit18Tenant.getPhoneNumbers().add(jackProp2Unit18TenantHomePhone);

		EmailAddress jackProp2Unit18TenantHomeEmail= new EmailAddress(true, "Home", "CeciliaCaiafa@gmail.com");
		EmailAddress jackProp2Unit18TenantWorkEmail= new EmailAddress(false, "Work", "CeciliaCaiafa@work.com");
		EmailAddress jackProp2Unit18TenantOtherEmail= new EmailAddress(false, "Other", "CeciliaCaiafa@aol.com");

		jackProp2Unit18Tenant.getEmailAddresses().add(jackProp2Unit18TenantHomeEmail);
		jackProp2Unit18Tenant.getEmailAddresses().add(jackProp2Unit18TenantWorkEmail);
		jackProp2Unit18Tenant.getEmailAddresses().add(jackProp2Unit18TenantOtherEmail);

		Tenant jackProp2Unit18Tenant2 = new Tenant ( jackProp2Unit18, "Dyan", "Carissa" , "Gwalthney" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit18Tenant2.setUserId("Dyan.Gwalthney@gmail.com");
		jackProp2Unit18Tenant2.setPassword("Carissa");
		jackProp2Unit18Tenant2.setPassword(DbFunctions.hashPassword("Carissa", jackProp2Unit18Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit18Tenant2CellPhone =new PhoneNumber( true , "Cell" , "301-841-5012");
		PhoneNumber jackProp2Unit18Tenant2WorkPhone =new PhoneNumber( false , "Work" , "703-874-4248");
		PhoneNumber jackProp2Unit18Tenant2HomePhone =new PhoneNumber( false , "Home" , "305-857-5489");

		jackProp2Unit18Tenant2.getPhoneNumbers().add(jackProp2Unit18Tenant2CellPhone);
		jackProp2Unit18Tenant2.getPhoneNumbers().add(jackProp2Unit18Tenant2WorkPhone);
		jackProp2Unit18Tenant2.getPhoneNumbers().add(jackProp2Unit18Tenant2HomePhone);

		EmailAddress jackProp2Unit18Tenant2HomeEmail= new EmailAddress(true, "Home", "DyanGwalthney@gmail.com");
		EmailAddress jackProp2Unit18Tenant2WorkEmail= new EmailAddress(false, "Work", "DyanGwalthney@work.com");
		EmailAddress jackProp2Unit18Tenant2OtherEmail= new EmailAddress(false, "Other", "DyanGwalthney@aol.com");

		jackProp2Unit18Tenant2.getEmailAddresses().add(jackProp2Unit18Tenant2HomeEmail);
		jackProp2Unit18Tenant2.getEmailAddresses().add(jackProp2Unit18Tenant2WorkEmail);
		jackProp2Unit18Tenant2.getEmailAddresses().add(jackProp2Unit18Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit18Tenant);
		DbFunctions.insert(jackProp2Unit18Tenant2);

		Set<Tenant> jackProp2Unit18Tenanats = new HashSet<>();
		jackProp2Unit18Tenanats.add(jackProp2Unit18Tenant);
		jackProp2Unit18Tenanats.add(jackProp2Unit18Tenant2);
		jackProp2Unit18.setTenants(jackProp2Unit18Tenanats);
		DbFunctions.update(jackProp2Unit18);




		Tenant jackProp2Unit19Tenant = new Tenant ( jackProp2Unit19, "Carmen", "Jess" , "Papasergi" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit19Tenant.setUserId("Carmen.Papasergi@gmail.com");
		jackProp2Unit19Tenant.setPassword(DbFunctions.hashPassword("Jess", jackProp2Unit19Tenant.getSalt() ));

		PhoneNumber jackProp2Unit19TenantCellPhone =new PhoneNumber( true , "Cell" , "626-636-4117");
		PhoneNumber jackProp2Unit19TenantWorkPhone =new PhoneNumber( false , "Work" , "305-575-8481");
		PhoneNumber jackProp2Unit19TenantHomePhone =new PhoneNumber( false , "Home" , "408-813-1105");

		jackProp2Unit19Tenant.getPhoneNumbers().add(jackProp2Unit19TenantCellPhone);
		jackProp2Unit19Tenant.getPhoneNumbers().add(jackProp2Unit19TenantWorkPhone);
		jackProp2Unit19Tenant.getPhoneNumbers().add(jackProp2Unit19TenantHomePhone);

		EmailAddress jackProp2Unit19TenantHomeEmail= new EmailAddress(true, "Home", "CarmenPapasergi@gmail.com");
		EmailAddress jackProp2Unit19TenantWorkEmail= new EmailAddress(false, "Work", "CarmenPapasergi@work.com");
		EmailAddress jackProp2Unit19TenantOtherEmail= new EmailAddress(false, "Other", "CarmenPapasergi@aol.com");

		jackProp2Unit19Tenant.getEmailAddresses().add(jackProp2Unit19TenantHomeEmail);
		jackProp2Unit19Tenant.getEmailAddresses().add(jackProp2Unit19TenantWorkEmail);
		jackProp2Unit19Tenant.getEmailAddresses().add(jackProp2Unit19TenantOtherEmail);

		Tenant jackProp2Unit19Tenant2 = new Tenant ( jackProp2Unit19, "Ozell", "Yolando" , "Adkin" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit19Tenant2.setUserId("Ozell.Adkin@gmail.com");
		jackProp2Unit19Tenant2.setPassword("Yolando");
		jackProp2Unit19Tenant2.setPassword(DbFunctions.hashPassword("Yolando", jackProp2Unit19Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit19Tenant2CellPhone =new PhoneNumber( true , "Cell" , "408-805-4309");
		PhoneNumber jackProp2Unit19Tenant2WorkPhone =new PhoneNumber( false , "Work" , "732-904-2931");
		PhoneNumber jackProp2Unit19Tenant2HomePhone =new PhoneNumber( false , "Home" , "419-313-5571");

		jackProp2Unit19Tenant2.getPhoneNumbers().add(jackProp2Unit19Tenant2CellPhone);
		jackProp2Unit19Tenant2.getPhoneNumbers().add(jackProp2Unit19Tenant2WorkPhone);
		jackProp2Unit19Tenant2.getPhoneNumbers().add(jackProp2Unit19Tenant2HomePhone);

		EmailAddress jackProp2Unit19Tenant2HomeEmail= new EmailAddress(true, "Home", "OzellAdkin@gmail.com");
		EmailAddress jackProp2Unit19Tenant2WorkEmail= new EmailAddress(false, "Work", "OzellAdkin@work.com");
		EmailAddress jackProp2Unit19Tenant2OtherEmail= new EmailAddress(false, "Other", "OzellAdkin@aol.com");

		jackProp2Unit19Tenant2.getEmailAddresses().add(jackProp2Unit19Tenant2HomeEmail);
		jackProp2Unit19Tenant2.getEmailAddresses().add(jackProp2Unit19Tenant2WorkEmail);
		jackProp2Unit19Tenant2.getEmailAddresses().add(jackProp2Unit19Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit19Tenant);
		DbFunctions.insert(jackProp2Unit19Tenant2);

		Set<Tenant> jackProp2Unit19Tenanats = new HashSet<>();
		jackProp2Unit19Tenanats.add(jackProp2Unit19Tenant);
		jackProp2Unit19Tenanats.add(jackProp2Unit19Tenant2);
		jackProp2Unit19.setTenants(jackProp2Unit19Tenanats);
		DbFunctions.update(jackProp2Unit19);




		Tenant jackProp2Unit20Tenant = new Tenant ( jackProp2Unit20, "Ressie", "Peggie" , "Plumer" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		jackProp2Unit20Tenant.setUserId("Ressie.Plumer@gmail.com");
		jackProp2Unit20Tenant.setPassword(DbFunctions.hashPassword("Peggie", jackProp2Unit20Tenant.getSalt() ));

		PhoneNumber jackProp2Unit20TenantCellPhone =new PhoneNumber( true , "Cell" , "718-201-3751");
		PhoneNumber jackProp2Unit20TenantWorkPhone =new PhoneNumber( false , "Work" , "407-564-8113");
		PhoneNumber jackProp2Unit20TenantHomePhone =new PhoneNumber( false , "Home" , "201-365-8698");

		jackProp2Unit20Tenant.getPhoneNumbers().add(jackProp2Unit20TenantCellPhone);
		jackProp2Unit20Tenant.getPhoneNumbers().add(jackProp2Unit20TenantWorkPhone);
		jackProp2Unit20Tenant.getPhoneNumbers().add(jackProp2Unit20TenantHomePhone);

		EmailAddress jackProp2Unit20TenantHomeEmail= new EmailAddress(true, "Home", "RessiePlumer@gmail.com");
		EmailAddress jackProp2Unit20TenantWorkEmail= new EmailAddress(false, "Work", "RessiePlumer@work.com");
		EmailAddress jackProp2Unit20TenantOtherEmail= new EmailAddress(false, "Other", "RessiePlumer@aol.com");

		jackProp2Unit20Tenant.getEmailAddresses().add(jackProp2Unit20TenantHomeEmail);
		jackProp2Unit20Tenant.getEmailAddresses().add(jackProp2Unit20TenantWorkEmail);
		jackProp2Unit20Tenant.getEmailAddresses().add(jackProp2Unit20TenantOtherEmail);

		Tenant jackProp2Unit20Tenant2 = new Tenant ( jackProp2Unit20, "Nobuko", "Arminda" , "Meteer" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		jackProp2Unit20Tenant2.setUserId("Nobuko.Meteer@gmail.com");
		jackProp2Unit20Tenant2.setPassword("Arminda");
		jackProp2Unit20Tenant2.setPassword(DbFunctions.hashPassword("Arminda", jackProp2Unit20Tenant2.getSalt() ));

		PhoneNumber jackProp2Unit20Tenant2CellPhone =new PhoneNumber( true , "Cell" , "407-312-1691");
		PhoneNumber jackProp2Unit20Tenant2WorkPhone =new PhoneNumber( false , "Work" , "512-528-9933");
		PhoneNumber jackProp2Unit20Tenant2HomePhone =new PhoneNumber( false , "Home" , "610-752-2683");

		jackProp2Unit20Tenant2.getPhoneNumbers().add(jackProp2Unit20Tenant2CellPhone);
		jackProp2Unit20Tenant2.getPhoneNumbers().add(jackProp2Unit20Tenant2WorkPhone);
		jackProp2Unit20Tenant2.getPhoneNumbers().add(jackProp2Unit20Tenant2HomePhone);

		EmailAddress jackProp2Unit20Tenant2HomeEmail= new EmailAddress(true, "Home", "NobukoMeteer@gmail.com");
		EmailAddress jackProp2Unit20Tenant2WorkEmail= new EmailAddress(false, "Work", "NobukoMeteer@work.com");
		EmailAddress jackProp2Unit20Tenant2OtherEmail= new EmailAddress(false, "Other", "NobukoMeteer@aol.com");

		jackProp2Unit20Tenant2.getEmailAddresses().add(jackProp2Unit20Tenant2HomeEmail);
		jackProp2Unit20Tenant2.getEmailAddresses().add(jackProp2Unit20Tenant2WorkEmail);
		jackProp2Unit20Tenant2.getEmailAddresses().add(jackProp2Unit20Tenant2OtherEmail);

		DbFunctions.insert(jackProp2Unit20Tenant);
		DbFunctions.insert(jackProp2Unit20Tenant2);

		Set<Tenant> jackProp2Unit20Tenanats = new HashSet<>();
		jackProp2Unit20Tenanats.add(jackProp2Unit20Tenant);
		jackProp2Unit20Tenanats.add(jackProp2Unit20Tenant2);
		jackProp2Unit20.setTenants(jackProp2Unit20Tenanats);
		DbFunctions.update(jackProp2Unit20);




		Tenant joeyProp1Unit1Tenant = new Tenant ( joeyProp1Unit1, "Gregoria", "Timothy" , "Lueckenbach" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeyProp1Unit1Tenant.setUserId("Gregoria.Lueckenbach@gmail.com");
		joeyProp1Unit1Tenant.setPassword(DbFunctions.hashPassword("Timothy", joeyProp1Unit1Tenant.getSalt() ));

		PhoneNumber joeyProp1Unit1TenantCellPhone =new PhoneNumber( true , "Cell" , "231-467-9978");
		PhoneNumber joeyProp1Unit1TenantWorkPhone =new PhoneNumber( false , "Work" , "508-504-6388");
		PhoneNumber joeyProp1Unit1TenantHomePhone =new PhoneNumber( false , "Home" , "931-486-6946");

		joeyProp1Unit1Tenant.getPhoneNumbers().add(joeyProp1Unit1TenantCellPhone);
		joeyProp1Unit1Tenant.getPhoneNumbers().add(joeyProp1Unit1TenantWorkPhone);
		joeyProp1Unit1Tenant.getPhoneNumbers().add(joeyProp1Unit1TenantHomePhone);

		EmailAddress joeyProp1Unit1TenantHomeEmail= new EmailAddress(true, "Home", "GregoriaLueckenbach@gmail.com");
		EmailAddress joeyProp1Unit1TenantWorkEmail= new EmailAddress(false, "Work", "GregoriaLueckenbach@work.com");
		EmailAddress joeyProp1Unit1TenantOtherEmail= new EmailAddress(false, "Other", "GregoriaLueckenbach@aol.com");

		joeyProp1Unit1Tenant.getEmailAddresses().add(joeyProp1Unit1TenantHomeEmail);
		joeyProp1Unit1Tenant.getEmailAddresses().add(joeyProp1Unit1TenantWorkEmail);
		joeyProp1Unit1Tenant.getEmailAddresses().add(joeyProp1Unit1TenantOtherEmail);

		Tenant joeyProp1Unit1Tenant2 = new Tenant ( joeyProp1Unit1, "Johnna", "Rozella" , "Nievas" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeyProp1Unit1Tenant2.setUserId("Johnna.Nievas@gmail.com");
		joeyProp1Unit1Tenant2.setPassword("Rozella");
		joeyProp1Unit1Tenant2.setPassword(DbFunctions.hashPassword("Rozella", joeyProp1Unit1Tenant2.getSalt() ));

		PhoneNumber joeyProp1Unit1Tenant2CellPhone =new PhoneNumber( true , "Cell" , "909-993-3242");
		PhoneNumber joeyProp1Unit1Tenant2WorkPhone =new PhoneNumber( false , "Work" , "215-794-4519");
		PhoneNumber joeyProp1Unit1Tenant2HomePhone =new PhoneNumber( false , "Home" , "310-694-8466");

		joeyProp1Unit1Tenant2.getPhoneNumbers().add(joeyProp1Unit1Tenant2CellPhone);
		joeyProp1Unit1Tenant2.getPhoneNumbers().add(joeyProp1Unit1Tenant2WorkPhone);
		joeyProp1Unit1Tenant2.getPhoneNumbers().add(joeyProp1Unit1Tenant2HomePhone);

		EmailAddress joeyProp1Unit1Tenant2HomeEmail= new EmailAddress(true, "Home", "JohnnaNievas@gmail.com");
		EmailAddress joeyProp1Unit1Tenant2WorkEmail= new EmailAddress(false, "Work", "JohnnaNievas@work.com");
		EmailAddress joeyProp1Unit1Tenant2OtherEmail= new EmailAddress(false, "Other", "JohnnaNievas@aol.com");

		joeyProp1Unit1Tenant2.getEmailAddresses().add(joeyProp1Unit1Tenant2HomeEmail);
		joeyProp1Unit1Tenant2.getEmailAddresses().add(joeyProp1Unit1Tenant2WorkEmail);
		joeyProp1Unit1Tenant2.getEmailAddresses().add(joeyProp1Unit1Tenant2OtherEmail);

		DbFunctions.insert(joeyProp1Unit1Tenant);
		DbFunctions.insert(joeyProp1Unit1Tenant2);

		Set<Tenant> joeyProp1Unit1Tenanats = new HashSet<>();
		joeyProp1Unit1Tenanats.add(joeyProp1Unit1Tenant);
		joeyProp1Unit1Tenanats.add(joeyProp1Unit1Tenant2);
		joeyProp1Unit1.setTenants(joeyProp1Unit1Tenanats);
		DbFunctions.update(joeyProp1Unit1);




		Tenant joeyProp1Unit2Tenant = new Tenant ( joeyProp1Unit2, "Helene", "Goldie" , "Hughey" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeyProp1Unit2Tenant.setUserId("Helene.Hughey@gmail.com");
		joeyProp1Unit2Tenant.setPassword(DbFunctions.hashPassword("Goldie", joeyProp1Unit2Tenant.getSalt() ));

		PhoneNumber joeyProp1Unit2TenantCellPhone =new PhoneNumber( true , "Cell" , "248-913-4677");
		PhoneNumber joeyProp1Unit2TenantWorkPhone =new PhoneNumber( false , "Work" , "706-616-5131");
		PhoneNumber joeyProp1Unit2TenantHomePhone =new PhoneNumber( false , "Home" , "410-522-7621");

		joeyProp1Unit2Tenant.getPhoneNumbers().add(joeyProp1Unit2TenantCellPhone);
		joeyProp1Unit2Tenant.getPhoneNumbers().add(joeyProp1Unit2TenantWorkPhone);
		joeyProp1Unit2Tenant.getPhoneNumbers().add(joeyProp1Unit2TenantHomePhone);

		EmailAddress joeyProp1Unit2TenantHomeEmail= new EmailAddress(true, "Home", "HeleneHughey@gmail.com");
		EmailAddress joeyProp1Unit2TenantWorkEmail= new EmailAddress(false, "Work", "HeleneHughey@work.com");
		EmailAddress joeyProp1Unit2TenantOtherEmail= new EmailAddress(false, "Other", "HeleneHughey@aol.com");

		joeyProp1Unit2Tenant.getEmailAddresses().add(joeyProp1Unit2TenantHomeEmail);
		joeyProp1Unit2Tenant.getEmailAddresses().add(joeyProp1Unit2TenantWorkEmail);
		joeyProp1Unit2Tenant.getEmailAddresses().add(joeyProp1Unit2TenantOtherEmail);

		Tenant joeyProp1Unit2Tenant2 = new Tenant ( joeyProp1Unit2, "Carissa", "Mozell" , "Poullion" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeyProp1Unit2Tenant2.setUserId("Carissa.Poullion@gmail.com");
		joeyProp1Unit2Tenant2.setPassword("Mozell");
		joeyProp1Unit2Tenant2.setPassword(DbFunctions.hashPassword("Mozell", joeyProp1Unit2Tenant2.getSalt() ));

		PhoneNumber joeyProp1Unit2Tenant2CellPhone =new PhoneNumber( true , "Cell" , "269-756-7222");
		PhoneNumber joeyProp1Unit2Tenant2WorkPhone =new PhoneNumber( false , "Work" , "773-857-2231");
		PhoneNumber joeyProp1Unit2Tenant2HomePhone =new PhoneNumber( false , "Home" , "517-747-7664");

		joeyProp1Unit2Tenant2.getPhoneNumbers().add(joeyProp1Unit2Tenant2CellPhone);
		joeyProp1Unit2Tenant2.getPhoneNumbers().add(joeyProp1Unit2Tenant2WorkPhone);
		joeyProp1Unit2Tenant2.getPhoneNumbers().add(joeyProp1Unit2Tenant2HomePhone);

		EmailAddress joeyProp1Unit2Tenant2HomeEmail= new EmailAddress(true, "Home", "CarissaPoullion@gmail.com");
		EmailAddress joeyProp1Unit2Tenant2WorkEmail= new EmailAddress(false, "Work", "CarissaPoullion@work.com");
		EmailAddress joeyProp1Unit2Tenant2OtherEmail= new EmailAddress(false, "Other", "CarissaPoullion@aol.com");

		joeyProp1Unit2Tenant2.getEmailAddresses().add(joeyProp1Unit2Tenant2HomeEmail);
		joeyProp1Unit2Tenant2.getEmailAddresses().add(joeyProp1Unit2Tenant2WorkEmail);
		joeyProp1Unit2Tenant2.getEmailAddresses().add(joeyProp1Unit2Tenant2OtherEmail);

		DbFunctions.insert(joeyProp1Unit2Tenant);
		DbFunctions.insert(joeyProp1Unit2Tenant2);

		Set<Tenant> joeyProp1Unit2Tenanats = new HashSet<>();
		joeyProp1Unit2Tenanats.add(joeyProp1Unit2Tenant);
		joeyProp1Unit2Tenanats.add(joeyProp1Unit2Tenant2);
		joeyProp1Unit2.setTenants(joeyProp1Unit2Tenanats);
		DbFunctions.update(joeyProp1Unit2);




		Tenant joeyProp1Unit4Tenant = new Tenant ( joeyProp1Unit4, "Lashaunda", "Nichelle" , "Ostrosky" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeyProp1Unit4Tenant.setUserId("Lashaunda.Ostrosky@gmail.com");
		joeyProp1Unit4Tenant.setPassword(DbFunctions.hashPassword("Nichelle", joeyProp1Unit4Tenant.getSalt() ));

		PhoneNumber joeyProp1Unit4TenantCellPhone =new PhoneNumber( true , "Cell" , "770-507-8791");
		PhoneNumber joeyProp1Unit4TenantWorkPhone =new PhoneNumber( false , "Work" , "925-522-7798");
		PhoneNumber joeyProp1Unit4TenantHomePhone =new PhoneNumber( false , "Home" , "212-462-9157");

		joeyProp1Unit4Tenant.getPhoneNumbers().add(joeyProp1Unit4TenantCellPhone);
		joeyProp1Unit4Tenant.getPhoneNumbers().add(joeyProp1Unit4TenantWorkPhone);
		joeyProp1Unit4Tenant.getPhoneNumbers().add(joeyProp1Unit4TenantHomePhone);

		EmailAddress joeyProp1Unit4TenantHomeEmail= new EmailAddress(true, "Home", "LashaundaOstrosky@gmail.com");
		EmailAddress joeyProp1Unit4TenantWorkEmail= new EmailAddress(false, "Work", "LashaundaOstrosky@work.com");
		EmailAddress joeyProp1Unit4TenantOtherEmail= new EmailAddress(false, "Other", "LashaundaOstrosky@aol.com");

		joeyProp1Unit4Tenant.getEmailAddresses().add(joeyProp1Unit4TenantHomeEmail);
		joeyProp1Unit4Tenant.getEmailAddresses().add(joeyProp1Unit4TenantWorkEmail);
		joeyProp1Unit4Tenant.getEmailAddresses().add(joeyProp1Unit4TenantOtherEmail);

		Tenant joeyProp1Unit4Tenant2 = new Tenant ( joeyProp1Unit4, "Rikki", "Pamella" , "Sawchuk" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeyProp1Unit4Tenant2.setUserId("Rikki.Sawchuk@gmail.com");
		joeyProp1Unit4Tenant2.setPassword("Pamella");
		joeyProp1Unit4Tenant2.setPassword(DbFunctions.hashPassword("Pamella", joeyProp1Unit4Tenant2.getSalt() ));

		PhoneNumber joeyProp1Unit4Tenant2CellPhone =new PhoneNumber( true , "Cell" , "612-508-2655");
		PhoneNumber joeyProp1Unit4Tenant2WorkPhone =new PhoneNumber( false , "Work" , "609-234-8376");
		PhoneNumber joeyProp1Unit4Tenant2HomePhone =new PhoneNumber( false , "Home" , "808-475-2310");

		joeyProp1Unit4Tenant2.getPhoneNumbers().add(joeyProp1Unit4Tenant2CellPhone);
		joeyProp1Unit4Tenant2.getPhoneNumbers().add(joeyProp1Unit4Tenant2WorkPhone);
		joeyProp1Unit4Tenant2.getPhoneNumbers().add(joeyProp1Unit4Tenant2HomePhone);

		EmailAddress joeyProp1Unit4Tenant2HomeEmail= new EmailAddress(true, "Home", "RikkiSawchuk@gmail.com");
		EmailAddress joeyProp1Unit4Tenant2WorkEmail= new EmailAddress(false, "Work", "RikkiSawchuk@work.com");
		EmailAddress joeyProp1Unit4Tenant2OtherEmail= new EmailAddress(false, "Other", "RikkiSawchuk@aol.com");

		joeyProp1Unit4Tenant2.getEmailAddresses().add(joeyProp1Unit4Tenant2HomeEmail);
		joeyProp1Unit4Tenant2.getEmailAddresses().add(joeyProp1Unit4Tenant2WorkEmail);
		joeyProp1Unit4Tenant2.getEmailAddresses().add(joeyProp1Unit4Tenant2OtherEmail);

		DbFunctions.insert(joeyProp1Unit4Tenant);
		DbFunctions.insert(joeyProp1Unit4Tenant2);

		Set<Tenant> joeyProp1Unit4Tenanats = new HashSet<>();
		joeyProp1Unit4Tenanats.add(joeyProp1Unit4Tenant);
		joeyProp1Unit4Tenanats.add(joeyProp1Unit4Tenant2);
		joeyProp1Unit4.setTenants(joeyProp1Unit4Tenanats);
		DbFunctions.update(joeyProp1Unit4);




		Tenant joeyProp1Unit6Tenant = new Tenant ( joeyProp1Unit6, "Justine", "Gwenn" , "Brucato" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeyProp1Unit6Tenant.setUserId("Justine.Brucato@gmail.com");
		joeyProp1Unit6Tenant.setPassword(DbFunctions.hashPassword("Gwenn", joeyProp1Unit6Tenant.getSalt() ));

		PhoneNumber joeyProp1Unit6TenantCellPhone =new PhoneNumber( true , "Cell" , "760-971-4322");
		PhoneNumber joeyProp1Unit6TenantWorkPhone =new PhoneNumber( false , "Work" , "516-376-4230");
		PhoneNumber joeyProp1Unit6TenantHomePhone =new PhoneNumber( false , "Home" , "601-637-5479");

		joeyProp1Unit6Tenant.getPhoneNumbers().add(joeyProp1Unit6TenantCellPhone);
		joeyProp1Unit6Tenant.getPhoneNumbers().add(joeyProp1Unit6TenantWorkPhone);
		joeyProp1Unit6Tenant.getPhoneNumbers().add(joeyProp1Unit6TenantHomePhone);

		EmailAddress joeyProp1Unit6TenantHomeEmail= new EmailAddress(true, "Home", "JustineBrucato@gmail.com");
		EmailAddress joeyProp1Unit6TenantWorkEmail= new EmailAddress(false, "Work", "JustineBrucato@work.com");
		EmailAddress joeyProp1Unit6TenantOtherEmail= new EmailAddress(false, "Other", "JustineBrucato@aol.com");

		joeyProp1Unit6Tenant.getEmailAddresses().add(joeyProp1Unit6TenantHomeEmail);
		joeyProp1Unit6Tenant.getEmailAddresses().add(joeyProp1Unit6TenantWorkEmail);
		joeyProp1Unit6Tenant.getEmailAddresses().add(joeyProp1Unit6TenantOtherEmail);

		Tenant joeyProp1Unit6Tenant2 = new Tenant ( joeyProp1Unit6, "Glenn", "Daron" , "Tromblay" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeyProp1Unit6Tenant2.setUserId("Glenn.Tromblay@gmail.com");
		joeyProp1Unit6Tenant2.setPassword("Daron");
		joeyProp1Unit6Tenant2.setPassword(DbFunctions.hashPassword("Daron", joeyProp1Unit6Tenant2.getSalt() ));

		PhoneNumber joeyProp1Unit6Tenant2CellPhone =new PhoneNumber( true , "Cell" , "248-913-4677");
		PhoneNumber joeyProp1Unit6Tenant2WorkPhone =new PhoneNumber( false , "Work" , "517-867-8077");
		PhoneNumber joeyProp1Unit6Tenant2HomePhone =new PhoneNumber( false , "Home" , "760-465-4762");

		joeyProp1Unit6Tenant2.getPhoneNumbers().add(joeyProp1Unit6Tenant2CellPhone);
		joeyProp1Unit6Tenant2.getPhoneNumbers().add(joeyProp1Unit6Tenant2WorkPhone);
		joeyProp1Unit6Tenant2.getPhoneNumbers().add(joeyProp1Unit6Tenant2HomePhone);

		EmailAddress joeyProp1Unit6Tenant2HomeEmail= new EmailAddress(true, "Home", "GlennTromblay@gmail.com");
		EmailAddress joeyProp1Unit6Tenant2WorkEmail= new EmailAddress(false, "Work", "GlennTromblay@work.com");
		EmailAddress joeyProp1Unit6Tenant2OtherEmail= new EmailAddress(false, "Other", "GlennTromblay@aol.com");

		joeyProp1Unit6Tenant2.getEmailAddresses().add(joeyProp1Unit6Tenant2HomeEmail);
		joeyProp1Unit6Tenant2.getEmailAddresses().add(joeyProp1Unit6Tenant2WorkEmail);
		joeyProp1Unit6Tenant2.getEmailAddresses().add(joeyProp1Unit6Tenant2OtherEmail);

		DbFunctions.insert(joeyProp1Unit6Tenant);
		DbFunctions.insert(joeyProp1Unit6Tenant2);

		Set<Tenant> joeyProp1Unit6Tenanats = new HashSet<>();
		joeyProp1Unit6Tenanats.add(joeyProp1Unit6Tenant);
		joeyProp1Unit6Tenanats.add(joeyProp1Unit6Tenant2);
		joeyProp1Unit6.setTenants(joeyProp1Unit6Tenanats);
		DbFunctions.update(joeyProp1Unit6);




		Tenant joeyProp1Unit7Tenant = new Tenant ( joeyProp1Unit7, "Vi", "Serina" , "Rauser" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeyProp1Unit7Tenant.setUserId("Vi.Rauser@gmail.com");
		joeyProp1Unit7Tenant.setPassword(DbFunctions.hashPassword("Serina", joeyProp1Unit7Tenant.getSalt() ));

		PhoneNumber joeyProp1Unit7TenantCellPhone =new PhoneNumber( true , "Cell" , "325-869-2649");
		PhoneNumber joeyProp1Unit7TenantWorkPhone =new PhoneNumber( false , "Work" , "574-405-1983");
		PhoneNumber joeyProp1Unit7TenantHomePhone =new PhoneNumber( false , "Home" , "206-923-6042");

		joeyProp1Unit7Tenant.getPhoneNumbers().add(joeyProp1Unit7TenantCellPhone);
		joeyProp1Unit7Tenant.getPhoneNumbers().add(joeyProp1Unit7TenantWorkPhone);
		joeyProp1Unit7Tenant.getPhoneNumbers().add(joeyProp1Unit7TenantHomePhone);

		EmailAddress joeyProp1Unit7TenantHomeEmail= new EmailAddress(true, "Home", "ViRauser@gmail.com");
		EmailAddress joeyProp1Unit7TenantWorkEmail= new EmailAddress(false, "Work", "ViRauser@work.com");
		EmailAddress joeyProp1Unit7TenantOtherEmail= new EmailAddress(false, "Other", "ViRauser@aol.com");

		joeyProp1Unit7Tenant.getEmailAddresses().add(joeyProp1Unit7TenantHomeEmail);
		joeyProp1Unit7Tenant.getEmailAddresses().add(joeyProp1Unit7TenantWorkEmail);
		joeyProp1Unit7Tenant.getEmailAddresses().add(joeyProp1Unit7TenantOtherEmail);

		Tenant joeyProp1Unit7Tenant2 = new Tenant ( joeyProp1Unit7, "Fannie", "Cherry" , "Stimmel" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeyProp1Unit7Tenant2.setUserId("Fannie.Stimmel@gmail.com");
		joeyProp1Unit7Tenant2.setPassword("Cherry");
		joeyProp1Unit7Tenant2.setPassword(DbFunctions.hashPassword("Cherry", joeyProp1Unit7Tenant2.getSalt() ));

		PhoneNumber joeyProp1Unit7Tenant2CellPhone =new PhoneNumber( true , "Cell" , "212-402-9216");
		PhoneNumber joeyProp1Unit7Tenant2WorkPhone =new PhoneNumber( false , "Work" , "804-808-9574");
		PhoneNumber joeyProp1Unit7Tenant2HomePhone =new PhoneNumber( false , "Home" , "808-526-5863");

		joeyProp1Unit7Tenant2.getPhoneNumbers().add(joeyProp1Unit7Tenant2CellPhone);
		joeyProp1Unit7Tenant2.getPhoneNumbers().add(joeyProp1Unit7Tenant2WorkPhone);
		joeyProp1Unit7Tenant2.getPhoneNumbers().add(joeyProp1Unit7Tenant2HomePhone);

		EmailAddress joeyProp1Unit7Tenant2HomeEmail= new EmailAddress(true, "Home", "FannieStimmel@gmail.com");
		EmailAddress joeyProp1Unit7Tenant2WorkEmail= new EmailAddress(false, "Work", "FannieStimmel@work.com");
		EmailAddress joeyProp1Unit7Tenant2OtherEmail= new EmailAddress(false, "Other", "FannieStimmel@aol.com");

		joeyProp1Unit7Tenant2.getEmailAddresses().add(joeyProp1Unit7Tenant2HomeEmail);
		joeyProp1Unit7Tenant2.getEmailAddresses().add(joeyProp1Unit7Tenant2WorkEmail);
		joeyProp1Unit7Tenant2.getEmailAddresses().add(joeyProp1Unit7Tenant2OtherEmail);

		DbFunctions.insert(joeyProp1Unit7Tenant);
		DbFunctions.insert(joeyProp1Unit7Tenant2);

		Set<Tenant> joeyProp1Unit7Tenanats = new HashSet<>();
		joeyProp1Unit7Tenanats.add(joeyProp1Unit7Tenant);
		joeyProp1Unit7Tenanats.add(joeyProp1Unit7Tenant2);
		joeyProp1Unit7.setTenants(joeyProp1Unit7Tenanats);
		DbFunctions.update(joeyProp1Unit7);




		Tenant joeyProp1Unit8Tenant = new Tenant ( joeyProp1Unit8, "Erick", "Malcolm" , "Lorens" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeyProp1Unit8Tenant.setUserId("Erick.Lorens@gmail.com");
		joeyProp1Unit8Tenant.setPassword(DbFunctions.hashPassword("Malcolm", joeyProp1Unit8Tenant.getSalt() ));

		PhoneNumber joeyProp1Unit8TenantCellPhone =new PhoneNumber( true , "Cell" , "760-291-5497");
		PhoneNumber joeyProp1Unit8TenantWorkPhone =new PhoneNumber( false , "Work" , "303-521-9860");
		PhoneNumber joeyProp1Unit8TenantHomePhone =new PhoneNumber( false , "Home" , "619-695-8086");

		joeyProp1Unit8Tenant.getPhoneNumbers().add(joeyProp1Unit8TenantCellPhone);
		joeyProp1Unit8Tenant.getPhoneNumbers().add(joeyProp1Unit8TenantWorkPhone);
		joeyProp1Unit8Tenant.getPhoneNumbers().add(joeyProp1Unit8TenantHomePhone);

		EmailAddress joeyProp1Unit8TenantHomeEmail= new EmailAddress(true, "Home", "ErickLorens@gmail.com");
		EmailAddress joeyProp1Unit8TenantWorkEmail= new EmailAddress(false, "Work", "ErickLorens@work.com");
		EmailAddress joeyProp1Unit8TenantOtherEmail= new EmailAddress(false, "Other", "ErickLorens@aol.com");

		joeyProp1Unit8Tenant.getEmailAddresses().add(joeyProp1Unit8TenantHomeEmail);
		joeyProp1Unit8Tenant.getEmailAddresses().add(joeyProp1Unit8TenantWorkEmail);
		joeyProp1Unit8Tenant.getEmailAddresses().add(joeyProp1Unit8TenantOtherEmail);

		Tenant joeyProp1Unit8Tenant2 = new Tenant ( joeyProp1Unit8, "Benedict", "Colette" , "Schnitzler" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeyProp1Unit8Tenant2.setUserId("Benedict.Schnitzler@gmail.com");
		joeyProp1Unit8Tenant2.setPassword("Colette");
		joeyProp1Unit8Tenant2.setPassword(DbFunctions.hashPassword("Colette", joeyProp1Unit8Tenant2.getSalt() ));

		PhoneNumber joeyProp1Unit8Tenant2CellPhone =new PhoneNumber( true , "Cell" , "949-867-4077");
		PhoneNumber joeyProp1Unit8Tenant2WorkPhone =new PhoneNumber( false , "Work" , "214-225-5850");
		PhoneNumber joeyProp1Unit8Tenant2HomePhone =new PhoneNumber( false , "Home" , "858-732-1884");

		joeyProp1Unit8Tenant2.getPhoneNumbers().add(joeyProp1Unit8Tenant2CellPhone);
		joeyProp1Unit8Tenant2.getPhoneNumbers().add(joeyProp1Unit8Tenant2WorkPhone);
		joeyProp1Unit8Tenant2.getPhoneNumbers().add(joeyProp1Unit8Tenant2HomePhone);

		EmailAddress joeyProp1Unit8Tenant2HomeEmail= new EmailAddress(true, "Home", "BenedictSchnitzler@gmail.com");
		EmailAddress joeyProp1Unit8Tenant2WorkEmail= new EmailAddress(false, "Work", "BenedictSchnitzler@work.com");
		EmailAddress joeyProp1Unit8Tenant2OtherEmail= new EmailAddress(false, "Other", "BenedictSchnitzler@aol.com");

		joeyProp1Unit8Tenant2.getEmailAddresses().add(joeyProp1Unit8Tenant2HomeEmail);
		joeyProp1Unit8Tenant2.getEmailAddresses().add(joeyProp1Unit8Tenant2WorkEmail);
		joeyProp1Unit8Tenant2.getEmailAddresses().add(joeyProp1Unit8Tenant2OtherEmail);

		DbFunctions.insert(joeyProp1Unit8Tenant);
		DbFunctions.insert(joeyProp1Unit8Tenant2);

		Set<Tenant> joeyProp1Unit8Tenanats = new HashSet<>();
		joeyProp1Unit8Tenanats.add(joeyProp1Unit8Tenant);
		joeyProp1Unit8Tenanats.add(joeyProp1Unit8Tenant2);
		joeyProp1Unit8.setTenants(joeyProp1Unit8Tenanats);
		DbFunctions.update(joeyProp1Unit8);




		Tenant joeyProp1Unit9Tenant = new Tenant ( joeyProp1Unit9, "Gary", "Winfred" , "Steffensmeier" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeyProp1Unit9Tenant.setUserId("Gary.Steffensmeier@gmail.com");
		joeyProp1Unit9Tenant.setPassword(DbFunctions.hashPassword("Winfred", joeyProp1Unit9Tenant.getSalt() ));

		PhoneNumber joeyProp1Unit9TenantCellPhone =new PhoneNumber( true , "Cell" , "608-382-4541");
		PhoneNumber joeyProp1Unit9TenantWorkPhone =new PhoneNumber( false , "Work" , "817-819-7799");
		PhoneNumber joeyProp1Unit9TenantHomePhone =new PhoneNumber( false , "Home" , "406-374-7752");

		joeyProp1Unit9Tenant.getPhoneNumbers().add(joeyProp1Unit9TenantCellPhone);
		joeyProp1Unit9Tenant.getPhoneNumbers().add(joeyProp1Unit9TenantWorkPhone);
		joeyProp1Unit9Tenant.getPhoneNumbers().add(joeyProp1Unit9TenantHomePhone);

		EmailAddress joeyProp1Unit9TenantHomeEmail= new EmailAddress(true, "Home", "GarySteffensmeier@gmail.com");
		EmailAddress joeyProp1Unit9TenantWorkEmail= new EmailAddress(false, "Work", "GarySteffensmeier@work.com");
		EmailAddress joeyProp1Unit9TenantOtherEmail= new EmailAddress(false, "Other", "GarySteffensmeier@aol.com");

		joeyProp1Unit9Tenant.getEmailAddresses().add(joeyProp1Unit9TenantHomeEmail);
		joeyProp1Unit9Tenant.getEmailAddresses().add(joeyProp1Unit9TenantWorkEmail);
		joeyProp1Unit9Tenant.getEmailAddresses().add(joeyProp1Unit9TenantOtherEmail);

		Tenant joeyProp1Unit9Tenant2 = new Tenant ( joeyProp1Unit9, "Elly", "Deonna" , "Schnitzler" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeyProp1Unit9Tenant2.setUserId("Elly.Schnitzler@gmail.com");
		joeyProp1Unit9Tenant2.setPassword("Deonna");
		joeyProp1Unit9Tenant2.setPassword(DbFunctions.hashPassword("Deonna", joeyProp1Unit9Tenant2.getSalt() ));

		PhoneNumber joeyProp1Unit9Tenant2CellPhone =new PhoneNumber( true , "Cell" , "508-855-9887");
		PhoneNumber joeyProp1Unit9Tenant2WorkPhone =new PhoneNumber( false , "Work" , "608-586-6912");
		PhoneNumber joeyProp1Unit9Tenant2HomePhone =new PhoneNumber( false , "Home" , "574-330-1884");

		joeyProp1Unit9Tenant2.getPhoneNumbers().add(joeyProp1Unit9Tenant2CellPhone);
		joeyProp1Unit9Tenant2.getPhoneNumbers().add(joeyProp1Unit9Tenant2WorkPhone);
		joeyProp1Unit9Tenant2.getPhoneNumbers().add(joeyProp1Unit9Tenant2HomePhone);

		EmailAddress joeyProp1Unit9Tenant2HomeEmail= new EmailAddress(true, "Home", "EllySchnitzler@gmail.com");
		EmailAddress joeyProp1Unit9Tenant2WorkEmail= new EmailAddress(false, "Work", "EllySchnitzler@work.com");
		EmailAddress joeyProp1Unit9Tenant2OtherEmail= new EmailAddress(false, "Other", "EllySchnitzler@aol.com");

		joeyProp1Unit9Tenant2.getEmailAddresses().add(joeyProp1Unit9Tenant2HomeEmail);
		joeyProp1Unit9Tenant2.getEmailAddresses().add(joeyProp1Unit9Tenant2WorkEmail);
		joeyProp1Unit9Tenant2.getEmailAddresses().add(joeyProp1Unit9Tenant2OtherEmail);

		DbFunctions.insert(joeyProp1Unit9Tenant);
		DbFunctions.insert(joeyProp1Unit9Tenant2);

		Set<Tenant> joeyProp1Unit9Tenanats = new HashSet<>();
		joeyProp1Unit9Tenanats.add(joeyProp1Unit9Tenant);
		joeyProp1Unit9Tenanats.add(joeyProp1Unit9Tenant2);
		joeyProp1Unit9.setTenants(joeyProp1Unit9Tenanats);
		DbFunctions.update(joeyProp1Unit9);




		Tenant joeyProp1Unit10Tenant = new Tenant ( joeyProp1Unit10, "Quentin", "Dierdre" , "Setter" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeyProp1Unit10Tenant.setUserId("Quentin.Setter@gmail.com");
		joeyProp1Unit10Tenant.setPassword(DbFunctions.hashPassword("Dierdre", joeyProp1Unit10Tenant.getSalt() ));

		PhoneNumber joeyProp1Unit10TenantCellPhone =new PhoneNumber( true , "Cell" , "419-939-3613");
		PhoneNumber joeyProp1Unit10TenantWorkPhone =new PhoneNumber( false , "Work" , "925-522-7798");
		PhoneNumber joeyProp1Unit10TenantHomePhone =new PhoneNumber( false , "Home" , "419-313-5571");

		joeyProp1Unit10Tenant.getPhoneNumbers().add(joeyProp1Unit10TenantCellPhone);
		joeyProp1Unit10Tenant.getPhoneNumbers().add(joeyProp1Unit10TenantWorkPhone);
		joeyProp1Unit10Tenant.getPhoneNumbers().add(joeyProp1Unit10TenantHomePhone);

		EmailAddress joeyProp1Unit10TenantHomeEmail= new EmailAddress(true, "Home", "QuentinSetter@gmail.com");
		EmailAddress joeyProp1Unit10TenantWorkEmail= new EmailAddress(false, "Work", "QuentinSetter@work.com");
		EmailAddress joeyProp1Unit10TenantOtherEmail= new EmailAddress(false, "Other", "QuentinSetter@aol.com");

		joeyProp1Unit10Tenant.getEmailAddresses().add(joeyProp1Unit10TenantHomeEmail);
		joeyProp1Unit10Tenant.getEmailAddresses().add(joeyProp1Unit10TenantWorkEmail);
		joeyProp1Unit10Tenant.getEmailAddresses().add(joeyProp1Unit10TenantOtherEmail);

		Tenant joeyProp1Unit10Tenant2 = new Tenant ( joeyProp1Unit10, "Scarlet", "Amber" , "Angalich" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeyProp1Unit10Tenant2.setUserId("Scarlet.Angalich@gmail.com");
		joeyProp1Unit10Tenant2.setPassword("Amber");
		joeyProp1Unit10Tenant2.setPassword(DbFunctions.hashPassword("Amber", joeyProp1Unit10Tenant2.getSalt() ));

		PhoneNumber joeyProp1Unit10Tenant2CellPhone =new PhoneNumber( true , "Cell" , "516-968-6051");
		PhoneNumber joeyProp1Unit10Tenant2WorkPhone =new PhoneNumber( false , "Work" , "803-975-3405");
		PhoneNumber joeyProp1Unit10Tenant2HomePhone =new PhoneNumber( false , "Home" , "305-304-6573");

		joeyProp1Unit10Tenant2.getPhoneNumbers().add(joeyProp1Unit10Tenant2CellPhone);
		joeyProp1Unit10Tenant2.getPhoneNumbers().add(joeyProp1Unit10Tenant2WorkPhone);
		joeyProp1Unit10Tenant2.getPhoneNumbers().add(joeyProp1Unit10Tenant2HomePhone);

		EmailAddress joeyProp1Unit10Tenant2HomeEmail= new EmailAddress(true, "Home", "ScarletAngalich@gmail.com");
		EmailAddress joeyProp1Unit10Tenant2WorkEmail= new EmailAddress(false, "Work", "ScarletAngalich@work.com");
		EmailAddress joeyProp1Unit10Tenant2OtherEmail= new EmailAddress(false, "Other", "ScarletAngalich@aol.com");

		joeyProp1Unit10Tenant2.getEmailAddresses().add(joeyProp1Unit10Tenant2HomeEmail);
		joeyProp1Unit10Tenant2.getEmailAddresses().add(joeyProp1Unit10Tenant2WorkEmail);
		joeyProp1Unit10Tenant2.getEmailAddresses().add(joeyProp1Unit10Tenant2OtherEmail);

		DbFunctions.insert(joeyProp1Unit10Tenant);
		DbFunctions.insert(joeyProp1Unit10Tenant2);

		Set<Tenant> joeyProp1Unit10Tenanats = new HashSet<>();
		joeyProp1Unit10Tenanats.add(joeyProp1Unit10Tenant);
		joeyProp1Unit10Tenanats.add(joeyProp1Unit10Tenant2);
		joeyProp1Unit10.setTenants(joeyProp1Unit10Tenanats);
		DbFunctions.update(joeyProp1Unit10);




		Tenant joeyProp1Unit11Tenant = new Tenant ( joeyProp1Unit11, "Gertude", "Karl" , "Aquas" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeyProp1Unit11Tenant.setUserId("Gertude.Aquas@gmail.com");
		joeyProp1Unit11Tenant.setPassword(DbFunctions.hashPassword("Karl", joeyProp1Unit11Tenant.getSalt() ));

		PhoneNumber joeyProp1Unit11TenantCellPhone =new PhoneNumber( true , "Cell" , "703-235-3937");
		PhoneNumber joeyProp1Unit11TenantWorkPhone =new PhoneNumber( false , "Work" , "952-938-9457");
		PhoneNumber joeyProp1Unit11TenantHomePhone =new PhoneNumber( false , "Home" , "617-997-5771");

		joeyProp1Unit11Tenant.getPhoneNumbers().add(joeyProp1Unit11TenantCellPhone);
		joeyProp1Unit11Tenant.getPhoneNumbers().add(joeyProp1Unit11TenantWorkPhone);
		joeyProp1Unit11Tenant.getPhoneNumbers().add(joeyProp1Unit11TenantHomePhone);

		EmailAddress joeyProp1Unit11TenantHomeEmail= new EmailAddress(true, "Home", "GertudeAquas@gmail.com");
		EmailAddress joeyProp1Unit11TenantWorkEmail= new EmailAddress(false, "Work", "GertudeAquas@work.com");
		EmailAddress joeyProp1Unit11TenantOtherEmail= new EmailAddress(false, "Other", "GertudeAquas@aol.com");

		joeyProp1Unit11Tenant.getEmailAddresses().add(joeyProp1Unit11TenantHomeEmail);
		joeyProp1Unit11Tenant.getEmailAddresses().add(joeyProp1Unit11TenantWorkEmail);
		joeyProp1Unit11Tenant.getEmailAddresses().add(joeyProp1Unit11TenantOtherEmail);

		Tenant joeyProp1Unit11Tenant2 = new Tenant ( joeyProp1Unit11, "Twana", "Lashawnda" , "Dilliard" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeyProp1Unit11Tenant2.setUserId("Twana.Dilliard@gmail.com");
		joeyProp1Unit11Tenant2.setPassword("Lashawnda");
		joeyProp1Unit11Tenant2.setPassword(DbFunctions.hashPassword("Lashawnda", joeyProp1Unit11Tenant2.getSalt() ));

		PhoneNumber joeyProp1Unit11Tenant2CellPhone =new PhoneNumber( true , "Cell" , "260-273-3725");
		PhoneNumber joeyProp1Unit11Tenant2WorkPhone =new PhoneNumber( false , "Work" , "513-863-9471");
		PhoneNumber joeyProp1Unit11Tenant2HomePhone =new PhoneNumber( false , "Home" , "215-351-8523");

		joeyProp1Unit11Tenant2.getPhoneNumbers().add(joeyProp1Unit11Tenant2CellPhone);
		joeyProp1Unit11Tenant2.getPhoneNumbers().add(joeyProp1Unit11Tenant2WorkPhone);
		joeyProp1Unit11Tenant2.getPhoneNumbers().add(joeyProp1Unit11Tenant2HomePhone);

		EmailAddress joeyProp1Unit11Tenant2HomeEmail= new EmailAddress(true, "Home", "TwanaDilliard@gmail.com");
		EmailAddress joeyProp1Unit11Tenant2WorkEmail= new EmailAddress(false, "Work", "TwanaDilliard@work.com");
		EmailAddress joeyProp1Unit11Tenant2OtherEmail= new EmailAddress(false, "Other", "TwanaDilliard@aol.com");

		joeyProp1Unit11Tenant2.getEmailAddresses().add(joeyProp1Unit11Tenant2HomeEmail);
		joeyProp1Unit11Tenant2.getEmailAddresses().add(joeyProp1Unit11Tenant2WorkEmail);
		joeyProp1Unit11Tenant2.getEmailAddresses().add(joeyProp1Unit11Tenant2OtherEmail);

		DbFunctions.insert(joeyProp1Unit11Tenant);
		DbFunctions.insert(joeyProp1Unit11Tenant2);

		Set<Tenant> joeyProp1Unit11Tenanats = new HashSet<>();
		joeyProp1Unit11Tenanats.add(joeyProp1Unit11Tenant);
		joeyProp1Unit11Tenanats.add(joeyProp1Unit11Tenant2);
		joeyProp1Unit11.setTenants(joeyProp1Unit11Tenanats);
		DbFunctions.update(joeyProp1Unit11);




		Tenant joeyProp1Unit12Tenant = new Tenant ( joeyProp1Unit12, "Paz", "My" , "Pawlowicz" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeyProp1Unit12Tenant.setUserId("Paz.Pawlowicz@gmail.com");
		joeyProp1Unit12Tenant.setPassword(DbFunctions.hashPassword("My", joeyProp1Unit12Tenant.getSalt() ));

		PhoneNumber joeyProp1Unit12TenantCellPhone =new PhoneNumber( true , "Cell" , "201-431-2989");
		PhoneNumber joeyProp1Unit12TenantWorkPhone =new PhoneNumber( false , "Work" , "303-521-9860");
		PhoneNumber joeyProp1Unit12TenantHomePhone =new PhoneNumber( false , "Home" , "512-693-8345");

		joeyProp1Unit12Tenant.getPhoneNumbers().add(joeyProp1Unit12TenantCellPhone);
		joeyProp1Unit12Tenant.getPhoneNumbers().add(joeyProp1Unit12TenantWorkPhone);
		joeyProp1Unit12Tenant.getPhoneNumbers().add(joeyProp1Unit12TenantHomePhone);

		EmailAddress joeyProp1Unit12TenantHomeEmail= new EmailAddress(true, "Home", "PazPawlowicz@gmail.com");
		EmailAddress joeyProp1Unit12TenantWorkEmail= new EmailAddress(false, "Work", "PazPawlowicz@work.com");
		EmailAddress joeyProp1Unit12TenantOtherEmail= new EmailAddress(false, "Other", "PazPawlowicz@aol.com");

		joeyProp1Unit12Tenant.getEmailAddresses().add(joeyProp1Unit12TenantHomeEmail);
		joeyProp1Unit12Tenant.getEmailAddresses().add(joeyProp1Unit12TenantWorkEmail);
		joeyProp1Unit12Tenant.getEmailAddresses().add(joeyProp1Unit12TenantOtherEmail);

		Tenant joeyProp1Unit12Tenant2 = new Tenant ( joeyProp1Unit12, "Tresa", "Graciela" , "Birkner" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeyProp1Unit12Tenant2.setUserId("Tresa.Birkner@gmail.com");
		joeyProp1Unit12Tenant2.setPassword("Graciela");
		joeyProp1Unit12Tenant2.setPassword(DbFunctions.hashPassword("Graciela", joeyProp1Unit12Tenant2.getSalt() ));

		PhoneNumber joeyProp1Unit12Tenant2CellPhone =new PhoneNumber( true , "Cell" , "631-258-6558");
		PhoneNumber joeyProp1Unit12Tenant2WorkPhone =new PhoneNumber( false , "Work" , "785-253-7049");
		PhoneNumber joeyProp1Unit12Tenant2HomePhone =new PhoneNumber( false , "Home" , "509-595-6485");

		joeyProp1Unit12Tenant2.getPhoneNumbers().add(joeyProp1Unit12Tenant2CellPhone);
		joeyProp1Unit12Tenant2.getPhoneNumbers().add(joeyProp1Unit12Tenant2WorkPhone);
		joeyProp1Unit12Tenant2.getPhoneNumbers().add(joeyProp1Unit12Tenant2HomePhone);

		EmailAddress joeyProp1Unit12Tenant2HomeEmail= new EmailAddress(true, "Home", "TresaBirkner@gmail.com");
		EmailAddress joeyProp1Unit12Tenant2WorkEmail= new EmailAddress(false, "Work", "TresaBirkner@work.com");
		EmailAddress joeyProp1Unit12Tenant2OtherEmail= new EmailAddress(false, "Other", "TresaBirkner@aol.com");

		joeyProp1Unit12Tenant2.getEmailAddresses().add(joeyProp1Unit12Tenant2HomeEmail);
		joeyProp1Unit12Tenant2.getEmailAddresses().add(joeyProp1Unit12Tenant2WorkEmail);
		joeyProp1Unit12Tenant2.getEmailAddresses().add(joeyProp1Unit12Tenant2OtherEmail);

		DbFunctions.insert(joeyProp1Unit12Tenant);
		DbFunctions.insert(joeyProp1Unit12Tenant2);

		Set<Tenant> joeyProp1Unit12Tenanats = new HashSet<>();
		joeyProp1Unit12Tenanats.add(joeyProp1Unit12Tenant);
		joeyProp1Unit12Tenanats.add(joeyProp1Unit12Tenant2);
		joeyProp1Unit12.setTenants(joeyProp1Unit12Tenanats);
		DbFunctions.update(joeyProp1Unit12);




		Tenant joeyProp1Unit14Tenant = new Tenant ( joeyProp1Unit14, "Jerry", "Lawrence" , "Degonia" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeyProp1Unit14Tenant.setUserId("Jerry.Degonia@gmail.com");
		joeyProp1Unit14Tenant.setPassword(DbFunctions.hashPassword("Lawrence", joeyProp1Unit14Tenant.getSalt() ));

		PhoneNumber joeyProp1Unit14TenantCellPhone =new PhoneNumber( true , "Cell" , "414-748-1374");
		PhoneNumber joeyProp1Unit14TenantWorkPhone =new PhoneNumber( false , "Work" , "574-405-1983");
		PhoneNumber joeyProp1Unit14TenantHomePhone =new PhoneNumber( false , "Home" , "714-698-2170");

		joeyProp1Unit14Tenant.getPhoneNumbers().add(joeyProp1Unit14TenantCellPhone);
		joeyProp1Unit14Tenant.getPhoneNumbers().add(joeyProp1Unit14TenantWorkPhone);
		joeyProp1Unit14Tenant.getPhoneNumbers().add(joeyProp1Unit14TenantHomePhone);

		EmailAddress joeyProp1Unit14TenantHomeEmail= new EmailAddress(true, "Home", "JerryDegonia@gmail.com");
		EmailAddress joeyProp1Unit14TenantWorkEmail= new EmailAddress(false, "Work", "JerryDegonia@work.com");
		EmailAddress joeyProp1Unit14TenantOtherEmail= new EmailAddress(false, "Other", "JerryDegonia@aol.com");

		joeyProp1Unit14Tenant.getEmailAddresses().add(joeyProp1Unit14TenantHomeEmail);
		joeyProp1Unit14Tenant.getEmailAddresses().add(joeyProp1Unit14TenantWorkEmail);
		joeyProp1Unit14Tenant.getEmailAddresses().add(joeyProp1Unit14TenantOtherEmail);

		Tenant joeyProp1Unit14Tenant2 = new Tenant ( joeyProp1Unit14, "Maryann", "Alishia" , "Waycott" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeyProp1Unit14Tenant2.setUserId("Maryann.Waycott@gmail.com");
		joeyProp1Unit14Tenant2.setPassword("Alishia");
		joeyProp1Unit14Tenant2.setPassword(DbFunctions.hashPassword("Alishia", joeyProp1Unit14Tenant2.getSalt() ));

		PhoneNumber joeyProp1Unit14Tenant2CellPhone =new PhoneNumber( true , "Cell" , "337-515-1438");
		PhoneNumber joeyProp1Unit14Tenant2WorkPhone =new PhoneNumber( false , "Work" , "207-297-5029");
		PhoneNumber joeyProp1Unit14Tenant2HomePhone =new PhoneNumber( false , "Home" , "775-578-1214");

		joeyProp1Unit14Tenant2.getPhoneNumbers().add(joeyProp1Unit14Tenant2CellPhone);
		joeyProp1Unit14Tenant2.getPhoneNumbers().add(joeyProp1Unit14Tenant2WorkPhone);
		joeyProp1Unit14Tenant2.getPhoneNumbers().add(joeyProp1Unit14Tenant2HomePhone);

		EmailAddress joeyProp1Unit14Tenant2HomeEmail= new EmailAddress(true, "Home", "MaryannWaycott@gmail.com");
		EmailAddress joeyProp1Unit14Tenant2WorkEmail= new EmailAddress(false, "Work", "MaryannWaycott@work.com");
		EmailAddress joeyProp1Unit14Tenant2OtherEmail= new EmailAddress(false, "Other", "MaryannWaycott@aol.com");

		joeyProp1Unit14Tenant2.getEmailAddresses().add(joeyProp1Unit14Tenant2HomeEmail);
		joeyProp1Unit14Tenant2.getEmailAddresses().add(joeyProp1Unit14Tenant2WorkEmail);
		joeyProp1Unit14Tenant2.getEmailAddresses().add(joeyProp1Unit14Tenant2OtherEmail);

		DbFunctions.insert(joeyProp1Unit14Tenant);
		DbFunctions.insert(joeyProp1Unit14Tenant2);

		Set<Tenant> joeyProp1Unit14Tenanats = new HashSet<>();
		joeyProp1Unit14Tenanats.add(joeyProp1Unit14Tenant);
		joeyProp1Unit14Tenanats.add(joeyProp1Unit14Tenant2);
		joeyProp1Unit14.setTenants(joeyProp1Unit14Tenanats);
		DbFunctions.update(joeyProp1Unit14);




		Tenant joeyProp1Unit15Tenant = new Tenant ( joeyProp1Unit15, "Yvonne", "Alaine" , "Koppinger" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeyProp1Unit15Tenant.setUserId("Yvonne.Koppinger@gmail.com");
		joeyProp1Unit15Tenant.setPassword(DbFunctions.hashPassword("Alaine", joeyProp1Unit15Tenant.getSalt() ));

		PhoneNumber joeyProp1Unit15TenantCellPhone =new PhoneNumber( true , "Cell" , "516-212-1915");
		PhoneNumber joeyProp1Unit15TenantWorkPhone =new PhoneNumber( false , "Work" , "209-242-7022");
		PhoneNumber joeyProp1Unit15TenantHomePhone =new PhoneNumber( false , "Home" , "410-951-2667");

		joeyProp1Unit15Tenant.getPhoneNumbers().add(joeyProp1Unit15TenantCellPhone);
		joeyProp1Unit15Tenant.getPhoneNumbers().add(joeyProp1Unit15TenantWorkPhone);
		joeyProp1Unit15Tenant.getPhoneNumbers().add(joeyProp1Unit15TenantHomePhone);

		EmailAddress joeyProp1Unit15TenantHomeEmail= new EmailAddress(true, "Home", "YvonneKoppinger@gmail.com");
		EmailAddress joeyProp1Unit15TenantWorkEmail= new EmailAddress(false, "Work", "YvonneKoppinger@work.com");
		EmailAddress joeyProp1Unit15TenantOtherEmail= new EmailAddress(false, "Other", "YvonneKoppinger@aol.com");

		joeyProp1Unit15Tenant.getEmailAddresses().add(joeyProp1Unit15TenantHomeEmail);
		joeyProp1Unit15Tenant.getEmailAddresses().add(joeyProp1Unit15TenantWorkEmail);
		joeyProp1Unit15Tenant.getEmailAddresses().add(joeyProp1Unit15TenantOtherEmail);

		Tenant joeyProp1Unit15Tenant2 = new Tenant ( joeyProp1Unit15, "Carmen", "Jesusa" , "Vocelka" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeyProp1Unit15Tenant2.setUserId("Carmen.Vocelka@gmail.com");
		joeyProp1Unit15Tenant2.setPassword("Jesusa");
		joeyProp1Unit15Tenant2.setPassword(DbFunctions.hashPassword("Jesusa", joeyProp1Unit15Tenant2.getSalt() ));

		PhoneNumber joeyProp1Unit15Tenant2CellPhone =new PhoneNumber( true , "Cell" , "512-213-8574");
		PhoneNumber joeyProp1Unit15Tenant2WorkPhone =new PhoneNumber( false , "Work" , "513-418-1566");
		PhoneNumber joeyProp1Unit15Tenant2HomePhone =new PhoneNumber( false , "Home" , "212-428-9538");

		joeyProp1Unit15Tenant2.getPhoneNumbers().add(joeyProp1Unit15Tenant2CellPhone);
		joeyProp1Unit15Tenant2.getPhoneNumbers().add(joeyProp1Unit15Tenant2WorkPhone);
		joeyProp1Unit15Tenant2.getPhoneNumbers().add(joeyProp1Unit15Tenant2HomePhone);

		EmailAddress joeyProp1Unit15Tenant2HomeEmail= new EmailAddress(true, "Home", "CarmenVocelka@gmail.com");
		EmailAddress joeyProp1Unit15Tenant2WorkEmail= new EmailAddress(false, "Work", "CarmenVocelka@work.com");
		EmailAddress joeyProp1Unit15Tenant2OtherEmail= new EmailAddress(false, "Other", "CarmenVocelka@aol.com");

		joeyProp1Unit15Tenant2.getEmailAddresses().add(joeyProp1Unit15Tenant2HomeEmail);
		joeyProp1Unit15Tenant2.getEmailAddresses().add(joeyProp1Unit15Tenant2WorkEmail);
		joeyProp1Unit15Tenant2.getEmailAddresses().add(joeyProp1Unit15Tenant2OtherEmail);

		DbFunctions.insert(joeyProp1Unit15Tenant);
		DbFunctions.insert(joeyProp1Unit15Tenant2);

		Set<Tenant> joeyProp1Unit15Tenanats = new HashSet<>();
		joeyProp1Unit15Tenanats.add(joeyProp1Unit15Tenant);
		joeyProp1Unit15Tenanats.add(joeyProp1Unit15Tenant2);
		joeyProp1Unit15.setTenants(joeyProp1Unit15Tenanats);
		DbFunctions.update(joeyProp1Unit15);




		Tenant joeProp1Unit1Tenant = new Tenant ( joeProp1Unit1, "Nu", "Francine" , "Fortino" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeProp1Unit1Tenant.setUserId("Nu.Fortino@gmail.com");
		joeProp1Unit1Tenant.setPassword(DbFunctions.hashPassword("Francine", joeProp1Unit1Tenant.getSalt() ));

		PhoneNumber joeProp1Unit1TenantCellPhone =new PhoneNumber( true , "Cell" , "562-579-6900");
		PhoneNumber joeProp1Unit1TenantWorkPhone =new PhoneNumber( false , "Work" , "701-421-7080");
		PhoneNumber joeProp1Unit1TenantHomePhone =new PhoneNumber( false , "Home" , "973-563-9502");

		joeProp1Unit1Tenant.getPhoneNumbers().add(joeProp1Unit1TenantCellPhone);
		joeProp1Unit1Tenant.getPhoneNumbers().add(joeProp1Unit1TenantWorkPhone);
		joeProp1Unit1Tenant.getPhoneNumbers().add(joeProp1Unit1TenantHomePhone);

		EmailAddress joeProp1Unit1TenantHomeEmail= new EmailAddress(true, "Home", "NuFortino@gmail.com");
		EmailAddress joeProp1Unit1TenantWorkEmail= new EmailAddress(false, "Work", "NuFortino@work.com");
		EmailAddress joeProp1Unit1TenantOtherEmail= new EmailAddress(false, "Other", "NuFortino@aol.com");

		joeProp1Unit1Tenant.getEmailAddresses().add(joeProp1Unit1TenantHomeEmail);
		joeProp1Unit1Tenant.getEmailAddresses().add(joeProp1Unit1TenantWorkEmail);
		joeProp1Unit1Tenant.getEmailAddresses().add(joeProp1Unit1TenantOtherEmail);

		Tenant joeProp1Unit1Tenant2 = new Tenant ( joeProp1Unit1, "Rozella", "Leonida" , "Lorens" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeProp1Unit1Tenant2.setUserId("Rozella.Lorens@gmail.com");
		joeProp1Unit1Tenant2.setPassword("Leonida");
		joeProp1Unit1Tenant2.setPassword(DbFunctions.hashPassword("Leonida", joeProp1Unit1Tenant2.getSalt() ));

		PhoneNumber joeProp1Unit1Tenant2CellPhone =new PhoneNumber( true , "Cell" , "773-225-9985");
		PhoneNumber joeProp1Unit1Tenant2WorkPhone =new PhoneNumber( false , "Work" , "770-531-2842");
		PhoneNumber joeProp1Unit1Tenant2HomePhone =new PhoneNumber( false , "Home" , "760-465-4762");

		joeProp1Unit1Tenant2.getPhoneNumbers().add(joeProp1Unit1Tenant2CellPhone);
		joeProp1Unit1Tenant2.getPhoneNumbers().add(joeProp1Unit1Tenant2WorkPhone);
		joeProp1Unit1Tenant2.getPhoneNumbers().add(joeProp1Unit1Tenant2HomePhone);

		EmailAddress joeProp1Unit1Tenant2HomeEmail= new EmailAddress(true, "Home", "RozellaLorens@gmail.com");
		EmailAddress joeProp1Unit1Tenant2WorkEmail= new EmailAddress(false, "Work", "RozellaLorens@work.com");
		EmailAddress joeProp1Unit1Tenant2OtherEmail= new EmailAddress(false, "Other", "RozellaLorens@aol.com");

		joeProp1Unit1Tenant2.getEmailAddresses().add(joeProp1Unit1Tenant2HomeEmail);
		joeProp1Unit1Tenant2.getEmailAddresses().add(joeProp1Unit1Tenant2WorkEmail);
		joeProp1Unit1Tenant2.getEmailAddresses().add(joeProp1Unit1Tenant2OtherEmail);

		DbFunctions.insert(joeProp1Unit1Tenant);
		DbFunctions.insert(joeProp1Unit1Tenant2);

		Set<Tenant> joeProp1Unit1Tenanats = new HashSet<>();
		joeProp1Unit1Tenanats.add(joeProp1Unit1Tenant);
		joeProp1Unit1Tenanats.add(joeProp1Unit1Tenant2);
		joeProp1Unit1.setTenants(joeProp1Unit1Tenanats);
		DbFunctions.update(joeProp1Unit1);




		Tenant joeProp2Unit1Tenant = new Tenant ( joeProp2Unit1, "Nieves", "Jenelle" , "Colla" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeProp2Unit1Tenant.setUserId("Nieves.Colla@gmail.com");
		joeProp2Unit1Tenant.setPassword(DbFunctions.hashPassword("Jenelle", joeProp2Unit1Tenant.getSalt() ));

		PhoneNumber joeProp2Unit1TenantCellPhone =new PhoneNumber( true , "Cell" , "305-385-9695");
		PhoneNumber joeProp2Unit1TenantWorkPhone =new PhoneNumber( false , "Work" , "850-330-8079");
		PhoneNumber joeProp2Unit1TenantHomePhone =new PhoneNumber( false , "Home" , "847-556-2909");

		joeProp2Unit1Tenant.getPhoneNumbers().add(joeProp2Unit1TenantCellPhone);
		joeProp2Unit1Tenant.getPhoneNumbers().add(joeProp2Unit1TenantWorkPhone);
		joeProp2Unit1Tenant.getPhoneNumbers().add(joeProp2Unit1TenantHomePhone);

		EmailAddress joeProp2Unit1TenantHomeEmail= new EmailAddress(true, "Home", "NievesColla@gmail.com");
		EmailAddress joeProp2Unit1TenantWorkEmail= new EmailAddress(false, "Work", "NievesColla@work.com");
		EmailAddress joeProp2Unit1TenantOtherEmail= new EmailAddress(false, "Other", "NievesColla@aol.com");

		joeProp2Unit1Tenant.getEmailAddresses().add(joeProp2Unit1TenantHomeEmail);
		joeProp2Unit1Tenant.getEmailAddresses().add(joeProp2Unit1TenantWorkEmail);
		joeProp2Unit1Tenant.getEmailAddresses().add(joeProp2Unit1TenantOtherEmail);

		Tenant joeProp2Unit1Tenant2 = new Tenant ( joeProp2Unit1, "Adelina", "Audra" , "Hagele" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeProp2Unit1Tenant2.setUserId("Adelina.Hagele@gmail.com");
		joeProp2Unit1Tenant2.setPassword("Audra");
		joeProp2Unit1Tenant2.setPassword(DbFunctions.hashPassword("Audra", joeProp2Unit1Tenant2.getSalt() ));

		PhoneNumber joeProp2Unit1Tenant2CellPhone =new PhoneNumber( true , "Cell" , "810-292-9388");
		PhoneNumber joeProp2Unit1Tenant2WorkPhone =new PhoneNumber( false , "Work" , "307-453-7589");
		PhoneNumber joeProp2Unit1Tenant2HomePhone =new PhoneNumber( false , "Home" , "907-921-2010");

		joeProp2Unit1Tenant2.getPhoneNumbers().add(joeProp2Unit1Tenant2CellPhone);
		joeProp2Unit1Tenant2.getPhoneNumbers().add(joeProp2Unit1Tenant2WorkPhone);
		joeProp2Unit1Tenant2.getPhoneNumbers().add(joeProp2Unit1Tenant2HomePhone);

		EmailAddress joeProp2Unit1Tenant2HomeEmail= new EmailAddress(true, "Home", "AdelinaHagele@gmail.com");
		EmailAddress joeProp2Unit1Tenant2WorkEmail= new EmailAddress(false, "Work", "AdelinaHagele@work.com");
		EmailAddress joeProp2Unit1Tenant2OtherEmail= new EmailAddress(false, "Other", "AdelinaHagele@aol.com");

		joeProp2Unit1Tenant2.getEmailAddresses().add(joeProp2Unit1Tenant2HomeEmail);
		joeProp2Unit1Tenant2.getEmailAddresses().add(joeProp2Unit1Tenant2WorkEmail);
		joeProp2Unit1Tenant2.getEmailAddresses().add(joeProp2Unit1Tenant2OtherEmail);

		DbFunctions.insert(joeProp2Unit1Tenant);
		DbFunctions.insert(joeProp2Unit1Tenant2);

		Set<Tenant> joeProp2Unit1Tenanats = new HashSet<>();
		joeProp2Unit1Tenanats.add(joeProp2Unit1Tenant);
		joeProp2Unit1Tenanats.add(joeProp2Unit1Tenant2);
		joeProp2Unit1.setTenants(joeProp2Unit1Tenanats);
		DbFunctions.update(joeProp2Unit1);




		Tenant joeProp3Unit1Tenant = new Tenant ( joeProp3Unit1, "Helene", "Joseph" , "Myricks" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeProp3Unit1Tenant.setUserId("Helene.Myricks@gmail.com");
		joeProp3Unit1Tenant.setPassword(DbFunctions.hashPassword("Joseph", joeProp3Unit1Tenant.getSalt() ));

		PhoneNumber joeProp3Unit1TenantCellPhone =new PhoneNumber( true , "Cell" , "305-968-9487");
		PhoneNumber joeProp3Unit1TenantWorkPhone =new PhoneNumber( false , "Work" , "775-578-1214");
		PhoneNumber joeProp3Unit1TenantHomePhone =new PhoneNumber( false , "Home" , "212-880-8865");

		joeProp3Unit1Tenant.getPhoneNumbers().add(joeProp3Unit1TenantCellPhone);
		joeProp3Unit1Tenant.getPhoneNumbers().add(joeProp3Unit1TenantWorkPhone);
		joeProp3Unit1Tenant.getPhoneNumbers().add(joeProp3Unit1TenantHomePhone);

		EmailAddress joeProp3Unit1TenantHomeEmail= new EmailAddress(true, "Home", "HeleneMyricks@gmail.com");
		EmailAddress joeProp3Unit1TenantWorkEmail= new EmailAddress(false, "Work", "HeleneMyricks@work.com");
		EmailAddress joeProp3Unit1TenantOtherEmail= new EmailAddress(false, "Other", "HeleneMyricks@aol.com");

		joeProp3Unit1Tenant.getEmailAddresses().add(joeProp3Unit1TenantHomeEmail);
		joeProp3Unit1Tenant.getEmailAddresses().add(joeProp3Unit1TenantWorkEmail);
		joeProp3Unit1Tenant.getEmailAddresses().add(joeProp3Unit1TenantOtherEmail);

		Tenant joeProp3Unit1Tenant2 = new Tenant ( joeProp3Unit1, "Herman", "Annabelle" , "Sayaphon" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeProp3Unit1Tenant2.setUserId("Herman.Sayaphon@gmail.com");
		joeProp3Unit1Tenant2.setPassword("Annabelle");
		joeProp3Unit1Tenant2.setPassword(DbFunctions.hashPassword("Annabelle", joeProp3Unit1Tenant2.getSalt() ));

		PhoneNumber joeProp3Unit1Tenant2CellPhone =new PhoneNumber( true , "Cell" , "410-669-1642");
		PhoneNumber joeProp3Unit1Tenant2WorkPhone =new PhoneNumber( false , "Work" , "856-702-3676");
		PhoneNumber joeProp3Unit1Tenant2HomePhone =new PhoneNumber( false , "Home" , "734-851-8571");

		joeProp3Unit1Tenant2.getPhoneNumbers().add(joeProp3Unit1Tenant2CellPhone);
		joeProp3Unit1Tenant2.getPhoneNumbers().add(joeProp3Unit1Tenant2WorkPhone);
		joeProp3Unit1Tenant2.getPhoneNumbers().add(joeProp3Unit1Tenant2HomePhone);

		EmailAddress joeProp3Unit1Tenant2HomeEmail= new EmailAddress(true, "Home", "HermanSayaphon@gmail.com");
		EmailAddress joeProp3Unit1Tenant2WorkEmail= new EmailAddress(false, "Work", "HermanSayaphon@work.com");
		EmailAddress joeProp3Unit1Tenant2OtherEmail= new EmailAddress(false, "Other", "HermanSayaphon@aol.com");

		joeProp3Unit1Tenant2.getEmailAddresses().add(joeProp3Unit1Tenant2HomeEmail);
		joeProp3Unit1Tenant2.getEmailAddresses().add(joeProp3Unit1Tenant2WorkEmail);
		joeProp3Unit1Tenant2.getEmailAddresses().add(joeProp3Unit1Tenant2OtherEmail);

		DbFunctions.insert(joeProp3Unit1Tenant);
		DbFunctions.insert(joeProp3Unit1Tenant2);

		Set<Tenant> joeProp3Unit1Tenanats = new HashSet<>();
		joeProp3Unit1Tenanats.add(joeProp3Unit1Tenant);
		joeProp3Unit1Tenanats.add(joeProp3Unit1Tenant2);
		joeProp3Unit1.setTenants(joeProp3Unit1Tenanats);
		DbFunctions.update(joeProp3Unit1);




		Tenant joeProp4Unit1Tenant = new Tenant ( joeProp4Unit1, "Deonna", "Myra" , "Sarao" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		joeProp4Unit1Tenant.setUserId("Deonna.Sarao@gmail.com");
		joeProp4Unit1Tenant.setPassword(DbFunctions.hashPassword("Myra", joeProp4Unit1Tenant.getSalt() ));

		PhoneNumber joeProp4Unit1TenantCellPhone =new PhoneNumber( true , "Cell" , "325-631-1560");
		PhoneNumber joeProp4Unit1TenantWorkPhone =new PhoneNumber( false , "Work" , "856-828-6021");
		PhoneNumber joeProp4Unit1TenantHomePhone =new PhoneNumber( false , "Home" , "419-399-1744");

		joeProp4Unit1Tenant.getPhoneNumbers().add(joeProp4Unit1TenantCellPhone);
		joeProp4Unit1Tenant.getPhoneNumbers().add(joeProp4Unit1TenantWorkPhone);
		joeProp4Unit1Tenant.getPhoneNumbers().add(joeProp4Unit1TenantHomePhone);

		EmailAddress joeProp4Unit1TenantHomeEmail= new EmailAddress(true, "Home", "DeonnaSarao@gmail.com");
		EmailAddress joeProp4Unit1TenantWorkEmail= new EmailAddress(false, "Work", "DeonnaSarao@work.com");
		EmailAddress joeProp4Unit1TenantOtherEmail= new EmailAddress(false, "Other", "DeonnaSarao@aol.com");

		joeProp4Unit1Tenant.getEmailAddresses().add(joeProp4Unit1TenantHomeEmail);
		joeProp4Unit1Tenant.getEmailAddresses().add(joeProp4Unit1TenantWorkEmail);
		joeProp4Unit1Tenant.getEmailAddresses().add(joeProp4Unit1TenantOtherEmail);

		Tenant joeProp4Unit1Tenant2 = new Tenant ( joeProp4Unit1, "Tonette", "Claribel" , "Vocelka" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		joeProp4Unit1Tenant2.setUserId("Tonette.Vocelka@gmail.com");
		joeProp4Unit1Tenant2.setPassword("Claribel");
		joeProp4Unit1Tenant2.setPassword(DbFunctions.hashPassword("Claribel", joeProp4Unit1Tenant2.getSalt() ));

		PhoneNumber joeProp4Unit1Tenant2CellPhone =new PhoneNumber( true , "Cell" , "972-419-7946");
		PhoneNumber joeProp4Unit1Tenant2WorkPhone =new PhoneNumber( false , "Work" , "907-873-2882");
		PhoneNumber joeProp4Unit1Tenant2HomePhone =new PhoneNumber( false , "Home" , "401-885-7681");

		joeProp4Unit1Tenant2.getPhoneNumbers().add(joeProp4Unit1Tenant2CellPhone);
		joeProp4Unit1Tenant2.getPhoneNumbers().add(joeProp4Unit1Tenant2WorkPhone);
		joeProp4Unit1Tenant2.getPhoneNumbers().add(joeProp4Unit1Tenant2HomePhone);

		EmailAddress joeProp4Unit1Tenant2HomeEmail= new EmailAddress(true, "Home", "TonetteVocelka@gmail.com");
		EmailAddress joeProp4Unit1Tenant2WorkEmail= new EmailAddress(false, "Work", "TonetteVocelka@work.com");
		EmailAddress joeProp4Unit1Tenant2OtherEmail= new EmailAddress(false, "Other", "TonetteVocelka@aol.com");

		joeProp4Unit1Tenant2.getEmailAddresses().add(joeProp4Unit1Tenant2HomeEmail);
		joeProp4Unit1Tenant2.getEmailAddresses().add(joeProp4Unit1Tenant2WorkEmail);
		joeProp4Unit1Tenant2.getEmailAddresses().add(joeProp4Unit1Tenant2OtherEmail);

		DbFunctions.insert(joeProp4Unit1Tenant);
		DbFunctions.insert(joeProp4Unit1Tenant2);

		Set<Tenant> joeProp4Unit1Tenanats = new HashSet<>();
		joeProp4Unit1Tenanats.add(joeProp4Unit1Tenant);
		joeProp4Unit1Tenanats.add(joeProp4Unit1Tenant2);
		joeProp4Unit1.setTenants(joeProp4Unit1Tenanats);
		DbFunctions.update(joeProp4Unit1);




		Tenant janeProp1Unit1Tenant = new Tenant ( janeProp1Unit1, "Laurel", "Ahmed" , "Jacobos" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		janeProp1Unit1Tenant.setUserId("Laurel.Jacobos@gmail.com");
		janeProp1Unit1Tenant.setPassword(DbFunctions.hashPassword("Ahmed", janeProp1Unit1Tenant.getSalt() ));

		PhoneNumber janeProp1Unit1TenantCellPhone =new PhoneNumber( true , "Cell" , "310-510-9713");
		PhoneNumber janeProp1Unit1TenantWorkPhone =new PhoneNumber( false , "Work" , "215-829-4221");
		PhoneNumber janeProp1Unit1TenantHomePhone =new PhoneNumber( false , "Home" , "707-821-8037");

		janeProp1Unit1Tenant.getPhoneNumbers().add(janeProp1Unit1TenantCellPhone);
		janeProp1Unit1Tenant.getPhoneNumbers().add(janeProp1Unit1TenantWorkPhone);
		janeProp1Unit1Tenant.getPhoneNumbers().add(janeProp1Unit1TenantHomePhone);

		EmailAddress janeProp1Unit1TenantHomeEmail= new EmailAddress(true, "Home", "LaurelJacobos@gmail.com");
		EmailAddress janeProp1Unit1TenantWorkEmail= new EmailAddress(false, "Work", "LaurelJacobos@work.com");
		EmailAddress janeProp1Unit1TenantOtherEmail= new EmailAddress(false, "Other", "LaurelJacobos@aol.com");

		janeProp1Unit1Tenant.getEmailAddresses().add(janeProp1Unit1TenantHomeEmail);
		janeProp1Unit1Tenant.getEmailAddresses().add(janeProp1Unit1TenantWorkEmail);
		janeProp1Unit1Tenant.getEmailAddresses().add(janeProp1Unit1TenantOtherEmail);

		Tenant janeProp1Unit1Tenant2 = new Tenant ( janeProp1Unit1, "Cristal", "Terrilyn" , "Zurcher" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		janeProp1Unit1Tenant2.setUserId("Cristal.Zurcher@gmail.com");
		janeProp1Unit1Tenant2.setPassword("Terrilyn");
		janeProp1Unit1Tenant2.setPassword(DbFunctions.hashPassword("Terrilyn", janeProp1Unit1Tenant2.getSalt() ));

		PhoneNumber janeProp1Unit1Tenant2CellPhone =new PhoneNumber( true , "Cell" , "916-591-3277");
		PhoneNumber janeProp1Unit1Tenant2WorkPhone =new PhoneNumber( false , "Work" , "408-813-1105");
		PhoneNumber janeProp1Unit1Tenant2HomePhone =new PhoneNumber( false , "Home" , "619-695-8086");

		janeProp1Unit1Tenant2.getPhoneNumbers().add(janeProp1Unit1Tenant2CellPhone);
		janeProp1Unit1Tenant2.getPhoneNumbers().add(janeProp1Unit1Tenant2WorkPhone);
		janeProp1Unit1Tenant2.getPhoneNumbers().add(janeProp1Unit1Tenant2HomePhone);

		EmailAddress janeProp1Unit1Tenant2HomeEmail= new EmailAddress(true, "Home", "CristalZurcher@gmail.com");
		EmailAddress janeProp1Unit1Tenant2WorkEmail= new EmailAddress(false, "Work", "CristalZurcher@work.com");
		EmailAddress janeProp1Unit1Tenant2OtherEmail= new EmailAddress(false, "Other", "CristalZurcher@aol.com");

		janeProp1Unit1Tenant2.getEmailAddresses().add(janeProp1Unit1Tenant2HomeEmail);
		janeProp1Unit1Tenant2.getEmailAddresses().add(janeProp1Unit1Tenant2WorkEmail);
		janeProp1Unit1Tenant2.getEmailAddresses().add(janeProp1Unit1Tenant2OtherEmail);

		DbFunctions.insert(janeProp1Unit1Tenant);
		DbFunctions.insert(janeProp1Unit1Tenant2);

		Set<Tenant> janeProp1Unit1Tenanats = new HashSet<>();
		janeProp1Unit1Tenanats.add(janeProp1Unit1Tenant);
		janeProp1Unit1Tenanats.add(janeProp1Unit1Tenant2);
		janeProp1Unit1.setTenants(janeProp1Unit1Tenanats);
		DbFunctions.update(janeProp1Unit1);




		Tenant janeProp1Unit2Tenant = new Tenant ( janeProp1Unit2, "Brock", "Erick" , "Honeywell" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		janeProp1Unit2Tenant.setUserId("Brock.Honeywell@gmail.com");
		janeProp1Unit2Tenant.setPassword(DbFunctions.hashPassword("Erick", janeProp1Unit2Tenant.getSalt() ));

		PhoneNumber janeProp1Unit2TenantCellPhone =new PhoneNumber( true , "Cell" , "952-768-2416");
		PhoneNumber janeProp1Unit2TenantWorkPhone =new PhoneNumber( false , "Work" , "919-885-2453");
		PhoneNumber janeProp1Unit2TenantHomePhone =new PhoneNumber( false , "Home" , "212-753-2740");

		janeProp1Unit2Tenant.getPhoneNumbers().add(janeProp1Unit2TenantCellPhone);
		janeProp1Unit2Tenant.getPhoneNumbers().add(janeProp1Unit2TenantWorkPhone);
		janeProp1Unit2Tenant.getPhoneNumbers().add(janeProp1Unit2TenantHomePhone);

		EmailAddress janeProp1Unit2TenantHomeEmail= new EmailAddress(true, "Home", "BrockHoneywell@gmail.com");
		EmailAddress janeProp1Unit2TenantWorkEmail= new EmailAddress(false, "Work", "BrockHoneywell@work.com");
		EmailAddress janeProp1Unit2TenantOtherEmail= new EmailAddress(false, "Other", "BrockHoneywell@aol.com");

		janeProp1Unit2Tenant.getEmailAddresses().add(janeProp1Unit2TenantHomeEmail);
		janeProp1Unit2Tenant.getEmailAddresses().add(janeProp1Unit2TenantWorkEmail);
		janeProp1Unit2Tenant.getEmailAddresses().add(janeProp1Unit2TenantOtherEmail);

		Tenant janeProp1Unit2Tenant2 = new Tenant ( janeProp1Unit2, "Sage", "Eun" , "Kownacki" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		janeProp1Unit2Tenant2.setUserId("Sage.Kownacki@gmail.com");
		janeProp1Unit2Tenant2.setPassword("Eun");
		janeProp1Unit2Tenant2.setPassword(DbFunctions.hashPassword("Eun", janeProp1Unit2Tenant2.getSalt() ));

		PhoneNumber janeProp1Unit2Tenant2CellPhone =new PhoneNumber( true , "Cell" , "315-818-2638");
		PhoneNumber janeProp1Unit2Tenant2WorkPhone =new PhoneNumber( false , "Work" , "808-526-5863");
		PhoneNumber janeProp1Unit2Tenant2HomePhone =new PhoneNumber( false , "Home" , "336-564-1492");

		janeProp1Unit2Tenant2.getPhoneNumbers().add(janeProp1Unit2Tenant2CellPhone);
		janeProp1Unit2Tenant2.getPhoneNumbers().add(janeProp1Unit2Tenant2WorkPhone);
		janeProp1Unit2Tenant2.getPhoneNumbers().add(janeProp1Unit2Tenant2HomePhone);

		EmailAddress janeProp1Unit2Tenant2HomeEmail= new EmailAddress(true, "Home", "SageKownacki@gmail.com");
		EmailAddress janeProp1Unit2Tenant2WorkEmail= new EmailAddress(false, "Work", "SageKownacki@work.com");
		EmailAddress janeProp1Unit2Tenant2OtherEmail= new EmailAddress(false, "Other", "SageKownacki@aol.com");

		janeProp1Unit2Tenant2.getEmailAddresses().add(janeProp1Unit2Tenant2HomeEmail);
		janeProp1Unit2Tenant2.getEmailAddresses().add(janeProp1Unit2Tenant2WorkEmail);
		janeProp1Unit2Tenant2.getEmailAddresses().add(janeProp1Unit2Tenant2OtherEmail);

		DbFunctions.insert(janeProp1Unit2Tenant);
		DbFunctions.insert(janeProp1Unit2Tenant2);

		Set<Tenant> janeProp1Unit2Tenanats = new HashSet<>();
		janeProp1Unit2Tenanats.add(janeProp1Unit2Tenant);
		janeProp1Unit2Tenanats.add(janeProp1Unit2Tenant2);
		janeProp1Unit2.setTenants(janeProp1Unit2Tenanats);
		DbFunctions.update(janeProp1Unit2);




		Tenant janeProp1Unit4Tenant = new Tenant ( janeProp1Unit4, "Lili", "Roosevelt" , "Pinilla" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		janeProp1Unit4Tenant.setUserId("Lili.Pinilla@gmail.com");
		janeProp1Unit4Tenant.setPassword(DbFunctions.hashPassword("Roosevelt", janeProp1Unit4Tenant.getSalt() ));

		PhoneNumber janeProp1Unit4TenantCellPhone =new PhoneNumber( true , "Cell" , "208-709-1235");
		PhoneNumber janeProp1Unit4TenantWorkPhone =new PhoneNumber( false , "Work" , "908-448-1209");
		PhoneNumber janeProp1Unit4TenantHomePhone =new PhoneNumber( false , "Home" , "951-248-6822");

		janeProp1Unit4Tenant.getPhoneNumbers().add(janeProp1Unit4TenantCellPhone);
		janeProp1Unit4Tenant.getPhoneNumbers().add(janeProp1Unit4TenantWorkPhone);
		janeProp1Unit4Tenant.getPhoneNumbers().add(janeProp1Unit4TenantHomePhone);

		EmailAddress janeProp1Unit4TenantHomeEmail= new EmailAddress(true, "Home", "LiliPinilla@gmail.com");
		EmailAddress janeProp1Unit4TenantWorkEmail= new EmailAddress(false, "Work", "LiliPinilla@work.com");
		EmailAddress janeProp1Unit4TenantOtherEmail= new EmailAddress(false, "Other", "LiliPinilla@aol.com");

		janeProp1Unit4Tenant.getEmailAddresses().add(janeProp1Unit4TenantHomeEmail);
		janeProp1Unit4Tenant.getEmailAddresses().add(janeProp1Unit4TenantWorkEmail);
		janeProp1Unit4Tenant.getEmailAddresses().add(janeProp1Unit4TenantOtherEmail);

		Tenant janeProp1Unit4Tenant2 = new Tenant ( janeProp1Unit4, "Noah", "Lisha" , "Paulas" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		janeProp1Unit4Tenant2.setUserId("Noah.Paulas@gmail.com");
		janeProp1Unit4Tenant2.setPassword("Lisha");
		janeProp1Unit4Tenant2.setPassword(DbFunctions.hashPassword("Lisha", janeProp1Unit4Tenant2.getSalt() ));

		PhoneNumber janeProp1Unit4Tenant2CellPhone =new PhoneNumber( true , "Cell" , "215-268-1275");
		PhoneNumber janeProp1Unit4Tenant2WorkPhone =new PhoneNumber( false , "Work" , "570-469-8401");
		PhoneNumber janeProp1Unit4Tenant2HomePhone =new PhoneNumber( false , "Home" , "254-205-1422");

		janeProp1Unit4Tenant2.getPhoneNumbers().add(janeProp1Unit4Tenant2CellPhone);
		janeProp1Unit4Tenant2.getPhoneNumbers().add(janeProp1Unit4Tenant2WorkPhone);
		janeProp1Unit4Tenant2.getPhoneNumbers().add(janeProp1Unit4Tenant2HomePhone);

		EmailAddress janeProp1Unit4Tenant2HomeEmail= new EmailAddress(true, "Home", "NoahPaulas@gmail.com");
		EmailAddress janeProp1Unit4Tenant2WorkEmail= new EmailAddress(false, "Work", "NoahPaulas@work.com");
		EmailAddress janeProp1Unit4Tenant2OtherEmail= new EmailAddress(false, "Other", "NoahPaulas@aol.com");

		janeProp1Unit4Tenant2.getEmailAddresses().add(janeProp1Unit4Tenant2HomeEmail);
		janeProp1Unit4Tenant2.getEmailAddresses().add(janeProp1Unit4Tenant2WorkEmail);
		janeProp1Unit4Tenant2.getEmailAddresses().add(janeProp1Unit4Tenant2OtherEmail);

		DbFunctions.insert(janeProp1Unit4Tenant);
		DbFunctions.insert(janeProp1Unit4Tenant2);

		Set<Tenant> janeProp1Unit4Tenanats = new HashSet<>();
		janeProp1Unit4Tenanats.add(janeProp1Unit4Tenant);
		janeProp1Unit4Tenanats.add(janeProp1Unit4Tenant2);
		janeProp1Unit4.setTenants(janeProp1Unit4Tenanats);
		DbFunctions.update(janeProp1Unit4);




		Tenant janeProp1Unit6Tenant = new Tenant ( janeProp1Unit6, "Izetta", "Melissa" , "Isenhower" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		janeProp1Unit6Tenant.setUserId("Izetta.Isenhower@gmail.com");
		janeProp1Unit6Tenant.setPassword(DbFunctions.hashPassword("Melissa", janeProp1Unit6Tenant.getSalt() ));

		PhoneNumber janeProp1Unit6TenantCellPhone =new PhoneNumber( true , "Cell" , "512-213-8574");
		PhoneNumber janeProp1Unit6TenantWorkPhone =new PhoneNumber( false , "Work" , "201-478-8540");
		PhoneNumber janeProp1Unit6TenantHomePhone =new PhoneNumber( false , "Home" , "718-478-8568");

		janeProp1Unit6Tenant.getPhoneNumbers().add(janeProp1Unit6TenantCellPhone);
		janeProp1Unit6Tenant.getPhoneNumbers().add(janeProp1Unit6TenantWorkPhone);
		janeProp1Unit6Tenant.getPhoneNumbers().add(janeProp1Unit6TenantHomePhone);

		EmailAddress janeProp1Unit6TenantHomeEmail= new EmailAddress(true, "Home", "IzettaIsenhower@gmail.com");
		EmailAddress janeProp1Unit6TenantWorkEmail= new EmailAddress(false, "Work", "IzettaIsenhower@work.com");
		EmailAddress janeProp1Unit6TenantOtherEmail= new EmailAddress(false, "Other", "IzettaIsenhower@aol.com");

		janeProp1Unit6Tenant.getEmailAddresses().add(janeProp1Unit6TenantHomeEmail);
		janeProp1Unit6Tenant.getEmailAddresses().add(janeProp1Unit6TenantWorkEmail);
		janeProp1Unit6Tenant.getEmailAddresses().add(janeProp1Unit6TenantOtherEmail);

		Tenant janeProp1Unit6Tenant2 = new Tenant ( janeProp1Unit6, "Tammara", "Blondell" , "Calvaresi" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		janeProp1Unit6Tenant2.setUserId("Tammara.Calvaresi@gmail.com");
		janeProp1Unit6Tenant2.setPassword("Blondell");
		janeProp1Unit6Tenant2.setPassword(DbFunctions.hashPassword("Blondell", janeProp1Unit6Tenant2.getSalt() ));

		PhoneNumber janeProp1Unit6Tenant2CellPhone =new PhoneNumber( true , "Cell" , "619-509-5282");
		PhoneNumber janeProp1Unit6Tenant2WorkPhone =new PhoneNumber( false , "Work" , "908-448-1209");
		PhoneNumber janeProp1Unit6Tenant2HomePhone =new PhoneNumber( false , "Home" , "936-937-2334");

		janeProp1Unit6Tenant2.getPhoneNumbers().add(janeProp1Unit6Tenant2CellPhone);
		janeProp1Unit6Tenant2.getPhoneNumbers().add(janeProp1Unit6Tenant2WorkPhone);
		janeProp1Unit6Tenant2.getPhoneNumbers().add(janeProp1Unit6Tenant2HomePhone);

		EmailAddress janeProp1Unit6Tenant2HomeEmail= new EmailAddress(true, "Home", "TammaraCalvaresi@gmail.com");
		EmailAddress janeProp1Unit6Tenant2WorkEmail= new EmailAddress(false, "Work", "TammaraCalvaresi@work.com");
		EmailAddress janeProp1Unit6Tenant2OtherEmail= new EmailAddress(false, "Other", "TammaraCalvaresi@aol.com");

		janeProp1Unit6Tenant2.getEmailAddresses().add(janeProp1Unit6Tenant2HomeEmail);
		janeProp1Unit6Tenant2.getEmailAddresses().add(janeProp1Unit6Tenant2WorkEmail);
		janeProp1Unit6Tenant2.getEmailAddresses().add(janeProp1Unit6Tenant2OtherEmail);

		DbFunctions.insert(janeProp1Unit6Tenant);
		DbFunctions.insert(janeProp1Unit6Tenant2);

		Set<Tenant> janeProp1Unit6Tenanats = new HashSet<>();
		janeProp1Unit6Tenanats.add(janeProp1Unit6Tenant);
		janeProp1Unit6Tenanats.add(janeProp1Unit6Tenant2);
		janeProp1Unit6.setTenants(janeProp1Unit6Tenanats);
		DbFunctions.update(janeProp1Unit6);




		Tenant janeProp1Unit7Tenant = new Tenant ( janeProp1Unit7, "Buddy", "Layla" , "Candlish" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		janeProp1Unit7Tenant.setUserId("Buddy.Candlish@gmail.com");
		janeProp1Unit7Tenant.setPassword(DbFunctions.hashPassword("Layla", janeProp1Unit7Tenant.getSalt() ));

		PhoneNumber janeProp1Unit7TenantCellPhone =new PhoneNumber( true , "Cell" , "740-343-8575");
		PhoneNumber janeProp1Unit7TenantWorkPhone =new PhoneNumber( false , "Work" , "210-300-6244");
		PhoneNumber janeProp1Unit7TenantHomePhone =new PhoneNumber( false , "Home" , "847-957-4614");

		janeProp1Unit7Tenant.getPhoneNumbers().add(janeProp1Unit7TenantCellPhone);
		janeProp1Unit7Tenant.getPhoneNumbers().add(janeProp1Unit7TenantWorkPhone);
		janeProp1Unit7Tenant.getPhoneNumbers().add(janeProp1Unit7TenantHomePhone);

		EmailAddress janeProp1Unit7TenantHomeEmail= new EmailAddress(true, "Home", "BuddyCandlish@gmail.com");
		EmailAddress janeProp1Unit7TenantWorkEmail= new EmailAddress(false, "Work", "BuddyCandlish@work.com");
		EmailAddress janeProp1Unit7TenantOtherEmail= new EmailAddress(false, "Other", "BuddyCandlish@aol.com");

		janeProp1Unit7Tenant.getEmailAddresses().add(janeProp1Unit7TenantHomeEmail);
		janeProp1Unit7Tenant.getEmailAddresses().add(janeProp1Unit7TenantWorkEmail);
		janeProp1Unit7Tenant.getEmailAddresses().add(janeProp1Unit7TenantOtherEmail);

		Tenant janeProp1Unit7Tenant2 = new Tenant ( janeProp1Unit7, "Haydee", "Janine" , "Aquas" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		janeProp1Unit7Tenant2.setUserId("Haydee.Aquas@gmail.com");
		janeProp1Unit7Tenant2.setPassword("Janine");
		janeProp1Unit7Tenant2.setPassword(DbFunctions.hashPassword("Janine", janeProp1Unit7Tenant2.getSalt() ));

		PhoneNumber janeProp1Unit7Tenant2CellPhone =new PhoneNumber( true , "Cell" , "530-986-9272");
		PhoneNumber janeProp1Unit7Tenant2WorkPhone =new PhoneNumber( false , "Work" , "440-579-7763");
		PhoneNumber janeProp1Unit7Tenant2HomePhone =new PhoneNumber( false , "Home" , "808-526-5863");

		janeProp1Unit7Tenant2.getPhoneNumbers().add(janeProp1Unit7Tenant2CellPhone);
		janeProp1Unit7Tenant2.getPhoneNumbers().add(janeProp1Unit7Tenant2WorkPhone);
		janeProp1Unit7Tenant2.getPhoneNumbers().add(janeProp1Unit7Tenant2HomePhone);

		EmailAddress janeProp1Unit7Tenant2HomeEmail= new EmailAddress(true, "Home", "HaydeeAquas@gmail.com");
		EmailAddress janeProp1Unit7Tenant2WorkEmail= new EmailAddress(false, "Work", "HaydeeAquas@work.com");
		EmailAddress janeProp1Unit7Tenant2OtherEmail= new EmailAddress(false, "Other", "HaydeeAquas@aol.com");

		janeProp1Unit7Tenant2.getEmailAddresses().add(janeProp1Unit7Tenant2HomeEmail);
		janeProp1Unit7Tenant2.getEmailAddresses().add(janeProp1Unit7Tenant2WorkEmail);
		janeProp1Unit7Tenant2.getEmailAddresses().add(janeProp1Unit7Tenant2OtherEmail);

		DbFunctions.insert(janeProp1Unit7Tenant);
		DbFunctions.insert(janeProp1Unit7Tenant2);

		Set<Tenant> janeProp1Unit7Tenanats = new HashSet<>();
		janeProp1Unit7Tenanats.add(janeProp1Unit7Tenant);
		janeProp1Unit7Tenanats.add(janeProp1Unit7Tenant2);
		janeProp1Unit7.setTenants(janeProp1Unit7Tenanats);
		DbFunctions.update(janeProp1Unit7);




		Tenant janeProp1Unit8Tenant = new Tenant ( janeProp1Unit8, "Norah", "Evangelina" , "Hagele" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		janeProp1Unit8Tenant.setUserId("Norah.Hagele@gmail.com");
		janeProp1Unit8Tenant.setPassword(DbFunctions.hashPassword("Evangelina", janeProp1Unit8Tenant.getSalt() ));

		PhoneNumber janeProp1Unit8TenantCellPhone =new PhoneNumber( true , "Cell" , "310-560-8022");
		PhoneNumber janeProp1Unit8TenantWorkPhone =new PhoneNumber( false , "Work" , "504-265-8174");
		PhoneNumber janeProp1Unit8TenantHomePhone =new PhoneNumber( false , "Home" , "949-903-3898");

		janeProp1Unit8Tenant.getPhoneNumbers().add(janeProp1Unit8TenantCellPhone);
		janeProp1Unit8Tenant.getPhoneNumbers().add(janeProp1Unit8TenantWorkPhone);
		janeProp1Unit8Tenant.getPhoneNumbers().add(janeProp1Unit8TenantHomePhone);

		EmailAddress janeProp1Unit8TenantHomeEmail= new EmailAddress(true, "Home", "NorahHagele@gmail.com");
		EmailAddress janeProp1Unit8TenantWorkEmail= new EmailAddress(false, "Work", "NorahHagele@work.com");
		EmailAddress janeProp1Unit8TenantOtherEmail= new EmailAddress(false, "Other", "NorahHagele@aol.com");

		janeProp1Unit8Tenant.getEmailAddresses().add(janeProp1Unit8TenantHomeEmail);
		janeProp1Unit8Tenant.getEmailAddresses().add(janeProp1Unit8TenantWorkEmail);
		janeProp1Unit8Tenant.getEmailAddresses().add(janeProp1Unit8TenantOtherEmail);

		Tenant janeProp1Unit8Tenant2 = new Tenant ( janeProp1Unit8, "Christiane", "Ezekiel" , "Klusman" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		janeProp1Unit8Tenant2.setUserId("Christiane.Klusman@gmail.com");
		janeProp1Unit8Tenant2.setPassword("Ezekiel");
		janeProp1Unit8Tenant2.setPassword(DbFunctions.hashPassword("Ezekiel", janeProp1Unit8Tenant2.getSalt() ));

		PhoneNumber janeProp1Unit8Tenant2CellPhone =new PhoneNumber( true , "Cell" , "212-860-1579");
		PhoneNumber janeProp1Unit8Tenant2WorkPhone =new PhoneNumber( false , "Work" , "323-842-8226");
		PhoneNumber janeProp1Unit8Tenant2HomePhone =new PhoneNumber( false , "Home" , "336-564-1492");

		janeProp1Unit8Tenant2.getPhoneNumbers().add(janeProp1Unit8Tenant2CellPhone);
		janeProp1Unit8Tenant2.getPhoneNumbers().add(janeProp1Unit8Tenant2WorkPhone);
		janeProp1Unit8Tenant2.getPhoneNumbers().add(janeProp1Unit8Tenant2HomePhone);

		EmailAddress janeProp1Unit8Tenant2HomeEmail= new EmailAddress(true, "Home", "ChristianeKlusman@gmail.com");
		EmailAddress janeProp1Unit8Tenant2WorkEmail= new EmailAddress(false, "Work", "ChristianeKlusman@work.com");
		EmailAddress janeProp1Unit8Tenant2OtherEmail= new EmailAddress(false, "Other", "ChristianeKlusman@aol.com");

		janeProp1Unit8Tenant2.getEmailAddresses().add(janeProp1Unit8Tenant2HomeEmail);
		janeProp1Unit8Tenant2.getEmailAddresses().add(janeProp1Unit8Tenant2WorkEmail);
		janeProp1Unit8Tenant2.getEmailAddresses().add(janeProp1Unit8Tenant2OtherEmail);

		DbFunctions.insert(janeProp1Unit8Tenant);
		DbFunctions.insert(janeProp1Unit8Tenant2);

		Set<Tenant> janeProp1Unit8Tenanats = new HashSet<>();
		janeProp1Unit8Tenanats.add(janeProp1Unit8Tenant);
		janeProp1Unit8Tenanats.add(janeProp1Unit8Tenant2);
		janeProp1Unit8.setTenants(janeProp1Unit8Tenanats);
		DbFunctions.update(janeProp1Unit8);




		Tenant janeProp1Unit9Tenant = new Tenant ( janeProp1Unit9, "Leonida", "Loreta" , "Scriven" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		janeProp1Unit9Tenant.setUserId("Leonida.Scriven@gmail.com");
		janeProp1Unit9Tenant.setPassword(DbFunctions.hashPassword("Loreta", janeProp1Unit9Tenant.getSalt() ));

		PhoneNumber janeProp1Unit9TenantCellPhone =new PhoneNumber( true , "Cell" , "206-711-6498");
		PhoneNumber janeProp1Unit9TenantWorkPhone =new PhoneNumber( false , "Work" , "321-597-2159");
		PhoneNumber janeProp1Unit9TenantHomePhone =new PhoneNumber( false , "Home" , "610-378-7332");

		janeProp1Unit9Tenant.getPhoneNumbers().add(janeProp1Unit9TenantCellPhone);
		janeProp1Unit9Tenant.getPhoneNumbers().add(janeProp1Unit9TenantWorkPhone);
		janeProp1Unit9Tenant.getPhoneNumbers().add(janeProp1Unit9TenantHomePhone);

		EmailAddress janeProp1Unit9TenantHomeEmail= new EmailAddress(true, "Home", "LeonidaScriven@gmail.com");
		EmailAddress janeProp1Unit9TenantWorkEmail= new EmailAddress(false, "Work", "LeonidaScriven@work.com");
		EmailAddress janeProp1Unit9TenantOtherEmail= new EmailAddress(false, "Other", "LeonidaScriven@aol.com");

		janeProp1Unit9Tenant.getEmailAddresses().add(janeProp1Unit9TenantHomeEmail);
		janeProp1Unit9Tenant.getEmailAddresses().add(janeProp1Unit9TenantWorkEmail);
		janeProp1Unit9Tenant.getEmailAddresses().add(janeProp1Unit9TenantOtherEmail);

		Tenant janeProp1Unit9Tenant2 = new Tenant ( janeProp1Unit9, "Fannie", "Nana" , "Paskin" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		janeProp1Unit9Tenant2.setUserId("Fannie.Paskin@gmail.com");
		janeProp1Unit9Tenant2.setPassword("Nana");
		janeProp1Unit9Tenant2.setPassword(DbFunctions.hashPassword("Nana", janeProp1Unit9Tenant2.getSalt() ));

		PhoneNumber janeProp1Unit9Tenant2CellPhone =new PhoneNumber( true , "Cell" , "650-473-1262");
		PhoneNumber janeProp1Unit9Tenant2WorkPhone =new PhoneNumber( false , "Work" , "303-997-7760");
		PhoneNumber janeProp1Unit9Tenant2HomePhone =new PhoneNumber( false , "Home" , "415-926-6089");

		janeProp1Unit9Tenant2.getPhoneNumbers().add(janeProp1Unit9Tenant2CellPhone);
		janeProp1Unit9Tenant2.getPhoneNumbers().add(janeProp1Unit9Tenant2WorkPhone);
		janeProp1Unit9Tenant2.getPhoneNumbers().add(janeProp1Unit9Tenant2HomePhone);

		EmailAddress janeProp1Unit9Tenant2HomeEmail= new EmailAddress(true, "Home", "FanniePaskin@gmail.com");
		EmailAddress janeProp1Unit9Tenant2WorkEmail= new EmailAddress(false, "Work", "FanniePaskin@work.com");
		EmailAddress janeProp1Unit9Tenant2OtherEmail= new EmailAddress(false, "Other", "FanniePaskin@aol.com");

		janeProp1Unit9Tenant2.getEmailAddresses().add(janeProp1Unit9Tenant2HomeEmail);
		janeProp1Unit9Tenant2.getEmailAddresses().add(janeProp1Unit9Tenant2WorkEmail);
		janeProp1Unit9Tenant2.getEmailAddresses().add(janeProp1Unit9Tenant2OtherEmail);

		DbFunctions.insert(janeProp1Unit9Tenant);
		DbFunctions.insert(janeProp1Unit9Tenant2);

		Set<Tenant> janeProp1Unit9Tenanats = new HashSet<>();
		janeProp1Unit9Tenanats.add(janeProp1Unit9Tenant);
		janeProp1Unit9Tenanats.add(janeProp1Unit9Tenant2);
		janeProp1Unit9.setTenants(janeProp1Unit9Tenanats);
		DbFunctions.update(janeProp1Unit9);




		Tenant janeProp1Unit10Tenant = new Tenant ( janeProp1Unit10, "Loreta", "Fatima" , "Scipione" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		janeProp1Unit10Tenant.setUserId("Loreta.Scipione@gmail.com");
		janeProp1Unit10Tenant.setPassword(DbFunctions.hashPassword("Fatima", janeProp1Unit10Tenant.getSalt() ));

		PhoneNumber janeProp1Unit10TenantCellPhone =new PhoneNumber( true , "Cell" , "623-461-8551");
		PhoneNumber janeProp1Unit10TenantWorkPhone =new PhoneNumber( false , "Work" , "419-573-2033");
		PhoneNumber janeProp1Unit10TenantHomePhone =new PhoneNumber( false , "Home" , "773-297-9391");

		janeProp1Unit10Tenant.getPhoneNumbers().add(janeProp1Unit10TenantCellPhone);
		janeProp1Unit10Tenant.getPhoneNumbers().add(janeProp1Unit10TenantWorkPhone);
		janeProp1Unit10Tenant.getPhoneNumbers().add(janeProp1Unit10TenantHomePhone);

		EmailAddress janeProp1Unit10TenantHomeEmail= new EmailAddress(true, "Home", "LoretaScipione@gmail.com");
		EmailAddress janeProp1Unit10TenantWorkEmail= new EmailAddress(false, "Work", "LoretaScipione@work.com");
		EmailAddress janeProp1Unit10TenantOtherEmail= new EmailAddress(false, "Other", "LoretaScipione@aol.com");

		janeProp1Unit10Tenant.getEmailAddresses().add(janeProp1Unit10TenantHomeEmail);
		janeProp1Unit10Tenant.getEmailAddresses().add(janeProp1Unit10TenantWorkEmail);
		janeProp1Unit10Tenant.getEmailAddresses().add(janeProp1Unit10TenantOtherEmail);

		Tenant janeProp1Unit10Tenant2 = new Tenant ( janeProp1Unit10, "Blondell", "Alpha" , "Coyier" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		janeProp1Unit10Tenant2.setUserId("Blondell.Coyier@gmail.com");
		janeProp1Unit10Tenant2.setPassword("Alpha");
		janeProp1Unit10Tenant2.setPassword(DbFunctions.hashPassword("Alpha", janeProp1Unit10Tenant2.getSalt() ));

		PhoneNumber janeProp1Unit10Tenant2CellPhone =new PhoneNumber( true , "Cell" , "516-948-5768");
		PhoneNumber janeProp1Unit10Tenant2WorkPhone =new PhoneNumber( false , "Work" , "510-452-4835");
		PhoneNumber janeProp1Unit10Tenant2HomePhone =new PhoneNumber( false , "Home" , "904-627-4341");

		janeProp1Unit10Tenant2.getPhoneNumbers().add(janeProp1Unit10Tenant2CellPhone);
		janeProp1Unit10Tenant2.getPhoneNumbers().add(janeProp1Unit10Tenant2WorkPhone);
		janeProp1Unit10Tenant2.getPhoneNumbers().add(janeProp1Unit10Tenant2HomePhone);

		EmailAddress janeProp1Unit10Tenant2HomeEmail= new EmailAddress(true, "Home", "BlondellCoyier@gmail.com");
		EmailAddress janeProp1Unit10Tenant2WorkEmail= new EmailAddress(false, "Work", "BlondellCoyier@work.com");
		EmailAddress janeProp1Unit10Tenant2OtherEmail= new EmailAddress(false, "Other", "BlondellCoyier@aol.com");

		janeProp1Unit10Tenant2.getEmailAddresses().add(janeProp1Unit10Tenant2HomeEmail);
		janeProp1Unit10Tenant2.getEmailAddresses().add(janeProp1Unit10Tenant2WorkEmail);
		janeProp1Unit10Tenant2.getEmailAddresses().add(janeProp1Unit10Tenant2OtherEmail);

		DbFunctions.insert(janeProp1Unit10Tenant);
		DbFunctions.insert(janeProp1Unit10Tenant2);

		Set<Tenant> janeProp1Unit10Tenanats = new HashSet<>();
		janeProp1Unit10Tenanats.add(janeProp1Unit10Tenant);
		janeProp1Unit10Tenanats.add(janeProp1Unit10Tenant2);
		janeProp1Unit10.setTenants(janeProp1Unit10Tenanats);
		DbFunctions.update(janeProp1Unit10);




		Tenant janeProp1Unit11Tenant = new Tenant ( janeProp1Unit11, "Pamella", "Jerry" , "Schemmer" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		janeProp1Unit11Tenant.setUserId("Pamella.Schemmer@gmail.com");
		janeProp1Unit11Tenant.setPassword(DbFunctions.hashPassword("Jerry", janeProp1Unit11Tenant.getSalt() ));

		PhoneNumber janeProp1Unit11TenantCellPhone =new PhoneNumber( true , "Cell" , "913-413-4604");
		PhoneNumber janeProp1Unit11TenantWorkPhone =new PhoneNumber( false , "Work" , "973-868-8660");
		PhoneNumber janeProp1Unit11TenantHomePhone =new PhoneNumber( false , "Home" , "201-995-3149");

		janeProp1Unit11Tenant.getPhoneNumbers().add(janeProp1Unit11TenantCellPhone);
		janeProp1Unit11Tenant.getPhoneNumbers().add(janeProp1Unit11TenantWorkPhone);
		janeProp1Unit11Tenant.getPhoneNumbers().add(janeProp1Unit11TenantHomePhone);

		EmailAddress janeProp1Unit11TenantHomeEmail= new EmailAddress(true, "Home", "PamellaSchemmer@gmail.com");
		EmailAddress janeProp1Unit11TenantWorkEmail= new EmailAddress(false, "Work", "PamellaSchemmer@work.com");
		EmailAddress janeProp1Unit11TenantOtherEmail= new EmailAddress(false, "Other", "PamellaSchemmer@aol.com");

		janeProp1Unit11Tenant.getEmailAddresses().add(janeProp1Unit11TenantHomeEmail);
		janeProp1Unit11Tenant.getEmailAddresses().add(janeProp1Unit11TenantWorkEmail);
		janeProp1Unit11Tenant.getEmailAddresses().add(janeProp1Unit11TenantOtherEmail);

		Tenant janeProp1Unit11Tenant2 = new Tenant ( janeProp1Unit11, "Dick", "Rosio" , "Schirpke" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		janeProp1Unit11Tenant2.setUserId("Dick.Schirpke@gmail.com");
		janeProp1Unit11Tenant2.setPassword("Rosio");
		janeProp1Unit11Tenant2.setPassword(DbFunctions.hashPassword("Rosio", janeProp1Unit11Tenant2.getSalt() ));

		PhoneNumber janeProp1Unit11Tenant2CellPhone =new PhoneNumber( true , "Cell" , "313-288-7937");
		PhoneNumber janeProp1Unit11Tenant2WorkPhone =new PhoneNumber( false , "Work" , "601-637-5479");
		PhoneNumber janeProp1Unit11Tenant2HomePhone =new PhoneNumber( false , "Home" , "207-233-6185");

		janeProp1Unit11Tenant2.getPhoneNumbers().add(janeProp1Unit11Tenant2CellPhone);
		janeProp1Unit11Tenant2.getPhoneNumbers().add(janeProp1Unit11Tenant2WorkPhone);
		janeProp1Unit11Tenant2.getPhoneNumbers().add(janeProp1Unit11Tenant2HomePhone);

		EmailAddress janeProp1Unit11Tenant2HomeEmail= new EmailAddress(true, "Home", "DickSchirpke@gmail.com");
		EmailAddress janeProp1Unit11Tenant2WorkEmail= new EmailAddress(false, "Work", "DickSchirpke@work.com");
		EmailAddress janeProp1Unit11Tenant2OtherEmail= new EmailAddress(false, "Other", "DickSchirpke@aol.com");

		janeProp1Unit11Tenant2.getEmailAddresses().add(janeProp1Unit11Tenant2HomeEmail);
		janeProp1Unit11Tenant2.getEmailAddresses().add(janeProp1Unit11Tenant2WorkEmail);
		janeProp1Unit11Tenant2.getEmailAddresses().add(janeProp1Unit11Tenant2OtherEmail);

		DbFunctions.insert(janeProp1Unit11Tenant);
		DbFunctions.insert(janeProp1Unit11Tenant2);

		Set<Tenant> janeProp1Unit11Tenanats = new HashSet<>();
		janeProp1Unit11Tenanats.add(janeProp1Unit11Tenant);
		janeProp1Unit11Tenanats.add(janeProp1Unit11Tenant2);
		janeProp1Unit11.setTenants(janeProp1Unit11Tenanats);
		DbFunctions.update(janeProp1Unit11);




		Tenant janeProp1Unit12Tenant = new Tenant ( janeProp1Unit12, "Felicidad", "Casie" , "Vonasek" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		janeProp1Unit12Tenant.setUserId("Felicidad.Vonasek@gmail.com");
		janeProp1Unit12Tenant.setPassword(DbFunctions.hashPassword("Casie", janeProp1Unit12Tenant.getSalt() ));

		PhoneNumber janeProp1Unit12TenantCellPhone =new PhoneNumber( true , "Cell" , "209-317-1801");
		PhoneNumber janeProp1Unit12TenantWorkPhone =new PhoneNumber( false , "Work" , "914-396-2615");
		PhoneNumber janeProp1Unit12TenantHomePhone =new PhoneNumber( false , "Home" , "321-632-4668");

		janeProp1Unit12Tenant.getPhoneNumbers().add(janeProp1Unit12TenantCellPhone);
		janeProp1Unit12Tenant.getPhoneNumbers().add(janeProp1Unit12TenantWorkPhone);
		janeProp1Unit12Tenant.getPhoneNumbers().add(janeProp1Unit12TenantHomePhone);

		EmailAddress janeProp1Unit12TenantHomeEmail= new EmailAddress(true, "Home", "FelicidadVonasek@gmail.com");
		EmailAddress janeProp1Unit12TenantWorkEmail= new EmailAddress(false, "Work", "FelicidadVonasek@work.com");
		EmailAddress janeProp1Unit12TenantOtherEmail= new EmailAddress(false, "Other", "FelicidadVonasek@aol.com");

		janeProp1Unit12Tenant.getEmailAddresses().add(janeProp1Unit12TenantHomeEmail);
		janeProp1Unit12Tenant.getEmailAddresses().add(janeProp1Unit12TenantWorkEmail);
		janeProp1Unit12Tenant.getEmailAddresses().add(janeProp1Unit12TenantOtherEmail);

		Tenant janeProp1Unit12Tenant2 = new Tenant ( janeProp1Unit12, "Alline", "Jenelle" , "Wolfgramm" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		janeProp1Unit12Tenant2.setUserId("Alline.Wolfgramm@gmail.com");
		janeProp1Unit12Tenant2.setPassword("Jenelle");
		janeProp1Unit12Tenant2.setPassword(DbFunctions.hashPassword("Jenelle", janeProp1Unit12Tenant2.getSalt() ));

		PhoneNumber janeProp1Unit12Tenant2CellPhone =new PhoneNumber( true , "Cell" , "706-221-4243");
		PhoneNumber janeProp1Unit12Tenant2WorkPhone =new PhoneNumber( false , "Work" , "401-885-7681");
		PhoneNumber janeProp1Unit12Tenant2HomePhone =new PhoneNumber( false , "Home" , "949-903-3898");

		janeProp1Unit12Tenant2.getPhoneNumbers().add(janeProp1Unit12Tenant2CellPhone);
		janeProp1Unit12Tenant2.getPhoneNumbers().add(janeProp1Unit12Tenant2WorkPhone);
		janeProp1Unit12Tenant2.getPhoneNumbers().add(janeProp1Unit12Tenant2HomePhone);

		EmailAddress janeProp1Unit12Tenant2HomeEmail= new EmailAddress(true, "Home", "AllineWolfgramm@gmail.com");
		EmailAddress janeProp1Unit12Tenant2WorkEmail= new EmailAddress(false, "Work", "AllineWolfgramm@work.com");
		EmailAddress janeProp1Unit12Tenant2OtherEmail= new EmailAddress(false, "Other", "AllineWolfgramm@aol.com");

		janeProp1Unit12Tenant2.getEmailAddresses().add(janeProp1Unit12Tenant2HomeEmail);
		janeProp1Unit12Tenant2.getEmailAddresses().add(janeProp1Unit12Tenant2WorkEmail);
		janeProp1Unit12Tenant2.getEmailAddresses().add(janeProp1Unit12Tenant2OtherEmail);

		DbFunctions.insert(janeProp1Unit12Tenant);
		DbFunctions.insert(janeProp1Unit12Tenant2);

		Set<Tenant> janeProp1Unit12Tenanats = new HashSet<>();
		janeProp1Unit12Tenanats.add(janeProp1Unit12Tenant);
		janeProp1Unit12Tenanats.add(janeProp1Unit12Tenant2);
		janeProp1Unit12.setTenants(janeProp1Unit12Tenanats);
		DbFunctions.update(janeProp1Unit12);




		Tenant janeProp1Unit14Tenant = new Tenant ( janeProp1Unit14, "Pete", "Paris" , "Liukko" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		janeProp1Unit14Tenant.setUserId("Pete.Liukko@gmail.com");
		janeProp1Unit14Tenant.setPassword(DbFunctions.hashPassword("Paris", janeProp1Unit14Tenant.getSalt() ));

		PhoneNumber janeProp1Unit14TenantCellPhone =new PhoneNumber( true , "Cell" , "916-591-3277");
		PhoneNumber janeProp1Unit14TenantWorkPhone =new PhoneNumber( false , "Work" , "610-379-7125");
		PhoneNumber janeProp1Unit14TenantHomePhone =new PhoneNumber( false , "Home" , "406-374-7752");

		janeProp1Unit14Tenant.getPhoneNumbers().add(janeProp1Unit14TenantCellPhone);
		janeProp1Unit14Tenant.getPhoneNumbers().add(janeProp1Unit14TenantWorkPhone);
		janeProp1Unit14Tenant.getPhoneNumbers().add(janeProp1Unit14TenantHomePhone);

		EmailAddress janeProp1Unit14TenantHomeEmail= new EmailAddress(true, "Home", "PeteLiukko@gmail.com");
		EmailAddress janeProp1Unit14TenantWorkEmail= new EmailAddress(false, "Work", "PeteLiukko@work.com");
		EmailAddress janeProp1Unit14TenantOtherEmail= new EmailAddress(false, "Other", "PeteLiukko@aol.com");

		janeProp1Unit14Tenant.getEmailAddresses().add(janeProp1Unit14TenantHomeEmail);
		janeProp1Unit14Tenant.getEmailAddresses().add(janeProp1Unit14TenantWorkEmail);
		janeProp1Unit14Tenant.getEmailAddresses().add(janeProp1Unit14TenantOtherEmail);

		Tenant janeProp1Unit14Tenant2 = new Tenant ( janeProp1Unit14, "Ciara", "An" , "Cookey" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		janeProp1Unit14Tenant2.setUserId("Ciara.Cookey@gmail.com");
		janeProp1Unit14Tenant2.setPassword("An");
		janeProp1Unit14Tenant2.setPassword(DbFunctions.hashPassword("An", janeProp1Unit14Tenant2.getSalt() ));

		PhoneNumber janeProp1Unit14Tenant2CellPhone =new PhoneNumber( true , "Cell" , "216-657-7668");
		PhoneNumber janeProp1Unit14Tenant2WorkPhone =new PhoneNumber( false , "Work" , "931-303-6041");
		PhoneNumber janeProp1Unit14Tenant2HomePhone =new PhoneNumber( false , "Home" , "308-250-6987");

		janeProp1Unit14Tenant2.getPhoneNumbers().add(janeProp1Unit14Tenant2CellPhone);
		janeProp1Unit14Tenant2.getPhoneNumbers().add(janeProp1Unit14Tenant2WorkPhone);
		janeProp1Unit14Tenant2.getPhoneNumbers().add(janeProp1Unit14Tenant2HomePhone);

		EmailAddress janeProp1Unit14Tenant2HomeEmail= new EmailAddress(true, "Home", "CiaraCookey@gmail.com");
		EmailAddress janeProp1Unit14Tenant2WorkEmail= new EmailAddress(false, "Work", "CiaraCookey@work.com");
		EmailAddress janeProp1Unit14Tenant2OtherEmail= new EmailAddress(false, "Other", "CiaraCookey@aol.com");

		janeProp1Unit14Tenant2.getEmailAddresses().add(janeProp1Unit14Tenant2HomeEmail);
		janeProp1Unit14Tenant2.getEmailAddresses().add(janeProp1Unit14Tenant2WorkEmail);
		janeProp1Unit14Tenant2.getEmailAddresses().add(janeProp1Unit14Tenant2OtherEmail);

		DbFunctions.insert(janeProp1Unit14Tenant);
		DbFunctions.insert(janeProp1Unit14Tenant2);

		Set<Tenant> janeProp1Unit14Tenanats = new HashSet<>();
		janeProp1Unit14Tenanats.add(janeProp1Unit14Tenant);
		janeProp1Unit14Tenanats.add(janeProp1Unit14Tenant2);
		janeProp1Unit14.setTenants(janeProp1Unit14Tenanats);
		DbFunctions.update(janeProp1Unit14);




		Tenant janeProp1Unit15Tenant = new Tenant ( janeProp1Unit15, "Marguerita", "Stevie" , "Bourbon" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		janeProp1Unit15Tenant.setUserId("Marguerita.Bourbon@gmail.com");
		janeProp1Unit15Tenant.setPassword(DbFunctions.hashPassword("Stevie", janeProp1Unit15Tenant.getSalt() ));

		PhoneNumber janeProp1Unit15TenantCellPhone =new PhoneNumber( true , "Cell" , "610-545-3615");
		PhoneNumber janeProp1Unit15TenantWorkPhone =new PhoneNumber( false , "Work" , "650-216-5075");
		PhoneNumber janeProp1Unit15TenantHomePhone =new PhoneNumber( false , "Home" , "864-594-4578");

		janeProp1Unit15Tenant.getPhoneNumbers().add(janeProp1Unit15TenantCellPhone);
		janeProp1Unit15Tenant.getPhoneNumbers().add(janeProp1Unit15TenantWorkPhone);
		janeProp1Unit15Tenant.getPhoneNumbers().add(janeProp1Unit15TenantHomePhone);

		EmailAddress janeProp1Unit15TenantHomeEmail= new EmailAddress(true, "Home", "MargueritaBourbon@gmail.com");
		EmailAddress janeProp1Unit15TenantWorkEmail= new EmailAddress(false, "Work", "MargueritaBourbon@work.com");
		EmailAddress janeProp1Unit15TenantOtherEmail= new EmailAddress(false, "Other", "MargueritaBourbon@aol.com");

		janeProp1Unit15Tenant.getEmailAddresses().add(janeProp1Unit15TenantHomeEmail);
		janeProp1Unit15Tenant.getEmailAddresses().add(janeProp1Unit15TenantWorkEmail);
		janeProp1Unit15Tenant.getEmailAddresses().add(janeProp1Unit15TenantOtherEmail);

		Tenant janeProp1Unit15Tenant2 = new Tenant ( janeProp1Unit15, "Dalene", "Elly" , "Paulas" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		janeProp1Unit15Tenant2.setUserId("Dalene.Paulas@gmail.com");
		janeProp1Unit15Tenant2.setPassword("Elly");
		janeProp1Unit15Tenant2.setPassword(DbFunctions.hashPassword("Elly", janeProp1Unit15Tenant2.getSalt() ));

		PhoneNumber janeProp1Unit15Tenant2CellPhone =new PhoneNumber( true , "Cell" , "216-923-3715");
		PhoneNumber janeProp1Unit15Tenant2WorkPhone =new PhoneNumber( false , "Work" , "386-599-7296");
		PhoneNumber janeProp1Unit15Tenant2HomePhone =new PhoneNumber( false , "Home" , "801-892-8781");

		janeProp1Unit15Tenant2.getPhoneNumbers().add(janeProp1Unit15Tenant2CellPhone);
		janeProp1Unit15Tenant2.getPhoneNumbers().add(janeProp1Unit15Tenant2WorkPhone);
		janeProp1Unit15Tenant2.getPhoneNumbers().add(janeProp1Unit15Tenant2HomePhone);

		EmailAddress janeProp1Unit15Tenant2HomeEmail= new EmailAddress(true, "Home", "DalenePaulas@gmail.com");
		EmailAddress janeProp1Unit15Tenant2WorkEmail= new EmailAddress(false, "Work", "DalenePaulas@work.com");
		EmailAddress janeProp1Unit15Tenant2OtherEmail= new EmailAddress(false, "Other", "DalenePaulas@aol.com");

		janeProp1Unit15Tenant2.getEmailAddresses().add(janeProp1Unit15Tenant2HomeEmail);
		janeProp1Unit15Tenant2.getEmailAddresses().add(janeProp1Unit15Tenant2WorkEmail);
		janeProp1Unit15Tenant2.getEmailAddresses().add(janeProp1Unit15Tenant2OtherEmail);

		DbFunctions.insert(janeProp1Unit15Tenant);
		DbFunctions.insert(janeProp1Unit15Tenant2);

		Set<Tenant> janeProp1Unit15Tenanats = new HashSet<>();
		janeProp1Unit15Tenanats.add(janeProp1Unit15Tenant);
		janeProp1Unit15Tenanats.add(janeProp1Unit15Tenant2);
		janeProp1Unit15.setTenants(janeProp1Unit15Tenanats);
		DbFunctions.update(janeProp1Unit15);




		Tenant robertProp1Unit1Tenant = new Tenant ( robertProp1Unit1, "Lettie", "Shalon" , "Onofrio" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		robertProp1Unit1Tenant.setUserId("Lettie.Onofrio@gmail.com");
		robertProp1Unit1Tenant.setPassword(DbFunctions.hashPassword("Shalon", robertProp1Unit1Tenant.getSalt() ));

		PhoneNumber robertProp1Unit1TenantCellPhone =new PhoneNumber( true , "Cell" , "215-211-9589");
		PhoneNumber robertProp1Unit1TenantWorkPhone =new PhoneNumber( false , "Work" , "856-702-3676");
		PhoneNumber robertProp1Unit1TenantHomePhone =new PhoneNumber( false , "Home" , "336-364-6037");

		robertProp1Unit1Tenant.getPhoneNumbers().add(robertProp1Unit1TenantCellPhone);
		robertProp1Unit1Tenant.getPhoneNumbers().add(robertProp1Unit1TenantWorkPhone);
		robertProp1Unit1Tenant.getPhoneNumbers().add(robertProp1Unit1TenantHomePhone);

		EmailAddress robertProp1Unit1TenantHomeEmail= new EmailAddress(true, "Home", "LettieOnofrio@gmail.com");
		EmailAddress robertProp1Unit1TenantWorkEmail= new EmailAddress(false, "Work", "LettieOnofrio@work.com");
		EmailAddress robertProp1Unit1TenantOtherEmail= new EmailAddress(false, "Other", "LettieOnofrio@aol.com");

		robertProp1Unit1Tenant.getEmailAddresses().add(robertProp1Unit1TenantHomeEmail);
		robertProp1Unit1Tenant.getEmailAddresses().add(robertProp1Unit1TenantWorkEmail);
		robertProp1Unit1Tenant.getEmailAddresses().add(robertProp1Unit1TenantOtherEmail);

		Tenant robertProp1Unit1Tenant2 = new Tenant ( robertProp1Unit1, "Jutta", "Jovita" , "Hiatt" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		robertProp1Unit1Tenant2.setUserId("Jutta.Hiatt@gmail.com");
		robertProp1Unit1Tenant2.setPassword("Jovita");
		robertProp1Unit1Tenant2.setPassword(DbFunctions.hashPassword("Jovita", robertProp1Unit1Tenant2.getSalt() ));

		PhoneNumber robertProp1Unit1Tenant2CellPhone =new PhoneNumber( true , "Cell" , "330-903-1345");
		PhoneNumber robertProp1Unit1Tenant2WorkPhone =new PhoneNumber( false , "Work" , "305-302-1135");
		PhoneNumber robertProp1Unit1Tenant2HomePhone =new PhoneNumber( false , "Home" , "972-742-4000");

		robertProp1Unit1Tenant2.getPhoneNumbers().add(robertProp1Unit1Tenant2CellPhone);
		robertProp1Unit1Tenant2.getPhoneNumbers().add(robertProp1Unit1Tenant2WorkPhone);
		robertProp1Unit1Tenant2.getPhoneNumbers().add(robertProp1Unit1Tenant2HomePhone);

		EmailAddress robertProp1Unit1Tenant2HomeEmail= new EmailAddress(true, "Home", "JuttaHiatt@gmail.com");
		EmailAddress robertProp1Unit1Tenant2WorkEmail= new EmailAddress(false, "Work", "JuttaHiatt@work.com");
		EmailAddress robertProp1Unit1Tenant2OtherEmail= new EmailAddress(false, "Other", "JuttaHiatt@aol.com");

		robertProp1Unit1Tenant2.getEmailAddresses().add(robertProp1Unit1Tenant2HomeEmail);
		robertProp1Unit1Tenant2.getEmailAddresses().add(robertProp1Unit1Tenant2WorkEmail);
		robertProp1Unit1Tenant2.getEmailAddresses().add(robertProp1Unit1Tenant2OtherEmail);

		DbFunctions.insert(robertProp1Unit1Tenant);
		DbFunctions.insert(robertProp1Unit1Tenant2);

		Set<Tenant> robertProp1Unit1Tenanats = new HashSet<>();
		robertProp1Unit1Tenanats.add(robertProp1Unit1Tenant);
		robertProp1Unit1Tenanats.add(robertProp1Unit1Tenant2);
		robertProp1Unit1.setTenants(robertProp1Unit1Tenanats);
		DbFunctions.update(robertProp1Unit1);




		Tenant robertProp1Unit2Tenant = new Tenant ( robertProp1Unit2, "Linn", "Barbra" , "Rhymes" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		robertProp1Unit2Tenant.setUserId("Linn.Rhymes@gmail.com");
		robertProp1Unit2Tenant.setPassword(DbFunctions.hashPassword("Barbra", robertProp1Unit2Tenant.getSalt() ));

		PhoneNumber robertProp1Unit2TenantCellPhone =new PhoneNumber( true , "Cell" , "718-332-6527");
		PhoneNumber robertProp1Unit2TenantWorkPhone =new PhoneNumber( false , "Work" , "336-467-3095");
		PhoneNumber robertProp1Unit2TenantHomePhone =new PhoneNumber( false , "Home" , "740-526-5410");

		robertProp1Unit2Tenant.getPhoneNumbers().add(robertProp1Unit2TenantCellPhone);
		robertProp1Unit2Tenant.getPhoneNumbers().add(robertProp1Unit2TenantWorkPhone);
		robertProp1Unit2Tenant.getPhoneNumbers().add(robertProp1Unit2TenantHomePhone);

		EmailAddress robertProp1Unit2TenantHomeEmail= new EmailAddress(true, "Home", "LinnRhymes@gmail.com");
		EmailAddress robertProp1Unit2TenantWorkEmail= new EmailAddress(false, "Work", "LinnRhymes@work.com");
		EmailAddress robertProp1Unit2TenantOtherEmail= new EmailAddress(false, "Other", "LinnRhymes@aol.com");

		robertProp1Unit2Tenant.getEmailAddresses().add(robertProp1Unit2TenantHomeEmail);
		robertProp1Unit2Tenant.getEmailAddresses().add(robertProp1Unit2TenantWorkEmail);
		robertProp1Unit2Tenant.getEmailAddresses().add(robertProp1Unit2TenantOtherEmail);

		Tenant robertProp1Unit2Tenant2 = new Tenant ( robertProp1Unit2, "Gilma", "Keneth" , "Boord" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		robertProp1Unit2Tenant2.setUserId("Gilma.Boord@gmail.com");
		robertProp1Unit2Tenant2.setPassword("Keneth");
		robertProp1Unit2Tenant2.setPassword(DbFunctions.hashPassword("Keneth", robertProp1Unit2Tenant2.getSalt() ));

		PhoneNumber robertProp1Unit2Tenant2CellPhone =new PhoneNumber( true , "Cell" , "716-752-4114");
		PhoneNumber robertProp1Unit2Tenant2WorkPhone =new PhoneNumber( false , "Work" , "901-573-9024");
		PhoneNumber robertProp1Unit2Tenant2HomePhone =new PhoneNumber( false , "Home" , "908-470-4661");

		robertProp1Unit2Tenant2.getPhoneNumbers().add(robertProp1Unit2Tenant2CellPhone);
		robertProp1Unit2Tenant2.getPhoneNumbers().add(robertProp1Unit2Tenant2WorkPhone);
		robertProp1Unit2Tenant2.getPhoneNumbers().add(robertProp1Unit2Tenant2HomePhone);

		EmailAddress robertProp1Unit2Tenant2HomeEmail= new EmailAddress(true, "Home", "GilmaBoord@gmail.com");
		EmailAddress robertProp1Unit2Tenant2WorkEmail= new EmailAddress(false, "Work", "GilmaBoord@work.com");
		EmailAddress robertProp1Unit2Tenant2OtherEmail= new EmailAddress(false, "Other", "GilmaBoord@aol.com");

		robertProp1Unit2Tenant2.getEmailAddresses().add(robertProp1Unit2Tenant2HomeEmail);
		robertProp1Unit2Tenant2.getEmailAddresses().add(robertProp1Unit2Tenant2WorkEmail);
		robertProp1Unit2Tenant2.getEmailAddresses().add(robertProp1Unit2Tenant2OtherEmail);

		DbFunctions.insert(robertProp1Unit2Tenant);
		DbFunctions.insert(robertProp1Unit2Tenant2);

		Set<Tenant> robertProp1Unit2Tenanats = new HashSet<>();
		robertProp1Unit2Tenanats.add(robertProp1Unit2Tenant);
		robertProp1Unit2Tenanats.add(robertProp1Unit2Tenant2);
		robertProp1Unit2.setTenants(robertProp1Unit2Tenanats);
		DbFunctions.update(robertProp1Unit2);




		Tenant robertProp2Unit1Tenant = new Tenant ( robertProp2Unit1, "Zona", "Annmarie" , "Wardrip" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		robertProp2Unit1Tenant.setUserId("Zona.Wardrip@gmail.com");
		robertProp2Unit1Tenant.setPassword(DbFunctions.hashPassword("Annmarie", robertProp2Unit1Tenant.getSalt() ));

		PhoneNumber robertProp2Unit1TenantCellPhone =new PhoneNumber( true , "Cell" , "215-491-5633");
		PhoneNumber robertProp2Unit1TenantWorkPhone =new PhoneNumber( false , "Work" , "570-469-8401");
		PhoneNumber robertProp2Unit1TenantHomePhone =new PhoneNumber( false , "Home" , "703-938-7939");

		robertProp2Unit1Tenant.getPhoneNumbers().add(robertProp2Unit1TenantCellPhone);
		robertProp2Unit1Tenant.getPhoneNumbers().add(robertProp2Unit1TenantWorkPhone);
		robertProp2Unit1Tenant.getPhoneNumbers().add(robertProp2Unit1TenantHomePhone);

		EmailAddress robertProp2Unit1TenantHomeEmail= new EmailAddress(true, "Home", "ZonaWardrip@gmail.com");
		EmailAddress robertProp2Unit1TenantWorkEmail= new EmailAddress(false, "Work", "ZonaWardrip@work.com");
		EmailAddress robertProp2Unit1TenantOtherEmail= new EmailAddress(false, "Other", "ZonaWardrip@aol.com");

		robertProp2Unit1Tenant.getEmailAddresses().add(robertProp2Unit1TenantHomeEmail);
		robertProp2Unit1Tenant.getEmailAddresses().add(robertProp2Unit1TenantWorkEmail);
		robertProp2Unit1Tenant.getEmailAddresses().add(robertProp2Unit1TenantOtherEmail);

		Tenant robertProp2Unit1Tenant2 = new Tenant ( robertProp2Unit1, "Alline", "Gracia" , "Campain" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		robertProp2Unit1Tenant2.setUserId("Alline.Campain@gmail.com");
		robertProp2Unit1Tenant2.setPassword("Gracia");
		robertProp2Unit1Tenant2.setPassword(DbFunctions.hashPassword("Gracia", robertProp2Unit1Tenant2.getSalt() ));

		PhoneNumber robertProp2Unit1Tenant2CellPhone =new PhoneNumber( true , "Cell" , "301-696-6420");
		PhoneNumber robertProp2Unit1Tenant2WorkPhone =new PhoneNumber( false , "Work" , "920-355-1610");
		PhoneNumber robertProp2Unit1Tenant2HomePhone =new PhoneNumber( false , "Home" , "847-755-9041");

		robertProp2Unit1Tenant2.getPhoneNumbers().add(robertProp2Unit1Tenant2CellPhone);
		robertProp2Unit1Tenant2.getPhoneNumbers().add(robertProp2Unit1Tenant2WorkPhone);
		robertProp2Unit1Tenant2.getPhoneNumbers().add(robertProp2Unit1Tenant2HomePhone);

		EmailAddress robertProp2Unit1Tenant2HomeEmail= new EmailAddress(true, "Home", "AllineCampain@gmail.com");
		EmailAddress robertProp2Unit1Tenant2WorkEmail= new EmailAddress(false, "Work", "AllineCampain@work.com");
		EmailAddress robertProp2Unit1Tenant2OtherEmail= new EmailAddress(false, "Other", "AllineCampain@aol.com");

		robertProp2Unit1Tenant2.getEmailAddresses().add(robertProp2Unit1Tenant2HomeEmail);
		robertProp2Unit1Tenant2.getEmailAddresses().add(robertProp2Unit1Tenant2WorkEmail);
		robertProp2Unit1Tenant2.getEmailAddresses().add(robertProp2Unit1Tenant2OtherEmail);

		DbFunctions.insert(robertProp2Unit1Tenant);
		DbFunctions.insert(robertProp2Unit1Tenant2);

		Set<Tenant> robertProp2Unit1Tenanats = new HashSet<>();
		robertProp2Unit1Tenanats.add(robertProp2Unit1Tenant);
		robertProp2Unit1Tenanats.add(robertProp2Unit1Tenant2);
		robertProp2Unit1.setTenants(robertProp2Unit1Tenanats);
		DbFunctions.update(robertProp2Unit1);




		Tenant robertProp2Unit2Tenant = new Tenant ( robertProp2Unit2, "Lai", "Lauran" , "Ketelsen" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		robertProp2Unit2Tenant.setUserId("Lai.Ketelsen@gmail.com");
		robertProp2Unit2Tenant.setPassword(DbFunctions.hashPassword("Lauran", robertProp2Unit2Tenant.getSalt() ));

		PhoneNumber robertProp2Unit2TenantCellPhone =new PhoneNumber( true , "Cell" , "740-343-8575");
		PhoneNumber robertProp2Unit2TenantWorkPhone =new PhoneNumber( false , "Work" , "907-873-2882");
		PhoneNumber robertProp2Unit2TenantHomePhone =new PhoneNumber( false , "Home" , "201-969-7063");

		robertProp2Unit2Tenant.getPhoneNumbers().add(robertProp2Unit2TenantCellPhone);
		robertProp2Unit2Tenant.getPhoneNumbers().add(robertProp2Unit2TenantWorkPhone);
		robertProp2Unit2Tenant.getPhoneNumbers().add(robertProp2Unit2TenantHomePhone);

		EmailAddress robertProp2Unit2TenantHomeEmail= new EmailAddress(true, "Home", "LaiKetelsen@gmail.com");
		EmailAddress robertProp2Unit2TenantWorkEmail= new EmailAddress(false, "Work", "LaiKetelsen@work.com");
		EmailAddress robertProp2Unit2TenantOtherEmail= new EmailAddress(false, "Other", "LaiKetelsen@aol.com");

		robertProp2Unit2Tenant.getEmailAddresses().add(robertProp2Unit2TenantHomeEmail);
		robertProp2Unit2Tenant.getEmailAddresses().add(robertProp2Unit2TenantWorkEmail);
		robertProp2Unit2Tenant.getEmailAddresses().add(robertProp2Unit2TenantOtherEmail);

		Tenant robertProp2Unit2Tenant2 = new Tenant ( robertProp2Unit2, "Leatha", "Cecily" , "Albares" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		robertProp2Unit2Tenant2.setUserId("Leatha.Albares@gmail.com");
		robertProp2Unit2Tenant2.setPassword("Cecily");
		robertProp2Unit2Tenant2.setPassword(DbFunctions.hashPassword("Cecily", robertProp2Unit2Tenant2.getSalt() ));

		PhoneNumber robertProp2Unit2Tenant2CellPhone =new PhoneNumber( true , "Cell" , "210-856-4979");
		PhoneNumber robertProp2Unit2Tenant2WorkPhone =new PhoneNumber( false , "Work" , "215-417-9563");
		PhoneNumber robertProp2Unit2Tenant2HomePhone =new PhoneNumber( false , "Home" , "716-854-9845");

		robertProp2Unit2Tenant2.getPhoneNumbers().add(robertProp2Unit2Tenant2CellPhone);
		robertProp2Unit2Tenant2.getPhoneNumbers().add(robertProp2Unit2Tenant2WorkPhone);
		robertProp2Unit2Tenant2.getPhoneNumbers().add(robertProp2Unit2Tenant2HomePhone);

		EmailAddress robertProp2Unit2Tenant2HomeEmail= new EmailAddress(true, "Home", "LeathaAlbares@gmail.com");
		EmailAddress robertProp2Unit2Tenant2WorkEmail= new EmailAddress(false, "Work", "LeathaAlbares@work.com");
		EmailAddress robertProp2Unit2Tenant2OtherEmail= new EmailAddress(false, "Other", "LeathaAlbares@aol.com");

		robertProp2Unit2Tenant2.getEmailAddresses().add(robertProp2Unit2Tenant2HomeEmail);
		robertProp2Unit2Tenant2.getEmailAddresses().add(robertProp2Unit2Tenant2WorkEmail);
		robertProp2Unit2Tenant2.getEmailAddresses().add(robertProp2Unit2Tenant2OtherEmail);

		DbFunctions.insert(robertProp2Unit2Tenant);
		DbFunctions.insert(robertProp2Unit2Tenant2);

		Set<Tenant> robertProp2Unit2Tenanats = new HashSet<>();
		robertProp2Unit2Tenanats.add(robertProp2Unit2Tenant);
		robertProp2Unit2Tenanats.add(robertProp2Unit2Tenant2);
		robertProp2Unit2.setTenants(robertProp2Unit2Tenanats);
		DbFunctions.update(robertProp2Unit2);




		Tenant robertProp3Unit1Tenant = new Tenant ( robertProp3Unit1, "Alisha", "Ligia" , "Heimann" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		robertProp3Unit1Tenant.setUserId("Alisha.Heimann@gmail.com");
		robertProp3Unit1Tenant.setPassword(DbFunctions.hashPassword("Ligia", robertProp3Unit1Tenant.getSalt() ));

		PhoneNumber robertProp3Unit1TenantCellPhone =new PhoneNumber( true , "Cell" , "972-934-6914");
		PhoneNumber robertProp3Unit1TenantWorkPhone =new PhoneNumber( false , "Work" , "770-584-4119");
		PhoneNumber robertProp3Unit1TenantHomePhone =new PhoneNumber( false , "Home" , "415-419-1597");

		robertProp3Unit1Tenant.getPhoneNumbers().add(robertProp3Unit1TenantCellPhone);
		robertProp3Unit1Tenant.getPhoneNumbers().add(robertProp3Unit1TenantWorkPhone);
		robertProp3Unit1Tenant.getPhoneNumbers().add(robertProp3Unit1TenantHomePhone);

		EmailAddress robertProp3Unit1TenantHomeEmail= new EmailAddress(true, "Home", "AlishaHeimann@gmail.com");
		EmailAddress robertProp3Unit1TenantWorkEmail= new EmailAddress(false, "Work", "AlishaHeimann@work.com");
		EmailAddress robertProp3Unit1TenantOtherEmail= new EmailAddress(false, "Other", "AlishaHeimann@aol.com");

		robertProp3Unit1Tenant.getEmailAddresses().add(robertProp3Unit1TenantHomeEmail);
		robertProp3Unit1Tenant.getEmailAddresses().add(robertProp3Unit1TenantWorkEmail);
		robertProp3Unit1Tenant.getEmailAddresses().add(robertProp3Unit1TenantOtherEmail);

		Tenant robertProp3Unit1Tenant2 = new Tenant ( robertProp3Unit1, "Glory", "Zona" , "Toyama" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		robertProp3Unit1Tenant2.setUserId("Glory.Toyama@gmail.com");
		robertProp3Unit1Tenant2.setPassword("Zona");
		robertProp3Unit1Tenant2.setPassword(DbFunctions.hashPassword("Zona", robertProp3Unit1Tenant2.getSalt() ));

		PhoneNumber robertProp3Unit1Tenant2CellPhone =new PhoneNumber( true , "Cell" , "650-947-1215");
		PhoneNumber robertProp3Unit1Tenant2WorkPhone =new PhoneNumber( false , "Work" , "815-426-5657");
		PhoneNumber robertProp3Unit1Tenant2HomePhone =new PhoneNumber( false , "Home" , "509-847-3352");

		robertProp3Unit1Tenant2.getPhoneNumbers().add(robertProp3Unit1Tenant2CellPhone);
		robertProp3Unit1Tenant2.getPhoneNumbers().add(robertProp3Unit1Tenant2WorkPhone);
		robertProp3Unit1Tenant2.getPhoneNumbers().add(robertProp3Unit1Tenant2HomePhone);

		EmailAddress robertProp3Unit1Tenant2HomeEmail= new EmailAddress(true, "Home", "GloryToyama@gmail.com");
		EmailAddress robertProp3Unit1Tenant2WorkEmail= new EmailAddress(false, "Work", "GloryToyama@work.com");
		EmailAddress robertProp3Unit1Tenant2OtherEmail= new EmailAddress(false, "Other", "GloryToyama@aol.com");

		robertProp3Unit1Tenant2.getEmailAddresses().add(robertProp3Unit1Tenant2HomeEmail);
		robertProp3Unit1Tenant2.getEmailAddresses().add(robertProp3Unit1Tenant2WorkEmail);
		robertProp3Unit1Tenant2.getEmailAddresses().add(robertProp3Unit1Tenant2OtherEmail);

		DbFunctions.insert(robertProp3Unit1Tenant);
		DbFunctions.insert(robertProp3Unit1Tenant2);

		Set<Tenant> robertProp3Unit1Tenanats = new HashSet<>();
		robertProp3Unit1Tenanats.add(robertProp3Unit1Tenant);
		robertProp3Unit1Tenanats.add(robertProp3Unit1Tenant2);
		robertProp3Unit1.setTenants(robertProp3Unit1Tenanats);
		DbFunctions.update(robertProp3Unit1);




		Tenant robertProp3Unit2Tenant = new Tenant ( robertProp3Unit2, "Sharika", "Clorinda" , "Marrier" , "06/22/1995", "12/01/2016", 12345678, "Texas", true);
		robertProp3Unit2Tenant.setUserId("Sharika.Marrier@gmail.com");
		robertProp3Unit2Tenant.setPassword(DbFunctions.hashPassword("Clorinda", robertProp3Unit2Tenant.getSalt() ));

		PhoneNumber robertProp3Unit2TenantCellPhone =new PhoneNumber( true , "Cell" , "404-505-4445");
		PhoneNumber robertProp3Unit2TenantWorkPhone =new PhoneNumber( false , "Work" , "201-387-9093");
		PhoneNumber robertProp3Unit2TenantHomePhone =new PhoneNumber( false , "Home" , "512-528-9933");

		robertProp3Unit2Tenant.getPhoneNumbers().add(robertProp3Unit2TenantCellPhone);
		robertProp3Unit2Tenant.getPhoneNumbers().add(robertProp3Unit2TenantWorkPhone);
		robertProp3Unit2Tenant.getPhoneNumbers().add(robertProp3Unit2TenantHomePhone);

		EmailAddress robertProp3Unit2TenantHomeEmail= new EmailAddress(true, "Home", "SharikaMarrier@gmail.com");
		EmailAddress robertProp3Unit2TenantWorkEmail= new EmailAddress(false, "Work", "SharikaMarrier@work.com");
		EmailAddress robertProp3Unit2TenantOtherEmail= new EmailAddress(false, "Other", "SharikaMarrier@aol.com");

		robertProp3Unit2Tenant.getEmailAddresses().add(robertProp3Unit2TenantHomeEmail);
		robertProp3Unit2Tenant.getEmailAddresses().add(robertProp3Unit2TenantWorkEmail);
		robertProp3Unit2Tenant.getEmailAddresses().add(robertProp3Unit2TenantOtherEmail);

		Tenant robertProp3Unit2Tenant2 = new Tenant ( robertProp3Unit2, "Yolando", "Leonida" , "Whobrey" , "06/22/1995", "12/01/2016", 12345678, "Texas", false);
		robertProp3Unit2Tenant2.setUserId("Yolando.Whobrey@gmail.com");
		robertProp3Unit2Tenant2.setPassword("Leonida");
		robertProp3Unit2Tenant2.setPassword(DbFunctions.hashPassword("Leonida", robertProp3Unit2Tenant2.getSalt() ));

		PhoneNumber robertProp3Unit2Tenant2CellPhone =new PhoneNumber( true , "Cell" , "516-948-5768");
		PhoneNumber robertProp3Unit2Tenant2WorkPhone =new PhoneNumber( false , "Work" , "812-442-8544");
		PhoneNumber robertProp3Unit2Tenant2HomePhone =new PhoneNumber( false , "Home" , "215-417-9563");

		robertProp3Unit2Tenant2.getPhoneNumbers().add(robertProp3Unit2Tenant2CellPhone);
		robertProp3Unit2Tenant2.getPhoneNumbers().add(robertProp3Unit2Tenant2WorkPhone);
		robertProp3Unit2Tenant2.getPhoneNumbers().add(robertProp3Unit2Tenant2HomePhone);

		EmailAddress robertProp3Unit2Tenant2HomeEmail= new EmailAddress(true, "Home", "YolandoWhobrey@gmail.com");
		EmailAddress robertProp3Unit2Tenant2WorkEmail= new EmailAddress(false, "Work", "YolandoWhobrey@work.com");
		EmailAddress robertProp3Unit2Tenant2OtherEmail= new EmailAddress(false, "Other", "YolandoWhobrey@aol.com");

		robertProp3Unit2Tenant2.getEmailAddresses().add(robertProp3Unit2Tenant2HomeEmail);
		robertProp3Unit2Tenant2.getEmailAddresses().add(robertProp3Unit2Tenant2WorkEmail);
		robertProp3Unit2Tenant2.getEmailAddresses().add(robertProp3Unit2Tenant2OtherEmail);

		DbFunctions.insert(robertProp3Unit2Tenant);
		DbFunctions.insert(robertProp3Unit2Tenant2);

		Set<Tenant> robertProp3Unit2Tenanats = new HashSet<>();
		robertProp3Unit2Tenanats.add(robertProp3Unit2Tenant);
		robertProp3Unit2Tenanats.add(robertProp3Unit2Tenant2);
		robertProp3Unit2.setTenants(robertProp3Unit2Tenanats);
		DbFunctions.update(robertProp3Unit2);









//		Create Vendors
//

		System.out.println("Working dir:  " + System.getProperty("user.dir"));
		Vendor vendor1 = new Vendor("Robert", "" , "Reyes", "Reyes HVAC", "HVAC",true);
		vendor1.setUserId("ReyesHVAC");
		vendor1.setPassword(DbFunctions.hashPassword("password", vendor1.getSalt() ));
		
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream vendor1Input = classLoader.getResourceAsStream("images/one.jpg");
		byte[] vendor1ImageFile = IOUtils.toByteArray(vendor1Input);
		Picture vendor1pic = new Picture();
		vendor1pic.setImageFile(vendor1ImageFile);
		vendor1.setPicture(vendor1pic);
		
		
		
		vendor1.setPicture(vendor1pic);
		DbFunctions.insert(vendor1pic);
		DbFunctions.insert(vendor1);

		Vendor vendor2 = new Vendor( "Lashawnda", "Moon", "Cryer", "Austin HVAC", "HVAC", true);

		PhoneNumber vendor2CellPhone =new PhoneNumber( true , "Cell" , "913-388-2079");
		PhoneNumber vendor2HomePhone =new PhoneNumber( false , "Home" , "215-228-8264");
		PhoneNumber vendor2WorkPhone =new PhoneNumber( false , "Work" , "305-287-4743");

		Address vendor2Address = new Address(vendor2,true,"305-287-4743", "38938 Park Blvd", "","Austin", "Texas", "78733");

		vendor2.getAddresses().add(vendor2Address);

		vendor2.getPhoneNumbers().add(vendor2CellPhone);
		vendor2.getPhoneNumbers().add(vendor2HomePhone);
		vendor2.getPhoneNumbers().add(vendor2WorkPhone);

		EmailAddress vendor2OtherEmail= new EmailAddress(false, "Other", "Lashawnda.Cryer@gmail.com");
		EmailAddress vendor2WorkEmail= new EmailAddress(true, "Work", "Lashawnda.Cryer@AustinHVAC.com");

		vendor2.getEmailAddresses().add(vendor2OtherEmail);
		vendor2.getEmailAddresses().add(vendor2WorkEmail);

		vendor2.setUserId("Lashawnda.Cryer@AustinHVAC.com");
		vendor2.setPassword(DbFunctions.hashPassword("Moon", vendor2.getSalt() ));

		ClassLoader classLoader2 = Thread.currentThread().getContextClassLoader();	
		InputStream vendor2Input = classLoader2.getResourceAsStream("images/woman2.jpg");
		byte[] vendor2ImageFile = IOUtils.toByteArray(vendor2Input);
		Picture vendor2pic = new Picture();
		vendor2pic.setImageFile(vendor2ImageFile);
		vendor2.setPicture(vendor2pic);
		DbFunctions.insert(vendor2pic);

		
		
		DbFunctions.insert(vendor2);

		Vendor vendor3 = new Vendor( "Chaya", "Mollie", "Bergesen", "Austin Handy Man", "General Repair", true);

		PhoneNumber vendor3CellPhone =new PhoneNumber( true , "Cell" , "619-461-9984");
		PhoneNumber vendor3HomePhone =new PhoneNumber( false , "Home" , "719-547-9543");
		PhoneNumber vendor3WorkPhone =new PhoneNumber( false , "Work" , "973-818-9788");

		Address vendor3Address = new Address(vendor3,true,"973-818-9788", "5 Tomahawk Dr", "","Austin", "Texas", "78756");

		vendor3.getAddresses().add(vendor3Address);

		vendor3.getPhoneNumbers().add(vendor3CellPhone);
		vendor3.getPhoneNumbers().add(vendor3HomePhone);
		vendor3.getPhoneNumbers().add(vendor3WorkPhone);

		EmailAddress vendor3OtherEmail= new EmailAddress(false, "Other", "Chaya.Bergesen@gmail.com");
		EmailAddress vendor3WorkEmail= new EmailAddress(true, "Work", "Chaya.Bergesen@AustinHandyMan.com");

		vendor3.getEmailAddresses().add(vendor3OtherEmail);
		vendor3.getEmailAddresses().add(vendor3WorkEmail);

		vendor3.setUserId("Chaya.Bergesen@AustinHandyMan.com");
		vendor3.setPassword(DbFunctions.hashPassword("Mollie", vendor3.getSalt() ));
		
		ClassLoader classLoader3 = Thread.currentThread().getContextClassLoader();
		InputStream vendor3Input = classLoader3.getResourceAsStream("images/woman3.jpg");
		byte[] vendor3ImageFile = IOUtils.toByteArray(vendor3Input);
		Picture vendor3pic = new Picture();
		vendor3pic.setImageFile(vendor3ImageFile);
		vendor2.setPicture(vendor3pic);
		DbFunctions.insert(vendor3pic);
		DbFunctions.insert(vendor3);

		Vendor vendor4 = new Vendor( "Ciara", "Cathrine", "Padilla", "Joe's landscaping", "Landscaping", true);

		PhoneNumber vendor4CellPhone =new PhoneNumber( true , "Cell" , "908-409-2890");
		PhoneNumber vendor4HomePhone =new PhoneNumber( false , "Home" , "732-724-7251");
		PhoneNumber vendor4WorkPhone =new PhoneNumber( false , "Work" , "619-727-3892");

		Address vendor4Address = new Address(vendor4,true,"619-727-3892", "762 S Main St", "","Austin", "Texas", "78745");

		vendor4.getAddresses().add(vendor4Address);

		vendor4.getPhoneNumbers().add(vendor4CellPhone);
		vendor4.getPhoneNumbers().add(vendor4HomePhone);
		vendor4.getPhoneNumbers().add(vendor4WorkPhone);

		EmailAddress vendor4OtherEmail= new EmailAddress(false, "Other", "Ciara.Padilla@gmail.com");
		EmailAddress vendor4WorkEmail= new EmailAddress(true, "Work", "Ciara.Padilla@Joeslandscaping.com");

		vendor4.getEmailAddresses().add(vendor4OtherEmail);
		vendor4.getEmailAddresses().add(vendor4WorkEmail);

		vendor4.setUserId("Ciara.Padilla@Joeslandscaping.com");
		vendor4.setPassword(DbFunctions.hashPassword("Cathrine", vendor4.getSalt() ));
		
		ClassLoader classLoader4 = Thread.currentThread().getContextClassLoader();
		InputStream vendor4Input = classLoader4.getResourceAsStream("images/woman4.jpg");
		byte[] vendor4ImageFile = IOUtils.toByteArray(vendor4Input);
		Picture vendor4pic = new Picture();
		vendor4pic.setImageFile(vendor4ImageFile);
		vendor4.setPicture(vendor4pic);
		DbFunctions.insert(vendor4pic);
		DbFunctions.insert(vendor4);

		Vendor vendor5 = new Vendor( "John", "Ma", "Paulas", "John's Plumbing", "Plumbing", true);

		PhoneNumber vendor5CellPhone =new PhoneNumber( true , "Cell" , "215-255-1641");
		PhoneNumber vendor5HomePhone =new PhoneNumber( false , "Home" , "973-662-8988");
		PhoneNumber vendor5WorkPhone =new PhoneNumber( false , "Work" , "215-829-4221");

		Address vendor5Address = new Address(vendor5,true,"215-829-4221", "209 Decker Dr", "","Del Valle", "Texas", "78567");

		vendor5.getAddresses().add(vendor5Address);

		vendor5.getPhoneNumbers().add(vendor5CellPhone);
		vendor5.getPhoneNumbers().add(vendor5HomePhone);
		vendor5.getPhoneNumbers().add(vendor5WorkPhone);

		EmailAddress vendor5OtherEmail= new EmailAddress(false, "Other", "John.Paulas@gmail.com");
		EmailAddress vendor5WorkEmail= new EmailAddress(true, "Work", "John.Paulas@JohnsPlumbing.com");

		vendor5.getEmailAddresses().add(vendor5OtherEmail);
		vendor5.getEmailAddresses().add(vendor5WorkEmail);

		vendor5.setUserId("Peggie.Paulas@JohnsPlumbing.com");
		vendor5.setPassword(DbFunctions.hashPassword("Ma", vendor5.getSalt() ));
		
		
		ClassLoader classLoader5 = Thread.currentThread().getContextClassLoader();
		InputStream vendor5Input = classLoader5.getResourceAsStream("images/two.jpg");
		byte[] vendor5ImageFile = IOUtils.toByteArray(vendor5Input);
		Picture vendor5pic = new Picture();
		vendor5pic.setImageFile(vendor5ImageFile);
		vendor5.setPicture(vendor5pic);
		DbFunctions.insert(vendor5pic);
		
		DbFunctions.insert(vendor5);

		Vendor vendor6 = new Vendor( "Avery", "Vallie", "Eschberger", "Debbie's Cleaning", "Cleaning", true);

		PhoneNumber vendor6CellPhone =new PhoneNumber( true , "Cell" , "734-561-6170");
		PhoneNumber vendor6HomePhone =new PhoneNumber( false , "Home" , "508-658-7802");
		PhoneNumber vendor6WorkPhone =new PhoneNumber( false , "Work" , "201-772-7699");

		Address vendor6Address = new Address(vendor6,true,"201-772-7699", "4486 W O St #1", "","Austin", "Texas", "76584");

		vendor6.getAddresses().add(vendor6Address);

		vendor6.getPhoneNumbers().add(vendor6CellPhone);
		vendor6.getPhoneNumbers().add(vendor6HomePhone);
		vendor6.getPhoneNumbers().add(vendor6WorkPhone);

		EmailAddress vendor6OtherEmail= new EmailAddress(false, "Other", "Avery.Eschberger@gmail.com");
		EmailAddress vendor6WorkEmail= new EmailAddress(true, "Work", "Avery.Eschberger@DebbiesCleaning.com");

		vendor6.getEmailAddresses().add(vendor6OtherEmail);
		vendor6.getEmailAddresses().add(vendor6WorkEmail);

		vendor6.setUserId("Avery.Eschberger@DebbiesCleaning.com");
		vendor6.setPassword(DbFunctions.hashPassword("Vallie", vendor6.getSalt() ));
		
		ClassLoader classLoader6 = Thread.currentThread().getContextClassLoader();
		InputStream vendor6Input = classLoader6.getResourceAsStream("images/three.jpg");
		byte[] vendor6ImageFile = IOUtils.toByteArray(vendor6Input);
		Picture vendor6pic = new Picture();
		vendor6pic.setImageFile(vendor6ImageFile);
		vendor6.setPicture(vendor6pic);
		DbFunctions.insert(vendor6pic);
		
		DbFunctions.insert(vendor6);

		Vendor vendor7 = new Vendor( "Cherry", "Joni", "Oldroyd", "Molly Maids", "Cleaning", true);

		PhoneNumber vendor7CellPhone =new PhoneNumber( true , "Cell" , "609-200-8577");
		PhoneNumber vendor7HomePhone =new PhoneNumber( false , "Home" , "916-770-7448");
		PhoneNumber vendor7WorkPhone =new PhoneNumber( false , "Work" , "608-942-8836");

		Address vendor7Address = new Address(vendor7,true,"608-942-8836", "39 S 7th St", "","San Marcos", "Texas", "78904");

		vendor7.getAddresses().add(vendor7Address);

		vendor7.getPhoneNumbers().add(vendor7CellPhone);
		vendor7.getPhoneNumbers().add(vendor7HomePhone);
		vendor7.getPhoneNumbers().add(vendor7WorkPhone);

		EmailAddress vendor7OtherEmail= new EmailAddress(false, "Other", "Cherry.Oldroyd@gmail.com");
		EmailAddress vendor7WorkEmail= new EmailAddress(true, "Work", "Cherry.Oldroyd@MollyMaids.com");

		vendor7.getEmailAddresses().add(vendor7OtherEmail);
		vendor7.getEmailAddresses().add(vendor7WorkEmail);

		vendor7.setUserId("Cherry.Oldroyd@MollyMaids.com");
		vendor7.setPassword(DbFunctions.hashPassword("Joni", vendor7.getSalt() ));
		
		ClassLoader classLoader7 = Thread.currentThread().getContextClassLoader();
		InputStream vendor7Input = classLoader7.getResourceAsStream("images/woman5.jpg");
		byte[] vendor7ImageFile = IOUtils.toByteArray(vendor7Input);
		Picture vendor7pic = new Picture();
		vendor7pic.setImageFile(vendor7ImageFile);
		vendor7.setPicture(vendor7pic);
		DbFunctions.insert(vendor7pic);
		DbFunctions.insert(vendor7);

		Vendor vendor8 = new Vendor( "Jerry", "Jacqueline", "Semidey", "South Austin Electric", "Electrician", true);

		PhoneNumber vendor8CellPhone =new PhoneNumber( true , "Cell" , "410-351-1863");
		PhoneNumber vendor8HomePhone =new PhoneNumber( false , "Home" , "513-747-9603");
		PhoneNumber vendor8WorkPhone =new PhoneNumber( false , "Work" , "973-868-8660");

		Address vendor8Address = new Address(vendor8,true,"973-868-8660", "98839 Hawthorne Blvd #6101", "","Austin", "Texas", "78654");

		vendor8.getAddresses().add(vendor8Address);

		vendor8.getPhoneNumbers().add(vendor8CellPhone);
		vendor8.getPhoneNumbers().add(vendor8HomePhone);
		vendor8.getPhoneNumbers().add(vendor8WorkPhone);

		EmailAddress vendor8OtherEmail= new EmailAddress(false, "Other", "Jerry.Semidey@gmail.com");
		EmailAddress vendor8WorkEmail= new EmailAddress(true, "Work", "Jerry.Semidey@SouthAustinElectric.com");

		vendor8.getEmailAddresses().add(vendor8OtherEmail);
		vendor8.getEmailAddresses().add(vendor8WorkEmail);

		vendor8.setUserId("Jerry.Semidey@SouthAustinElectric.com");
		vendor8.setPassword(DbFunctions.hashPassword("Jacqueline", vendor8.getSalt() ));
		
		ClassLoader classLoader8 = Thread.currentThread().getContextClassLoader();
		InputStream vendor8Input = classLoader8.getResourceAsStream("images/four.jpg");
		byte[] vendor8ImageFile = IOUtils.toByteArray(vendor8Input);
		Picture vendor8pic = new Picture();
		vendor8pic.setImageFile(vendor8ImageFile);
		vendor8.setPicture(vendor8pic);
		DbFunctions.insert(vendor8pic);
		
		DbFunctions.insert(vendor8);

		Vendor vendor9 = new Vendor( "Jose", "Helaine", "Good", "North Austin Plumbing", "Plumbing", true);

		PhoneNumber vendor9CellPhone =new PhoneNumber( true , "Cell" , "847-222-1734");
		PhoneNumber vendor9HomePhone =new PhoneNumber( false , "Home" , "603-745-7497");
		PhoneNumber vendor9WorkPhone =new PhoneNumber( false , "Work" , "216-733-8494");

		Address vendor9Address = new Address(vendor9,true,"216-733-8494", "71 San Mateo Ave", "","Austin", "Texas", "76543");

		vendor9.getAddresses().add(vendor9Address);

		vendor9.getPhoneNumbers().add(vendor9CellPhone);
		vendor9.getPhoneNumbers().add(vendor9HomePhone);
		vendor9.getPhoneNumbers().add(vendor9WorkPhone);

		EmailAddress vendor9OtherEmail= new EmailAddress(false, "Other", "Jose.Good@gmail.com");
		EmailAddress vendor9WorkEmail= new EmailAddress(true, "Work", "Jose.Good@NorthAustinPlumbing.com");

		vendor9.getEmailAddresses().add(vendor9OtherEmail);
		vendor9.getEmailAddresses().add(vendor9WorkEmail);

		vendor9.setUserId("Jose.Good@NorthAustinPlumbing.com");
		vendor9.setPassword(DbFunctions.hashPassword("Helaine", vendor9.getSalt() ));
		
		ClassLoader classLoader9 = Thread.currentThread().getContextClassLoader();
		InputStream vendor9Input = classLoader9.getResourceAsStream("images/five.jpg");
		byte[] vendor9ImageFile = IOUtils.toByteArray(vendor9Input);
		Picture vendor9pic = new Picture();
		vendor9pic.setImageFile(vendor9ImageFile);
		vendor9.setPicture(vendor9pic);
		DbFunctions.insert(vendor9pic);
		
		DbFunctions.insert(vendor9);

		Vendor vendor10 = new Vendor( "Kallie", "Britt", "Bubash", "Buda Handy Man", "General Repair", true);

		PhoneNumber vendor10CellPhone =new PhoneNumber( true , "Cell" , "908-275-8357");
		PhoneNumber vendor10HomePhone =new PhoneNumber( false , "Home" , "215-647-2158");
		PhoneNumber vendor10WorkPhone =new PhoneNumber( false , "Work" , "315-640-6357");

		Address vendor10Address = new Address(vendor10,true,"315-640-6357", "76 Brooks St #9", "","Buda", "Texas", "78765");

		vendor10.getAddresses().add(vendor10Address);

		vendor10.getPhoneNumbers().add(vendor10CellPhone);
		vendor10.getPhoneNumbers().add(vendor10HomePhone);
		vendor10.getPhoneNumbers().add(vendor10WorkPhone);

		EmailAddress vendor10OtherEmail= new EmailAddress(false, "Other", "Kallie.Bubash@gmail.com");
		EmailAddress vendor10WorkEmail= new EmailAddress(true, "Work", "Kallie.Bubash@BudaHandyMan.com");

		vendor10.getEmailAddresses().add(vendor10OtherEmail);
		vendor10.getEmailAddresses().add(vendor10WorkEmail);

		vendor10.setUserId("Kallie.Bubash@BudaHandyMan.com");
		vendor10.setPassword(DbFunctions.hashPassword("Britt", vendor10.getSalt() ));

		ClassLoader classLoader10 = Thread.currentThread().getContextClassLoader();
		InputStream vendor10Input = classLoader10.getResourceAsStream("images/six.jpg");
		byte[] vendor10ImageFile = IOUtils.toByteArray(vendor10Input);
		Picture vendor10pic = new Picture();
		vendor10pic.setImageFile(vendor10ImageFile);
		vendor10.setPicture(vendor10pic);
		DbFunctions.insert(vendor10pic);
		
		DbFunctions.insert(vendor10);

		Vendor vendor11 = new Vendor( "Bok", "Xuan", "Perin", "BokBok Cleaning", "Cleaning", true);

		PhoneNumber vendor11CellPhone =new PhoneNumber( true , "Cell" , "602-390-4944");
		PhoneNumber vendor11HomePhone =new PhoneNumber( false , "Home" , "410-916-8015");
		PhoneNumber vendor11WorkPhone =new PhoneNumber( false , "Work" , "509-595-6485");

		Address vendor11Address = new Address(vendor11,true,"509-595-6485", "4545 Courthouse Rd", "","Kyle", "Texas", "76438");

		vendor11.getAddresses().add(vendor11Address);

		vendor11.getPhoneNumbers().add(vendor11CellPhone);
		vendor11.getPhoneNumbers().add(vendor11HomePhone);
		vendor11.getPhoneNumbers().add(vendor11WorkPhone);

		EmailAddress vendor11OtherEmail= new EmailAddress(false, "Other", "Bok.Perin@gmail.com");
		EmailAddress vendor11WorkEmail= new EmailAddress(true, "Work", "Bok.Perin@BokBokCleaning.com");

		vendor11.getEmailAddresses().add(vendor11OtherEmail);
		vendor11.getEmailAddresses().add(vendor11WorkEmail);

		vendor11.setUserId("Bok.Perin@BokBokCleaning.com");
		vendor11.setPassword(DbFunctions.hashPassword("Xuan", vendor11.getSalt() ));
		
		ClassLoader classLoader11 = Thread.currentThread().getContextClassLoader();
		InputStream vendor11Input = classLoader11.getResourceAsStream("images/seven.jpg");
		byte[] vendor11ImageFile = IOUtils.toByteArray(vendor11Input);
		Picture vendor11pic = new Picture();
		vendor11pic.setImageFile(vendor11ImageFile);
		vendor11.setPicture(vendor11pic);
		DbFunctions.insert(vendor11pic);
		
		DbFunctions.insert(vendor11);

		Vendor vendor12 = new Vendor( "Lonna", "Amber", "Duenas", "Amber Green", "Landscaping", true);

		PhoneNumber vendor12CellPhone =new PhoneNumber( true , "Cell" , "410-669-1642");
		PhoneNumber vendor12HomePhone =new PhoneNumber( false , "Home" , "410-234-2267");
		PhoneNumber vendor12WorkPhone =new PhoneNumber( false , "Work" , "215-422-8694");

		Address vendor12Address = new Address(vendor12,true,"215-422-8694", "14288 Foster Ave #4121", "","Cedar Park", "Texas", "78654");

		vendor12.getAddresses().add(vendor12Address);

		vendor12.getPhoneNumbers().add(vendor12CellPhone);
		vendor12.getPhoneNumbers().add(vendor12HomePhone);
		vendor12.getPhoneNumbers().add(vendor12WorkPhone);

		EmailAddress vendor12OtherEmail= new EmailAddress(false, "Other", "Lonna.Duenas@gmail.com");
		EmailAddress vendor12WorkEmail= new EmailAddress(true, "Work", "Lonna.Duenas@AmberGreen.com");

		vendor12.getEmailAddresses().add(vendor12OtherEmail);
		vendor12.getEmailAddresses().add(vendor12WorkEmail);

		vendor12.setUserId("Lonna.Duenas@AmberGreen.com");
		vendor12.setPassword(DbFunctions.hashPassword("Amber", vendor12.getSalt() ));

		ClassLoader classLoader12 = Thread.currentThread().getContextClassLoader();
		InputStream vendor12Input = classLoader12.getResourceAsStream("images/eight.jpg");
		byte[] vendor12ImageFile = IOUtils.toByteArray(vendor12Input);
		Picture vendor12pic = new Picture();
		vendor12pic.setImageFile(vendor12ImageFile);
		vendor11.setPicture(vendor12pic);
		DbFunctions.insert(vendor12pic);
		
		DbFunctions.insert(vendor12);




		
		ServiceCall serviceCall1 = new ServiceCall(jackProp1Unit1, "General Repair", "Broken garbage Disposal", "Open" , "0" , "30");
		serviceCall1.setReportedBy(jackProp1Unit1Tenant);
		DbFunctions.insert(serviceCall1);
		Set<ServiceCall> jackProp1Unit1SC = new HashSet<>();
		jackProp1Unit1SC.add(serviceCall1);
		jackProp1Unit1.setServiceCalls(jackProp1Unit1SC);
		DbFunctions.update(jackProp1Unit1);
		
		ServiceCall serviceCall2 = new ServiceCall(joeyProp1Unit15, "General Repair", "Door does not close properly", "Open" , "0" , "50");
		serviceCall2.setReportedBy(joeyProp1Unit15Tenant);
		DbFunctions.insert(serviceCall2);
		Set<ServiceCall> joeyProp1Unit15SC = new HashSet<>();
		joeyProp1Unit15SC.add(serviceCall2);
		jackProp1Unit1.setServiceCalls(joeyProp1Unit15SC);
		DbFunctions.update(joeyProp1Unit15);
		
		ServiceCall serviceCall3 = new ServiceCall(jackProp2Unit20, "HVAC", "AC not working", "Open" , "0" , "30");
		serviceCall3.setReportedBy(jackProp2Unit20Tenant);
		DbFunctions.insert(serviceCall3);
		Set<ServiceCall> jackProp2Unit20SC = new HashSet<>();
		jackProp2Unit20SC.add(serviceCall3);
		jackProp2Unit20.setServiceCalls(jackProp2Unit20SC);
		DbFunctions.update(jackProp2Unit20);
		
		ServiceCall serviceCall4 = new ServiceCall(joeyProp1Unit8, "Plumbing", "Leaking Pipe", "Open" , "0" , "30");
		serviceCall4.setReportedBy(joeyProp1Unit8Tenant2);
		DbFunctions.insert(serviceCall4);
		Set<ServiceCall> joeyProp1Unit8SC = new HashSet<>();
		joeyProp1Unit8SC.add(serviceCall4);
		joeyProp1Unit8.setServiceCalls(joeyProp1Unit8SC);
		DbFunctions.update(joeyProp1Unit8);
		
		ServiceCall serviceCall5 = new ServiceCall(robertProp3Unit2, "Plumbing", "Leaking Pipe", "Complete" , "0" , "30");
		serviceCall5.setReportedBy(robertProp3Unit2Tenant2);
		serviceCall5.setActive(false);
		DbFunctions.insert(serviceCall5);
		Set<ServiceCall> robertProp3Unit2SC = new HashSet<>();
		robertProp3Unit2SC.add(serviceCall5);
		robertProp3Unit2.setServiceCalls(robertProp3Unit2SC);
		DbFunctions.update(robertProp3Unit2);
		

		
		
		
		
		LedgerEntry ledger1 = new LedgerEntry( jackProp2Unit1 ,"01/01/2016", "Rent", 
				"Monthly Rent Charge", "750.00", "0");
		DbFunctions.insert(ledger1);
		LedgerEntry ledger2 = new LedgerEntry( jackProp2Unit1 ,"01/01/2016", "Rent", 
				"Monthly Rent Paid", "0", "750.00");
		DbFunctions.insert(ledger2);
		
		DbFunctions.addRents();
		
		getServletContext().getRequestDispatcher("/Home")
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
