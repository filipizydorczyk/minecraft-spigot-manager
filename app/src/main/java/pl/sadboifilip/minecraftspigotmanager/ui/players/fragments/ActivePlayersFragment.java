package pl.sadboifilip.minecraftspigotmanager.ui.players.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import pl.sadboifilip.minecraftspigotmanager.R;
import pl.sadboifilip.minecraftspigotmanager.data.viewmodels.OnlinePlayersViewModel;
import pl.sadboifilip.minecraftspigotmanager.databinding.FragmentMainBinding;
import pl.sadboifilip.minecraftspigotmanager.ui.adapters.PlayersInfoAdapter;


public class ActivePlayersFragment extends Fragment {
    private FragmentMainBinding binding;
    private OnlinePlayersViewModel viewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewModel = new ViewModelProvider(this, new OnlinePlayersViewModel.OnlinePlayersViewModelFactory(getActivity().getApplication())).get(OnlinePlayersViewModel.class);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        this.viewModel.getOnlinePlayers().observe(getViewLifecycleOwner(),players -> {
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