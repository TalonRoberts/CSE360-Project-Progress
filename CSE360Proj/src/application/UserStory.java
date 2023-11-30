package application;

public class UserStory {
	
   
   private String _projName;
   private String _projDesc;
   private String _userStoryName;
   private String _userStory;
   private int _weight;
   //data fields to be used for winnowing down 
   private String _userRole;
   private String _progLang;
   private String _domain;
   
   public UserStory(String projName, String projDesc, String storyName)
   {
	   	  _projName = projName;
	      _projDesc = projDesc;
	      _userStoryName = storyName;
   }
   
   public UserStory(String projName, String projDesc, String storyName, String story, int weight, String role, String lang, String domain)
   {
      _projName = projName;
      _projDesc = projDesc;
      _userStoryName = storyName;
      _userStory = story;
      _weight = weight;
      _userRole = role;
      _progLang = lang;
      _domain = domain;    //applicable domain (criteria for winnowing down)
   } 
	
   // get weight and update weight
   public int getWeight()
   {
      return _weight;
   }
	
   public void updateWeight(int num)
   {
      _weight = num;
   }
   
   //Setters for values
   
   public void setUserStoryName(String name)
   {
      _userStoryName = name;
   }
   
   public void setUserStoryDesc(String desc)
   {
      _userStory = desc;
   }
   
   // other getters (for winnowing down)
   public String getProjectName()
   {
      return _projName;
   }
   
   public String getProjDesc()
   {
      return _projDesc;
   }
   
   public String getStoryName()
   {
      return _userStoryName;
   }
   
   public String getStory()
   {
      return _userStory;
   }
   
   public String getUserRole()
   {
      return _userRole;
   }
   
   public String getProjLang()
   {
      return _progLang;
   }
   
   public String getDomain()
   {
      return _domain;
   }
   
	 public String toString() {
		String str = "";

			str += _projName + " " +
		      _projDesc + " " +
		      _userStoryName + " " +
		      _userStory + " " +
		      _weight + " " +
		      _userRole + " " +
		      _progLang + " " +
		      _domain + " ";
			
			str+= "\n";
			
		return str;
	 }
}