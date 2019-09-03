package rpgtcc.endpoint;


import rpgtcc.model.Sheet;
import rpgtcc.repository.SheetRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sheet")
public class SheetEndPoint {
    private SheetRepository sheetDAO;
    private SheetEndPoint(SheetRepository sheetRepository){
        sheetDAO = sheetRepository;
    }


    @GetMapping
    public ResponseEntity<?> listOfAllSheets(){
        return new ResponseEntity<>(sheetDAO.findAll(), HttpStatus.OK);
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?>  findSheetByName(@PathVariable("id")long id){
        try{
            return  new ResponseEntity<>(sheetDAO.findById(id), HttpStatus.OK);
        }catch(Exception e){
            return  new ResponseEntity<>("Sheet Not Found", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(path = "/UserOwner/{id}")
    public ResponseEntity<?>  findSheetByUserOwner(@PathVariable("id")long id){
        try{
            return  new ResponseEntity<>(sheetDAO.findAllSheetBySheetUserId(id), HttpStatus.OK);
        }catch(Exception e){
            return  new ResponseEntity<>("Sheets Not Found", HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<?> saveSheet(@RequestBody Sheet Sheet){
        try {
            sheetDAO.save(Sheet);
            return new ResponseEntity<>(Sheet,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }


    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteSheet(@PathVariable("id")long id) {
        try {
            sheetDAO.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Sheet Not Found",HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping
    public ResponseEntity<?> alterar(@RequestBody Sheet Sheet) {
        if(sheetDAO.existsById(Sheet.getSheetId())){
            sheetDAO.save(Sheet);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Sheet não encontrado.",HttpStatus.NOT_FOUND);
        }
    }


}