package beans.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import annotations.UpperCase;
import beans.FileLoader;
import beans.FileWorker;

@Component("zipfileworker")
public class ZipFileWorker implements FileWorker {

	@Value("4")
	private int count;
	@Value("hello-world-worker")
	@UpperCase
	private String name;
	@Autowired
	@Qualifier("torrentloader")
	private FileLoader loader;

	private List<String> consumers;

	public static ZipFileWorker getInstance() {
		return new ZipFileWorker();
	}

	public ZipFileWorker() {
		System.out.println("Constructor with no params");
	}

	public ZipFileWorker(int count, String name) {
		System.out.println("Constructor with primitives");
		this.count = count;
		this.name = name;
	}

	public ZipFileWorker(FileLoader loader) {
		System.out.println("Constructor with object");
		this.loader = loader;
	}

	public ZipFileWorker(List<String> consumer) {
		System.out.println("Constructor with list");
		this.consumers = consumer;
	}

	public ZipFileWorker(int count, String name, FileLoader loader, List<String> consumer) {
		System.out.println("Constructor with all");
		this.loader = loader;
		this.count = count;
		this.name = name;
		this.consumers = consumer;

	}

	public void readFromFile(String file) {
		System.out.println("reading compressed file");
	}

	public void writeToFile(String file) {
		System.out.println("writing compressed file");
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FileLoader getLoader() {
		return loader;
	}

	public void setLoader(FileLoader loader) {
		this.loader = loader;
	}

	public List<String> getConsumers() {
		return consumers;
	}

	public void setConsumers(List<String> consumers) {
		this.consumers = consumers;
	}

	@Override
	@PostConstruct
	public void init() {
		System.out.println("Init");

	}

	@Override
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy: " + this);

	}

	public static String getHi() {
		return "HELLO-IMPL!";
	}

	public String toString() {
		return String.format("CompressedFileWorker: name %s, count: %d, consumers: %s, loader: %s", name, count,
				consumers, loader == null ? "null" : loader.toString());
	}

}
