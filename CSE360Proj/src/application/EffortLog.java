package application;

public class EffortLog {
	private String projectName;
	private String id;
    private String date;
    private String start;
    private String stop;
    private String delta;
    private String lcs;
    private String category;
    private String specifics;

    public EffortLog(String projectName, String id, String date, String start, String stop, String delta, String lcs, String category, String specifics) {
        this.projectName = projectName;
    	this.id = id;
        this.date = date;
        this.start = start;
        this.stop = stop;
        this.delta = delta;
        this.lcs = lcs;
        this.category = category;
        this.specifics = specifics;
    }

    // Getter and Setter methods for each field
    public String getProjectName() {
        return projectName;
    }
    
    public void setProjectName(String projectName) {
    	this.projectName = projectName;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getDelta() {
        return delta;
    }

    public void setDelta(String delta) {
        this.delta = delta;
    }

    public String getLcs() {
        return lcs;
    }

    public void setLcs(String lcs) {
        this.lcs = lcs;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSpecifics() {
        return specifics;
    }

    public void setSpecifics(String specifics) {
        this.specifics = specifics;
    }
    public String toString() {
        return "EffortLog{" +
        		"project=" + projectName+
                ", id=" + id +
                ", date='" + date + '\'' +
                ", start='" + start + '\'' +
                ", stop='" + stop + '\'' +
                ", delta='" + delta + '\'' +
                ", lcs='" + lcs + '\'' +
                ", category='" + category + '\'' +
                ", specifics='" + specifics + '\'' +
                '}';
    }
}

