<%@ page language="java" contentType="text/html; charset=UTF-8"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
   		<title>Quản lý hàng hóa - Cửa hàng vật tư, phân bón nông nghiệp</title>
    	<link rel="stylesheet" href="style2.css">
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
      				<button>Tìm kiếm</button>
    			</div>
  			</nav>
  		<div id="main-content">
  			<div class="dangxuat">
          <ul>
          <li><a href="Them-moi-khach-hang"> Đăng xuất</a></li>  
  			  <li><p>${name},</p></li>
          
          </ul>
  			</div>
           
        	<div class="tieude">
        		<h1>CHI TIẾT PHIẾU NHẬP</h1>
        	</div>
            <div class="phieu">
				<div class="phieu1">
                	<p>Mã phiếu nhập: ${phieunhap.maphieunhap}</p>
				</div>
				<div class="phieu1">
					<ul>
						<p>Mã nhà cung cấp: ${phieunhap.mancc}</p>
						</ul>
				</div>
				<div class="phieu1">
                	<p>Mã nhân viên: ${phieunhap.mannv}</p>
				</div>
				<div class="phieu1">
                	<p>Ngày lập phiếu: ${phieunhap.ngaylapphieu}</p>
				</div>

            </div>


        	<div class="list">            
				
				<table class="table">				
					<tr>
						
						<th>Mã hàng hóa</th>
						<th>Tên hàng hóa</th>
						<th>Số lượng</th>
						<th>Đơn giá</th>
						
					</tr>									
					<c:forEach items="${ctphieunhapList}" var="ctphieunhapList" >

					<tr>
						<td>${ctphieunhapList.mahanghoa}</td>
						<td>${ctphieunhapList.tenhanghoa}</td>
						<td>${ctphieunhapList.soluong}</td>
						<td>${ctphieunhapList.dongia}</td>
					</tr>                     
					</c:forEach>							
				</table>
				
        	</div> 
			<div class="thanhtien">
				Thành tiền: ${thanhtien} VNĐ
			</div>
			<div class="luu">
			<ul style="padding-left: 0%; margin-top: 10px;">
				
				<li style="float: left; line-height:38px;margin-left: 50px; background-color: rgb(8, 101, 59);padding:0px 70px 0px 70px ;">
				<a href="Danh-sach-phieu-nhap" >Quay lai</a>
				 </li>
				</ul> 
			</div>	 
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