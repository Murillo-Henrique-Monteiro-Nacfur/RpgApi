package rpgtcc.util;

import org.springframework.stereotype.Service;
import rpgtcc.model.Match;
import rpgtcc.model.Sheet;

import java.util.List;

@Service
public class Utils {

    public List<Sheet> removeSubSheetFromMatch(List<Sheet> list){

        if(list == null){
            return null;
        }

        for (Sheet sheet : list) {
            int i = list.indexOf(sheet);
            if(sheet.getMatch() != null){
                sheet.getMatch().setSheets(null);
            }
            list.set(i, sheet);
        }
        return list;
    }
    public List<Match> removeSubMatchFromSheet(List<Match> listMatch){

        if(listMatch == null){
            return null;
        }

        for (Match match : listMatch ) {
            int i = listMatch.indexOf(match);
            match = removeMatchFromSheet(match);
            listMatch.set(i,match);
        }
        return listMatch;
    }

    public Match  removeMatchFromSheet(Match match) {

        if(match == null){
            return null;
        }

        List<Sheet> listSheet = match.getSheets();
        for (Sheet sheet : listSheet) {
            int y = listSheet.indexOf(sheet);
            sheet.setMatch(null);
            listSheet.set(y, sheet);
        }
        match.setSheets(listSheet);
        return  match;
    }
}
