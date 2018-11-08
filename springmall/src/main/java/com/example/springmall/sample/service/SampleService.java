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
		//	GET 방식으로 page값이 들어오면 currentPage에 저장합니다.
		if(page != 1) {
			currentPage = page;
		}
		//	lastPage값을 계산합니다.
		lastPage = totalRow/rowPerPage;
		if(totalRow%rowPerPage != 0) {
			lastPage++;
		}
		//	만약 currentPage가 1~lastPage 범위를 벗어나면 1이나 lastPage값으로 바꿔줍니다.
		if(currentPage>lastPage) {
			currentPage=lastPage;
		}else if(currentPage<1) {
			currentPage=1;
		}
		//	한 페이지에 페이지 버튼 수는 10개로 가정합니다.
		//	currentPage를 기반으로 가장 큰 페이지값을 계산합니다.
		//	currentPage 1~10 이면 lastPageButton=10
		//	11~20 => 20, 21~30 => 30
		//	현재페이지에 9를 더한뒤 첫째자리를 떼면 됩니다.
		//	가장 작은 페이이지버튼값도 자동으로 계산됩니다.
		lastPageButton = ((currentPage+9)/10)*10;
		firstPageButton = lastPageButton-9;
		//	위 계산을 거친 후 마지막 페이지값이 lastPageButton값도다 작을 수 있습니다.
		//	currnetPage가 lastPage에 근접한 경우입니다.
		//	lastPage의 버튼까지만 화면에 보여주기 위해서
		//	lastPageButton을 lastPage로 바꿔줍니다.
		if((lastPage-1)/10 == (currentPage-1)/10) {
			lastPageButton = lastPage;
		}
		//	현재페이지와 한페이지에 보여줄 목록 수 값을 계산하여 SELECT합니다.
		int startRow = (currentPage-1)*rowPerPage;
		pagingInfo.put("startRow", startRow);
		pagingInfo.put("rowPerPage", rowPerPage);
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
