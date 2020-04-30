package com.example.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyConfigure extends WebSecurityConfigurerAdapter {

  // ----------------------------------------
  // Spring Securityの設定
  // ----------------------------------------

  // <<< ※WebSecurityConfigurerAdapterには、configureのオーバーロードメソッドが複数あるので要注意 >>>
  @Override protected void configure(AuthenticationManagerBuilder auth) throws Exception { super.configure(auth); }
  @Override public    void configure(WebSecurity                  web)  throws Exception { super.configure(web); }
  //---

  @Override
  protected void configure(HttpSecurity http) throws Exception {
	System.out.println("MyConfigure configure");
    // Basic認証の設定
    http.httpBasic().realmName("My sample realm");
    // 認証が必要となるリクエストの設定
    http.authorizeRequests().anyRequest().authenticated();
    // CSRF対策が有効だとTokenなしのPOSTがエラーとなるため、無効化する
    http.csrf().disable();
    // 認証情報は常にAuthorizationヘッダから取得するため、Cookieによるセッション管理は不要
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  // ----------------------------------------
  // Bean定義
  // ----------------------------------------

  @Bean
  public UserDetailsService userDetailsService() {
    return new LoginPrincipal.LoginPrincipalService();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}