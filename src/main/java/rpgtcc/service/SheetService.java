package rpgtcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;
import rpgtcc.model.Match;
import rpgtcc.model.Sheet;
import rpgtcc.repository.MatchRepository;
import rpgtcc.repository.SheetRepository;
import rpgtcc.util.Utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SheetService {

    @Autowired
    private SheetRepository sheetDAO;

    @Autowired
    private MatchRepository matchDAO;

    @Autowired
    private Utils utils;

    public Sheet saveSheet(Sheet Sheet){
        return sheetDAO.save(Sheet);
    }

    public List<Sheet> listOfAllSheets(){
        return  this.utils.removeSubSheetFromMatch((List<Sheet>) sheetDAO.findAll());
    }

    public Sheet findSheetById(Long id){
        Sheet sheet = this.sheetDAO.findById(id).orElseThrow(
                () -> new InvalidConfigurationPropertyValueException("Sheet", id,
                        "Opa! Não conseguimos achar o personagem desejado!")
        );

        sheet.getMatch().setSheets(null);
        return sheet;
    }

    public List<Sheet> findAllSheetByMatchId(Long id){
        return this.utils.removeSubSheetFromMatch(sheetDAO.findSheetByMatch_Id(id));
    }

    public List<Sheet> findSheetByUserOwner(Long id){
        return this.utils.removeSubSheetFromMatch(sheetDAO.findAllSheetByUser_Id(id));
    }

    public void deleteSheet(Long id) {
        sheetDAO.deleteById(id);
    }

    public Sheet addSheetToMatch(Integer pin, Sheet sheet) {
        Match match = this.matchDAO.findMatchByPin(pin);
        sheet.setMatch(match);
        sheet = this.sheetDAO.save(sheet);
        sheet.getMatch().setSheets(null);
        return sheet;
    }
}