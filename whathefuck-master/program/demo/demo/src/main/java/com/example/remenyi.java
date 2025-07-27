package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class remenyi {
    public static String identifierRM(String SKU, int sep){
String price = "not found";
if(sep ==1 ){
    int[]input = {10,10}; //second one is 0 so it can be index of placeholder   CHARACTER, SIZEID
  String[] character = {"131","132A","32","33","29","30"}; //A,DS,DA,G,E,EW THIS IS AN ISSUE
 String [] sizeid = {"1/2","3/4","1"}; //largest to smallest if largest then size id remains DOM, placeholder = full
 int[] result = Soundpost.determineroute(character, sizeid, input, SKU);
 price = scrapeRM(1, result);

 // again, find the route

} 
else if(sep == 2){
    int[]input = {10,10};
  String [] sizeid = {"04", "0334","0314", "03",}; //4/4 gold, 1/2, 3/4, 4/4 normal              
String[] character = {"A","D","G","E"};
int[] result = Soundpost.determineroute(character, sizeid, input, SKU);
System.out.println(result[0]+"and"+result[1]);
price = scrapeRM(2, result);
}

 else if(sep == 3){
int[]input = {10,10};
String[] character = {"GE","PE","SD","A","D","G","E"}; //Gold Steel E, plat E,silver d,A,D, G,  E
String[] sizeid = {"7"};// full


    int[] result = Soundpost.determineroute(character,sizeid, input, SKU);
price = scrapeRM(3, result);

} 



return price;

    }

public static String scrapeRM(int pathway, int[] input) {
    WebDriver driver= new ChromeDriver();
    String last = "Not found";
    String EXPENSIVE = "210000022777";
if(pathway == 1){

//https://remenyi.com/#4a75/fullscreen/m=and&q=
// class: dfd-card-price
// small -> large
//A,DS,DA,G,E,EW
String[][] productlist = {{"41414766526507",EXPENSIVE,"40833744601131"},
                            {EXPENSIVE,EXPENSIVE,"41413655920683"},
                            {EXPENSIVE,EXPENSIVE,EXPENSIVE},
                            {"41414766624811",EXPENSIVE,"40833744568363"},
                            {"41414766460971",EXPENSIVE,"40833744633899"},
                            {EXPENSIVE,EXPENSIVE,EXPENSIVE}};


driver.get("https://remenyi.com/#4a75/fullscreen/m=and&q="+productlist[input[0]][input[1]]);


      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      WebElement shadowContent = driver.findElement(By.className("dfd-card-price"));
      last = shadowContent.getText();


}

if(pathway == 2){
    // ADG,EGBALLsilvers
//AALUM,DS,GG,EBALL,Gsilver
//FullG, half, 3/4, full
String[][] productcodesnongold = {{"210000054381","210000054381","210000054381","210000054381"},
                                    {"210000054865","210000054865","210000054865","210000054865"},
                                    {"14476008718379","14476008718379","14476008718379","14476008718379"},
                                    {EXPENSIVE,EXPENSIVE,EXPENSIVE,EXPENSIVE}};

      String[] productcodesgold = {"210000054538","210000054834","210000054399","210000054555","210000054806"};
if(input[1] == 0){
          driver.get("https://remenyi.com/#4a75/fullscreen/m=and&q="+productcodesgold[input[0]]); //use the first number to decide product code
         
        }else{
              driver.get("https://remenyi.com/#4a75/fullscreen/m=and&q="+productcodesnongold[input[0]][input[1]]);

          }

           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      WebElement shadowContent = driver.findElement(By.className("dfd-card-price"));
      last = shadowContent.getText();

}

else if(pathway == 3){ // for PI

String[][] productcodes = {{"41414795231275"},{"41414794870827"},{"41414794936363"},{"41414794903595"},{"41414795034667"},{"41414794969131"},{"41414795001899"}}; //Gold Steel E, plat E,silver d,A,D, G (Presumed silver?),  E

driver.get("https://remenyi.com/#4a75/fullscreen/m=and&q="+productcodes[input[0]][input[1]]);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement shadowContent = driver.findElement(By.id("product-regular-price"));
      last = shadowContent.getText();
}

driver.quit();
return  last;
}




}
