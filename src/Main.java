public class Main {

    public static void main(String[] args) {

        TextAppenderImpl tAI = new TextAppenderImpl();
        TextAppenderImpl tAI2 = new TextAppenderImpl();

        try {
            System.out.println("Opening First");
            tAI.open("First");
            System.out.println("Succesful at opening First");
        } catch (AlreadyExistsException e) {
            System.out.println("ERROR should have been able to open first");
        }

        try {
            System.out.println("Opening First");
            tAI.open("First");
            System.out.println("ERROR shouldn't be opening First");
        } catch (AlreadyExistsException e) {
            System.out.println("Expected this exception");
        }

        try {
            System.out.println("Going to append first");
            tAI.append("First", "The next step");
            System.out.println("All good");
            System.out.println(tAI);
        } catch (DoesNotExistException e) {
            System.out.println("ERROR");
        } catch (CannotAppendException e) {
            System.out.println("ERROR AS WELL");
        }

        try {
            System.out.println("Trying to flush");
            tAI.flush("First");
        } catch (DoesNotExistException e) {
            System.out.println("Returns an error");

        }
        try {
            System.out.println("Trying to close");
            tAI.close("First");
        } catch (DoesNotExistException e) {
            System.out.println("Can't close");
        } catch (NeedsFlushException e) {
            System.out.println("Doesn't meet flush");
                // am I supposed to have a finally statement here?
            }

        }
    }




