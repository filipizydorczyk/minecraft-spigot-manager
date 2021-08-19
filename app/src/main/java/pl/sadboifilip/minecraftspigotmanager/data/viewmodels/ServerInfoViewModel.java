package pl.sadboifilip.minecraftspigotmanager.data.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import pl.sadboifilip.minecraftspigotmanager.MinecraftSpigotManagerApp;
import pl.sadboifilip.minecraftspigotmanager.data.ServerDataRepository;
import pl.sadboifilip.minecraftspigotmanager.data.models.ServerLogs;

public class ServerInfoViewModel extends AndroidViewModel {

    private ServerDataRepository repository;
    private MutableLiveData<ServerLogs> serverLogs;

    public ServerInfoViewModel(@NonNull Application application) {
        super(application);
        this.repository = ((MinecraftSpigotManagerApp) getApplication()).appContainer.getServerDataRepository();
    }

    public LiveData<ServerLogs> getServerLogs(){
        if(this.serverLogs==null){
            this.serverLogs = new MutableLiveData<>();
        }
        this.serverLogs.postValue(this.repository.getLatestLogs());
        return this.serverLogs;
    }

    public static class ServerInfoViewModelFactory implements ViewModelProvider.Factory{

        private Application mApp;

        public ServerInfoViewModelFactory(Application app){
            this.mApp = app;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ServerInfoViewModel(this.mApp);
        }
    }

}
