class Color {
    private String value;
    public Color (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


abstract class Theme {
    Color color = null;

    public Color getColor() {
        return this.color;
    }
}

class ThemeBlack extends Theme {
    ThemeBlack (){
        this.color = new Color("#000000");
    }
}

class ThemeWhite extends Theme {
    ThemeWhite () {
        this.color = new Color("#ffffff");
    }
}

abstract class Page {
    public void renderPage () {
        Theme theme = createTheme();
        System.out.println("Render page with themecolor " + theme.getColor().getValue());
    }

    public abstract Theme createTheme();
}

class PageBlackTheme extends Page {
    public Theme createTheme() {
        Theme theme = new ThemeBlack();
        return theme;        
    }
}

class PageDefaultTheme extends Page {
    public Theme createTheme () {
        Theme theme = new ThemeWhite();
        return theme;
    }
}

public class MainProject {

    public static void main (String args[]) {

        Page page = null;

        if (args.length > 0 && args[0].equals("black")) {
            page = new PageBlackTheme();
        } else {
            page = new PageDefaultTheme();
        }

        page.renderPage();
    }

}