<%-- 
    Document   : footer
    Created on : 05-jul-2017, 21:56:01
    Author     : Gamalyon
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.time.Instant"%>
                       <div class="page-footer">
                                            <div class="row">
                                                    <div class="col-xs-12 col-sm-6">
                                                            <span class="txt-color-white">Mantenedor © 2013-2014</span>
                                                    </div>

                                                    <div class="col-xs-6 col-sm-6 text-right hidden-xs">
                                                            <div class="txt-color-white inline-block">
                                                                <%
                                                                    Date fecha=new Date(); 

                                                                   
                                                                %>
                                                                    <i class="txt-color-blueLight hidden-mobile">última conexion <i class="fa fa-clock-o"></i> <strong><%=fecha%></strong> </i>
                                                                    <div class="btn-group dropup">
                                                                            <button class="btn btn-xs dropdown-toggle bg-color-blue txt-color-white" data-toggle="dropdown">
                                                                                    <i class="fa fa-link"></i> <span class="caret"></span>
                                                                            </button>
                                                                            <ul class="dropdown-menu pull-right text-left">
                                                                                    <li>
                                                                                            <div class="padding-5">
                                                                                                    <p class="txt-color-darken font-sm no-margin">Download Progress</p>
                                                                                                    <div class="progress progress-micro no-margin">
                                                                                                            <div class="progress-bar progress-bar-success" style="width: 50%;"></div>
                                                                                                    </div>
                                                                                            </div>
                                                                                    </li>
                                                                                    <li class="divider"></li>
                                                                                    <li>
                                                                                            <div class="padding-5">
                                                                                                    <p class="txt-color-darken font-sm no-margin">Server Load</p>
                                                                                                    <div class="progress progress-micro no-margin">
                                                                                                            <div class="progress-bar progress-bar-success" style="width: 20%;"></div>
                                                                                                    </div>
                                                                                            </div>
                                                                                    </li>
                                                                                    <li class="divider"></li>
                                                                                    <li>
                                                                                            <div class="padding-5">
                                                                                                    <p class="txt-color-darken font-sm no-margin">Memory Load <span class="text-danger">*critical*</span></p>
                                                                                                    <div class="progress progress-micro no-margin">
                                                                                                            <div class="progress-bar progress-bar-danger" style="width: 70%;"></div>
                                                                                                    </div>
                                                                                            </div>
                                                                                    </li>
                                                                                    <li class="divider"></li>
                                                                                    <li>
                                                                                            <div class="padding-5">
                                                                                                    <button class="btn btn-block btn-default">refresh</button>
                                                                                            </div>
                                                                                    </li>
                                                                            </ul>
                                                                    </div>
                                                            </div>
                                                    </div>
                                            </div>
                                    </div>
                                    <!-- END PAGE FOOTER -->

                                    <!-- SHORTCUT AREA : With large tiles (activated via clicking user name tag)
                                    Note: These tiles are completely responsive,
                                    you can add as many as you like
                                    -->
                                    <div id="shortcut">
                                            <ul>
                                                    <li>
                                                            <a href="#inbox.html" class="jarvismetro-tile big-cubes bg-color-blue"> <span class="iconbox"> <i class="fa fa-envelope fa-4x"></i> <span>Mail <span class="label pull-right bg-color-darken">14</span></span> </span> </a>
                                                    </li>
                                                    <li>
                                                            <a href="#calendar.html" class="jarvismetro-tile big-cubes bg-color-orangeDark"> <span class="iconbox"> <i class="fa fa-calendar fa-4x"></i> <span>Calendar</span> </span> </a>
                                                    </li>
                                                    <li>
                                                            <a href="#gmap-xml.html" class="jarvismetro-tile big-cubes bg-color-purple"> <span class="iconbox"> <i class="fa fa-map-marker fa-4x"></i> <span>Maps</span> </span> </a>
                                                    </li>
                                                    <li>
                                                            <a href="#invoice.html" class="jarvismetro-tile big-cubes bg-color-blueDark"> <span class="iconbox"> <i class="fa fa-book fa-4x"></i> <span>Invoice <span class="label pull-right bg-color-darken">99</span></span> </span> </a>
                                                    </li>
                                                    <li>
                                                            <a href="#gallery.html" class="jarvismetro-tile big-cubes bg-color-greenLight"> <span class="iconbox"> <i class="fa fa-picture-o fa-4x"></i> <span>Gallery </span> </span> </a>
                                                    </li>
                                                    <li>
                                                            <a href="javascript:void(0);" class="jarvismetro-tile big-cubes selected bg-color-pinkDark"> <span class="iconbox"> <i class="fa fa-user fa-4x"></i> <span>My Profile </span> </span> </a>
                                                    </li>
                                            </ul>
                        	    </div>
		<!--================================================== -->

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
                <!--<script type="text/javascript" data-pace-options='{ "restartOnRequestAfter": true }' src="${pageContext.request.contextPath}/js/plugin/pace/pace.min.js"></script>-->

		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		<script >
			if (!window.jQuery) {
				document.write('<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/jquery-2.0.2.min.js"><\/script>');
			}
		</script>
                <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
		<script>
			if (!window.jQuery.ui) {
				document.write('<script type="text/javascript" src="${pageContext.request.contextPath}/js/libs/jquery-ui-1.10.3.min.js"><\/script>');
			}
		</script>
                
             <!-- JS TOUCH : include this plugin for mobile drag / drop touch events
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

		<!-- BOOTSTRAP JS -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>

		<!-- CUSTOM NOTIFICATION -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/notification/SmartNotification.min.js"></script>

		<!-- JARVIS WIDGETS -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/smartwidgets/jarvis.widget.min.js"></script>

		<!-- EASY PIE CHARTS -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

		<!-- SPARKLINES -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/sparkline/jquery.sparkline.min.js"></script>

		<!-- JQUERY VALIDATE -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery-validate/jquery.validate.min.js"></script>

		<!-- JQUERY MASKED INPUT -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

		<!-- JQUERY SELECT2 INPUT -->
		<script  type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/select2/select2.min.js"></script>

		<!-- JQUERY UI + Bootstrap Slider -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

		<!-- browser msie issue fix -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

		<!-- FastClick: For mobile devices -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/fastclick/fastclick.min.js"></script>

		<!--[if IE 8]>

		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

		<![endif]-->

	
		<!-- MAIN APP JS FILE -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/app.min.js"></script>
		
		<!-- PAGE RELATED PLUGIN(S) -->
		
		<!-- Flot Chart Plugin: Flot Engine, Flot Resizer, Flot Tooltip -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/flot/jquery.flot.cust.min.js"></script>-->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/flot/jquery.flot.resize.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/flot/jquery.flot.tooltip.min.js"></script>
		
		<!-- Vector Maps Plugin: Vectormap engine, Vectormap language -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/vectormap/jquery-jvectormap-1.2.2.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/vectormap/jquery-jvectormap-world-mill-en.js"></script>
		
		<!-- Full Calendar -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/fullcalendar/jquery.fullcalendar.min.js"></script>

		

		<!-- Your GOOGLE ANALYTICS CODE Below -->
		<script type="text/javascript">
			var _gaq = _gaq || [];
			_gaq.push(['_setAccount', 'UA-XXXXXXXX-X']);
			_gaq.push(['_trackPageview']);

			(function() {
				var ga = document.createElement('script');
				ga.type = 'text/javascript';
				ga.async = true;
				ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
				var s = document.getElementsByTagName('script')[0];
				s.parentNode.insertBefore(ga, s);
			})();

		</script>


