package com.example.froyvalencia.myapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

//package com.example.johannes.hack;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class Scanner extends AppCompatActivity {


    public static HashMap<String, Integer> iMap = new HashMap();


    public String grading(String ingredients) {
        Integer gradeInt = 0;
        Integer tempInt = 0;
        String[] procAr = ingredients.replaceAll("^[,\\s]+", "").split("[,\\s]+");
        for (String procS : procAr) {
            tempInt = iMap.get(procS);
            if (tempInt != null && tempInt > gradeInt) {
                gradeInt = tempInt;
            }
        }
        if (gradeInt < 500) {
            return "A";
        } else if (gradeInt >= 500 && gradeInt < 1000) {
            return "B";
        } else if (gradeInt >= 1000 && gradeInt < 1500) {
            return "C";
        } else if (gradeInt >= 1500 && gradeInt < 2000) {
            return "D";
        } else {
            return "F";
        }
    }

    public static Scanner mainAct;
    public TextView tvData;
    private TextView jtext;

    public class jModel {
        //boolean writtenTo = false;
        JSONArray categories = new JSONArray();
        String ingredients = "";
    };

    public jModel jData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        Button scanInit = (Button) findViewById(R.id.scan);
        scanInit.setOnClickListener(mScan);
        mainAct = this;
        tvData = (TextView) findViewById(R.id.tvJsonObj);
        jData = new jModel();
        tvData.setText("waiting");


        iMap.put("WHEAT",522);
        iMap.put("RICE",1368);
        iMap.put("BARLEY",731);
        iMap.put("CORN",440);
        iMap.put("RYE",1259);
        iMap.put("OATS",863);
        iMap.put("MILLET",414);
        iMap.put("POTATO",91);
        iMap.put("POTATOES",91);
        //iMap.put("SWEET POTATOES",163);
        //iMap.put("SWEET POTATO",163);
        iMap.put("YAMS",79);
        iMap.put("YAM",79);
        //iMap.put("SUGAR CANE",325);
        iMap.put("SUGAR",325);
        iMap.put("BEANS",1293);
        iMap.put("BEAN",1293);
        iMap.put("PEAS",725);
        iMap.put("PEA",725);
        iMap.put("LENTILS",1839);
        iMap.put("LENTIL",1839);
        iMap.put("ALMONDS",2013);
        iMap.put("ALMOND",2013);
        iMap.put("WALNUTS",2015);
        iMap.put("WALNUT",2015);
        iMap.put("PISTACHIOS",2143);
        iMap.put("PISTACHIO",2143);
        iMap.put("HAZELNUTS",2891);
        iMap.put("HAZELNUT",2891);
        iMap.put("SOYBEANS",763);
        iMap.put("SOYBEAN",763);
        //iMap.put("GREEN OLIVES",545);
        //iMap.put("GREEN OLIVE",545);
        iMap.put("OLIVE",545);
        iMap.put("OLIVES",545);
        iMap.put("SUNFLOWER",3051);
        iMap.put("SUNFLOWER",3051);
        iMap.put("CANOLA",227);
        iMap.put("CANOLA OIL",227);
        iMap.put("MUSTARD",900);
        iMap.put("CABBAGE",188);
        iMap.put("CABBAGES",188);
        iMap.put("ARTICHOKE",473);
        iMap.put("ASPARAGUS",1494);
        iMap.put("LETTUCE",59);
        iMap.put("SPINACH",41);
        iMap.put("TOMATO",90);
        iMap.put("TOMATOES",90);
        iMap.put("CAULIFLOWER",62);
        iMap.put("BROCCOLI",62);
        iMap.put("PUMPKIN",89);
        iMap.put("PUMPKINS",89);
        iMap.put("SQUASH",89);
        iMap.put("CUCUMBER",228);
        iMap.put("CUCUMBERS",228);
        iMap.put("EGGPLANT",125);
        iMap.put("EGGPLANTS",125);
        iMap.put("CHILE",135);
        iMap.put("PEPPER",135);
        iMap.put("PEPPERS",135);
        iMap.put("ONIONS",86);
        iMap.put("ONION",86);
        iMap.put("GARLIC",374);
        //iMap.put("GREEN BEANS",281);
        //iMap.put("GREEN BEAN",281);
        //iMap.put("STRING BEANS",303);
        //iMap.put("STRING BEAN",303);
        iMap.put("CARROTS",55);
        iMap.put("CARROT",55);
        iMap.put("BANANAS",260);
        iMap.put("BANANA",260);
        iMap.put("ORANGE",39);
        iMap.put("ORANGES",39);
        iMap.put("TANGERINES",59);
        iMap.put("TANGERINE",59);
        iMap.put("MANDARIN ORANGES",59);
        iMap.put("MANDARIN ORANGE",59);
        iMap.put("LEMONS",49);
        iMap.put("LEMON",49);
        iMap.put("LIMES",49);
        iMap.put("LIME",49);
        iMap.put("GRAPEFRUIT",100);
        iMap.put("GRAPEFRUITS",100);
        iMap.put("APPLES",250);
        iMap.put("APPLE",250);
        iMap.put("PEARS",204);
        iMap.put("PEAR",204);
        iMap.put("APRICOTS",316);
        iMap.put("APRICOT",316);
        iMap.put("CHERRIES",949);
        iMap.put("CHERRY",949);
        iMap.put("PEACHES",351);
        iMap.put("PEACH",351);
        iMap.put("NECTARINES",351);
        iMap.put("NECTARINE",351);
        iMap.put("PLUMS",530);
        iMap.put("PLUM",530);
        iMap.put("STRAWBERRIES",82);
        iMap.put("STRAWBERRY",82);
        iMap.put("RASPBERRIES",174);
        iMap.put("RASPBERRY",174);
        iMap.put("BLUEBERRIES",329);
        iMap.put("BLUEBERRY",329);
        iMap.put("CRANBERRIES",147);
        iMap.put("CRANBERRY",147);
        iMap.put("GRAPES",289);
        iMap.put("GRAPE",289);
        iMap.put("FIGSs",497);
        iMap.put("FIG",497);
        iMap.put("MANGO",552);
        iMap.put("MANGOES",552);
        iMap.put("AVOCADO",618);
        iMap.put("AVOCADOS",618);
        iMap.put("PINEAPPLE",4);
        iMap.put("PINEAPPLES",4);
        iMap.put("KIWI",499);
        iMap.put("KIWIS",499);
        iMap.put("PAPAYA",44);
        iMap.put("PAPAYAS",44);
        iMap.put("COFFEE",7500);
        iMap.put("COCOA",7000);
        iMap.put("CHOCOLATE",7000);
        iMap.put("HOPS",1269);
        iMap.put("GINGER",200);
        iMap.put("MILK",90);
        iMap.put("CREAM",180);
        iMap.put("YOGURT",69);
        iMap.put("BUTTERMILK",93);
        iMap.put("WHEY",38);
        iMap.put("BUTTER",324);
        iMap.put("CHEESE",310);
        iMap.put("EGGS",170);
        iMap.put("EGG",170);
        iMap.put("TURKEY",1187);
        iMap.put("CHICKEN",1187);
        iMap.put("DUCK",1187);
        iMap.put("HAM",1701);
        iMap.put("PORK",1400);
        iMap.put("BEEF",1663);
        iMap.put("WATER", 2000);
    }

    public Button.OnClickListener mScan = new Button.OnClickListener() {
        public void onClick(View v) {
            IntentIntegrator integrator = new IntentIntegrator(mainAct);
            integrator.initiateScan();
        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        String s = "http://world.openfoodfacts.org/api/v0/product/[" + scanResult.getContents() + "].json";
        JSONtask jTask = new JSONtask();
        jTask.execute(s);

    }

    public class JSONtask extends AsyncTask< String, String, String > {
        HttpURLConnection urlConn = null;
        BufferedReader reader;
        private TextView letterGrade;

        @Override
        protected void onPreExecute(){
            letterGrade = (TextView) findViewById(R.id.letter);
            letterGrade.setText("");
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                urlConn = (HttpURLConnection) url.openConnection();
                urlConn.connect();

                InputStream in = urlConn.getInputStream();
                reader = new BufferedReader(new InputStreamReader(in));
                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }  finally {
                if (urlConn != null) {
                    urlConn.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            //super.onPostExecute(result);
            JSONObject jObj = null;
            try {
                jObj = new JSONObject(result);
                if (jObj.optString("status_verbose").equals("product found")) {
                    jObj = jObj.optJSONObject("product");
                    if (!jObj.optString("ingredients_text_debug").equals("")) {
                        mainAct.jData.ingredients = jObj.optString("ingredients_text_debug");
                        tvData.setText(mainAct.jData.ingredients);
                    } else {
                        mainAct.jData.ingredients = "Ingredients not listed on openfoodfacts.org";
                        tvData.setText(mainAct.jData.ingredients);
                        return;
                    }
                }
                else  {
                    mainAct.jData.ingredients = "Data Not Found";
                    tvData.setText(mainAct.jData.ingredients);
                    return;
                }
            }catch(JSONException e){
                e.printStackTrace();
            }


            if (!mainAct.jData.ingredients.equals("null")){
                letterGrade.setText(grading(mainAct.jData.ingredients));
            }
            try {
                mainAct.jData.categories = jObj.getJSONArray("categories_hierarchy");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

