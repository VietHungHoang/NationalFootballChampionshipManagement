//package com.vhh.nfcm.config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Tùy chọn: vô hiệu hóa CSRF nếu cần
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().authenticated() // Mọi yêu cầu đều cần đăng nhập
//                )
//                .formLogin(form -> form
//                        .loginPage("") // Trang đăng nhập tùy chỉnh
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")                      // URL để thực hiện logout
//                        .logoutSuccessUrl("/login?logout=true")    // URL sau khi logout thành công
//                        .invalidateHttpSession(true)              // Hủy session hiện tại
//                        .deleteCookies("JSESSIONID")              // Xóa cookie phiên làm việc
//                        .permitAll()
//                );
//
//        return http.build();
//    }
//}
//
