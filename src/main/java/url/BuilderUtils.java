package url;

import java.util.Arrays;
import java.util.List;

public class BuilderUtils {

	// 设置userAgentstrs库
	String[] userAgentstrs = {
			"Mozilla/5.0 (Macintosh; U; Intel Mac os x 10 6 8; en-us) Applewebkit/534.50 (KHTML, like Gecko) version/5.1 Safari/534.50",
			"Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) Applewebkit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50",
			"Mozilla/5.0 (Windows NT 10.0; wow64; rv:38.0). Gecko/20100101 Firefox/38.0",
			"Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; NET4.0C; .NET4.OE; .NET CLR 2.0.50727; .NET CLR 3.0.30729; .NET CLR 3.5.30729; InfoPath.3; rv:11.0) like Gecko",
			"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1;Trident/5.0)",
			"Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0;Trident/4.0)",
			"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)" };
	// 将数组放入list
	List<String> userAgentList = Arrays.asList(userAgentstrs);
	int userAgentSize = userAgentList.size();

	// //设置Referer库;读者根据需求添加更多Referer
	String[] refererstrs = { "https://www.bilibili.com/" };
	// 设置accept, accept-Language及accept-Encoding
	String accept = "text/html, application/xhtml+xml, application/xml ;q=0. 9, image/webp, image/apng,*/*;q=0.8";
	String acceptLanguage = "zh-cn, zh;q=0.5";
	String acceptEncoding = "gzip, deflate";
	String contentType = "text/plain;charset=UTF-8";
	String host;

	public String[] getUserAgentstrs() {
		return userAgentstrs;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setUserAgentstrs(String[] userAgentstrs) {
		this.userAgentstrs = userAgentstrs;
	}

	public List<String> getUserAgentList() {
		return userAgentList;
	}

	public void setUserAgentList(List<String> userAgentList) {
		this.userAgentList = userAgentList;
	}

	public int getUserAgentSize() {
		return userAgentSize;
	}

	public void setUserAgentSize(int userAgentSize) {
		this.userAgentSize = userAgentSize;
	}

	public String[] getRefererstrs() {
		return refererstrs;
	}

	public void setRefererstrs(String[] refererstrs) {
		this.refererstrs = refererstrs;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getAcceptLanguage() {
		return acceptLanguage;
	}

	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}

	public String getAcceptEncoding() {
		return acceptEncoding;
	}

	public void setAcceptEncoding(String acceptEncoding) {
		this.acceptEncoding = acceptEncoding;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
