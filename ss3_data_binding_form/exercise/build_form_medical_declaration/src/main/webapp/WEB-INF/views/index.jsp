<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 style="text-align: center">TỜ KHAI Y TẾ</h3>
    <h4 style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI
        CẦN THIẾT ĐỂ PHÒNG CHỐNG
        DỊCH BỆNH TRUYỀN NHIỄM</h4>
    <p style="color: red;text-align: center">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể
        xử lý hình sự</p>

    <form:form modelAttribute="medicalDeclaration" action="/medical" method="post">
        <div>
            <label>Họ Tên(Ghi chữ in hoa)</label>
            <em style="color: red">(*)</em>
            <br>
            <form:input cssClass="form-control" path="name" type="text"/>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-12">
                <div class="from-group">
                    <label>Năm sinh</label>
                    <em style="color: red">(*)</em>
                    <form:select path="dayOfBirth">
                        <form:options items="${listDayOfBirth}"></form:options>
                    </form:select>
                </div>

            </div>

            <div class="col-md-4 col-sm-4 col-xs-12">
                <div class="from-group">
                    <label>Giới tính</label>
                    <em style="color: red">(*)</em>
                    <form:select path="gender">
                        <form:options items="${listGender}"></form:options>
                    </form:select>
                </div>

            </div>

            <div class="col-md-4 col-sm-4 col-xs-12">
                <div class="from-group">
                    <label>Giới tính</label>
                    <em style="color: red">(*)</em>
                    <form:select path="nationality">
                        <form:options items="${listNationality}"></form:options>
                    </form:select>
                </div>

            </div>
        </div>


        <div>
            <label>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp</label>
            <em style="color: red">(*)</em>
            <br>
            <form:input cssClass="form-control" path="idCard" type="text"/>
        </div>

        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-12">
                <label>Thông tin đi lại</label>
                <em style="color: red">(*)</em>
                <br>
                <span><form:radiobutton path="travelInformation" value="Tàu bay"/> Tàu bay</span>
                <span><form:radiobutton path="travelInformation" value="Tàu thuyền"/> Tàu thuyền</span>
                <span><form:radiobutton path="travelInformation" value="Ô tô"/>Ô tô</span>
                <span><form:radiobutton path="travelInformation" value="Khác"/>Khác </span>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-12">
                <div class="from-group">
                    <label>Số phương tiện</label>
                    <em style="color: red">(*)</em>
                    <br>
                    <form:input path="vehicleNumber" type="text"/>
                </div>
            </div>

            <div class="col-md-4 col-sm-4 col-xs-12">
                <div class="from-group">
                    <label>Số ghế</label>
                    <em style="color: red">(*)</em>
                    <br>
                    <form:input path="seats" type="text"/>
                </div>
            </div>
        </div>

        <div>
            <label>Ngày khởi hành</label>
            <em style="color: red">(*)</em>
            <form:select path="startDay">
                <form:options items="${startDay}"></form:options>
            </form:select>

            <form:select path="startMonth">
                <form:options items="${startMonth}"></form:options>
            </form:select>

            <form:select path="startYear">
                <form:options items="${startYear}"></form:options>
            </form:select>
        </div>
        <div>
            <label>Ngày kết thúc</label>
            <em style="color: red">(*)</em>
            <form:select path="endDay">
                <form:options items="${endDay}"></form:options>
            </form:select>

            <form:select path="endMonth">
                <form:options items="${endMonth}"></form:options>
            </form:select>

            <form:select path="endYear">
                <form:options items="${endYear}"></form:options>
            </form:select>
        </div>
        <div>
            <label>Trong vòng 14 ngày qua ,Anh/Chị có đến tỉnh/thành phố nào?</label>
            <em style="color: red">(*)</em>
            <form:input path="status" type="text"/>
        </div>

        <input type="submit" value="Gửi Tờ Khai">

    </form:form>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>
