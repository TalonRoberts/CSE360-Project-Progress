package application;

import java.util.ArrayList;

public class effortLogsDatabase {
		private static effortLogsDatabase instance;
		private ArrayList<EffortLog> effortLogsList;
		
		private effortLogsDatabase() {
			effortLogsList = new ArrayList<>();
		}
		
		public static effortLogsDatabase getInstance() {
			if (instance == null) {
				instance = new effortLogsDatabase();
			}
			return instance;
		}
		
		public void addLog(EffortLog effortLog) {
			effortLogsList.add(effortLog);
		}
		
		public void removeLog(EffortLog effortLog) {
			effortLogsList.remove(effortLog);
		}
		
		
		
		public ArrayList<EffortLog> getLogList(){
			return effortLogsList;
		}
		

}
