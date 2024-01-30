
interface Button {
    public void render();
}

class ButtonWindows implements Button {
    public void render () {
        System.out.println("Button Windows");
    }
}

class ButtonLinux implements Button {
    public void render () {
        System.out.println("Button Linux");
    }
}

abstract class Dialog {

    public void renderButton () {
        Button button = createButton();
        button.render();
    }

    public abstract Button createButton();
}

class WindowsDialog extends Dialog {
    public Button createButton () {
        return new ButtonWindows();
    }
}

class LinuxDialog extends Dialog {
    public Button createButton () {
        return new ButtonLinux();
    }
}

public class FactoryMethod {
    public static void main (String args[]) {
        Dialog dialog = null;

        if (System.getProperty("os.name").equals("Linux")) {
            dialog = new LinuxDialog();
        } else {
            dialog = new WindowsDialog();
        }

        dialog.renderButton();
    }
}