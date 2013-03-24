package app;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.TableModel;

public interface IWebServiceClient {

	public int IsValidLogin(String username, String password, String type);
	public ArrayList GetServicesData(int userId);
	public String GetList(String serviceName, int userId);
}
