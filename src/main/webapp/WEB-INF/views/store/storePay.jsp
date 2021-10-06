<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/storePay.css">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<div id="pay_wrap">
		<h2>결제</h2>
	
		<div id="box_product">	
		<h3> 주문 정보 </h3>	
			<table class="table">
				<thead>
					<tr>
						<th colspan="2">주문상품</th>
						<th>구매수량</th>
						<th>총 금액</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td width="150px"><img alt="상품이미지" src="https://cdn.pixabay.com/photo/2019/06/12/07/12/popcorn-4268489_960_720.jpg"></td>
						<td class="store_name"><p>버블버블버블팝 콤보</p><p>팝콘(R) 2 + 콜라 1</p></td>
						<td width="150px">2</td>
						<td width="200px">24,000</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<h3> 최종 결제 </h3>	
		<div id="box_price">
			<ul>
				<li>
					<div>
						<p class="price_title">총 상품금액</p>
						<b class="price_content"> 24,000 </b>
					</div>				
				</li>
				<li class="sign">-</li>
				<li>
					<div>
						<p class="price_title">할인 금액</p>
						<b class="price_content"> 3,000 </b>
					</div>				
				</li>
				<li class="sign">=</li>
				<li>
					<div>
						<p class="price_title">최종 결제 금액</p>
						<b class="price_final"> 21,000 </b>원
					</div>				
				</li>
			</ul>
		</div>
		<div class="box_pay">
			<button type="button" class="reset-button">취소</button>
			<button type="button" class="pay-button">구매</button>
		</div>		
	</div>
</body>
</html>