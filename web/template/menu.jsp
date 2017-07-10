<aside id="left-panel">

			<!-- User info -->
			<div class="login-info">
				<span> <!-- User image size is adjusted inside CSS, it should stay as it --> 
					
					<a href="javascript:void(0);" id="show-shortcut" data-action="toggleShortcut">
						<img src="img/avatars/sunny.png" alt="me" class="online"> 
						<span>
							john.doe 
						</span>
						<i class="fa fa-angle-down"></i>
					</a> 
					
				</span>
			</div>
			<!-- end user info -->

			<!-- NAVIGATION : This navigation is also responsive

			To make this navigation dynamic please make sure to link the node
			(the reference to the nav > ul) after page load. Or the navigation
			will not initialize.
			-->
			<nav>
				<!-- NOTE: Notice the gaps after each icon usage <i></i>..
				Please note that these links work a bit different than
				traditional href="" links. See documentation for details.
				-->

				<ul>
					<li>
						<a href="index.jsp" title="Dashboard"><i class="fa fa-lg fa-fw fa-users"></i> <span class="menu-item-parent">Estudiantes</span></a>
					</li>
					<li>
						<a href="deportes.jsp"><i class="fa fa-lg fa-fw fa-empire"></i> <span class="menu-item-parent">Deportes</span></a>
					</li>
					<li>
						<a href="inscripciones.jsp"><i class="fa fa-lg fa-fw fa-bar-chart-o"></i> <span class="menu-item-parent">Inscripciones</span></a>
					
					</li>
				
				</ul>
			</nav>
			<span class="minifyme" data-action="minifyMenu"> 
				<i class="fa fa-arrow-circle-left hit"></i> 
			</span>

		</aside>


