package com.example.springmall.sample.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;

@Service
@Transactional
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	//	1
	public HashMap<String, Object> getSampleList(String page){
		//	페이징 관련 코드
		HashMap<String, Integer> pagingInfo = new HashMap<String, Integer>();
		int totalRow = sampleMapper.selectCountSampleAll();
		int rowPerPage = 11;
		int lastPage = 1;
		int currentPage = 1;
		int lastPageButton = 10;
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage++;
		}
		lastPageButton = ((currentPage+9)/10)*10;
		if((lastPage-1)/10 == (currentPage-1)/10) {
			lastPageButton = lastPage;
		}
		int startRow = (currentPage-1)*rowPerPage;
		pagingInfo.put("startRow", startRow);
		pagingInfo.put("rowPerPage", rowPerPage);
		List<Sample> list = sampleMapper.selectSample(pagingInfo);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("lastPage", lastPage);
		map.put("currentPage", currentPage);
		map.put("lastPageButton", lastPageButton);
		return map;
	}
	//	2
	public int removeSample(int sampleNo) {
		return sampleMapper.deleteSample(sampleNo);
	}
	//	3
	public int addSample(String id, String pw) {
		return sampleMapper.insertSample(new Sample(0, id, pw));
	}
}
