package beans.impl;

import org.springframework.stereotype.Component;

import beans.FileLoader;

@Component("torrentloader")
public class TorrentLoader implements FileLoader {

	@Override
	public String getFile() {
		return "Get file";
	}

	public String toString() {
		return "Torrent Loader";
	}

}
