package com.rsrit.Dops.Server.Validations;

/**
 * @author gn.teja created on 02/25/2017
 *
 */

public class EmailExistsException  extends Throwable {

    /**
	 * Default serialization  is used 
	 */
	private static final long serialVersionUID = 1L;

	public EmailExistsException(final String message) {
        super(message);
        System.out.println("oops email already exists -> EmailExistsException");
    }
}
