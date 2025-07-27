package com.example;
import static com.example.GSpreadsheets.getCredentials;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
// 1 = Sounpost, 2 = Long, 3 = remenyi
// 1 = Dom, 2 = EP, 3= PI

public class Main extends GSpreadsheets  {
       public static void main(String[] args) throws IOException, GeneralSecurityException  {

        
       
  printstuff("EP","A3:A17",3,2);
//longingmclongquade.identifierLM("129",1);
 //System.out.println(identifierSP("1293/4",2));

    }




// requires an answer always
   


        
	 // Only selects first result, may need to double check
      // to toggle outfit just write outfit

   

    




  
   



 


      

 

}
