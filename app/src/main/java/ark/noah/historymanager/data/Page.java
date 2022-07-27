package ark.noah.historymanager.data;

public class Page {
    public static enum PageType {
        TITLE,
    }

    protected PageType pageType;
    private PageType next, prev;

    public PageType getNext() { return next; }
    public void setNext(PageType next) { this.next = next; }

    public PageType getPrev() { return prev; }
    public void setPrev(PageType prev) { this.prev = prev; }

    public PageType getPageType() { return pageType; }
}
