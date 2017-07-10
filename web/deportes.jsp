<%-- 
    Document   : index
    Created on : 05-jul-2017, 1:55:01
    Author     : Gamalyon
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="clienteRest.RestEstudiante"%>
<%@page import="entities.Estudiante"%>
<%@page import="java.util.List"%>
<jsp:include page="template/header.jsp" />
<jsp:include page="template/menu.jsp" />
<div id="main" role="main">
    
<div id="content">
    <div class="row">
    
    
				
						<!-- NEW COL START -->
						<article class="col-sm-12 col-md-12 col-lg-12 sortable-grid ui-sortable">
				
							<!-- Widget ID (each widget will need unique ID)-->
							<div class="jarviswidget jarviswidget-sortable" id="wid-id-0" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false" data-widget-togglebutton="false" data-widget-deletebutton="false" role="widget">
								<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">
				
								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"
				
								-->
								<header role="heading"><div class="jarviswidget-ctrls" role="menu"></div>
									<span class="widget-icon">  </span>
									<h2>Mantenedor </h2>
				
								<span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>
				
								<!-- widget div-->
								<div role="content">
				
									<!-- widget edit box -->
									<div class="jarviswidget-editbox">
										<!-- This area used as dropdown edit box -->
				
									</div>
									<!-- end widget edit box -->
				
									<!-- widget content -->
									<div class="widget-body no-padding">
				
										<form class="smart-form" action="deportes?action=guardar" method="post">
											<header>
												Deportes
											</header>
				
											<fieldset>
												<div class="row">
													<section class="col col-2">
                                                                                                            <label class="label">
                                                                                                                Nombre
                                                                                                            </label>	
                                                                                                            <label class="input">
															<input type="text" id="nombre" name="nombre" placeholder="nombre"required>
                                                                                                                        <input type="hidden" id="iddeporte" name="iddeporte" value="">
													   </label>
													</section>
													<section class="col col-2">
														<label class="label">
                                                                                                                 Fecha inicio
                                                                                                                </label>	
                                                                                                                <label class="input">
															
                                                                                                                    <input type="text" class="datepicker" id="inicio" name="inicio" placeholder="dd/mm/yy" required>
                                                                                                                        
														</label>
													</section>
													<section class="col col-2">
													      <label class="label">
                                                                                                                 Fecha termino  
                                                                                                               </label>	
                                                                                                               <label class="input">
															<input type="text" class="datepicker" id="termino" name="termino" placeholder=""required>
														</label>
													</section>
													<section class="col col-2">
														<label class="label">
                                                                                                                     Cupos
                                                                                                                </label>	
                                                                                                                <label class="input">
                                                                                                                    <input type="text" id="cupos"  name="cupos"placeholder="" required>
														</label>
													</section>
                                                                                                        <section class="col col-2">
														<label class="label">
                                                                                                                     Cantidad de clases
                                                                                                                </label>	
                                                                                                                <label class="input">
															<input type="text" id="clases"  name="clases"placeholder="" required>
														</label>
													</section>
													
												</div>
				                                                        </fieldset>
				
											<footer>
												<button type="submit" id="guardar" class="btn btn-primary">
								                                        Guardar   					
												</button>
                                                                                                <button type="button" id="cancelar"class="btn btn-default" style="display:none" onclick="cancelarEdicion();">
								                                        Cancelar   					
												</button>
								
											</footer>
										</form>
				
									</div>
									<!-- end widget content -->
				
								</div>
								<!-- end widget div -->
				
							</div>
							<!-- end widget -->
				
						</article>
						<!-- END COL -->
                                               
                                                <article class="col-xs-12 col-sm-12 col-md-12 col-lg-12 sortable-grid ui-sortable">

							<!-- Widget ID (each widget will need unique ID)-->
							
							<!-- end widget -->

							<!-- Widget ID (each widget will need unique ID)-->
							
							<!-- end widget -->

						<div class="jarviswidget jarviswidget-color-blueDark jarviswidget-sortable" id="wid-id-0" data-widget-editbutton="false" role="widget" style="">
								<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"

								-->
								<header role="heading"><div class="jarviswidget-ctrls" role="menu">   <a href="#" class="button-icon jarviswidget-toggle-btn" rel="tooltip" title="" data-placement="bottom" data-original-title="Collapse"><i class="fa fa-minus "></i></a> <a href="javascript:void(0);" class="button-icon jarviswidget-fullscreen-btn" rel="tooltip" title="" data-placement="bottom" data-original-title="Fullscreen"><i class="fa fa-expand "></i></a> <a href="javascript:void(0);" class="button-icon jarviswidget-delete-btn" rel="tooltip" title="" data-placement="bottom" data-original-title="Delete"><i class="fa fa-times"></i></a></div><div class="widget-toolbar" role="menu"><a data-toggle="dropdown" class="dropdown-toggle color-box selector" href="javascript:void(0);"></a><ul class="dropdown-menu arrow-box-up-right color-select pull-right"><li><span class="bg-color-green" data-widget-setstyle="jarviswidget-color-green" rel="tooltip" data-placement="left" data-original-title="Green Grass"></span></li><li><span class="bg-color-greenDark" data-widget-setstyle="jarviswidget-color-greenDark" rel="tooltip" data-placement="top" data-original-title="Dark Green"></span></li><li><span class="bg-color-greenLight" data-widget-setstyle="jarviswidget-color-greenLight" rel="tooltip" data-placement="top" data-original-title="Light Green"></span></li><li><span class="bg-color-purple" data-widget-setstyle="jarviswidget-color-purple" rel="tooltip" data-placement="top" data-original-title="Purple"></span></li><li><span class="bg-color-magenta" data-widget-setstyle="jarviswidget-color-magenta" rel="tooltip" data-placement="top" data-original-title="Magenta"></span></li><li><span class="bg-color-pink" data-widget-setstyle="jarviswidget-color-pink" rel="tooltip" data-placement="right" data-original-title="Pink"></span></li><li><span class="bg-color-pinkDark" data-widget-setstyle="jarviswidget-color-pinkDark" rel="tooltip" data-placement="left" data-original-title="Fade Pink"></span></li><li><span class="bg-color-blueLight" data-widget-setstyle="jarviswidget-color-blueLight" rel="tooltip" data-placement="top" data-original-title="Light Blue"></span></li><li><span class="bg-color-teal" data-widget-setstyle="jarviswidget-color-teal" rel="tooltip" data-placement="top" data-original-title="Teal"></span></li><li><span class="bg-color-blue" data-widget-setstyle="jarviswidget-color-blue" rel="tooltip" data-placement="top" data-original-title="Ocean Blue"></span></li><li><span class="bg-color-blueDark" data-widget-setstyle="jarviswidget-color-blueDark" rel="tooltip" data-placement="top" data-original-title="Night Sky"></span></li><li><span class="bg-color-darken" data-widget-setstyle="jarviswidget-color-darken" rel="tooltip" data-placement="right" data-original-title="Night"></span></li><li><span class="bg-color-yellow" data-widget-setstyle="jarviswidget-color-yellow" rel="tooltip" data-placement="left" data-original-title="Day Light"></span></li><li><span class="bg-color-orange" data-widget-setstyle="jarviswidget-color-orange" rel="tooltip" data-placement="bottom" data-original-title="Orange"></span></li><li><span class="bg-color-orangeDark" data-widget-setstyle="jarviswidget-color-orangeDark" rel="tooltip" data-placement="bottom" data-original-title="Dark Orange"></span></li><li><span class="bg-color-red" data-widget-setstyle="jarviswidget-color-red" rel="tooltip" data-placement="bottom" data-original-title="Red Rose"></span></li><li><span class="bg-color-redLight" data-widget-setstyle="jarviswidget-color-redLight" rel="tooltip" data-placement="bottom" data-original-title="Light Red"></span></li><li><span class="bg-color-white" data-widget-setstyle="jarviswidget-color-white" rel="tooltip" data-placement="right" data-original-title="Purity"></span></li><li><a href="javascript:void(0);" class="jarviswidget-remove-colors" data-widget-setstyle="" rel="tooltip" data-placement="bottom" data-original-title="Reset widget color to default">Remove</a></li></ul></div>
									<span class="widget-icon"> <i class="fa fa-table"></i> </span>
									<h2>Lista de deportes</h2>

								<span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>

								<!-- widget div-->
								<div role="content">

									<!-- widget edit box -->
									<div class="jarviswidget-editbox">
										<!-- This area used as dropdown edit box -->

									</div>
									<!-- end widget edit box -->

									<!-- widget content -->
									<div class="widget-body">
										<div class="table-responsive">
                                                                                    <form action="controlador">
										        
											<table class="table table-bordered">
												<thead>
                                                                                                    <tr>
                                                                                                        <th>Nombre </th>
                                                                                                        <th>Fecha inicio </th>
                                                                                                        <th>Fecha término</th>
                                                                                                        <th>Cupos</th>
                                                                                                        <th>Cantidad de clases</th>
                                                                                                        <th>Acciones</th>
                                                                                                    </tr>
												</thead>
												<tbody id="laTabla">
                                                                                                
                                                                                                    
												</tbody>
											</table>
											</form>
										</div>
									</div>
									<!-- end widget content -->

								</div>
								<!-- end widget div -->

							</div>
                                                      </article>
    </div>
</div>
</div>
<jsp:include page="template/footer.jsp" />
 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/deportes.js" ></script> 
<jsp:include page="template/endBody.jsp" />    
