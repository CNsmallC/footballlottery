package cn.smallc.footballLottery.common.web;

import cn.smallc.footballLottery.common.ientity.WebAggregateRoot;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public abstract class MyCrudController<T extends WebAggregateRoot> extends MyController {
	
	@PostMapping("/add")
	public JsonResult add(@Valid T obj,BindingResult result){
		return onAdd(obj,result,new JsonResult());
	}
	
	@PostMapping("/edit")
	public JsonResult edit(@Valid T obj,BindingResult result){
		return onEdit(obj,result,new JsonResult());
	}
	
	@PostMapping("/remove")
	public JsonResult remove(T obj){
		return onRemove(obj,new JsonResult());
	}
	
	@PostMapping("/get")
	public JsonResult get(T obj){
		return onGet(obj,new JsonResult());
	}
	
	@PostMapping("/query")
	public JsonResult query(RequestParamMVCMap<String> params){
		return onQuery(params,new JsonResult());
	}
	
	protected abstract JsonResult onAdd(@Valid T obj, BindingResult result, JsonResult jsonResult);
	protected abstract JsonResult onEdit(@Valid T obj, BindingResult result, JsonResult jsonResult);
	protected abstract JsonResult onRemove(T obj,JsonResult jsonResult);
	protected abstract JsonResult onGet(T obj,JsonResult jsonResult);
	protected abstract JsonResult onQuery(RequestParamMVCMap<String> params,JsonResult jsonResult);
}
