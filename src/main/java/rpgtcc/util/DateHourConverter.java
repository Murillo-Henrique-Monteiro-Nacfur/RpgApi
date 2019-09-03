package hot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHourConverter {
    public Date StringToDate(String data){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formato.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public DateHourConverter(){

    }
}
