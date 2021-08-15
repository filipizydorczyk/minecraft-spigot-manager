package pl.sadboifilip.minecraftspigotmanager.data.models;

public class PlayerInfo {

    private String name;
    private ServerRoles serverRole;

    public PlayerInfo(String name, ServerRoles serverRole) {
        this.name = name;
        this.serverRole = serverRole;
    }

    public String getName() {
        return name;
    }

    public ServerRoles getServerRole() {
        return serverRole;
    }
}
