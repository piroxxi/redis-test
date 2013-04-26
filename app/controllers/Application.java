package controllers;

import java.util.UUID;

import model.Client;
import model.Grant;
import model.GrantState;
import model.OasisUser;
import model.ResourceServer;
import model.Scope;
import model.VirtualScope;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
	public static Result index() {

		creatingModelObjects();

		return ok(index.render());
	}

	private static void creatingModelObjects() {
		// Users
		OasisUser rpo = new OasisUser(randomId(), "Raphael", "Poittevin", "rpo", "rpo@mail");
		OasisUser toto = new OasisUser(randomId(), "To", "To", "toto", "toto@mail");

		// Virtual Scopes
		VirtualScope emails = new VirtualScope(randomId(), "emails", "Provides user's mails.");
		VirtualScope photos = new VirtualScope(randomId(), "photos", "Provides user's photos.");
		VirtualScope documents = new VirtualScope(randomId(), "documents", "Provides user's Documents");

		// Resource servers
		ResourceServer server = new ResourceServer(randomId(), "ResourcesServer",
		    "http://127.0.0.1:9002", randomId());

		// Scopes
		Scope scopeEmailServer = new Scope(randomId(), "emails@server", emails,
		    "Resource server's mails");
		Scope scopeMusicsServer = new Scope(randomId(), "musics@server", "Resource server's ");

		// Client
		Client client = new Client(randomId(), "Client", "http://127.0.0.1:9000",
		    "http://127.0.0.1:9000/redirect", randomId());

		// Here comes the grants
		Grant grantEmailServerClientRpo = new Grant(randomId(), client, scopeEmailServer, rpo,
		    GrantState.Granted);
		Grant grantMusicsServerClientRpo = new Grant(randomId(), client, scopeMusicsServer, rpo,
		    GrantState.GrantedOnlineOnly);
		Grant grantEmailServerClientToto = new Grant(randomId(), client, scopeEmailServer, toto,
		    GrantState.Denied);
	}

	private static String randomId() {
		return UUID.randomUUID().toString().substring(0, 8);
	}
}
