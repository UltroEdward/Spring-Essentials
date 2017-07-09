package beans.impl;

import beans.FileLoader;

public class FtpFileLoader implements FileLoader {

	public String getFile() {
		System.out.println("ftp get file");
		return "FILE....";
	}

	public String toString() {
		return "Ftp Loader";
	}
}
