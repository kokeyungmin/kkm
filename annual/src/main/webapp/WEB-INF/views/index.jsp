<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Read Only by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="/spring_Annual/resources/assets/css/annual.css" />
		<link rel="stylesheet" href="/spring_Annual/resources/assets/css/main.css" />
 		<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
		<script src="/spring_Annual/resources/assets/js/annual1.js"></script>
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>

		<!-- Header -->
			<section id="header">
				<header>
					<span class="image avatar"><img src="/spring_Annual/resources/images/avatar.jpg" alt="" /></span>
					<h1 id="logo"><a href="#">Willis Corto</a></h1>
					<p>I got reprogrammed by a rogue AI<br />
					and now I'm totally cray</p>
				</header>
				<nav id="nav">
					<ul>
						<li><a href="#one" class="active">연차</a></li>
						<li><a href="#two">추가</a></li>
						<!-- <li><a href="#three">A Few Accomplishments</a></li> -->
					</ul>
				</nav>
				<!-- <footer>
					<ul class="icons">
						<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
						<li><a href="#" class="icon fa-envelope"><span class="label">Email</span></a></li>
					</ul>
				</footer> -->
			</section>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">

						<!-- One -->
							<section id="one">
								<div class="container">
									<header class="major">
										<h2>전체 연차</h2>
									</header>
									<table>
										<thead>
											<tr>
												<th>이름</th>
												<th>직급</th>
												<th>총 연차</th>
												<th>사용 연차</th>
												<th>남은 연차</th>
												<th>기록</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${view }" var="dto">
												<tr class="menu">
													<td>${dto.aName }</td>
													<td>${dto.rank }</td>
													<td>${dto.annual }</td>
													<td>${dto.use }</td>
													<td>${dto.annual-dto.use }</td>
													<td>${dto.aDate }</td>
													<td class="btn" id="${dto.aId }"><button>▼</button></td>
												</tr>
												<c:forEach items="${log }" var="log">.
												<tr class="sub ${dto.aId }">
												<c:if test="${dto.aId==log.aId}">
													<td colspan="3">${log.aDate }</td>
													<td colspan="4">${log.aComent }</td>
												</c:if>
												</tr>
												</c:forEach>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</section>

						<!-- Two -->
							<section id="two">
								<div class="container">
									<h3>연차 요청</h3>
									<form action="insert" method="post">
										<input type="hidden" value="${name.aId }" name="id"/>
										이름: <input type="text" id="name" class="add" value="${name.aName }" style="width: 20%; display: inline;"/>&nbsp&nbsp
										직급: <input type="text" name="rank" class="add" value="${name.rank }" style="width: 20%; display: inline;"/>&nbsp&nbsp
										날짜: <input type="date" id="test" name="date" style="width: 41%; display: inline;"/> <br />
										총연차: <input type="text" value="${name.annual }" style="width: 39%; display: inline;"/>&nbsp&nbsp
										사용한 연차: <input type="text" value="${name.use }" style="width: 39.5%; display: inline;"/>
										이유: <textarea name="coment" id="" cols="30" rows="10"></textarea>
										<input type="submit" value="요청"/>
									</form>
								</div>
							</section>

						<!-- Three -->
							<!-- <section id="three">
								<div class="container">
									<h3>A Few Accomplishments</h3>
									<p>Integer eu ante ornare amet commetus vestibulum blandit integer in curae ac faucibus integer non. Adipiscing cubilia elementum integer. Integer eu ante ornare amet commetus.</p>
									<div class="features">
										<article>
											<a href="#" class="image"><img src="images/pic01.jpg" alt="" /></a>
											<div class="inner">
												<h4>Possibly broke spacetime</h4>
												<p>Integer eu ante ornare amet commetus vestibulum blandit integer in curae ac faucibus integer adipiscing ornare amet.</p>
											</div>
										</article>
										<article>
											<a href="#" class="image"><img src="images/pic02.jpg" alt="" /></a>
											<div class="inner">
												<h4>Terraformed a small moon</h4>
												<p>Integer eu ante ornare amet commetus vestibulum blandit integer in curae ac faucibus integer adipiscing ornare amet.</p>
											</div>
										</article>
										<article>
											<a href="#" class="image"><img src="images/pic03.jpg" alt="" /></a>
											<div class="inner">
												<h4>Snapped dark matter in the wild</h4>
												<p>Integer eu ante ornare amet commetus vestibulum blandit integer in curae ac faucibus integer adipiscing ornare amet.</p>
											</div>
										</article>
									</div>
								</div>
							</section> -->

					</div>
					<div class="bigmodal">
      <div class="jquery-modal blocker"></div>
      <div class="modalbox">
         <div class="modalHeader">
            <form action="add" method="post">
            	이름: <input type="text" name="name"/>
            </form>
         </div>
         <div class="modalContent">
         	<table>
         		<c:forEach items="name">
		            <tr>
		            	<td></td>
		            	<td></td>
		            	<td></td>
		            </tr>
            	</c:forEach>
         	</table>   
         </div>
         <div class="modalButton">
            <button type="button" class="btn" onclick="javascript:closed();">취소</button>
         </div>
      </div>
   </div>
   
					    

				<!-- Footer -->
					<section id="footer">
						<div class="container">
							<ul class="copyright">
								<li>&copy; Untitled. All rights reserved.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>
					</section>

			</div>

		<!-- Scripts -->
			<!-- <script src="/spring_Annual/resources/assets/js/jquery.min.js"></script>
			<script src="/spring_Annual/resources/assets/js/jquery.js"></script> -->
			<script src="/spring_Annual/resources/assets/js/jquery.scrollzer.min.js"></script>
			<script src="/spring_Annual/resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="/spring_Annual/resources/assets/js/skel.min.js"></script>
			<script src="/spring_Annual/resources/assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="/spring_Annual/resources/assets/js/main.js"></script>

	</body>
</html>