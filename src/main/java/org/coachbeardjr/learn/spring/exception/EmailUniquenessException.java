package org.coachbeardjr.learn.spring.exception;

public class EmailUniquenessException extends RuntimeException{

  public EmailUniquenessException(String message){ super(message); }
  
}
