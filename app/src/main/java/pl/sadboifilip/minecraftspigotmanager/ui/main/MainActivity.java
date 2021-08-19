package pl.sadboifilip.minecraftspigotmanager.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import pl.sadboifilip.minecraftspigotmanager.databinding.ActivityMainBinding;
import pl.sadboifilip.minecraftspigotmanager.ui.players.PlayersActivity;

public class MainActivity extends AppCompatActivity {
    private final static String SERVER_URL = "server_url";
    private final static String SERVER_TOKEN = "server_token";
    private final static String SERVER_INFO_SAVE_MESSAGE = "Server creds successfully saved!";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPreferences preferences = this.getPreferences(Context.MODE_PRIVATE);
        final String url = preferences.getString(SERVER_URL,"http://localhost:7000");
        final String token = preferences.getString(SERVER_TOKEN,"94a7b26c-7f4c-44a1-8c8b-b5db49a824e6");
        // TODO Add token decryption

        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        this.binding.activityMainButtonPlayersActivity.setOnClickListener(e->{
            Intent intent = new Intent(this, PlayersActivity.class);
            startActivity(intent);
        });
        this.binding.activityMainButtonServerInfoSave.setOnClickListener(e->{
            final SharedPreferences.Editor editor = preferences.edit();
            editor.putString(SERVER_URL,this.binding.activityMainUrl.getText().toString());
            editor.putString(SERVER_TOKEN,this.binding.activityMainToken.getText().toString());
            editor.apply();
            // TODO Add token encryption

            Toast toast = Toast.makeText(getApplicationContext(), SERVER_INFO_SAVE_MESSAGE, Toast.LENGTH_SHORT);
            toast.show();
        });

        this.binding.activityMainUrl.setText(url);
        this.binding.activityMainToken.setText(token);
    }
}
