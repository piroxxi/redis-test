package controllers;

import java.util.UUID;

import model.Client;
import model.Grant;
import model.GrantState;
import model.OasisUser;
import model.ResourceServer;
import model.Scope;
import model.VirtualScope;

import org.apache.commons.pool.impl.GenericObjectPool.Config;

import play.mvc.Controller;
import play.mvc.Result;
import redis.clients.jedis.JedisPool;
import redis.clients.johm.JOhm;
import views.html.index;

public class Application extends Controller {
	public static Result index() {
		JedisPool jedisPool = new JedisPool(new Config(), "localhost");
		JOhm.setPool(jedisPool);

		creatingModelObjects();

		return ok(index.render(
				JOhm.<OasisUser>getAll(OasisUser.class),
				JOhm.<ResourceServer>getAll(ResourceServer.class),
				JOhm.<VirtualScope>getAll(VirtualScope.class),
				JOhm.<Scope>getAll(Scope.class),
				JOhm.<Client>getAll(Client.class),
				JOhm.<Grant>getAll(Grant.class)
		));
	}

	private static void creatingModelObjects() {
		// Users
		OasisUser rpo = new OasisUser(randomId(), "Raphael", "Poittevin", "rpo", "rpo@mail");
		JOhm.save(rpo);
		OasisUser toto = new OasisUser(randomId(), "To", "To", "toto", "toto@mail");
		JOhm.save(toto);

		// Virtual Scopes
		VirtualScope emails = new VirtualScope(randomId(), "emails", "Provides user's mails.");
		JOhm.save(emails);
		VirtualScope photos = new VirtualScope(randomId(), "photos", "Provides user's photos.");
		JOhm.save(photos);
		VirtualScope documents = new VirtualScope(randomId(), "documents", "Provides user's Documents");
		JOhm.save(documents);

		// Resource servers
		ResourceServer server = new ResourceServer(randomId(), "ResourcesServer",
		    "http://127.0.0.1:9002", randomId());
		JOhm.save(server);

		// Scopes
		Scope scopeEmailServer = new Scope(randomId(), "emails@server", emails,
		    "Resource server's mails");
		JOhm.save(scopeEmailServer);
		Scope scopeMusicsServer = new Scope(randomId(), "musics@server", "Resource server's ");
		JOhm.save(scopeMusicsServer);

		// Client
		Client client = new Client(randomId(), "Client", "http://127.0.0.1:9000",
		    "http://127.0.0.1:9000/redirect", randomId());
		JOhm.save(client);

		// Here comes the grants
		Grant grantEmailServerClientRpo = new Grant(randomId(), client, scopeEmailServer, rpo,
		    GrantState.Granted);
		JOhm.save(grantEmailServerClientRpo);
		Grant grantMusicsServerClientRpo = new Grant(randomId(), client, scopeMusicsServer, rpo,
		    GrantState.GrantedOnlineOnly);
		JOhm.save(grantMusicsServerClientRpo);
		Grant grantEmailServerClientToto = new Grant(randomId(), client, scopeEmailServer, toto,
		    GrantState.Denied);
		JOhm.save(grantEmailServerClientToto);
	}

	private static String randomId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}
}
