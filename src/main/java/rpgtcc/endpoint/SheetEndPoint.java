package rpgtcc.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import rpgtcc.model.Sheet;
import org.springframework.web.bind.annotation.*;
import rpgtcc.service.SheetService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sheet")
public class SheetEndPoint {

    @Autowired
    private SheetService sheetService;

    @PostMapping
    public Sheet saveSheet(@RequestBody Sheet Sheet){
        return sheetService.saveSheet(Sheet);
    }

    @GetMapping
    public List<Sheet> listOfAllSheets(){
        return sheetService.listOfAllSheets();
    }

    @GetMapping(path = "/{id}")
    public Optional<Sheet> findSheetById(@PathVariable("id")Long id){
        return sheetService.findSheetById(id);
    }

    @GetMapping(path = "/playersInMatch/{id}")
    public List<Sheet> findAllSheetByMatchId(@PathVariable("id")Long id){
        return sheetService.findAllSheetByMatchId(id);
    }

    @GetMapping(path = "/UserOwner/{id}")
    public List<Sheet> findSheetByUserOwner(@PathVariable("id")Long id){
        return sheetService.findSheetByUserOwner(id);
    }

    @PutMapping
    public Sheet update(@RequestBody Sheet Sheet) {
        return sheetService.saveSheet(Sheet);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSheet(@PathVariable("id")Long id) {
        sheetService.deleteSheet(id);
    }
}