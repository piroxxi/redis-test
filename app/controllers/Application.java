package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import redis.clients.jedis.Jedis;
import views.html.index;
import views.html.jedis;

public class Application extends Controller {
	public static Result index() {
		return Results.ok(index.render());
	}

	public static Result jedis() {
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
		if(hadAValue){
			logs.add("> Has a value was found at first, we erase it");
			connection.del("foo");
		}else{
			logs.add("> Nothing to do");
		}
		
		return Results.ok(jedis.render(connection.info(), logs));
	}

}
