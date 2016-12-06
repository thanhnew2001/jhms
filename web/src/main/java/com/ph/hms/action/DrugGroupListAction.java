package com.ph.hms.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Drug;
import com.ph.hms.DrugGroup;
import com.ph.hms.DrugManager;
import com.ph.hms.action.util.DefaultSecurity;
import com.ph.hms.action.util.I18nManager;

public class DrugGroupListAction extends ActionSupport {

	public String fname = "druggroup";
	public String aname = "list";

	private DrugManager drugManager;

	private int id;

	private Collection<Drug> drugs;

	public Collection<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(Collection<Drug> drugs) {
		this.drugs = drugs;
	}

	public DrugManager getDrugManager() {
		return drugManager;
	}

	public void setDrugManager(DrugManager drugManager) {
		this.drugManager = drugManager;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String node;

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	private String description;

	private Collection<DrugGroup> druggroups = new ArrayList<DrugGroup>();

	private Hashtable<String, String> i18n;

	public Collection<DrugGroup> getDruggroups() {
		return druggroups;
	}

	public void setDruggroups(Collection<DrugGroup> druggroups) {
		this.druggroups = druggroups;
	}

	public Hashtable<String, String> getI18n() {
		return i18n;
	}

	public void setI18n(Hashtable<String, String> i18n) {
		this.i18n = i18n;
	}

	private I18nManager i18nManager;

	public I18nManager getI18nManager() {
		return i18nManager;
	}

	public void setI18nManager(I18nManager i18nManager) {
		this.i18nManager = i18nManager;
	}

	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String execute() {
		i18n = i18nManager.geti18n();

		DefaultSecurity ds = new DefaultSecurity();

		boolean matched = ds.checkRight(fname, aname);

		if (matched == false)
			return "noprivilege";

		if (action != null && action.equalsIgnoreCase("adddruggroup")) {
			DrugGroup dg = new DrugGroup();
			id = dg.getId();
			dg.setNode(node);
			dg.setDescription(description);

			drugManager.addDrugGroup(dg);

		}

		if (action != null && action.equalsIgnoreCase("deletedruggroup")) {
			drugManager.deleteDrugGroup(id);
		}
		if (action != null && action.equalsIgnoreCase("editdruggroup")) {
			
			druggroups = (ArrayList<DrugGroup>) drugManager.getAllDrugGroups();

		}

		druggroups = new ArrayList<DrugGroup>();

		druggroups = drugManager.getAllDrugGroups();

		return SUCCESS;
	}

}
