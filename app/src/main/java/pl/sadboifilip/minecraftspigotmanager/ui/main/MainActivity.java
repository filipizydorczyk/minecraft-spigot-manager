package pl.sadboifilip.minecraftspigotmanager.ui.main;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import pl.sadboifilip.minecraftspigotmanager.databinding.ActivityMainBinding;
import pl.sadboifilip.minecraftspigotmanager.ui.players.PlayersActivity;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        this.binding.buttonPlayersActivity.setOnClickListener(e->{
            Intent intent = new Intent(this, PlayersActivity.class);
            startActivity(intent);
        });
    }
}
