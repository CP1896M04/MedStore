package lib;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pattern.model.DateTag;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class LibraryAssistant {
    public static final String ICON_IMAGE_LOC = "/resources/icon.png";
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    public static void setStageIcon(Stage stage) {
        stage.getIcons().add(new Image(ICON_IMAGE_LOC));
    }

    public static Object loadWindow(URL loc, String title, Stage parentStage) {
        Object controller = null;
        try {
            FXMLLoader loader = new FXMLLoader(loc);
            Parent parent = loader.load();
            controller = loader.getController();
            Stage stage = null;
            if (parentStage != null) {
                stage = parentStage;
            } else {
                stage = new Stage(StageStyle.DECORATED);
            }
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
            setStageIcon(stage);
        } catch (IOException ex) {

        }
        return controller;
    }
    public static String formatDateTimeString(Date date) {
        return DATE_TIME_FORMAT.format(date);
    }

    public static String formatDateTimeString(Long time) {
        return DATE_TIME_FORMAT.format(new Date(time));
    }

    public static String getDateString(Date date) {
        return DATE_FORMAT.format(date);
    }

    public static boolean validateEmailAddress(String emailID) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(emailID).matches();
    }
    public static boolean validatePhone(String phoneID){
        String regex="^[0-9]{10}$";
        Pattern pattern=Pattern.compile(regex);
        return pattern.matcher(phoneID).matches();

    }
    public static boolean validateAddress(String address){
        String regex="^[0-9\\s\\S]+$";
        Pattern pattern=Pattern.compile(regex);
        return pattern.matcher(address).matches();
    }
    public static boolean ktSo(String ktso){
        String regex="^[0-9]+$";
        Pattern pattern=Pattern.compile(regex);
        return pattern.matcher(ktso).matches();
    }
    public static void openFileWithDesktop(File file) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException ex) {

        }
    }
    public static String getMonthForInt(int num) {
        String month = "wrong";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (num >= 0 && num <= 11 ) {
            month = months[num];
        }
        return month;
    }
    public static void formatDate(DateTag dateTag){
        LocalDateTime today = LocalDateTime.now();
        Calendar calendar = Calendar.getInstance();
        dateTag.setDate(DateTimeFormatter.ISO_DATE.format(today));
        dateTag.setMonth(getMonthForInt(today.getMonthValue()));
        dateTag.setMonthNumber(today.getMonthValue());
        dateTag.setYear(today.getYear());
        int quarter = (today.getMonthValue() / 3) + 1;
        dateTag.setQuarter(quarter);
    }
}
