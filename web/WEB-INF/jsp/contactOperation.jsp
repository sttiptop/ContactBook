<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yevgeni
  Date: 28.01.2016
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>$Title$</title>
    <link href="<%= request.getContextPath()%>/public/css/default.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="<%= request.getContextPath()%>/public/css/blue.css" rel="stylesheet" type="text/css" media="screen"/>
    <!-- color skin: blue / red / green / dark -->
    <link href="<%= request.getContextPath()%>/public/css/datePicker.css" rel="stylesheet" type="text/css"
          media="screen"/>
    <link href="<%= request.getContextPath()%>/public/css/wysiwyg.css" rel="stylesheet" type="text/css" media="screen"/>
    <link href="<%= request.getContextPath()%>/public/css/fancybox-1.3.1.css" rel="stylesheet" type="text/css"
          media="screen"/>
    <link href="<%= request.getContextPath()%>/public/css/visualize.css" rel="stylesheet" type="text/css"
          media="screen"/>

    <script type="text/javascript" src="<%= request.getContextPath()%>/public/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath()%>/public/js/jquery.dimensions.min.js"></script>

    <!-- // Tabs // -->
    <script type="text/javascript" src="<%= request.getContextPath()%>/public/js/ui.core.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath()%>/public/js/jquery.ui.tabs.min.js"></script>

    <!-- // Table drag and drop rows // -->
    <script type="text/javascript" src="<%= request.getContextPath()%>/public/js/tablednd.js"></script>

    <!-- // Date Picker // -->
    <script type="text/javascript" src="<%= request.getContextPath()%>/ublic/js/date.js"></script>
    <!--[if IE]>
    <script type="text/javascript" src="public/js/jquery.bgiframe.js"></script><![endif]-->
    <script type="text/javascript" src="<%= request.getContextPath()%>/public/js/jquery.datePicker.js"></script>

    <!-- // Wysiwyg // -->
    <script type="text/javascript" src="<%= request.getContextPath()%>/public/js/jquery.wysiwyg.js"></script>

    <!-- // Graphs // -->
    <script type="text/javascript" src="<%= request.getContextPath()%>/public/js/excanvas.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath()%>/public/js/jquery.visualize.js"></script>

    <!-- // Fancybox // -->
    <script type="text/javascript" src="<%= request.getContextPath()%>/public/js/jquery.fancybox-1.3.1.js"></script>

    <!-- // File upload // -->
    <script type="text/javascript" src="<%= request.getContextPath()%>/public/js/jquery.filestyle.js"></script>

    <script type="text/javascript" src="<%= request.getContextPath()%>/public/js/init.js"></script>
