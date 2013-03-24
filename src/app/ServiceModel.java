package app;

public class ServiceModel {
	
	public int userId=0;
	private int id = 0;
	public String serviceName;
	public String Status = "TestStatus";
	
	public ServiceModel(int id, String serviceName, int userId){
		this.serviceName = serviceName;
		this.userId = userId;
		this.id = id;
	}
}
