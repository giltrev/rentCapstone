package com.rentroll.admin;

import java.util.Comparator;

import com.rentroll.business.EmailAddress;

public class EmailComp implements Comparator<EmailAddress>{
	@Override
    public int compare(EmailAddress e1, EmailAddress e2) {
        boolean b1 = e1.isPrimaryEmail();
        boolean b2 = e1.isPrimaryEmail();

        if (b1 == !b2){
            return 1;
        }
        if (!b1 == b2){
            return -1;
        }
        return 0;
    }
}
