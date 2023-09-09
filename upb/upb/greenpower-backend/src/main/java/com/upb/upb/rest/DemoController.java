//package com.upb.upb.rest;
//
//import com.example.springbootdemo.dto.User;
//import com.example.springbootdemo.dto.UserResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import static org.springframework.http.ResponseEntity.ok;
//
///**
// * RestController
// *
// * @author Marcos Quispe
// * @since 1.0
// */
//@Slf4j
//@RestController
//@RequestMapping("/api/mc4")
//public class DemoController {
//
//    @GetMapping
//    public String test() {
//        log.info("test!!");
//        return "Hola mundo!!";
//    }
//
//    @GetMapping("/user/{name}")
//    public ResponseEntity<String> user(@PathVariable(value = "name") String name, @RequestParam(value = "age") Integer age) {
//        return ok().body(String.format("Hola %s %d!", name, age));
//    }
//
//    @GetMapping("/user")
//    public ResponseEntity<User> user(@RequestParam(value = "codigo") Integer codigo, @RequestBody User user) {
//        if (user == null || user.getAddress() == null)
//            return ResponseEntity.badRequest().build();
//            //return "user Error: no envio el nombreValor en el body";
//
//        log.info("user [{}] [{}]", user.getName(), codigo);
//        return ok(user);
//    }
//
//    @PostMapping("/user")
//    public ResponseEntity<UserResponse> user(@RequestBody User user) {
//        UserResponse response = new UserResponse("nok", "", null);
//
//        if (user == null) {
//            response.setMessage("el user recibido es null");
//            return ResponseEntity.badRequest().body(response);
//
//        } else if (user.getAddress() == null) {
//            response.setMessage("el user.address recibido es null");
//            return ResponseEntity.badRequest().body(response);
//        }
//
//        response.setStatus("ok");
//        response.setUser(user);
//        return ResponseEntity.ok(response);
//    }
//
////    @RequestMapping(value = "/cargar-archivo-txt", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
////    public ResponseEntity uploadFile(@RequestPart("txtFile") @Nullable MultipartFile mpTxtFile) {
////        try {
////
////            List<String[]> listRows = FileUtil.getValues(mpTxtFile, "|", "#", null, 5);
////            System.out.println(ListUtil.getToStringListArray(listRows));
////
////            log.info("Archivo txt cargado correctamente");
////            return ok().build();
////
////        } catch (ValidationException e) {
////            log.error("Error controlado. message: {}", e.getMessage(), e);
////            return ResponseEntity.badRequest().build();
////
////        } catch (Exception e) {
////            log.error("Error inesperado al cargar el archivo txt", e);
////            return ResponseEntity.badRequest().build();
////        }
////    }
//
//}
