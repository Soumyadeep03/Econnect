package com.example.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class thirdactivity extends AppCompatActivity {
    TextView name, number;
    int followersort,feesort;

    ArrayAdapter arrayAdapter;
    Map<Integer, String> employeeMap = new HashMap<>();
    Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

    ArrayList<String> array_list;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdactivity);

        array_list = new ArrayList<>();

        listView = findViewById(R.id.listView);

        //Get text from Intent
        Intent intent = getIntent();
        String domain = intent.getStringExtra("domain");
        String platform = intent.getStringExtra("platform");
        followersort =  getIntent().getExtras().getInt("followers");
        feesort =  getIntent().getExtras().getInt("fee");
//employee add
        employeeMap.put(760205 ,"Name:-: Kessia Draycott\nPlatform:-Youtube\nDomain:-Gaming\nFollowers:- 760205\nCharges:-: 22005");
        employeeMap.put(115112 ,"Name:-: Toni Element\nPlatform:-YoutubenDomain:- Gaming\nFollowers:-:115112\nCharges:- 89831");
        employeeMap.put(194776 ,"Name:-Atlante Andreichik\n Platform:-Youtube\n Domain: 1 \n Followers:- 194776 \n Charges:- 9217");
        employeeMap.put( 429914,"Name:-Morgan Adamsky \nPlatform:-Facebook\\n Domain:- Gaming \n Followers:-429914\nCharges:-58721");
        employeeMap.put( 513928,"Name:- Jerald Ortas \nPlatform:-Youtube\nDomain:- Gaming \n Followers:- 513928\nCharges:- 14493");
        employeeMap.put(634860 ,"Name:- Bald Hunnicutt \nPlatform:-Youtube \nDomain:- Gaming \nFollowers:-634860 \nCharges:- 80425");
        employeeMap.put( 395742,"Name:- Jacky Michell \nPlatform:-Youtube\n Domain:- Gaming \nFollowers:-395742\nCharges:-:97791");
        employeeMap.put(448959  ,"Name:- Colver Guillond\n Platform:-Youtube\n Domain:- Gaming\nFollowers:-448959 \n Charges:-83853");
        employeeMap.put( 899388,"Name:- Merrily Trickey\nPlatform:-Youtube\nDomain:- Gaming\nFollowers:-899388 \nCharges:-67824");
        employeeMap.put(549885 ,"Name:- Edwin Rignold \nPlatform:-Instagram\nDomain:- Vines\nFollowers:-549885\nCharges:-99918");
        employeeMap.put( 98559,"Name:- Lockwood Goroni\nPlatform:-Instagram\nDomain:- Vines\nFollowers:-98559\nCharges:-:72258");
        employeeMap.put( 909165,"Name:- Ethelind Caush\nPlatform:-Instagram\nDomain:- Vines\nFollowers:-909165 \nCharges:-75903");
        employeeMap.put(600418 ,"Name:- Wash Altofts\nPlatform:-Facebook\\nDomain:- Vines\nFollowers:-600418 \nCharges:-72983");
        employeeMap.put( 511344,"Name:- Mozelle Newbury\nPlatform:-Instagram\nDomain:- Vines\nFollowers:-511344\nCharges:-68702");
        employeeMap.put( 525260,"Name:- Harriot Adriano\nPlatform:-Instagram\nDomain:- Vines\nFollowers:-525260\nCharges:-60497");
        employeeMap.put( 90858,"Name:-Herminia Leggott\nPlatform:-Facebook\nInstagram\nDomain:- Vines\nFollowers:-90858\nCharges:-77171");
        employeeMap.put( 489187,"Name:-Loralee Smeeth\nPlatform:-Facebook\nDomain:- Vines\nFollowers:-489187\nCharges:-97833");
        employeeMap.put( 486310,"Name:- Adiana Corington\nPlatform:-Facebook\nDomain:- Vines\nFollowers:-486310\nCharges:-8294");
        employeeMap.put( 711287,"Name:-Fulvia Cubbino\nPlatform:-nDomain:- Education\nFollowers:-711287\nCharges:-68686");
        employeeMap.put( 899489,"Name:-Sanders Whacket\nPlatform:-Facebook\nDomain:- Education\nFollowers:-899489\nCharges:- 7058");
        employeeMap.put( 805411,"Name:-Franchot McKellen\nPlatform:-Facebook\nDomain:- Education\nFollowers:-805411\nCharges:-37273");
        employeeMap.put(180966 ,"Name:-Anallese HilliamPlatform:-Facebook\nDomain:- Education\nFollowers:-180966\nCharges:-50939");
        employeeMap.put(778733 ,"Name:-Marilin De Moreno\nPlatform:-Facebook\nDomain:- Education\nFollowers:-778733\nCharges:-96494");
        employeeMap.put( 916449,"Name:-Inglebert Greensmith\nPlatform:-Facebook\nDomain:- Education\nFollowers:-916449\nCharges:-62314");
        employeeMap.put( 993238,"Name:-Boyce Wicher\nPlatform:-Twitter\nDomain:- Lifestyle\nFollowers:-993238\nCharges:-33927");
        employeeMap.put( 553809,"Name:-Charlotta Schneidau\nPlatform:-Twitter\nDomain:- Lifestyle\nFollowers:-553809\nCharges:-92273");
        employeeMap.put( 433809,"Name:-Charloti Schneidau\nPlatform:-Twitter\nDomain:- Lifestyle\nFollowers:-433809\nCharges:-76543");
        employeeMap.put(936494 ,"Name:-Chane Sambell\nPlatform:-Twitter\nDomain:- Lifestyle\nFollowers:-936494\nCharges:-78529");
        employeeMap.put(893595 ,"Name:-Hogan Lasselle\nPlatform:-Twitter\nDomain:- Lifestyle\nFollowers:-893595\nCharges:-43560");
        employeeMap.put(521962 ,"Name:-:Tristam Mulrooney,Platform:-Twitter,Domain:- Lifestyle\nFollowers:-521962,Charges:-:79955");
        employeeMap.put(669125 ,"Name:-Che Annandale\nPlatform:-Twitter\nDomain:- Lifestyle\nFollowers:-669125\nCharges:-43238");


        for (Map.Entry<Integer, String> employee : employeeMap.entrySet()) {
            if(employee.getKey() < followersort &&employee.getValue().contains(platform) &&employee.getValue().contains(domain)){
                linkedHashMap.put(employee.getKey(), employee.getValue());
            }
        }
        array_list.clear();
        array_list.addAll(linkedHashMap.values());
        arrayAdapter = new ArrayAdapter(thirdactivity.this, android.R.layout.simple_list_item_1, array_list);


        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Wrong Credentials"+ selectedItem,Toast.LENGTH_SHORT).show();
                alertDialog();
            }
        });


    }
    private void alertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose");
        builder.setMessage("Press Continue to contact with the creator");
        // add the buttons
        builder.setPositiveButton("Continue", null);

        builder.setNegativeButton("Cancel", null);
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}