package pl.sadboifilip.minecraftspigotmanager.data.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import pl.sadboifilip.minecraftspigotmanager.MinecraftSpigotManagerApp;
import pl.sadboifilip.minecraftspigotmanager.data.ServerDataRepository;
import pl.sadboifilip.minecraftspigotmanager.data.models.PlayerInfo;

public class BannedPlayersViewModel extends AndroidViewModel {

    private ServerDataRepository repository;
    private MutableLiveData<List<PlayerInfo>> bannedPlayers;

    public BannedPlayersViewModel(@NonNull Application application) {
        super(application);
        this.repository = ((MinecraftSpigotManagerApp) getApplication()).appContainer.getServerDataRepository();
    }

    public LiveData<List<PlayerInfo>> getBannedPlayers(){
        if(this.bannedPlayers==null){
            this.bannedPlayers = new MutableLiveData<>();
        }
        this.bannedPlayers.postValue(this.repository.getBannedPlayers());
        return this.bannedPlayers;
    }

    public static class BannedPlayersViewModelFactory implements ViewModelProvider.Factory{

        private Application mApp;

        public BannedPlayersViewModelFactory(Application app){
            this.mApp = app;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new BannedPlayersViewModel(this.mApp);
        }
    }
}
