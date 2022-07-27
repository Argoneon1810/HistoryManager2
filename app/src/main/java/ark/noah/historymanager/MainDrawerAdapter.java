package ark.noah.historymanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ark.noah.historymanager.data.Histories;
import ark.noah.historymanager.data.History;

public class MainDrawerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Histories mData;

    public MainDrawerAdapter(History[] data) {
        mData = new Histories(data);
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getDebugType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        switch (viewType) {
            default:
            case 0:
                return new ViewHolder(inflater.inflate(R.layout.item_recycler_main_drawer, parent, false));
            case 1:
                return new ViewHolderVar1(inflater.inflate(R.layout.item_recycler_main_drawer_var1, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        History current = mData.get(position);

        switch(holder.getItemViewType()) {
            default:
            case 0:
                MainDrawerAdapter.ViewHolder vh = (MainDrawerAdapter.ViewHolder) holder;
                vh.title.setText(current.getTitle());
                break;
            case 1:
                MainDrawerAdapter.ViewHolderVar1 vh_var1 = (MainDrawerAdapter.ViewHolderVar1) holder;
                vh_var1.title.setText(current.getTitle());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_rec_main);
        }
    }

    public static class ViewHolderVar1 extends RecyclerView.ViewHolder {
        TextView title;
        public ViewHolderVar1(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_rec_main_var1);
        }
    }
}
