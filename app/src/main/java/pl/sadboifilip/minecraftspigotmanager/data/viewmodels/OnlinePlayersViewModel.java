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

public class OnlinePlayersViewModel extends AndroidViewModel {

    private ServerDataRepository repository;
    private MutableLiveData<List<PlayerInfo>> onlinePlayers;

    public OnlinePlayersViewModel(@NonNull Application application) {
        super(application);
        this.repository = ((MinecraftSpigotManagerApp) getApplication()).appContainer.getServerDataRepository();
    }

    public LiveData<List<PlayerInfo>> getOnlinePlayers(){
        if(this.onlinePlayers==null){
            this.onlinePlayers = new MutableLiveData<>();
        }
        this.onlinePlayers.postValue(this.repository.getOnlinePlayers());
        return this.onlinePlayers;
    }

    public static class OnlinePlayersViewModelFactory implements ViewModelProvider.Factory{

        private Application mApp;

        public OnlinePlayersViewModelFactory(Application app){
            this.mApp = app;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new OnlinePlayersViewModel(this.mApp);
        }
    }

}
