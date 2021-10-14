package com.wizer.wizer.services.serviceImpl;

import com.wizer.wizer.dto.ErrorValidationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created By Samuel Sawyerr
 */
@Service
@Slf4j
public class MapServiceImpl  {



    public ResponseEntity<?> MapValidationService(BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResponseEntity.ok(new ErrorValidationResponse("BAD REQUEST", errors));
        }

        log.info("binding result {}",bindingResult);

        return null ;
    }


}

