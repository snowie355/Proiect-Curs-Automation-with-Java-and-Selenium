/*package ApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import reutilizabile.ReportGenerator;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class APITest {
    public static void main(String[] args) {

        // Ștergem raportul anterior și începem unul nou
        ReportGenerator.clearReport();
        ReportGenerator.writeToReport("Test Execution Report");
        ReportGenerator.writeToReport("========================");

        // Setăm URL-ul API-ului
        RestAssured.baseURI = "https://dummyjson.com";

        // Creăm payload-ul pentru login
        String loginPayload = "{"
                + "\"username\": \"emilys\","
                + "\"password\": \"emilyspass\","
                + "\"expiresInMins\": 30"
                + "}";

        // Facem request-ul POST pentru login
        Response loginResponse = RestAssured
                .given()
                .header("Content-Type", "application/json")  // Specificăm formatul JSON
                .header("Accept", "application/json")       // Acceptăm JSON în răspuns
                .body(loginPayload)
                .post("/auth/login");

        // Extragem răspunsul ca JSON
        String jsonResponse = loginResponse.getBody().asString();
        System.out.println("Response: " + jsonResponse); // Afișăm în consolă

        // Salvăm răspunsul în raport
        ReportGenerator.writeToReport("API Response: " + jsonResponse);

        // Parsăm răspunsul JSON
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

        // Verificăm dacă există "accessToken"
        if (jsonObject.has("accessToken")) {
            String accessToken = jsonObject.get("accessToken").getAsString();
            System.out.println("Access Token: " + accessToken);
            ReportGenerator.writeToReport("Access Token Retrieved: SUCCESS");
        } else {
            System.out.println("ERROR: accessToken not found in response!");
            ReportGenerator.writeToReport("ERROR: accessToken not found in response!");
        }

        ReportGenerator.writeToReport("Test Completed.");
    }
}
*/


package ApiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import reutilizabile.ReportGenerator;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class APITest {
    public static void main(String[] args) {

        ReportGenerator.clearReport(); // Curăță raportul API înainte de rulare
        ReportGenerator.writeToReport("Starting API Tests...");

        // Setăm URL-ul API-ului
        RestAssured.baseURI = "https://dummyjson.com";

        // Creăm payload-ul pentru login
        String loginPayload = "{"
                + "\"username\": \"emilys\","
                + "\"password\": \"emilyspass\","
                + "\"expiresInMins\": 30"
                + "}";

        // Facem request-ul POST pentru login
        Response loginResponse = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(loginPayload)
                .post("/auth/login");

        // Extragem răspunsul ca JSON
        String jsonResponse = loginResponse.getBody().asString();
        ReportGenerator.writeToReport("API Response: " + jsonResponse);

        // Parsăm răspunsul JSON
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

        // Verificăm dacă există "accessToken"
        if (jsonObject.has("accessToken")) {
            @SuppressWarnings("unused")
            String accessToken = jsonObject.get("accessToken").getAsString();
            ReportGenerator.writeToReport("API Test Passed: Access Token received.");
        } else {
            ReportGenerator.writeToReport("ERROR: accessToken not found in response!");
        }
    }
}



