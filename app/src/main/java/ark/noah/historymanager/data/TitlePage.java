package ark.noah.historymanager.data;

public class TitlePage extends Page {
    private String title;

    public TitlePage(String title) {
        this.title = title;
        pageType = PageType.TITLE;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
