package ark.noah.historymanager.fragments.main.Second;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ark.noah.historymanager.databinding.FragmentPageSecondBinding;

public class PageSecondFragment extends Fragment {
    private ark.noah.historymanager.databinding.FragmentPageSecondBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPageSecondBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }
}