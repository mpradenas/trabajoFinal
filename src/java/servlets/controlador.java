
package servlets;

import clienteRest.DeporteRest;
import clienteRest.RestEstudiante;
import com.sun.javafx.Utils;

import entities.Deporte;
import entities.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class controlador extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            if(request.getParameter("action").equals("cargaTabla"))
            {
              RestEstudiante elresEst=new RestEstudiante();
              List<Estudiante> respu=elresEst.findAll_JSON();
              SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy");
             String cadenaDatos="";

             if(respu!=null){
             if(respu.size()>0)
             {
               for(int i=0;i<respu.size();i++)
               {
                   int posicion=(i+1);
                   String fecha=format.format(respu.get(i).getFechaNac());
                    /*out.println("<tr>");
                    out.print("<td id=\"nom_"+posicion+"\"> "+respu.get(i).getNombre()+"</td>");
                    out.print("<td id=\"aps_"+posicion+"\"> "+respu.get(i).getApellidos()+" </td>");
                    out.print("<td id=\"rut_"+posicion+"\">"+respu.get(i).getRut()+"-"+respu.get(i).getDigVer()+"</td>");
                    out.print("<td id=\"fechaNac_"+posicion+"\">"+fecha+"</td>");
                    out.print("<td><input type=\"hidden\" id=\"idEstudiante_"+posicion+"\" value=\""+respu.get(i).getIdEstudiante()+"\"><button type=\"button\" class=\"btn btn-warning\" onclick=\"editar("+posicion+");\"><i class=\"fa fa-pencil\"></i></button><button type=\"button\" class=\"btn btn-danger\" onclick=\"eliminar("+posicion+");\"><i class=\"fa fa-trash-o\"></i></button></td>");
                    out.println("</tr>");
                    */
                    cadenaDatos=cadenaDatos+"<tr>";
                    cadenaDatos=cadenaDatos+"<td id=\"nom_"+posicion+"\"> "+respu.get(i).getNombre()+"</td>";
                    cadenaDatos=cadenaDatos+"<td id=\"aps_"+posicion+"\"> "+respu.get(i).getApellidos()+" </td>";
                    cadenaDatos=cadenaDatos+"<td id=\"rut_"+posicion+"\">"+respu.get(i).getRut()+"-"+respu.get(i).getDigVer()+"</td>";
                    cadenaDatos=cadenaDatos+"<td id=\"fechaNac_"+posicion+"\">"+fecha+"</td>";
                    cadenaDatos=cadenaDatos+"<td><input type=\"hidden\" id=\"idEstudiante_"+posicion+"\" value=\""+respu.get(i).getIdEstudiante()+"\"><button type=\"button\" class=\"btn btn-warning\" onclick=\"editar("+posicion+");\"><i class=\"fa fa-pencil\"></i></button><button type=\"button\" class=\"btn btn-danger\" onclick=\"eliminar("+posicion+");\"><i class=\"fa fa-trash-o\"></i></button></td>";
                    cadenaDatos=cadenaDatos+"</tr>";

               }

            }
            }
              response.getWriter().write("//OK//"+cadenaDatos+"//");
                        
            }
    }
    @Override
    @SuppressWarnings("deprecation")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getParameter("action").equals("eliminar"))
        {
            RestEstudiante elRest=new RestEstudiante(); 
            String idEstudiante=request.getParameter("Elidestudiante");
            elRest.remove(idEstudiante);
            elRest.close();
              response.getWriter().write("//OK//Se ha eliminado registro//");
            
            
        }
        else if(request.getParameter("action").equals("guardar"))
        {
        
        
                try {



                    SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy");

                    if(request.getParameter("idEstudiante").isEmpty())
                    {
                        String[]rut=request.getParameter("rut").split("-");

                        Estudiante elestudiante=new Estudiante();
                        elestudiante.setNombre(request.getParameter("nombre"));
                        elestudiante.setApellidos(request.getParameter("apellidos"));
                        elestudiante.setRut(rut[0]);
                        elestudiante.setDigVer(rut[1]);
                        elestudiante.setFechaNac(format.parse(request.getParameter("fecha")));
                        RestEstudiante REstudiante=new RestEstudiante();
                        REstudiante.create_JSON(elestudiante);
                        REstudiante.close();
                                /*
                                 Deporte sport=new Deporte();

                                sport.setNombre();
                                sport.setCupos(8);
                                Date fIni=format.parse("11-02-2017");
                                Date fFn=format.parse("11-11-2017");
                                sport.setFechaIni(fIni);
                                sport.setFechaFin(fFn);
                                sport.setTotalClases(10);
                                DeporteRest elDep=new DeporteRest();
                                elDep.create_JSON(sport);
                                elDep.close();
                                */

                    }
                    else
                    {
                        String[]rut=request.getParameter("rut").split("-");

                        Estudiante elestudiante=new Estudiante();
                        elestudiante.setIdEstudiante(Integer.parseInt(request.getParameter("idEstudiante")));
                        elestudiante.setNombre(request.getParameter("nombre"));
                        elestudiante.setApellidos(request.getParameter("apellidos"));
                        elestudiante.setRut(rut[0]);
                        elestudiante.setDigVer(rut[1]);
                        elestudiante.setFechaNac(format.parse(request.getParameter("fecha")));
                        RestEstudiante REstudiante=new RestEstudiante();
                        REstudiante.edit_JSON(elestudiante,request.getParameter("idEstudiante"));
                        REstudiante.close();
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
        }     
             
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
