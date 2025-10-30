package com.next.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.next.base.BaseTest;
import com.next.test.ProductDetailsTest;

public class ProjectObjectModel {
	 WebDriver driver;
	 
	 public ProjectObjectModel(WebDriver driver) {
		this.driver = driver;
	}

	    // Methods to get text
	    public String getProductName() {
	        return driver.findElement(By.cssSelector("h1[data-testid=\"product-title\"]")).getText();
	    }

	    public String getProductPrice() {
	        return driver.findElement(By.cssSelector("div[data-testid=\"product-now-price\"] span")).getText();
	    }

	    public String getProductDescription() {
	        return driver.findElement(By.cssSelector("div[class=\"MuiGrid-root MuiGrid-container pdp-css-1nssz9m\"]")).getText();
	    }

		
		 public String getProductSpecs() { 
			return driver.findElement(By.cssSelector("div[class=\"PDP-CSSA\"]")).getText(); 
		 }
		

	
	
	
	 
//    public int getImageCount() {
//        return driver.findElements(By.cssSelector("img[data-testid=\"superzoom-image\"]")).size();
//    }
//
      public void selectSize(int index) {
		    
		    WebElement dropdown = driver.findElement(By.cssSelector("div[data-testid=\"size-select\"]"));
		    dropdown.click();

		    
		    List<WebElement> sizes = driver.findElements(By.cssSelector("li[class=\"MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters pdp-css-1c3bdib\"]"));

		    
		    if (sizes.size() > index) {
		        sizes.get(index).click();  //select the size by index
		        System.out.println("Selected size: " + sizes.get(index).getText());
		    } else {
		        System.out.println("Invalid index Size not found.");
		    }
		}
      
      
      public void selectColor(String colorName) throws InterruptedException {
    	  
    	  WebElement dropdown = driver.findElement(By.cssSelector("div[data-testid=\"colour-select\"]"));
    	  dropdown.click();
    	  Thread.sleep(2000);
    	  
    	  List<WebElement> colors = driver.findElements(By.cssSelector("li[class=\"MuiList-root MuiList-padding MuiMenu-list pdp-css-r8u8y9\"]"));
    	    
    	  
    	  
    	  for (WebElement color : colors) {
    	        String colorText = color.getText().trim(); // visible text (ex: "Natural", "Grey", etc)
    	        if (colorText.equalsIgnoreCase(colorName)) {
    	            color.click();
    	            System.out.println("Selected color: " + colorText);
    	            return;
    	        }
    	    }

    	    System.out.println("Color not found: " + colorName);
    	    
//    	  if (colors.size() > index) {
//    	        WebElement selectedColor = colors.get(index);
//    	        String colorName = selectedColor.getText();
//    	        selectedColor.click();
//    	        System.out.println("Selected color: " + colorName);
//    	    } else {
//    	        System.out.println("Invalid index Color not found. Total colors: " + colors.size());
//    	    }
      }
//
//    
//
//    public void clickAddToBag() {
//        driver.findElement(By.cssSelector("button[data-testid='item-form-addToBag-button']")).click();
//    }
//
//    public String getBagCount() {
//        return driver.findElement(By.cssSelector("div[data-testid='header-shopping-bag']")).getText();
//    }
//
//    /*public String getErrorMessage() {
//        return driver.findElement(errorMsg).getText();
//    }
//
//    public void clickRelatedProduct(int index) {
//        driver.findElements(relatedProducts).get(index).click();
//    }*/
      
      public void clickAddToBag() throws InterruptedException {
    	  WebElement addToBagBtn = driver.findElement(By.cssSelector("button[data-testid=\"item-form-addToBag-button\"]"));
          addToBagBtn.click();
          System.out.println("🛒 Clicked on Add to Bag button");
          Thread.sleep(1500);

	}
      
   // --- Check if Add to Bag confirmation visible ---
      public boolean isAddToBagConfirmed() {
    	    try {
    	        // ✅ CSS selector for the bag popup heading (1 ITEM IN BAG)
    	        WebElement popupHeader = driver.findElement(By.cssSelector("div[data-testid=\"header-mini-shopping-bag-item-count\"]"));
    	        return popupHeader.isDisplayed();
    	    } catch (Exception e) {
    	        return false;
    	    }
    	}
      
      // --- Click on Bag icon ---
      public void clickBagIcon() throws InterruptedException {
          WebElement bagIcon = driver.findElement(By.cssSelector("a[data-testid=\"shopping-bag-link-button\"]"));
          bagIcon.click();
          System.out.println("Clicked on Bag icon");
          Thread.sleep(2000);
      }
      
      // --- Click on View bag button ---
      public void clickViewBagButton() {
		WebElement viewBagButton = driver.findElement(By.cssSelector("div[class=\"header-9ay3le\"]"));
		viewBagButton.click();
		System.out.println("Clicked on View bag button");

	}
      
//      public void bagTitle() {
//		WebElement pageLoad = driver.findElement(By.cssSelector("div[class=\"shopping-bag-page-title desktop-mode\"]"));
//		System.out.println("Bag page opened successfully :"+pageLoad);
//    	  
//	}
      
      //Login functionlity 
      
      
      public void clickOnSignInButton() {
  		WebElement signInButton = driver
  				.findElement(By.cssSelector("div[class=\"cdebb54bf\"] button"));
  		signInButton.click();
  		System.out.println("Clicked on sign In Button button");
  	}

  	public void clickOnEmailField() {
  		// Email input field
  		WebElement emailField = driver.findElement(By.cssSelector("input[id='username']"));
  		emailField.sendKeys("sayalihtpatil95@gmail.com");
  		System.out.println("Entered in Email Feild");
  	}
  	public void clickOnPasswordFeild() {
  		// Password input field
  	    WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
  	    passwordField.sendKeys("SayaliMatle1");
  	    System.out.println("Password Entered successfully");
  	}
  	public void showPasswordButton() {
  		// password show button
  	    driver.findElement(By.cssSelector("a[id=\"showPasswordButton\"]")).click();
  	    System.out.println("clicked successfully on show password button");
  	}
  	
}
