package bd.edu.seu.newconnectiondb.exceptions;

public class ResourceAlreadyExistException extends Exception {
    public ResourceAlreadyExistException(String s) {
        super(s + " Already Exist");
    }
}
