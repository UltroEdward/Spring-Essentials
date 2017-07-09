package beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Scope;

import beans.impl.TorrentLoader;
import beans.impl.ZipFileWorker;

@Configuration
public class SpringJavaBasedConfig {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	@Scope("singleton")
	public FileWorker fileWorker() {
		return new ZipFileWorker();
	}

	@Bean(name = "baseWorker")
	@Scope("prototype")
	@Description("Base bean")
	public FileWorker fileWorkerBase() {
		ZipFileWorker worker = new ZipFileWorker();
		worker.setCount(10);
		worker.setName("worker.pro");
		return worker;
	}

	@Bean
	public FileWorker fileWorkerFull() {
		return new ZipFileWorker(100, "worker-ultro", loader(), null);
	}

	@Bean
	public FileLoader loader() {
		return new TorrentLoader();
	}

}
