package pl.sadboifilip.minecraftspigotmanager.ui.players;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import pl.sadboifilip.minecraftspigotmanager.R;
import pl.sadboifilip.minecraftspigotmanager.ui.players.fragments.ActivePlayersFragment;
import pl.sadboifilip.minecraftspigotmanager.ui.players.fragments.PlayersFragmentFactory;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_players_active, R.string.tab_players_whitelisted, R.string.tab_players_banned};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return PlayersFragmentFactory.getPlayersFragment(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 3;
    }
}