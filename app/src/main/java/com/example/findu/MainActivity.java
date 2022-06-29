package com.example.findu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** First Part Text Input **/
        EditText edit_name = findViewById(R.id.edit_name);
        EditText edit_location = findViewById(R.id.edit_location);
        EditText edit_contact = findViewById(R.id.edit_contact);
        Button btn = findViewById(R.id.btn_submit);

        /** getText **/
        //DaoPerson dao = new DaoPerson();
        FirestoreAPI db = new FirestoreAPI();
        btn.setOnClickListener(v->
        {   String name =  edit_name.getText().toString();
            String location = edit_location.getText().toString();
            String contact = edit_contact.getText().toString();

            Map<String, Object> userInfo = new HashMap<String, Object>();
            userInfo.put("name", name);
            userInfo.put("location", location);
            userInfo.put("contact", contact);
            db.writePost(userInfo);
            System.out.println(userInfo);


        });




        /** bottom nav **/
        bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setSelectedItemId(R.id.post_nav_button);
        bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.map_nav_button:
                    startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.post_nav_button:
                    return true;
                case R.id.profile_nav_button:
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });
    }
}