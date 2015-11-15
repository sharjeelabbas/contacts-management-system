package com.cms.utils;

public class CMS_Utilities { 
	
	/*** Validating IndexSrvlet url ***/
	public static boolean isValidIndexUrl(String url){
		boolean is = false;		
		String[] validUrls = {"/auth", "/about-us", "/contact-us"};
		
		for (int i=0; i<validUrls.length; i++){
			if (url.equals(validUrls[i])){
				is = true;
				break;
			}
		}		
		return is;
	}
	
	/*** Validating UserSrvlet url ***/
	public static boolean isValidUsersUrl(String url){
		boolean is = false;		
		String[] validUrls = {"/signIn", "/signOut", "/signUp", "/forgotPassword"};
		
		for (int i=0; i<validUrls.length; i++){
			if (url.equals(validUrls[i])){
				is = true;
				break;
			}
		}		
		return is;
	}
	
	/*** Validating ContactSrvlet url ***/
	public static boolean isValidContactsUrl(String url){
		boolean is = false;		
		String[] validUrls = {"/addContact", "/editContact", "/removeContact", "/getContactById", "/listContacts"};
		
		for (int i=0; i<validUrls.length; i++){
			if (url.equals(validUrls[i])){
				is = true;
				break;
			}
		}		
		return is;
	}
}
