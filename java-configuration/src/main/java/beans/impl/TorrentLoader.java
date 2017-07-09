package beans.impl;

import beans.FileLoader;

public class TorrentLoader implements FileLoader {

	@Override
	public String getFile() {
		return "Get file";
	}

	public String toString() {
		return "Torrent Loader";
	}

}
