package bd.edu.seu.newconnectiondb.exceptions;

public class ResoueceNotFoundException extends Exception {
    public ResoueceNotFoundException(String id) {
        super(id + "Not Found !");
    }
}
