package org.project.mapper;

import org.project.domain.ContentsVO;

public interface ContentsMapper {
	public ContentsVO getContentTitle(String title);
	
	public String selectMusical(String title);
	
	//�����ͺ��̽��� ���� �� ���� �������ϱ� ���ε��� ������ϴ��� �ñ�
}
