package pl.sadboifilip.minecraftspigotmanager.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import pl.sadboifilip.minecraftspigotmanager.data.models.PlayerInfo;
import pl.sadboifilip.minecraftspigotmanager.data.models.ServerInfo;
import pl.sadboifilip.minecraftspigotmanager.data.models.ServerLogs;
import pl.sadboifilip.minecraftspigotmanager.data.models.ServerRoles;

/**
 * Repository that gets data with REST API calls
 * @author filip
 */
public class ServerDataRepository {

    /**
     * @return list of info about players that are logged in
     */
    public List<PlayerInfo> getOnlinePlayers(){
        return Arrays.asList(
                new PlayerInfo("shorud", ServerRoles.OP_PLAYER),
                new PlayerInfo("izak", ServerRoles.NORMAL_PLAYER),
                new PlayerInfo("pasha", ServerRoles.WHITELISTED_PLAYER),
                new PlayerInfo("vlauder", ServerRoles.OP_PLAYER),
                new PlayerInfo("clokec", ServerRoles.BANNED_PLAYER)
        );
    }

    /**
     * @return list of info about players that are banned
     */
    public List<PlayerInfo> getBannedPlayers(){
        return new ArrayList<>();
    }

    /**
     * @param player info about player to be banned
     * @return if action was successful
     */
    public boolean banPlayer(PlayerInfo player){
        return true;
    }

    /**
     * @param player info about player to be unbanned
     * @return if action was successful
     */
    public boolean pardonPlayer(PlayerInfo player){
        return true;
    }

    /**
     * @param player info about player to be kicked
     * @return if action was successful
     */
    public boolean kickPlayer(PlayerInfo player){
        return true;
    }

    /**
     * @return if server has whitelist enabled
     */
    public boolean isWhitelistEnabled(){
        return true;
    }

    /**
     * @return if whitelist was successfully enabled
     */
    public boolean setWhitelistEnabled(){
        return true;
    }

    /**
     * @return if whitelist was successfully disabled
     */
    public boolean setWhitelistDisabled(){
        return true;
    }

    /**
     * @return list of info about players that are whitelisted
     */
    public List<PlayerInfo> getWhitelistedPlayers(){
        return new ArrayList<>();
    }

    /**
     * @return the newest server logs
     */
    public ServerLogs getLatestLogs(){
        return new ServerLogs("[Time] log",new Date());
    }

}
