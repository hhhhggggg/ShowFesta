package org.project.service;

import java.util.List;
import org.project.domain.SearchVO;

public interface SearchService {
    List<SearchVO> search(String keyword); // �˻� �޼��� ����

    // �ٸ� �޼���� �����մϴ�.
}