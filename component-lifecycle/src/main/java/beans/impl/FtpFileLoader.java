package beans.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beans.FileLoader;

@Component
@Scope("prototype")
public class FtpFileLoader implements FileLoader {

	public String getFile() {
		System.out.println("ftp get file");
		return "FILE....";
	}

	public String toString() {
		return "Ftp Loader";
	}
}
