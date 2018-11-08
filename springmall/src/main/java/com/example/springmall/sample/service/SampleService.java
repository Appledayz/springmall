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
	public HashMap<String, Object> getSampleList(int page){
		//	페이징 관련 코드
		HashMap<String, Integer> pagingInfo = new HashMap<String, Integer>();
		int totalRow = sampleMapper.selectCountSampleAll();
		int rowPerPage = 11;
		int lastPage = 1;
		int currentPage = 1;
		int lastPageButton = 10;
		int firstPageButton = 1;
		if(page != 1) {
			currentPage = page;
		}
		lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage++;
		}
		if(currentPage>lastPage) {
			currentPage=lastPage;
		}else if(currentPage<1) {
			currentPage=1;
		}
		lastPageButton = ((currentPage+9)/10)*10;
		firstPageButton = lastPageButton-9;
		if((lastPage-1)/10 == (currentPage-1)/10) {
			lastPageButton = lastPage;
		}
		int startRow = (currentPage-1)*rowPerPage;
		pagingInfo.put("startRow", startRow);
		pagingInfo.put("rowPerPage", rowPerPage);
		//	페이지정보를 바탕으로 목록 조회
		List<Sample> list = sampleMapper.selectSample(pagingInfo);
		//	뷰에 전달할 파라미터 저장
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("lastPage", lastPage);
		map.put("currentPage", currentPage);
		map.put("lastPageButton", lastPageButton);
		map.put("firstPageButton", firstPageButton);
		return map;
	}
	
	//	2
	public int removeSample(int sampleNo) {
		return sampleMapper.deleteSample(sampleNo);
	}
	
	//	3
	public int addSample(Sample sample) {
		return sampleMapper.insertSample(sample);
	}
	
	//	4
	public Sample getSample(int sampleNo) {
		return sampleMapper.selectOne(sampleNo);
	}
	
	//	4-2
	public int modifySample(Sample sample) {
		return sampleMapper.updateSample(sample);
	}
}
