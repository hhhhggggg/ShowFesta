package org.project.service;

import java.util.List;
import org.project.domain.ContentsVO;


public interface ContentsService {

	public List<ContentsVO> getMusicalContents();
	
	public ContentsVO getMusical(Long m_num);

	public List<ContentsVO> getConcertContents();
	
	public List<ContentsVO> getFestivalContents();
	
	//Ķ���� ���â�� ��� ���� �ִ� ����
	public List<ContentsVO> getToday_contents();
//	public List<ContentsVO> getToday_c_contents();
//	public List<ContentsVO> getToday_f_contents();
}
