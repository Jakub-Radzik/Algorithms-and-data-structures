package Interfaces;

public class FullQueueException extends Exception{
    public FullQueueException() {
    }

    public FullQueueException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
