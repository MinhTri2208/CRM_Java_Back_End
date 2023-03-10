<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="<%=request.getContextPath()%>/LayoutCrm_admin/../plugins/images/favicon.png">
    <title>Pixel Admin</title>
    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath()%>/LayoutCrm_admin/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="<%=request.getContextPath()%>/LayoutCrm_admin/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <link rel="stylesheet" <%=request.getContextPath()%>/LayoutCrm_admin/https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <!-- animation CSS -->
    <link href="<%=request.getContextPath()%>/LayoutCrm_admin/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="<%=request.getContextPath()%>/LayoutCrm_admin/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="<%=request.getContextPath()%>/LayoutCrm_admin/css/colors/blue-dark.css" id="theme" rel="stylesheet">
    <link rel="stylesheet" <%=request.getContextPath()%>/LayoutCrm_admin/./css/custom.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
    <!-- Preloader -->
    <div class="preloader">
        <div class="cssload-speeding-wheel"></div>
    </div>
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
                <div class="navbar-header"> 
                    <a class="navbar-toggle hidden-sm hidden-md hidden-lg " <%=request.getContextPath()%>/LayoutCrm_admin/javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse">
                        <i class="fa fa-bars"></i>
                    </a>
                    <div class="top-left-part">
                        <a class="logo" href="<%=request.getContextPath()%>/admin">
                            <b>
                                <img src="<%=request.getContextPath()%>/LayoutCrm_admin/plugins/images/pixeladmin-logo.png" alt="home" />
                            </b>
                            <span class="hidden-xs">
                                <img src="<%=request.getContextPath()%>/LayoutCrm_admin/plugins/images/pixeladmin-text.png" alt="home" />
                            </span>
                        </a>
                    </div>
                    <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
                        <li>
                            <form role="search" class="app-search hidden-xs">
                                <input type="text" placeholder="Search..." class="form-control"> 
                                <a <%=request.getContextPath()%>/LayoutCrm_admin/">
                                    <i class="fa fa-search"></i>
                                </a>
                            </form>
                        </li>
                    </ul>
                    <ul class="nav navbar-top-links navbar-right pull-right">
                        <li>
                            <div class="dropdown">
                                <a class="profile-pic dropdown-toggle" data-toggle="dropdown" <%=request.getContextPath()%>/LayoutCrm_admin/#"> 
                                    <img src="<%=request.getContextPath()%>/LayoutCrm_admin/plugins/images/users/varun.jpg" alt="user-img" width="36" class="img-circle" />
                                    <b class="hidden-xs">Cybersoft</b> 
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a <%=request.getContextPath()%>/LayoutCrm_admin/profile.html">Th??ng tin c?? nh??n</a></li>
                                    <li><a <%=request.getContextPath()%>/LayoutCrm_admin/#">Th???ng k?? c??ng vi???c</a></li>
                                    <li class="divider"></li>
                                    <li><a <%=request.getContextPath()%>/LayoutCrm_admin/#">????ng xu???t</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-header -->
                <!-- /.navbar-top-links -->
                <!-- /.navbar-static-side -->
            </nav>
        <!-- Left navbar-header -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse slimscrollsidebar">
                <ul class="nav" id="side-menu">
                    <li style="padding: 10px 0 0;">
                        <a href="http://localhost:8080/CRM_project/admin" class="waves-effect"><i class="fa fa-clock-o fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Dashboard</span></a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/user_list" class="waves-effect"><i class="fa fa-user fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Th??nh Vi??n</span></a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/role_list" class="waves-effect"><i class="fa fa-modx fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Quy???n</span></a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/duan_list" class="waves-effect"><i class="fa fa-table fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">D??? ??n</span></a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/task_list" class="waves-effect"><i class="fa fa-table fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">C??ng Vi???c</span></a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>" class="waves-effect"><i class="fa fa-columns fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Blank Page</span></a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>" class="waves-effect"><i class="fa fa-info-circle fa-fw"
                                aria-hidden="true"></i><span class="hide-menu">Error 404</span></a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- Left navbar-header end -->
        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Danh s??ch c??ng vi???c</h4>
                    </div>
                    
                    <div class="col-lg-2 col-sm-8 col-md-8 col-xs-3 text-right">
                    	<i class="fa-thin fa-chart-simple"></i>
                        <a href="<%=request.getContextPath()%>/add_task_view" class="btn btn-sm btn-link">C??ng vi???c</a>
                    </div>
                    <div class="col-lg-2 col-sm-8 col-md-8 col-xs-3 text-right">
                        <a href="<%=request.getContextPath()%>/add_task_view" class="btn btn-sm btn-link">D??? ??n</a>
                    </div>
                    <div class="col-lg-2 col-sm-8 col-md-8 col-xs-3 text-right">
                        <a href="<%=request.getContextPath()%>/add_task_view" class="btn btn-sm btn-link">Ng?????i th???c hi???n</a>
                    </div>
                    <div class="col-lg-2 col-sm-8 col-md-8 col-xs-3 text-right">
                        <a href="<%=request.getContextPath()%>/add_task_view" class="btn btn-sm btn-link">Tr???ng th??i</a>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
                <!-- /row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <div class="table-responsive">
                                <table class="table" id="example">
                                    <thead>
                                        <tr>
                                            <th>STT</th>
                                            <th>T??n C??ng Vi???c</th>
                                            <th>D??? ??n</th>
                                            <th>Ng?????i Th???c Hi???n</th>
                                            <th>Ng??y B???t ?????u</th>
                                            <th>Ng??y K???t Th??c</th>
                                            <th>Tr???ng Th??i</th>
                                            <th>H??nh ?????ng</th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                        <c:forEach items="${listTasks}" var="task">
        									<tr>
                                            <td><c:out value = "${task.getId_task()}"/></td>
                                            <td><c:out value = "${task.getTenDuAn()}"/></td>
                                            <td><c:out value = "${task.getId_DuAn()}"/></td>
                                            <td><c:out value = "${task.getId_NV()}"/></td>
                                            <td><c:out value = "${task.getTenTrangThai()}"/></td>
                                            <td><c:out value = "${task.getNgayBatDau()}"/></td>
                                            <td><c:out value = "${task.getNgayKetThuc()}"/></td>
                                                                                       
                                            <td>
                                            
                                                <a href="<%=request.getContextPath()%>/view_task_update?id_task=${task.getId_task()}" class="btn btn-sm btn-primary">Update</a>
                                                <a href="<%=request.getContextPath()%>/task_delete?id_task=${task.getId_task()}" class="btn btn-sm btn-danger">Delete</a>
                                                <a href="<%=request.getContextPath()%>/view_task?id_task=${task.getId_task()}" class="btn btn-sm btn-info">View</a>
                                            </td>
                                        	</tr>
        								</c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
            <footer class="footer text-center"> 2018 &copy; myclass.com </footer>
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="<%=request.getContextPath()%>/LayoutCrm_admin/plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath()%>/LayoutCrm_admin/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath()%>/LayoutCrm_admin/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="<%=request.getContextPath()%>/LayoutCrm_admin/js/jquery.slimscroll.js"></script>
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <!--Wave Effects -->
    <script src="<%=request.getContextPath()%>/LayoutCrm_admin/js/waves.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath()%>/LayoutCrm_admin/js/custom.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#example').DataTable();
        });
    </script>
</body>

</html>