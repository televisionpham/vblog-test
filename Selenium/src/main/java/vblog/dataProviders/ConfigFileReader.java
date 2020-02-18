package vblog.dataProviders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import vblog.enums.DriverType;
import vblog.enums.EnvironmentType;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "configs\\Configuration.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDriverPath() {
		String ret = properties.getProperty("driverPath");
		if (ret != null) {
			return ret;
		}
		throw new RuntimeException("driverPath not specified in the Configuration.properties file");
	}
	
	public long getImplicitlyWait() {
		String ret = properties.getProperty("implicitlyWait");
		if (ret != null) {
			return Long.parseLong(ret);
		}
		throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file");
	}
	
	public String getApplicatonUrl() {
		String ret = properties.getProperty("url");
		if (ret != null) {
			return ret;
		}
		throw new RuntimeException("url not specified in the Configuration.properties file");
	}
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome")) {
			return DriverType.CHROME;
		} else if (browserName.equals("firefox")) {
			return DriverType.FIREFOX;
		} else {
			throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
		}
	}
	
	public EnvironmentType getEnvironment() {
		String environment = properties.getProperty("environment");
		if (environment == null || environment.equals("local")) {
			return EnvironmentType.LOCAL;
		} else if (environment.equals("remote")) {
			return EnvironmentType.REMOTE;
		} else {
			throw new RuntimeException("Environment Key value in Configuration.properties is not matched : " + environment);
		}
	}
	
	public Boolean getBrowserWindowSize() {
		 String windowSize = properties.getProperty("windowMaximize");
		 if(windowSize != null) return Boolean.valueOf(windowSize);
		 return true;
	}
}
