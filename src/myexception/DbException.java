package myexception;

public class DbException extends Exception  {
	
	public DbException() {
		super();
	}

	public DbException(String m) {
		super(m);
	}
	
	public DbException(Throwable cause) {
		super(cause);
	}
	
	public DbException(String m, Throwable cause) {
		super(m,cause);
	}

}
