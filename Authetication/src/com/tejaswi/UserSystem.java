package com.tejaswi;

import java.util.Scanner;

public class UserSystem {
	static Scanner sc = new Scanner(java.lang.System.in);

	
	
    private String user = "tejaswi";  
    private String password = "tejaswi69";  
    private String gmail;
    private String gmailPassword;

   
    void setval(String user) {
        this.user = user;

    }
    void setval1(String password) {
        this.password = password;
    }

    String getuser() {
        return user;
    }

    
    String getpassword() {
        return password;
    }

  
    void setGmail(String gmail) {
        this.gmail = gmail;
    }

   
    void setGmailPassword(String gmailPassword) {
        this.gmailPassword = gmailPassword;
    }

   
    String getGmail() {
        return gmail;
    }

    
    String getGmailPassword() {
        return gmailPassword;
    }
}


