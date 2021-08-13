package com.studentinfo.controllers;

import com.studentinfo.constants.GenericConstants;
import com.studentinfo.enums.LocalEnum;
import com.studentinfo.models.FileInfo;
import com.studentinfo.models.NewsSummary;
import com.studentinfo.models.TodoInfo;
import com.studentinfo.utils.ResponsePayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.Document;
import java.io.IOException;
import java.util.Locale;

@RestController

@RequestMapping(value = "/todo/")
public class TODORestController {

    @GetMapping(value =  "greeting/{name}")
    public ResponseEntity<?> getRequestSampleFirst(@PathVariable("name") String name) {
        return new ResponseEntity<Object>(GenericConstants.FIRST_GET_SAMPLE + name,HttpStatus.OK);
    }
     /*
      * This service accepting param from url
      * accepting header param
     */
    @GetMapping(value = "country/greeting/{name}")
   public ResponseEntity<?> countryGreeting(@PathVariable("name") String name, @RequestHeader("local") String local) {
        String message = "Namaste " ;
        LocalEnum code = LocalEnum.valueOf(local.toUpperCase(Locale.ROOT));
        switch (code) {
            case IN:
                message = "Namaste ";
                break;
            case FR:
                message = "Bonjour ";
                break;
            case IT:
                message = "Buongiorno ";
                break;
        }
       message = message +  name;
       return new ResponseEntity<Object>(message,HttpStatus.OK);
   }

   /*
    * This service accepting params from the url todo/greet/Ashish/lastname/Awasthi
    * This service accepting param param=value and form parameters todo/greet/Ashish/lastname/Awasthi?message=Hi
    * This accepting optional params todo/greet/Ashish/lastname/Awasthi
    */
   @GetMapping(value = "greet/{firstName}/lastname/{lastName}")
   public ResponseEntity<?> multipleURLParams(@PathVariable("firstName") String firstName,
                                              @PathVariable("lastName") String lastName,
                                              @RequestParam(value = "message", required = false, defaultValue = "Hello") String message) {
        String text = message + GenericConstants.BLANK_SPACE + firstName + GenericConstants.BLANK_SPACE + lastName;
       return new ResponseEntity<Object>(text,HttpStatus.OK);
   }

    /*
     * Sample post request with message
     * Post request accepting param meter
     */

   @PostMapping(value = "greet/message")
   public ResponseEntity<?>todoBodyRequest(@RequestBody TodoInfo todoInfo) {
       String message = todoInfo.getMessage() + GenericConstants.BLANK_SPACE + todoInfo.getFirstName() + GenericConstants.BLANK_SPACE + todoInfo.getLastName();
       return new ResponseEntity<Object>(message,HttpStatus.OK);
   }

    @PostMapping(value = "country/greet/message")
    public ResponseEntity<?>todoBodyRequest(@RequestBody TodoInfo todoInfo, @RequestHeader("local") String local) {
        String message = "Namaste " ;
        LocalEnum code = LocalEnum.valueOf(local.toUpperCase(Locale.ROOT));
        switch (code) {
            case IN:
                message = "Namaste ";
                break;
            case FR:
                message = "Bonjour ";
                break;
            case IT:
                message = "Buongiorno ";
                break;
        }
        String text = message + GenericConstants.BLANK_SPACE + todoInfo.getFirstName() + GenericConstants.BLANK_SPACE + todoInfo.getLastName();
        return new ResponseEntity<Object>(text,HttpStatus.OK);
    }

    @PutMapping(value = "put/message")
    public ResponseEntity<?>putRequest(@RequestBody TodoInfo info) {
        return new ResponseEntity<Object>("Message",HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/message")
    public ResponseEntity<?>deleteRequest(@PathVariable("name") String name,
                                           @RequestParam(value = "message", required = false,
                                                   defaultValue = "Hello") String msg) {
        return new ResponseEntity<Object>("Message",HttpStatus.OK);
    }

    @PostMapping(value = "uploadfile")
    public ResponseEntity<?> uploadFileOnCloud(@RequestParam(value = "filename", required = false, defaultValue = "Hello") String fileName,
                                               @RequestParam(value = "username", required = false, defaultValue = "Ashish") String userName,
    @RequestPart(value = "uploadFile") MultipartFile documentFile) {
       String returnTxt = "FileName: " + fileName + GenericConstants.BLANK_SPACE + "UserName: " + userName;
       if (documentFile != null) {
           returnTxt = returnTxt + GenericConstants.BLANK_SPACE  + "We have received the file";
       }
        return new ResponseEntity<Object>(returnTxt,HttpStatus.OK);
    }

    @GetMapping(value = "googlenews")
   public ResponseEntity<?>googleNews() {
        ResponsePayload payload = new ResponsePayload();
        String uri = GenericConstants.GOOGLE_BASE_URL + GenericConstants.NEWS_PARAMS + GenericConstants.GOOGLE_NEWS_API_KEY;
        RestTemplate restTemplate = new RestTemplate();
        payload.setCode("Success");
        payload.setMessage("Received News");
        System.out.println("############" + uri );
        try {
            payload.setObject(payload.setObject(restTemplate.getForObject(uri, NewsSummary.class)));
         } catch (RestClientResponseException e) {
            return ResponseEntity
                    .status(e.getRawStatusCode())
                    .body(e.getResponseBodyAsString());
        }
        return new ResponseEntity<>(payload,HttpStatus.OK);
   }




}
