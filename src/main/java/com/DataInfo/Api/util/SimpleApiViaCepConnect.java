package com.DataInfo.Api.util;

import javax.json.Json;
import javax.json.JsonObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class SimpleApiViaCepConnect {

	public static JsonObject apiViaCepConnect(String cep) {

		JsonObject jsonObject = null;

		try {
			if (!Util.checkCep(cep)) {
				throw new RuntimeException("Formato de CEP inválido");
			}
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet("https://viacep.com.br/ws/" + cep + "/json");
			HttpResponse httpResponse = httpclient.execute(httpGet);

			HttpEntity entity = httpResponse.getEntity();

			jsonObject = Json.createReader(entity.getContent()).readObject();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return jsonObject;
	}
}
