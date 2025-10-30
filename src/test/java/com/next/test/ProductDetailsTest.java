package com.next.test;

import java.time.Duration;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import org.testng.annotations.Test;

import com.next.base.BaseTest;
import com.next.pages.ProjectObjectModel;

public class ProductDetailsTest extends BaseTest {
	
//	@Test 
//	public void verifyHomepageLoadTime() { // TC has passed 
//		long startTime = System.currentTimeMillis();
//		long loadTime = System.currentTimeMillis() - startTime;
//		System.out.println("Page Load Time: " + loadTime + "ms");
//		Assert.assertTrue(loadTime < 20000, "Homepage took too long to load!");
//	}
//	
//	
//	@Test (groups = "Regression")
//	public void verifyProductDetails() throws InterruptedException {
//		driver.get("https://www.next.co.uk/style/st080519/938040");
//		
//		ProductPage productdetail = new ProductPage(driver);
//		
//		Assert.assertTrue(productdetail.getProductName().length() > 0,"Product Name missing");
//		System.out.println("Product name is available");
//		Thread.sleep(2000);
//		Assert.assertTrue(productdetail.getProductPrice().length() > 0, "Product Price missing");
//		System.out.println("Product price is displayed");
//		Thread.sleep(2000);
//		Assert.assertTrue(productdetail.getProductDescription().length() > 0, "Product description missing");
//		System.out.println("product description is displayed");
//		Thread.sleep(2000);
//		Assert.assertTrue(productdetail.getProductSpecs().length()>0, "Product Specifictaion is missing");
//		System.out.println("product specs is displayed");
//		
//		productdetail.selectSize(2);
//		
//		Thread.sleep(2000);
//		
//		 productdetail.selectColor("Grey");  
//		 
//		 Thread.sleep(2000);
		
//	}
	
	@Test
	public void verifyAddToBagFunctionality() throws InterruptedException {

		// Step 1: Open a specific product URL
        driver.get("https://www.next.co.uk/style/st080519/938040");
        ProjectObjectModel addToBag = new ProjectObjectModel(driver);
        
     // Step 2: Select size and color (required before adding to bag)
        addToBag.selectSize(1);
        Thread.sleep(2000);
//        addToBag.selectColor("Light Blue Denim");
//        Thread.sleep(2000);
        
     // --- Step 2: Click Add to Bag ---
        addToBag.clickAddToBag();
        
     /// Step 3: Verify mini bag popup visible
        Assert.assertTrue(addToBag.isAddToBagConfirmed(), "Mini bag popup not displayed!");
        System.out.println("Mini bag popup displayed: 1 ITEM IN BAG");
        Thread.sleep(3000);

     // Step 4: Click View Bag button from popup
       addToBag.clickViewBagButton();
       Thread.sleep(3000);
        
        // --- Step 5: Verify Bag page loaded ---
        WebElement bagTitle = driver.findElement(By.cssSelector("div[class=\"shopping-bag-page-title desktop-mode\"]"));
        Assert.assertTrue(bagTitle.isDisplayed(), "Bag page not opened!");
        System.out.println("Bag page opened successfully");
        
     // --- Step 6: Verify Product present in Bag ---
        WebElement productNameInBag = driver.findElement(By.cssSelector("div.sbm-item-conent > p.sbm-item-description.line-clamp"));
        Assert.assertTrue(productNameInBag.isDisplayed(), "Product not found in bag!");
        System.out.println("Product in bag: " + productNameInBag.getText());
        
	}
	
	
	
	

	// NOTE: ek working PDP link use karo
	/*
	 * String pdpUrl = "https://www.next.co.uk/style/st123456";
	 * 
	 * @Test 
	 * public void verifyProductDetails() { driver.get(pdpUrl); ProductPage
	 * pdp = new ProductPage(driver);
	 * 
	 * Assert.assertTrue(pdp.getProductName().length() > 0, "Product name missing");
	 * Assert.assertTrue(pdp.getProductPrice().length() > 0, "Price missing");
	 * Assert.assertTrue(pdp.getProductDescription().length() > 0,
	 * "Description missing"); Assert.assertTrue(pdp.getProductSpecs().length() > 0,
	 * "Specs missing"); }
	 * 
	 * @Test public void verifyProductImagesAndZoom() { driver.get(pdpUrl);
	 * ProductPage pdp = new ProductPage(driver);
	 * 
	 * Assert.assertTrue(pdp.getImageCount() > 1, "Multiple images not found"); //
	 * zoom popup click ka code bhi add kar sakte ho agar chahiye }
	 * 
	 * @Test public void verifySizeSelectionAndAddToBag() { driver.get(pdpUrl);
	 * ProductPage pdp = new ProductPage(driver);
	 * 
	 * pdp.selectSize(1); // 2nd size select karo pdp.clickAddToBag();
	 * Assert.assertEquals(pdp.getBagCount(), "1", "Bag count not updated"); }
	 * 
	 * @Test public void verifyAddToBagWithoutSize() { driver.get(pdpUrl);
	 * ProductPage pdp = new ProductPage(driver);
	 * 
	 * // pdp.clickAddToBag(); //
	 * Assert.assertTrue(pdp.getErrorMessage().contains("Please select"),
	 * "Error not shown"); }
	 * 
	 * @Test public void verifyRelatedProductsNavigation() { driver.get(pdpUrl);
	 * ProductPage pdp = new ProductPage(driver);
	 * 
	 * // pdp.clickRelatedProduct(0);
	 * //Assert.assertTrue(driver.getCurrentUrl().contains("style"),
	 * "Related product did not redirect"); }
	 */


	
	
	
}
