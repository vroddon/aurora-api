package project.aurora.api.utils;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.aurora.api.entity.User;

public class GenerateZipFile {
	
	public static void createAndSendFile(User user, CustomConfiguration customConfiguration) {
		File file = generateFileContent(user, customConfiguration.getTempPath());
		createZipFile(file, customConfiguration.getTempPath() + user.getId()+".zip");
		File zipFile = new File(customConfiguration.getTempPath() + user.getId()+".zip");
		try {
			SendEmail.sendZipFile(user.getEmail(),zipFile, customConfiguration);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zipFile.delete();

	}
	
	private static void createZipFile(File userFile, String zipFilePath){
	    try   
	    {  
			//Source files  
			String fileName1 = userFile.getPath();  
			//Zipped file  
			String zipFilename = zipFilePath;  
			File zipFile = new File(zipFilename);  
			FileOutputStream fos  = new FileOutputStream(zipFile);              
			ZipOutputStream zos = new ZipOutputStream(fos);  
			zipFile(fileName1, zos);  
		    zos.close(); 
		    userFile.delete();
	    }   
	    catch (IOException e)   
	    {  
	      e.printStackTrace();  
	    }  
	}
	
	private static void zipFile(String fileName, ZipOutputStream zos) throws IOException  
	  {  
	    final int BUFFER = 1024;  
	    BufferedInputStream bis = null;  
	    try  
	    {  
	      File file = new File(fileName);  
	      FileInputStream fis = new FileInputStream(file);  
	      bis = new BufferedInputStream(fis, BUFFER);            
	  
	      // ZipEntry --- Here file name can be created using the source file  
	      ZipEntry zipEntry = new ZipEntry(file.getName());          
	      zos.putNextEntry(zipEntry);  
	      byte data[] = new byte[BUFFER];  
	      int count;  
	      while((count = bis.read(data, 0, BUFFER)) != -1)   
	      {  
	        zos.write(data, 0, count);  
	      }    
	      // close entry every time  
	      zos.closeEntry();  
	    }   
	    finally  
	    {  
	      try   
	      {  
	        bis.close();  
	      }   
	      catch (IOException e)   
	      {  
	        e.printStackTrace();  
	      }    
	    }  
	  }  
	
	public static File generateFileContent(User user, String tempPath) {

		String fileContent = "";
		try {
			fileContent = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(user.toJsonMap());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		writeFile(tempPath + user.getId() + ".json", fileContent);
		File file = new File(tempPath + user.getId() + ".json");
		return file;
	}
	
	public static void writeFile(String fileName, String content) {

        Path path = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
        	writer.append(content);
        	writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
