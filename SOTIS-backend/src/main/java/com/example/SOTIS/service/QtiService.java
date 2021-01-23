package com.example.SOTIS.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.Odgovor;
import com.example.SOTIS.model.DTO.PitanjeDTO;
import com.example.SOTIS.model.DTO.TestViewDTO;
import com.example.SOTIS.repository.OdgovoriRepository;
import com.example.SOTIS.repository.PitanjeRepository;
import com.example.SOTIS.repository.PredmetRepository;
import com.example.SOTIS.repository.TestRepository;
import com.example.SOTIS.repository.UcenikRepository;
import com.example.SOTIS.repository.UcenikTestRepository;

@Service
public class QtiService {
	@Autowired
	TestRepository testRepo;

	@Autowired
	UcenikRepository ucenikRepo;

	@Autowired
	OdgovoriRepository odgovorRepo;

	@Autowired
	UcenikTestRepository ucenikTestRepo;

	@Autowired
	PredmetRepository predmetRepo;

	@Autowired
	PitanjeRepository pitanjeRepo;
	
	
	@Autowired
	TestService testService;


public byte[] generateQTI(Long testId) {
		
		
		TestViewDTO test = testService.findById(testId);
		
		// povratna vrednost funkcije je zip folder sa qti xml fajlovima
		File zip;
		try {
			if (!makeFolders(testId)) {
				System.out.println("Folder already exist");
			}
						
			
			String xmlStr = "<?xml version='1.0' encoding='UTF-8'?>"			
							+ "<qti-assessment-test identifier=\""
							+ test.getId()
							+ "\" title=\""
							+ test.getId()
							+ "\" xmlns=\"http://www.imsglobal.org/xsd/imsqtiasi_v3p0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocatio=\"http://www.imsglobal.org/xsd/imsqtiasi_v3p0 https://purl.imsglobal.org/spec/qti/v3p0/schema/xsd/imsqti_asiv3p0_v1p0.xsd\">\r\n"
							+ "<qti-test-part identifier=\"Part 1\" navigation-mode=\"linear\" submission-mode=\"individual\">\r\n"
							+ "<qti-assessment-section identifier=\"set\" title=\"Section 1\" visible=\"true\">\r\n"
							+ "<qti-selection select=\"2\">";
			
			
			int redniBrojPitanja = 1;
			for(PitanjeDTO p : test.getPitanje()) {
				
				Boolean pitanjeBool = napraviPitanjeXML(test, p, redniBrojPitanja);
				xmlStr += " <qti-assessment-item-ref href=\""
						+ test.getId()
						+ "-"
						+ redniBrojPitanja
						+ ".xml\" identifier=\""
						+ redniBrojPitanja
						+ "\"/>";
				redniBrojPitanja ++;
			}
			
			
			xmlStr += "</qti-selection>\r\n"
					+ "</qti-assessment-section>\r\n"
					+ "</qti-test-part>\r\n"
					+ "</qti-assessment-test>";
							
			
		    BufferedWriter writer = new BufferedWriter(new FileWriter("QTI/test-" + testId.toString() + "-QTI" + "/test-" + testId.toString() + "QTI.xml"));
		    writer.write(xmlStr);
		    
		    writer.close();

		    File dir = new File("QTI/test-" + testId.toString() + "-QTI");
		    zipDirectory(dir, "QTI/test-" + testId.toString() + "-QTI.zip");

		    zip = new File("QTI/test-" + testId.toString() + "-QTI.zip");
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		try {
			return convertFileContentToBlob(zip);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Boolean napraviPitanjeXML(TestViewDTO test, PitanjeDTO p, int redniBrojPitanja) {

		String pitanjeXML = "<?xml version='1.0' encoding='UTF-8'?>";
		
		pitanjeXML += "<qti-assessment-item adaptive=\"false\" identifier=\""
				+ "TEST-"
				+ test.getId() + "-" + redniBrojPitanja
				+ "\" time-dependent=\"false\" title=\""
				+ "Question " + redniBrojPitanja
				+ "\" xmlns=\"http://www.imsglobal.org/xsd/imsqtiasi_v3p0\" xmlns:xi=\"http://www.w3.org/2001/XInclude\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.imsglobal.org/xsd/imsqtiasi_v3p0 https://purl.imsglobal.org/spec/qti/v3p0/schema/xsd/imsqti_asiv3p0_v1p0.xsd\">\r\n"
				+ "	<qti-response-declaration base-type=\"identifier\" cardinality=\"single\" identifier=\"RESPONSE\">\r\n"
				+ "		<qti-correct-response>\r\n"
				+ "			<qti-value>10</qti-value>\r\n"
				+ "		</qti-correct-response>\r\n"
				+ "	</qti-response-declaration>\r\n"
				+ "	<qti-outcome-declaration base-type=\"float\" cardinality=\"single\" identifier=\"SCORE\"/>\r\n"
				+ "	<qti-item-body>\r\n"
				+ "		<qti-choice-interaction max-choices=\"1\" response-identifier=\"RESPONSE\" shuffle=\"true\">"
				
				+ "<qti-prompt>"
				+ p.getTekst()
				+ "</qti-prompt>\r\n"
				+ "";
		
		for(Odgovor o : p.getOdgovori()) {
			pitanjeXML += "<qti-simple-choice fixed=\"false\" identifier=\""
					+ o.getId()
					+ "\">"
					+ o.getTekst()
					+ "</qti-simple-choice>\r\n";
		}
		
		pitanjeXML += "		</qti-choice-interaction>\r\n"
				+ "	</qti-item-body>\r\n"
				+ "	<qti-response-processing template=\"\"/>\r\n"
				+ "</qti-assessment-item>";
		
		
	    try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("QTI/test-" + test.getId().toString() + "-QTI/questions/" + "test" + test.getId().toString() + "-" + redniBrojPitanja + ".xml"));
			writer.write(pitanjeXML);
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean makeFolders(Long id) {

		if (!new File("QTI").exists()) {
		    File folderQTI = new File("QTI");
		    Boolean b = folderQTI.mkdir();
		}
		
	      //Creating a File object
	      File folder1 = new File("QTI/test-" + id.toString() + "-QTI");
	      //Creating the directory
	      boolean bool = folder1.mkdir();
	      if(bool){
		      File folder2 = new File("QTI/test-" + id.toString() + "-QTI" + "/questions");
		      //Creating the directory
		      boolean bool2 = folder2.mkdir();
		      
		      if(bool2) {
			         System.out.println("Directory created successfully");
		      } else {
			         System.out.println("Nije dobro kreiran drugi folder");
			         return false;
		      }
	      }else{
	         System.out.println("Sorry couldn’t create specified directory");
	      }
	      
	      
	      return bool;
	}
	

    private void zipDirectory(File dir, String zipDirName) {
        try {
            List<String> filesListInDir = new ArrayList<String>();

            populateFilesList(filesListInDir, dir);

            FileOutputStream fos = new FileOutputStream(zipDirName);
            ZipOutputStream zos = new ZipOutputStream(fos);
            for(String filePath : filesListInDir){
                System.out.println("Zipping "+filePath);
                ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
                zos.putNextEntry(ze);
                
                FileInputStream fis = new FileInputStream(filePath);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Pomocna funkcija za zipDirectory funkciju
    private void populateFilesList(List<String> filesListInDir, File dir) throws IOException {
        File[] files = dir.listFiles();
        for(File file : files){
            if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
            else populateFilesList(filesListInDir, file);
        }
    }

    public byte[] convertFileContentToBlob(File file) throws IOException {
    	   // create file object
    	   //File file = new File(filePath);
    	   // initialize a byte array of size of the file
    	   byte[] fileContent = new byte[(int) file.length()];
    	   FileInputStream inputStream = null;
    	   try {
    		// create an input stream pointing to the file
    		inputStream = new FileInputStream(file);
    		// read the contents of file into byte array
    		inputStream.read(fileContent);
    	   } catch (IOException e) {
    		throw new IOException("Unable to convert file to byte array. " + 
    	              e.getMessage());
    	   } finally {
    		// close input stream
    		if (inputStream != null) {
    	           inputStream.close();
    		}
    	   }
    	   return fileContent;
    	}

}
