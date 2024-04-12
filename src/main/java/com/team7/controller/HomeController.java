    package com.team7.controller;


    import com.team7.dto.CustomerInfoDto;
    import com.team7.model.entity.Customer;
    import com.team7.security.utils.token.Blacklist;
    import com.team7.security.utils.token.BlacklistRepository;
    import com.team7.service.entitiy.CustomerService;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.core.Authentication;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.web.bind.annotation.*;

    import java.util.Arrays;


    @CrossOrigin(originPatterns = "http://localhost:3000")
    @RestController
    @ResponseBody
    @RequiredArgsConstructor
    public class HomeController {
        private final BlacklistRepository blacklistRepository;
        private final CustomerService customerService;
        @GetMapping("/")
        public String getIndexPage(){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("returning " + authentication.getName());
            return authentication.getName();
        }

        @PostMapping("/login")
        public String getLogin(){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("entered login");
            return authentication.getName();
        }

        @PostMapping("/register")
        public ResponseEntity<String> postRegister(@RequestBody CustomerInfoDto customerInfoDto){

            System.out.println(customerInfoDto.toString());

            if(customerService.findCustomerByAccountId(customerInfoDto.getAccountId()).isPresent()){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("아이디 중복.");
            }
            if(customerService.findCustomerByEmail(customerInfoDto.getEmail()).isPresent()){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재하는 이메일.");
            }
            if(customerService.findCustomerByPhone(customerInfoDto.getPhone()).isPresent()){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 존재하는 휴대폰 번호.");
            }
            Customer newCustomer = new Customer(customerInfoDto);
            customerService.save(newCustomer);
            return ResponseEntity.ok("회원가입 완료");
        }

        @PostMapping("/logout")
        public void getLogout(HttpServletRequest request, HttpServletResponse response){
            System.out.println("Customer Logout");
            String token = request.getHeader("Authorization").split(" ")[1];
            Blacklist blacklist = new Blacklist(token);
            blacklistRepository.save(blacklist);
            SecurityContextHolder.clearContext();


        }
    }
