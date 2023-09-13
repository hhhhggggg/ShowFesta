package org.project.service;

import java.util.ArrayList;

import org.project.domain.ContentsVO;
import org.project.mapper.ContentsMapper;
import org.project.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ContentsServiceImpl implements ContentsService {
	
	
	private ContentsMapper contentsmapper;

	public ArrayList<String> getMusicalContents() {
        // ���⼭ ������ �����ͺ��̽����� ������ �������� �������� ArrayList<String> ���·� ��ȯ
        
		//test
        ArrayList<String> musicalContents = new ArrayList<>();
//        musicalContents.add("������ 1");
//        musicalContents.add("������ 2");
        // �����ͺ��̽����� ������ ���� �����͸� ���⿡ �߰��ϼ���.

        return musicalContents;
    }
	
}
