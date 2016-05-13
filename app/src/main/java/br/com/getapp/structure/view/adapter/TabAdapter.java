package br.com.getapp.structure.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import br.com.getapp.structure.view.fragment.ListFragment;
import br.com.getapp.structure.view.fragment.RemoveFragment;

/**
 * Created by User on 21/04/2016.
 */
public class TabAdapter extends FragmentStatePagerAdapter {

    private int numTabs;

    public TabAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ListFragment.newInstance();
            case 1:
                return RemoveFragment.newInstance();

            default:
                return new Fragment();
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Alarmes";
            case 1:
                return "Excluir";
            default:
                return null;
        }
    }
}
