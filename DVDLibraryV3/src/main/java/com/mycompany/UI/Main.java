


package com.mycompany.UI;

import com.mycompany.Operations.DVDLibrary;
//import com.mycompany.dao.FileIO;
import com.mycompany.dto.Controller;
import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
//        FileIO file = new FileIO();
//        DvdLibraryDao lib = new DVDLibrary(file.readDVDs("mylibrary.dlb"));
//        Controller cont = new Controller(lib);
//        cont.runProgram();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
 //       DvdLibraryDao lib = (DVDLibrary) ctx.getBean("library");
        Controller cont =  (Controller) ctx.getBean("dvdcontroller");
        cont.runProgram();        
                
    }
}
