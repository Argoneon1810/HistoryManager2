package ark.noah.historymanager.data;

import java.util.ArrayList;
import java.util.Arrays;

public class Histories {
    ArrayList<History> mList;

    public Histories() {
        mList = new ArrayList<>();
    }
    public Histories(ArrayList<History> histories) {
        mList = histories;
    }
    public Histories(History[] histories) {
        mList = new ArrayList<>(Arrays.asList(histories));
    }

    public History get(int index) {
        return mList.get(index);
    }

    public int size() {
        return mList.size();
    }
}
