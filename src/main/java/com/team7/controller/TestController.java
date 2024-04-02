package com.team7.controller;

import com.team7.model.Test;
import com.team7.db.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController()
public class TestController {
    @Autowired
    private TestRepository testRepository;
    @CrossOrigin(originPatterns = "http://localhost:3000")
    @GetMapping("/testbed")
    public ResponseEntity<Test> getTest(){
        Test rv = testRepository.findTestById(Integer.toUnsignedLong(1));
        if(rv == null){
            System.out.println("you are fucked");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        else{
            //HttpHeaders headers = new HttpHeaders();
            //headers.add("Access-Control-Allow-Origin", "http://localhost:3000");
            ResponseEntity<Test> res = new ResponseEntity<>( rv, HttpStatus.OK);
            System.out.println(res.getHeaders().toString());
        return res;
        }
    }
}
