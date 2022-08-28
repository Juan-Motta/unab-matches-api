package com.matches;

import com.matches.entities.Team;
import com.matches.entities.User;
import com.matches.services.TeamServiceInterface;
import com.matches.services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MatchesApiApplication implements CommandLineRunner {

	@Autowired
	private UserServiceInterface userService;

	@Autowired
	private TeamServiceInterface teamService;

	public static void main(String[] args) {
		SpringApplication.run(MatchesApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("jualopezmo");
		user.setFirst_name("Juan");
		user.setLast_name("Motta");
		user.setPassword("abcd1234");
		user.setEmail("jualopezmo@example.com");
		user.setActive(true);

		Team local = new Team();
		local.setName("Equipo UNAL");
		local.setAbbreviation("UNAL");

		Team away = new Team();
		away.setName("Equipo UNAB");
		away.setAbbreviation("UNAB");

		User savedUser = userService.saveUser(user);
		Team savedLocalTeam = teamService.saveTeam(local);
		Team savedAwayTeam = teamService.saveTeam(away);

	}
}
