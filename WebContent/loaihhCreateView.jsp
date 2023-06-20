<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
      					<a href="#"><img src="./facebook.png" alt="logo" style="width: 55px;height: 18px;"> </a>
      					<a href="#"><img src="./instagram.png" alt="logo" style="width: 55px;height: 18px;"> </a>
      					<a href="#"><img src="./youtube.png" alt="logo" style="width: 55px;height: 18px;"> </a>
      					<a href="#"><img src="./twitter.png" alt="logo" style="width: 55px;height: 18px;"> </a>
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
     				</ul>
    			</div>
    			<div class="search">
      				<input type="search" placeholder="Search">
      				<button>Tìm kiếm</button>
    			</div>  
  			</nav>
  			<div id="main-content">
  			<div class="dangxuat">
          <ul>
          <li><a href="logout"> Dang Xuat</a></li>  
  			  <li><p>Admin,</p></li>
          
          </ul>
  			</div>
        		<div class="tieude">
        			<h1>THÊM MỚI LOẠI HÀNG HÓA</h1>
        		</div>
        		<div class="form">
        			<form method="POST" action="${pageContext.request.contextPath}/Them-moi-loai-hang-hoa">
        				
          					<ul>                   
          						<li><p>Mã loại hàng hóa</p></li>
          						<li><input type="text" name="maLoaihh" value="${loaihh.maLoaihh}"/> </li>                        
          						<li><p>Tên loại hàng hóa</p></li>
					          	<li><input type="text" name="tenLoaihh" value="${loaihh.tenLoaihh}"/> </li>                          
					          	   
					        </ul>      
          					<ul style=" margin-top: 10px;">
						          <li style="float: left;">
						          <input type="submit" value="Lưu" style="height:38px 
						          ;width: 200px;background-color:rgb(8, 101, 59);color: aliceblue; ">
						          </li>
						          <li style="float: left; line-height:38px;margin-left: 50px;
						           background-color: rgb(8, 101, 59);padding:0px 70px 0px 70px ;">
						          <a href="Danh-sach-loai-hang-hoa" >Quay lại</a>
						          </li>
          					</ul>                              		    
          				</form>
        			</div>    
  				</div>
			</div>
  		<footer>
    		<div class="fLeft">
	      		<p>Cửa hàng vật tư nông nghiệp</p>
	      		<p>Địa chỉ: 123 abc, phường X, quận Y, tp.Z<br />
	      		Điện thoại: 012.3456789</p>
	      		<p>Email: <a href="mailto:support@hocwebchuan.com">support@vattunongnghiep.com</a></p>
	      		<!-- / class fLeft --></div>
	      	<div class="fRight">
	        	<h3>Danh mục</h3>
	        	<ul>
	          		<li><a href="Danh-sach-nha-cung-cap">Nhà cung cấp</a></li>
			        <li><a href="Danh-sach-loai-hang-hoa">Loại hàng hóa</a></li>
			        <li><a href="Danh-sach-hang-hoa">Hàng hóa</a></li>
			        <li><a href="Danh-sach-chi-tiet-hoa-don">Chi tiết hóa đơn</a></li>
			        <li><a href="Danh-sach-hoa-don">Hóa đơn</a></li>
			        <li><a href="Danh-sach-khach-hang">Khách hàng</a></li>
        		</ul>
        	</div>         
  		</footer>
</html>