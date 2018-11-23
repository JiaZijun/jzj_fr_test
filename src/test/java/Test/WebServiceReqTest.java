package Test;

import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class WebServiceReqTest {
	 static int socketTimeout = 30000;// 请求超时时间  
     static int connectTimeout = 30000;// 传输超时时间  
     
	 public static String doPostSoap1_1(String postUrl, String soapXml,  
	            String soapAction) {  
	        String retStr = "";  
	        // 创建HttpClientBuilder  
	        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
	        // HttpClient  
	        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();  
	        HttpPost httpPost = new HttpPost(postUrl);  
	                //  设置请求和传输超时时间  
	        RequestConfig requestConfig = RequestConfig.custom()  
	                .setSocketTimeout(socketTimeout)  
	                .setConnectTimeout(connectTimeout).build();  
	        httpPost.setConfig(requestConfig);  
	        try {  
	            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");  
	            httpPost.setHeader("SOAPAction", soapAction);  
	            StringEntity data = new StringEntity(soapXml,  
	                    Charset.forName("UTF-8"));  
	            httpPost.setEntity(data);  
	            CloseableHttpResponse response = closeableHttpClient  
	                    .execute(httpPost);  
	            HttpEntity httpEntity = response.getEntity();  
	            if (httpEntity != null) {  
	                // 打印响应内容  
	                retStr = EntityUtils.toString(httpEntity, "UTF-8");  
	               System.out.println("response:" + retStr);  
	            }  
	            // 释放资源  
	            closeableHttpClient.close();  
	        } catch (Exception e) {  
	        }  
	        return retStr;  
	    } 
	 
	 public static void main(String[] args) {
	
		String pnrRetrieveXml = 
		"<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">"
			+"<SOAP-ENV:Header>"+
				"<t:Transaction xmlns:t=\"xxs\">"
					+"<tc>"
				 		+ "<iden u=\"FlightRoutesLHG\" p=\"JJ6ETXTkbaC7yAp37\" pseudocity=\"AJQW\" agt=\"xmlflro001\"  agtpwd=\"1nQnBVPw\" agtrole=\"Ticketing Agent\" agy=\"13300350\" />"
				 		+ "<agent user=\"xmlflro001\" />"
				 		+ "<trace>AJQW_flro</trace>"
				 		+ " <script engine=\"FLXDM\" name=\"flightroutes-lhg-dipatch.flxdm\" />"
				 	+ "</tc>"
				+"</t:Transaction>"
		 	+"</SOAP-ENV:Header>"
			+"<SOAP-ENV:Body>"
		 		+"<ns1:XXTransaction xmlns:ns1=\"xxs\">"
		 		+"<REQ>"
		 		+ "<OrderRetrieveRQ Version=\"17.2\" TransactionIdentifier=\"c6edeca0daff41f393cc2f6ef89f679a\">"
				  +" <Document id=\"document\"/>"
					+"<Party>"
					 +"<Sender>" 
						+" <TravelAgencySender>"
						+	"<PseudoCity>AE9L</PseudoCity>"
						+	"<AgencyID>27212216</AgencyID>"
						+	"</TravelAgencySender>"
					+ "</Sender>"
					+ "</Party>" 
					+ "<Query>"
					+ "<Filters>"
					 	+ "<BookingReferences>"
					 	  +  "<BookingReference>"
					 	   +  	"<ID>KEBZLT</ID>"
					 	   + 	"<OtherID>F1</OtherID>"
						+"</BookingReference>"
						 + "</BookingReferences>"
					+ "</Filters>"
					+"</Query>"
				+"</OrderRetrieveRQ>"
			+"</REQ>"
		+"</ns1:XXTransaction>"
		+"</SOAP-ENV:Body>"
	+"</SOAP-ENV:Envelope> ";
		
		
		String airShoppingXml = 
				"<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\">"
					+"<SOAP-ENV:Header>"+
						"<t:Transaction xmlns:t=\"xxs\">"
							+"<tc>"
						 		+ "<iden u=\"FlightRoutesLHG\" p=\"JJ6ETXTkbaC7yAp37\" pseudocity=\"AJQW\" agt=\"xmlflro001\"  agtpwd=\"1nQnBVPw\" agtrole=\"Ticketing Agent\" agy=\"13300350\" />"
						 		+ "<agent user=\"xmlflro001\" />"
						 		+ "<trace>AJQW_flro</trace>"
						 		+ " <script engine=\"FLXDM\" name=\"flightroutes-lhg-dipatch.flxdm\" />"
						 	+ "</tc>"
						+"</t:Transaction>"
				 	+"</SOAP-ENV:Header>"
					+"<SOAP-ENV:Body>"
				 		+"<ns1:XXTransaction xmlns:ns1=\"xxs\">"
				 		+"<REQ>"
				 		+"<AirShoppingRQ Version=\"17.2\" TransactionIdentifier=\"262cd1d804f8492fb332aa8853c1e996\">"
						+"<Document id=\"document\"/>"
						+"<Party>"
						+ "<Sender>"
							+ "<TravelAgencySender>"
								+ "<PseudoCity>AE9L</PseudoCity>"
								+ "<AgencyID>27212216</AgencyID>"
							+ "</TravelAgencySender>"
						+ "</Sender>"
						+"</Party>"
						+"<CoreQuery>"
						+ " <OriginDestinations>"
						+ " <OriginDestination OriginDestinationKey=\"OD1\">"
							+ "<Departure>"
								+ "<AirportCode>HKG</AirportCode>"
								+ "<Date>2018-10-01</Date>"
							+ "</Departure>"
							+ "<Arrival>"
								+ "<AirportCode>LAX</AirportCode>"
							+ "</Arrival>"
							+"</OriginDestination>"		
							+ " <OriginDestination OriginDestinationKey=\"OD2\">"
							+ "<Departure>"
								+ "<AirportCode>LAX</AirportCode>"
								+ "<Date>2018-10-09</Date>"
							+ "</Departure>"
							+ "<Arrival>"
								+ "<AirportCode>HKG</AirportCode>"
							+ "</Arrival>"
							+"</OriginDestination>"	
						+"</OriginDestinations>"	
						+"</CoreQuery>"	
						+"<DataLists>"
							+ "<PassengerList>"
								+ "<Passenger PassengerID=\"T1\">"
								+ "			<PTC>ADT</PTC>"
								+ "</Passenger>"
								+ "<Passenger PassengerID=\"T2\">"
										+ "<PTC>ADT</PTC>"
								+ "</Passenger>"
								+ "<Passenger PassengerID=\"T3\">"
								+ "<PTC>CNN</PTC>"
						+ "</Passenger>"
							+ "</PassengerList>"
						+ "</DataLists>"
						+ "</AirShoppingRQ>"
					+"</REQ>"
				+"</ns1:XXTransaction>"
				+"</SOAP-ENV:Body>"
			+"</SOAP-ENV:Envelope> ";
		
		
        //采用SOAP1.1调用服务端，这种方式能调用服务端为soap1.1和soap1.2的服务  
		String postUrl = "https://stg.farelogix.com:443/xmlts/sandboxdm";  
        doPostSoap1_1(postUrl, airShoppingXml, "");  
	}
	

 }
	

