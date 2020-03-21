package me.itson.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.itson.backend.dto.AccountDTO;
import me.itson.backend.service.AccountService;

@RestController
@RequestMapping("account")
public class AccountEndpoint {

	@Autowired
	private AccountService accountService;
	
	@PostMapping("register")
	public AccountDTO registerUser(@RequestBody AccountDTO accountDto){
		return accountService.register(accountDto);
	}
	
	@GetMapping("validate/{token:\\w+}")
	public void validateUser(@PathVariable String token) {
		accountService.verifyUser(token);
	}
}
