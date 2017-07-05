package beans;

public interface FileWorker {

	public void readFromFile(String file);

	public void writeToFile(String file);

	public void setName(String name);

	public void setCount(int count);

	public String getName();
	
	public FileLoader getLoader();

	public void init();

	public void destroy();

	public static FileWorker getInstance() {
		return null;
	}

	public  static String getHi(){
		return "HELLO!";
	}

}
