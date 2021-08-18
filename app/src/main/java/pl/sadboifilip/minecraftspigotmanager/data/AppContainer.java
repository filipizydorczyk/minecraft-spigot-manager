package pl.sadboifilip.minecraftspigotmanager.data;

/**
 * App container for dependencies
 * @author filip
 */
public class AppContainer {
    private ServerDataRepository serverDataRepository = new ServerDataRepository();

    public ServerDataRepository getServerDataRepository() {
        return serverDataRepository;
    }
}
