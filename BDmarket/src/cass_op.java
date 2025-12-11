
public class cass_op {
	 private int id_op;
	    private java.sql.Date Date;
	    private int Sum;
	    private int id_cassira;
	    private int id_cassa;

	    public cass_op(int id_op, java.sql.Date Date, int Sum, int id_cassira, int id_cassa) {
	        this.id_op = id_op;
	        this.Date = Date;
	        this.Sum = Sum;
	        this.id_cassira = id_cassira;
	        this.id_cassa = id_cassa;
	    }

	    public int getId_op() {
	        return id_op;
	    }

	    public java.sql.Date getDate() {
	        return Date;
	    }

	    public int getSum() {
	        return Sum;
	    }

	    public int getId_cassira() {
	        return id_cassira;
	    }

	    public int getId_cassa() {
	        return id_cassa;
	    }
}
