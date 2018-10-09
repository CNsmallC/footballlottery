package cn.smallc.footballLottery.common.web;

import java.util.Map;

public class RequestParamMVCMap<T> {
	private Map<String,T> params;

	public Map<String, T> getParams() {
		return params;
	}
	public void setParams(Map<String, T> params) {
		this.params = params;
	}  
}
