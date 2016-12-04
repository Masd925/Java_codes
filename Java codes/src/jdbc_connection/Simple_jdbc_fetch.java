package jdbc_connection;

public class Simple_jdbc_fetch {

	public static void main(String[] args) {
		PersonListFetcher plf = new PersonListFetcher();
		System.out.println(plf.fetch());
	}
    
	
}
