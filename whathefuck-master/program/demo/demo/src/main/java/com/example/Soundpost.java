package com.example;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Soundpost {
public static String identifierSP(String SKU,int sep){

        
      // get last char in sku
      //for loop for size
String returnvalue ="";
      


if(sep == 1){
int[]input = {10,10};
String[] character = {"131","32A","32","33","29","30"}; //A,DS,DA,G,E,EW
 String [] sizeid = {"1/2","3/4","1"}; //small -> large

    int[] newroute = determineroute(character, sizeid, input, SKU);
   returnvalue = scrapeSP(1,newroute,SKU);
}

      if(sep== 2) {

int[]input = {10,10};


if(SKU.contains("04")){

String [] sizeid = {"04"};             
String[] character = {"A","D","GS","G","E"}; //A,D,GS,G,E
int[] newroute = determineroute(character, sizeid, input, SKU);
returnvalue = scrapeSP(2,newroute,SKU);
} else{

      String [] sizeid = { "0334","0314", "03"}; // 1/2, 3/4, 4/4 normal              
String[] character = {"A","D","G","ESL","ESB","EGL","EGB","EP","E"};
int[] newroute = determineroute(character, sizeid, input, SKU);
returnvalue = scrapeSP(2,newroute,SKU);


}
      
                                                                                        //EP

} 
//-----------------------------------------------------------------------



else if(sep == 3){ // Thomas IngField
int[]input = {10,0};
String[] character = {"GE","PE","SD","A","D","G","E"}; //Gold Steel E, plat E,silver d,A,D, G,  E
String[] sizeid = {"7"};// full


    int[] newroute = determineroute(character,sizeid, input, SKU);
   returnvalue = scrapeSP(3,newroute,SKU);
}
   

return returnvalue;


}



      


      public static int[] determineroute(String[] keys, String[] sizeid, int[] input, String SKU){

        int[] identical = input;
  for(int x =0; x<=sizeid.length-1; x++){
  if(SKU.contains(sizeid[x])){
      System.out.println(SKU+" contains "+sizeid[x]);
identical[1] =x;
                                                     // for the size
  } 
  if(identical[1]!= 10){            //if solution found
    break;
  }
 
  
                                // for the key
}

for(int x =0; x<=keys.length-1; x++){
  if(SKU.contains(keys[x])){
identical[0] = x;

  } if(identical[0]!= 10){            //if solution found
    break;
  }

}

return identical;

      }

// Subsheet, input
       public static String scrapeSP(int pathway, int[] input, String SKU) {
//System.setProperty("webdriver.chrome.driver","C:\\Users\\info\\Desktop\\demo\\demo\\src\\drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
 WebDriver driver= new ChromeDriver();
    
String last ="Not found";
if(pathway == 1){
//A,DS,DA,G,Steel E, would E, 
// small -> large
String[][] productcodes = {{"SD122", "SD123","SD124S"},{"PLACEHOLDER","PLACEHOLDER","SD15BULK"},{"SD142","SD143","SD144S"},{"SD162","SD163","SD164S"},{"SD112","SD113","SD114SL"},{"SD102","SD103","SD10ML"}};
driver.get("https://www.thesoundpost.com/en/product/search?keywords="+productcodes[input[0]][input[1]]+"&submitted=1");


      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      WebElement shadowContent = driver.findElement(By.cssSelector("div[class='product_row'] div:nth-child(1)"));
      last = shadowContent.getText();




      }
    else if (pathway == 2){                       
// A,D,G,ESL,ESB,EGL,EGB,platnum,E
//AALUM,DS,Gsilver,GG,EBALL
String DNE = "SBH06X3";

      String[][] productcodesnongold = {{"SEP123","SEP121","SEP12H"},{"SEP153","SEP151","SEP15H"},{"SEP163","SEP161","SEP16H"},{DNE,DNE,DNE},{DNE,DNE,DNE},{DNE,DNE,"SEP10MB"},{DNE,DNE,"SEP10ML"},{DNE,DNE,"SEP11HPB"},{"SEP113","SEP111","SEP11HB"}};
      String[] productcodesgold = {"SEPG12","SEPG15","SEPG16","SEPG17","SEPG11B",};

        if(SKU.contains("04")){
          driver.get("https://www.thesoundpost.com/en/product/search?keywords="+productcodesgold[input[0]]+"&submitted=1"); //use the first number to decide product code
          }else{
              driver.get("https://www.thesoundpost.com/en/product/search?keywords="+productcodesnongold[input[0]][input[1]]+"&submitted=1");

          }

      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      WebElement shadowContent = driver.findElement(By.cssSelector("div[class='product_row'] div:nth-child(1)"));
      last = shadowContent.getText();
System.out.println(last);

   }

      else if(pathway == 3){
//Gold Steel E, plat E,silver d,A,D,  G, 
// full
String[][] productcodes = {{"SPI10"},{"SPI11P"},{"SPI15"},{"SPI12"},{"SPI14"},{"SPI16"},{"Peter Infeld Violin String Tin E"}}; // this is troubling..
driver.get("https://www.thesoundpost.com/en/product/search?keywords="+productcodes[input[0]][input[1]]+"&submitted=1");

      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      WebElement shadowContent = driver.findElement(By.cssSelector("div[class='product_row'] div:nth-child(1)"));
      last = shadowContent.getText();



        }
        
driver.quit();
      return last;  





 }
}
