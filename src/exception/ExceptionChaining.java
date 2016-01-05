package exception;

public class ExceptionChaining {
	public static void main(String[] args) {
		try {
			getLeave();
		} catch (LeaveRejectedException e) {
			System.out.println("Leave Rejected");
			e.printStackTrace();
		}
	}

	private static void getLeave() throws LeaveRejectedException {
		try {
			howIsTeamLead();
			throw new NullPointerException();
		} catch (LeadUpSetException e) {
			throw new LeaveRejectedException("Lead Rejected",e);
		}
		
	}

	private static void howIsTeamLead() throws LeadUpSetException {
		try{
			howIsManager();
		}catch(ManagerUpSetException e){
			throw new LeadUpSetException("Lead Upset",e);
		}
		
	}

	private static void howIsManager() throws ManagerUpSetException {
		throw new ManagerUpSetException("Manager Upset");
		
	}
}
