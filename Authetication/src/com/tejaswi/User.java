package com.tejaswi;

import java.util.Scanner;

public class User extends UserSystem {  
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private int password = 0;
    private boolean loggedIn = false;  
    private String loggedInUser = "";
	private int usernameAttempts;
	private int passwordAttempts;  

    static Scanner sc = new Scanner(System.in);  

    public static void main(String[] args) {
        User obj = new User();  
        boolean registered = false;  

        while (true) {  
            if (obj.loggedIn) {  
                System.out.println("Logged in as: -> " + obj.loggedInUser + " <- ");
                delaySeconds(4); 
            } else {
            	 delaySeconds(4); 
                System.out.println("1. Sign Up");
                System.out.println("2. Log In");
                System.out.println("3. Reset Password");
                System.out.println("4. Exit");
                System.out.println("5. Log Out");
            }

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();  

            switch (choice) {
                case 1:
                    signUp(obj);  
                    registered = true;  
                    break;     
                case 2:
                    if (!obj.loggedIn) {
                    	 login(obj);  
                    } else {
                        System.out.println(" -> You are already logged in as: " + obj.loggedInUser);
                    }
                    break;
                case 3:
                    if (registered) {
                        resetPassword(obj);  
                    } else {
                        System.out.println("    ****    You are not registered. Please sign up first.    ****    ");
                    }
                    break;
                case 4:
                    System.out.println(" -> -> Exiting the program. <- <-");
                    System.exit(0); 
                    break;
                case 5:
                    if (obj.loggedIn) {
                        if (logOutConfirmation()) {
                            obj.logOut();  
                            delaySeconds(4);
                        } else {
                            System.out.println("    ****    Logout canceled.    ****    ");
                        }
                    } else {
                        System.out.println("    ****    You are not logged in.    ****    ");
                    }
                    break;
                default:
                    System.out.println("    ****    Invalid choice. Please enter a valid option.    ****    ");
            }
        }
    }

   
    private static void signUp(User obj) {
    	 System.out.print("Enter your User Name: ");
         String enteredUser = sc.next();
         obj.setval(enteredUser); 

         System.out.print("Enter your User Password: ");
         String enteredPassword = sc.next();
         obj.setval1(enteredPassword);  
         System.out.print("Enter your Gmail: ");
         String enteredGmail = sc.next();
         obj.setGmail(enteredGmail);  

         System.out.print("Enter your Gmail Password: ");
         String enteredGmailPassword = sc.next();
         obj.setGmailPassword(enteredGmailPassword); 

        

         System.out.println("    $$$$    Registration Successful!    $$$$    ");
     }
    private static void login(User obj) {
      
    	 if (obj.usernameAttempts < MAX_LOGIN_ATTEMPTS) {
             System.out.print("Enter your User Name: ");
             String enteredUser = sc.next();

             if (obj.getuser().equals(enteredUser)) {
                 System.out.print("Enter your User Password: ");
                 String enteredPassword = sc.next();

                 if (obj.getpassword().equals(enteredPassword)) {
                     obj.loggedIn = true;
                     obj.loggedInUser = enteredUser;
                     delaySeconds(4);
                     System.out.println("    @@@@    Login Success!    @@@@    ");
                     return;
                 } else {
                     obj.passwordAttempts++;
                     int remainingAttempts = MAX_LOGIN_ATTEMPTS - obj.passwordAttempts;
                     if (remainingAttempts > 0) {
                         System.out.println(" !!!! Invalid Password. You have " + remainingAttempts + " more attempts. !!!! ");
                         login(obj); 
                     } else {
                         System.out.println("    ****    You've exceeded the maximum number of login attempts for the password.    ****    ");
                         resetPassword(obj);  
                     }
                 }
             } else {
                 obj.usernameAttempts++;
                 int remainingAttempts = MAX_LOGIN_ATTEMPTS - obj.usernameAttempts;
                 if (remainingAttempts > 0) {
                     System.out.println(" !!!! Invalid User Name. You have " + remainingAttempts + " more attempts. !!!! ");
                     login(obj); 
                 } else {
                     System.out.println("    ****    You've exceeded the maximum number of login attempts for the username.    ****    ");
                     resetPassword(obj); 
                 }
             }
         } else {
             System.out.println("    ****    You've exceeded the maximum number of login attempts for both username and password. Please sign up again.    ****    ");
             obj.usernameAttempts = 0;
             obj.passwordAttempts = 0;
         }
    }

    private static void resetPassword(User obj) {
    	boolean otpSent = false;
        int remainingGmailAttempts = 3;

        while (remainingGmailAttempts > 0) {
            System.out.print("Enter your Gmail: ");
            String enteredGmail = sc.next();

            if (obj.getGmail().equals(enteredGmail)) {
                System.out.print("Enter your Gmail Password: ");
                String enteredGmailPassword = sc.next();

                if (obj.getGmailPassword().equals(enteredGmailPassword)) {
                    String otp = generateOTP(); 
                    System.out.println(" -> -> Your OTP for username reset is: " + otp);
                    otpSent = true;

                    while (true) {
                        System.out.print(" -> -> Enter OTP to confirm username reset (or 'R' to resend OTP): ");
                        String enteredOTP = sc.next();

                        if (otp.equals(enteredOTP)) {
                            
                            delaySeconds(3);

                            System.out.print("Enter your new User Name: ");
                            String newUsername = sc.next();
                            obj.setval(newUsername);  
                            System.out.println("    ****    Username reset successful.    ****    ");
                            obj.usernameAttempts = 0;
                            return;
                        } else if (enteredOTP.equalsIgnoreCase("R")) {
                            otp = generateOTP();  
                            System.out.println(" => => Resending OTP: " + otp);
                        } else {
                            System.out.println("    ****    Invalid OTP. Username reset failed.    ****    ");
                        }
                    }
                } else {
                    System.out.println(" !!!! Invalid Gmail Password. You have " + remainingGmailAttempts + " more attempts. !!!! ");
                    remainingGmailAttempts--;
                }
            } else {
                System.out.println(" !!!!Invalid Gmail. You have " + remainingGmailAttempts + " more attempts. !!!! ");
                remainingGmailAttempts--;
            }
        }
        if (!otpSent) {
            System.out.println("    ****    Failed to send OTP. Username reset failed.    ****    ");
        }
    }

