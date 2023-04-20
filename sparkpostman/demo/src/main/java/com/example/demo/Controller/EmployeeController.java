package com.example.demo.Controller;

import com.example.demo.Kafka.KafkaProducer;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Spliting.CsvSpliting;
import com.example.demo.model.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

        private KafkaProducer kafkaProducer;
        public EmployeeController(KafkaProducer kafkaProducer){
            this.kafkaProducer = kafkaProducer;
        }

        @PostMapping("/post")
        public String upload(@RequestParam("file")MultipartFile multipartFile) throws IOException {
            multipartFile.transferTo(new File("/home/albanero/Downloads/sparkpostman/demo/src/main/resources/text"));
            return (new CsvSpliting()).split("/home/albanero/Downloads/sparkpostman/demo/src/main/resources/text",kafkaProducer);
        }

        @GetMapping("Get")
        public List<Details> get(){
            return employeeRepository.findAll();
        }
    }























//    @PostMapping("/upload")
//    public String uploadData(@RequestParam("file")MultipartFile file) throws Exception{
//        List<Details> EmployeeList = new ArrayList<>();
//        InputStream inputStream = file.getInputStream();
//        CsvParserSettings setting = new CsvParserSettings();
//        setting.setHeaderExtractionEnabled(true);
//        CsvParser parser = new CsvParser(setting);
//        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
//        parseAllRecords.forEach(record -> {
//            Details Employee = new Details();
//            Employee.setEmployeeId(Integer.parseInt(record.getString("EmployeeId")));
//            Employee.setFullName(record.getString("Full Name"));
//            Employee.setEmail(record.getString("Email"));
//        });
//       EmployeeRepository.SaveAll(EmployeeList);
//        return "uploaded Successfully!!!";
//    }}




















//    @PostMapping("/upload")
//    public String uploadData(@RequestParam("file")MultipartFile file) throws Exception{
//        List<Details> accountList=new ArrayList<>();
//       InputStream inputStream= file.getInputStream();
//       CsvParserSettings setting = new CsvParserSettings();
//       setting.setHeaderExtractionEnabled(true);
//       CsvParser parser= new CsvParser(setting);
//       List<Record> parseAllRecords=parser.parseAllRecords(inputStream);
//       parseAllRecords.forEach(record -> {
//           Details account=new Details();
//           account.setAccountNumber(Integer.parseInt(record.getString("accountNumber")));
//           account.setFirstName(record.getString("firstName"));
//           account.setLatName(record.getString("lastName"));
//           account.setAccountType(record.getString("accountType"));
//           account.setAddress(record.getString("Address"));
//           account.setEmail(record.getString("Email"));
//           account.setZipcode(record.getString("Zipcode"));
//           accountList.add(account);
//       });
//       accountRepository.saveAll(accountList);
//        return "upload Successfully!!!";
//    }












