package controller;

import pattern.model.Staff;

public class Controller {
    private  Staff staff;

    public Controller() {
       checkLogin();
    }

    public void checkLogin(){
        if(staff==null){
            System.out.println("Not login");
        }
    }

    public Staff getStaff() {
        return staff;
    }
}
