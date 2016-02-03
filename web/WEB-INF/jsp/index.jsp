<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yevgeni
  Date: 28.01.2016
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
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
            <a href="/" title="Go to Homepage"><span>ContactBook</span></a>
        </div>
    </div>
    <div id="content">
        <div class="box">
            <div class="headlines">
                <h2><span>Choose</span></h2>
            </div>
            <div class="box-content">
                <div class="form-cols">
                    <div class="col1">
                        <h3><a href="showContactList.form">showContactList</a></h3>

                    </div>
                    <div class="col2">
                        <h3><a href="chooseOption">contactOperation</a></h3>
                    </div>
                </div>
            </div>
        </div>

    </div>


</div>
</body>
</html>
