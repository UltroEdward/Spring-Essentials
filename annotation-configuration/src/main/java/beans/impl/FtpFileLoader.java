package beans.impl;

import org.springframework.stereotype.Component;

import beans.FileLoader;

@Component
public class FtpFileLoader implements FileLoader {

	public String getFile() {
		System.out.println("ftp get file");
		return "FILE....";
	}

	public String toString() {
		return "Ftp Loader";
	}
}
