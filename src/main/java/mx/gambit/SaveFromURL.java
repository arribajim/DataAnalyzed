package mx.gambit;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;

import org.springframework.util.FileCopyUtils;

public class SaveFromURL {
	
	private String url;
	private String fileOutput;
	
	public SaveFromURL(String url) throws Exception {
		// TODO Auto-generated constructor stub
		this.setUrl(url);
		
		save();
	}
	public SaveFromURL() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * save to tmp dir
	 */
	public void save() throws Exception  {
		
		URL connection;
		connection = new URL(url);

		InputStream is = connection.openStream();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		FileCopyUtils.copy(is, bos);
		File output = new File("/tmp/" +getFileOutput());
		
		FileCopyUtils.copy(bos.toByteArray(), output);
		
		close(is,bos);//TODO check if this fail
		
	}
	
	
	public void close(InputStream is ,ByteArrayOutputStream bos) throws IOException {
		bos.close();
		is.close();
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the fileOutput
	 */
	public String getFileOutput() {
		if(fileOutput==null) {
			fileOutput = "raw_"+Calendar.getInstance().getTimeInMillis();
		}
		return fileOutput;
	}
	/**
	 * @param fileOutput the fileOutput to set
	 */
	public void setFileOutput(String fileOutput) {
		this.fileOutput = fileOutput;
	}
}
