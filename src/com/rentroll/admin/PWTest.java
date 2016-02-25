package com.rentroll.admin;

import java.io.IOException;
import java.util.Base64;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.xml.bind.DatatypeConverter;

import com.rentroll.data.DbFunctions;



/**
 * Servlet implementation class PWTest
 */
@WebServlet("/PWTest")
public class PWTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static boolean slowEquals(byte[] a, byte[] b)
    {
        int diff = a.length ^ b.length;
        for(int i = 0; i < a.length && i < b.length; i++)
            diff |= a[i] ^ b[i];
        return diff == 0;
    }   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PWTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random random = new Random();
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		byte[] salt = new byte[4];
		random.nextBytes(salt);
		byte[] salt2 = new byte[4];
		random.nextBytes(salt2);
		
		
		String storedPassword = DbFunctions.hashPassword("Julianna6", salt);
		String hashPassword = DbFunctions.hashPassword(password, salt);
		System.out.println("User ID " + userId);
		System.out.println("password " + password + " length "+ hashPassword.length());
		Base64.Encoder enc = Base64.getEncoder();
//		System.out.printf("salt: %s%n", enc.encodeToString(salt));
//		String hashedPW = enc.encodeToString(hashPassword);
//		System.out.println(hashedPW);
//		System.out.printf("hashPassword: %s%n", enc.encodeToString(hashPassword));
//		System.out.printf("storedPassword: %s%n", enc.encodeToString(storedPassword));
//		String hash = enc.encodeToString(hashPassword) + enc.encodeToString(salt);
//		System.out.println("hashed " + hash);
//		System.out.println(salt);
//		
//		if (slowEquals(storedPassword,hashPassword)){
//			System.out.println("passwords match!!");
//		} else {
//			System.out.println("passwords DO NOT match!!");
//
//		}
//		Base64.Decoder dec = Base64.getDecoder();
//		String gotSalt = hash.substring(hashedPW.length());
//		System.out.println(gotSalt);
//		byte[] retrievedSalt = dec.decode(gotSalt);
//		System.out.println(gotSalt);
//		String hexSalt = DatatypeConverter.printHexBinary(salt);
//		
//		String passwrodAndSalt = "Julianna6" + hexSalt;
//		System.out.println("passwrodAndSalt " + passwrodAndSalt); 
//		
//		String enteredPasswrodAndSalt = password + hexSalt;
//		System.out.println("enteredPasswrodAndSalt " + enteredPasswrodAndSalt);
//		
//		String enteredPasswrodAndSaltHashed = DbFunctions.hashPassword(enteredPasswrodAndSalt, salt);
//		String passwrodAndSaltHashed = DbFunctions.hashPassword(passwrodAndSalt, salt);
//		
//		
////		String enteredHex = DatatypeConverter.printHexBinary(enteredPasswrodAndSaltHashed);
////		String hex = DatatypeConverter.printHexBinary(passwrodAndSaltHashed);
//	    System.out.println("passwrodAndSaltHashed  " + passwrodAndSaltHashed);
//	    System.out.println("Entered passwrodAndSaltHashed  " + enteredPasswrodAndSaltHashed);
//	    
//	   
//	    
//		
//		if (slowEquals(retrievedSalt,salt)){
//			System.out.println("Salts match!!");
//		} else {
//			System.out.println("Salts DO NOT match!!");
//		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
