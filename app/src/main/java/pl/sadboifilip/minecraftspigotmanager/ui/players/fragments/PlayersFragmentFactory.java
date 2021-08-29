package pl.sadboifilip.minecraftspigotmanager.ui.players.fragments;

import androidx.fragment.app.Fragment;

/**
* Factory class that creates different players list views
*
* @author filip
*/
public class PlayersFragmentFactory {

    public final static int ACTIVE = 0;
    public final static int WHITELISTED = 1;
    public final static int BANNED = 3;

    public static final Fragment getPlayersFragment(int type){
        switch (type) {
            case 0:
                return new ActivePlayersFragment();
            case 1:
                return new WhitelistedPlayersFragment();
            case 2:
                return new BannedPlayersFragment();
        }

        return null;
    }

}
