import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.Soundpost;

public class Heinl {


    public static String identifierHN(String SKU, int sep){
String price = "not found";
if(sep ==1 ){
    int[]input = {10,10}; //second one is 0 so it can be index of placeholder   CHARACTER, SIZEID
  String[] character = {"131","132A","32","33","29","30"}; //A,DS,DA,G,E,EW THIS IS AN ISSUE
 String [] sizeid = {"1/2","3/4","1"}; //largest to smallest if largest then size id remains DOM, placeholder = full
 int[] result = Soundpost.determineroute(character, sizeid, input, SKU);
 price = scrapeHN(1, result);

 // again, find the route

} 
else if(sep == 2){
    int[]input = {10,10};
  String [] sizeid = {"04", "0334","0314", "03",}; //4/4 gold, 1/2, 3/4, 4/4 normal              
String[] character = {"A","D","G","E"};
int[] result = Soundpost.determineroute(character, sizeid, input, SKU);
System.out.println(result[0]+"and"+result[1]);
price = scrapeHN(2, result);
}

 else if(sep == 3){
int[]input = {10,10};
String[] character = {"GE","PE","SD","A","D","G","E"}; //Gold Steel E, plat E,silver d,A,D, G,  E
String[] sizeid = {"7"};// full


    int[] result = Soundpost.determineroute(character,sizeid, input, SKU);
price = scrapeHN(3, result);

} 



return price;


    }

    public static String scrapeHN(int pathway, int[] input) {

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
// ADG,EGBALLsilvers
//AALUM,DS,GG,EBALL,Gsilver


      String[][] productcodesnongold = {{"31005801807950","31005801807950","31005801807950","31005801807950"},{"31005801840718","31005801840718","31005801840718","31005801840718"},{"31005801873486","31005801873486","31005801873486","31005801873486"},{"31005801971790","31005801971790SEP113","31005801971790","31005801971790"}};
      String[] productcodesgold = {"31045317197902","31045320376398","31045330108494","31045336006734","31045325586510"};

        if(input[1] == 0){
          driver.get("https://www.georgeheinl.com/collections/violin-strings/products/evah-pirazzi-gold-violin-set?variant="+productcodesgold[input[0]]); //use the first number to decide product code
          }else{
              driver.get("https://www.georgeheinl.com/collections/violin-strings/products/evah-pirazzi-violin-set?variant="+productcodesnongold[input[0]][input[1]]);

          }

      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      WebElement shadowContent = driver.findElement(By.className("product__price h2--number"));
      last = shadowContent.getText();
System.out.println(last);

   }

      else if(pathway == 3){
//Gold Steel E, plat E,silver d,A,D,  G, E
// full
String[][] productcodes = {{"31357995810894"},{"31357995843662"},{"31357995974734"},{"31357995909198"},{"31357995941966"},{"31358396170318"},{"31357995876430"}}; // this is troubling..
driver.get("https://www.thesoundpost.com/en/product/search?keywords="+productcodes[input[0]][input[1]]+"&submitted=1");

      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      WebElement shadowContent = driver.findElement(By.className("product__price h2--number")); // idek if this works check later
      last = shadowContent.getText();



        }
driver.quit();
return last;
    }
}
