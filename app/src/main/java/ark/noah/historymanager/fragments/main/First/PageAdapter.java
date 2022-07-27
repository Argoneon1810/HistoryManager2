package ark.noah.historymanager.fragments.main.First;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import ark.noah.historymanager.MainDrawerAdapter;
import ark.noah.historymanager.R;
import ark.noah.historymanager.data.Page;
import ark.noah.historymanager.data.Pages;
import ark.noah.historymanager.data.TitlePage;

public class PageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Pages pages;
    private IPageUpdate iPageUpdate;

    private TextWatcher titleChangeWatcher;

    public PageAdapter(Page[] pages) {
        this.pages = new Pages(pages);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        switch (viewType) {
            default:
            case 0:
                return new PageAdapter.ViewHolderTitle(inflater.inflate(R.layout.item_page_title, parent, false));
            case 1:
                return new PageAdapter.ViewHolderTitle(inflater.inflate(R.layout.item_page_title, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch(holder.getItemViewType()) {
            default:
            case 0:
                TitlePage titlePage = (TitlePage) pages.getPage(Page.PageType.TITLE);
                PageAdapter.ViewHolderTitle vh_title = (PageAdapter.ViewHolderTitle) holder;
                vh_title.etxt_title.setText(titlePage.getTitle());
                vh_title.etxt_title.addTextChangedListener(titleChangeWatcher != null ? titleChangeWatcher : (titleChangeWatcher = new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) { }
                    @Override
                    public void afterTextChanged(Editable s) {
                        titlePage.setTitle(s.toString());
                    }
                }));
                break;
        }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        switch(holder.getItemViewType()) {
            default:
            case 0:
                PageAdapter.ViewHolderTitle vh_title = (PageAdapter.ViewHolderTitle) holder;
                vh_title.etxt_title.removeTextChangedListener(titleChangeWatcher);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return pages != null ? pages.getCount() : -1;
    }

    public static class ViewHolderTitle extends RecyclerView.ViewHolder {
        TextView title;
        EditText etxt_title;

        public ViewHolderTitle(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_page_title);
            etxt_title = itemView.findViewById(R.id.etxt_page_title);
        }
    }

    public interface IPageUpdate {
        void onTitleTextUpdated();
    }
}
