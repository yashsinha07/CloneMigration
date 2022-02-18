package com.yashsinha.clonemigration.controllers;

import com.yashsinha.clonemigration.model.DataJSON;
import com.yashsinha.clonemigration.model.ResponseClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cloneMigrationController {

    @GetMapping(value="/app/{orgId}/migrate")
    public ResponseEntity<ResponseClass> migrateOrganisationClients(@RequestHeader("Authorization") String header, @PathVariable String orgId){

        int id = Integer.parseInt(orgId);

        ResponseClass response = new ResponseClass();
        DataJSON dataJSON = new DataJSON();

        if(id > 1000 && id < 1099){
            response.setHttpCode(HttpStatus.OK.toString());
            dataJSON.setMessage("Migration Successful.");
            dataJSON.setSuccess(true);
            response.setData(dataJSON);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
