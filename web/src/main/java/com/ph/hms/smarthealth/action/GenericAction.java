package com.ph.hms.smarthealth.action;

import java.awt.print.Pageable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Service;
import com.ph.hms.ServiceManager;
import com.ph.hms.ServiceParam;
import com.ph.hms.Servicegroup;
import com.ph.hms.ServicegroupManager;
import com.ph.hms.cardmanagement.CardManager;
import com.ph.hms.cardmanagement.CardType;
import com.ph.hms.smarthealth.GenericDao;

public class GenericAction extends ActionSupport {

	private static final String packageName = "com.ph.hms";

	// property of manager
	private GenericDao genericDao;

	public GenericDao getGenericDao() {
		return genericDao;
	}

	// for pagination
	private int pageSize;
	private int page;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	// property of a param
	private int id;

	private String name;

	private String node;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	// object to transfer
	private String clazz;

	private String action;

	private Object object;

	protected Collection objects;

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Collection getObjects() {
		return objects;
	}

	public void setObjects(Collection objects) {
		this.objects = objects;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	public Object invoke(String aClass, String aMethod, Object instance,
			Class[] params, Object[] args) throws SecurityException,
			NoSuchMethodException, ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException

	{
		Class c = Class.forName(aClass);
		Method m = c.getDeclaredMethod(aMethod, params);

		return m.invoke(instance, args);
	}

	private String table;

	private String form;

	private String paginationBar;

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getPaginationBar() {
		return paginationBar;
	}

	public void setPaginationBar(String paginationBar) {
		this.paginationBar = paginationBar;
	}

	public String getClazzWithoutPackage(String fullClazzName) {
		int len = fullClazzName.split(".").length;
		if (len > 0)
			return fullClazzName.split(".")[len];
		return "";
	}

	public String createForm(String myClass, Field myFields[], Object object,
			int id) throws IllegalArgumentException, IllegalAccessException,
			SecurityException, NoSuchMethodException, ClassNotFoundException,
			InstantiationException, InvocationTargetException {
		String form = "";
		String fieldName = "";
		String fullClazzName = packageName + "." + myClass;
		Object value = "";
		int valueId = 0;
		int myId = 0;

		for (int i = 0; i < myFields.length; i++) {
			fieldName = myFields[i].getName();
			String fieldType = myFields[i].getType().toString();

			if (id > 0) {
				value = invoke(fullClazzName, "get" + up1(fieldName), object,
						new Class[] {}, new Object[] {});

				if (fieldType.indexOf("class") >= 0
						&& fieldType.indexOf("java") < 0) {
					valueId = (Integer) invoke(packageName + "."
							+ up1(fieldName), "getId", value, new Class[] {},
							new Object[] {});
					value = invoke(packageName + "." + up1(fieldName),
							"getNode", value, new Class[] {}, new Object[] {});
				}
			}

			if (value == null)
				value = "";

			if (valueId > 0) {
				form += fieldName + "<input type='text' size='5' id='"
						+ fieldName + "' name='" + fieldName + "' value='"
						+ valueId + "'>";
				form += "<input type='text' id='" + fieldName + "Node' name='"
						+ fieldName + "Node' value='" + value + "' > <br>";
			} else {
				form += fieldName + "<input type='text' id='" + fieldName
						+ "' name='" + fieldName + "' value='" + value
						+ "' ><br>";
			}
			valueId = 0;
		}// for

		return form;
	}

	public static String up1(String s) {
		return (s.length() > 0) ? Character.toUpperCase(s.charAt(0))
				+ s.substring(1) : s;
	}

	public static String down1(String s) {
		return (s.length() > 0) ? Character.toLowerCase(s.charAt(0))
				+ s.substring(1) : s;
	}

	public String createPaginationBar(String fullClazzName, int pageSize,
			int page) {
		String clazz = fullClazzName
				.substring(fullClazzName.lastIndexOf(".") + 1);

		String bar = "Page: <select id='page' name='page' onchange='beforePagination();'>";
		try {
			int totalRecord = genericDao.getAll(Class.forName(fullClazzName))
					.size();
			int totalPage = totalRecord / pageSize;

			for (int i = 0; i < totalPage; i++) {
				if (i == page)
					bar += "<option value='" + i + "' selected>" + i
							+ "</option>";
				else
					bar += "<option value='" + i + "'>" + i + "</option>";
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		bar += "</select>";
		return bar;

	}

	public String createTable(String myClass, Field myFields[],
			Collection myObjects) throws IllegalArgumentException,
			IllegalAccessException, SecurityException, NoSuchMethodException,
			ClassNotFoundException, InstantiationException,
			InvocationTargetException {
		// caption

		String table = "<table border='0' width='100%' cellpadding='1' cellspacing='1' bgcolor='#999999'>";
		table += "<theader><tr class='tableheader'>";

		for (int i = 0; i < myFields.length; i++) {
			table += "<th>" + myFields[i].getName() + "</th>";
		}
		table += "<th>Action</th>";
		table += "</tr></theader><tbody>";

		String fieldName = "";
		Object value = "";
		String fullClazzName = packageName + "." + myClass;

		int k = 0;
		int myId = 0;
		int valueId = 0;

		for (Object obj : myObjects) {
			k++;
			table += "<tr class='tableitem'>";
			for (int i = 0; i < myFields.length; i++) {
				fieldName = myFields[i].getName();
				String fieldType = myFields[i].getType().toString();

				value = invoke(fullClazzName, "get" + up1(fieldName), obj,
						new Class[] {}, new Object[] {});

				if (fieldName.equals("id"))
					myId = Integer.valueOf(invoke(fullClazzName, "getId", obj,
							new Class[] {}, new Object[] {}).toString());

				table += "<td>" + value + "</td>";

			}
			table += "<td><a href='generic.action?clazz=" + myClass
					+ "&action=edit&id=" + myId + "'>Edit</a> - ";
			table += "<a href='#' onClick=\"if(confirm('Do you want to delete?')){ beforeDelete("
					+ myId + ") } \">Del</a></td>";

			table += "</tr>";
		}

		table += "</tbody></table>";

		return table;
	}

	public String execute() {

		String fullClazzName = packageName + "." + clazz;

		if (action == null)
			action = "";
		if (pageSize == 0)
			pageSize = 50;
		if (page == 0)
			page = 1;

		try {

			Field fields[] = Class.forName(fullClazzName).getDeclaredFields();

			object = genericDao.get(Class.forName(fullClazzName), id);

			if (object == null)
				object = Class.forName(fullClazzName).newInstance();

			if (action.equalsIgnoreCase("save")) {
				// setting property
				for (int i = 0; i < fields.length; i++) {
					String fieldName = fields[i].getName();
					String fieldType = fields[i].getType().toString();

					Object value = ServletActionContext.getRequest()
							.getParameter(fieldName);

			
					if (fieldType.indexOf("String") >= 0)
						invoke(fullClazzName, "set" + up1(fieldName), object,
								new Class[] { String.class },
								new Object[] { new String("" + value + "") });

					if (fieldType.indexOf("int") >= 0)
						invoke(fullClazzName, "set" + up1(fieldName), object,
								new Class[] { int.class },
								new Object[] { new Integer("" + value + "") });

					if (fieldType.indexOf("float") >= 0)
						invoke(fullClazzName, "set" + up1(fieldName), object,
								new Class[] { float.class },
								new Object[] { new Float("" + value + "") });

					if (fieldType.indexOf("class") >= 0
							&& fieldType.indexOf("java") < 0) {
						Object oj = genericDao.get(Class.forName(packageName
								+ "." + up1(fieldName)), new Integer(value
								.toString()));

						invoke(fullClazzName, "set" + up1(fieldName), object,
								new Class[] { Class.forName(packageName + "."
										+ up1(fieldName)) },
								new Object[] { oj });
					}

				}

				if (id > 0) {
					genericDao.update(object);
				} else {
					genericDao.save(object);
				}
			}

			if (action.equalsIgnoreCase("delete")) {
				genericDao.delete(object);

			}

			// reload a list of card type
			objects = genericDao.getAll(Class.forName(fullClazzName), pageSize,
					page);

			paginationBar = createPaginationBar(fullClazzName, pageSize, page);

			table = createTable(clazz, fields, objects);

			form = createForm(clazz, fields, object, id);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

}
