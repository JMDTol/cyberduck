package ch.cyberduck.core.ftp;

/*
 *  Copyright (c) 2003 David Kocher. All rights reserved.
 *  http://cyberduck.ch/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 */

import ch.cyberduck.core.*;

import com.enterprisedt.net.ftp.FTPClient;
import com.enterprisedt.net.ftp.FTPConnectMode;
import com.enterprisedt.net.ftp.FTPException;

import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * Opens a connection to the remote server via ftp protocol
 * @version $Id$
 */
public class FTPSession extends Session {
	private static Logger log = Logger.getLogger(Session.class);

	static {
		SessionFactory.addFactory(Session.FTP, new Factory());
	}

	private static class Factory extends SessionFactory {
		protected Session create(Host h) {
			return new FTPSession(h);
		}
	}

	protected FTPClient FTP;

	/**
	 * @param client The client to use which does implement the ftp protocol
	 * @param action The <code>TransferAction</code> to execute after the connection has been opened
	 * @param transfer The <code>Bookmark</code> object
	 * @param secure If the connection is secure
	 */
	public FTPSession(Host h) {//, TransferAction action) {
		super(h);
		// System.getProperties().put("proxySet", Preferences.instance().getProperty("connection.proxy"));
		// System.getProperties().put("proxyHost", Preferences.instance().getProperty("connection.proxy.host"));
		// System.getProperties().put("proxyPort", Preferences.instance().getProperty("connection.proxy.port"));
	}

	public synchronized void close() {
		this.callObservers(new Message(Message.CLOSE, "Closing session."));
		try {
			if (this.FTP != null) {
				this.log("Disconnecting...", Message.PROGRESS);
				this.FTP.quit();
				this.getHost().getLogin().setPassword(null);
				this.FTP = null;
			}
			this.log("Disconnected", Message.PROGRESS);
		}
		catch (FTPException e) {
			this.log("FTP Error: " + e.getMessage(), Message.ERROR);
		}
		catch (IOException e) {
			this.log("IO Error: " + e.getMessage(), Message.ERROR);
		}
		finally {
			this.setConnected(false);
		}
	}

	public synchronized void connect() throws IOException {
		this.callObservers(new Message(Message.OPEN, "Opening session."));
		this.log("Opening FTP connection to " + host.getIp() + "...", Message.PROGRESS);
		this.log("-------" + new java.util.Date().toString(), Message.TRANSCRIPT);
		this.log("-------" + host.getIp(), Message.TRANSCRIPT);
		this.FTP = new FTPClient();
		if (Preferences.instance().getProperty("ftp.connectmode").equals("active")) {
			this.FTP.setConnectMode(FTPConnectMode.ACTIVE);
		}
		else {
			this.FTP.setConnectMode(FTPConnectMode.PASV);
		}
		this.FTP.connect(host.getHostname(), host.getPort());
		this.log("FTP connection opened", Message.PROGRESS);
		this.login();
		if(Preferences.instance().getProperty("ftp.sendSystemCommand").equals("true")) {
			this.FTP.system();
		}
		this.setConnected(true);
	}


	public synchronized void mount() {
		this.log("Mounting " + host.getHostname() + "...", Message.PROGRESS);
		new Thread() {
			public void run() {
				try {
					connect();
					Path home;
					if (host.hasReasonableDefaultPath()) {
						if (host.getDefaultPath().charAt(0) != '/')
							home = PathFactory.createPath(FTPSession.this, ((FTPPath) FTPSession.this.workdir()).getAbsolute(), host.getDefaultPath());
						else
							home = PathFactory.createPath(FTPSession.this, host.getDefaultPath());
					}
					else
						home = (FTPPath) FTPSession.this.workdir();
					home.list(true);
				}
				catch (FTPException e) {
					FTPSession.this.log("FTP Error: " + e.getMessage(), Message.ERROR);
				}
				catch (IOException e) {
					FTPSession.this.log("IO Error: " + e.getMessage(), Message.ERROR);
				}
			}
		}.start();
	}

	private synchronized void login() throws IOException {
		log.debug("login");
		try {
			Login credentials = host.getLogin();
			if(credentials.check()) {
				this.log("Authenticating as " + host.getLogin().getUsername() + "...", Message.PROGRESS);
				this.FTP.login(credentials.getUsername(), credentials.getPassword());
				credentials.addPasswordToKeychain();
				this.log("Login successfull", Message.PROGRESS);
			}
		}
		catch (FTPException e) {
			this.log("Login failed", Message.PROGRESS);
			if (host.getLogin().promptUser("Authentication for user " + host.getLogin().getUsername() + " failed. The server response is: " + e.getMessage())) {
				// let's try again with the new values
				this.login();
			}
			else {
				throw new FTPException("Login as user " + host.getLogin().getUsername() + " failed.");
			}
		}
	}

	public Path workdir() {
		try {
			return PathFactory.createPath(this, this.FTP.pwd());
		}
		catch (FTPException e) {
			this.log("FTP Error: " + e.getMessage(), Message.ERROR);
		}
		catch (IOException e) {
			this.log("IO Error: " + e.getMessage(), Message.ERROR);
		}
		return null;
	}


	public void check() throws IOException {
		log.debug(this.toString() + ":check");
		this.log("Working", Message.START);
		if (null == this.FTP || !this.FTP.isAlive()) {
			this.setConnected(false);
			this.connect();
		}
	}
}