package com.example;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.lang.Object;
public class GSpreadsheets {
public static Sheets sheetservice; 
private static String name = "SCRAPPER";
public static String SPREADSHEETID = "1V3Zgb_b53JgiN9OdHKGCLSEVV4tfjmN1zpJo40AOYtk";



static List<String>  scope = Arrays.asList(SheetsScopes.SPREADSHEETS);
         private static String CREDENTIALS_FILE_PATH = "credentialsIS.json";

 public static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
      throws IOException{
    // Load client secrets.
    InputStream in = GSpreadsheets.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
   if (in == null) {
      throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
    }
    GoogleClientSecrets clientSecrets =
        GoogleClientSecrets.load(GsonFactory.getDefaultInstance(), new InputStreamReader(in));

        
// GoogleNetHttpTransport.newTrustedTransport()
    // Build flow and trigger user authorization request.
    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
        HTTP_TRANSPORT, GsonFactory.getDefaultInstance(), clientSecrets, scope)
        .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
        .setAccessType("offline")
        .build();
    LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
    return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
  }



// 1 for sound, 2 for long

public static void printstuff(String subsheet, String scope, int store, int brand) throws IOException, GeneralSecurityException{

 NetHttpTransport httpstuff =  GoogleNetHttpTransport.newTrustedTransport();


        Sheets service = new Sheets.Builder(httpstuff, GsonFactory.getDefaultInstance(), getCredentials(httpstuff))
            .setApplicationName("scrape")
            .build();

String range = subsheet+"!"+scope; //format is SUBTITLE!MINRANGE:MAXRANGE


    List<List<Object>> words = service.spreadsheets().values().get(SPREADSHEETID, range).execute().getValues();



             if (store == 1) {                                                                                                  //Im using shitton of if statements cuz idk what lamdas are and I dont wanna make objects
     for(int x = 0; x<words.size(); x++){
 ValueRange myIntegerList = new ValueRange().setValues(Arrays.asList(Arrays.asList(Soundpost.identifierSP(words.get(x).toString(),brand))));

UpdateValuesResponse updating = service.spreadsheets().values().update(SPREADSHEETID, "J"+Integer.toString(x+2), myIntegerList).setValueInputOption("USER_ENTERED").execute();
      
      }
} // this one is for printing soundpost

 else if(store == 2){
  for(int x = 0; x<words.size(); x++){ // loops through a set from A2-A10 or something
ValueRange myIntegerList = new ValueRange().setValues(Arrays.asList(Arrays.asList(longingmclongquade.identifierLM(words.get(x).toString(),brand)))); // add a return value to longmcquade

UpdateValuesResponse updating = service.spreadsheets().values().update(SPREADSHEETID, "K"+Integer.toString(x+2), myIntegerList).setValueInputOption("USER_ENTERED").execute();

 }
 }

 else if(store == 3){
  for(int x = 0; x<words.size(); x++){ // loops through a set from A2-A10 or something
ValueRange myIntegerList = new ValueRange().setValues(Arrays.asList(Arrays.asList(remenyi.identifierRM(words.get(x).toString(),brand)))); // add a return value to longmcquade

UpdateValuesResponse updating = service.spreadsheets().values().update(SPREADSHEETID, "L"+Integer.toString(x+2), myIntegerList).setValueInputOption("USER_ENTERED").execute();

 }
 }
}



        /* Load pre-authorized user credentials from the environment.
           TODO(developer) - See https://developers.google.com/identity for
            guides on implementing OAuth2 for your application. */
   

    // Create the sheets API client
  
}



  
