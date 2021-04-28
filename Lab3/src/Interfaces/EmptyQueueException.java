package Interfaces;

public class EmptyQueueException extends Exception{
    public EmptyQueueException() {
    }

    public EmptyQueueException(String message) {
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
