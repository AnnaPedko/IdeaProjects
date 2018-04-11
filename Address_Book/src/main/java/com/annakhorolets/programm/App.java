package com.annakhorolets.programm;

import com.annakhorolets.programm.services.impl.ContactServiceImpl;
import com.annakhorolets.programm.view.impl.CmdLineService;
import com.annakhorolets.programm.view.impl.impl.CmdLineServiceImpl;

public class App {
    public static void main(String []args) {
        CmdLineService cmd = new CmdLineServiceImpl(new ContactServiceImpl());
        cmd.runMenu();
    }
}
