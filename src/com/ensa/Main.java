package com.ensa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


// 2 
// ce code permet à l'utilisateur de s'authentifier et de créer sa demande

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5173/login");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        Thread.sleep(500);
        WebElement inputEmail = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        inputEmail.sendKeys("pfaproject2023@gmail.com");
        Thread.sleep(500);
        
        WebElement inputPasswd = driver.findElement(By.xpath("//input[@id='passwdInput']"));
        inputPasswd.sendKeys("123456789");
        Thread.sleep(1000);


        WebElement ButtonLogin = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/button[1]"));
        ButtonLogin.click();
        Thread.sleep(4000);
   
        WebElement ButtonProfile = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/a[1]/*[1]"));
        ButtonProfile.click();
        
        Thread.sleep(2000);
        scrollToEnd(driver);
        
        WebElement scrollableElement = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]/div[2]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(scrollableElement)
                .sendKeys(Keys.ARROW_LEFT)
                .build()
                .perform();
        
        Thread.sleep(1000);
        WebElement ajouterDemande = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]/div[2]/div[5]/a[1]/div[1]"));
        ajouterDemande.click();
        
        Thread.sleep(1000);
        WebElement sectionInput = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        sectionInput.sendKeys("Section1AGA");
        Thread.sleep(500);
        
        WebElement numInput  = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[2]/div[1]/form[1]/div[1]/div[2]/input[1]"));
        numInput.sendKeys("27S11T");
        Thread.sleep(500);
        
        WebElement dateInput  = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[2]/div[1]/form[1]/div[2]/div[1]/input[1]"));
        dateInput.sendKeys("22/08/2024");
        Thread.sleep(500);
        
        WebElement durreeInput = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[2]/div[1]/form[1]/div[2]/div[2]/input[1]"));
        durreeInput.sendKeys("13");
        Thread.sleep(500);
        
        WebElement localisationInput = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[2]/div[1]/form[1]/div[3]/div[1]/textarea[1]"));
        localisationInput.sendKeys("Rdc imm r19 I12 mo1 agadir bay, Agadir 80000, Agadir 80000");
        Thread.sleep(500);
        
        WebElement objetInput = driver.findElement(By.xpath("//input[@id='browser1']"));
        objetInput.sendKeys("travaux en limite du domaine public");
        Thread.sleep(1000);
        objetInput.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        
        WebElement modaliteInput = driver.findElement(By.xpath("//input[@id='browser2']"));
        modaliteInput.sendKeys("Route barré");
        Thread.sleep(1000);
        modaliteInput.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		String filePath = "C:\\Users\\ylach\\Desktop\\cours\\TP_Qazdar\\planOeuvrage.pdf";
		fileInput.sendKeys(filePath);
		Thread.sleep(1000);

		 
	    WebElement ButtonCreate = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[2]/div[2]/form[1]/div[7]"));
	    ButtonCreate.click();
	    Thread.sleep(2000);
	    Number initialScrollPosition;
	    initialScrollPosition = (Number) js.executeScript("return window.scrollY;");
	    js.executeScript("window.scrollBy(0,-"+initialScrollPosition+");");
	    Thread.sleep(2000);
	    
	    WebElement ButtonSave = driver.findElement(By.xpath("//button[contains(text(),'Enregistrer')]"));
	    ButtonSave.click();
	    Thread.sleep(3000);

	    WebElement ButtonDetails = driver.findElement(By.xpath("//button[@id='27S11T']"));
	    ButtonDetails.click();
	    Thread.sleep(3000);
	    WebElement ButtonShow = driver.findElement(By.xpath("//button[@id='show_27S11T']"));
	    ButtonShow.click();
	    Thread.sleep(3000);
	    WebElement ButtonCloseDetails = driver.findElement(By.xpath("//button[contains(text(),'X')]"));
	    ButtonCloseDetails.click();
		Thread.sleep(3000);
		 WebElement ButtonLogOut = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/p[1]"));
		 ButtonLogOut.click();
		 
		  Thread.sleep(2000);
	        driver.close();
    }
    
    // Method to scroll to the end of the page
    private static void scrollToEnd(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Number initialScrollPosition, currentScrollPosition;

        do {
            initialScrollPosition = (Number) js.executeScript("return window.scrollY;");
            js.executeScript("window.scrollBy(0, 200);");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentScrollPosition = (Number) js.executeScript("return window.scrollY;");

        } while (currentScrollPosition.doubleValue() > initialScrollPosition.doubleValue());

        js.executeScript("window.scrollBy(0, -" + initialScrollPosition.doubleValue() + ");");
    }
    
}
