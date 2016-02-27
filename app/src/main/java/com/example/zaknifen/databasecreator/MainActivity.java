package com.example.zaknifen.databasecreator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.zaknifen.databasecreator.DataBase.DataBaseMaster;
import com.example.zaknifen.databasecreator.models.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User user = new User();
        user.name = "Vasya";

        DataBaseMaster.getInstance(this).addUser(user);

        List<User> query = DataBaseMaster.getInstance(this).getAllUsersQuery();
        Log.d("query", "size: " + query.size());
        List<User> raw = DataBaseMaster.getInstance(this).getAllUsersRaw();
        Log.d("raw", "size: " + raw.size());
    }
}
