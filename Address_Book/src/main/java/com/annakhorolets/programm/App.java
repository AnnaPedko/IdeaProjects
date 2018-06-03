package com.annakhorolets.programm;

import com.annakhorolets.programm.dao.ContactDao;
import com.annakhorolets.programm.dao.impl.DBContactDao;
import com.annakhorolets.programm.services.ContactService;
import com.annakhorolets.programm.services.impl.ContactServiceImpl;
import com.annakhorolets.programm.view.impl.CmdLineService;
import com.annakhorolets.programm.view.impl.impl.CmdLineServiceImpl;

public class App {
    public static void main(String []args) {
        ContactDao contactDao = new DBContactDao();
        //ContactDao contactDao = new FileSystemContactDaoImpl();
        ContactService contactService = new ContactServiceImpl(contactDao);
        CmdLineService cmd = new CmdLineServiceImpl(contactService);

        cmd.runMenu();
    }
}
