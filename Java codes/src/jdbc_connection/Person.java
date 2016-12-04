package jdbc_connection;

public class Person {
    private int id;
    private String etunimi;
    private String sukunimi;
    private String phone_number;
	
    public Person(int id, String etunimi, String sukunimi, String phone_number) {
		this.id = id;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", etunimi=" + etunimi + ", sukunimi="
				+ sukunimi + ", phone_number=" + phone_number + "]";
	}
       
}
