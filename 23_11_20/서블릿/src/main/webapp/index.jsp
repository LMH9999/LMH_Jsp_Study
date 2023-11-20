<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="form-group row pull-right">
            <div class="col-xs-8">
                <input class="form-control" type="text" size="20">
            </div>
            <div class="col-xs-2">
                <button class="btn btn-primary" type="button">검색</button>
            </div>
        </div>
    </div>
    <table class="table" style="text-align: center; border: 1px solid #dddddd" >
        <thead>
            <tr>
                <th style="background-color: yellow; text-align: center;">chk</th>
                <th style="background-color: blue; color: #dddddd; text-align: center;">ID</th>
                <th style="background-color: greenyellow; text-align: center;">메뉴명</th>
                <th style="background-color: coral; text-align: center;">종류</th>
                <th style="background-color: coral; text-align: center;">가격</th>
                <th style="background-color: coral; text-align: center;">등록일</th>
            </tr>

        </thead>
        <tbody>
            <tr>
                <td>이무현</td>
                <td>32</td>
                <td>남자</td>
                <td>lmh9999@test.com</td>
            </tr>

        </tbody>
    </table>
</body>
</html>