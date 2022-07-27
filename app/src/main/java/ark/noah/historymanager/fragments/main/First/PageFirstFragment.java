package ark.noah.historymanager.fragments.main.First;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ark.noah.historymanager.data.Page;
import ark.noah.historymanager.data.Pages;
import ark.noah.historymanager.data.TitlePage;
import ark.noah.historymanager.databinding.FragmentPageFirstBinding;

public class PageFirstFragment extends Fragment implements PageAdapter.IPageUpdate {
    private FragmentPageFirstBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPageFirstBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(
                new PageAdapter(
                        new Page[]{
                                new TitlePage("Testing"),
                        }
                )
        );

        return root;
    }

    @Override
    public void onTitleTextUpdated() {

    }
}