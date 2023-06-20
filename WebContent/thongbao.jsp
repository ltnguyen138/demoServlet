<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
   		<title>Quản lý hàng hóa - Cửa hàng vật tư, phân bón nông nghiệp</title>
    	<link rel="stylesheet" href="style1.css">
	</head>
	<body>
		<div class="container">
  			<header>
    			<div class="header1">
    				<a href="#"><img src="./download14.png" alt="logo"> </a>
  				</div>
  				<div class="header2">
    				<ul>
				      <a href="#"><img src="./facebook.png" alt="logo" style="width: 60px;height: 20px;"> </a>
				      <a href="#"><img src="./instagram.png" alt="logo" style="width: 60px;height: 20px;"> </a>
				      <a href="#"><img src="./youtube.png" alt="logo" style="width: 60px;height: 20px;"> </a>
				      <a href="#"><img src="./twitter.png" alt="logo" style="width: 60px;height: 20px;"> </a>
    				</ul>  
  				</div>
  			</header>
  			<nav>
    			<div class="menu">
      				<ul>
				       <li><a href="Danh-sach-nha-cung-cap">Nhà cung cấp</a></li>
				        <li><a href="Danh-sach-hang-hoa">Hàng hóa</a></li>
				        <li><a href="Danh-sach-phieu-nhap">Phiếu nhập</a></li>
				        <li><a href="Danh-sach-phieu-xuat">Phiếu xuất</a></li>
				        <li><a href="Danh-sach-khach-hang">Khách hàng</a></li>
				        <li><a href="Danh-sach-nhan-vien">Nhân viên</a></li>
      				</ul>
    			</div>
   				<div class="search">
      				<form method="GET" action="${pageContext.request.contextPath}/Danh-sach-khach-hang">
      				<input type="text" placeholder="Search" name="search">
      				<input type="submit" value="Tìm kiếm" >
      			</form>
    			</div>
  			</nav>
  		<div id="main-content">
  			<div class="dangxuat">
          <ul>
          <li><a href="logout">Đăng xuất</a></li>  
  			  <li><p>${name},</p></li>
          
          </ul>
  			</div>
        	<div class="tieude">
        		<h1>Bạn không có quyền truy cập vào trang quảng lý nhân viên</h1>
        	</div>
        	<div style="float: left; line-height:38px;margin-left: 50px;
						           background-color: rgb(8, 101, 59);padding:0px 70px 0px 70px ;margin-top:50px;margin-left: 550px;">
						          <a style="color: white;" href="Danh-sach-hang-hoa" >Quay lại</a></div>
  		</div>
	</div>
	<footer>
    	<div class="fLeft">
		     <p>Cửa Hàng Vật Tư Nông Nghiệp</p>
		     <p>Địa chỉ: 123 abc, phường X, quận Y, tp.Z<br />
		     Điện thoại: 012.3456789</p>
		     <p>Email: <a href="mailto:support@hocwebchuan.com">support@vattunongnghiep.com</a></p>
		</div>
		<div class="fRight">
        	<h3>Danh mục</h3>
        	<ul>
	            <li><a href="Danh-sach-nha-cung-cap">Nhà cung cấp</a></li>
		        <li><a href="Danh-sach-hang-hoa">Hàng hóa</a></li>
		        <li><a href="Danh-sach-phieu-nhap">Phiếu nhập</a></li>
		        <li><a href="Danh-sach-phieu-xuat">Phiếu xuất</a></li>
		        <li><a href="Danh-sach-khach-hang">Khách hàng</a></li>
		        <li><a href="Danh-sach-nhan-vien">Nhân viên</a></li>
        	</ul>
       </div>   
	</footer>
</body>
</html>