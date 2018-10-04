package com.ust.pdfglue;

import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PdfGlueCode {
	
	public static WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("plugins.always_open_pdf_externally", true);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		driver = new ChromeDriver(options);
		driver.get("https://www.princexml.com/samples/");
		
		
		
	}
	
	@After
	public void teardown() {
		if(driver != null) {
			driver.close();
		}
	}
	
	@Given("^I am on the sample document page$")
	public void i_am_on_the_sample_document_page() throws Throwable {
	    assertEquals("https://www.princexml.com/samples/", driver.getCurrentUrl());
	}

	@When("^I click the textbook pdf link$")
	public void i_click_the_textbook_pdf_link() throws Throwable {
	    driver.findElement(By.xpath("//*[@id=\"textbook\"]/p[2]/a[2]")).click();
	}

	@Then("^The pdf file is displayed in the window$")
	public void the_pdf_file_is_displayed_in_the_window() throws Throwable {
	    assertEquals("http://css4.pub/2015/textbook/somatosensory.pdf", driver.getCurrentUrl());
	}
	
	@When("^I am on the textbook pdf$")
	public void i_am_on_the_textbook_pdf() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"textbook\"]/p[2]/a[2]")).click();
		Thread.sleep(3000);
//		assertEquals("http://css4.pub/2015/textbook/somatosensory.pdf", driver.getCurrentUrl());		
	}

	@Then("^I see the word cutaneous on the first page$")
	public void i_see_the_word_cutaneous_on_the_first_page() throws Throwable {		
		boolean flag = pdfString(1, 1, "cutaneous", "C:\\Users\\Vlad\\Downloads\\somatosensory.pdf");
	    
	    Assert.assertTrue(flag);
	}
	
	@Given("^I am on the prince xml page$")
	public void i_am_on_the_prince_xml_page() throws Throwable {
	    assertEquals("https://www.princexml.com/samples/", driver.getCurrentUrl());
	}

	@When("^I click the dictionary pdf$")
	public void i_click_the_dictionary_pdf() throws Throwable {
	    driver.findElement(By.xpath("//*[@id=\"dictionary\"]/p[2]/a[2]")).click();
	}

	@Then("^I should see fonts by monokrom$")
	public void i_should_see_fonts_by_monokrom() throws Throwable {		
		boolean flag = pdfString(1, 1, "Fonts by Monokrom","");
		
		Assert.assertTrue(flag);
	}
	
	@Then("^I should see formatting by prince$")
	public void i_should_see_formatting_by_prince() throws Throwable {		
		boolean flag = pdfStringByLocation(0, "Formatting by Prince", 10, 325, 600, 140);
		
		Assert.assertTrue(flag);
	}
	
	private boolean pdfString(int start, int end, String phrase, String path) {
		boolean phraseFound = false;
		RandomAccessBufferedFileInputStream fis;
		
		try {
			PDFTextStripper stripper = new PDFTextStripper();
		    stripper.setStartPage(start);
		    stripper.setEndPage(end);
		    
		    if(path.equals("")) {
		    	URL url = new URL(driver.getCurrentUrl());
		    	fis = new RandomAccessBufferedFileInputStream(url.openStream());
		    }
		    else {
		    	File file = new File(path);	
		    	fis = new RandomAccessBufferedFileInputStream(file);
		    } 
		    
		    PDFParser testPDF = new PDFParser(fis);
		    testPDF.parse();
		    String text = stripper.getText(testPDF.getPDDocument());
		    
		    if(text.contains(phrase)) {
		    	phraseFound = true;
		    }		    
		}
		catch(IOException e) {
			e.printStackTrace();
		}			
		return phraseFound;
	}
	
	private boolean pdfStringByLocation(int page, String phrase, int x, int y, int width, int height)  {
		boolean phraseFound = false;
		
		try {
			URL url = new URL(driver.getCurrentUrl());
		    BufferedInputStream pdf = new BufferedInputStream(url.openStream());
		    PDDocument document = PDDocument.load(pdf);
		    
		    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
		    stripper.setSortByPosition(true);
		    Rectangle rect = new Rectangle(x, y, width, height);
		    stripper.addRegion("target", rect);
		    PDPage firstPage = document.getPage(page);
		    stripper.extractRegions(firstPage);
		    String extractedText = stripper.getTextForRegion("target").trim();
		    
		    System.out.println("Text in the area " + rect);
		    System.out.println(extractedText);
		    
		    if(extractedText.equals(phrase)) {
		    	phraseFound = true;
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}				
		return phraseFound;
	}
}
