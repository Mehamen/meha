
public class cassir {
		private int id_cassira;
	    private String name;
	    private String surname;
	    private String otchestvo;
	    private String job_title;

	    public cassir(int id_cassira, String name, String surname, String otchestvo, String job_title) {
	        this.id_cassira = id_cassira;
	        this.name = name;
	        this.surname = surname;
	        this.otchestvo = otchestvo;
	        this.job_title = job_title;
	    }

	    public int getId_cassira() {
	        return id_cassira;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getSurname() {
	        return surname;
	    }

	    public String getOtchestvo() {
	        return otchestvo;
	    }

	    public String getJob_title() {
	        return job_title;
	    }
}
