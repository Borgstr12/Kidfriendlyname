package com.example;
import java.time.Duration;
import java.util.Locale;
import java.text.NumberFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class longingmclongquade {
public static String identifierLM(String SKU, int sep){
    String price = "Not found";
if(sep ==1 ){
    int[]input = {10,10}; //second one is 0 so it can be index of placeholder   CHARACTER, SIZEID
  String[] character = {"131","32A","32","33","29","30"}; //A,DS,DA,G,E,EW
 String [] sizeid = {"1/2","3/4","1"}; //largest to smallest if largest then size id remains DOM, placeholder = full
 int[] result = Soundpost.determineroute(character, sizeid, input, SKU);
 price = scrapeLM(1, result,SKU);

 // again, find the route

} 
else if(sep == 2){
    int[]input = {10,10};
  if(SKU.contains("04")){

String [] sizeid = {"04"};             
String[] character = {"A","D","GS","G","E"}; //A,D,GS,G,E
int[] newroute = Soundpost.determineroute(character, sizeid, input, SKU);
price = scrapeLM(2,newroute,SKU);
} else{

      String [] sizeid = { "0334","0314", "03"}; // 1/2, 3/4, 4/4 normal              
String[] character = {"A","D","G","ESL","ESB","EGL","EGB","EP","E"};
int[] newroute = Soundpost.determineroute(character, sizeid, input, SKU);
price = scrapeLM(2,newroute,SKU);
}
}
else if(sep == 3){
int[]input = {10,10};
String[] character = {"GE","PE","SD","A","D","G","E"}; //Gold Steel E, plat E,silver d,A,D, G,  E
String[] sizeid = {"7"};// full


    int[] result = Soundpost.determineroute(character,sizeid, input, SKU);
price = scrapeLM(3, result,SKU);

}

   


return price; 
}
public static String scrapeLM(int pathway, int[] input,String SKU) {
    String EXPENSIVE = "322021";

WebDriver driver = new ChromeDriver();
String last = "not found";
if(pathway ==1){
    //A,DS,DA,G,E,EW| DS assumed to be DA
    // increasing in size
String[][] productlist = {{"72476","72451","922"},{"72475","72450","72435"},{"72475","72450","72435"},{"138060","72448","72425"},{"72474","72449","72430"},{EXPENSIVE,EXPENSIVE,"931"}};

System.out.println(input[0]+"and"+input[1]);

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.long-mcquade.com/"+productlist[input[0]][input[1]]);

WebElement shadowContent = driver.findElement(By.id("product-regular-price"));
      
last = shadowContent.getText();



} else if(pathway ==2){
// ADG,EGBALLsilvers
//AALUM,DS,GG,EBALL,Gsilver


      String[][] productcodesnongold = {{EXPENSIVE,EXPENSIVE,"903"},{"358216","358216",EXPENSIVE},{EXPENSIVE,EXPENSIVE,EXPENSIVE},{EXPENSIVE,EXPENSIVE,EXPENSIVE},{EXPENSIVE,EXPENSIVE,EXPENSIVE},{EXPENSIVE,EXPENSIVE,EXPENSIVE},{EXPENSIVE,EXPENSIVE,"185020"},{EXPENSIVE,EXPENSIVE,"93741"},{EXPENSIVE,EXPENSIVE,"325691"}};
      String[] productcodesgold = {"396520",EXPENSIVE,EXPENSIVE,EXPENSIVE,EXPENSIVE};
// A,D,G,ESL,ESB,EGL,EGB,platnum,E
//AALUM,DS,Gsilver,GG,EBALL

          if(SKU.contains("04")){
          driver.get("https://www.long-mcquade.com/"+productcodesgold[input[0]]); //use the first number to decide product code
          }else{
              driver.get("https://www.long-mcquade.com/"+productcodesnongold[input[0]][input[1]]);

          }
    //last = Soundpost.getelementbyCSS("#product-regular-price");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    WebElement shadowContent = driver.findElement(By.id("product-regular-price"));
      last = shadowContent.getText();
} else if(pathway == 3){ // for PI

String[][] productcodes = {{"72409"},{"72320"},{"72410"},{"72412"},{"72411"},{"72405"},{"72407"}}; //Gold Steel E, plat E,silver d,A,D, G,  E

driver.get("https://www.long-mcquade.com/"+productcodes[input[0]][input[1]]);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement shadowContent = driver.findElement(By.id("product-regular-price"));
      last = shadowContent.getText();
}



driver.quit();

return last;

}
}
