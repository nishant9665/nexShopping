package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	 
	public ConfigDataProvider(){
		
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fs = new FileInputStream(src);
			pro = new Properties();
			
			pro.load(fs);
			
		} 
		catch (Exception e) 
		{
		System.out.println("any thing go wrong"+e.getMessage());
		}
	}
	public String getchormePathUrl()
	{
		String url=pro.getProperty("chromePath");
		return url;
	}
		public String getiepathUrl()
		{
			String url=pro.getProperty("IEPath");
			return url;
			}
		
			public String getappliactionUrl()
			{
				String url=pro.getProperty("url");
				return url;
			}
	}
	
	 


