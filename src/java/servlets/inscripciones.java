package servlets;

import clienteRest.DeporteRest;
import clienteRest.RestEstudiante;
import clienteRest.RestIncripciones;
import entities.Deporte;
import entities.Estudiante;
import entities.Inscripcion;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class inscripciones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("action").equals("cargaTabla"))
        {
              DeporteRest elresdep=new DeporteRest();
              List<Deporte> respu=elresdep.findAll_JSON();
              SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy");
              String cadenaDatosOp="<option selected disabled>Selecciona deporte</option>";
              String cadenaDatos="";
              elresdep.close();
              if(respu!=null){
                if(respu.size()>0)
                {
                  for(int i=0;i<respu.size();i++)
                  {
                      int posicion=(i+1);
                      String ini=format.format(respu.get(i).getFechaIni());
                      String term=format.format(respu.get(i).getFechaFin());
                      cadenaDatosOp=cadenaDatosOp+"<option value=\""+respu.get(i).getIdDeporte()+"\"> "+respu.get(i).getNombre()+"</td>";

                  
                  }

               
                }
            
              }
              RestIncripciones restInsc=new RestIncripciones();
              List<Inscripcion>LasInscripciones=restInsc.findAll_JSON();
              if(LasInscripciones!=null)
              {
                  if(LasInscripciones.size()>0)
                  {
                      for(int a=0;a<LasInscripciones.size();a++){
                            
                            cadenaDatos=cadenaDatos+"<tr>";
                            cadenaDatos=cadenaDatos+"<td id=\"nom_"+(a+1)+"\">"+LasInscripciones.get(a).getIdEstudiante().getNombre()+" "+LasInscripciones.get(a).getIdEstudiante().getApellidos()+"</td>";
                            cadenaDatos=cadenaDatos+"<td>"+LasInscripciones.get(a).getIdDeporte().getNombre()+"</td>";
                            cadenaDatos=cadenaDatos+"<td id=\"clasesAsistidas_"+(a+1)+"\">"+LasInscripciones.get(a).getClasesAsistidas()+"</td>";
                            cadenaDatos=cadenaDatos+"<td><input type=\"hidden\" id=\"idInscrip_"+(a+1)+"\" value=\""+LasInscripciones.get(a).getIdInscripcion()+"\">";
                            cadenaDatos=cadenaDatos+"<input type=\"hidden\" id=\"idEstudiante_"+(a+1)+"\" value=\""+LasInscripciones.get(a).getIdEstudiante().getIdEstudiante()+"\">";
                            cadenaDatos=cadenaDatos+"<input type=\"hidden\" id=\"iddeporte_"+(a+1)+"\" value=\""+LasInscripciones.get(a).getIdDeporte().getIdDeporte()+"\">";
                            cadenaDatos=cadenaDatos+"<button type=\"button\" class=\"btn btn-warning\" onclick=\"editar("+(a+1)+");\"><i class=\"fa fa-pencil\"></i></button>";
                            cadenaDatos=cadenaDatos+"<button type=\"button\" class=\"btn btn-danger\" onclick=\"eliminar("+(a+1)+");\"><i class=\"fa fa-trash-o\"></i></button></td>";
                            cadenaDatos=cadenaDatos+"</tr>";
                            
                      }
                  }
              }
              restInsc.close();
            response.getWriter().write("//OK//"+cadenaDatos+"//"+cadenaDatosOp+"//");
        }
        else if(request.getParameter("action").equals("cargaTablaAlumnos"))
        {
                  String cadenaDatos="";
                  RestEstudiante restEst=new RestEstudiante();
                  List<Estudiante>estudiantes=restEst.findAll_JSON();
                  if(estudiantes!=null)
                  {
                      if(estudiantes.size()>0)
                      {
                            for(int i=0;i<estudiantes.size();i++)
                            {
                                cadenaDatos=cadenaDatos+"<tr>";
                                cadenaDatos=cadenaDatos+"<td id=\"nomEst_"+(i+1)+"\">"+estudiantes.get(i).getNombre()+"</td>";
                                cadenaDatos=cadenaDatos+"<td id=\"apEst_"+(i+1)+"\">"+estudiantes.get(i).getApellidos()+"</td>";
                                cadenaDatos=cadenaDatos+"<td id=\"rutEst_"+(i+1)+"\">"+estudiantes.get(i).getRut()+"-"+estudiantes.get(i).getDigVer()+"</td>";
                                cadenaDatos=cadenaDatos+"<td><input type=\"radio\" name=\"estudents\" value=\""+(i+1)+"\"><input type=\"hidden\" id=\"idEstu_"+(i+1)+"\" value=\""+estudiantes.get(i).getIdEstudiante()+"\" ></td>";
                                cadenaDatos=cadenaDatos+"</tr>";
                                
                            }
                      }
                  }
                  restEst.close();
                  response.getWriter().write("//OK//"+cadenaDatos+"//");
        
        }
        
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("action").equals("eliminar"))
        {
            RestIncripciones elRest=new RestIncripciones(); 
            String idInscrip=request.getParameter("ElidInscripcion");
            elRest.remove(idInscrip);
            elRest.close();
            response.getWriter().write("//OK//Se ha eliminado registro//");
            
            
        }
        else if(request.getParameter("action").equals("guardar"))
        {
        
        
            SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy");
            if(request.getParameter("idinscripcion").isEmpty())
            {
                Inscripcion inscripcion=new Inscripcion();
                RestEstudiante restestu=new RestEstudiante();
                DeporteRest deporteRest=new DeporteRest();
                RestIncripciones restinscrip=new RestIncripciones();
                
                Estudiante elEst=restestu.find_JSON(Estudiante.class,request.getParameter("idestudiante"));
                restestu.close();
                Deporte elDep=deporteRest.find_JSON(Deporte.class,request.getParameter("iddeporte"));
                deporteRest.close();
                
                inscripcion.setIdEstudiante(elEst);
                inscripcion.setIdDeporte(elDep);
                inscripcion.setClasesAsistidas(Integer.parseInt(request.getParameter("clasesAsistidas")));
                restinscrip.create_JSON(inscripcion);
                restinscrip.close();
            }
            else
            {
                Inscripcion inscripcion=new Inscripcion();
                RestEstudiante restestu=new RestEstudiante();
                DeporteRest deporteRest=new DeporteRest();
                RestIncripciones restinscrip=new RestIncripciones();
                Estudiante elEst=restestu.find_JSON(Estudiante.class,request.getParameter("idestudiante"));
                restestu.close();
                Deporte elDep=deporteRest.find_JSON(Deporte.class,request.getParameter("iddeporte"));
                deporteRest.close();
                inscripcion.setIdInscripcion(Integer.parseInt(request.getParameter("idinscripcion")));
                inscripcion.setIdEstudiante(elEst);
                inscripcion.setIdDeporte(elDep);
                inscripcion.setClasesAsistidas(Integer.parseInt(request.getParameter("clasesAsistidas")));
                restinscrip.edit_JSON(inscripcion,request.getParameter("idinscripcion"));
                restinscrip.close();
                
            }
            request.getRequestDispatcher("inscripciones.jsp").forward(request, response);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
