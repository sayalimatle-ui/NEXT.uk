package com.next.errors;

public class InvalidBrowserNameError extends Error{
    private String browserName;
    
    public InvalidBrowserNameError(String browserName) {
    	this.browserName = browserName;

	}
	
    @Override
    public String getMessage() {
    	
    	return "Invalid browser name provided in testng.xml :"+browserName;
    }
	
}
