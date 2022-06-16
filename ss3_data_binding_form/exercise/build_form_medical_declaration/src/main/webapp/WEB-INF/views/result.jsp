<%--
  Created by IntelliJ IDEA.
  User: TechCare
  Date: 6/16/2022
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h2>TỜN KHAI Y TẾ</h2>
    <p>Họ Tên: ${medicalDeclaration.name}</p>

    <p>Năm Sinh: ${medicalDeclaration.dayOfBirth}</p>

    <p>Giới tính: ${medicalDeclaration.gender}</p>

    <p>Quốc tịch: ${medicalDeclaration.nationality}</p>

    <p>Số CMND: ${medicalDeclaration.idCard}</p>

    <p>Thông tin đi lại: ${medicalDeclaration.travelInformation}</p>

    <p>Số phương tiện: ${medicalDeclaration.vehicleNumber}</p>

    <p>Số ghế: ${medicalDeclaration.seats}</p>

    <p>Ngày bắt đầu: ${medicalDeclaration.startDay}/${medicalDeclaration.startMonth}/${medicalDeclaration.startYear}</p>

    <p>Ngày kết thúc: ${medicalDeclaration.endDay}/${medicalDeclaration.endMonth}/${medicalDeclaration.endYear}</p>

    <p>Trong vòng 14 ngày qua ,Anh/Chị có đến tỉnh/thành phố nào?: ${medicalDeclaration.status}</p>
</div>
</body>
</html>