    private void logOut() {
        loggedIn = false;
        loggedInUser = "";
        System.out.println(" -> You have successfully logged out.");
    }

    private static boolean logOutConfirmation() {
        System.out.println("Are you sure you want to log out? (yes/no): ");
        String response = sc.next();
        return response.equalsIgnoreCase("yes");
    }

    private static void delaySeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public static int getMaxLoginAttempts() {
		return MAX_LOGIN_ATTEMPTS;
	}
	 static void signUp1(User obj) {
	        System.out.print("Enter your User Name: ");
	        String enteredUser = sc.next();
	        obj.setval(enteredUser);  

	        System.out.print("Enter your User Password: ");
	        String enteredPassword = sc.next();
	        obj.setval1(enteredPassword);  
     System.out.println("    $$$$    Registration Successful!    $$$$    ");
	    }

	    static void login1(User obj) {
	        if (obj.usernameAttempts < MAX_LOGIN_ATTEMPTS) {
	            System.out.print("Enter your User Name: ");
	            String enteredUser = sc.next();

	            if (obj.getuser().equals(enteredUser)) {
	                System.out.print("Enter your User Password: ");
	                String enteredPassword = sc.next();

	                if (obj.getpassword().equals(enteredPassword)) {
	                    obj.loggedIn = true;
	                    obj.loggedInUser = enteredUser;
	                    delaySeconds(4);
	                    System.out.println("    @@@@    Login Success!    @@@@    ");
	                    return;
	                } else {
	                    obj.passwordAttempts++;
	                    int remainingAttempts = MAX_LOGIN_ATTEMPTS - obj.passwordAttempts;
	                    if (remainingAttempts > 0) {
	                        System.out.println(" !!!! Invalid Password. You have " + remainingAttempts + " more attempts. !!!! ");
	                        login(obj); 
	                    } else {
	                        System.out.println("    ****    You've exceeded the maximum number of login attempts for the password.    ****    ");
	                        resetPassword(obj);  
	                    }
	                }
	            } else {
	                obj.usernameAttempts++;
	                int remainingAttempts = MAX_LOGIN_ATTEMPTS - obj.usernameAttempts;
	                if (remainingAttempts > 0) {
	                    System.out.println(" !!!! Invalid User Name. You have " + remainingAttempts + " more attempts. !!!! ");
	                    login(obj); 
	                } else {
	                    System.out.println("    ****    You've exceeded the maximum number of login attempts for the username.    ****    ");
	                    resetPassword(obj);  
	                }
	            }
	        } else {
	            System.out.println("    ****    You've exceeded the maximum number of login attempts for both username and password. Please sign up again.    ****    ");
	            obj.usernameAttempts = 0;
	            obj.passwordAttempts = 0;
	        }
	    }
	    static void resetPassword1(User obj) {
	        boolean otpSent = false;
	        int remainingGmailAttempts = 3;

	        while (remainingGmailAttempts > 0) {
	            System.out.print("Enter your Gmail: ");
	            String enteredGmail = sc.next();

	            if (obj.getGmail().equals(enteredGmail)) {
	                System.out.print("Enter your Gmail Password: ");
	                String enteredGmailPassword = sc.next();

	                if (obj.getGmailPassword().equals(enteredGmailPassword)) {
	                    String otp = generateOTP();  
	                    System.out.println(" -> -> Your OTP for password reset is: " + otp);
	                    otpSent = true;

	                    while (true) {
	                        System.out.print(" -> -> Enter OTP to confirm password reset (or 'R' to resend OTP): ");
	                        String enteredOTP = sc.next();

	                        if (otp.equals(enteredOTP)) {
	                            
	                            delaySeconds(3);

	                            System.out.print("Enter your new User Password: ");
	                            String newPassword = sc.next();
	                            obj.setval1(newPassword);  
	                            System.out.println("    ****    Password reset successful.    ****    ");
	                            obj.passwordAttempts = 0;
	                            return;
	                        } else if (enteredOTP.equalsIgnoreCase("R")) {
	                            otp = generateOTP();  
	                            System.out.println(" => => Resending OTP: " + otp);
	                        } else {
	                            System.out.println("    ****    Invalid OTP. Password reset failed.    ****    ");
	                        }
	                    }
	                } else {
	                    System.out.println(" !!!! Invalid Gmail Password. You have " + remainingGmailAttempts + " more attempts. !!!! ");
	                    remainingGmailAttempts--;
	                }
	            } else {
	                System.out.println(" !!!! Invalid Gmail. You have " + remainingGmailAttempts + " more attempts. !!!! ");
	                remainingGmailAttempts--;
	            }
	        }
	        if (!otpSent) {
	            System.out.println("    ****    Failed to send OTP. Password reset failed.    ****    ");
	        }
	    }

	    private static String generateOTP() {
		
			return null;
		}

	    void logOut1() {
	        loggedIn = false;
	        loggedInUser = "";
	        delaySeconds(4);
	        System.out.println("    ****    Logged out successfully.    ****    ");
	    }
}
