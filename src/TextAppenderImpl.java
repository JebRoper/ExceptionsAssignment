import java.security.Key;
import java.util.Arrays;

/**
 * Created by admin on 4/3/17.
 */
public class TextAppenderImpl implements TextAppender {
    private TextContainer[] lists = new TextContainer[10];


    @Override
    public void open(String key) throws AlreadyExistsException {
        // Check the list of text containers to see if there is one with key that matches
        // If there is not a match then new up a text container and add it to the array
        // If there is a match throw an AlreadyExistsException
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                if (lists[i].getKey().equals(key)) {
                    throw new AlreadyExistsException("This is the exception");
                }
            }
        }

        TextContainer tc = new TextContainer(key);
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] == null) {
                lists[i] = tc;
                break;
            }
        }

    }

    @Override
    public void append(String key, String text) throws DoesNotExistException, CannotAppendException {
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                if (lists[i].getKey().equals(key)) {
                    // here we have found the TC that we should append to
                    lists[i].append(text);
                }
            }
        }

    }

    @Override
    public void flush(String key) throws DoesNotExistException {

        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                if (lists[i].getKey().equals(key)) {
                    lists[i].flush();
                }
            }
        }

    }

    @Override
    public void close(String key) throws DoesNotExistException, NeedsFlushException {

        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] == null) {
                throw new DoesNotExistException("are we closed yet?");
                        else{
                        return lists.close();
                }
            }
            //I'm referencing something wrong in the above paragraph
            // should I be returning or have a finally statement in main?
        }
    }

}

    @Override
    public String toString() {
        return "TextAppenderImpl{" +
                "lists=" + Arrays.toString(lists) +
                '}';
    }
}

