package id.ac.telkomuniversity.vsi3f4.tubesandroid;

public class app_caridua {
    private String Title;
    private String Subtitle;
    private int Icon;

    app_caridua(String Title, String Subtitle, int Icon) {
        this.Title = Title;
        this.Subtitle = Subtitle;
        this.Icon = Icon;
    }

    String getTitle() {
        return this.Title;
    }

    String getSubtitle() {
        return Subtitle;
    }

    int getIcon() {
        return Icon;
    }
}
