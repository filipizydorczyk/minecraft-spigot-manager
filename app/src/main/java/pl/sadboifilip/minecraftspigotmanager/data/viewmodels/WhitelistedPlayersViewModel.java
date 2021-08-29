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

public class WhitelistedPlayersViewModel extends AndroidViewModel {

    private ServerDataRepository repository;
    private MutableLiveData<List<PlayerInfo>> whitelistedPlayers;
    private MutableLiveData<Boolean> isWhitelistedEnabled;

    public WhitelistedPlayersViewModel(@NonNull Application application) {
        super(application);
        this.repository = ((MinecraftSpigotManagerApp) getApplication()).appContainer.getServerDataRepository();
    }

    public LiveData<List<PlayerInfo>> getWhitelistedPlayers(){
        if(this.whitelistedPlayers==null){
            this.whitelistedPlayers = new MutableLiveData<>();
        }
        this.whitelistedPlayers.postValue(this.repository.getWhitelistedPlayers());
        return this.whitelistedPlayers;
    }

    public LiveData<Boolean> isWhitelistedEnabled(){
        if(this.isWhitelistedEnabled==null){
            this.isWhitelistedEnabled = new MutableLiveData<>();
        }
        this.isWhitelistedEnabled.postValue(this.repository.isWhitelistEnabled());
        return this.isWhitelistedEnabled;
    }


    public static class WhitelistedPlayersViewModelFactory implements ViewModelProvider.Factory{

        private Application mApp;

        public WhitelistedPlayersViewModelFactory(Application app){
            this.mApp = app;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new WhitelistedPlayersViewModel(this.mApp);
        }
    }
}
