package com.liy.utils.jsonToXml;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;


public class JsonToXmlUtil {

		/**
		 * 将json转换为xml
		 */
		public String jsonToXml(String json) {

			JSONObject j = JSONObject.fromObject(json);
			String xml = "";
			XMLSerializer xmlSer = new XMLSerializer();
			xmlSer.setRootName("info");
			xmlSer.setTypeHintsEnabled(false);
			xml = xmlSer.write(j);
			return xml;
		}

		/**
		 * Xml转换为json
		 */
		public String xmlToJson(String xml) {
			String json = "";
			XMLSerializer xmlser = new XMLSerializer();
			json = xmlser.read(xml).toString();
			return json;
		}

		/**
		 * java对象转换为json
		 * @param <T>
		 */
		public <T> String pojotoJson(T vo) {

			JSONObject j = JSONObject.fromObject(vo);
			String json = j.toString();
			return json;
		}

	
}
