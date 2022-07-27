package ark.noah.historymanager.data;

public class History {
    private String title;
    private int debugType;

    public History(String title, int debugType) {
        this.title = title;
        this.debugType = debugType;
    }

    public String getTitle() { return title; }
    public int getDebugType() { return debugType; }
}
