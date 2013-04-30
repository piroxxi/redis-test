package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import model.Client;
import model.Grant;
import model.GrantState;
import model.OasisUser;
import model.ResourceServer;
import model.Scope;
import model.Token;
import model.VirtualScope;

import org.apache.commons.pool.impl.GenericObjectPool.Config;

import play.mvc.Controller;
import play.mvc.Result;
import redis.clients.jedis.JedisPool;
import redis.clients.johm.JOhm;
import views.html.index;

public class Application extends Controller {
	private static final Random RANDOM = new Random(new Date().getTime());

	public static Result index() {
		JedisPool jedisPool = new JedisPool(new Config(), "localhost");
		JOhm.setPool(jedisPool);

		creatingModelObjects();

		return ok(index.render(getSortedList(JOhm.<OasisUser> getAll(OasisUser.class)),
		    getSortedList(JOhm.<ResourceServer> getAll(ResourceServer.class)),
		    getSortedList(JOhm.<VirtualScope> getAll(VirtualScope.class)),
		    getSortedList(JOhm.<Scope> getAll(Scope.class)),
		    getSortedList(JOhm.<Client> getAll(Client.class)),
		    getSortedList(JOhm.<Grant> getAll(Grant.class)),
		    getSortedList(JOhm.<Token> getAll(Token.class))));
	}

	public static <T> List<T> getSortedList(Set<T> objects) {
		List<T> list = new ArrayList<T>(objects);
		Collections.sort(list, new Comparator<T>() {
			@Override
			public int compare(T arg0, T arg1) {
				return JOhm.getId(arg0).compareTo(JOhm.getId(arg1));
			}
		});
		return list;
	}

	/*-
	  List<Client> clients = new ArrayList<>(JOhm.<Client> getAll(Client.class));
		Collections.sort(clients, new Comparator<Client>() {
			@Override
			public int compare(Client arg0, Client arg1) {
				return arg0.getClientId().compareTo(arg1.getClientId());
			}
		});
		return clients;
	 */

	public static Result authorize() {
		String clientId = request().getQueryString("client_id");
		String userId = request().getQueryString("user_id");
		List<String> scopesIds = Arrays.asList(request().getQueryString("scope").split(" ", -1));

		Client client = JOhm.get(Client.class, clientId);
		OasisUser user = JOhm.<OasisUser>get(OasisUser.class, userId);
		for (String scopeId : scopesIds) {
			/*
			 * Here in face, we are loosing efficiency, as we could create the Grant
			 * without having to query the Scope and Client.
			 */
			Scope scope = JOhm.get(Scope.class, scopeId);
			Grant grant = new Grant(client, scope, user, randomState());
			JOhm.save(grant);
		}

		return redirect(routes.Application.index());
	}

	private static void creatingModelObjects() {
		// Users
		if (JOhm.getAll(OasisUser.class).isEmpty()) {
			OasisUser rpo = new OasisUser(randomId(), "Raphael", "Poittevin", "rpo", "rpo@mail");
			JOhm.save(rpo);
			OasisUser toto = new OasisUser(randomId(), "To", "To", "toto", "toto@mail");
			JOhm.save(toto);
		}

		// Client
		if (JOhm.getAll(Client.class).isEmpty()) {
			Client client = new Client(randomId(), "Client", "http://127.0.0.1:9000",
			    "http://127.0.0.1:9000/redirect", randomId());
			JOhm.save(client);

			Client client2 = new Client(randomId(), "AnotherClient", "http://127.0.0.1:9008",
			    "http://127.0.0.1:9008/redirect", randomId());
			JOhm.save(client2);
		}

		// Virtual Scopes
		if (JOhm.getAll(VirtualScope.class).isEmpty()) {
			VirtualScope emails = new VirtualScope("oasis@vs-emails", "emails", "Provides user's mails.");
			JOhm.save(emails);
			VirtualScope musics = new VirtualScope("oasis@vs-musics", "musics", "Provides user's musics.");
			JOhm.save(musics);
			VirtualScope photos = new VirtualScope("oasis@vs-photos", "photos", "Provides user's photos.");
			JOhm.save(photos);
			VirtualScope documents = new VirtualScope("oasis@vs-documents", "documents",
			    "Provides user's Documents");
			JOhm.save(documents);
		}

		// Resource servers
		if (JOhm.getAll(ResourceServer.class).isEmpty()) {
			ResourceServer server = new ResourceServer(randomId(), "ResourcesServer",
			    "http://127.0.0.1:9002", randomId());
			JOhm.save(server);

			Scope scopeEmailServer = new Scope("oasis@" + randomId() + "-email", "Emails", server,
			    JOhm.<VirtualScope> get(VirtualScope.class, "oasis@vs-emails"));
			JOhm.save(scopeEmailServer);

			Scope scopeMusicServer = new Scope("oasis@" + randomId() + "-musics", "Musics", server,
			    JOhm.<VirtualScope> get(VirtualScope.class, "oasis@vs-musics"));
			JOhm.save(scopeMusicServer);

			Scope scopeDocumentsServer = new Scope("oasis@" + randomId() + "-documents", "Documents",
			    server, JOhm.<VirtualScope> get(VirtualScope.class, "oasis@vs-documents"));
			JOhm.save(scopeDocumentsServer);

			Scope scopePhotosServer = new Scope("oasis@" + randomId() + "-photos", "Photos", server,
			    JOhm.<VirtualScope> get(VirtualScope.class, "oasis@vs-photos"));
			JOhm.save(scopePhotosServer);

			Scope otherScope = new Scope("oasis@" + randomId() + "-somethingelse", "Someting else",
			    server);
			JOhm.save(otherScope);
		}
	}

	private static String randomId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}

	private static GrantState randomState() {
		switch (RANDOM.nextInt(4)) {
			case 0:
				return GrantState.Granted;
			case 1:
				return GrantState.Denied;
			case 2:
				return GrantState.Postponed;
			case 3:
				return GrantState.Revoked;
		}
		return null;
	}
}
