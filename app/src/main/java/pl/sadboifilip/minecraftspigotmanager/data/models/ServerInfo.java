package pl.sadboifilip.minecraftspigotmanager.data.models;

public class ServerInfo {

    private String url;
    private String token;


    public ServerInfo(String url, String token) {
        this.url = url;
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public String getToken() {
        return token;
    }
}
