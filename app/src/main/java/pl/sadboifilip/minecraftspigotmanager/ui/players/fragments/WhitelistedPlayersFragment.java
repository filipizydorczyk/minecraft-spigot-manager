package pl.sadboifilip.minecraftspigotmanager.ui.players.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import pl.sadboifilip.minecraftspigotmanager.R;
import pl.sadboifilip.minecraftspigotmanager.data.viewmodels.WhitelistedPlayersViewModel;
import pl.sadboifilip.minecraftspigotmanager.databinding.FragmentPlayersWhitelistedBinding;
import pl.sadboifilip.minecraftspigotmanager.ui.adapters.PlayersInfoAdapter;

public class WhitelistedPlayersFragment extends Fragment {
    private FragmentPlayersWhitelistedBinding binding;
    private WhitelistedPlayersViewModel viewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewModel = new ViewModelProvider(this, new WhitelistedPlayersViewModel.WhitelistedPlayersViewModelFactory(getActivity().getApplication())).get(WhitelistedPlayersViewModel.class);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentPlayersWhitelistedBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        this.viewModel.isWhitelistedEnabled().observe(getViewLifecycleOwner(), isEnabled -> {
            if(isEnabled != null){
                binding.switchCompactWhitelistEnabled.setChecked(isEnabled);
            }
        });
        this.viewModel.getWhitelistedPlayers().observe(getViewLifecycleOwner(),players -> {
            if(players != null){
                final PlayersInfoAdapter adapter =  new PlayersInfoAdapter(getActivity(), R.layout.listelement_player, players);
                binding.listviewPlayers.setAdapter(adapter);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}