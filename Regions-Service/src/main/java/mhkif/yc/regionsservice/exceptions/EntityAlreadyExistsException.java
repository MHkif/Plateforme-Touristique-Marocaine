package mhkif.yc.regionsservice.exceptions;


public class EntityAlreadyExistsException extends RuntimeException{
    public EntityAlreadyExistsException(String message){
        super(message);
    }
}