package pl.sadboifilip.minecraftspigotmanager.data.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import pl.sadboifilip.minecraftspigotmanager.MinecraftSpigotManagerApp;
import pl.sadboifilip.minecraftspigotmanager.data.AppContainer;
import pl.sadboifilip.minecraftspigotmanager.data.ServerDataRepository;
import pl.sadboifilip.minecraftspigotmanager.data.models.PlayerInfo;

public class OnlinePlayersViewModel extends AndroidViewModel {

    private ServerDataRepository repository;
    private MutableLiveData<List<PlayerInfo>> onlinePlayers;

    public OnlinePlayersViewModel(@NonNull Application application) {
        super(application);
        AppContainer appContainer = ((MinecraftSpigotManagerApp) getApplication()).appContainer;
    }

    public LiveData<List<PlayerInfo>> getOnlinePlayers(){
        if(this.onlinePlayers==null){
            this.onlinePlayers = new MutableLiveData<>();
        }
        this.onlinePlayers.postValue(repository.getOnlinePlayers());
        return this.onlinePlayers;
    }


}
