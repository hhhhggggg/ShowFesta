package org.project.service;

import java.util.ArrayList;
import org.project.domain.ContentsVO;


public interface ContentsService {
	
	public ArrayList<String> getMusicalContents();
	
	public ContentsVO getMusical(Long m_num);
}
