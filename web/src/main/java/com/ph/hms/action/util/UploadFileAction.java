package com.ph.hms.action.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;



import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Department;
import com.ph.hms.User;

public class UploadFileAction implements Action {

	// private final String dir =
	// "C:/wamp/www/openepr_generator/generated_web/target/work/webapp/upload/";

	private List files = new ArrayList();

	public List getFiles() {
		return files;
	}

	public void setFiles(List files) {
		this.files = files;
	}

	private File file;
	private String contentType;
	private String filename;

	public void setUpload(File file) {
		this.file = file;
	}

	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setUploadFileName(String filename) {
		this.filename = filename;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	private String browsedir;

	public String getBrowsedir() {
		return browsedir;
	}

	public void setBrowsedir(String browsedir) {
		this.browsedir = browsedir;
	}

	private I18nManager i18nManager;

	private Hashtable<String, String> i18n;

	public I18nManager getI18nManager() {
		return i18nManager;
	}

	public void setI18nManager(I18nManager manager) {
		i18nManager = manager;
	}

	public Hashtable<String, String> getI18n() {
		return i18n;
	}

	public void setI18n(Hashtable<String, String> i18n) {
		this.i18n = i18n;
	}

	public String execute() {
		i18n = i18nManager.geti18n();
		// String dir = System.getenv("jhms_upload");
		String dir = i18n.get("jhmsdata");
		System.out.println(dir);

		FileInputStream fin = null;
		FileOutputStream fout = null;

		Date d = new Date();

		String today = d.getDate() + "-" + (d.getMonth() + 1) + "-"
				+ (d.getYear() + "");
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
        String now =  dateFormat.format(d);
		
/*		String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HHmmss");
		String today =  sdf.format(cal.getTime());
		String now =  sdf2.format(cal.getTime());*/

		Map session = ActionContext.getContext().getSession();

		User user = (User) session.get("user");

		File todaydir = new File(dir + today + "/" + user.getNode());

		if (!todaydir.exists())
			todaydir.mkdirs();

		try {

			if (file != null) {
				System.out.println(file.getPath());// (doc.getPath());
				fin = new FileInputStream(file.getPath());// (doc.getPath());
				byte[] data = new byte[8192];
				int byteReads = fin.read(data);

				fout = new FileOutputStream(todaydir + "/" + now
						+ "_" + filename);

				while (byteReads != -1) {
					fout.write(data, 0, byteReads);
					fout.flush();
					byteReads = fin.read(data);
				}

				fin.close();
				fout.close();
			}

			File myDir;
			if (browsedir == null) // not select browse dir
			{
				myDir = todaydir;
				browsedir = today + "/" + user.getNode();
			} else {
				myDir = new File(dir + browsedir + "/" + user.getNode());
				System.out.println(myDir);// (doc.getPath());
			}

			if (myDir.exists() && myDir.isDirectory()) {
				File[] listfiles = myDir.listFiles();
				for (int i = 0; i < listfiles.length; i++) {
					if (!listfiles[i].isHidden()) {
						files.add(listfiles[i]);

					}

				}
			}

			return SUCCESS;

		} catch (Exception ex) {
			ex.printStackTrace();
			return ERROR;
		}

	}
}
