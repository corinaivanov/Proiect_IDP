package app;

import guicomponents.CustomTableModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class WebServiceClient implements IWebServiceClient {

		String configFile = "D:/Facultate/ProiectIDP/src/app/Config.txt";
		String servicesFile = "D:/Facultate/ProiectIDP/src/app/selfServices.txt";
		ArrayList<UserModel> users;
		ArrayList<ServiceModel> services;
		
		public WebServiceClient(){
			users = new ArrayList<UserModel>();
			services = new ArrayList<ServiceModel>();
			this.loadConfig();
		}
		
		private void loadConfig(){
			
			PopulateUsers();
			PopulateServices();
		    
		}
		
		private void PopulateUsers(){
			try {
		    	BufferedReader br = new BufferedReader(new FileReader(configFile));
		        String line = br.readLine();

		        while (line != null) {
		        	String[] s = line.split(",");
		            line = br.readLine();
		            int userID = Integer.parseInt(s[0]);
		            users.add(new UserModel(s[1], s[2], GetUserType(s[3]),userID));
		        }
		        
		    }catch(Exception e){
		    
		    }
		}
		private void PopulateServices(){
			try {
		    	BufferedReader br = new BufferedReader(new FileReader(servicesFile));
		        String line = br.readLine();

		        while (line != null) {
		        	String[] s = line.split(",");
		            line = br.readLine();
		            
		            int id = Integer.parseInt(s[0]);
		            int userID = Integer.parseInt(s[1]);
		            services.add(new ServiceModel(id,s[2],userID));
		        }
		        
		    }catch(Exception e){
		    
		    }
		}
		
		private UserModel.UserType GetUserType(String s){
			 UserModel.UserType type;
	            switch (s){
	            	case "1":
	            		type = UserModel.UserType.Buyer;
	            		break;
	            	case "2":
	            		type = UserModel.UserType.Seller;
	            		break;
	            	default:
	            		type = UserModel.UserType.Buyer;
	            }
            return type;
		}
		
		public int IsValidLogin(String username, String password, String type){
			for(int i = 0; i < users.size(); i++){
				UserModel currentUser = this.users.get(i);
				if(currentUser.username.equals(username) && 
						currentUser.password.equals(password))
					return currentUser.id;
			}
			return 0;
		}
		
		public ArrayList GetServicesData(int userId){
			ArrayList rows = new ArrayList();

			for(int i = 0; i < this.services.size(); i++){
				ServiceModel currentService = services.get(i);
				if(currentService.userId == userId){
					ArrayList<String> serviceData  = new ArrayList<String>();
					serviceData.add(currentService.serviceName);
					serviceData.add(currentService.Status);
					serviceData.add(GetList(currentService.serviceName, userId));
					rows.add(serviceData);
				}
			}
			return rows;
		}
		
		public String GetList(String serviceName, int userId){
			String result = "";
			UserModel me = GetUser(userId);
			for(int i = 0; i < this.services.size(); i++){
				ServiceModel serv = this.services.get(i);
				if (serv.serviceName.contains(serviceName)){
					UserModel user = GetUser(serv.userId);
					if (user.userType != me.userType){
						result += user.username + " ";
					}
				}
				
			}
			return result;
		}
		
		public UserModel GetUser(int id){
			for (int i = 0; i < this.users.size(); i++){
				UserModel currentUser = this.users.get(i);
				if (currentUser.id == id){
					return currentUser;
				}
			}
			return null;
		}
}
