package beans.impl;

import org.springframework.stereotype.Component;

import beans.FileLoader;

@Component	
public class Loader implements FileLoader {
	
	public Loader(){
		System.out.println(toString());
	}

	@Override
	public String getFile() {
		// TODO Auto-generated method stub
		return null;
	}

	public String toString() {
		return "Loader";
	}
}
