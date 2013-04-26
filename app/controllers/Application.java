package controllers;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import model.OasisUser;

import org.apache.commons.pool.impl.GenericObjectPool.Config;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.johm.JOhm;

public class Application extends Controller {
	public static Result index() {
		return Results.ok(views.html.index.render());
	}

	public static Result jedis() throws UnknownHostException, IOException {
		Jedis connection = new Jedis("localhost", 6379);
		connection.connect();

		List<String> logs = new ArrayList<>();

		boolean hadAValue = false;
		logs.add("STEP 1");

		String value = connection.get("foo");
		if (value != null && !value.isEmpty()) {
			logs.add("> A value was already stored in foo : " + value);
			hadAValue = true;
		} else {
			logs.add("> No value is stored in foo.");
			value = UUID.randomUUID().toString().substring(0, 8);
			logs.add("> We put " + value);
			connection.set("foo", value);
		}

		logs.add("STEP 2");
		value = connection.get("foo");
		logs.add("> GET foo  has returned " + value);

		logs.add("STEP 3");
		if (hadAValue) {
			logs.add("> Has a value was found at first, we erase it");
			connection.del("foo");
		} else {
			logs.add("> Nothing to do");
		}

		return Results.ok(views.html.jedis.render(connection.info(), logs));
	}

	public static Result johm() {
		JedisPool jedisPool = new JedisPool(new Config(), "localhost");
		JOhm.setPool(jedisPool);

		List<OasisUser> users = new ArrayList<>(JOhm.<OasisUser> getAll(OasisUser.class));

		if (users.isEmpty()) {
			users.add(new OasisUser("Raphaël", "Poittevin", "rpo", "rpo@mail.com"));
			users.add(new OasisUser("Paul", "Dupont", "pdu", "pdu@mail.com"));
			users.add(new OasisUser("Foo", "Bar", "fob", "fob@mail.com"));
			users.add(new OasisUser("Opa", "Gangam", "Style", "ogs@mail.com"));

			for (OasisUser user : users) {
				JOhm.save(user);
			}
		} else {
			ArrayList<Integer> userIds = new ArrayList<Integer>();
			for (OasisUser user : users) {
				userIds.add(user.getOasisUUID());
			}
			for (Integer id : userIds) {
				JOhm.delete(OasisUser.class, id);
			}
		}

		return Results.ok(views.html.johm.render(users));
	}
}
