<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@include file="../includes/header.jsp"%>
<link href="/resources/css/mainpage.css?after" rel="stylesheet">
<main id="main">
	<html>
<head>
<link href="/resources/css/swiper.css?after" rel="stylesheet">
<script src="https://unpkg.com/swiper@8/swiper-bundle.min.js"></script>
<title>Home</title>
</head>
<body>
	<div id="cont_wrap" class="clear_g">
		<div class="wrap_main_slider">
			<div class="swiper" style="width: 2959px; left: -1076px;">
				<div class="swiper-wrapper">
					<div class="swiper-slide">
						<a href="/page/musical_info"><img
							src=http://tkfile.yes24.com/upload2/PerfBlog/202307/20230703/20230703-46234.jpg
							class=img></a>
					</div>
					<div class="swiper-slide">
						<a href="/page/musical_info"><img
							src=http://tkfile.yes24.com/upload2/PerfBlog/202308/20230804/20230804-46305.jpg
							class=img></a>
					</div>
					<div class="swiper-slide">
						<a href="/page/musical_info"><img
							src=https://ticketimage.interpark.com/Play/image/large/L0/L0000049_p.gif
							class=img></a>
					</div>
					<div class="swiper-slide">
						<a href="/page/musical_info"><img
							src=http://tkfile.yes24.com/upload2/PerfBlog/202308/20230830/20230830-46927.jpg
							class=img></a>
					</div>
					<div class="swiper-slide-on">
						<a href="/page/musical_info"><img
							src=https://ticketimage.interpark.com/Play/image/large/23/23008837_p.gif
							class=img></a>
					</div>
					<div class="swiper-slide-on">
						<a href="/page/musical_info"><img
							src=https://ticketimage.interpark.com/Play/image/large/23/23012526_p.gif
							class=img></a>
					</div>
					<div class="swiper-slide-on">
						<a href="/page/musical_info"><img
							src=http://tkfile.yes24.com/upload2/PerfBlog/202309/20230904/20230904-47067.jpg
							class=img></a>
					</div>
					<div class="swiper-slide">
						<a href="/page/musical_info"><img
							src=https://ticketimage.interpark.com/Play/image/large/23/23011055_p.gif
							class=img></a>
					</div>
					<div class="swiper-slide">
						<a href="/page/musical_info"><img
							src=http://tkfile.yes24.com/upload2/PerfBlog/202309/20230912/20230912-47041.jpg
							class=img></a>
					</div>
					<div class="swiper-slide">
						<a href="/page/musical_info"><img
							src=http://tkfile.yes24.com/upload2/PerfBlog/202309/20230907/20230907-47116.jpg
							class=img></a>
					</div>
					<div class="swiper-slide">
						<a href="/page/musical_info"><img
							src=https://korean.visitkorea.or.kr/kfes/upload/contents/db/400_7c1728ce-e80a-4c10-809d-6212a0e38bff_3.jpg
							class=img></a>
					</div>
				</div>

				<div class="swiper-pagination"></div>

				<div class="swiper-button-prev">
					<div class="btn_mslider_prev"></div>
				</div>
				<div class="swiper-button-next">
					<div class="btn_mslider_next"></div>
				</div>
			</div>
		</div>
	</div>
	<div class>
		<div data-v-223ac3f7>
			<div data-v-223ac3f7 id="mitisection_index_1" class="multi portrait-cell" style="background-color: #000127;">
				<div data-v-223ac3f7 class="title">
					<h1 data-v-223ac3f7 tabindex="0" class="title-area">
						<span data-v-223ac3f7 class="label">뮤지컬</span>
					</h1>
				</div>
				<div data-v-223ac3f7>
					<div data-v-54077454 data-v-223ac3f7 class = "session-contents" cell-type="band_14">
						<div class = "contents-wrapper">
							<div data-v-54077454 class="slide1" style="width:240px; margin-right:10px;">
								<div data-v-54077454 class="thumb portrait" loaded-fn="function() { [navice cod]}" cell-index="0">
									<a href="/page/musical_info?m_num=141" aria-label="">
										<div class="thumb-image">
											<div class="picture-area">
												<picture> <img
													src="https://ticketimage.interpark.com/Play/image/large/23/23008837_p.gif"
													class="thumb-img"> </picture>
											</div>
										</div>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<a data-v-223ac3f7 href="#" class="btn-more all">더보기</a>
			</div>
		</div>
	</div>
		<ul>
		</ul>
</body>
<script>
	new Swiper('.swiper', {
		autoplay : {
			delay : 5000
		},
		loop : true,
		slidesPerView : 3,
		spaceBetween : 5,
		centeredSlides : true,
		pagination : {
			el : '.swiper-pagination',
			clickable : true
		},
		navigation : {
			prevEl : '.swiper-button-prev',
			nextEl : '.swiper-button-next'
		}
	})
</script>
	</html>
</main>