package uz.imed.exception;

public class PatientNotSavedException extends RuntimeException
{
    public PatientNotSavedException(String message)
    {
        super(message);
    }
}
