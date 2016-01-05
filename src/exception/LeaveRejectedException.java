package exception;

class ManagerUpSetException extends Exception {

	private static final long serialVersionUID = 1L;

	public ManagerUpSetException(){
		super();
	}

	public ManagerUpSetException(String cause){
		super(cause);
	}

	public ManagerUpSetException(String cause,Throwable throwable){
		super(cause,throwable);
	}

}

class LeadUpSetException extends Exception {

	private static final long serialVersionUID = 1L;

	public LeadUpSetException(){
		super();
	}

	public LeadUpSetException(String cause){
		super(cause);
	}

	public LeadUpSetException(String cause,Throwable throwable){
		super(cause,throwable);
	}

}

public class LeaveRejectedException extends Exception {

	private static final long serialVersionUID = 1L;

	public LeaveRejectedException(){
		super();
	}

	public LeaveRejectedException(String cause){
		super(cause);
	}

	public LeaveRejectedException(String cause,Throwable throwable){
		super(cause,throwable);
	}

}