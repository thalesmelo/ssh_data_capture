package com.dataCapture.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dataCapture.pojo.Detail_info;
import com.dataCapture.service.DataCaptureService;
import com.opensymphony.xwork2.ActionSupport;

import oracle.net.aso.d;

/**
 * @author zhuCan
 *
 * @DATE 2017年10月14日
 *
 * @TIME 下午8:09:39
 */
public class DataUpdateAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Detail_info> infos;
	private Integer size;

	@Autowired
	private DataCaptureService service;

	public String query() {

		List<Detail_info> list = service.queryAll();
		infos = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			infos.add(list.get(list.size() - i - 1));
		}

		size = infos.size();
		return SUCCESS;
	}

	/**
	 * @return the infos
	 */
	public List<Detail_info> getInfos() {
		return infos;
	}

	/**
	 * @param infos
	 *            the infos to set
	 */
	public void setInfos(List<Detail_info> infos) {
		this.infos = infos;
	}

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

}
