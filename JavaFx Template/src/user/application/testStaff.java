package user.application;

import user.dao.StaffDAO;
import user.model.Staff;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class testStaff {
    public static void main(String[] args) throws ParseException {
        StaffDAO staffDAO = new StaffDAO();
        String sDate1="31/12/1998";
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        Staff staff = new Staff(1,"admin","Tinh","khung",date1,"abc","M","015978643","tinh123","123456");
        staffDAO.add(staff);
    }


}
