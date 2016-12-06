package com.ph.hms.action;

import java.util.Hashtable;

import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.IndicationdetailManager;
import com.ph.hms.NoiSoiTMH;
import com.ph.hms.action.util.I18nManager;

public class NoiSoiTMHSaveAction extends ActionSupport {

	private int id;	
	private String ongtaingoai;
	private String mangnhi;
	
	private String niemmacmui;
	private String vachngan;
	private String khegiua;
	private String khetren;
	private String mommoc;
	private String vomhong;
	private String hong;
	private String thanhquan;
	
	private String camnghi;
	
	private String denghi;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getOngtaingoai() {
		return ongtaingoai;
	}

	public void setOngtaingoai(String ongtaingoai) {
		this.ongtaingoai = ongtaingoai;
	}

	public String getMangnhi() {
		return mangnhi;
	}

	public void setMangnhi(String mangnhi) {
		this.mangnhi = mangnhi;
	}

	public String getNiemmacmui() {
		return niemmacmui;
	}

	public void setNiemmacmui(String niemmacmui) {
		this.niemmacmui = niemmacmui;
	}

	public String getVachngan() {
		return vachngan;
	}

	public void setVachngan(String vachngan) {
		this.vachngan = vachngan;
	}

	public String getKhegiua() {
		return khegiua;
	}

	public void setKhegiua(String khegiua) {
		this.khegiua = khegiua;
	}

	public String getKhetren() {
		return khetren;
	}

	public void setKhetren(String khetren) {
		this.khetren = khetren;
	}

	public String getMommoc() {
		return mommoc;
	}

	public void setMommoc(String mommoc) {
		this.mommoc = mommoc;
	}

	public String getVomhong() {
		return vomhong;
	}

	public void setVomhong(String vomhong) {
		this.vomhong = vomhong;
	}

	public String getHong() {
		return hong;
	}

	public void setHong(String hong) {
		this.hong = hong;
	}

	public String getThanhquan() {
		return thanhquan;
	}

	public void setThanhquan(String thanhquan) {
		this.thanhquan = thanhquan;
	}

	public String getCamnghi() {
		return camnghi;
	}

	public void setCamnghi(String camnghi) {
		this.camnghi = camnghi;
	}

	public String getDenghi() {
		return denghi;
	}

	public void setDenghi(String denghi) {
		this.denghi = denghi;
	}
	
	private IndicationdetailManager indicationdetailManager;
	
	
	public IndicationdetailManager getIndicationdetailManager() {
		return indicationdetailManager;
	}

	public void setIndicationdetailManager(
			IndicationdetailManager indicationdetailManager) {
		this.indicationdetailManager = indicationdetailManager;
	}
	
	private NoiSoiTMH noiSoiTMH;	

	public NoiSoiTMH getNoiSoiTMH() {
		return noiSoiTMH;
	}

	public void setNoiSoiTMH(NoiSoiTMH noiSoiTMH) {
		this.noiSoiTMH = noiSoiTMH;
	}
	
	private Hashtable<String, String> i18n;

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
	
	private String action;
	
	
		public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	private String msg;
	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	public String execute() throws Exception
    {		
        try{

        	noiSoiTMH = indicationdetailManager.getNoiSoiTMH(id);
        	
        	if(noiSoiTMH==null) return ERROR;
        	
        	if (action!=null && action.equalsIgnoreCase("save"))
        	{
	        	noiSoiTMH.setCamnghi(camnghi);
	        	noiSoiTMH.setDenghi(denghi);
	        	noiSoiTMH.setHong(hong);
	        	noiSoiTMH.setKhegiua(khegiua);
	        	noiSoiTMH.setKhetren(khetren);
	        	noiSoiTMH.setMangnhi(mangnhi);
	        	noiSoiTMH.setMommoc(mommoc);
	        	noiSoiTMH.setNiemmacmui(niemmacmui);
	        	noiSoiTMH.setOngtaingoai(ongtaingoai);
	        	noiSoiTMH.setThanhquan(thanhquan);
	        	noiSoiTMH.setVachngan(vachngan);
	        	noiSoiTMH.setVomhong(vomhong);
	        	
	        	indicationdetailManager.updateNoiSoiTMH(noiSoiTMH);
	        	
	        	msg = "Luu thanh cong";
        	}
        	
        	
        	return SUCCESS;
        }

        catch(Exception e)
        {
        	e.printStackTrace();
        	return ERROR;
        }
      

}
}
