<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: tnguyen
  Date: 10/26/2024
  Time: 3:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../static/add.css">
</head>
<body>
    <div class="header"> </div>
    <div class="main">
        <div class="left"></div>

        <div class="mid">
            <div class="midtop">
<%--                <div class="addbutton">--%>
<%--                    <a href="http://localhost:8080/add">--%>
<%--                        <button type="button" class="btn btn-outline-success">Thêm mới</button>--%>
<%--                    </a>--%>

<%--                </div>--%>

            </div>

            <div class="midmid">
                <form action="http://localhost:8080/add" method="post">
                    <div class="mb-3">
                        <label class="form-label">Tên người thuê</label>
                        <input type="text" class="form-control" name="name" id="formGroupExampleInput" placeholder="Nhập tên" maxlength="50" minlength="5" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Số điện thoại</label>
                        <input type="text" class="form-control" name="tel" id="formGroupExampleInput2" placeholder="Nhập số điện thoại" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Ngày bắt đầu</label>
                        <input type="date" class="form-control" name="startdate" id="formGroupExampleInput2" placeholder="" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" >Hình thức thanh toán</label>
                        <select id="inputState" name="paytype" class="form-select" required>
                            <option selected value="Month">Theo tháng</option>
                            <option value="Quarter">Theo quý</option>
                            <option value="Year">Theo năm </option>

                        </select>
                    </div>
                    <div class="mb-3">Ghi chú</label>
                        <textarea class="form-control" aria-label="With textarea" maxlength="200"></textarea>
                    </div>

                    <div class="mb3">
                        <button  type="submit" class="btn btn-success">Thêm</button>
                    </div>

                </form>



            </div>

            <div class="midbot"></div>




        </div>
        <div class="right"></div> 
    </div>

</body>
</html>
