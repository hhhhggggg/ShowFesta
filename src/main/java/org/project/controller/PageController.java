package org.project.controller;

import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.project.data.DateData;
import org.project.domain.ContentsVO;
import org.project.domain.MemberVO;
import org.project.service.ContentsService;
import org.project.service.MemberService;
import org.project.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/page/*")
public class PageController {
	@Autowired
	private ScheduleService scheduleservice;
	@Autowired
	private MemberService memberservice;
	@Autowired
	private ContentsService contentsservice;

	
	@GetMapping("/calendar")
	public String calendar(Model model, HttpServletRequest request, DateData dateData) {
		log.info("calendar Get");
		Calendar cal = Calendar.getInstance();
		DateData calendarData;

		// 검색 날짜
		if (dateData.getDate().equals("") && dateData.getMonth().equals("")) {
			dateData = new DateData(String.valueOf(cal.get(Calendar.YEAR)), String.valueOf(cal.get(Calendar.MONTH)),
					String.valueOf(cal.get(Calendar.DATE)), null);
		}
		// 검색 날짜 end

		Map<String, Integer> today_info = dateData.today_info(dateData);
		List<DateData> dateList = new ArrayList<DateData>();

		
		// 실질적인 달력 데이터 리스트에 데이터 삽입 시작.
		// 일단 시작 인덱스까지 아무것도 없는 데이터 삽입
		for (int i = 1; i < today_info.get("start"); i++) {
			calendarData = new DateData(null, null, null, null);
			dateList.add(calendarData);
		}

		// 날짜 삽입
		for (int i = today_info.get("startDay"); i <= today_info.get("endDay"); i++) {
			if (i == today_info.get("today")) {
				calendarData = new DateData(String.valueOf(dateData.getYear()), String.valueOf(dateData.getMonth()),
						String.valueOf(i), "today");
			} else {
				calendarData = new DateData(String.valueOf(dateData.getYear()), String.valueOf(dateData.getMonth()),
						String.valueOf(i), "normal_date");
			}
			dateList.add(calendarData);
		}

		// 달력 빈곳 빈 데이터로 삽입
		int index = 7 - dateList.size() % 7;

		if (dateList.size() % 7 != 0) {
			for (int i = 0; i < index; i++) {
				calendarData = new DateData(null, null, null, null);
				dateList.add(calendarData);
			}
		}
		System.out.println(dateList);
		int musicalCnt = scheduleservice.getMusical();
		int concertCnt = scheduleservice.getConcerts();
		
		// 배열에 담음
		model.addAttribute("musicalCnt", musicalCnt);
		model.addAttribute("concertCnt", concertCnt);
		model.addAttribute("dateList", dateList); // 날짜 데이터 배열
		model.addAttribute("today_info", today_info);
		return "/page/calendar";
	}

	@GetMapping("/main")
	public void main(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		log.info("main Get");
		if (id != null) {
			MemberVO membervo = memberservice.getUserInfo(id);
			model.addAttribute("user", membervo);
		}
	}
	@GetMapping("/musical_info")
	public void m_info(@RequestParam("m_num") Long m_num, Model model) {
		log.info(m_num);
		ContentsVO result = contentsservice.getMusical(m_num);
		String s_date = result.getM_start_date();
		result.setM_start_date(parseDate(s_date));
		String e_date = result.getM_end_date();
		result.setM_end_date(parseDate(e_date));
		model.addAttribute("musical", result);
	}

	//오라클로 날짜를 받아오면 2023-08-10 00:00:00 이런식으로 가져오는데 이걸 2023.08.10 으로 바꾸는 함수
	public String parseDate(String inputString)
	{
		String[] parts = inputString.split(" "); // 공백을 기준으로 문자열을 나눔
		String datePart = parts[0]; // "2023-08-10" 부분을 가져옴
		String[] dateParts = datePart.split("-"); // "-"을 기준으로 날짜 부분을 나눔
		String formattedDate = dateParts[0] + "." + dateParts[1] + "." + dateParts[2]; // 원하는 형식으로 조합
		return formattedDate;
	}
	
	@GetMapping("/news")
	public void latestNewsPage() {
		log.info("News get");
	}
	
	
	//	뮤지컬 상세페이지 가져옵니다
	@GetMapping("/mContents")
	public void musicalContent(Model model) {

		log.info("musical contents get");
		List<ContentsVO> musicalList = contentsservice.getMusicalContents();
		System.out.println(musicalList.get(1).getM_num());
		model.addAttribute("musicalContents",musicalList);
		
	}
	
}
