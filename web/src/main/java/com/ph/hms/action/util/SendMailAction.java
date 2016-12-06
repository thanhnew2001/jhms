package com.ph.hms.action.util;

import java.util.Hashtable;

import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Client;
import com.ph.hms.ClientManager;

public class SendMailAction extends ActionSupport {

	private Hashtable<String, String> i18n;

	private I18nManager i18nManager;

	private int clientId;

	private String result;

	private ClientManager clientManager;

	public Hashtable<String, String> getI18n() {
		return i18n;
	}

	public void setI18n(Hashtable<String, String> i18n) {
		this.i18n = i18n;
	}

	public I18nManager getI18nManager() {
		return i18nManager;
	}

	public void setI18nManager(I18nManager manager) {
		i18nManager = manager;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public ClientManager getClientManager() {
		return clientManager;
	}

	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}

	public String execute() {

		i18n = i18nManager.geti18n();
		  
		Client client = clientManager.getClient(clientId);
		
		System.out.println(client);

		if (i18n.get("sendmailcreateclient").trim().equalsIgnoreCase("yes") && client!=null) {
			try {

				// Emailer
				String[] receivers = { "thanh.hispvietnam@gmail.com",
						client.getEmail() };

				UtilManager utilManger = new UtilManager();

				System.out.println(client.getEmail());
				String content = ""
						+ "Kinh chao Quy khach !\n"
						+ "Ten :"
						+ client.getNode()
						+ "\nMS cua quy khach la: "
						+ client.getCode()
						+ "\nMat khau :"
						+ client.getPassword()
						+ "\nQuy khach co the xem ho so benh an cua ban tai http://pkmytung.com";
				utilManger.postMail(receivers, "Phong kham da khoa My Tung",
						content, "admin@bacsigiadinhvietnam.org");

			} catch (Exception e) {
				result = "Failed to send mail. Please check your connection or mail server!!!";
				e.printStackTrace();
				//return ERROR;
			}
			result = "Sent mail successfully!!!";
		}
		else
		{
			result = "Failed to send mail. Please check if client has an email address!!!";			
		}
	
		return SUCCESS;
	}
}
