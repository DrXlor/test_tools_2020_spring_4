import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;

public class Task1 {

    public static void main(String[] args) throws ParseException {

        String apiUrl = "http://api.open-notify.org/astros.json";

        Environment chromeEnv = new Environment();
        WebDriver driver = chromeEnv.getWebDriver();

        driver.get(apiUrl);
        String rawText = Utility.getElementFromPageBy(driver, "tag","pre");

        try {
            JSONObject obj = new JSONObject(rawText);

            if(obj.has("message")){
                if(!obj.get("message").toString().equals("success")){
                    System.out.println("Message is not equals success!");
                    return;
                }
            }

            JSONArray people = obj.getJSONArray("people");
            int size = people.length();

            for (int i = 0; i < size; i++){
                JSONObject astronaut = people.getJSONObject(i);
                String name = astronaut.get("name").toString();
                System.out.println(name);
            }

        }catch (JSONException err){
            System.out.println("Error"+ err.toString());
        }

        chromeEnv.destroy();
    }
}