package ark.noah.historymanager.fragments.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

import ark.noah.historymanager.fragments.main.First.PageFirstFragment;
import ark.noah.historymanager.fragments.main.Second.PageSecondFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsStateAdapter extends FragmentStateAdapter {
    ArrayList<Fragment> fragments = new ArrayList<>();

    public SectionsStateAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            default:
            case 0: return new PageFirstFragment();
            case 1: return new PageSecondFragment();
        }
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    public void addFragment(Fragment fragment) {
        fragments.add(fragment);
        notifyItemInserted(fragments.size()-1);
    }

    public void removeFragment(Fragment fragment) {
        int index = fragments.indexOf(fragment);
        fragments.remove(index);
        notifyItemRemoved(index);
    }
}