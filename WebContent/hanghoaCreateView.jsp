<%@ page language="java" contentType="text/html; charset=UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Quản lý hàng hóa - Cửa hàng vật tư, phân bón nông nghiệp</title>
    <link rel="stylesheet" href="style.css">
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
      				<input type="search" placeholder="Search">
      				<button>Tim kiem</button>
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
        			<h1>THEM MOI HANG HOA</h1>
        		</div>
        		<div class="form">
        			<form method="POST" action="${pageContext.request.contextPath}/Them-moi-hang-hoa">
        				
          					<ul>                   
          						<li><p>Mã hàng hóa</p></li>
          						<li><input type="text" name="maHH" value="${hanghoa.maHH}"/> </li>                        
          						<li><p>Tên hàng hóa</p></li>
					          	<li><input type="text" name="tenHH" value="${hanghoa.tenHH}"/> </li> 
					          	<li><p>Mã nhà cung cấp</p></li>
					          	<li><input type="text" name="maNCC" value="${hanghoa.maNCC}"/> </li>                           
					          	<li><p>Số lượng</p></li>
					          	<li><input type="text" name="maLoaihh" value="${hanghoa.soluong}"/> </li>      					                 
					          	<li><p>Đơn giá</p></li>
					          	<li><input type="text" name="donGia" value="${hanghoa.donGia}"/></li>   
					        </ul>      
          					<ul style=" margin-top: 10px;">
						          <li style="float: left;">
						          <input type="submit" value="Luu" style="height:38px 
						          ;width: 200px;background-color:rgb(8, 101, 59);color: aliceblue; ">
						          </li>
						          <li style="float: left; line-height:38px;margin-left: 50px;
						           background-color: rgb(8, 101, 59);padding:0px 70px 0px 70px ;">
						          <a href="Danh-sach-hang-hoa" >Quay lại</a>
						          </li>
          					</ul>                              		    
          				</form>
        			</div>    
  				</div>
			</div>
  		<footer>
    		<div class="fLeft">
	      		<p>Cửa Hàng Vật Tư Nông Ngiệp</p>
	      		<p>Địa chỉ: 123 abc, phường X, quận Y, tp.Z<br />
	      		Điện thoại: 012.3456789</p>
	      		<p>Email: <a href="mailto:support@hocwebchuan.com">support@vattunongnghiep.com</a></p>
	      		<!-- / class fLeft --></div>
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
</html>