</head>
<body>
<div id="main">
    <!-- #header -->
    <div id="header">
        <!-- #logo -->
        <div id="logo">
            <a href="#" title="Go to Homepage"><span>ContactBook</span></a>
        </div>
    </div>
    <div id="content">
        <div class="breadcrumbs">
            <ul>
                <li class="home"><a href="#">Назад</a></li>
            </ul>
        </div>
        <c:if test="${!empty contactEdit}">
            <div class="box">
                <div class="headlines">
                    <h2><span>Edit Contact</span></h2>
                </div>

                <form class="formBox" action="saveChanges${contactEdit.contactId}" method="POST">
                    <fieldset>
                        <div class="col1">
                            <div class="clearfix">
                                <div class="lab"><label>Surname</label></div>
                                <div class="con"><input type="text" name="surname" class="input"
                                                        value="${contactEdit.surname}">
                                </div>
                            </div>
                            <div class="clearfix">
                                <div class="lab"><label>FirstName</label></div>
                                <div class="con"><input type="text" name="firstname" class="input"
                                                        value="${contactEdit.firstname}">
                                </div>
                            </div>
                            <div class="clearfix">
                                <div class="lab"><label>SecondName</label></div>
                                <div class="con"><input type="text" name="secondname" class="input"
                                                        value="${contactEdit.secondname}">
                                </div>
                            </div>
                            <div class="clearfix">
                                <div class="lab"><label>Birthday</label></div>
                                <div class="con"><input type="date" name="birthday" class="input"
                                                        value="${contactEdit.birthday}">
                                </div>
                            </div>
                            <div class="clearfix">
                                <div class="lab"><label>Address</label></div>
                                <div class="con"><input type="text" name="address" class="input"
                                                        value="${contactEdit.address}">
                                </div>
                            </div>
                            <div class="clearfix">
                                <div class="lab"><label>Phones</label></div>
                                <div class="con">
                                    <table class="tab tab-drag">
                                        <c:forEach items="${setPhones}" var="phone">
                                            <tr>
                                                <td><input id="kind" class="input" type="text" value="${phone.kind}"
                                                           disabled>
                                                </td>
                                                <td><label for="kind"><input class="input" name="${phone.kind}"
                                                                             type="text"
                                                                             value="${phone.phone}"></label>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                            <div class="clearfix">
                                <div class="lab"><label>Emails</label></div>
                                <div class="con">
                                    <table class="tab tab-drag">

                                        <c:forEach items="${setEmails}" var="Email">
                                            <tr>
                                                <td><label><input type="text" class="input" value="${Email.kind}"
                                                                  disabled></label></td>
                                                <td><input type="text" class="input" name="${Email.kind}"
                                                           value="${Email.email}">
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                            <input type="submit" value="saveEdit"><br><br>
                        </div>
                    </fieldset>
                </form>
            </div>
        </c:if>


        <c:if test="${empty contactEdit}">
            <div class="box">
                <div class="headlines">
                    <h2><span>New Contact</span></h2>
                </div>
                <div class="box-content">
                    <form class="formBox" action="contactOperation/addContact" method="POST">
                        <fieldset>
                            <div class="col1">
                                <div class="clearfix">
                                    <div class="lab"><label>Surname</label></div>
                                    <div class="con"><input type="text" class="input" name="surname"></div>
                                </div>
                                <div class="clearfix">
                                    <div class="lab"><label>secondName</label></div>
                                    <div class="con"><input type="text" class="input" name="secondname"></div>
                                </div>
                                <div class="clearfix">
                                    <div class="lab"><label>Birthday</label></div>
                                    <div class="con"><input type="date" class="input" name="birthday"></div>
                                </div>
                                <div class="clearfix">
                                    <div class="lab"><label>Address</label></div>
                                    <div class="con"><input type="text" class="input" name="address"></div>
                                </div>
                                <div class="clearfix">
                                    <div class="lab"><label>Phones</label></div>
                                    <div class="con">
                                        <table class="tab tab-drag">
                                            <tr class="top nodrop nodrag">
                                                <th>Type Phone</th>
                                                <th>Phone</th>
                                            </tr>
                                            <tr>
                                                <td><input type="text" class="input" value="Mobile" name="mobile"
                                                           disabled></td>
                                                <td><input type="text" class="input" name="mobilePhone"></td>
                                            </tr>
                                            <tr>
                                                <td><input type="text" class="input" value="Home" name="home" disabled>
                                                </td>
                                                <td><input type="text" class="input" name="homePhone"></td>
                                            </tr>
                                            <tr>
                                                <td><input type="text" class="input" value="Work" name="work" disabled>
                                                </td>
                                                <td><input type="text" class="input" name="workPhone"></td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                                <div class="clearfix">
                                    <div class="lab"><label>Emails</label></div>
                                    <div class="con">
                                        <table class="tab tab-drag">
                                            <tr class="top nodrop nodrag">
                                                <th>Type Email</th>
                                                <th>Email</th>
                                            </tr>
                                            <tr>
                                                <td><input type="text" class="input" value="Home" name="homeE" disabled>
                                                </td>
                                                <td><input type="text" class="input" name="homeEmail"></td>
                                            </tr>
                                            <tr>
                                                <td><input type="text" class="input" value="Work" name="workE" disabled>
                                                </td>
                                                <td><input type="text" class="input" name="workEmail"></td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                                <input type="submit" name="addContact">br><br>
                            </div>

                        </fieldset>
                    </form>
                </div>
            </div>
        </c:if>


    </div>
</div>
</body>
</html>
