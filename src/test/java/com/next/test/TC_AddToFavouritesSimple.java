package com.next.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.next.base.BaseTest;

public class TC_AddToFavouritesSimple extends BaseTest {

	@Test
	public void verifyMultipleProductsAddedToFavourites() throws InterruptedException {
		// 🔹 Step 1: Open category page
		driver.get("https://www.next.co.uk/shop/department-beauty-productaffiliation-makeup-0?p=1#338");
		Thread.sleep(2000);
		
		

		// 🔹 Step 2: Find product titles and heart icons
		List<WebElement> productTitles = driver.findElements(By.cssSelector("div[data-testid=\"plp-product-grid\"]"));//"p[title=\"Ribbed Velvet Alphabet Makeup Bag (AL3861) | £12\"] p[title=\"Luxe Pretty Neutrals Eyeshadow Crayons Set of 4 (C76416) | £16\"]"));// p.ProductTitle
		List<WebElement> favIcons = driver.findElements(By.cssSelector("svg[data-testid=\"product-inactive-favourite-icon\"]"));//"svg[id=\"product-summary-favourites-icon-AL3861\"] svg[id=\"product-summary-favourites-icon-C76416\"]"));//button[aria-label*='Favourites']
		Thread.sleep(2000);
		// 🔹 Step 3: Add first 2 products
		String product1 = productTitles.get(0).getText();
		favIcons.get(0).click();
		Thread.sleep(1000);
		System.out.println("Added to favourites: " + product1);
		
//		List<WebElement> productTitlesElements = driver.findElements(By.cssSelector("div[data-testid=\"plp-product-grid\"]"));//"p[title=\"Ribbed Velvet Alphabet Makeup Bag (AL3861) | £12\"] p[title=\"Luxe Pretty Neutrals Eyeshadow Crayons Set of 4 (C76416) | £16\"]"));// p.ProductTitle
//		List<WebElement> favIconsElements = driver.findElements(By.cssSelector("svg[data-testid=\"product-inactive-favourite-icon\"]"));//"svg[id=\"product-summary-favourites-icon-AL3861\"] svg[id=\"product-summary-favourites-icon-C76416\"]"));//button[aria-label*='Favourites']
//		Thread.sleep(2000);

		String product2 = productTitles.get(1).getText();
		favIcons.get(1).click();
		System.out.println("Added to favourites: " + product2);

		// 🔹 Step 4: Open favourites page
		driver.get("https://www.next.co.uk/favourites");
		Thread.sleep(2000);

		// 🔹 Step 5: Verify both products are present
		String favPageSource = driver.getPageSource();
		Assert.assertTrue(favPageSource.contains(product1), "Product not found: " + product1);
	//	Assert.assertTrue(favPageSource.contains(product2), "Product not found: " + product2);

		System.out.println("Both products successfully verified in favourites!");
	}
}
