package rpgtcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import rpgtcc.model.Sheet;
import rpgtcc.repository.SheetRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SheetService {

    @Autowired
    private SheetRepository sheetDAO;

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

    public void deleteSheet(@PathVariable("id")long id) {
        sheetDAO.deleteById(id);
    }
}