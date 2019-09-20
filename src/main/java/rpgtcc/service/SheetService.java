package rpgtcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rpgtcc.model.Match;
import rpgtcc.model.Sheet;
import rpgtcc.repository.MatchRepository;
import rpgtcc.repository.SheetRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SheetService {

    @Autowired
    private SheetRepository sheetDAO;

    @Autowired
    private MatchRepository matchDAO;

    public Sheet saveSheet(Sheet Sheet){
        return sheetDAO.save(Sheet);
    }

    public List<Sheet> listOfAllSheets(){
        return StreamSupport.stream(sheetDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Sheet> findSheetById(Long id){
        return  sheetDAO.findById(id);
    }

    public List<Sheet> findAllSheetByMatchId(Long id){
        return sheetDAO.findSheetByMatch_MatchId(id);
    }

    public List<Sheet> findSheetByUserOwner(Long id){
        return sheetDAO.findAllSheetBySheetUser_Id(id);
    }

    public void deleteSheet(Long id) {
        sheetDAO.deleteById(id);
    }

    public Sheet addSheetToMatch(Integer pin, Sheet sheet) {
        Match match = this.matchDAO.findMatchByPin(pin);
        sheet.setMatch(match);
        return this.sheetDAO.save(sheet);
    }
}