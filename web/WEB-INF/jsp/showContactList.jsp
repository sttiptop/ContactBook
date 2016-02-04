<%--
  Created by IntelliJ IDEA.
  User: Yevgeni
  Date: 28.01.2016
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <link href="public/css/default.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="public/css/blue.css" rel="stylesheet" type="text/css" media="screen"/>
    <!-- color skin: blue / red / green / dark -->
    <link href="public/css/datePicker.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="public/css/wysiwyg.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="public/css/fancybox-1.3.1.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="public/css/visualize.css" rel="stylesheet" type="text/css" media="screen"/>

    <script type="text/javascript" src="public/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="public/js/jquery.dimensions.min.js"></script>

    <!-- // Tabs // -->
    <script type="text/javascript" src="public/js/ui.core.js"></script>
    <script type="text/javascript" src="public/js/jquery.ui.tabs.min.js"></script>

    <!-- // Table drag and drop rows // -->
    <script type="text/javascript" src="public/js/tablednd.js"></script>

    <!-- // Date Picker // -->
    <script type="text/javascript" src="ublic/js/date.js"></script>
    <!--[if IE]>
    <script type="text/javascript" src="public/js/jquery.bgiframe.js"></script><![endif]-->
    <script type="text/javascript" src="public/js/jquery.datePicker.js"></script>

    <!-- // Wysiwyg // -->
    <script type="text/javascript" src="public/js/jquery.wysiwyg.js"></script>

    <!-- // Graphs // -->
    <script type="text/javascript" src="public/js/excanvas.js"></script>
    <script type="text/javascript" src="public/js/jquery.visualize.js"></script>

    <!-- // Fancybox // -->
    <script type="text/javascript" src="public/js/jquery.fancybox-1.3.1.js"></script>

    <!-- // File upload // -->
    <script type="text/javascript" src="public/js/jquery.filestyle.js"></script>

    <script type="text/javascript" src="public/js/init.js"></script>
</head>
<body>
<div id="main">
    <!-- #header -->
    <div id="header">
        <!-- #logo -->
        <div id="logo">
            <a href="/" title="Go to Homepage"><span>Contact Book</span></a>
        </div>
    </div>
    <div id="content">
        <div class="breadcrumbs">
            <ul>
                <li class="home"><a href="index">Назад</a></li>
            </ul>
        </div>
        <div class="box">
            <div class="headlines">
                <h2><span>Contact List</span></h2>

            </div>

            <table class="tab tab-drag">
                <tr class="top nodrop nodrag">
                    <th>option</th>
                    <th>Surname</th>
                    <th>FirstName</th>
                    <th>SecondName</th>
                    <th>Address</th>
                    <th>Birthday</th>
                </tr>
                <c:forEach items="${conList}" var="contact">
                    <tr>
                        <td><form action="showContactList/${contact.contactId}"><input type="submit" value="more"/></form></td>
                        <td>${contact.surname}</td>
                        <td>${contact.firstname}</td>
                        <td>${contact.secondname}</td>
                        <td>${contact.address}</td>
                        <td>${contact.birthday}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
