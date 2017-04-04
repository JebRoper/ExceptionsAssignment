import java.util.Arrays;

/**
 * Created by admin on 4/3/17.
 */
public class TextContainer {

    private String key;
    private String text = "";
    private boolean flushed;

    public TextContainer(String key) {
        this.key = key;

    }

    public String getKey() {
        return key;
    }

    public String getText() {
        return text;
    }

    public boolean isFlushed() {
        return flushed;
    }

    public void append(String text) {
        this.text += text;
        flushed = false;

    }

    public void flush() {
        flushed = true;
    }

    @Override
    public String toString() {
        return "TextContainer{" +
                "key='" + key + '\'' +
                ", text='" + text + '\'' +
                ", flushed=" + flushed +
                '}';
    }
}
