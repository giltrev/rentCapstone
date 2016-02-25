package com.rentroll.data;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.rentroll.business.LedgerEntry;
import com.rentroll.business.Tenant;
import com.rentroll.business.Unit;

public class AddRent {

	public static void addRent(){
		Calendar firstOfMonthCal = Calendar.getInstance();   
		firstOfMonthCal.set(Calendar.DAY_OF_MONTH, 1);
		Date firstOfMonth = firstOfMonthCal.getTime();

		List <Tenant> tenants =DbFunctions.selectAllTenants();
		
		for (Tenant tenant : tenants) {
			System.out.println("Tenant " + tenant.getPersonId() + " Unit ID "+ tenant.getUnit().getUnitId());

			
			System.out.println("Tenant " + tenant.getPersonId() + " Unit ID "+ tenant.getUnit().getUnitId());
			

			System.out.println("unit");
			
			
			
			
			Unit unit = tenant.getUnit();
			
			Set <LedgerEntry> unitledgerEntries = new HashSet<>();
			
			
			unitledgerEntries.addAll(unit.getLedgerEntries());
			
			System.out.println(" Ledger Entry QTY size "+ unitledgerEntries.size());
			int counter = 0;	
			if (unitledgerEntries.size()!=0){
				for (LedgerEntry ledgerEntry : unitledgerEntries) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(ledgerEntry.getDate());
					
					if (Calendar.YEAR==firstOfMonthCal.YEAR &&
							Calendar.MONTH==firstOfMonthCal.MONTH &&
							Calendar.DAY_OF_MONTH==firstOfMonthCal.DAY_OF_MONTH){
						counter++;
						System.out.println("ledgerEntry counter "+counter);
					}	
					

				}

			}
			if (counter==0){
				LedgerEntry ledgerEnty = new LedgerEntry();	
				ledgerEnty.setAccountName("RentCharge");
				ledgerEnty.setDate(firstOfMonth);
				ledgerEnty.setUnit(unit);
				ledgerEnty.setDebit(unit.getRentRate());	

				DbFunctions.insert(ledgerEnty);

			}
		}

	}

}
