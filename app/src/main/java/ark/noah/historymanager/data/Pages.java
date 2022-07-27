package ark.noah.historymanager.data;

import java.util.HashMap;

public class Pages {
    private HashMap<Page.PageType, Page> pages;
    private Page root;

    public Pages(Page root) {
        pages = new HashMap<>();
        pages.put(root.getPageType(), root);
        this.root = root;
    }
    public Pages(Page[] pagesArray) {
        pages = new HashMap<>();

        if(pagesArray == null || pagesArray.length == 0) return;

        root = pagesArray[0];
        for (Page page : pagesArray) {
            pages.put(page.getPageType(), page);
        }
    }

    public Page getPage(Page.PageType pageType) {
        return pages.get(pageType);
    }

    public Page[] getAllPages() {
        Page[] pagesArray = new Page[pages.size()];
        Page current = root;
        int count = 0;
        while(current.getNext() != null) {
            pagesArray[count++] = current;
            current = pages.get(current.getNext());
        }
        return pagesArray;
    }

    public void addAfter(Page toAdd, Page head) {
        Page tail = pages.get(head.getNext());
        tail.setPrev(toAdd.getPageType());
        head.setNext(toAdd.getPageType());
        toAdd.setPrev(head.getPageType());
        toAdd.setNext(tail.getPageType());
        pages.put(toAdd.getPageType(), toAdd);
    }

    public int getCount() { return pages.size(); }
}
